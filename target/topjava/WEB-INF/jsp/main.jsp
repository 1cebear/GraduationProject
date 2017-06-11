<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages.app"/>

<html>
<body>

<section>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${menus}" var="menu">
            <jsp:useBean id="menu" scope="page" type="ru.gradproject.topjava.model.Menu"/>
            <tr>
                <td><c:out value="${menu.name}"/></td>
                <td><c:out value="${menu.menuDate}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>

<br><br><br>
<section>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${dishes}" var="dish">
            <jsp:useBean id="dish" scope="page" type="ru.gradproject.topjava.model.Dish"/>
            <tr>
                <td><c:out value="${dish.name}"/></td>
                <td><c:out value="${dish.price}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>