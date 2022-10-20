<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 12.04.2022
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration form</title>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/register"
           modelAttribute="user"
           class="form-horizontal">
    <!-- Check for registration error -->
    <p><form:input path="username" placeholder="username"/> <%--class="form-control" />--%></p>
    <form:errors path="username" cssClass="error" class="failed"/>
    <p><form:password path="password" placeholder="password" class="form-control" /></p>
    <form:errors path="password" cssClass="error"/>
    <p><form:input path="firstName" placeholder="first name" class="form-control" /></p>
    <form:errors path="firstName" cssClass="error"/>
    <p><form:input path="lastName" placeholder="last name" class="form-control" /></p>
    <form:errors path="lastName" cssClass="error"/>
    <p><form:input path="email" placeholder="email" class="form-control" /></p>
    <form:errors path="email" cssClass="error"/>
    <br>
    <button type="submit" class="btn btn-primary">Register</button>
</form:form>
</body>
</html>
