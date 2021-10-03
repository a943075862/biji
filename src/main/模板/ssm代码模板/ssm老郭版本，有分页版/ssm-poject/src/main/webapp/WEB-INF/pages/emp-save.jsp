<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>emp-save</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container">

    <center><h1>员工增加页面</h1></center>

    <br/>
    <br/>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/employee/save" method="post">
        <div class="form-group">
            <div class="col-sm-2"></div>
            <label for="inputEmpName" class="col-sm-2 control-label">员工姓名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputEmpName" name="empName" placeholder="员工姓名">
            </div>
            <div class="col-sm-2"></div>
        </div>
        <div class="form-group">
            <div class="col-sm-2"></div>
            <label for="inputSalary" class="col-sm-2 control-label">薪资</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="inputSalary" name="salary" placeholder="薪资">
            </div>
            <div class="col-sm-2"></div>
        </div>
        <div class="form-group">
            <div class="col-sm-2"></div>
            <label class="col-sm-2 control-label">部门</label>
            <div class="col-sm-6">
                <select class="form-control" name="deptId">
                    <option selected value="0">--请选择--</option>
                    <c:forEach items="${depts}" var="dept">
                        <option value="${dept.id}">${dept.deptName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-2"></div>
        </div>
        <div class="form-group">
            <div class="col-sm-6"></div>
            <div class="col-sm-offset-2 col-sm-4">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>

</body>

<script>

</script>
</html>