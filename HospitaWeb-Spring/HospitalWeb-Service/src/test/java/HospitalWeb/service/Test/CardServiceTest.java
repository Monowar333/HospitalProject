/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.service.Test;

import HospitalWeb.domain.Card;
import HospitalWeb.domain.DAO.CardsDAO;
import HospitalWeb.domain.Users;
import HospitalWeb.service.CardService;
import HospitalWeb.service.CardServiceImpl;
import HospitalWeb.service.ODEException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Жека
 */
public class CardServiceTest {
    @Mock
    private CardsDAO cardsDAO;
    @InjectMocks
    private CardService cardService = new CardServiceImpl(); 

    private Card card = new Card();
    
    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
            card.setNumber("TestNumber");
            Date da = new Date(2016, 12, 9);          
            card.setDateRegistr(da);
            card.setName("TestName");
            card.setSname("TestSname");
            da = new Date(2016, 12, 9);
            card.setDateofBirthdey(da);
            card.setAddress("Test");
            card.setTelephone("Test");
            card.setEmail("test");
            card.setStatus(true);
    }
        
    
    
    @Test
    public void getByIdTest_1() throws Exception {
        when(cardsDAO.getById(8)).thenReturn(card);
        Card card1 = cardService.getById(8);
        Assert.assertNotNull("entity not found", card1);
        Assert.assertEquals(card , card1);
    }
    
    @Test(expected= ODEException.class)
    public void getByIdTest_2() throws Exception {
        when(cardsDAO.getById(0)).thenReturn(null);
        Card card1 = cardService.getById(0);
    }
//    
//    
//     
    @Test
    public void getByEmailTest_1() throws Exception {
        when(cardsDAO.getByEmail("test")).thenReturn(card);
        Card card1 = cardService.getByEmail("test");
        Assert.assertNotNull("entity not found", card1);
        Assert.assertEquals(card, card1);
    }
    
    @Test(expected= ODEException.class)
    public void getByEmailTest_2() throws Exception {
        when(cardsDAO.getByEmail("test")).thenReturn(null);
        Card card = cardService.getByEmail("test");
    }

    @Test
    public void getSaveTest_1() throws Exception {
        when(cardsDAO.save(card)).thenReturn(5);
        int i = cardsDAO.save(card);
        Assert.assertNotNull("entity not found", i);
        Assert.assertEquals(5, i);
    }
    
    @Test(expected= ODEException.class)
    public void getSaveTest_2() throws Exception {
        when(cardsDAO.save(card)).thenReturn(-1);
        Integer i = cardService.save(card);
    }
    
  
     @Test(expected= ODEException.class)
    public void removeTest_1() throws Exception {
          cardService.remove(null);
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
          cardService.update(null);
    }
    
//    @Test(expected= ODEException.class)
//    public void changeStatus_1() throws Exception {
//        cardService.changeStatus(0);
//    }
          @Test
    public void getListTest_1() throws Exception {
        ArrayList<Card> clist = new ArrayList<Card>();
        clist.add(card);
        when(cardsDAO.getList()).thenReturn(clist);
        List<Card> clist1 = cardService.getList();
        Assert.assertNotNull("entity not found", clist1);
        Assert.assertEquals(clist, clist1);
    }
    
     @Test(expected= ODEException.class)
    public void getListTest_2() throws Exception {
        when(cardsDAO.getList()).thenReturn(null);
        List<Card> clist1 = cardService.getList();
    }
}
