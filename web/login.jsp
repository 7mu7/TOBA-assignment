<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/Header.html" />
<link rel="stylesheet" href="Css/Style.css">
<section>
    enter your username and password:
    <form action="LoginServlet" method="post">
        <input type="hidden" name="action" value="signin">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Sign in"></td>
            </tr>
        </table>
    </form>
</section>
<section>
    <p><a href="password_reset.jsp">Reset Password</a></p>
</section>
<c:import url="includes/footer.jsp" />