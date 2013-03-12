/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.servlet;

import co.themafia.dao.ProveedorDao;
import co.themafia.dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
public class RegistroUsuario extends HttpServlet {

    boolean respuesta = true;
    
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            if(respuesta){
                out.println("<h3>Se a registrado en la aplicacion</h3>");
            }else{
                out.println("<h3>Verifique que todos los datos esten indexados</h3>");
            }
            out.println("</body>");
            out.println("</html>");
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
        String nombre = new String();
        String apellido = new String();
        String email = new String();
        String tUsuario = new String();
        String contrasena = new String();
        
        if(request.getParameter("nombre")!=null && !request.getParameter("nombre").equals("")){
            nombre = request.getParameter("nombre");
        }else{
            respuesta = false;
        }
        if(request.getParameter("apellido")!=null && !request.getParameter("apellido").equals("")){
            apellido = request.getParameter("apellido");
        }else{
            respuesta = false;
        }
        if(request.getParameter("email")!=null && !request.getParameter("email").equals("")){
            email = request.getParameter("email");
        }else{
            respuesta = false;
        }
        if(request.getParameter("tUsuario")!=null && !request.getParameter("tUsuario").equals("")){
            tUsuario = request.getParameter("tUsuario");
        }else{
            respuesta = false;
        }
        if(request.getParameter("contrasena")!=null && request.getParameter("vContrasena")!=null){
            if(!request.getParameter("contrasena").equals("") && !request.getParameter("vContrasena").equals("")){
                if(request.getParameter("contrasena").equals(request.getParameter("vContrasena"))){
                    contrasena = request.getParameter("contrasena");
                }else{
                    respuesta = false;
                }
            }else{
                respuesta = false;
            }
        }else{
            respuesta = false;
        }
        if(respuesta && tUsuario.equals("1")){
            UsuarioDao ud = new UsuarioDao();
            if(ud.existeEmailUsuario(email)){
                ud.agregarUsuario(nombre, apellido, email, contrasena);
            }else{
                respuesta=false;
            }
        }
        if(respuesta && tUsuario.equals("2")){
            ProveedorDao pd = new ProveedorDao();
            if(pd.existeEmailProveedor(email)){
                pd.agregarProveedor(nombre, apellido, email, contrasena);
            }else{
                respuesta=false;
            }
        }
        if(tUsuario.equals("0")){
            respuesta=false;
        }
        processRequest(request, response);
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
