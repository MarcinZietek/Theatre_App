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
<h2>You are on customers page</h2>
<sec:authorize access="hasRole('USER')">
    MAM ROLE KLIENTA
</sec:authorize>
<br>
<p>To jest strona kilentów aplikacji</p>
<hr>
<a href="${pageContext.request.contextPath}/home">Powrót na stronę główną</a>
</body>
</html>
