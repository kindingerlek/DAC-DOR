<%-- 
    Document   : index
    Created on : 05/05/2016, 15:31:01
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> DOR - Devedores Originalmente Regulares </title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="assets/bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">

        <script type="text/javascript" src="assets/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/jquery-2.2.4.min.js"></script>

    </head>
    <body>
        <div >
            <%@ include file="messageLabel.jsp" %>
            <div class="login-title">
                <h1>DOR</h1>
                <h4>Devedores Originalmente Regulares</h4>
            </div>

            <form action="LoginProcess" method="POST" role="form">
                <div class="form-group login-form">
                    <div class="input-group login-input">
                        <span class="login-span input-group-addon">Email</span>
                        <input type="text" class="form-control email" placeholder="Digite seu email." name="email" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group login-input">
                        <span class="login-span input-group-addon">Senha</span>
                        <input type="password" class="form-control" placeholder="Digite sua senha." name="password" aria-describedby="basic-addon1">

                    </div>
                    <%@ include file="errorMessages.jsp" %>
                    <div class="error"></div>
                    <spam><a>Esqueci minha senha.</a></spam>
                    <span><button class="btn btn-default login-button submit-button" type="submit">Entrar</button></span>
                    
                </div>
                
            </form>
   <script type="text/javascript" src="js/validation.js"></script>

    </body>
</html>
