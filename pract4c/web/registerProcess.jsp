<%@ include file="dbconnect.jsp" %>
<%
    String uname = request.getParameter("username");
    String pwd = request.getParameter("password");

    try {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)");
        ps.setString(1, uname);
        ps.setString(2, pwd); // In real apps, hash the password
        int i = ps.executeUpdate();
        if(i > 0){
            out.println("<h3>Registration successful!</h3>");
            out.println("<a href='login.jsp'>Login Now</a>");
        } else {
            out.println("<h3>Registration failed. Try again.</h3>");
        }
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
