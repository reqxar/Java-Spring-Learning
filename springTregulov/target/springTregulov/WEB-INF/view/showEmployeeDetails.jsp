<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: reqxar
  Date: 14.09.2023
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отражение имени</title>
</head>
<body>

<p>Имя: ${Employee.name}</p>
<p>Фамилия: ${Employee.surName}</p>
<p>Доход: ${Employee.salary}</p>
<p>Номер телефона: ${Employee.phoneNumber}</p>
<p>Почтовый адрес: ${Employee.email}</p>
<p>Подразделение: ${Employee.department}</p>
<p>Модель машины: ${Employee.car}</p>
<p>Знание языков:</p>
<ul>
    <c:forEach var="lang" items="${Employee.languages}">
        ${lang}
    </c:forEach>
</ul>

</body>
</html>
