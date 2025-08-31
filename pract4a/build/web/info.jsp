<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>Intrinsic Objects Example</title>
</head>
<body>
    <h2>Values from Intrinsic Objects</h2>

    <% 
        // Request object
        String name = request.getParameter("uname");

        // Session object
        session.setAttribute("username", name);

        // Application object
        application.setAttribute("appMsg", "This message is stored in application scope");

        // Response object - set content type
        response.setContentType("text/html");

        // Out object - printing message
        out.println("<p><b>Welcome, " + name + "</b></p>");
    %>

    <p><b>Request Object:</b> Your name = <%= request.getParameter("uname") %></p>
    <p><b>Session Object:</b> Username stored in session = <%= session.getAttribute("username") %></p>
    <p><b>Application Object:</b> <%= application.getAttribute("appMsg") %></p>
    <p><b>Response Object:</b> Content type set = <%= response.getContentType() %></p>
    <p><b>Config Object:</b> JSP Page name = <%= config.getServletName() %></p>
    <p><b>Page Object:</b> JSP class = <%= page.getClass().getName() %></p>
    <p><b>PageContext Object:</b> Server info = <%= pageContext.getServletContext().getServerInfo() %></p>
    <p><b>Out Object:</b> Current time = <%= new Date() %></p>

</body>
</html>
