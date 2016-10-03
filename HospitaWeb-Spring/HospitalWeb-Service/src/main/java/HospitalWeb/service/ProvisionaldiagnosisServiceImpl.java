/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;

import HospitalWeb.domain.DAO.ProvisionaldiagnosisDAO;
import HospitalWeb.domain.Provisionaldiagnosis;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Жека
 */
public class ProvisionaldiagnosisServiceImpl implements ProvisionaldiagnosisService{
      @Autowired
    private ProvisionaldiagnosisDAO provisionaldiagnosisDAO;
    
    
    @Override
    public Provisionaldiagnosis getById(int id) {
       Provisionaldiagnosis u = null;
        try{
            u = provisionaldiagnosisDAO.getById(id);
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
    public int save(Provisionaldiagnosis o) {
       Integer i  = null;
        //Medications u = o;
        try{
            
            i = provisionaldiagnosisDAO.save(o);
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
    public void remove(Provisionaldiagnosis o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provisionaldiagnosis> getList() {
        List<Provisionaldiagnosis> u = null;
        try{
            u = provisionaldiagnosisDAO.getList();
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
