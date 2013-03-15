/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.servlet;

import co.themafia.dao.PedidoDao;
import co.themafia.hbm.Confirmacion;
import co.themafia.hbm.ConfirmacionId;
import co.themafia.hbm.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davidmpv01
 */
public class AprobarRechazar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AprobarRechazar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AprobarRechazar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("index.jsp");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String aceptado;
        String fechaEnvio;
        String idPedido;
        
        aceptado = request.getParameter("estadoPedido");
        fechaEnvio = request.getParameter("fechaEnvio");
        idPedido = request.getParameter("idPedido");
        
        PedidoDao dao = new PedidoDao();
        Confirmacion confirmacion = new Confirmacion();
        if(aceptado.equals("1")){
        confirmacion.setAceptada(Boolean.TRUE);
        }else{
            confirmacion.setAceptada(Boolean.FALSE);
        }
        confirmacion.setFechaEnvio(fechaEnvio);
        Pedido pedido = dao.buscarPedido(Integer.parseInt(idPedido));
        confirmacion.setPedido(pedido);
        confirmacion.setId(new ConfirmacionId(1, pedido.getIdPedido()));
        dao.ingresarConfirmacion(confirmacion);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
