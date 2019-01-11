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
        用户名：<input type="text" class="blur" id="username" name="username"><span id="message"></span>
        <br>
        密码：<input type="password" class="blur" id="password" name="password"><span id="pwd"></span><br>
        确认密码：<input type="password" class="blur" id="passwords" name="passwords"><br>
        邮箱：<input type="text" class="blur" id="email" name="email"><br>
        <button id="logIn" class="login" type="submit" name="signup" disabled="disabled">Sign Up</button>

    </form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        var username;
        var password;
        var passwords;
        var email;
        $(".blur").blur(function () {
            username = $("#username").val();
            password = $("#password").val();
            passwords = $("#passwords").val();
            email = $("#email").val();

            $.ajax({
                url:"doRegister.do",
                type:"post",
                data:{
                    "username":username,
                    "password":password,
                    "passwords":passwords,
                    "email":email
                },
                success:function (result) {
                    if (result=="OK"){
                        $("#message").text("该用户名可以注册");
                        $("#pwd").text("✔");
                        $("#logIn").attr("disabled",false);
                    }
                    if (result=="PwdNotOk"){
                        $("#message").text("该用户名可以注册");
                        $("#pwd").text("两次密码不一致");
                    }
                    if (result=="nameNotOK"){
                        $("#message").text("该用户名已存在，请登录或更换名称");
                    }
                }

            })
        });

        $("#logIn").click(function () {
            $.ajax({
                url:"regIt.do",
                type:"post",
                data:{
                    "username":username,
                    "password":password,
                    "passwords":passwords,
                    "email":email
                },
                success:function (data) {
                    if (data>0){
                        alert("注册成功");
                        window.location.href="http://localhost:8080/ssm01/login.do";
                    }
                }
            })
        });

    });
</script>

</body>
</html>
