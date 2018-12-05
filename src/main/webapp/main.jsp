<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>图书管理系统</h1>
    <h5>当前用户: ${user.name}&nbsp;(${user.role} )[<a href="logout">注销</a>]</h5>
    <hr>
    <c:if test="${user.role == '管理员'}">
        <a href="addUser.jsp">添加用户</a><br>
        <%--<a href="findBook.jsp">2. 查询图书</a><br>--%>
        <a href="listUser">管理用户</a><br>
        <a href="addBook.jsp">添加图书</a><br>
        <%--<a href="findBook.jsp">2. 查询图书</a><br>--%>
        <a href="listBook">管理图书</a><br>
    </c:if>
    <c:if test="${user.role == '读者'}">
        <a href="lendBook">借阅图书</a><br>
        <%--<a href="findBook.jsp">2. 查询图书</a><br>--%>
        <a href="seeLendBook">已借图书</a><br>
    </c:if>


</body>
<s:debug />
</html>
