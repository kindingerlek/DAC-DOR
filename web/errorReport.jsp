<%-- 
    Document   : errorReport
    Created on : 10/05/2016, 14:31:41
    Author     : Alisson
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de erro</title>
    </head>
    <body>
        <h1>${requestScope.errorMessage}</h1>
        <a href="index.jsp">Voltar para página de login</a>
    </body>
</html>
