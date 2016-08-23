/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;


import HospitalWeb.domain.HibernateUtil;
import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class SpecialalizationDAOImpl implements SpecialalizationDAO {

   @Override
    public Spcialialization getById(int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Spcialialization.class)
                .add(Restrictions.eq("id", id));
        Spcialialization u = (Spcialialization)crit.uniqueResult();
        session.close();
        return u;
    }
    
    @Override
    public Spcialialization getByName(String name) {
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Spcialialization.class)
                .add(Restrictions.eq("name", name));
        Spcialialization u = (Spcialialization)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Spcialialization o) {
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
    public void update(Spcialialization o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            session.update(o);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void remove(Spcialialization o) {
        if(!"Default".equals(o.getName())){
        UsersDAOImpl us = new UsersDAOImpl();
        List<Users> usspec = us.getBySpec(o);
        for(Users user: usspec){
            user.setIdspecialization(new SpecialalizationDAOImpl().getByName("Default"));
            us.update(user);
        }
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
        } else{
            System.out.println("Невозможно удалить специализацию");
        }
    }

    @Override
    public List<Spcialialization> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Spcialialization.class); 
        List<Spcialialization> uList = (List<Spcialialization>)crit.list();
        session.close();
        return uList;   
    }

    @Override
    public void changeStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
