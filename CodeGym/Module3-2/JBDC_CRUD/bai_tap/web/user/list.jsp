<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 28/09/2020
  Time: 7:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List All Users</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
        <form action="/users">
            <label>Search user</label>
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="search"/>
            <input type="submit" value="search"/>
        </form>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
                <td><a href="/users?action=edit&id=${user.getId()}">Edit</a></td>
                <td><a href="/users?action=delete&id=${user.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
