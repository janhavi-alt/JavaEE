import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class QAServlet extends HttpServlet {
    Connection con;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/qadb", "root", "root"); // change pass if needed
        } catch (Exception e) { e.printStackTrace(); }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String q = req.getParameter("question");
        String a = req.getParameter("answer");
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO qa(question, answer) VALUES(?,?)");
            ps.setString(1, q);
            ps.setString(2, a);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        res.sendRedirect("QAServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Saved Q&A</h2><table border=1><tr><th>Question</th><th>Answer</th></tr>");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT question, answer FROM qa");
            while (rs.next()) {
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
            }
        } catch (Exception e) { e.printStackTrace(); }
        out.println("</table><br><a href='index.html'>Add New</a>");
    }
}
