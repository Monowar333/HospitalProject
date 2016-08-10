/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;


import HospitalWeb.domain.DAO.SpecialalizationDAO;
import HospitalWeb.domain.DAO.SpecialalizationDAOImpl;
import HospitalWeb.domain.Spcialialization;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Жека
 */
public class SpecialalizationServiceImpl implements SpecialalizationService{
        
    @Autowired
    private SpecialalizationDAO  specialalizationDAO;
    
//    @Required
//    public void setUsersDao(SpecialalizationDAO specialalizationDAO) {
//        this.specialalizationDAO = specialalizationDAO;
//    }

    public SpecialalizationServiceImpl() {
//        this.specialalizationDAO = new SpecialalizationDAOImpl();
    }
    
    
    @Override
    public Spcialialization getById(int id) {
      Spcialialization u = null;
        try{
            u = specialalizationDAO.getById(id);
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
    public int save(Spcialialization o) {
       Integer i  = null;
        Spcialialization u = o;
        try{
            specialalizationDAO.save(o);
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
    public void update(Spcialialization o) {
       Spcialialization u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            specialalizationDAO.update(o);
           
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
    public void remove(Spcialialization o) {
     Spcialialization u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            specialalizationDAO.remove(o);
           
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
    public List<Spcialialization> getList() {
        List<Spcialialization> u = null;
        try{
            u = specialalizationDAO.getList();
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
