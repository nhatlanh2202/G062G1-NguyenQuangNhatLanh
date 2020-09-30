<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/27/2020
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products-manager">Back to products list</a>
</p>
<form method="post">
    <h3>Are you sure ?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name :</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price :</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description :</td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Manufacturer :</td>
                <td>${requestScope["product"].getManufacturer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products-manager">Back to products list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
