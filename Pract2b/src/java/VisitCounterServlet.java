import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0;

        // Get cookies from request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    // Retrieve the old count
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        // Increment the count
        visitCount++;

        // Store updated count back into a cookie
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24); 
        response.addCookie(visitCookie);

        // Display result
        out.println("<html><body>");
        out.println("<h2>Welcome to the Visit Counter Servlet</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");
        out.println("</body></html>");
    }
}
