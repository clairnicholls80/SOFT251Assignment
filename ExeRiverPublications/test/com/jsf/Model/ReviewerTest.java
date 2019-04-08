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
public class ReviewerTest {
    private static Reviewer reviewer;

    /**
     *
     */
    public ReviewerTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        reviewer = new Reviewer("Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer.setName(reviewer.forename, reviewer.surname);
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
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testUpdate() {
    }

    /**
     *
     */
    @Test
    public void testSetSubject() {
    }

    /**
     *
     */
    @Test
    public void testIsComplete()
    {
        System.out.println("Reviewer Name is: " + reviewer.getName());
        System.out.println("Reviewer Details are: " + reviewer.getUserDetails());        
    }
}
