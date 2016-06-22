<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="company" scope="request" class="models.entities.Company" />

<c:url value="UpdateCompany" var="url">
    <c:param name="companyId" value="${company.id}"/>
</c:url>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="assets/bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">
        
        <script src="assets/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="assets/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        
        <title>DOR</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>  Editar nstituição</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <%@ include file="messageLabel.jsp" %>
        <!-- Form -->
        <div class="form">
            <form action="${url}" method="POST" role="form">
                <div class="form-group">


                    <label>Nome:</label>
                    <input type="text" class="form-control" placeholder="Nome" value="${fn:escapeXml(company.name)}" name="name"/>
                </div>
                <div class="form-group">
                    <label>Token:</label>
                    <div class="input-group">
                        <input id="token" type="text" class="form-control" placeholder="Token." value="${fn:escapeXml(company.token)}" name="token" aria-describedby="basic-addon1">
                        <span class="input-group-btn">
                            <button id="generateToken" class="btn btn-warning" type="button">Gerar Token</button>
                        </span>
                    </div>
                </div>
                <div>
                    <%@ include file="errorMessages.jsp" %>
                    <button type="submit" class="btn btn-info">Salvar</button>
                    <a href="ListCompanies"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
                <script type="text/javascript" src="js/validation.js"></script>
            </form>
        </div>
    </body>
</html>
