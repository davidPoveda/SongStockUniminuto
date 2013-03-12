<%-- 
    Document   : RegistroUsuario
    Created on : 11/03/2013, 12:21:32 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegistroUsuario" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Nombre</td>
                        <td>Apellido</td>
                    </tr>
                    <tr>
                        <td><input name="nombre" id="nombre" type="text"/></td>
                        <td><input name="apellido" id="apellido" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>Tipo de usuario</td>
                    </tr>
                    <tr>
                        <td><input name="email" id="email" type="email"/></td>
                        <td>
                            <select name="tUsuario" id="tUsuario" style="width: 100%">
                                <option value="0">...</option>
                                <option value="1">Comprador</option>
                                <option value="2">Vendedor</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Contrasena</td>
                        <td>Validar Contrasena</td>
                    </tr>
                    <tr>
                        <td><input name="contrasena" id="contrasena" type="password"/></td>
                        <td><input name="vContrasena" id="vContrasena" type="password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit"/></td>
                        <td><input type="reset"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
