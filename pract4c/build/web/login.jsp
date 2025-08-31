<%@ include file="dbconnect.jsp" %>
<html>
<head><title>Login</title></head>
<body>
    <h2>User Login</h2>
    <form action="loginProcess.jsp" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
