<%@ include file="dbconnect.jsp" %>
<%
    String uname = request.getParameter("username");
    String pwd = request.getParameter("password");

    try {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, uname);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            session.setAttribute("username", uname);
            response.sendRedirect("welcome.jsp");
        } else {
            out.println("<h3>Invalid username or password</h3>");
            out.println("<a href='login.jsp'>Try Again</a>");
        }
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
