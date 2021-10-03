# Day 62 笔记

### 一、传值

### 1.1 作用域概述

* 在服务端有些对象可以存储数据、传递数据
  * request
  * cookie
  * session
  * applicationContext
* 我们更多使用request和session

### 1.2 Request

* 声明周期是一次请求
  * 发生在转发的情况数据依旧可以共享
  * 重定向的时候数据会失效

#### 服务端

```
package com.shine.controller;

import com.shine.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/req")
public class RequestController {

    /**
     * 传递数据--request--转发
     *  数据在转发过程中可以共享
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(HttpServletRequest request, User user){
        System.out.println("RequestController --- getData01---> show01.jsp");
        request.setAttribute("user",user);
        return "forward:/show01.jsp";
    }

    /**
     * 传递数据---request---重定向
     *  数据在重定向过程中不可以共享
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(HttpServletRequest request, User user){
        System.out.println("RequestController --- getData02---> show01.jsp");
        request.setAttribute("user",user);
        return "redirect:/show01.jsp";
    }

}
```

#### 客户端

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>id: ${requestScope.user.id}</p>
        <p>username: ${requestScope.user.username}</p>
        <p>password: ${requestScope.user.password}</p>
        <p>registerTime: ${requestScope.user.registerTime}</p>
    </body>
</html>
```

#### 请求链接

```
http://localhost:8080/Day62/req/getData01?id=110011&username=songjiang
```

### 1.3 Session

* Session可以传递数据
* 生命周期是一次会话

#### 服务端

```
@Controller
@RequestMapping("/session")
public class SessionController {

    /**
     * 传递数据---session--转发
     *  session在转发过程中数据可以共享
     *  session的生命周期是一次会话
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(HttpSession session, User user){
        System.out.println("SessionController === getData01 ---> show02.jsp");
        session.setAttribute("user",user);
        return "forward:/show02.jsp";
    }

    /**
     * 传递数据---session--重定向
     *  session在重定向过程中数据可以共享
     *  session的生命周期是一次会话
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(HttpSession session, User user){
        System.out.println("SessionController === getData02 ---> show02.jsp");
        session.setAttribute("user",user);
        return "redirect:/show02.jsp";
    }
}
```

#### 客户端

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>id: ${sessionScope.user.id}</p>
        <p>username: ${sessionScope.user.username}</p>
        <p>password: ${sessionScope.user.password}</p>
        <p>registerTime: ${sessionScope.user.registerTime}</p>
    </body>
</html>
```

### 1.4 Model

* springmvc框架中的一个api
* 可以存储数据传递数据
* 默认存储在request中
* 可以设置注解@SessionAttributes({"city"})存入session

#### 服务端

```
package com.shine.controller;

import com.shine.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/model")
@SessionAttributes({"city"})
public class ModelController {

    /**
     * Model数据模型，可以存取数据--转发
     *  默认会把数据也存入request域中
     *  可以使用注解：@SessionAttributes({"city"})把对应名称的数据存入session中
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(Model model, User user){
        System.out.println("ModelController === getData01 ===> show03.jsp");
        Model user1 = model.addAttribute("user", user);
        System.out.println(user1);
        return "forward:/show03.jsp";
    }

    /**
     * 重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(Model model, User user){
        System.out.println("ModelController === getData02 ===> show03.jsp");
        Model user1 = model.addAttribute("user", user);
        System.out.println(user1);
        return "redirect:/show03.jsp";
    }

    /**
     * 重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData03")
    public String getData03(Model model,User user,String city,String area){
        System.out.println("ModelController === getData03 ===> show04.jsp");

        model.addAttribute("user",user);
        model.addAttribute("city",city);
        model.addAttribute("area",area);

        return "forward:/show04.jsp";
    }

    /**
     * 重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData04")
    public String getData04(Model model,User user,String city,String area){
        System.out.println("ModelController === getData04 ===> show04.jsp");

        model.addAttribute("user",user);
        model.addAttribute("city",city);
        model.addAttribute("area",area);

        return "redirect:/show04.jsp";
    }
}
```

#### 客户端

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>id: ${requestScope.user.id}</p>
        <p>username: ${requestScope.user.username}</p>
        <p>password: ${requestScope.user.password}</p>
        <p>registerTime: ${requestScope.user.registerTime}</p>
        <p>city:${requestScope.city}</p>
        <p>area:${requestScope.area}</p>

        <hr>

        <p>id: ${sessionScope.user.id}</p>
        <p>username: ${sessionScope.user.username}</p>
        <p>password: ${sessionScope.user.password}</p>
        <p>registerTime: ${sessionScope.user.registerTime}</p>
        <p>city:${sessionScope.city}</p>
        <p>area:${sessionScope.area}</p>
    </body>
</html>
```

### 1.5 清空session中的数据

#### 服务端

```
    /**
     * 重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData05")
    public String getData05(){
        System.out.println("ModelController === getData05 ===> show04.jsp");
        return "redirect:/show04.jsp";
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/getData06")
    public String getData06(SessionStatus status){
        System.out.println("ModelController === getData06 ===> show04.jsp");
        // 清空session中SessionAttributes注解声明的数据
        status.setComplete();
        return "redirect:/show04.jsp";
    }
}
```

### 1.6 Cookie

* 客户端存储数据的对象

#### 服务端

```
@Controller
@RequestMapping("/cook")
public class CookieController {

    @RequestMapping("/getCookie01")
    public String getCookie01(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie01 = new Cookie("username","lisi");
        Cookie cookie02 = new Cookie("password","sili");

        response.addCookie(cookie01);
        response.addCookie(cookie02);

        return "forward:/show05.jsp";
    }

    @RequestMapping("/getCookie02")
    public String getCookie02(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "====" + cookie.getValue());
        }
        return "forward:/show05.jsp";
    }
}
```

#### 客户端

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h3>show05 haaha</h3>

        <%
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + "====" + cookie.getValue());
            }
        %>
    </body>
</html>
```

### 1.7 ModelAndView

* 模型和视图
  * 能存储数据
  * 能控制跳转

#### 服务端

```
@RequestMapping("/mav")
@Controller
@SessionAttributes({"city"})
public class MavController {

    @RequestMapping("/getData01")
    public ModelAndView getData01(User user,String city){
        ModelAndView modelAndView = new ModelAndView();

        // 设置数据
        modelAndView.addObject("user",user);
        modelAndView.addObject("city",city);

        // 设置视图
        modelAndView.setViewName("forward:/showmav.jsp");
        return modelAndView;
    }

    @RequestMapping("/getData02")
    public ModelAndView getData02(User user,String city){
        ModelAndView modelAndView = new ModelAndView();

        // 设置数据
        modelAndView.addObject("user",user);
        modelAndView.addObject("city",city);

        // 设置视图
        modelAndView.setViewName("redirect:/showmav.jsp");
        return modelAndView;
    }
}
```

#### 客户端

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>id: ${requestScope.user.id}</p>
        <p>username: ${requestScope.user.username}</p>
        <p>password: ${requestScope.user.password}</p>
        <p>registerTime: ${requestScope.user.registerTime}</p>
        <p>city:${requestScope.city}</p>

        <hr>

        <p>id: ${sessionScope.user.id}</p>
        <p>username: ${sessionScope.user.username}</p>
        <p>password: ${sessionScope.user.password}</p>
        <p>registerTime: ${sessionScope.user.registerTime}</p>
        <p>city:${sessionScope.city}</p>
    </body>
</html>
```

## 二、静态资源

### 2.1 概述

> 静态资源：html，js文件，css文件，图片文件

> 静态文件没有url-pattern,所以默认是访问不到的，之所以可以访问，是因为，tomcat中有一个全局的servlet：org.apache.catalina.servlets.DefaultServlet，它的url-pattern是 "/",是全局默认的Servlet.  所以每个项目中不能匹配的静态资源的请求，有这个Servlet来处理即可。

> 但，在SpringMVC中DispatcherServlet也采用了 “/” 作为url-pattern, 则项目中不会再使用全局的Serlvet，则静态资源不能完成访问。

### 2.2 解决方案01

* DispathcerServlet采用其他的url-pattern
* 此时，所有访问handler的路径都要以 action(或者do)结尾
* 每一个Handler被访问的时候都要以此结尾

```
    <!--  路径映射，设置/表示拦截所有请求  -->
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
```

### 2.3 解决方案02

* 在spring项目配置文件中添加如下配置

```
<!--
      额外的增加一个handler，且其requestMapping:  "/**" 可以匹配所有请求，但是优先级最低
      所以如果其他所有的handler都匹配不上，请求会转向 "/**" ,恰好，这个handler就是处理静态资源的
      处理方式：将请求转会到tomcat中名为default的Servlet
    -->
    <mvc:default-servlet-handler/>
```

### 2.4 解决方案03

* 采用请求路径映射资源路径的方式

```
    <!--  http://localhost:8080/Day62/hhhh/index.html  -->
<!--    <mvc:resources mapping="/hhhh/**" location="/html/"></mvc:resources>-->
<!--    <mvc:resources mapping="/cccc/**" location="/css/"></mvc:resources>-->
```

## 三、Json处理

### 3.1 概述

* 为什么学习json处理
  * 客户端和服务端数据传输的格式就是json
* fastjson（国产）
* jackson（框架默认）

### 3.2 添加依赖

```
<!-- Jackson springMVC默认的Json解决方案选择是 Jackson，所以只需要导入jackson的jar，即可使用。-->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

### 3.3 客户端接收json

#### 服务端

```
    @RequestMapping("/getJson01")
    @ResponseBody
    public User getJson01() {
        User user = new User(10011,"李逵","xiaokuikui",new Date());
        return user;
    }


    @RequestMapping(value = "/getJson02",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJson02(){
        User user = new User(10011,"李逵","xiaokuikui",new Date());
        return "静夜思";   // /静夜思.jsp
    }
```

#### 客户端

```
        // 接送服务端发来的json数据
        function getJson() {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/json/getJson01",
                contentType:"application/json",
                success:function (ret) {
                    console.log(ret);
                }
            })
        }
```

### 3.4 客户端发送json数据

#### 客户端

```
        // 客户端向服务端发送json数据
        function sendJson() {
            var user = {id:100111,username:"李逵",password:"xiaokui",registerTime:Date};
            var jsonUser = JSON.stringify(user);
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/json/getJson04",
                data:jsonUser,
                contentType:"application/json",
                dataType:"json",
                success:function (ret) {
                    console.log(ret);
                }
            })
        }
```

#### 服务端

```
    @RequestMapping(value = "/getJson04")
    @ResponseBody
    public User getJson04(@RequestBody User user){
        user.setPassword("laokui");
        return user;   // /静夜思.jsp
    }
```

### 3.5 @RestController

* 注解
  * 包含@Controller
  * 包含@ResponseBody

```
@RequestMapping("/json02")
@RestController
public class JsonController02 {
    /**
     * {key:value,key:value}
     * [
     *  {},
     *  {},
     *  {}
     * ]
     *
     * Fastjson     阿里巴巴
     * Jackson      springMVC默认使用
     */

    @RequestMapping("/getJson01")
    public User getJson01() {
        User user = new User(10011,"李逵","xiaokuikui",new Date());
        return user;
    }


    @RequestMapping(value = "/getJson02",produces = "text/html;charset=utf-8")
    public String getJson02(){
        User user = new User(10011,"李逵","xiaokuikui",new Date());
        return "静夜思";   // /静夜思.jsp
    }

    @RequestMapping(value = "/getJson03",produces = "text/html;charset=utf-8")
    public String getJson03(){
        User user = new User(10011,"李逵","xiaokuikui",new Date());
        return "静夜思";   // /静夜思.jsp
    }

    @RequestMapping(value = "/getJson04")
    public User getJson04(@RequestBody User user){
        user.setPassword("laokui");
        return user;   // /静夜思.jsp
    }
}
```

