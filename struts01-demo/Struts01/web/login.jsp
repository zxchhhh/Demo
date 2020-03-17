<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="login" method="post">
<%--    给user对象绑定值--%>
    用户名：<input type="text" name="user.name"></br>
    密码：<input type="password" name="user.password"></br>
    <input type="submit" value="登录">
</form>
</body>
</html>
