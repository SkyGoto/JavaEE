<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/27/18
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>浏览书籍</title>
</head>
<body>

<table border="1" width="700">
    <tr>
        <td>书号</td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${book}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td><a href="">修改</a> <a href="">删除</a></td>
        </tr>
    </c:forEach>

</table >
<a href="home">返回主页</a><br>
<s:debug />
</body>
</html>
