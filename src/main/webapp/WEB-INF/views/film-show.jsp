<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 14.04.2022
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Film List</title>
</head>
<body>
<table border="1">
    <thead>
    <th>title</th>
    <th>length</th>
    <th>description</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${film.name}"/></td>
        <td><c:out value="${film.lengthMin}"/></td>
        <td><c:out value="${film.description}"/></td>
    </tr>
    </tbody>
</table>
<br/>
<a href="/managers/films/all">Wróć do strony głównej</a>
</body>
</html>
