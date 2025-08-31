<%
    // If user already logged in, send to welcome page
    if (session.getAttribute("username") != null) {
        response.sendRedirect("welcome.jsp");
    } else {
        // Otherwise, send to login page
        response.sendRedirect("register.jsp");
    }
%>
