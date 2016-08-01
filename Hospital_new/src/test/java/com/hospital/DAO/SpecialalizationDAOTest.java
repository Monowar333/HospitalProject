/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.DAO;

import DB.entity.Spcialialization;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Жека
 */
public class SpecialalizationDAOTest {
    static int iduser;
    static int iduser1;
    public SpecialalizationDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Spcialialization spec = new Spcialialization();
        spec.setName("TestName");
        SpecialalizationDAO spDAO = new SpecialalizationDAO();
        iduser = spDAO.save(spec);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        Spcialialization spec = new SpecialalizationDAO().getById(iduser);
        SpecialalizationDAO spDAO = new SpecialalizationDAO();
        spDAO.remove(spec);
        spec = new SpecialalizationDAO().getById(iduser1);
        spDAO.remove(spec);
    }
    
   

    /**
     * Test of getById method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
         Spcialialization user = new SpecialalizationDAO().getById(iduser);
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(iduser, (long)user.getId());
    }

    /**
     * Test of save method, of class SpecialalizationDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Spcialialization spec = new Spcialialization();
        spec.setName("TestName3");
        SpecialalizationDAO spDAO = new SpecialalizationDAO();
        iduser1 = spDAO.save(spec);
        Spcialialization spec1 = new SpecialalizationDAO().getById(iduser1);
        Assert.assertNotNull("entity not found", spec1);
        Assert.assertEquals(iduser1, (long)spec1.getId());
    }

    /**
     * Test of update method, of class SpecialalizationDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Spcialialization spec = new SpecialalizationDAO().getById(iduser);
            spec.setName("TestNameUpdate");
            new SpecialalizationDAO().update(spec);
            Spcialialization spec1 = new SpecialalizationDAO().getById(iduser);
        Assert.assertNotNull("entity not found", spec1);
        Assert.assertEquals("TestNameUpdate", spec1.getName());
    }

    /**
     * Test of remove method, of class SpecialalizationDAO.
     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Spcialialization o = null;
//        SpecialalizationDAO instance = new SpecialalizationDAO();
//        instance.remove(o);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getList method, of class SpecialalizationDAO.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        List<Spcialialization> user = new SpecialalizationDAO().getList();
        Assert.assertNotNull("entity not found", user);
    }

  
    
}
