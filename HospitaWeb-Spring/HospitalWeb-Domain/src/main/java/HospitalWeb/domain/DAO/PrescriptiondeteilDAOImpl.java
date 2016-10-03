/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Prescriptiondeteil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Жека
 */
public class PrescriptiondeteilDAOImpl implements PrescriptiondeteilDAO{
      @Override
    public Prescriptiondeteil getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Prescriptiondeteil.class)
                .add(Restrictions.eq("id", id));
        Prescriptiondeteil u = (Prescriptiondeteil)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Prescriptiondeteil o) {
          
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
    public void remove(Prescriptiondeteil o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prescriptiondeteil> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Prescriptiondeteil.class); 
        List<Prescriptiondeteil> uList = (List<Prescriptiondeteil>)crit.list();
        session.close();
        return uList;   
    }
}
