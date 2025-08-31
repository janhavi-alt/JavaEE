import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/nonBlockingServlet", asyncSupported = true)
public class NonBlockingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Start async mode
        AsyncContext asyncContext = request.startAsync();
        ServletInputStream input = request.getInputStream();

        input.setReadListener(new ReadListener() {
            private StringBuilder buffer = new StringBuilder();

            @Override
            public void onDataAvailable() throws IOException {
                byte[] b = new byte[1024];
                int len;
                while (input.isReady() && (len = input.read(b)) != -1) {
                    buffer.append(new String(b, 0, len, StandardCharsets.UTF_8));
                }
            }

            @Override
            public void onAllDataRead() throws IOException {
                HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
                resp.setContentType("text/plain");
                resp.getWriter().write("Data received (Non-Blocking):\n");
                resp.getWriter().write(buffer.toString());
                asyncContext.complete(); // must end async
            }

            @Override
            public void onError(Throwable t) {
                try {
                    HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
                    resp.getWriter().write("Error: " + t.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    asyncContext.complete();
                }
            }
        });
    }
}
