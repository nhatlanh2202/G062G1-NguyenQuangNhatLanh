<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/27/2020
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
    <style>
        a {
            color: black;
        }
    </style>
</head>
<body>
<h1>Products</h1>

<p>
    <a href="/products-manager?action=create"><h3>Create new product</h3></a>
</p>

<form method="post">
    <label style="color: black">Search product by name : <input type="text" name="nameProduct" id="nameProduct"/></label>
    <input type="submit" value="Search">
    <br><br>
</form>

<table border="1">
    <tr class="row-1">
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/products-manager?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td class="name">${product.getName()}</td>
            <td class="price">${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacturer()}</td>
            <td><a href="/products-manager?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products-manager?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
