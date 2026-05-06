<%@ page import="DTO.DogDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="static controller.ShowDogList.DOGS_PER_PAGE" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Заголовок страницы</title>
</head>
<body>
<%
    List<DogDTO> list = (List<DogDTO>) request.getAttribute("list");
%>


<table border="2">
    <thead>
    <tr width="20">
        <th>ID</th>
        <th>Имя</th>
        <th>Тип</th>
    </tr>
    </thead>
    <tbody>
    <%for (DogDTO dogDTO : list) {%>
    <tr width="20">
        <td><%=dogDTO.getId()%>
        </td>
        <td><%=dogDTO.getName()%>
        </td>
        <td><%=dogDTO.getType()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>

<% Integer dogsCount = (Integer) request.getAttribute("dogsCount");
    Integer currentPage = (Integer) request.getAttribute("currentPage");
    Integer pagesCount = dogsCount / DOGS_PER_PAGE;
    if (dogsCount % DOGS_PER_PAGE != 0) {
        pagesCount += 1;
    }
    Integer maxPage = currentPage + 3;
    if (pagesCount - currentPage < 3) {
        maxPage = pagesCount;
    }

    Integer minPage = currentPage - 3;
    if (currentPage - 3 < 1) {
        minPage = 1;
    }
    for (long i = minPage; i < maxPage + 1; i++) {
%>
<a href="<%=request.getContextPath()%>/ShowDogList?currentPage=<%=i%>"><%if (i == currentPage) {%><big><%=i%>
</big><%} else {%><%=i%><%}%></a>&nbsp
<%}%>
</body>
</html>