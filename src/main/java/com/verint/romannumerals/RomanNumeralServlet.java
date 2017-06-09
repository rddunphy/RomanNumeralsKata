package com.verint.romannumerals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RomanNumeralServlet")
public class RomanNumeralServlet extends HttpServlet {

    private static final long serialVersionUID = 490891425236113725L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String output = "";
        try {
            String arabicString = request.getParameter("arabic");
            if (arabicString != null) {
                arabicString = arabicString.trim();
                if (arabicString.length() > 0) {
                    int arabic = Integer.parseInt(arabicString);
                    output = "As a Roman numeral: " + RomanNumeralConverter.convertToRoman(arabic);

                }
            }
        } catch (NumberFormatException | ArabicNumberOutOfBoundsException e) {
            output = "Please enter a number between 1 and 3888.";
        }
        response.setContentType("text/plain");
        response.getWriter().write(output);
    }
}
