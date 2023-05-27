<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/21
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/chapter/registservlet" method="post">
    <table>
        <tr>
            <td>请输入用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>请输入密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>请再次输入密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"/></td>
            <td><input type="reset"  value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
