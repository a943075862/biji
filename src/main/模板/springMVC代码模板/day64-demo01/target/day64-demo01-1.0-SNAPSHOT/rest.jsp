<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/15
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
    <button type="button"  onclick="getAllUser()">获取所有用户</button>
    <button type="button"  onclick="getUserById()">通过id获取用户</button>
    <input type="hidden" id="ipt01" value="1">

</body>
</html>
<script type="text/javascript">

    function getAllUser() {
        $.ajax({ url:"${pageContext.request.contextPath}/rest/users",
            type:'get',
            contentType:"application/json",//声明请求参数类型为json
            success:function (ret) {
                console.log(ret)
            }
            })
    }
    function getUserById() {

        var id = $("#ipt01").val()
        $.ajax({ url:"${pageContext.request.contextPath}/rest/users/"+id,
            type:'get',
            contentType:"application/json",//声明请求参数类型为json
            success:function (ret) {
                console.log(ret)
                var oldtime= ret.registerTime
                var newtime = new Date(oldtime)
                alert("id="+ret.id+" username="+ret.username+" password="+ret.password+" registerTime="+newtime)
            }
        })
    }


</script>
