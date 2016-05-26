<%-- 
    Document   : crudPerson
    Created on : 17/05/2016, 15:01:08
    Author     : Alisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Person</title>
    </head>
    <body>
        <form action="UpdatePerson" method="POST">
            id:<input type="number" name="idPerson"/><br/>
            Nome:<input type="text" name="name"/><br/>
            Cpf:<input type="text" name="cpf"/><br/>      
            <input type="submit" value="Update"/>
        </form>
        
        <form action="AddPerson" method="POST">
            Nome:<input type="text" name="name"/><br/>
            Cpf:<input type="text" name="cpf"/><br/>
            <input type="submit" value="Add"/>
        </form>
        
        <form action="DeletePerson" method="POST">
            id:<input type="number" name="idPerson"/><br/>
            <input type="submit" value="Delete"/>
        </form>
    </body>
</html>
