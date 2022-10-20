<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 09.04.2022
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
</head>
<body>
<%-- Check for login error --%>
<c:if test="${param.error != null}">
    <i class="failed">Sorry! You entered invalid username/password.</i>
</c:if>
<c:if test="${param.logout != null}">
    <i class="logout">You have been logout correctly</i>
</c:if>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <br>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <br>
    <div><input type="submit" value="Sign In"/></div>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
</form:form>

</body>
</html>
