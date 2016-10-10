/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Medications;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Жека
 */
public class MedicationsDAOImpl implements MedicationsDAO{
      @Override
    public Medications getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Medications.class)
                .add(Restrictions.eq("id", id));
        Medications u = (Medications)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Medications o) {
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
    public void remove(Medications o) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            session.delete(o);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Medications> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Medications.class); 
        List<Medications> uList = (List<Medications>)crit.list();
        session.close();
        return uList;   
    }
}