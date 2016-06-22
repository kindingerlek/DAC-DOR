<%-- 
    Document   : header
    Created on : 03/06/2016, 14:43:29
    Author     : Alisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Header -->
<div class="header">
    <span class="title">DOR <small>- Devedores Originalmente Regulares</small></span>
    <span class="log-out"><a href="LogoutProcess"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></span>
    <span class="welcome">Bem vindo, ${admin.name}</span>
</div>
<!-- Navbar -->
<nav class="navbar navbar-default menu">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Menu</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="ListDebtors">Devedores</a></li>
                <li><a href="ListCompanies">Instituições</a></li>
                <li><a href="ListAdmins">Administradores</span></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- Section Header -->
