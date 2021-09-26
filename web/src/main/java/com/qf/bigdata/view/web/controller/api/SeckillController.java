package com.qf.bigdata.view.web.controller.api;

import com.qf.data.view.core.model.common.CommonMethod;
import com.qf.data.view.core.model.entity.Account;
import com.qf.data.view.core.model.entity.Product;
import com.qf.data.view.core.model.result.ResultModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class SeckillController {

    /*@Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;*/

    @Autowired
    private StringRedisTemplate redisTemplate;


    //商品售完标记map，多线程操作不能用HashMap
    private static ConcurrentHashMap<String, Boolean> productSoldOutMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, Boolean> getProductSoldOutMap() {
        return productSoldOutMap;
    }


    /**
     * 秒杀抢购
     * @param productId
     * @param token 秒杀接口访问令牌
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{token}/confirm", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel miaosha(String productId, @PathVariable("token")String token) throws Exception{
        if(StringUtils.isEmpty(productId) || StringUtils.isEmpty(token)){
            return ResultModel.error("商品id或访问地址参数为空");
        }
        Account account = getLoginAccount();
        if(account==null){
            return ResultModel.error("必须登录才能参与秒杀");
        }

        //验证用户token
        boolean check = checkToken(null, productId, token);
        if(!check){
            return ResultModel.error("非法请求");
        }

        //用内存里的商品库存校验可以大大提高性能，相比用redis里的库存来判断减少了与redis的交互次数
        if (productSoldOutMap.get(productId) != null) {
            return ResultModel.error("商品已抢完");
        }

        //查询生成订单的缓存
        if (redisTemplate.opsForValue().get(CommonMethod.getMiaoshaOrderRedisKey(account.getAccount(), productId)) != null) {
            return ResultModel.error("用户已经参与过该商品的秒杀活动，不能重复参与");
        }

        //用redis原子操作判断排队标记
        if (redisTemplate.opsForValue().increment(CommonMethod.getMiaoshaOrderWaitFlagRedisKey(account.getAccount(), productId)) > 1) {
            return ResultModel.error("排队中，请耐心等待");
        }
        //设置排队标记的超时时间，根据业务情况决定
        redisTemplate.expire(CommonMethod.getMiaoshaOrderWaitFlagRedisKey(account.getAccount(), productId), 60, TimeUnit.SECONDS);

       /* Address defaultAddress = getUserDefaultAddress(account);
        if (defaultAddress == null) {
            return ReturnMessage.error("必须先填写用户默认收货地址才能参与秒杀");
        }*/

        //预减库存
        if (!preDeductCache(productId)) {
            return ResultModel.error("商品已抢完");
        }

        Product productParam = new Product();
        productParam.setId(productId);
        /*Product product = productService.selectOne(productParam);
        if(product==null){
            return ResultModel.error("商品不存在");
        }*/

        /*ResultModel validResult = validMiaoshaTime(product);
        if (!validResult.isSuccess()) {
            return validResult;
        }*/


        return confirmOrder(productParam, account);
    }


    //测试所用，实际为用户账号信息
    private Account getLoginAccount() {
        Account account = new Account();
        account.setAccount((long)Math.random()*100000);
        return account;
    }




    /**
     * 提交订单
     */
    private ResultModel confirmOrder(Product product, Account account){
        /*//填充订单信息
        Order order = setOrderInfo(product, account);
        //填充订单配送信息
        Ordership ordership = setOrdershipInfo(address, order);
        order.setOrdership(ordership);
        //创建秒杀订单并插入到数据库
        Order orderData = null;
        try {
            orderData = orderService.createMiaoshaOrder(order);
        } catch (Exception e) {
            logger.error("创建订单失败", e);
            //还原缓存里的库存并清除内存里的商品售完标记
            RedisUtil.incr(RedisKeyPrefix.PRODUCT_STOCK + "_" + product.getId());
            if (productSoldOutMap.get(product.getId()) != null) {
                productSoldOutMap.remove(product.getId());
            }
            return ReturnMessage.error("创建订单失败：" + e.getMessage());
        }

        //return ReturnMessage.success(orderData);
        //返回0代表排队中
        return ReturnMessage.success(0);*/


        return null;
    }

    /**
     * @param productId
     * @return 秒杀成功返回"orderId"，秒杀失败返回"-1"，秒杀排队进行中返回"0"
     */
    @RequestMapping(value="result", method=RequestMethod.GET)
    @ResponseBody
    public ResultModel miaoshaResult(String productId) {
        Account account = getLoginAccount();
        if(account==null){
            return ResultModel.error("必须登录才能参与秒杀");
        }

        //判断redis里的排队标记
        if (redisTemplate.opsForValue().get(CommonMethod.getMiaoshaOrderWaitFlagRedisKey(account.getAccount(), productId)) != null) {
            //返回0代表排队中
            return ResultModel.success(0);
        }

        if(redisTemplate.opsForValue().get(CommonMethod.getMiaoshaOrderRedisKey(account.getAccount(), productId) )!= null) {//秒杀成功
            return ResultModel.success(1);
        }

        //返回-1代表秒杀失败
        return ResultModel.success(-1);
    }

    /**
     * 获取秒杀接口的令牌
     * @param productId
     * @param verifyCode
     * @return
     */
    @RequestMapping(value="token", method=RequestMethod.GET)
    @ResponseBody
    public ResultModel getMiaoshaToken(HttpServletRequest request, String productId, String verifyCode) {
        //用redis限流，限制接口1分钟最多访问10000次
        Long requestNum = redisTemplate.opsForValue().increment(request.getRequestURI().toString());
        if (requestNum == 1) {
            redisTemplate.expire(request.getRequestURL().toString(), 60,TimeUnit.SECONDS);
        } else if (requestNum > 10000) {
            return ResultModel.error("访问超载，请稍后再试");
        }

        Account account = getLoginAccount();
        if(account==null){
            return ResultModel.error("必须登录才能参与秒杀");
        }
        //校验验证码，防止接口被刷
        boolean check = checkVerifyCode(account, productId, verifyCode);
        if(!check) {
            return ResultModel.error("验证码错误");
        }
        String token = createMiaoshaToken(account, productId);
        return ResultModel.success(token);
    }

    /**
     * 校验验证码
     * @param account
     * @param productId
     * @param verifyCode
     * @return
     */
    private boolean checkVerifyCode(Account account, String productId, String verifyCode) {
        if(account == null || StringUtils.isEmpty(verifyCode)) {
            return false;
        }
        String verifyCodeRedisKey = CommonMethod.getMiaoshaVerifyCodeRedisKey(account.getAccount(), productId);
        String realCode = redisTemplate.opsForValue().get(verifyCodeRedisKey);
        if(StringUtils.isEmpty(realCode) || !verifyCode.equals(realCode)) {
            return false;
        }
        redisTemplate.delete(verifyCodeRedisKey);
        return true;
    }

    /**
     * 创建秒杀接口令牌
     * @param account
     * @param productId
     * @return
     */
    private String createMiaoshaToken(Account account, String productId) {
        if(account == null) {
            return null;
        }
        String token = MD5Encoder.encode(UUID.randomUUID().toString().getBytes());
        redisTemplate.opsForValue().set(CommonMethod.getMiaoshaTokenRedisKey(account.getAccount(), productId), token, 60,TimeUnit.SECONDS);
        return token;
    }

    /**
     * 验证令牌的有效性
     * @param account
     * @param productId
     * @param token
     * @return
     */
    private boolean checkToken(Account account, String productId, String token) {
        if(account == null || token == null) {
            return false;
        }
        String realToken = redisTemplate.opsForValue().get(CommonMethod.getMiaoshaTokenRedisKey(account.getAccount(), productId));
        boolean result = token.equals(realToken);
        //验证完token需要立即销毁
        redisTemplate.delete(CommonMethod.getMiaoshaTokenRedisKey(account.getAccount(), productId));
        return result;
    }


    /**
     * 获取验证码图片
     * @param response
     * @param productId
     * @return
     */
    @RequestMapping(value="verifyCode", method=RequestMethod.GET)
    @ResponseBody
    public ReturnMessage getMiaoshaVerifyCod(HttpServletResponse response, String productId) {
        Account account = getLoginAccount();
        if(account==null){
            return ReturnMessage.error("必须登录才能参与秒杀");
        }
        try {
            BufferedImage image  = createVerifyCode(account, productId);
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
            out.flush();
            out.close();
            return null;
        }catch(Exception e) {
            e.printStackTrace();
            return ReturnMessage.error("秒杀失败");
        }
    }

    /**
     * 校验商品的秒杀时间
     * @param product
     * @return
     * @throws ParseException
     */
    private ReturnMessage validMiaoshaTime(Product product) throws ParseException {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(product.getMiaoshaStartTime()));
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(product.getMiaoshaEndTime()));
        long startAt = calendarStart.getTimeInMillis();
        long endAt = calendarEnd.getTimeInMillis();
        long now = System.currentTimeMillis();
        if(now < startAt ) {//秒杀还没开始
            return ReturnMessage.error("秒杀还没开始");
        }else  if(now > endAt){//秒杀已经结束
            return ReturnMessage.error("秒杀已经结束");
        }
        return ReturnMessage.success();
    }

    /**
     * 预减库存的缓存
     * @param productId
     * @return
     */
    private boolean preDeductCache(String productId) {
        //用redie的原子操作减库存，防止并发操作
        Long stock = redisTemplate.opsForValue().decrement("miaosha:stock:" + productId);
        if (stock == null || stock < 0) {
            //还原缓存里的库存
            redisTemplate.opsForValue().increment("miaosha:stock:" + productId);
            //写商品已售完的内存标记
            productSoldOutMap.put(productId, true);
            return false;
        }
        return true;
    }





    /**
     * 创建验证码
     * @param account
     * @param productId
     * @return
     */
    private BufferedImage createVerifyCode(Account account, String productId) {
        if(account == null) {
            return null;
        }
        int width = 80;
        int height = 32;
        //create the image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // set the background color
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        // draw the border
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);
        // create a random instance to generate the codes
        Random rdm = new Random();
        // make some confusion
        for (int i = 0; i < 50; i++) {
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        // generate a random code
        String verifyCode = generateVerifyCode(rdm);
        g.setColor(new Color(0, 100, 0));
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(verifyCode, 8, 24);
        g.dispose();
        //把验证码存到redis中
        Integer result = calc(verifyCode);
        if (result == null) {
            return null;
        }
        String verifyCodeRedisKey = CommonMethod.getMiaoshaVerifyCodeRedisKey(account.getId(), productId);
        RedisUtil.set(verifyCodeRedisKey, result.toString(), 300);
        //输出图片
        return image;
    }

    private static Integer calc(String exp) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            return (Integer)engine.eval(exp);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static char[] ops = new char[] {'+', '-', '*'};
    /**
     * + - *
     * */
    private String generateVerifyCode(Random rdm) {
        int num1 = rdm.nextInt(10);
        int num2 = rdm.nextInt(10);
        int num3 = rdm.nextInt(10);
        char op1 = ops[rdm.nextInt(3)];
        char op2 = ops[rdm.nextInt(3)];
        String exp = ""+ num1 + op1 + num2 + op2 + num3;
        return exp;
    }

   /* @Override
    public void afterPropertiesSet() throws Exception {
        //初始化加载所有秒杀商品的库存到redis
        Product productParam = new Product();
        productParam.setSpecial(ProductType.PRODUCT_MIAOSHA);
        List<Product> products = productService.selectList(productParam);
        for (Product product : products) {
            RedisUtil.set(RedisKeyPrefix.PRODUCT_STOCK + "_" + product.getId(), String.valueOf(product.getStock()));
        }
    }*/





}
