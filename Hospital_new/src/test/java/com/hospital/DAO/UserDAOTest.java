package com.hospital.DAO;
import DB.entity.Spcialialization;
import DB.entity.Users;
import java.util.List;
import org.hibernate.TransactionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Жека
 */
public class UserDAOTest {
     static int iduser;
    static int iduser1;
    @BeforeClass 
    public static void newUser(){
        
        Users user = new Users();
             user.setName("wewrer");    
             user.setSnme("dsfsdfdfsdf");
             user.setExp(15);
            user.setIdspecialization((Spcialialization)
                 new SpecialalizationDAO().getById(27));
             
            user.setStatus("admin");
            user.setLogin("TestLogin123");
            user.setPassword("TestLogin");
            user.setEmail("sasdasd");
            user.setTelephone("34242342342");
            user.setLinkaccept("TESTLINK11111111111");
            user.setAuntification("TESTLINK33333333");
            user.setStatusWork(true); 
            user.setStatusregistr(false);
            iduser1 = new UsersDAO().save(user);
            System.out.println(iduser1 + " 65546546546");
            
    }
    
    @AfterClass
     public static void removeUser(){
          Users user = new UsersDAO().getById(iduser);
           new UsersDAO().remove(user);
           Users user1 = new UsersDAO().getById(iduser1);
           new UsersDAO().remove(user1);
    }
   
    @Test
    public void step_01_insertUsertest(){
        
        Users user = new Users();
             user.setName("wewrer");    
             user.setSnme("dsfsdfdfsdf");
             user.setExp(15);
            user.setIdspecialization((Spcialialization)
                 new SpecialalizationDAO().getById(27));
             
            user.setStatus("admin");
            user.setLogin("TestLogin123");
            user.setPassword("dsdasd");
            user.setEmail("sasdasd");
            user.setTelephone("34242342342");
            user.setStatusWork(true); 
            user.setStatusregistr(false);
            iduser = new UsersDAO().save(user);
            System.out.println(iduser);
            Users user1 = new UsersDAO().getById(iduser);
        Assert.assertNotNull("entity not found", user1);
        Assert.assertEquals(iduser, (long)user1.getId());
    }
    
    @Test
    public void step_02_getByIdTest(){
        Users user = new UsersDAO().getById(iduser1);
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(iduser1, (long)user.getId());
    }
    
      @Test
    public void step_03_getList(){
       List<Users> user = new UsersDAO().getList();
        Assert.assertNotNull("entity not found", user);
    }
    
      @Test
    public void step_04_changeStatus(){
        new UsersDAO().changeStatus(iduser1);
        Users user = new UsersDAO().getById(iduser1);
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(false, user.getStatusWork());
    }
    
    @Test
    public void step_05_insertUpdate(){
        
        Users user = new UsersDAO().getById(iduser1);
            user.setPassword("TestLogin");
            new UsersDAO().update(user);
            Users user1 = new UsersDAO().getById(iduser1);
        Assert.assertNotNull("entity not found", user1);
        Assert.assertEquals("TestLogin", user1.getPassword());
    }
    
     @Test
    public void step_06_getByLinckAccept(){
        
        Users user = new UsersDAO().getByLinckAccept("TESTLINK11111111111");
            
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals("TESTLINK11111111111", user.getLinkaccept());
    }
    
     @Test
    public void step_07_getByAuntification(){
        
        Users user = new UsersDAO().getByAuntification("TESTLINK33333333");
            
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals("TESTLINK33333333", user.getAuntification());
    }
    
    @Test
    public void step_08_getByLogin(){
        
        Users user = new UsersDAO().getByLogin("TestLogin123");
            
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals("TestLogin123", user.getLogin());
    }
    
     @Test
    public void step_09_getBySpec(){
       Spcialialization spec = new SpecialalizationDAO().getById(27);
       List<Users> user = new UsersDAO().getBySpec(spec);
      
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(new SpecialalizationDAO().getById(27).getId(),
                user.get(0).getIdspecialization().getId());
    }
    
    
     public void step_010_getBySpecAndStWork(){
       Spcialialization spec = new SpecialalizationDAO().getById(27);
       List<Users> user = new UsersDAO().getBySpec(spec);
      
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(new SpecialalizationDAO().getById(27).getId(),
                user.get(0).getIdspecialization().getId());
        Assert.assertEquals(true, user.get(0).getStatusWork());
    }
//    @Test
//    public void step_03_removeTest(){
//          
//           user = new UsersDAO().getById(iduser1);
//        Assert.assertNull("entity not found", user);
//       // Assert.assertEquals(iduser, (long)user.getId());
//    }
}
