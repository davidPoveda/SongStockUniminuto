/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.themafia.dao;

import co.themafia.hbm.Disco;
import co.themafia.hbm.Proveedor;
import co.themafia.hbm.conf.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Alejandro
 */
public class DiscoDao {
    
    Session session;
    

    public DiscoDao() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Disco> ListarDiscos(){
        List<Disco> discos = new ArrayList<Disco>();
        try {
            session.beginTransaction();
            discos = session.createQuery("from Disco").list();
        } catch (Exception e) {
        }
        return  discos;
    }
    public void IngresarDisco(Proveedor p){
        try {
            session.beginTransaction();
            //Disco newDisco = new Disco(2, p, "Balck album","Metallica","","Rock",2002, Boolean.TRUE, Boolean.TRUE,12000,21000,"1", null, null);
            //session.save(newDisco);
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
