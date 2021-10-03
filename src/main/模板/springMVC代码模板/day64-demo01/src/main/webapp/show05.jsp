<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/13
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>hahah</h3>

    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            out.println(cookie.getName()+"+++"+cookie.getValue());
        }
    %>
</body>

</html>
