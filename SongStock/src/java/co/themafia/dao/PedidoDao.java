/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.dao;

import co.themafia.hbm.Confirmacion;
import co.themafia.hbm.Pedido;
import co.themafia.hbm.Proveedor;
import co.themafia.hbm.conf.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author davidmpv01
 */
public class PedidoDao {

    Session session;
    
    public PedidoDao() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Proveedor> consultarListaPedidoProveedor(int valor) {
        session.beginTransaction();
        List<Proveedor> listaPedido = (List<Proveedor>)session.createQuery("from Proveedor p where p.idProveedor=:valor").setParameter("valor", valor).list();
        return listaPedido;
    }
    
    public void ingresarConfirmacion(Confirmacion confirmacion){
        session.beginTransaction();
        session.save(confirmacion);
        session.getTransaction().commit();
    }
    
    public Pedido buscarPedido (int id){
        session.beginTransaction();
        Pedido pedido = (Pedido)session.createQuery("from Pedido where idPedido=:id").setParameter("id", id).uniqueResult();
        return pedido;
    }
}
