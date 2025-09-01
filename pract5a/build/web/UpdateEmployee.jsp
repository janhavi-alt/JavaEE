<%@ page import="java.sql.*" %>
<%
    // Fetch form data
    String eno = request.getParameter("eno");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String desg = request.getParameter("desg");
    String salary = request.getParameter("salary");

    Connection con = null;
    PreparedStatement ps = null;

    try {
        // Load driver (example for MySQL)
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/yourDB", "root", "root");

        // Update query
        String query = "UPDATE employee SET name=?, age=?, desg=?, salary=? WHERE eno=?";
        ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, Integer.parseInt(age));
        ps.setString(3, desg);
        ps.setDouble(4, Double.parseDouble(salary));
        ps.setInt(5, Integer.parseInt(eno));

        int i = ps.executeUpdate();

        if (i > 0) {
            out.println("<h3>Employee record updated successfully!</h3>");
        } else {
            out.println("<h3>No record found with Employee No: " + eno + "</h3>");
        }

    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        try { if (ps != null) ps.close(); } catch(Exception ex){}
        try { if (con != null) con.close(); } catch(Exception ex){}
    }
%>
