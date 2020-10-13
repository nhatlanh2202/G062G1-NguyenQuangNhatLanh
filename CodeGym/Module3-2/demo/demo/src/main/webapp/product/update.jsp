<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Update Customer</h2>
    <form method="post">
        <div class="form-group">
            <label for="name">Product Name</label>
            <input type="text" name="name" id="name" class="form-control" value="${product.name}">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" name="price" id="price" class="form-control" value="${product.price}">
        </div>
        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="text" name="quantity" id="quantity" class="form-control" value="${product.quantity}">
        </div>
        <div class="form-group">
            <label for="color">Color</label>
            <input type="text" name="color" id="color" class="form-control" value="${product.color}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="description" id="description" class="form-control" value="${product.description}">
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <input type="text" name="category" id="category" class="form-control" value="${product.category}">
        </div>
        <div>
            <button type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>
        </div>
    </form>
    <button><a href="/HomePage?action=listProduct">List product</a></button>
</div>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
