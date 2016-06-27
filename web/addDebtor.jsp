<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="assets/bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">

        <script src="assets/jquery-2.2.4.min.js"></script>
        <script src="assets/jquery.maskedinput.js" type="text/javascript"></script>
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>   Inserir Devedor</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Form -->
        <div class="form">
            <form action="AddDebtor" method="POST" role="form">
                <div class="form-group">
                    <label>Nome:</label>
                    <input type="text" class="form-control" placeholder="Nome" name="name" required/>
                </div>
                <div class="form-group">
                    <label>Identificador:</label>
                    <div class="form-inline radio-button">
                        <div class="radio radio-button">
                            <label>
                                <input type="radio" id="identifierType" name="identifierType" value="cpf" checked="checked">
                                CPF
                            </label>
                        </div>
                        <div class="radio radio-button">
                            <label>
                                <input type="radio" id="identifierType" name="identifierType" value="cnpj">
                                CNPJ
                            </label>
                        </div>
                    </div>
                    <input type="text" id="identifier" class="form-control" placeholder="Identificador" name="identifier" required/>

                </div>
                <div>
                    <%@ include file="errorMessages.jsp" %>
                    <div class="error"></div>
                    <div>

                        <button type="submit" class="btn btn-info submit-button">Adicionar</button>
                        <a href="ListDebtors"><button type="button" class="btn btn-danger">Cancelar</button></a>
                    </div>

            </form>
            <script src="js/maskValidation.js" type="text/javascript"></script>
            <script type="text/javascript" src="js/validation.js"></script>
        </div>
    </body>
</html>
