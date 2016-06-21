<%-- 
    Document   : home
    Created on : 06/05/2016, 16:24:08
    Author     : Alisson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="debtor" scope="request" class="models.entities.Debtor" />

<c:url value="UpdateDebtor" var="url">
    <c:param name="debtorId" value="${debtor.id}"/>
</c:url>

<c:url value="ShowReport" var="DebtorLogReport">
    <c:param name="type" value="logDebtor"/>
    <c:param name="debtorId" value="${debtor.id}"/>
</c:url>

<c:url value="ShowReport" var="DebtorSituationReport">
    <c:param name="type" value="debtorSituation"/>
    <c:param name="debtorId" value="${debtor.id}"/>
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
                    <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>   Editar Devedor</a>
                </div>

            </div><!-- /.container-fluid -->
        </nav>
        <%@ include file="errorMessages.jsp" %>
        <%@ include file="messageLabel.jsp" %>
        <!-- Form -->
        <div class="form">

            <form  action="${url}" method="POST"  modelAttribute = "debtor" role="form">
                <div class="form-inline">
                    <label>Situação:</label>
                    <c:if test="${debtor.indebted}">
                        <span class="label label-danger">Irregular</span>
                    </c:if>
                    <c:if test="${!debtor.indebted}">
                        <span class="label label-success">Regular</span>
                    </c:if>
                </div>
                <div class="form-group">   
                    <label>Nome:</label>
                    <input name="debtor.name" type="text" class="form-control" placeholder="Nome" value="${fn:escapeXml(debtor.name)}"/> 

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
                    <input name="debtor.identifier" type="text" class="form-control" placeholder="Identificador" value="${fn:escapeXml(debtor.identifier)}"  />
                </div>
                <label>Instituição: </label>
                <div class="form-group intitution-debtor">
                    <a href="${DebtorSituationReport}" target="blank" class="btn btn-warning btn-debtor">Gerar Relatório</a>                        
                    <hr>
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
                                <c:set var="index" value="${1}"/>
                                <c:forEach items="${debtor.situationCompanies}" var="company">
                                    <tr>
                                        <td><c:out value="${index}"/></td>
                                        <td><c:out value="${fn:escapeXml(company.company.name)}"/></td>
                                        <td>
                                            <fieldset path="company.situation" id="option">
                                                <input type="radio" value="false" name="debtor.situationCompanies[${index}].indebt" ${!company.indebt? 'checked' : ''} >Regular</input>
                                                <input type="radio" value="true" name="debtor.situationCompanies[${index}].indebt" ${company.indebt? 'checked' : ''} >Irregular</input>
                                            </fieldset>
                                        </td>
                                    </tr>
                                    <c:set var="index" value="${index+1}" scope="page"/>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <label>Histórico: </label>
                <div class="form-group intitution-debtor">
                    <a href="${DebtorLogReport}" target="blank" class="btn btn-warning btn-debtor">Gerar Relatório</a>                     

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
                                <c:forEach items="${debtorCompanySituationLogs}" var="log">
                                    <tr>
                                        <td><c:out value="${index}"/></td>
                                        <td><c:out value="${fn:escapeXml(log.company.name)}"/></td>
                                        <td>
                                            <c:if test="${log.indebt}">
                                                <span class="label label-danger">Irregular</span>
                                            </c:if>
                                            <c:if test="${!log.indebt}">
                                                <span class="label label-success">Regular</span>
                                            </c:if>
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${log.logDate}" pattern="dd/MM/YYYY HH:mm"/>
                                        </td>
                                    </tr>
                                    <c:set var="index" value="${index+1}" scope="page"/>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <div>


                    <button type="submit" class="btn btn-info">Salvar</button>
                    <a href="ListDebtors"><button type="button" class="btn btn-danger" id="botao-do-capeta">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
