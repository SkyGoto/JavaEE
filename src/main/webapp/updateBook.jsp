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
<form action="update.action" method="post" enctype="multipart/form-data">
    书号: <input type="text" name="book.isbn" value="<s:property value="#session.rebook.isbn"/>" readonly><br>
    书名: <input type="text" name="book.title" value="<s:property value="#session.rebook.title"/>"><br>
    作者姓名: <input type="text" name="book.author.name" value="<s:property value="#session.rebook.author.name"/>"><br>
    作者电话: <input type="text" name="book.author.tel" value="<s:property value="#session.reauthor.tel"/> "><br>
    作者邮件: <input type="text" name="book.author.email" value="<s:property value="#session.reauthor.email" />"><br>
    价格: <input type="text" name="book.price" value="<s:property value="#session.rebook.price"/>"><br>
    介绍: <input type="file" name="bookIntro"><br>

    <input type="submit" value="修改">
</form>
<s:actionmessage/> <br>

<a href="listBook">查看全部</a>  <a href="home">返回主页</a><br>
</body>
</html>
