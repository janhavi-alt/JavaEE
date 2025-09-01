<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL Result</title>
</head>
<body>
    <h2>JSTL Example Output</h2>

    <!-- Catch request parameters -->
    <c:set var="user" value="${param.username}" />
    <c:set var="number" value="${param.num}" />

    <!-- If/Choose condition -->
    <c:if test="${not empty user}">
        <p>Hello, <b>${user}</b>!</p>
    </c:if>

    <c:choose>
        <c:when test="${number % 2 == 0}">
            <p>The number <b>${number}</b> is Even.</p>
        </c:when>
        <c:otherwise>
            <p>The number <b>${number}</b> is Odd.</p>
        </c:otherwise>
    </c:choose>

    <!-- Loop example -->
    <h3>Numbers from 1 to ${number}:</h3>
    <ul>
        <c:forEach var="i" begin="1" end="${number}">
            <li>${i}</li>
        </c:forEach>
    </ul>

</body>
</html>
