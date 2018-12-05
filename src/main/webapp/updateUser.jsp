<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 10/14/18
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>
<form action="updateUser" method="post" >
    用户名: <input type="text" name="user.name" value="<s:property value="#session.reUser.name"/>" readonly><br>
    <%--用户密码: <input type="text" name="user.password" value="<s:property value="#session.reUser.password"/>"><br>--%>
    用户密码: <input type="text" name="user.password" ><br>
    用户角色: <input type="text" name="user.role" value="<s:property value="#session.reUser.role" />" readonly><br>

    <input type="submit" value="修改">
</form>
<s:actionmessage/> <br>

<a href="listUser">查看全部</a>  <a href="home">返回主页</a><br>
</body>
</html>
