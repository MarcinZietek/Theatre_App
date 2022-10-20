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
<sec:authorize access="hasRole('ADMIN')">
    MAM ROLE ADMIN
</sec:authorize>
<br>
<p>To jest strona administratora sytemu</p>
<hr>
<a href="${pageContext.request.contextPath}/">Powrót na stronę główną</a>
</body>
</html>
