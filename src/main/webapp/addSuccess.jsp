<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${sessionScope.user.name}, 你成功添加了书籍</h1>
    <hr>
    书名: ${sessionScope.fbook.title} <br>
    价格: ${sessionScope.fbook.price} <br>
    <hr>
    <a href="home">返回主页</a>
</body>
</html>
