<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language Demo</title>
</head>
<body>
    <h2>JSP Expression Language (EL) Example</h2>

    <!-- Reading request parameter directly -->
    <p>Hello, ${param.name}!</p>

    <!-- Accessing request, session, and application attributes -->
    <%
        request.setAttribute("course", "Web Technology");
        session.setAttribute("username", "JohnDoe");
        application.setAttribute("college", "ABC Institute");
    %>

    <p>Course (from request scope): ${course}</p>
    <p>Username (from session scope): ${username}</p>
    <p>College (from application scope): ${college}</p>

    <!-- Arithmetic operation using EL -->
    <p>10 + 20 = ${10 + 20}</p>

    <!-- Relational operator -->
    <p>Is 100 greater than 50? ${100 gt 50}</p>

    <!-- Conditional operator -->
    <p>Welcome message: ${username == 'JohnDoe' ? 'Hello John!' : 'Hello Guest!'}</p>

    <!-- Accessing header -->
    <p>User Agent: ${header["user-agent"]}</p>
</body>
</html>
