<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2019/1/7
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="doInsert.do" method="post">
        用户名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password"/><br>
        邮箱：<input type="text" name="email"/><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
