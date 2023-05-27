<%@ page import="java.util.Collection" %>
<%@ page import="pojo.Product" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2022/4/20
  Time: 11:33
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
        <th>购买</th>
    </tr>
    <%
        Collection<Product> products = (Collection<Product>) session.getAttribute("products");
        for (Product product:products){
            String url = request.getServletContext().getContextPath()+"/purchaseProduct?id=" + product.getId();
            String newUrl = response.encodeRedirectURL(url);
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getCount()%></td>
        <td><%=product.getPrice()%></td>
        <td><a href="<%=newUrl%>">点击购买</a> </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
