<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="admin" scope="request" class="models.entities.Admin" />

<c:url value="UpdateAdmin" var="url">
    <c:param name="adminId" value="${admin.id}"/>
</c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">
        <script src="bootstrap-3.3.6-dist/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>   Editar Administrador</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <%@ include file="messageLabel.jsp" %>
        <!-- Form -->
        <div class="form">
            <form action="${url}" method="POST" role="form">
                <div class="form-group">
                    <label>Nome:</label>
                    <input type="text" class="form-control" value="${fn:escapeXml(admin.name)}" placeholder="Nome" name="name"/>
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" class="form-control" value="${fn:escapeXml(admin.email)}"placeholder="Email" name="email"/>
                </div>
                <div class="form-group">
                    <label>Senha Antiga:</label>
                    <input type="password" class="form-control" placeholder="Senha Antiga" name="oldPassword"/>
                </div>
                <div class="form-group">
                    <label>Nova Senha:</label>
                    <input type="password" class="form-control" placeholder="Nova Senha" name="newPassword"/>
                </div>
                <div class="form-group">
                    <label>Confirmar Senha:</label>
                    <input type="password" class="form-control" placeholder="Confirmar senha" name="passwordConfirmation"/>
                </div>
                <div>
                    <%@ include file="errorMessages.jsp" %>
                    <button type="submit" class="btn btn-info">Salvar</button>
                    <a href="ListAdmins"><button type="button" class="btn btn-danger">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
