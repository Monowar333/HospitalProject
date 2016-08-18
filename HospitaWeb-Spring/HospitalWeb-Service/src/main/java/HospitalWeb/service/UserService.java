/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service;


import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface UserService {
    public Users getById(int id);
    public List<Users> getBySpec(Spcialialization idspecialization);
     public Users getByEmail(String mail);
    public Users getByLogin(String login); 
    public Users getByAuntification(String auntification); 
    public Users getByLinckAccept(String link);  
    public List<Users> getBySpecAndStWork(Spcialialization idspecialization);
    public int save(Users o);
    public void update(Users o); 
    public void remove(Users o); 
    public List<Users> getList(); 
    public void changeStatus(int id);
}
