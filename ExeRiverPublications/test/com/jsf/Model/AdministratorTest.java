/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clair
 */
public class AdministratorTest {
    
    private Administrator admin; 
    
    /**
     *
     */
    public AdministratorTest() {
    }    

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }    

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }    

    /**
     *
     */
    @Before
    public void setUp() {
        //setup and administrator to test
        admin = new Administrator(1,"Clair", "Nicholls", "clair@gmail.com", "8 Copper Meadows, Redruth, TR152NX", "letmein");
        admin.setName(admin.forename, admin.surname);
    }    
    @After
    public void tearDown() {
    }
    @Test
    public void testUpdate() {
    }
    @Test
    public void testSetSubject() {
    }
    @Test
    public void testIsComplete()
    {
        System.out.println("Administrator Name is: " + admin.getName());
        System.out.println("Administrator details are: " + admin.getUserDetails());       
        assertEquals(admin.forename + " " + admin.surname, admin.name);
    }
}
