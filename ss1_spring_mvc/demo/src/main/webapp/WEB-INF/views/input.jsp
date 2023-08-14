<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/8/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change money</title>
</head>
<body>
<h2>Currency converter app</h2>
<form action="/change/input" method="post">
<input type="number" name="usd" placeholder="USD">
<input type="number" name="rate" placeholder="Rate">
<button type="submit">Change</button>
</form>
<div>
<h4>Result:</h4>
    ${result}
</div>

</body>
</html>
