<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2019/1/7
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="doUpdate.do" method="post">
        <input type="text" hidden="hidden" name="id" value="${user.id}">
        用户名：<input type="text" name="username" value="${user.username}" /><br>
        密码：<input type="password" name="password" value="${user.password}"/><br>
        邮箱：<input type="text" name="email" value="${user.email}"/><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
