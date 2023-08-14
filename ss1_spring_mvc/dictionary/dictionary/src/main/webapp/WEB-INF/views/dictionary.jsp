<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/8/2023
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>English-Vietnamese Dictionary</h2>
<form action="/dictionary" method="post">
    <input type="text" name="anh" placeholder="enter english words">
    <div>Result: ${error} ${message}</div>
    <button type="submit">Search</button>
</form>
</body>
</html>
