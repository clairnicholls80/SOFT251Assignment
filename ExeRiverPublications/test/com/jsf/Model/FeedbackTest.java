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
public class FeedbackTest {
    private static Book book1,book2;
    private static Feedback feedback1, feedback2, feedback3, feedback4;
    private static Reviewer reviewer1, reviewer2, reviewer3;
    
    public FeedbackTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        reviewer1 = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.forename, reviewer1.surname);
        reviewer2 = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer2.forename, reviewer2.surname);
        reviewer3 = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer3.forename, reviewer3.surname);
        book1 = new Book(1, "The witch and the wand");
        feedback1 = new Feedback(1,"1. This is my feedback for " + book1.getTitle().toString(),3,book1,reviewer1);
        feedback2 = new Feedback(2,"2. This is my feedback for " + book1.getTitle().toString(),4,book1,reviewer2);
        book2 = new Book(2, "Darcy's Doughnuts");
        feedback3 = new Feedback(3,"3. This is my feedback for " + book2.getTitle().toString(),3,book2, reviewer3);
        feedback4 = new Feedback(4,"4. This is my feedback for " + book2.getTitle().toString(),2,book2, reviewer1);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testIsComplete(){
        System.out.println("Book: " + book1);
        System.out.println("Feedback 1: " + feedback1.toString() + " Reviewer: " + feedback1.getReviewer().toString());
        System.out.println("Feedback 2: " + feedback2.toString() + " Reviewer: " + feedback2.getReviewer().toString());
        System.out.println("Book: " + book2);
        System.out.println("Feedback 3: " + feedback3.toString() + " Reviewer: " + feedback3.getReviewer().toString());
        System.out.println("Feedback 4: " + feedback4.toString() + " Reviewer: " + feedback4.getReviewer().toString());
    }
}
