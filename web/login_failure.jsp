<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<section>
    Login Failed
    <form class="formButton" action="login.jsp" method="get">
        <input type="submit" value="Login">
    </form>
    <form class="formButton" action="new_customer.jsp" method="get">
        <input type="submit" value="Register">
    </form>
</section>
<c:import url="includes/footer.jsp" />