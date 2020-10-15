<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/10/2020
  Time: 3:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choice</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/condiment">
    <input type="checkbox" name="condiment" value="Lettuce ">Lettuce
    <input type="checkbox" name="condiment" value="Tomato ">Tomato
    <input type="checkbox" name="condiment" value="Mustard ">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <input type="hidden" name="condiment"><br><br>
    <input type="submit" value="Save">
</form>
</body>
</html>
