/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Provisionaldiagnosis;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Жека
 */
public class ProvisionaldiagnosisDAOImpl implements ProvisionaldiagnosisDAO{
     @Override
    public Provisionaldiagnosis getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Provisionaldiagnosis.class)
                .add(Restrictions.eq("id", id));
        Provisionaldiagnosis u = (Provisionaldiagnosis)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Provisionaldiagnosis o) {
        int result;
         
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            System.out.println(o.getGroupdiagnos()+ "56465465465");
             System.out.println(o.getName());
             System.out.println(o.getGroupid());
            result = (Integer)session.save(o);
            System.out.println(result);
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
    public void remove(Provisionaldiagnosis o) {
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
    public List<Provisionaldiagnosis> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Provisionaldiagnosis.class); 
        List<Provisionaldiagnosis> uList = (List<Provisionaldiagnosis>)crit.list();
        session.close();
        return uList;   
    }
}
