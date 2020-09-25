<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 24/09/2020
  Time: 6:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bai_tap.customers" %>
<%
  List<customers> data = new ArrayList<>();
  data.add(new customers("Mai Văn Hoàn","1983-08-20","Hà Nội","images.jpg"));
  data.add(new customers("Nguyễn Văn Nam","1983-08-21","Bắc Giang","images2.jpg"));
  data.add(new customers("Nguyễn Thái Hòa","1983-08-22","Nam Định","images3.jpg"));
  data.add(new customers("Trần Đăng Khoa","1983-08-17","Hà Tây","images4.jpg"));
  data.add(new customers("Nguyễn Đình Thi","1983-08-19","Hà Nội","images5.jpg"));
  pageContext.setAttribute("myCustomer",data);
%>
<html>
  <head>
    <title>$Title$</title>
    <style>
      table {
        margin-left: 400px;
        height: 100px;
        width: 600px;
      }
      img {
        height: 75px;
        width: 75px;
      }
    </style>
  </head>
  <body style="background-color: #F0F0F0">
  <table border="1px">
    <caption><h1>Danh sách khách hàng</h1></caption>
    <tr>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa chỉ</th>
      <th>Ảnh</th>
    </tr>
    <c:forEach var="tempCustomer" items="${myCustomer}">
      <tr>
        <td>${tempCustomer.name}</td>
        <td>${tempCustomer.birthday}</td>
        <td>${tempCustomer.address}</td>
        <td><img src=${tempCustomer.image}></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
