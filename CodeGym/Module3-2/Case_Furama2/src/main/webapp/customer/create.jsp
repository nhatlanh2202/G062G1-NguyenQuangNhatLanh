<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/HomePage?action=listCustomer">List All Customers</a>
    </h2>
    <h3>${message}</h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Id:</th>
                <td>
                    <input type="text" name="customerId" id="customerId" size="45" placeholder="${Message1}"/>
                </td>
            </tr>
            <tr>
                <th>Custome Type Id:</th>
                <td>
                    <input type="text" name="customerTypeId" id="customerTypeId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="customerName" id="customerName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="customerBirthday" id="customerBirthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="customerGender" id="customerGender" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="customerIdCard" id="customerIdCard" size="45" placeholder="${Message2}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="customerPhone" id="customerPhone" size="45" placeholder="${Message3}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="customerEmail" id="customerEmail" size="45" placeholder="${Message3}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customerAddress" id="customerAddress" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
