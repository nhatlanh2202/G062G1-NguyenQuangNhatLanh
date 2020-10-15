<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 15/10/2020
  Time: 1:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
    .kc {
        float: left;
    }
</style>
</head>
<body>
<form:form action="/mail" method="post" modelAttribute="home_mail">
    <div>
        <div><strong>languages</strong>
            <span style="margin-left: 20px">
            <form:select path="languages" items="${languages}">${home_mail.languages}</form:select>
            </span>
        </div>
    </div>

    <br>

    <div>
        <div><strong>Page Size: </strong>
            <span style="margin-left: 20px">Show</span>
            <span style="margin-left: 10px">
                    <form:select path="pageSize" items="${pageSize}">${home_mail.pageSize}</form:select>
            </span>
            <span style="margin-left: 10px">emails per page</span>
        </div>
    </div>

    <br>

    <div>
        <div><strong>Spams filter: </strong>
            <form:checkbox path="spamsFilter" value="true"/>
            <span style="margin-left: 10px">Enable spams filter</span>
        </div>
    </div>

    <br>

    <div>
        <div><Strong>Signature: </Strong>
            <span style="margin-left: 20px">
            <form:textarea path="signature"/>
            </span>
        </div>
    </div>

    <br>

    <div style="float: left">
        <input type="submit" value="update">
    </div>
</form:form>
</body>
</html>
