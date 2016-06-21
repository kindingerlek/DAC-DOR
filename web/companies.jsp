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
        <%@ include file="header.jsp" %>  
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>    Institições</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">

                    <a href="addCompany.jsp"><button type="button" class="btn btn-info navbar-btn">Adicionar</button></a>
                    <form class="navbar-form navbar-right" role="search" action="ListCompanies?type=name" method="POST">

                        <span>Nome:</span>
                        <div class="form-group">
                            <input type="text" name="pattern" class="form-control" placeholder="...">
                        </div>
                        <button type="submit" class="btn btn-info">Procurar</button>
                    </form>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <%@ include file="messageLabel.jsp" %>
        <!-- Table -->
        <table class="table table-hover my-table">
            <thead>
                <tr>
                    <td><b>#</b></td>
                    <td><b>Nome</b></td>
                    <td><b>Token</b></td>
                    <td><b>Ações</b></td>
                </tr>
            </thead>

            <tbody>
                <c:set var="index" value="${1}" scope="page"/>
       
                <c:forEach items="${companiesList}" var="company">
                    <tr>
                        <td><c:out value="${index}" /></td>
                        <td><c:out value="${company.name}" /></td>
                        <td><c:out value="${company.token}" /></td>                     
                        <td>
                            <c:url value="GetCompany" var="url">
                                <c:param name="companyId" value="${company.id}"/>
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
