<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/10/2020
  Time: 5:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<form action="/library" method="post">
    <input type="text" name="key" placeholder="Input English" value="${key}">
    <input type="text" name ="word" value="${word}" readonly>
    <input type="submit" value="Translate">
</form>
</body>
</html>
