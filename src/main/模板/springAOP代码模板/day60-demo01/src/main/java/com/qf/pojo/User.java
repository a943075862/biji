package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    @PostConstruct
    public void init(){
//        System.out.println("user....init");
    }
    @PreDestroy
    public void destory(){
//        System.out.println("user....destory");
    }

/*
    public User() {
//        System.out.println("user...Cons");
    }

    public User(Integer id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
//        System.out.println("user...setusername");
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void init(){
//        System.out.println("user....init");
    }
    public void destory(){
//        System.out.println("user....destory");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }*/
}
