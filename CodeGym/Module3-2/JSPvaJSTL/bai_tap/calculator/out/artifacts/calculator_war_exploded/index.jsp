<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 25/09/2020
  Time: 4:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<div>
<form action="/calculator" method="post">
    <h2>Simple Calculator</h2>
    <fieldset>
    <legend>Calculator</legend>
    <table>
        <tr>
            <td>First operand:</td>
            <td><input type="text" name="first"></td>
        </tr>
        <tr>
            <td>Operator:</td>
            <td>
                <select name="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="x">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second operand:</td>
            <td><input type="text" name="second"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="Calculate"></td>
        </tr>
        <tr>
            <td>Result</td>
            <td><p id="result">${result}</p></td>
        </tr>
    </table>
    </fieldset>
</form>
</div>
</body>
</html>
