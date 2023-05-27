<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/20
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/chapter/login" method="post">
    <table>
        <tr>
            <td>用户名称</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
