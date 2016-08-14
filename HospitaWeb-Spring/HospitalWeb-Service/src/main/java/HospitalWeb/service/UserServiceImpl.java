/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;


import HospitalWeb.domain.DAO.UserDAO;
import HospitalWeb.domain.DAO.UsersDAOImpl;
import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Жека
 */
//класс сервис призваны обрабатывать все возможные исключения при работе с ДАО
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO usersDao;

//инекция компонента бин     
//    @Required
//    public void setUsersDao(UserDAO usersDao) {
//        this.usersDao = usersDao;
//    }

    public UserServiceImpl() {
//        this.usersDao = new UsersDAOImpl();
    }
    
    @Override
    public Users getById(int id) {
        Users u = null;
        try{
            u = usersDao.getById(id);
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
    public List<Users> getBySpec(Spcialialization idspecialization) {
        List<Users> u = null;
        try{
            u = usersDao.getBySpec(idspecialization);
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
    public Users getByLogin(String login) {
         Users u = null;
        try{
            u = usersDao.getByLogin(login);
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
    public Users getByAuntification(String auntification) {
         Users u = null;
        try{
            u = usersDao.getByAuntification(auntification);
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
    public Users getByLinckAccept(String link) {
          Users u = null;
        try{
            u = usersDao.getByLinckAccept(link);
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
    public List<Users> getBySpecAndStWork(Spcialialization idspecialization) {
        List<Users> u = null;
        try{
            u = usersDao.getBySpecAndStWork(idspecialization);
//            if(u == null){
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

    @Override
    public int save(Users o) {
        Integer i  = null;
        Users u = o;
        try{
            
            i = usersDao.save(u);
            System.out.println(i + "fsdfsfdfs");
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
    public void update(Users o) {
        
        Users u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            usersDao.update(o);
           
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
    public void remove(Users o) {
        Users u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            usersDao.remove(o);
           
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
    public List<Users> getList() {
        List<Users> u = null;
        try{
            u = usersDao.getList();
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
        Integer i = id;
        try{
             if(i == null){
                throw new ODEException("such user is not exist");
            }
            usersDao.changeStatus(i);
           
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
    
}
