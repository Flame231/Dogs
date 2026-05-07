<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Already Exist</title>
</head>
<body>
<h1>User already exist</h1>
<p><strong>Details:</strong> <%= exception.getMessage() %></p>
<a href="ShowDogList">Home</a>
</body>
</html>
