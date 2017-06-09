<%@ page
    import="com.verint.romannumerals.RomanNumeralConverter, com.verint.romannumerals.ArabicNumberOutOfBoundsException,java.io.*,java.util.*"
    language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roman Numeral Converter</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"
    type="text/javascript"></script>
<script src="js/roman_ajax.js" type="text/javascript"></script>
</head>
<body>
    <h2>Roman Numeral Converter</h2>
    <form>
        Enter a number: <input type="text" id="arabicInput" name="arabic"><br>
    </form>
    <p id="romanOutput"></p>
</body>
</html>