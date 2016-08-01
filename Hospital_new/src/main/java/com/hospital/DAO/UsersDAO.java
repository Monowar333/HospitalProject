/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.DAO;

import DB.entity.HibernateUtil;
import DB.entity.Spcialialization;
import DB.entity.Users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Жека
 */
public class UsersDAO implements DAO<Users>{
     @Override
    public Users getById(int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("id", id));
        Users u = (Users)crit.uniqueResult();
        session.close();
        return u;
    }
    
    public List<Users> getBySpec(Spcialialization idspecialization) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("idspecialization", idspecialization));
        List<Users> uList = (List<Users>)crit.list();
        session.close();
        return uList;   
    }
    
    public Users getByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("login", login));
        Users us = (Users)crit.uniqueResult();
        session.close();
        return us;   
    }
    
        public Users getByAuntification(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("auntification", login));
        Users us = (Users)crit.uniqueResult();
        session.close();
        return us;   
    }
     public Users getByLinckAccept(String link) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("linkaccept", link));
        Users u = (Users)crit.uniqueResult();
        session.close();
        return u; 
    }
    
    public List<Users> getBySpecAndStWork(Spcialialization idspecialization) {
        Session session = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = session.createCriteria(Users.class);
        Criterion spec = Restrictions.eq("idspecialization", idspecialization);
        Criterion status = Restrictions.eq("statusWork", true);
        LogicalExpression andExp = Restrictions.and(spec,status);
        crit.add(andExp);
        List<Users> uList = (List<Users>)crit.list();
        session.close();
        return uList;   
    }
    
    @Override
    public int save(Users o) {
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
    public void update(Users o) {
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
    public void remove(Users o) {
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
    public List<Users> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Users.class); 
        List<Users> uList = (List<Users>)crit.list();
        session.close();
        return uList;   
    }

    @Override
    public void changeStatus(int id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = session.getTransaction();        
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("id", id));
        Users u = (Users)crit.uniqueResult();
        u.setStatusWork(false);
       
         tx.begin();
        try{
            session.update(u);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
       
    }
    
}
