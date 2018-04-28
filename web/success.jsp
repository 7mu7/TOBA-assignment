<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/Header.html" />
<link rel="stylesheet" href="Css/Style.css">
<section>
    You have successfully registered!
    <table>
        <tr>
            <td>First Name:</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${user.address}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${user.city}</td>
        </tr>
        <tr>
            <td>State:</td>
            <td>${user.state}</td>
        </tr>
        <tr>
            <td>Zip Code:</td>
            <td>${user.zipCode}</td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Here is your Username and Password</td>
        </tr>
        <tr>
            <td>Username:</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>${user.password}</td>
        </tr>
    </table>
    <form action="login.jsp" method="get">
        <input type="submit" value="Login">
    </form>
</section>
<c:import url="includes/footer.jsp" />