package testcart;

import cart.CartBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CartTestServlet", urlPatterns = {"/CartTestServlet"})
public class CartTestServlet extends HttpServlet {

    @EJB
    private CartBeanLocal cartBean;  // EJB injection (no need for manual JNDI lookup)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            cartBean.initialize("ABC", "123");
            cartBean.addBook("Java 8 Cookbook");
            cartBean.addBook("Enterprise Java 7");
            cartBean.addBook("Java for Dummies");
            cartBean.addBook("Learn Java 8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter()) {
            try {
                List<String> books = cartBean.getContents();
                out.println("<h2>Books in Cart:</h2>");
                for (String s : books) {
                    out.println(s + "<br/>");
                }
            } catch (Exception e) {
                out.println("Error retrieving cart contents: " + e.getMessage());
            }
        }
    }
}
