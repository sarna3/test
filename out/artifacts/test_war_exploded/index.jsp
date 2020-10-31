<%--
  Created by IntelliJ IDEA.
  User: S.sarna
  Date: 2020/10/30
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Signin</title>
</head>
<body>
<form action="loginServlet" method="post">
  用户名：<label><input type = "text" name = "name"/></label>
  密码 ：<label><input type = "password" psw = "psw"/></label>
  <input type="submit" value="提交">
</form>
</body>
</html>
