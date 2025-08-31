<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Details</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String ageStr = request.getParameter("age");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String[] hobbies = request.getParameterValues("hobbies");

    boolean valid = true;
    String errorMsg = "";

    // Validation
    if(name == null || name.trim().equals("")) {
        valid = false;
        errorMsg += "Name is required.<br>";
    }
    int age = 0;
    try {
        age = Integer.parseInt(ageStr);
        if(age <= 0) {
            valid = false;
            errorMsg += "Age must be greater than 0.<br>";
        }
    } catch(Exception e) {
        valid = false;
        errorMsg += "Age must be a number.<br>";
    }

    if(email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        valid = false;
        errorMsg += "Invalid email format.<br>";
    }

    if(gender == null) {
        valid = false;
        errorMsg += "Please select gender.<br>";
    }

    if(hobbies == null || hobbies.length == 0) {
        valid = false;
        errorMsg += "Please select at least one hobby.<br>";
    }

    if(valid) {
%>
        <h2>Details Entered</h2>
        <b>Name:</b> <%= name %><br>
        <b>Age:</b> <%= age %><br>
        <b>Email:</b> <%= email %><br>
        <b>Gender:</b> <%= gender %><br>
        <b>Hobbies:</b>
        <ul>
            <% for(String h : hobbies) { %>
                <li><%= h %></li>
            <% } %>
        </ul>
<%
    } else {
%>
        <h2 style="color:red;">Validation Errors</h2>
        <%= errorMsg %>
        <br><a href="index.jsp">Go Back</a>
<%
    }
%>
</body>
</html>
