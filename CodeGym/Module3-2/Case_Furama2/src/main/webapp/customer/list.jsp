<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<h1>Customer Management</h1>

<form action="/HomePage">
    <h3>Search by id</h3><br>
    <input type="hidden" name="action" value="search">
    <input type="submit" value="search">
    <input type="text" name="customerId">
</form>
<button> <a href="/HomePage">Back To Home</a></button><br>
<button> <a href="/HomePage?action=createCustomer">Add New Customer</a></button><br>
<button> <a href="/HomePage?action=listCustomerUsingService">List Customer Using Service</a></button>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Customer Id</th>
<%--                    <th>Customer Type Id</th>--%>
                    <th>Customer Name</th>
                    <th>Customer Birthday</th>
                    <th>Customer Gender</th>
<%--                    <th>Customer Id Card</th>--%>
<%--                    <th>Customer Phone</th>--%>
                    <th>Customer Email</th>
                    <th>Customer Address</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td><c:out value="${customer.customerId}"/></td>
<%--                        <td><c:out value="${customer.customerTypeId}"/></td>--%>
                        <td><c:out value="${customer.customerName}"/></td>
                        <td><c:out value="${customer.customerBirthday}"/></td>
                        <td>
                            <c:if test="${customer.customerGender == 1}">Nam</c:if>
                            <c:if test="${customer.customerGender == 2}">Nữ</c:if>
                        </td>
<%--                        <td><c:out value="${customer.customerGender}"/></td>--%>
<%--                        <td><c:out value="${customer.customerIdCard}"/></td>--%>
<%--                        <td><c:out value="${customer.customerPhone}"/></td>--%>
                        <td><c:out value="${customer.customerEmail}"/></td>
                        <td><c:out value="${customer.customerAddress}"/></td>
                        <td>
                            <a href="/HomePage?action=update&customerId=${customer.customerId}">Update</a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#a${customer.customerId}">
                                Delete
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="a${customer.customerId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Confirm Delete</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Are you sure to delete ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <a href="/HomePage?action=delete&customerId=${customer.customerId}">
                                                <button type="button" class="btn btn-primary">Accept Delete</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../bootstrap413/js/bootstrap.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
