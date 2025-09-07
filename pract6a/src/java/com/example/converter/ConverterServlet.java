package com.example.converter;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/convert")
public class ConverterServlet extends HttpServlet {

    @EJB
    private CurrencyConverterBeanLocal converter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String amountStr = req.getParameter("amount");

        String error = null;
        BigDecimal result = null;

        try {
            BigDecimal amount = new BigDecimal(amountStr);
            result = converter.convert(from, to, amount);
        } catch (Exception e) {
            error = "Conversion failed: " + e.getMessage();
        }

        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("amount", amountStr);
        req.setAttribute("result", result);
        req.setAttribute("error", error);

        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
