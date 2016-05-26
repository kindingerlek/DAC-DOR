<%-- 
    Document   : addAdmin
    Created on : 11/05/2016, 15:18:51
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Admin</title>
    </head>
    <body>
        <form action="UpdateAdmin" method="POST">
            id:<input type="number" name="idAdmin"/><br/>
            Nome:<input type="text" name="name"/><br/>
            Password:<input type="password" name="password"/><br/>
            Email:<input type="text" name="email"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
        
        <form action="AddAdmin" method="POST">
            Nome:<input type="text" name="name"/><br/>
            Password:<input type="password" name="password"/><br/>
            Email:<input type="text" name="email"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
        
        <form action="DeleteAdmin" method="POST">
            id:<input type="number" name="idAdmin"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
