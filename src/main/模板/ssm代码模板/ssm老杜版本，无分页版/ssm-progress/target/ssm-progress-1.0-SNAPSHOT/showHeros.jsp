<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/16
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>展示</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4" style="text-align: center"><h1 style="text-align: center" >英雄榜</h1></div>
    <div class="col-md-4"></div>
</div>
<div class="row">
    <div class="col-md-3" style="text-align: right">
        <button type="button" class="btn btn-primary" onclick="saveHero()" style="text-align: center">增加</button>
    </div>

</div>
<div class="container">
    <table border="1px" class="table table-hover">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>武力值</th>
            <th>地址</th>
            <th>信息</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${heros}" var="hero">
            <tr id="${hero.id}">
                <td>${hero.id}</td>
                <td>${hero.name}</td>
                <td>${hero.forceValue}</td>
                <td>${hero.addr}</td>
                <td>${hero.info}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="updateHero(${hero.id})">修改</button>
                    <button type="button" class="btn btn-danger" onclick="delHero(${hero.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
<script type="text/javascript">
    function delHero(id) {
        var ret = confirm("确认删除吗？")
        if (ret){
        $.ajax({
            type:"delete",
            url:"${pageContext.request.contextPath}/hero/heros/"+id,
            contentType:"application/json",
            success:function (ret) {
                if (ret=="success") {
                    $("#"+id).remove();
                    alert("删除成功")
                }else {
                    alert("删除失败")
                }
            }
        })
        }else {
            alert("取消操作")
        }
    }

    function updateHero(id) {
        location.href ="${pageContext.request.contextPath}/hero/showById/"+id;
    }

    function saveHero() {
        location.href="${pageContext.request.contextPath}/save.jsp"
    }

</script>

