package com.qf.controller;

import com.qf.constant.MessageConstant;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.ResultVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  11:40
 */
@RestController
@RequestMapping("/user")
@Log4j2
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody User user){
        User user1 = userService.selectByUsername(user);

        try {
            if (user.getUserName().equals(user1.getUserName())&&user.getPassword().equals(user1.getPassword())){
                return ResultVO.ok("登录成功",user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error("服务器正忙");
        }
        return ResultVO.error("登录失败");
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody User user){
        System.out.println("user = " + user);
        try {
            log.info("{}",user);
            Integer insert = userService.insert(user);
            if (insert!=0){
                User user1 = userService.selectByUsername(user);
                return ResultVO.ok(MessageConstant.REGISTER_SUCCESS,user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error("服务器正忙");
        }
        return ResultVO.error(MessageConstant.REGISTER_ERROR);
    }

}
