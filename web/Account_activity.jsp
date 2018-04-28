<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/Header.html" />
<c:if test="${sessionScope.user != null}">
Welcome ${user.firstName} ${user.lastName}!
</c:if>
<c:if test="${sessionScope.user == null}">
Not Logged In
</c:if>
<c:import url="includes/footer.jsp" />