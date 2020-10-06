<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/HomePage?action=listEmployee">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>employee id:</th>
                <td>
                    <input type="text" name="employeeId" id="employeeId" size="45" placeholder="${Message1}"/>
                </td>
            </tr>
            <tr>
                <th>employee name:</th>
                <td>
                    <input type="text" name="employeeName" id="employeeName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>employee birthday:</th>
                <td>
                    <input type="date" name="employeeBirthday" id="employeeBirthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>employeeId card:</th>
                <td>
                    <input type="text" name="employeeIdCard" id="employeeIdCard" size="45" placeholder="${Message2}"/>
                </td>
            </tr>
            <tr>
                <th>employee salary:</th>
                <td>
                    <input type="text" name="employeeSalary" id="employeeSalary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>employee phone:</th>
                <td>
                    <input type="text" name="employeePhone" id="employeePhone" size="45" placeholder="${Message3}"/>
                </td>
            </tr>
            <tr>
                <th>employee email:</th>
                <td>
                    <input type="text" name="employeeEmail" id="employeeEmail" size="45" placeholder="${Message4}"/>
                </td>
            </tr>
            <tr>
                <th>employee address:</th>
                <td>
                    <input type="text" name="employeeAddress" id="employeeAddress" size="45"/>
                </td>
            </tr>
            <tr>
                <th>position id:</th>
                <td>
                    <input type="text" name="positionId" id="positionId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>education degree id:</th>
                <td>
                    <input type="text" name="educationDegreeId" id="educationDegreeId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>division id:</th>
                <td>
                    <input type="text" name="divisionId" id="divisionId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>username:</th>
                <td>
                    <input type="text" name="username" id="username" size="45"/>
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


