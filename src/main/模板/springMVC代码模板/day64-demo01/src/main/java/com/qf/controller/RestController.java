package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

/**
 * restful风格代码
 */
@RequestMapping("/rest")
@Controller
@CrossOrigin(origins = {"http://localhost:8899"})
public class RestController {
    /**
     * 查询所有用户
     *      返回用户集合
     * @return
     */
    @GetMapping("/users")
    @ResponseBody
    public List<User> queryUsers(){
        System.out.println("查询所有用户");
        User user1 = new User(1001,"zhangsan","sanzhang",new Date());
        User user2 = new User(1002,"lisi","sili",new Date());
       List<User> users = Arrays.asList(user1,user2);
        return users;
    }

    /**
     * 查询单个用户
     *      返回一个用户对象
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    @ResponseBody        //@pathvariable接收url路径中的值
    public User queryOneUser(@PathVariable Integer id){
        System.out.println("id = " + id);
        System.out.println("查询单个用户");
        String oldtime= "1995/05/24 12:00:21";
        Date newDate = new Date(oldtime);
        Date date = new Date();

        User user1 = new User(1001,"zhangsan","sanzhang",newDate);
        System.out.println("user1 = " + user1);
        return user1;
    }

    /**
     * 修改用户信息
     *      返回状态码1
     * @param user
     * @return
     */
    @PutMapping("/users")
    @ResponseBody
    public String updateUser(@RequestBody User user){
        System.out.println("修改用户");
        User user1 = new User(1001,"zhangsan","sanzhang",new Date());
        return "{status:1}";
    }

    /**
     * 增加用户
     *      返回状态吗1
     * @param user
     * @return
     */
    @PostMapping ("/users")
    @ResponseBody
    public User insertUser(@RequestBody User user){
        System.out.println("增加用户");
        User user1 = new User(1001,"zhangsan","sanzhang",new Date());

        return user1;
    }

    /**
     *  删除一个用户
     *      返回状态码1
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    @ResponseBody       //@pathvariable接收路径中的值
    public String deleteUser(@PathVariable Integer id){
        System.out.println("删除单个用户");
        User user1 = new User(1001,"zhangsan","sanzhang",new Date());
        return "{status:1}";
    }

}
