<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/8/2023
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator/action" method="post">
  <div>
    <input type="number" name="operator1" placeholder="operator1">
    <input type="number" name="operator2" placeholder="operator2">
  </div>
  <br>
  <div>
    <button type="submit" name="operation" value="Addition">Addition</button>
    <button type="submit" name="operation" value="Subtraction">Subtraction</button>
    <button type="submit" name="operation" value="Multiplication">Multiplication</button>
    <button type="submit" name="operation" value="Division">Division</button>
  </div>
</form>
<div>Result: ${result}</div>

</body>
</html>
