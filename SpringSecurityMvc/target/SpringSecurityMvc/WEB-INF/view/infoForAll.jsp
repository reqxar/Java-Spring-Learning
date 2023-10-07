<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: reqxar
  Date: 27.09.2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>infoForAll</title>
</head>
<body>
<h1>infoForAll</h1>
<br>
<security:authorize access="hasRole('HR')">
<input type="button" value="HR roles" onclick="window.location.href='/hr-info'">Only for HR roles
<br/><br/>
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
<input type="button" value="MANAGER roles" onclick="window.location.href='manager-info'">Only for MANAGER roles
</security:authorize>

</body>
</html>
