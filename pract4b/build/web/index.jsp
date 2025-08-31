<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>Enter Your Details</h2>
    <form action="display.jsp" method="post">
        Name: <input type="text" name="name"><br><br>
        Age: <input type="text" name="age"><br><br>
        Email: <input type="text" name="email"><br><br>

        Gender: 
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female <br><br>

        Hobbies:<br>
        <input type="checkbox" name="hobbies" value="Reading"> Reading
        <input type="checkbox" name="hobbies" value="Sports"> Sports
        <input type="checkbox" name="hobbies" value="Music"> Music
        <input type="checkbox" name="hobbies" value="Travel"> Travel
        <br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
