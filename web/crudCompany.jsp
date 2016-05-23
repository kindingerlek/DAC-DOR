<%-- 
    Document   : crudCompany
    Created on : 17/05/2016, 15:01:08
    Author     : Alisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Company</title>
    </head>
    <body>
        <form action="UpdateCompany" method="POST">
            id:<input type="number" name="idCompany"/><br/>
            Nome:<input type="text" name="name"/><br/>
            Token:<input type="text" name="token"/><br/>      
            <input type="submit" value="Update"/>
        </form>
        
        <form action="AddCompany" method="POST">
            Nome:<input type="text" name="name"/><br/>
            Token:<input type="text" name="token"/><br/>
            <input type="submit" value="Add"/>
        </form>
        
        <form action="DeleteCompany" method="POST">
            id:<input type="number" name="idCompany"/><br/>
            <input type="submit" value="Delete"/>
        </form>
    </body>
</html>
