/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service.Test;

import HospitalWeb.domain.DAO.UserDAO;
import HospitalWeb.domain.DAO.UsersDAOImpl;
import HospitalWeb.domain.Spcialialization;
import HospitalWeb.domain.Users;
import HospitalWeb.service.ODEException;
import HospitalWeb.service.UserService;
import HospitalWeb.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Жека
 */
public class UserServiceTest {
    @Mock
    private UserDAO usersDAO;
    @InjectMocks
    private UserService userService = new UserServiceImpl(); 
//    @Mock
//    private UsersValidate usersValidate;
// 
//    @InjectMocks
//    private UsersController userController = new UsersController();
// 
//    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
    }
        
    
    
    @Test
    public void getByIdTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users(8);
        when(usersDAO.getById(8)).thenReturn(u);
        Users u1 = userService.getById(8);
        System.out.println(u.toString());
        Assert.assertNotNull("entity not found", u);
        Assert.assertEquals(u, u1);
    }
    
    @Test(expected= ODEException.class)
    public void getByIdTest_2() throws Exception {
        when(usersDAO.getById(0)).thenReturn(null);
        Users u = userService.getById(0);
    }
//    
//    
//     
    @Test
    public void getByEmailTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setEmail("test");
        when(usersDAO.getByEmail("test")).thenReturn(u);
        Users u1 = userService.getByEmail("test");
        Assert.assertNotNull("entity not found", u);
        Assert.assertEquals(u, u1);
    }
    
        @Test(expected= ODEException.class)
    public void getByEmailTest_2() throws Exception {
        when(usersDAO.getByEmail("test")).thenReturn(null);
        Users u = userService.getByEmail("test");
    }
    
     @Test
    public void getByLoginTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setLogin("test");
        when(usersDAO.getByLogin("test")).thenReturn(u);
        Users u1 = userService.getByLogin("test");
        Assert.assertNotNull("entity not found", u);
        Assert.assertEquals(u, u1);
    }
    
      @Test(expected= ODEException.class)
    public void getByLoginTest_2() throws Exception {
        when(usersDAO.getByLogin("test")).thenReturn(null);
        Users u1 = userService.getByLogin("test");
    }
     
    @Test
    public void getBySpecTest_1() throws Exception {
        Users u = new Users();
        u.setIdspecialization(new Spcialialization(5));
        ArrayList<Users> ulist = new ArrayList<Users>();
        when(usersDAO.getBySpec(new Spcialialization(5))).thenReturn(ulist);
        List<Users> ulist1 = userService.getBySpec(new Spcialialization(5));
        Assert.assertNotNull("entity not found", ulist1);
        Assert.assertEquals(ulist, ulist1);
    }
    
     @Test(expected= ODEException.class)
    public void getBySpecTest_2() throws Exception {
        when(usersDAO.getBySpec(new Spcialialization(5))).thenReturn(null);
        List<Users> ulist1 = userService.getBySpec(new Spcialialization(5));
    }
    
     @Test
    public void getListTest_1() throws Exception {
        Users u = new Users();
        u.setIdspecialization(new Spcialialization(5));
        ArrayList<Users> ulist = new ArrayList<Users>();
        ulist.add(u);
        when(usersDAO.getList()).thenReturn(ulist);
        List<Users> ulist1 = userService.getList();
        Assert.assertNotNull("entity not found", ulist1);
        Assert.assertEquals(ulist, ulist1);
    }
    
     @Test(expected= ODEException.class)
    public void getListTest_2() throws Exception {
        when(usersDAO.getList()).thenReturn(null);
        List<Users> ulist1 = userService.getList();
    }
    
      @Test
    public void getByBySpecAndStWorkTest_1() throws Exception {
        Users u = new Users();
        u.setIdspecialization(new Spcialialization(5));
        u.setStatusWork(Boolean.TRUE);
        ArrayList<Users> ulist = new ArrayList<Users>();
        when(usersDAO.getBySpecAndStWork(new Spcialialization(5))).thenReturn(ulist);
        List<Users> ulist1 = userService.getBySpec(new Spcialialization(5));
        Assert.assertNotNull("entity not found", ulist1);
        Assert.assertEquals(ulist, ulist1);
    }
    
    @Test(expected= ODEException.class)
    public void getByBySpecAndStWorkTest_2() throws Exception {
        when(usersDAO.getBySpecAndStWork(new Spcialialization(5))).thenReturn(null);
        List<Users> ulist1 = userService.getBySpecAndStWork(new Spcialialization(5));
    }
//    
    @Test
    public void getSaveTest_1() throws Exception {
        Users u = new Users();
        u.setStatusWork(Boolean.TRUE);
        when(usersDAO.save(u)).thenReturn(5);
        int i = userService.save(u);
        Assert.assertNotNull("entity not found", i);
        Assert.assertEquals(5, i);
    }
    
      @Test(expected= ODEException.class)
    public void getSaveTest_2() throws Exception {
        Users u = new Users();
        u.setStatusWork(Boolean.TRUE);
        when(usersDAO.save(u)).thenReturn(-1);
        int i = userService.save(u);
    }
    
     @Test
    public void getByLinckAcceptTest_1() throws Exception {
        Users u = new Users();
        u.setLinkaccept("Test");
        when(usersDAO.getByLinckAccept("Test")).thenReturn(u);
        Users u1= userService.getByLinckAccept("Test");
        Assert.assertNotNull("entity not found", u1);
        Assert.assertEquals(u, u1);
    }
    
    @Test(expected= ODEException.class)
    public void getByLinckAcceptTest_2() throws Exception {
         when(usersDAO.getByLinckAccept("Test")).thenReturn(null);
        Users u1= userService.getByLinckAccept("Test");
    }
    
     @Test(expected= ODEException.class)
    public void removeTest_1() throws Exception {
          userService.remove(null);
//        Users u = new Users();
//        u.setLinkaccept("Test");
////        when(usersDAO.remove(u)).;
////        Users u = new Users();
//        u.setLinkaccept("Test");
//        // call methods
//        userService.remove(u);
//        // verify, that methods are called, please note that we check 
//        // also parameter value
//        verify(userService).remove(u);
    }
    
         @Test(expected= ODEException.class)
    public void updateTest_1() throws Exception {
          userService.update(null);
    }
    
    @Test
    public void getByAuntificationTest_1() throws Exception {
        Users u = new Users();
        u.setAuntification("Test");
        when(usersDAO.getByAuntification("Test")).thenReturn(u);
        Users u1= userService.getByAuntification("Test");
        Assert.assertNotNull("entity not found", u1);
        Assert.assertEquals(u, u1);
    }
    
    @Test(expected= ODEException.class)
    public void getByAuntificationTest_2() throws Exception {
        when(usersDAO.getByAuntification("Test")).thenReturn(null);
        Users u1= userService.getByAuntification("Test");
    }
    
//    @Test(expected= ODEException.class)
//    public void changeStatus_1() throws Exception {
//        userService.changeStatus(0);
//    }
}   

