<%@ include file="dbconnect.jsp" %>
<html>
<head><title>Register</title></head>
<body>
    <h2>User Registration</h2>
    <form action="registerProcess.jsp" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Register">
    </form>
    <p>Already registered? <a href="login.jsp">Login here</a></p>
</body>
</html>
