package web;

import ejb.RoomReservationBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ReservationServlet extends HttpServlet {

    @EJB
    private RoomReservationBean reservationBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String roomIdParam = request.getParameter("roomId");
        if (roomIdParam != null) {
            int roomId = Integer.parseInt(roomIdParam);
            String result = reservationBean.reserveRoom(roomId);
            out.println("<h2>" + result + "</h2>");
        } else {
            out.println("<h2>Please provide a roomId parameter in URL</h2>");
        }
    }
}
