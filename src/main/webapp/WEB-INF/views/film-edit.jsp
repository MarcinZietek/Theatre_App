<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 14.04.2022
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>
<c:url var="edit_url" value="/managers/films/edit"/>
<form:form method="post" modelAttribute="film" action="${edit_url}">
    <form:hidden path="id"/>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <form:input path="lengthMin"/>
    <form:errors path="lengthMin"/><br/>
    <form:input path="description"/>
    <form:errors path="description"/><br/>

    <input type="submit" value="Save">
</form:form>

</body>
</html>