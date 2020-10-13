<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

<%--    <h3>${message1}</h3>--%>
    <h3>${message}</h3>

    <form action="/Exam" method="post">
        <input type="hidden" name="action" value="create">
        <div class="form-group">
            <label>Mã mặt bằng</label>
            <input type="text" class="form-control" name="ma_mat_bang" value="${matBang.ma_mat_bang}" required>
        </div>
        <div class="form-group">
            <label>Trạng thái</label>
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
            <input class="form-control" name="dien_tich" value="${matBang.dien_tich}" required>
        </div>
        <div class="form-group">
            <label>Tầng</label>
            <input class="form-control" name="tang" value="${matBang.tang}" required>
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
            <input class="form-control" name="gia_tien" value="${matBang.gia_tien}" required>
        </div>
        <div class="form-group">
            <label>Ngày Bắt Đầu</label>
            <input type="date" class="form-control" name="ngay_bat_dau" value="${matBang.ngay_bat_dau}">
        </div>
        <div class="form-group">
            <label>Ngày Kết Thúc</label>
            <input type="date" class="form-control" name="ngay_ket_thuc" value="${matBang.ngay_ket_thuc}">
        </div>
        <input type="submit" class="btn btn-info" value="Create New"><span>
    <a href="/Exam" class="btn btn-info back">Back</a></span>
    </form>
</div>
</body>
</html>
