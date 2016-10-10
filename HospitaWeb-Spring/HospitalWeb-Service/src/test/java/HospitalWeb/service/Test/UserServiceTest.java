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
    private UsersDAOImpl usersDAO;
    @Mock
    private UserService userService; 
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
        when(userService.getById(8)).thenReturn(new Users());
        Users u = userService.getById(8);
        System.out.println(u.toString());
        Assert.assertNotNull("entity not found", u);
    }
    
    @Test(expected=NullPointerException.class)
    public void getByIdTest_2() throws Exception {
        when(userService.getById(0)).thenReturn(null);
        Users u = userService.getById(0);
        System.out.println(u.toString());
    }
    
    
     
    @Test
    public void getByEmailTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setEmail("test");
        when(userService.getByEmail("test")).thenReturn(u);
        Users u1 = userService.getByEmail("test");
        Assert.assertNotNull("entity not found", u);
        Assert.assertEquals(u, u1);
    }
    
     @Test
    public void getByLoginTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setLogin("test");
        when(userService.getByLogin("test")).thenReturn(u);
        Users u1 = userService.getByLogin("test");
        Assert.assertNotNull("entity not found", u);
        Assert.assertEquals(u, u1);
    }
    
     
     @Test
    public void getBySpecTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setIdspecialization(new Spcialialization(5));
        ArrayList<Users> ulist = new ArrayList<Users>();
        when(userService.getBySpec(new Spcialialization(5))).thenReturn(ulist);
        List<Users> ulist1 = userService.getBySpec(new Spcialialization(5));
        Assert.assertNotNull("entity not found", ulist1);
        Assert.assertEquals(ulist, ulist1);
    }
    
      @Test
    public void getByBySpecAndStWorkTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setIdspecialization(new Spcialialization(5));
        u.setStatusWork(Boolean.TRUE);
        ArrayList<Users> ulist = new ArrayList<Users>();
        when(userService.getBySpecAndStWork(new Spcialialization(5))).thenReturn(ulist);
        List<Users> ulist1 = userService.getBySpec(new Spcialialization(5));
        Assert.assertNotNull("entity not found", ulist1);
        Assert.assertEquals(ulist, ulist1);
    }
    
    @Test
    public void getSaveTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setStatusWork(Boolean.TRUE);
        when(userService.save(u)).thenReturn(5);
        int i = userService.save(u);
        Assert.assertNotNull("entity not found", 5);
        Assert.assertEquals(5, 5);
    }
    
     @Test
    public void getByLinckAcceptTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setLinkaccept("Test");
        when(userService.getByLinckAccept("Test")).thenReturn(u);
        Users u1= userService.getByLinckAccept("Test");
        Assert.assertNotNull("entity not found", u1);
        Assert.assertEquals(u, u1);
    }
    
        @Test
    public void removeTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setLinkaccept("Test");
        // call methods
        userService.remove(u);
        // verify, that methods are called, please note that we check 
        // also parameter value
        verify(userService).remove(u);

    }
    
    @Test
    public void getByAuntificationTest_1() throws Exception {
//        UserServiceImpl usersDAO = mock(UserServiceImpl.class);
        Users u = new Users();
        u.setAuntification("Test");
        when(userService.getByAuntification("Test")).thenReturn(u);
        Users u1= userService.getByAuntification("Test");
        Assert.assertNotNull("entity not found", u1);
        Assert.assertEquals(u, u1);
    }
    
}   

