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
<form action="addbook" method="post" enctype="multipart/form-data">
    书号: <input type="text" name="book.isbn"><br>
    书名: <input type="text" name="book.title"><br>
    <%--作者: <input type="text" name="book.author"><br>--%>
    价格: <input type="text" name="book.price"><br>
    介绍: <input type="file" name="file"><br>
    作者姓名: <input type="text" name="author.name"><br>
    作者电话: <input type="text" name="author.tel"><br>
    作者邮件: <input type="text" name="author.email"><br>
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
