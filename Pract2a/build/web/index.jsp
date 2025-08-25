<!DOCTYPE html>
<html>
<head>
    <title>Password Validation</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="ValidateServlet" method="post">
        Enter Password: <input type="password" name="password" />
        <input type="submit" value="Login" />
    </form>

    <p style="color:red;">
        ${errorMsg}
    </p>
</body>
</html>
