<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 6:21 PM
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
<form action="addUser" method="post" >
    姓名: <input type="text" name="user.name"><br>
    密码: <input type="text" name="user.password"><br>
    角色: <select name="user.role">
            <option  value="读者" selected>读者</option>
            <option  value="管理员" >管理员</option>
          </select><br>
    <input type="submit" value="添加">
    <input type="reset" value="重置">

    <%--<s:textfield name="book.title" label=" 姓名" size="20" />--%>
    <%--<s:password name="book.price" label=" 密码" size="21" />--%>
    <%--<s:submit value="登录"/>--%>
    <%--<s:reset value="重置" />--%>
</form>
<s:property value="message"/><br>
<s:actionmessage/>
<a href="home">返回主页</a><br>
</body>
</html>
