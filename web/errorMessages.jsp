<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty errorMessages}">
    <div class="alert alert-danger" role="alert">
        <c:forEach var="errorMessage" items="${errorMessages}">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <c:out value="${errorMessage}"/><p>
        </c:forEach>
    </div>
        <c:set var="errorMessages" scope="session" value="${null}"/>
</c:if>
