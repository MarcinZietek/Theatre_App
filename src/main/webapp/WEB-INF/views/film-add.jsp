<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 14.04.2022
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Film add page</title>
</head>
<body>

<form:form method="post"
           action="${pageContext.request.contextPath}/managers/films/add" modelAttribute="film">
  <p>Podaj tytuł filmu: <form:input path="name"/></p>
  <form:errors path="name"/>
  <p>Podaj długość filmu: <form:input path="lengthMin"/></p>
  <form:errors path="lengthMin"/>
  <p>Podaj opis filmu: <form:input path="description"/></p>
  <form:errors path="description"/>
  <br/>
  <input type="submit" value="Save">
</form:form>

</body>
</html>
