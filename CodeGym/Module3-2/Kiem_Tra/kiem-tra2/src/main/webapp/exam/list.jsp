<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Note Management</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            /*background: #f7f5f2;*/
            font-family: 'Roboto', sans-serif;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            color: #fff;
            background: dimgray;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .search-box {
            position: relative;
            float: right;
        }

        .search-box .input-group {
            min-width: 300px;
            position: absolute;
            right: 0;
        }

        .search-box .input-group-addon, .search-box input {
            border-color: #ddd;
            border-radius: 0;
        }

        .search-box input {
            height: 34px;
            padding-right: 35px;
            background: #f4fcfd;
            border: none;
            border-radius: 2px !important;
        }

        .search-box input:focus {
            background: #fff;
        }

        .search-box input::placeholder {
            font-style: italic;
        }

        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 6px 0;
        }

        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
            position: relative;
            top: 2px;
        }

        table.table {
            table-layout: fixed;
            margin-top: 15px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table th:first-child {
            width: 60px;
        }

        table.table th:last-child {
            width: 120px;
        }

        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }

        table.table td a.view {
            color: #03A9F4;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #E34724;
        }

        table.table td i {
            font-size: 19px;
        }
    </style>

</head>
<body>
<div style="width: 500px; margin-left: 600px">

    <form action="/Exam">
        <input type="hidden" name="action" value="searchByTang">
        <input type="submit" value="Tìm theo tầng">
        <input type="text" name="tang">
    </form>

    <form action="/Exam">
        <input type="hidden" name="action" value="searchByGia">
        <input type="submit" value="Tìm theo giá">
        <input type="text" name="gia_tien">
    </form>

    <form action="/Exam">
        <input type="hidden" name="action" value="searchByLoaiMatBang">
        <input type="submit" value="tìm loại mặt bằng">
        <input type="text" name="ten_loai_mat_bang">
    </form>

</div>

<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper" style="background-color:#f7f5f2 ">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Quản Lý Mặt Bằng</h2>
                    </div>
                    <div class="col-sm-3">
                        <a href="#addProModal" class="btn btn-success" data-toggle="modal"><i class="fa fa-plus"></i>
                            <span>Thêm mới mặt bằng</span></a>
                    </div>
                    <div class="col-sm-3">
                        <div class="search-box">
                            <div class="input-group">
                                <input type="text" id="search" class="form-control" placeholder="Search by Name">
                                <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${message != null}">
                <span class="message" style="color: blue"><i>${message}</i></span>
            </c:if>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Mã mặt bằng</th>
                    <th style="width: 22%;">Trạng thái</th>
                    <th>Diện tích</th>
                    <th>Tầng</th>
                    <th style="width: 16%">Loại văn phòng</th>
                    <th>Giá cho thuê</th>
                    <th style="width: 12%">Ngày bắt đầu</th>
                    <th style="width: 12%">Ngày kết thúc</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="matBang" items="${dtoMatBangList}">
                    <tr>
                        <td><span><c:out value="${matBang.ma_mat_bang}"></c:out></span></td>
                        <td><span><c:out value="${matBang.ten_trang_thai}"></c:out></span></td>
                        <td><span><c:out value="${matBang.dien_tich}"></c:out></span></td>
                        <td><span><c:out value="${matBang.tang}"></c:out></span></td>
                        <td><span><c:out value="${matBang.ten_loai_mat_bang}"></c:out></span></td>
                        <td><span><c:out value="${matBang.gia_tien}"></c:out></span></td>
                        <td><span><c:out value="${matBang.ngay_bat_dau}"></c:out></span></td>
                        <td><span><c:out value="${matBang.ngay_ket_thuc}"></c:out></span></td>
                        <td>
                            <a href="" class="delete" title="Delete" data-toggle="modal"
                               data-target="#abc${matBang.ma_mat_bang}"><i class="material-icons">&#xE872;</i></a>

                            <div class="modal fade" id="abc${matBang.ma_mat_bang}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Xác nhận xóa</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Bạn có chắc chắn muốn xóa không ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy
                                            </button>
                                            <a href="/Exam?action=delete&ma_mat_bang=${matBang.ma_mat_bang}">
                                                <button type="button" class="btn btn-primary">Xóa</button>
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


<!-- Edit Modal HTML -->
<div id="addProModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/Exam?action=create" method="post">
                <div class="modal-header" style="background: dimgrey">
                    <h4 class="modal-title" style="color: #e9e9e9">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã Mặt Bằng</label>
                        <input type="text" class="form-control" name="ma_mat_bang">
                    </div>
                    <div class="form-group">
                        <label>Trạng Thái</label>
                        <select name="id_trang_thai" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="trangThai" items="${trangThaiList}">
                                <option value="${trangThai.id_trang_thai}"><c:out
                                        value="${trangThai.ten_trang_thai}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Diện Tích</label>
                        <input class="form-control" name="dien_tich"></input>
                    </div>
                    <div class="form-group">
                        <label>Tầng</label>
                        <input class="form-control" name="tang"></input>
                    </div>
                    <div class="form-group">
                        <label>Loại Mặt Bằng</label>
                        <select name="id_loai_mat_bang" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            <c:forEach var="loaiMatBang" items="${loaiMatBangList}">
                                <option value="${loaiMatBang.id_loai_mat_bang}"><c:out
                                        value="${loaiMatBang.ten_loai_mat_bang}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Giá Tiền</label>
                        <input class="form-control" name="gia_tien"></input>
                    </div>
                    <div class="form-group">
                        <label>Ngày Bắt Đầu</label>
                        <input type="date" class="form-control" name="ngay_bat_dau"></input>
                    </div>
                    <div class="form-group">
                        <label>Ngày Kết Thúc</label>
                        <input type="date" class="form-control" name="ngay_ket_thuc"></input>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

