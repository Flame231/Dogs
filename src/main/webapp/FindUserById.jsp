<%@ page import="DTO.UserDTO" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search by Id</title>
    <form action = "FindUserById" method = "post">
        Identifier: <input name = "id" type = "number"/><br/>
        <input type = "submit">
    </form>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>DateTimeRegistration</th>
            <th>DateTimeAuthorization</th>

        </tr>
        </thead>
        <tbody>
        <%
            UserDTO user = (UserDTO) request.getAttribute("user");
            if (user != null && user.getId() != null) {

        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getLogin() %></td>
            <td><%= user.getRegistrationTime() %></td>
            <td><%= user.getAuthorizationTime() %></td>

        </tr>
        <%
        } else {
        %>
        <tr>
            <td colspan="5">No products found</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


</head>
<body>

</body>
</html>
