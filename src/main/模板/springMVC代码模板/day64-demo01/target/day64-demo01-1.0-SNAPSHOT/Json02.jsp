<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/14
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<button onclick="getJson()">获取user</button>
<button onclick="getJson2()">获取user2</button>
<button onclick="getJson3()">获取user3</button>
<button onclick="sendJson()">发送user</button>

</body>
<script>
    //客户端从服务端接收数据
    function getJson() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/json/getJson05",
            contentType:"application/json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }
    //客户端从服务端接收数据
    function getJson2() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/json/getJson07",
            contentType:"application/json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }
    //客户端从服务端接收数据
    function getJson3() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/json/getJson08",
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
            url:"${pageContext.request.contextPath}/json/getJson06",
            data:jsonuser,
            contentType:"application/json",
            dtaType:"json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }

</script>
</html>
