package com.qf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.mapper.IUserMapper;
import com.qf.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class SelectDay730Demo01ApplicationTests02 {
    @Autowired
    private IUserMapper iUserMapper;

    /**
     * 通过ID查询用户对象
     * id 主键ID列表(不能为 null 以及 empty)
     */
    @Test
    public void test01(){
        User user = iUserMapper.selectById(1);
        System.out.println("user = " + user);
    }

    /**
     * 通过使用querywrapper来指定查询条件
     *      查询结果返回一个集合
     *      wrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void test02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        List<User> users = iUserMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 通过id集合查询集合中所有的id集合
     *      idList 主键ID列表(不能为 null 以及 empty)
     */
    @Test
    public void test03(){
        List<User> users = iUserMapper.selectBatchIds(Arrays.asList("1", "2", "3", "4", "5"));
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 通过map类的键值对来指定查询内容
     *      key为列名或属性名
     *      value为查询的值
     *       columnMap 表字段 map 对象
     */
    @Test
    public void test04(){
        HashMap<String, Object> lists = new HashMap<>();
        lists.put("user_name","zhangsan");
        List<User> users = iUserMapper.selectByMap(lists);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 通过querywrapper查询指定条件的内容
     *      通过selectcount输出查询条件记录的总个数
     *      queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void test05(){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        Integer count = iUserMapper.selectCount(wrapper);
        System.out.println("count = " + count);
    }

    /**
     * 通过指定条件查询
     *      返回一个对象
     *      实体对象封装操作类（可以为 null）
     */
    @Test
    public void test06(){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","lisi1");
        User user = iUserMapper.selectOne(wrapper);
        System.out.println("user = " + user);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     *     wrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void test07(){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        List<Map<String, Object>> maps = iUserMapper.selectMaps(wrapper);
        for (Map<String, Object> map : maps) {
            System.out.println("map = " + map);
        }
    }
    @Test
    public void test08(){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        List<Object> objects = iUserMapper.selectObjs(wrapper);
        for (Object object : objects) {
            User user = (User) object;
            System.out.println("user = " + user);
        }
    }

    /**
     * 查询用户分页显示
     *  先new一个page对象    对象ipage
     *      创建查询条件wrapper
     *          再通过方法查询分页
     */
    @Test
    public void test09(){
        IPage<User> page =new Page<>();
        //设置每页显示数量
        page.setSize(5);
        //设置显示第几页
        page.setCurrent(2);
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        IPage<User> page1 = iUserMapper.selectPage(page, wrapper);
        //第几页
        System.out.println(page1.getRecords());
        //总条数
        System.out.println(page1.getTotal());
        //总页数
        System.out.println(page1.getPages());
    }

    /**
     * 查询分页显示
     *      最后结果以键值对形式输出
     */
    @Test
    public void test10(){
        IPage<User> page =new Page<>();
        //设置每页显示数量
        page.setSize(5);
        //设置显示第几页
        page.setCurrent(2);
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("user_name","zhangsan");
        IPage<Map<String, Object>> mapIPage = iUserMapper.selectMapsPage(page, wrapper);
        List<Map<String, Object>> records = mapIPage.getRecords();
        for (Map<String, Object> record : records) {
            System.out.println("record = " + record);
        }
    }
    


}
