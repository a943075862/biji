<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>emp-list</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container">

    <center><h1>员工列表页面</h1></center>

    <br/>
    <br/>
    <button type="button" class="btn btn-primary btn-lg" onclick="saveUI()">增加</button>
    <br/>
    <br/>

    <table class="table table-bordered">
        <tr align="center">
            <td>员工编号</td>
            <td>姓名</td>
            <td>薪资</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="emp" >
            <tr align="center">
                <td>${emp.id}</td>
                <td>${emp.empName}</td>
                <td>${emp.salary}</td>
                <td>${emp.department.deptName}</td>
                <td>
                    <a class="btn btn btn-primary btn-xs" href="javascript:void(0);" onclick="edit(${emp.id});" role="button">修改</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="btn btn btn-danger btn-xs" href="javascript:void(0);" onclick="del(${emp.id}, this);" role="button">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="10">
                总共 ${pageInfo.total} 条&nbsp;&nbsp;&nbsp;
                总共 ${pageInfo.pages} 页&nbsp;&nbsp;&nbsp;
                当前第${pageInfo.pageNum} 页&nbsp;&nbsp;&nbsp;
                <c:if test="${pageInfo.pageNum > 1}">
                    <a href="/employee/list">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/employee/list?pageNum=${pageInfo.pageNum-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${pageInfo.pageNum <= 1}">
                    <a href="javascript:void(0);">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0);">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>

                <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                    <a href="/employee/list?pageNum=${pageInfo.pageNum+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/employee/list?pageNum=${pageInfo.pages}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${pageInfo.pageNum >= pageInfo.pages}">
                    <a href="javascript:void(0);">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0);">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
            </td>
        </tr>
    </table>
</div>

</body>

<script>

    function edit(id) {
        location.href = "/employee/editUI/" + id;
    }

    function saveUI() {
        location.href = "/employee/saveUI";
    }

    function del(id, obj){
        if (confirm("确定要删除编号为" + id + "员工吗?")) {
            $.get('/employee/delete/' + id, null, function (result) {
                alert(result.message);
                if(result.success) {
                    $(obj).parent().parent().remove();
                }
            }, "json");
        }
    }

    $(function () {

    })
</script>
</html>