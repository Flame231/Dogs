<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.05.2026
  Time: 03:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User not found</title>
</head>
<body>
<h1>User not found</h1>
<p><strong>Details:</strong> <%= exception.getMessage() %></p>
<a href="ShowDogList">Home</a>
</body>
</html>
