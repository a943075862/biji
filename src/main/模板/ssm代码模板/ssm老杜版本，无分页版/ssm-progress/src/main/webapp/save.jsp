<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/17
  Time: 7:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div class="row">
    <div class="col-md-12" style="text-align: center;"> <h3 align="center">增加用户</h3></div>
</div>
<div class="row">
    <br>
</div>
<div class="row">
    <form action="${pageContext.request.contextPath}/hero/save" method="post" >
        <div class="row">
            <div class="col-md-4"> </div>
            <div class="col-md-4">
                姓名：
                <input type="text" class="form-control" name="name" placeholder="请输入姓名" >
            </div>
        </div>
        <div class="row"><br> </div>
        <div class="row">
            <div class="col-md-4"> </div>
            <div class="col-md-4">
                武力值：
                <input type="text" class="form-control" name="forceValue" placeholder="请输入武力值" >
            </div>
        </div>
        <div class="row"><br> </div>
        <div class="row">
            <div class="col-md-4"> </div>
            <div class="col-md-4">
                地址：
                <input type="text" class="form-control" name="addr" placeholder="请输入地址">
            </div>
        </div>
        <div class="row"> <br></div>
        <div class="row">
            <div class="col-md-4"> </div>
            <div class="col-md-4">
                信息：
                <input type="text" class="form-control" name="info"placeholder="请输入信息">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"> </div>
            <div class="col-md-4" style="text-align: center">
                <button type="submit" class="btn btn-primary btn-lg btn-block" >提交</button>
            </div>
        </div>

    </form>
</div>
