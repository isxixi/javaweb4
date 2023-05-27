<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/16
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%--<%@ page import="LoginServlet"  language="java" %>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String names = "";
    String pwd = "";
    Cookie[] c = request.getCookies();
    for (int i=0;c!=null&&i<c.length;i++){
        if (c[i].getName().equals("users")){
            names = c[i].getValue().split("-")[0];
            pwd = c[i].getValue().split("-")[1];
            request.setAttribute("xingming",names);
            if (pwd!=null){
                request.setAttribute("mima",pwd);
            }
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body class="main">
<td style="...">
    <table width="80%" border="0" cellspacing="0"
           style="...">
        <tr>
            <td style="text-align: right;padding-top: 5px;width: 25%">用户名：</td>
            <td style="..."><input name="username" type="text" class="text-input" value="<%=names%>"></td>
        </tr>
        <tr>
            <td style="...">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td style="..."><input name="password" type="password" class="text-input" value="<%=pwd%>"></td>
        </tr>
        <tr>
            <td colspan="2" style="...">
                <input type="checkbox" name="checkbox" value="ok">记住用户名
                &nbsp;&nbsp;
                <input type="checkbox" name="checkbox" value="ok">自动登录
            </td>
        </tr>
    </table>
</td>
</body>
</html>
