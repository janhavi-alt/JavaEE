package ValidateServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");

        if ("Servlet".equals(password)) {
            // Forward to WelcomeServlet if password is correct
            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
            rd.forward(request, response);
        } else {
            // Stay on index.html with error message
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);  // include index.html content

            out.println("<center><p style='color:red;'>Invalid Password! Try Again.</p></center>");
        }
    }
}



  