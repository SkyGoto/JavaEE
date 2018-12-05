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
             var flag = confirm("删除后无法恢复是否确定?");
             if (flag) {
                 window.location.assign("deleteUser?user.name="+isbn);
             }
        }
        function doUpdate(isbn){
            window.location.assign("editUser?user.name="+isbn);
        }
    </script>
</head>
<body>
<h1>查询</h1>
<form action="findUser" method="post">
    搜索条件: <input type="text" name="user.name"><input type="submit" value="查询">
</form>
<%--${bookss}--%>
<%--\model.Book@185eb225--%>
<%--<s:property value="books"/>--%>
<hr>
<s:actionmessage/>
<table border="1" width="700">
    <tr>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户角色</td>
        <td>操作/td>
    </tr>
    <s:iterator var="user" value="#session.user">
    <tr>
        <td><s:property value="#user.name"/> </td>
        <td><s:property value="#user.password"/></td>
        <td><s:property value="#user.role"/></td>
        <td>
            <div style="display: inline-block" onclick="doUpdate('<s:property value="#user.name"/>')">修改</div>&nbsp;
                <div style="display: inline-block" onclick="doDelete('<s:property value="#user.name"/>')">删除</div></td>
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
<a href="listUser">查看全部</a>  <a href="home">返回主页</a><br>
<s:debug />
</body>
</html>
