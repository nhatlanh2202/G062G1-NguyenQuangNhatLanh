<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/10/2020
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="number" name="num1" value="${num1}" required>
    <input type="number" name="num2" value="${num2}" required>
    <input type="number" value="${result}" readonly>
    <select name="calculation">
        <option value="add" ${calculation=="add" ? "selected":""}>+</option>
        <option value="sub" ${calculation=="sub" ? "selected":""}>-</option>
        <option value="mul" ${calculation=="mul" ? "selected":""}>*</option>
        <option value="div" ${calculation=="div" ? "selected":""}>/</option>
    </select>
    <input type="submit" value="calculate">
</form>
</body>
</html>
