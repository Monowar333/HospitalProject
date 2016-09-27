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
           System.out.println(o.getClinicalpharmgroup().length() + " 0");
            System.out.println(o.getCompositionofactivesubstances().length() + " 1");
            System.out.println(o.getConditionsofsupply().length() + " 2");
            System.out.println(o.getCountry().length() + " 3");
            System.out.println(o.getManufacturer().length() + " 4");
            System.out.println(o.getManufactureren().length()+ " 5");
            System.out.println(o.getMnn().length()+ " 6");
            System.out.println(o.getProduct().length()+ " 7");
            System.out.println(o.getTradename().length() + " 8");
            System.out.println("//////////");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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