<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${sessionScope.user.name} , 找到了你需要的书籍!</h1>
    <hr>
    <c:forEach items="${sessionScope.book.keySet()}" var="data">
        书名: ${data} <br>
        价格: ${sessionScope.book.get(data)} <br>
        <br><br>
    </c:forEach>
    <hr>
    <a href="home">返回主页</a>
    <%--<s:property value="book" />--%>
</body>
</html>
