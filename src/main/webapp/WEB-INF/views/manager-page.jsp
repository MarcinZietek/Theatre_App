<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 11.04.2022
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h2>You are on admins page</h2>
<sec:authorize access="hasRole('MANAGER')">
    MAM ROLE MANAGERA
</sec:authorize>
<br>
h3>Operacje CRUD na filmach</h3>
<hr>
<a href="${pageContext.request.contextPath}/managers/films/all">Wyświetl listę filmów</a>
<br>
<a href="${pageContext.request.contextPath}/home">Powrót na stronę główną</a>
</body>
</html>
