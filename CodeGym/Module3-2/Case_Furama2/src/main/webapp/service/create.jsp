<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/HomePage?action=listService">List All Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>service id:</th>
                <td>
                    <input type="text" name="serviceId" id="serviceId" size="45" placeholder="${Message}"/>
                </td>
            </tr>
            <tr>
                <th>service name:</th>
                <td>
                    <input type="text" name="serviceName" id="serviceName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>service area:</th>
                <td>
                    <input type="text" name="serviceArea" id="serviceArea" size="45"/>
                </td>
            </tr>
            <tr>
                <th>service cost:</th>
                <td>
                    <input type="text" name="serviceCost" id="serviceCost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>service max people:</th>
                <td>
                    <input type="text" name="serviceMaxPeople" id="serviceMaxPeople" size="45"/>
                </td>
            </tr>
            <tr>
                <th>rent type id:</th>
                <td>
                    <input type="text" name="rentTypeId" id="rentTypeId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>service type id:</th>
                <td>
                    <input type="text" name="serviceTypeId" id="serviceTypeId" size="45"/>
                </td>
            </tr>
            <tr>
                <th>standard room:</th>
                <td>
                    <input type="text" name="standardRoom" id="standardRoom" size="45"/>
                </td>
            </tr>
            <tr>
                <th>description other convenionce:</th>
                <td>
                    <input type="text" name="descriptionOtherConvenionce" id="descriptionOtherConvenionce" size="45"/>
                </td>
            </tr>
            <tr>
                <th>pool area:</th>
                <td>
                    <input type="text" name="poolArea" id="poolArea" size="45"/>
                </td>
            </tr>
            <tr>
                <th>number of floors:</th>
                <td>
                    <input type="text" name="numberOfFloors" id="numberOfFloors" size="45"/>
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

