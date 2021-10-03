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
<button onclick="getFastJson()">fastjson获取user</button>
</body>
<script>
    //客户端从服务端接收数据
    function getFastJson() {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/json03/getJson01",
            contentType:"application/json",
            dataType:"json",
            success:function (ret) {
                console.log(ret);
            }
        });
    }


</script>
</html>
