<%@ page import="com.verint.romannumerals.RomanNumeralConverter"
    language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roman Numeral Converter</title>
</head>
<body>
    <h2>Roman Numeral Converter</h2>
    <form action="index.jsp" method="get">
        Enter a number: <input type="text" name="arabic"> <input
            type="submit" value="Submit"><br>
        <br>
    </form>
    <%
        try {
            String arabicString = request.getParameter("arabic");
            if (arabicString != null && arabicString.length() > 0) {
                int arabic = Integer.parseInt(arabicString);
                out.println(
                        arabicString + " as a Roman numeral is: " + RomanNumeralConverter.convertToRoman(arabic));
            }
        } catch (NumberFormatException e) {
            out.println("<font color=\"red\">Please enter a number.</font>");
        }
    %>
</body>
</html>