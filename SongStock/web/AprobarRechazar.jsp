<%-- 
    Document   : AprobarRechazar
    Created on : 14/03/2013, 10:46:20 PM
    Author     : davidmpv01
--%>

<%@page import="co.themafia.hbm.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="co.themafia.hbm.Proveedor"%>
<%@page import="co.themafia.dao.PedidoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AprobarRechazar</title>
    </head>
    <body>
    
        <h1>Aprobar o rechazar pedido</h1>
        
        <form action="AprobarRechazar" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Numero pedido</td>
                        <td>Comprador</td>
                        <td>Medio de pago</td>
                        <td>Fecha de solicitud</td>
                        <td>Estado</td>
                    </tr>
                    <tr>
                        <% String proveedorId=request.getParameter("proveedor"); 
                    PedidoDao pedidoDao = new PedidoDao();
                    List<Proveedor> listaPedido = pedidoDao.consultarListaPedidoProveedor(1);
                    for(Proveedor p : listaPedido){
                        for(Pedido pedido : p.getPedidos()){                        
%>                      <td><input type ="text" name="idPedido" value="<%=pedido.getIdPedido()%>"/></td>
                        <td><input type ="text" name="nombre" value="<%=p.getNombre()%>"/></td>
                        <td><input type="text" name="medioPago" value="<%=pedido.getMediopago().getMedioPago()%>"/></td>
                        <td><input type="text" name="fechaSolicitud" value="<%=pedido.getFechaSolicitud()%>"/></td>
                        <td><input type="text" name="estado" value="<%=pedido.getEstadopedido().getEstado() %>"/></td>
                        <%
                        }
                                               }
                        %>
                    </tr>
                    <tr>
                        <td>Aprobar o rechazar</td>
                        <td>Fecha estimada de envío</td>
                    </tr>
                    <tr>
                        <td><select name="estadoPedido" id="estadoPedido" style="width: 100%">
            <option value="0">Seleccione...</option>
            <option value="1">Aprobar</option>
            <option value="2">Rechazar</option>
                            </select></td>
                <td><input type="text" name="fechaEnvio" /></td>
                <td><input type = "submit" value="Aceptar"></td>
            </tr>
        </form>
    </body>
</html>
