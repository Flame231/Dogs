<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.05.2026
  Time: 05:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wrong password</title>
</head>
<body>
<h1>Wrong Pass Word</h1>
<p><strong>Details:</strong> <%= exception.getMessage() %></p>
<a href="ShowDogList">Home</a>
</body>
</html>
