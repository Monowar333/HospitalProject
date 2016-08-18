/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;


import HospitalWeb.domain.Card;
import HospitalWeb.domain.DAO.CardsDAOImpl;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Жека
 */
public class CardServiceImpl implements CardService{
     @Autowired
    private CardsDAOImpl cardDAO;
    
//    @Required
//    public void setCardDao(CardsDAOImpl cardDAO) {
//        this.cardDAO = cardDAO;
//    }

    public CardServiceImpl() {
//        this.cardDAO = new CardsDAOImpl();
    }

    @Override
    public Card getById(int id) {
       Card u = null;
        try{
            u = cardDAO.getById(id);
            if(u == null){
                throw new ODEException("such user is not exist");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
        return u;
    }

    @Override
    public int save(Card o) {
       Integer i  = null;
        Card u = o;
        try{
            i = cardDAO.save(o);
            if(i == null){
                throw new ODEException("invalid save");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
       return i;
    }

    @Override
    public void update(Card o) {
        Card u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            cardDAO.update(o);
           
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
    }

    @Override
    public void remove(Card o) {
       Card u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            cardDAO.remove(o);
           
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
    }

    @Override
    public List<Card> getList() {
        List<Card> u = null;
        try{
            u = cardDAO.getList();
            System.out.println(u.get(0));
            if(u == null){
                throw new ODEException("such user is not exist");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
        return u;
    }

    @Override
    public void changeStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
