<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/8/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<div>${mess}</div>
<form action="/condiment/save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce" id="check1">
    <label for="check1" style="font-weight: bold">Lettuce</label>

    <input type="checkbox" name="condiment" value="Tomato" id="check2">
    <label for="check2" style="font-weight: bold">Tomato</label>

    <input type="checkbox" name="condiment" value="Mustard" id="check3">
    <label for="check3" style="font-weight: bold">Mustard</label>

    <input type="checkbox" name="condiment" value="Sprouts" id="check4">
    <label for="check4" style="font-weight: bold">Sprouts</label>
    <hr>
    <button type="submit">Save</button>
</form>
<hr>

<h2>Condiment you chose:</h2>
<c:forEach items="${list}" var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
