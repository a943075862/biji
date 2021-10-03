<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/13
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>

<body>
  <button onclick="getJson()">获取user</button>
  <button onclick="sendJson()">发送user</button>

</body>
<script type="text/javascript">
    //客户端从服务端接收数据
    function getJson() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/json/getJson01",
            contentType:"application/json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }
    //客户端向服务端发送json数据，服务端返回新数据
    function sendJson() {
        var user = {};
        user.id=10001;
        user.username="张三";
        user.password="xiaosansan";
        user.registerTime=new Date();
        var jsonuser=JSON.stringify(user);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/json/getJson04",
            data:jsonuser,
            contentType:"application/json",
            dataType:"json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }

</script>
</html>
