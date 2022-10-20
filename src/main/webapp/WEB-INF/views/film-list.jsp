<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 13.04.2022
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Film List</title>
</head>
<body>
<sec:authorize access="hasRole('MANAGER')">
    MAM ROLE MANAGERA
</sec:authorize>
<hr>
<a href="<c:url value="/managers/films/add"/>">Dodaj</a>
<table border="1">
    <thead>
    <th>title</th>
    <th>length</th>
    <th>description</th>
    </thead>
    <tbody>
    <c:forEach items="${films}" var="film">
        <tr>
            <td><c:out value="${film.name}"/></td>
            <td><c:out value="${film.lengthMin}"/></td>
            <td><c:out value="${film.description}"/></td>
            <td>
                <a href="<c:out value="/managers/films/edit/${film.id}"/>">Edytuj</a>
                <a href="<c:out value="/managers/films/delete/${film.id}"/>">Usuń</a>
                <a href="<c:out value="/managers/films/show/${film.id}"/>">Pokaż</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<a href="${pageContext.request.contextPath}/home">Powrót na stronę główną</a>
</body>
</html>


