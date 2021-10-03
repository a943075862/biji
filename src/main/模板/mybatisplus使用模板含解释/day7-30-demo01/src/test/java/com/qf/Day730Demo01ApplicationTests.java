package com.qf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qf.mapper.IUserMapper;
import com.qf.pojo.User;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Day730Demo01ApplicationTests {
    @Autowired
    private IUserMapper iUserMapper;

    /**
     * 查询所有的用户
     */
    @Test
    public void test01() {
        List<User> users = iUserMapper.selectList(null);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 通过id查询用户
     */
    @Test
    public void test02() {
        User user = iUserMapper.selectById(1);
        System.out.println("user = " + user);
    }

    /**
     * 添加用户信息
     *      当不使用主键注解时自动添加的id为很长一串值
     *          使用主键注解后 id会按照数据库的自增添加值
     */
    @Test
    public void test03(){
        User user = new User();
        user.setAge(11).setName("李四").setUserName("lisi").setPassword("sili").setEmail("xxx@xx.xxx");
        int row = iUserMapper.insert(user);
        System.out.println("row = " + row);
    }

    /**
     * 通过id删除
     *      id为序列号后的id
     */
    @Test
    public void test04(){
        int row = iUserMapper.deleteById(1421065285007425538L);
        System.out.println("row = " + row);
    }

    /**
     * 通过wrapper删除用户
     *      ge是>=
     *      eq对应=
     *      in对应为in 也就是= 或数组集合
     *      gt对应的是>
     */
    @Test
    public void test05(){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
//        wrapper.ge("user_name","lisi1");
//        wrapper.in("user_name","lisi");
//        wrapper.select("user_name","lisi");
//        wrapper.eq("user_name","lisi");
//        wrapper.in("user_name","lisi");
        wrapper.gt("user_name","lisi");
        int row = iUserMapper.delete(wrapper);
        System.out.println("row = " + row);
    }

    /**
     * 通过map删除用户
     *      先new一个hashmap
     *          key设置为列名
     *          value为需要删除的值
     */
    @Test
    public void test06(){
        Map<String,Object> list = new HashMap<>();
        list.put("user_name","zhangsan");
        int row = iUserMapper.deleteByMap(list);
        System.out.println("row = " + row);
    }

    /**
     * 通过id集合删除
     *     创建集合用arrays.tolist（参数集合）
     *          将集合放入删除方法
     *              进行删除
     */
    @Test
    public void test07(){
        int row = iUserMapper.deleteBatchIds(Arrays.asList("6", "7", "8"));
        System.out.println("row = " + row);
    }

    /**
     * 通过id修改对象
     *      创建user对象赋值
     *          传对象进修改方法
     */
    @Test
    public void test08(){
        User user = new User();
        user.setId(10L).setUserName("zhangsan");
        int row = iUserMapper.updateById(user);
        System.out.println("row = " + row);
    }

    /**
     * 通过wrapper查询需要修改的对象
     *      wrapper中为查询的对象
     *          user为修改后的对象
     *  user        实体对象 (set 条件值,可以为 null)
     *  wrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    @Test
    public void test09(){
        UpdateWrapper<User> wrapper =new UpdateWrapper<>();
        wrapper.eq("user_name","zhangsan");
        User user = new User();
        user.setName("wukaihe");
        int row = iUserMapper.update(user, wrapper);
        System.out.println("row = " + row);
    }




}
