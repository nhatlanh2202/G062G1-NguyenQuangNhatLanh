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
<h1>List Contract Detail</h1>
<h2>
    <a href="/HomePage?action=createContractDetail">Add New Contract Detail</a>
</h2>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableEmployee" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>contract detail id</th>
                    <th>contract id</th>
                    <th>attach service id</th>
                    <th>quanlity</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${contractDetailList}">
                    <tr>
                        <td><c:out value="${employee.contractDetailId}"/></td>
                        <td><c:out value="${employee.contractId}"/></td>
                        <td><c:out value="${employee.attachServiceId}"/></td>
                        <td><c:out value="${employee.quanlity}"/></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../jquery/jquery-3.5.1.min.js"></script>
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

