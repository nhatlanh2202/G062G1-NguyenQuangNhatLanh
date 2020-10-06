<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Employee</h1>
<form action="/HomePage">
    <h3>Search by id</h3><br>
    <input type="hidden" name="action" value="searchEmployee">
    <input type="submit" value="search">
    <input type="text" name="employeeId">
</form>
<button>
    <a href="/HomePage?action=createEmployee">Add New Employee</a>
</button><br>
<button> <a href="/HomePage">Back To Home</a></button><br>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableEmployee" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee Name</th>
                    <th>Employee Birthday</th>
                    <th>Employee Id Card</th>
<%--                    <th>Employee Salary</th>--%>
                    <th>Employee Phone</th>
                    <th>Employee Email</th>
                    <th>Employee Address</th>
<%--                    <th>Position Id</th>--%>
<%--                    <th>Education Degree Id</th>--%>
<%--                    <th>Division Id</th>--%>
                    <th>Username</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><c:out value="${employee.employeeId}"/></td>
                        <td><c:out value="${employee.employeeName}"/></td>
                        <td><c:out value="${employee.employeeBirthday}"/></td>
                        <td><c:out value="${employee.employeeIdCard}"/></td>
<%--                        <td><c:out value="${employee.employeeSalary}"/></td>--%>
                        <td><c:out value="${employee.employeePhone}"/></td>
                        <td><c:out value="${employee.employeeEmail}"/></td>
                        <td><c:out value="${employee.employeeAddress}"/></td>
<%--                        <td><c:out value="${employee.positionId}"/></td>--%>
<%--                        <td><c:out value="${employee.educationDegreeId}"/></td>--%>
<%--                        <td><c:out value="${employee.divisionId}"/></td>--%>
                        <td><c:out value="${employee.username}"/></td>
                        <td>
                            <a href="/HomePage?action=updateEmployee&employeeId=${employee.employeeId}">Update</a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#abc${employee.employeeId}">
                                Delete
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="abc${employee.employeeId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                            <a href="/HomePage?action=deleteEmployee&employeeId=${employee.employeeId}">
                                            <button type="button" class="btn btn-primary">Accept Delete</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                <%--                            <a href="/HomePage?action=deleteEmployee&employeeId=${employee.employeeId}">Delete</a>--%>
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
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
