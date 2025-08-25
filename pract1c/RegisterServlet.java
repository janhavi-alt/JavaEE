import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "root"; // your DB username
    private static final String DB_PASS = "";     // your DB password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form values
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/userdb", "root", "root");


            // Insert query
            String sql = "INSERT INTO users (username, password, email, country) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, country);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Registration successful!</h2>");
            } else {
                out.println("<h2>Registration failed.</h2>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }