<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/27/2020
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products-manager">Back to products list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price :</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description :</td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Manufacturer :</td>
                <td><input type="text" name="manufacturer" id="manufacturer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>