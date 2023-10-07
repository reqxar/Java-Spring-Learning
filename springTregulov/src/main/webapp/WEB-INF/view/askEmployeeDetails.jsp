<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: reqxar
  Date: 14.09.2023
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <h2>Добро пожаловать!</h2>

    <br>
    <br>
    <br>

    <form:form action="showEmployeeDetails" modelAttribute="Employee">
        Имя <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>

        Фамилия <form:input path="surName"/>
        <form:errors path="surName"/>
        <br><br>

        Доход<form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>
        
        Номер телефона:
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
        <br><br>

        Почтовый адрес:
        <form:input path="email"/>
        <form:errors path="email"/>
        <br><br>

        Подразделение
        <form:select path="department">
            <form:options items="${Employee.departmentsList}"/>
        </form:select>
        <br><br>

        Предпочитаемая модель?
        <form:radiobuttons path="car" items="${Employee.carList}"/>
        <br><br>

        Какие языки вы знаете?
        <form:checkboxes path="languages" items="${Employee.languagesList}"/>
        <br><br>

        <br><br>
        <input type="submit" value="Сохранить">
    </form:form>

</body>
</html>
