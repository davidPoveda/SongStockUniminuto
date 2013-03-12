/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.dao;

import co.themafia.hbm.Proveedor;
import co.themafia.hbm.Usuario;
import co.themafia.hbm.conf.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alejandro
 */
public class ProveedorDao {
    
    Session session;
    
    public ProveedorDao() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void agregarProveedor(String nombre,String apellido,String email,String contrasena){
        Proveedor p = new Proveedor();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setEmail(email);
        p.setContrasena(contrasena);
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
    
    public boolean existeEmailProveedor(String email){
        boolean respuesta = false;
        Usuario u = new Usuario();
        session.beginTransaction();
        u = (Usuario) session.createQuery("from Proveedor where email = :email").setString("email", email).uniqueResult();
        if(u.equals(null)){
            respuesta = true;
        }
        return respuesta;
    }
    
    public Proveedor loguearProveedor (String email, String contrasena) {
        Proveedor proveedor = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Proveedor p "
                    + "WHERE p.email = :emailP "
                    + "AND p.contrasena = :contrasenaP");
            query.setParameter("emailP", email);
            query.setParameter("contrasenaP", contrasena);
            proveedor = (Proveedor) query.uniqueResult();
        } 
        catch (Exception e) {
        }
        return proveedor;
    }
}
