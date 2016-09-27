/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Reception;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Жека
 */
public class ReceptionDAOImpl implements ReceptionDAO{

    @Override
    public Reception getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Reception.class)
                .add(Restrictions.eq("id", id));
        Reception u = (Reception)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Reception o) {
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            result = (Integer)session.save(o);
            tx.commit();
        }catch(Exception ex){
            result = 0;
            tx.rollback();
        }finally{
            session.close();
        }
        return result;  
    }

    @Override
    public void remove(Reception o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reception> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Reception.class); 
        List<Reception> uList = (List<Reception>)crit.list();
        session.close();
        return uList;   
    }

    @Override
    public void changeStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
