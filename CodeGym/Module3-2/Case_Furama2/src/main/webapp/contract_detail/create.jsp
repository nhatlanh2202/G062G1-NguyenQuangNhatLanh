<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Contrac tDetail Management</h1>
    <h2>
        <a href="/HomePage?action=listContractDetail">List All Contract Detail</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract Detail</h2>
            </caption>
            <tr>
                <th>Contract Detail Id:</th>
                <td>
                    <input type="text" name="contractDetailId" id="contractDetailId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Id:</th>
                <td>
                    <input type="text" name="contractId" id="contractId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Attach Service Id:</th>
                <td>
                    <input type="text" name="attachServiceId" id="attachServiceId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quanlity:</th>
                <td>
                    <input type="text" name="quanlity" id="quanlity" size="45"/>
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
