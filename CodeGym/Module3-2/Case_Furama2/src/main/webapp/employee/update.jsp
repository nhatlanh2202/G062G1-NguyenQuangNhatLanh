<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Update Employee</h2>
    <form method="post">
        <div class="form-group">
            <label for="employeeId">Employee Id</label>
            <input type="text" name="employeeId" id="employeeId" class="form-control" value="${employee.employeeId}" readonly="true">
        </div>
        <div class="form-group">
            <label for="employeeName">Employee Name</label>
            <input type="text" name="employeeName" id="employeeName" class="form-control" value="${employee.employeeName}">
        </div>
        <div class="form-group">
            <label for="employeeBirthday">Employee Birthday</label>
            <input type="date" name="employeeBirthday" id="employeeBirthday" class="form-control" value="${employee.employeeBirthday}">
        </div>
        <div class="form-group">
            <label for="employeeIdCard">Employee Id Card</label>
            <input type="text" name="employeeIdCard" id="employeeIdCard" class="form-control" value="${employee.employeeIdCard}" placeholder="${Message2}">
        </div>
        <div class="form-group">
            <label for="employeeSalary">Employee Salary</label>
            <input type="text" name="employeeSalary" id="employeeSalary" class="form-control" value="${employee.employeeSalary}">
        </div>
        <div class="form-group">
            <label for="employeePhone">Employee Phone</label>
            <input type="text" name="employeePhone" id="employeePhone" class="form-control" value="${employee.employeePhone}" placeholder="${Message3}">
        </div>
        <div class="form-group">
            <label for="employeeEmail">Employee Email</label>
            <input type="text" name="employeeEmail" id="employeeEmail" class="form-control" value="${employee.employeeEmail}" placeholder="${Message4}">
        </div>
        <div class="form-group">
            <label for="employeeAddress">Employee Address</label>
            <input type="text" name="employeeAddress" id="employeeAddress" class="form-control" value="${employee.employeeAddress}">
        </div>
        <div class="form-group">
            <label for="positionId">Position Id</label>
            <input type="text" name="positionId" id="positionId" class="form-control" value="${employee.positionId}">
        </div>
        <div class="form-group">
            <label for="educationDegreeId">Education Degree Id</label>
            <input type="text" name="educationDegreeId" id="educationDegreeId" class="form-control" value="${employee.educationDegreeId}">
        </div>
        <div class="form-group">
            <label for="divisionId">Division Id</label>
            <input type="text" name="divisionId" id="divisionId" class="form-control" value="${employee.divisionId}">
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" class="form-control" value="${employee.username}">
        </div>
        <div>
            <%--            <input type="hidden" name="action" value="create">--%>
            <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
        </div>
    </form>
</div>
<button><a href="/HomePage?action=listEmployee">List All Employee</a></button>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

