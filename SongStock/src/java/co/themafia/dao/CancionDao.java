/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.dao;

import co.themafia.hbm.Disco;
import co.themafia.hbm.conf.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Alejandro
 */
public class CancionDao {
    
    Session session;
    
    public CancionDao() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Disco> ListarDiscos(){
    System.out.println ("");
        List<Disco> discos = new ArrayList<Disco>();
        try {
            session.beginTransaction();
            discos = session.createQuery("from Conceptousuario").list();
        } catch (Exception e) {
        }
        return  discos;
    }
    
}
