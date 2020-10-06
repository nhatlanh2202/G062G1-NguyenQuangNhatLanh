<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Contract Management</h1>
    <h2>
        <a href="/HomePage?action=listContract">List All Contracts</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract</h2>
            </caption>
            <tr>
                <th>Contract Id:</th>
                <td>
                    <input type="text" name="contractId" id="contractId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Start Date:</th>
                <td>
                    <input type="text" name="contractStartDate" id="contractStartDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract End Date:</th>
                <td>
                    <input type="text" name="contractEndDate" id="contractEndDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Deposit:</th>
                <td>
                    <input type="text" name="contractDeposit" id="contractDeposit" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Total Money:</th>
                <td>
                    <input type="text" name="contractTotalMoney" id="contractTotalMoney" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id:</th>
                <td>
                    <input type="text" name="employeeId" id="employeeId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id:</th>
                <td>
                    <input type="text" name="customerId" id="customerId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Id:</th>
                <td>
                    <input type="text" name="serviceId" id="serviceId" size="45"/>
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
