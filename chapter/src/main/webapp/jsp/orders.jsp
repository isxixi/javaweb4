<%@ page import="pojo.Product" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>数量</th>
        <th>单价</th>
    </tr>
    <%
        Collection<Product> products = (Collection<Product>) session.getAttribute("orders");
        for (Product product:products){
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getCount()%></td>
        <td><%=product.getPrice()%></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="4"><a href="/chapter/listProduct">产品页面</a> </td>
    </tr>
</table>
</body>
</html>
