
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wrong login</title>
</head>
<body>
<h1>Wrong login</h1>
<p><strong>Details:</strong> <%= exception.getMessage() %></p>
<a href="ShowDogList">Home</a>
</body>
</html>