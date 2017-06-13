package com.verint.romannumerals;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RomanNumeralServlet")
public class RomanNumeralServlet extends HttpServlet {

    private static final long serialVersionUID = 490891425236113725L;
    private static final Logger LOGGER = Logger.getLogger(RomanNumeralServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String arabicString = request.getParameter("arabic");
        String message = "null";
        if (arabicString != null) {
            arabicString = arabicString.trim();
            if (arabicString.length() > 0) {
                try {
                    int arabic = Integer.parseInt(arabicString);
                    message = RomanNumeralConverter.convertToRoman(arabic);
                } catch (NumberFormatException | ArabicNumberOutOfBoundsException e) {
                    LOGGER.log(Level.FINE, e.toString(), e);
                    message = "NaN";
                }
            }
        }
        sendResponse(response, message);
    }

    private void sendResponse(HttpServletResponse response, String message) {
        try {
            response.setContentType("text/plain");
            response.getWriter().write(message);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
