<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="debtor" scope="request" class="models.entities.Debtor" />

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
                        <li><a href="debtors.jsp">Devedores</a></li>
                        <li><a href="companies.jsp">Instituições</a></li>
                        <li><a href="admins.jsp">Administradores</span></a></li>
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>   Editar Devedor</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <!-- Form -->
        <div class="form">
            <form action="LoginProcess" method="POST" role="form">
                <div class="form-inline">
                    <label>Situação:</label>
                    <c:if test="{debtor.indebt}">
                        <span>Irregular</span>
                    </c:if>
                    <c:if test="{!debtor.indebt}">
                        <span>Regular</span>
                    </c:if>
                </div>
                <div class="form-group">   
                    <label>Nome:</label>
                    <input type="text" class="form-control" placeholder="Nome" name="name" value="${fn:escapeXml(debtor.name)}"/> 
                    
                </div>
                <div class="form-group">
                    <label>Identificador:</label>
                    <div class="form-inline radio-button">
                        <div class="radio radio-button">
                            <label>
                                <input type="radio" name="identifier" value="cpf">
                                CPF
                            </label>
                        </div>
                        <div class="radio radio-button">
                            <label>
                                <input type="radio" name="identifier" value="cnpj">
                                CNPJ
                            </label>
                        </div>
                    </div>
                    <input type="text" class="form-control" placeholder="Identificador" value="${fn:escapeXml(debtor.identifier)}"  name="identifier"/>
                </div>
                <label>Instituição: </label>
                <div class="form-group intitution-debtor">
                    <div class="form-inline add-company-combo">
                        <button type="submit" class="btn btn-warning btn-debtor">Gerar Relatório</button>
                        <select class="form-control">
                            <option value="name">VSF</option>
                            <option value="email">DOR</option>
                        </select>
                        <button type="submit" class="btn btn-info btn-debtor">Adicionar</button>
                    </div>
                    <div class="debtor-table">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <td><b>#</b></td>
                                    <td><b>Instituição</b></td>
                                    <td><b>Situação</b></td>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${debtor.situationCompanies}" var="company">
                                <tr>
                                    <td><c:out value="${fn:escapeXml(company.id)}"/></td>
                                    <td><c:out value="${fn:escapeXml(company.name)}"/></td>
                                    <td>
                                        <input type="radio" name="option" value="regular">Regular</input>
                                        <input type="radio" name="option" value="irregular">Irregular</input>
                                    </td>
                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
                <label>Histórico: </label>
                <div class="form-group intitution-debtor">
                    <button type="submit" class="btn btn-warning btn-debtor">Gerar Relatório</button>
                    <hr>
                    <div class="debtor-table">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <td><b>#</b></td>
                                    <td><b>Instituição</b></td>
                                    <td><b>Situação</b></td>
                                    <td><b>Data</b></td>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>VSF</td>
                                    <td>Irregular</td>
                                    <td>10/10/10<td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-info">Salvar</button>
                    <a href="debtors.jsp"><button type="button" class="btn btn-danger" id="botao-do-capeta">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
