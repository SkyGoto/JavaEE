<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 9/16/18
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>用户登录</title>
  </head>
  <body>
  <form action="/login" method="post" >
      姓名: <input  type="text" name="user.name" size="20"><br>
      密码: <input type="password" name="user.password" size="20"> <br>
      <input type="submit" value="登录">
      <input type="reset" value="重置">
  </form>
  <%--<s:form action="login" method="post" namespace="/login">--%>
      <%--<s:textfield name="user.name" label=" 姓名" size="20" />--%>
      <%--<s:password name="user.password" label=" 密码" size="20" />--%>
      <%--<s:submit value="登录"/>--%>
      <%--<s:reset value="重置" />--%>
  <%--</s:form>--%>
  <%----%>
  <%--<form action="login" method="post">--%>
      <%--姓名: <input type="text" name="user.name"><br>--%>
      <%--密码: <input type="password" name="user.password"><br>--%>
      <%--<input type="submit" value="登录">--%>
      <%--<input type="reset" value="重置">--%>
  <%--</form>--%>
  <s:debug />
  </body>
</html>
