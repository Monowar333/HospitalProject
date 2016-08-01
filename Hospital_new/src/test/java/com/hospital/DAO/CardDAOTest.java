/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.DAO;

import DB.entity.Card;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Жека
 */
public class CardDAOTest {
    static int iduser;
    static int iduser1;
    public CardDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
            Card card = new Card();
            card.setNumber("TestNumber");
            Date da = new Date(2016, 12, 9);          
            card.setDateRegistr(da);
            card.setName("TestName");
            card.setSname("TestSname");
            da = new Date(2016, 12, 9);
            card.setDateofBirthdey(da);
            card.setAddress("Test");
            card.setTelephone("Test");
            card.setEmail("Test");
            card.setStatus(true);
            CardDAO cardsave = new CardDAO();
            iduser  = cardsave.save(card);
    }
    
    @AfterClass
    public static void tearDownClass() {
        Card card = new CardDAO().getById(iduser);
           new CardDAO().remove(card);
           Card card1 = new CardDAO().getById(iduser1);
           new CardDAO().remove(card1);
    }
    

    /**
     * Test of getById method, of class CardDAO.
     */
    @Test
    public void testGetById() {
        Card card = new CardDAO().getById(iduser);
        Assert.assertNotNull("entity not found", card);
        Assert.assertEquals(iduser, (long)card.getId());
    }

    /**
     * Test of save method, of class CardDAO.
     */
    @Test
    public void testSave() {
            Card card = new Card();
            card.setNumber("TestNumber1");
            Date da = new Date(2016, 12, 9);          
            card.setDateRegistr(da);
            card.setName("TestName1");
            card.setSname("TestSname1");
            da = new Date(2016, 12, 9);
            card.setDateofBirthdey(da);
            card.setAddress("Test1");
            card.setTelephone("Test1");
            card.setEmail("Test1");
            card.setStatus(true);
            CardDAO cardsave = new CardDAO();
            iduser1  = cardsave.save(card);
            Card card1 = new CardDAO().getById(iduser1);
            Assert.assertNotNull("entity not found", card1);
            Assert.assertEquals(iduser1, (long)card1.getId());
    }

    /**
     * Test of update method, of class CardDAO.
     */
    @Test
    public void testUpdate() {
            Card card = new CardDAO().getById(iduser);
            card.setName("TestLoginUpdate");
            new CardDAO().update(card);
            Card card1 = new CardDAO().getById(iduser);
        Assert.assertNotNull("entity not found", card1);
        Assert.assertEquals("TestLoginUpdate", card1.getName());
    }

    /**
     * Test of remove method, of class CardDAO.
     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Card o = null;
//        CardDAO instance = new CardDAO();
//        instance.remove(o);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getList method, of class CardDAO.
     */
    @Test
    public void testGetList() {
         List<Card> card = new CardDAO().getList();
        Assert.assertNotNull("entity not found", card);
    }

    /**
     * Test of changeStatus method, of class CardDAO.
     */
    @Test
    public void testChangeStatus() {
        new CardDAO().changeStatus(iduser);
        Card card = new CardDAO().getById(iduser);
        Assert.assertNotNull("entity not found", card);
        Assert.assertEquals(false, card.getStatus());
    }
    
}
