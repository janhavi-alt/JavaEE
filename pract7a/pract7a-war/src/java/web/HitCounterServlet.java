package web;

import ejb.HitCounterBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HitCounterServlet extends HttpServlet {

    @EJB
    private HitCounterBean hitCounterBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int hits = hitCounterBean.incrementAndGet();

        out.println("<html><body>");
        out.println("<h2>Servlet Hit Counter using Singleton EJB</h2>");
        out.println("<p>This servlet has been accessed <b>" + hits + "</b> times.</p>");
        out.println("</body></html>");
    }
}
