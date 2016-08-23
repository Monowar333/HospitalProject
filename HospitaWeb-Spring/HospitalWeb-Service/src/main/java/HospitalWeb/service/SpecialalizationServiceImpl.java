/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;


import HospitalWeb.domain.DAO.SpecialalizationDAO;
import HospitalWeb.domain.Spcialialization;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Жека
 */
public class SpecialalizationServiceImpl implements SpecialalizationService{
        
    @Autowired
    private SpecialalizationDAO  specialalizationDAO;
    

    public SpecialalizationServiceImpl() {
//        this.specialalizationDAO = new SpecialalizationDAOImpl();
    }
    
    
    @Override
    public Spcialialization getById(int id) {
      Spcialialization u = null;
        try{
            u = specialalizationDAO.getById(id);
            if(null == u){
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
            i = specialalizationDAO.save(o);
            if(0 == i){
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
             if(null == u){
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
             if(null == u){
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
            if(null == u){
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

    @Override
    public Spcialialization getByName(String name) {
        Spcialialization u = null;
        try{
            u = specialalizationDAO.getByName(name);
//            if(null == u){
//                throw new ODEException("such user is not exist");
//            }
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
    
}
