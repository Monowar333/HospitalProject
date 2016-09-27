/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;

import HospitalWeb.domain.DAO.MedicationsDAO;
import HospitalWeb.domain.Medications;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Жека
 */
public class MedicationsServiceImpl implements MedicationsService{
    
    @Autowired
    private MedicationsDAO medicationsDAO;
    
    
    @Override
    public Medications getById(int id) {
       Medications u = null;
        try{
            u = medicationsDAO.getById(id);
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
    public int save(Medications o) {
       Integer i  = null;
        //Medications u = o;
        try{
         
            i = medicationsDAO.save(o);
            System.out.println("+++++++++" + i);
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
    public void remove(Medications o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medications> getList() {
        List<Medications> u = null;
        try{
            u = medicationsDAO.getList();
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
}
