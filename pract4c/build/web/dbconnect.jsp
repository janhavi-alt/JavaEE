<%@ page import="java.sql.*" %>
<%
    String url = "jdbc:mysql://localhost:3306/userdb";
    String user = "root";     // change as per your MySQL
    String pass = "root";     // change as per your MySQL

    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
    } catch(Exception e) {
        out.println("Database connection error: " + e);
    }
%>
