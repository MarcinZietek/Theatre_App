<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 09.04.2022
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<head>
    <title>Security with Spring Boot</title>
</head>
<body>
<h1>Dostęp zabroniony</h1>
<h3>Nie posiadasz uprawnień do wejścia na tę stronę</h3>
<hr>
<a href="${pageContext.request.contextPath}/">Powrót na stronę główną</a>
</body>
</html>
