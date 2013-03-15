<%-- 
    Document   : AprobarPedido
    Created on : 14/03/2013, 07:57:55 PM
    Author     : davidmpv01
--%>


<%@page import="co.themafia.hbm.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="co.themafia.hbm.Pedido"%>
<%@page import="co.themafia.dao.PedidoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de pedidos</h1>
        <form action="AprobarPedido" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>Nombre usuario</td>
                        <td>Medio de pago</td>
                        <td>Fecha de solicitud</td>
                        <td>Estado</td>
                        <td>Aprobar/Rechazar</td>
                    </tr>
                    <%
                    PedidoDao pedidoDao = new PedidoDao();
                    List<Proveedor> listaPedido = pedidoDao.consultarListaPedidoProveedor(1);
                    for(Proveedor p : listaPedido){
                        for(Pedido pedido : p.getPedidos()){
                        %>
                    <tr>
                        <td><%=p.getNombre() %></td>
                        <td><%=pedido.getMediopago().getMedioPago()  %></td>
                        <td><%=pedido.getFechaSolicitud() %></td>
                        <td><%=pedido.getEstadopedido().getEstado() %></td>
                        <td><a href="AprobarRechazar.jsp?proveedor=<%=p.getIdProveedor()%>">Aprobar/Rechazar</a></td>
                    </tr>
                    <%
                                       }
                    }
                    %>
                </tbody>
            </table>
        </form>
    </body>
</html>