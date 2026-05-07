<%@ page import="DTO.UserDTO" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.05.2026
  Time: 04:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
