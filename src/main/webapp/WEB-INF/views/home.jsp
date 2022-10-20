<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 12.04.2022
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<p>Welcome to home page</p>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>

<sec:authorize access="hasRole ('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/admins">Admins page</a>
    (Admin's page)
</p>
</sec:authorize>
<br>
<sec:authorize access="hasRole ('MANAGER')">
<p>
    <a href="${pageContext.request.contextPath}/managers">Managers page</a>
    (Manager's page)
</p>
</sec:authorize>
<br>
<sec:authorize access="hasRole('USER')">
    <p>
        <a href="${pageContext.request.contextPath}/customers">Customers page</a>
        (Manager's page)
    </p>
</sec:authorize>
<hr>
<%-- Add a logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Wyloguj"/>
</form:form>

</body>
</html>
