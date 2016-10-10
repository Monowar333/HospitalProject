/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Prescription;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Жека
 */
public class PrescriptionDAOImpl implements PrescriptionDAO{
      @Override
    public Prescription getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Prescription.class)
                .add(Restrictions.eq("id", id));
        Prescription u = (Prescription)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Prescription o) {
          
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
    public void remove(Prescription o) {
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
    public List<Prescription> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Prescription.class); 
        List<Prescription> uList = (List<Prescription>)crit.list();
        session.close();
        return uList;   
    }
}
