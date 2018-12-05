<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 10/21/18
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简介</title>
</head>
<body>
<h1><s:property value="book.title"/></h1>
<hr>
<h5><s:property value="book.author.name"/></h5>
<hr>
<h3><s:property value="bookIntroContent"/></h3>
<a href="listBook">返回</a>
</body>
</html>
