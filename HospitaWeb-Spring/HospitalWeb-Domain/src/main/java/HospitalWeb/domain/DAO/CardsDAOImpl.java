/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain.DAO;

import HospitalWeb.domain.Card;
import HospitalWeb.domain.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class CardsDAOImpl implements CardsDAO {
    
    
    @Override
    public Card getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Card.class)
                .add(Restrictions.eq("email", email));
        Card us = (Card)crit.uniqueResult();
        session.close();
        return us;   
    }
    @Override
    public Card getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Card.class)
                .add(Restrictions.eq("id", id));
        Card u = (Card)crit.uniqueResult();
        session.close();
        return u;
    }

    @Override
    public int save(Card o) {
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
    public void update(Card o) {
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
    public void remove(Card o) {
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
    public List<Card> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Card.class); 
        List<Card> uList = (List<Card>)crit.list();
        session.close();
        return uList;   
    }

    @Override
    public void changeStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx =session.getTransaction();        
        Criteria crit = session.createCriteria(Card.class)
                .add(Restrictions.eq("id", id));
        Card u = (Card)crit.uniqueResult();
        u.setStatus(false);
        tx.begin();
        try{
            session.update(u);
            tx.commit();
        }catch (Exception ex){
            tx.rollback();
        }finally {
            session.close();
        }    
    }
    
    
}
