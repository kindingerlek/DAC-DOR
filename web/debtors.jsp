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
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="main.css">
        <script src="bootstrap-3.3.6-dist/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <title>DOR</title>
    </head>
    <body>
        <!-- Header -->
        <div class="header">
            <span class="title">DOR <small>- Devedores Originalmente Regulares</small></span>
            <span class="log-out"><a href="LogoutProcess"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></span>
            <span class="welcome">Bem vindo, Razer!</span>
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
                        <li class="active"><a href="debtors.jsp">Devedores <span class="sr-only">(atual)</span></a></li>
                        <li><a href="companies.jsp">Instituições</a></li>
                        <li><a href="admins.jsp">Administradores</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Section Header -->
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>    Devedores</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">

                    <a href="addDebtor.jsp"><button type="button" class="btn btn-info navbar-btn">Adicionar</button></a>
                    <form class="navbar-form navbar-right" role="search" action="ListDebtors" method="POST">
                        <div class="form-group">
                            <select name="type" class="form-control">
                                <option value="name">Nome</option>
                                <option value="identifier">Identificador</option>
                            </select> 
                            <input name="pattern" type="text" class="form-control" placeholder="...">
                        </div>
                        <button type="submit" class="btn btn-info">Procurar</button>
                    </form>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Table -->
        <table class="table table-hover my-table">
            <thead>
                <tr>
                    <td><b>#</b></td>
                    <td><b>Nome</b></td>
                    <td><b>CPF/CNPJ</b></td>
                    <td><b>Situação</b></td>
                    <td><b>Visualizar</b></td>
                </tr>
            </thead>

            <tbody>
                <c:set var="index" value="${1}" scope="page"/>
                <c:set var="debtors" scope="session" value="${debtorsList}"/>
                <c:forEach items="${debtorsList}" var="debtor">

                    <tr>
                        <td><c:out value="${index}" /></td>
                        <td><c:out value="${debtor.name}" /></td>
                        <td><c:out value="${debtor.identifier}" /></td>
                        <td><c:out value="${debtor.indebted}" /></td>
                        <td>
                            
                            <c:url value="GetDebtor" var="url">
                                <c:param name="debtorId" value="${debtor.id}"/>
                            </c:url>
                            <a href="${url}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
                            </td>
                        </tr>
                        <c:set var="index" value="${index+1}" scope="page"/>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
