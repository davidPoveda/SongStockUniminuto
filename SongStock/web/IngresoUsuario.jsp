<%-- 
    Document   : IngresoUsuario
    Created on : 12-mar-2013, 0:04:03
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso usuario</title>
    </head>
    <body>
        <form action="IngresoUsuario" method="post">
            Email
            <input type ="text" name="email"/><br>
            Contraseña
            <input type="password" name="contrasena" /><br>
            <input type = "submit" value="ingresar">
        </form>
    </body>
</html>
