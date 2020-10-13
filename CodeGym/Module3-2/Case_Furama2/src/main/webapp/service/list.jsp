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
<h1>List Service</h1>
<h2>
    <a href="/HomePage?action=createService">Add New Service</a>
</h2>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="table" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Service Id</th>
                    <th>Service Name</th>
                    <th>Service Area</th>
                    <th>Service Code</th>
                    <th>Service Max People</th>
                    <th>Rent Type Id</th>
                    <th>Service Type Id</th>
                    <th>Standard Room</th>
                    <th>Description Other Convenionce</th>
                    <th>Pool Area</th>
                    <th>Number Of Floors</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <td><c:out value="${service.serviceId}"/></td>
                        <td><c:out value="${service.serviceName}"/></td>
                        <td><c:out value="${service.serviceArea}"/></td>
                        <td><c:out value="${service.serviceCost}"/></td>
                        <td><c:out value="${service.serviceMaxPeople}"/></td>
                        <td><c:out value="${service.rentTypeId}"/></td>
                        <td><c:out value="${service.serviceTypeId}"/></td>
                        <td><c:out value="${service.standardRoom}"/></td>
                        <td><c:out value="${service.descriptionOtherConvenionce}"/></td>
                        <td><c:out value="${service.poolArea}"/></td>
                        <td><c:out value="${service.numberOfFloors}"/></td>
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
        $('#table').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>

