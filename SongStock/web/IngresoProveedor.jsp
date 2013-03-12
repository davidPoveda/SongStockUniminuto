<%-- 
    Document   : IngresoProveedor
    Created on : 12-mar-2013, 0:04:23
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreasar como proveedor</title>
    </head>
    <body>
        <form action="IngresoProveedor" method="post">
            Email
            <input type ="text" name="email"/><br>
            Contraseña
            <input type="password" name="contrasena" /><br>
            <input type = "submit" value="ingresar">
        </form>
    </body>
</html>
