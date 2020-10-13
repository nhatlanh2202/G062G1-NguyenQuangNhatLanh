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
<h1>List Product</h1>
<form action="/HomePage">
    <h3>Search by Name</h3><br>
    <input type="hidden" name="action" value="search">
    <input type="submit" value="search">
    <input type="text" name="name">
</form>
<h2>
    <a href="/HomePage?action=createProduct">Add New Product</a>
</h2>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <table id="table" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>id</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td><c:out value="${product.quantity}"/></td>
                        <td><c:out value="${product.color}"/></td>
                        <td><c:out value="${product.description}"/></td>
                        <td><c:out value="${product.category}"/></td>
                        <td>
                                <%--                            <a href="/HomePage?action=update&id=${product.id}">Update</a>--%>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#edit${product.id}">
                                
                                Update
                            </button>
                            <div class="modal fade" id="#edit${product.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Update</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form" id="newModalForm">
                                                <div class="form-group">
                                                    <label for="id">id</label>
                                                    <input type="hidden" name="id" id="id" class="form-control"
                                                           value="${product.id}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="name">Product Name</label>
                                                    <input type="text" name="name" id="name" class="form-control"
                                                           value="${product.name}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="price">Product Name</label>
                                                    <input type="text" name="price" id="price" class="form-control"
                                                           value="${product.price}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="quantity">Quantity</label>
                                                    <input type="text" name="quantity" id="quantity"
                                                           class="form-control" value="${product.quantity}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="color">Color</label>
                                                    <input type="text" name="color" id="color" class="form-control"
                                                           value="${product.color}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="description">Description</label>
                                                    <input type="text" name="description" id="description"
                                                           class="form-control" value="${product.description}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="category">Category</label>
                                                    <input type="text" name="category" id="category"
                                                           class="form-control" value="${product.category}">
                                                </div>
                                                <div>
                                                        <%--            <input type="hidden" name="action" value="create">--%>
                                                    <button type="submit" class="btn btn-primary" id="btnSubmit">
                                                        Submit
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#abc${product.id}">
                                Delete
                            </button>
                            <div class="modal fade" id="abc${product.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a href="/HomePage?action=delete&id=${product.id}">
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
        $('#table').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
