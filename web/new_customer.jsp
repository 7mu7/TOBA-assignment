<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<section>
New customer
<form action="NewCustomerServlet" method="post">
<input type="hidden" name="action" value="register">
First Name
<input type="text" name="firstName">
Last Name
<input type="text" name="lastName" >
Phone
<input type="text" name="phone" >
Address
<input type="text" name="address">
City
<input type="text" name="city">
State
<input type="text" name="state">
Zip Code
<input type="text" name="zipCode">
E-mail
<input type="email" name="email">
<input type="submit" value="Sign up">
<p><i>${message}</i></p>
</form>
</section>
<c:import url="includes/footer.jsp" />