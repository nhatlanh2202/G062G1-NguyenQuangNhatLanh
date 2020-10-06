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
    <h2>Update Customer</h2>
    <form method="post">
        <div class="form-group">
            <label for="customerId">Customer ID</label>
            <input type="text" name="customerId" id="customerId" class="form-control" value="${customer.customerId}" readonly="true">
        </div>
        <div class="form-group">
            <label for="customerTypeId">Customer Type Id</label>
            <input type="text" name="customerTypeId" id="customerTypeId" class="form-control" value="${customer.customerTypeId}">
        </div>
        <div class="form-group">
            <label for="customerName">Customer Name</label>
            <input type="text" name="customerName" id="customerName" class="form-control" value="${customer.customerName}">
        </div>
        <div class="form-group">
            <label for="customerBirthday">Customer Birthday</label>
            <input type="date" name="customerBirthday" id="customerBirthday" class="form-control" value="${customer.customerBirthday}">
        </div>
        <div class="form-group">
            <label for="customerGender">Customer Gender</label>
            <input type="text" name="customerGender" id="customerGender" class="form-control" value="${customer.customerGender}">
        </div>
        <div class="form-group">
            <label for="customerIdCard">Customer Id Card</label>
            <input type="text" name="customerIdCard" id="customerIdCard" class="form-control" value="${customer.customerIdCard}" placeholder="${Message1}">
        </div>
        <div class="form-group">
            <label for="customerPhone">Customer Phone Number</label>
            <input type="text" name="customerPhone" id="customerPhone" class="form-control" value="${customer.customerPhone}" placeholder="${Message2}">
        </div>
        <div class="form-group">
            <label for="customerEmail">Customer Email</label>
            <input type="text" name="customerEmail" id="customerEmail" class="form-control" value="${customer.customerEmail}" placeholder="${Message3}">
        </div>
        <div class="form-group">
            <label for="customerAddress">Customer Address</label>
            <input type="text" name="customerAddress" id="customerAddress" class="form-control" value="${customer.customerAddress}">
        </div>
        <div>
<%--            <input type="hidden" name="action" value="create">--%>
            <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
        </div>
    </form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
