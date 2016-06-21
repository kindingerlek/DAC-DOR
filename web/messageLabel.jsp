<%-- 
    Document   : messageLabel
    Created on : 21/06/2016, 10:05:43
    Author     : Alisson
--%>


<c:if test="${!empty message}">
    <div class="alert alert-${message.type}" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>${message.title}</strong> ${message.body}
    </div>
    <br/>
    <c:set var="message" scope="session" value="${null}"/>
</c:if>