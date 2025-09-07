package web;

import ejb.VisitorStatBean;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;   // ✅ Use this instead of Inject
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitorServlet extends HttpServlet {

    @Resource(lookup = "jms/VisitorQueue")
    private Queue queue;

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @EJB   // ✅ Changed from @Inject to @EJB
    private VisitorStatBean visitorStatBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Send message to Queue
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, "New Visitor");
        }

        // Show updated count
        int count = visitorStatBean.getVisitorCount();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Visitor Statistics</h2>");
        out.println("<p>Total Visitors: " + count + "</p>");
    }
}
