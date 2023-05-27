<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/15
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String names = "";
    String pwd = "";
    Cookie[] c = request.getCookies();
    for (int i = 0;c!=null&&i<c.length;i++){
        if(c[i].getName().equals("users")){
            names = c[i].getValue().split("-")[0];
            pwd = c[i].getValue().split("-")[1];
            break;
        }
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面-验证用户自动登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/validatecookie" method="post">
    用户名：<input type="text" name="userName" value="<%=names%>"><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPass" value="<%=pwd%>"><br>
    <input type="checkbox" name="checkbox" value="ok">记住用户名
    <input type="checkbox" name="checkbox" value="ok">自动登录<br>
    <input type="submit" value="登录">
</form>
</body>
</html>
