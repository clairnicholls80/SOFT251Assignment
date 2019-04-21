package com.jsf.Model;

import java.util.ArrayList;
import java.util.List;
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
    private static Reviewer reviewer1, reviewer2, reviewer3, reviewer4;
    private static ArrayList<Reviewer> reviewers = new ArrayList<Reviewer>();
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
        reviewer1 = new Reviewer("Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.forename, reviewer1.surname);
        reviewer2 = new Reviewer("Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer1.forename, reviewer1.surname);
        reviewer3 = new Reviewer("Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer1.forename, reviewer1.surname);
        reviewer4 = new Reviewer("Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        reviewer4.setName(reviewer1.forename, reviewer1.surname);   
        reviewers.add(reviewer1);
        reviewers.add(reviewer2);
        reviewers.add(reviewer3);
        reviewers.add(reviewer4);
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
        System.out.println("Reviewer Name is: " + reviewer1.getName());
        System.out.println("Reviewer Details are: " + reviewer1.getUserDetails()); 
        for (Reviewer reviewer : reviewers) {
            System.out.println(reviewer.getUserDetails());
        }
    }
}
