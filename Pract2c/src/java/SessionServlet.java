import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession();

        // Check if it's a new session
        if (session.isNew()) {
            out.println("<h2>Welcome! This is your first visit.</h2>");
            session.setAttribute("visitCount", 1); // start counting visits
        } else {
            Integer count = (Integer) session.getAttribute("visitCount");
            if (count == null) count = 0;
            count++;
            session.setAttribute("visitCount", count);

            out.println("<h2>Welcome back! You have visited this page " + count + " times.</h2>");
        }

        // Display session details
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Session Creation Time: " + new java.util.Date(session.getCreationTime()) + "</p>");
        out.println("<p>Last Accessed Time: " + new java.util.Date(session.getLastAccessedTime()) + "</p>");

        // Option to destroy the session
        out.println("<form action='' method='post'>");
        out.println("<input type='submit' value='Logout (Destroy Session)'>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); // don't create new if not exists
        if (session != null) {
            session.invalidate(); // destroy session
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Session destroyed. Please refresh to create a new session.</h2>");
    }
}
