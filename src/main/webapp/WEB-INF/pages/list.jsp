<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2019/1/9
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bean {
            position: absolute;
            right: 0;
            margin-top: 50px;
            list-style: none;
        }

        .bean li {
            float: left;
            height: 30px;
            width: 30px;
            line-height: 30px;
            text-align: center;
            text-decoration: none;
        }

        .bean li a {
            text-decoration: none;
            color: #155fb4;
            display: block;
            width: 30px;
        }

        .bean .page {
            width: 80px;
            height: 30px;
        }
    </style>
</head>
<body>
<table>
    <form>
        <input type="text" name="username">
        <input type="submit" value="搜索">
    </form>
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.username}</td>
            <td>${list.password}</td>
            <td>${list.email}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<br>

<ul class="bean">
    <c:choose>
        <c:when test="${page.pages>0}">
            <c:choose>
                <c:when test="${page.isFirstPage}">
                    <li>首页</li>
                    <li>上一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="list.do?pageNum=${page.navigateFirstPage}${uname}">首页</a></li>
                    <li><a href="list.do?pageNum=${page.prePage}${uname}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach items="${page.navigatepageNums}" var="p">
                <c:choose>
                    <c:when test="${page.pageNum==p}">
                        <li>${p}</li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="list.do?pageNum=${p}${uname}">${p}</a></li>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

            <c:choose>
                <c:when test="${page.isLastPage}">
                    <li>下一页</li>
                    <li>尾页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="list.do?pageNum=${page.nextPage}${uname}">下一页</a></li>
                    <li><a href="list.do?pageNum=${page.navigateLastPage}${uname}">尾页</a></li>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

</ul>

${page}
<%--    <ul class="bean">
        <li><a href="#">首页</a></li>
        <li><a href="#">上一页</a></li>
        <li><a href="#">a</a></li>
        <li><a href="#">下一页</a></li>
        <li><a href="#">尾页</a></li>
    </ul>--%>
</body>
</html>
