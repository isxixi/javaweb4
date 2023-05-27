<%@ page import="java.sql.SQLOutput" %>
<%@ page import="solve.User"  language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/15
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    if (user!=null){
        System.out.println(user.getUserName());
    }
%>
<%=user.getUserName()%>欢迎你，登录成功！
</body>
</html>
