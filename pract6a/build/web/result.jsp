<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Result</title></head>
<body>
  <h2>Conversion Result</h2>
  <c:choose>
    <c:when test="${not empty error}">
      <p style="color:red;">${error}</p>
    </c:when>
    <c:otherwise>
      <p>${amount} ${from} = <strong>${result} ${to}</strong></p>
    </c:otherwise>
  </c:choose>
  <p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
