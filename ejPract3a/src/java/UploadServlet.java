import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("file"); // get file
        String fileName = filePart.getSubmittedFileName();

        // Save file to uploads folder inside webapp
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        filePart.write(uploadPath + File.separator + fileName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>File " + fileName + " uploaded successfully!</h3>");
        out.println("<a href='index.html'>Back</a>");
    }
}
