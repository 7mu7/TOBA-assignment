<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.html" />
<session>
Reset Password
<form action="ResetPasswordServlet" method="post">
<input type="hidden" name="action" value="resetPassword">
Username:
<input type="text" name="username" value="${user.username}" required>
New Password:
<input type="password" name="newPassword" required>
Confirm New Password:
<input type="password" name="confirmPassword" required>
<input type="submit" value="Reset Password">
</form>
<p><i>${message}</i></p>
</session>
<c:import url="includes/footer.jsp" />
