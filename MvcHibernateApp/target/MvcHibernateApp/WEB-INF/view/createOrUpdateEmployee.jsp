<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: reqxar
  Date: 18.09.2023
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание нового сотрудника</title>
</head>
<body>
<form:form action="saveOrUpdateEmployee" modelAttribute="employee" method="get">

    <form:hidden path="id"/>

    Имя <form:input path="name"/>
    <br>
    Фамилия <form:input path="surName"/>
    <br>
    Доход <form:input path="salary"/>
    <br>

    <input type="submit" value="Сохранить">
</form:form>
</body>
</html>
