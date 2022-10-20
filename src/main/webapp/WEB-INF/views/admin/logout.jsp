<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 09.04.2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Logout page</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <form:form action="<c:url value=/logout" method="post">
        <input type="submit" value="Wyloguj">
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <form:form>
</sec:authorize>
</body>
</html>
