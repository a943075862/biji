package com.qf.pojo;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */

/**
 * 员工实体类
 */
public class Employee {
    //用户id
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    //信息
    private String info;

    public Employee() {
    }

    public Employee(int id, String username, String password, String info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
