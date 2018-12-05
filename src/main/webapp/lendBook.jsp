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
    <script  language="javascript">
        function doDelete(isbn){
             var flag = confirm("是否确定借此书?");
             if (flag) {
                 window.location.assign("toLendBook?book.isbn="+isbn);
             }
        }
        function doreaddate(isbn){
            window.location.assign("readbookintro?book.isbn="+isbn);
        }
    </script>
</head>
<body>
<h1>图书查询</h1>
<form action="findLengBook" method="post">
    搜索条件: <input type="text" name="book.title"><input type="submit" value="查询">
</form>
<%--${bookss}--%>
<%--\model.Book@185eb225--%>
<%--<s:property value="books"/>--%>
<hr>
<s:actionmessage/>
<s:property value="message" />
<table border="1" width="700">
    <tr>
        <td>书号</td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <s:iterator var="book" value="#session.lendBook">
    <tr>
        <td><s:property value="#book.isbn"/> </td>
        <td><s:property value="#book.title"/></td>
        <td><s:property value="#book.author.name"/></td>
        <td><s:property value="#book.price"/></td>
        <td><div style="display: inline-block" onclick="doreaddate('<s:property value="#book.isbn"/>')">简介</div>&nbsp;
            <div style="display: inline-block" onclick="doDelete('<s:property value="#book.isbn"/>')">借书</div></td>
    </tr>
    </s:iterator>
    <%--<c:forEach items="${book}" var="book">--%>
        <%--<tr>--%>
            <%--<td>${book.isbn}</td>--%>
            <%--<td>${book.title}</td>--%>
            <%--<td>${book.author}</td>--%>
            <%--<td>${book.price}</td>--%>
            <%--<td><a href="">修改</a> <a href="">删除</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

</table >
<a href="listBook">查看全部</a>  <a href="home">返回主页</a><br>
<s:debug />
</body>
</html>
