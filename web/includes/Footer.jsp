<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<footer>
<p>&copy; Copyright <%= currentYear%> TOBA Online Banking Application<br>
</footer>
</body>
</html>
