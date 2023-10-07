<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: reqxar
  Date: 18.09.2023
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все сотрудники</title>
</head>
<body>
    <h1>На этой странице приведен полный список сотрудников</h1>
    <br>
    <button type="button" onclick="window.location.href='/createNewEmployee'">Создать нового сотрудника</button>
    <br>
    <br>

    <table>
        <tr>
            <td>Имя</td>
            <td>Фамилия</td>
            <td>Доход</td>
            <td>Операции</td>
        </tr>


        <c:forEach var="emp" items="${allEmployees}">

            <c:url var="updateButton" value="/updateEmployee">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>

            <tr>
                <td>${emp.name}</td>
                <td>${emp.surName}</td>
                <td>${emp.salary}</td>
                <td><input type="button" value="Изменить" onclick="window.location.href='${updateButton}'"></td>
                <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
