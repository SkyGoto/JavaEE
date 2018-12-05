<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:fielderror/>
<form action="find" method="post">
    书名: <input type="text" name="book.title"> <br>
    <input type="submit" value="查询">
    <input type="reset" value="重置">
</form>
</body>
</html>
