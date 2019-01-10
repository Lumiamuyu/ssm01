<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2019/1/10
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <form action="doRegister.do" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        确认密码：<input type="password" name="passwords"><br>
        邮箱：<input type="text" name="email"><br>
        <input type="submit" value="确认">
    </form>


</body>
</html>
