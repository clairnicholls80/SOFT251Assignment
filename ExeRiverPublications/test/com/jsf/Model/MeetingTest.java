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
public class MeetingTest {
        
    private static Meeting meeting1, meeting2, meeting3;
    private static Book book1, book2;
    
    public MeetingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        meeting1 = new Meeting(1, "These are the initial meeting notes", book1);        
        meeting2 = new Meeting(2, "These are the second meeting notes", book1);
        meeting3 = new Meeting(3, "These are the first notes for this book.", book2);
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
        System.out.println("Meeting 1: " + meeting1.toString() + " Book: " + meeting1.getBook().toString());
        System.out.println("Meeting 2: " + meeting2.toString() + " Book: " + meeting2.getBook().toString());
        System.out.println("Book: " + book2);
        System.out.println("Meeting 3: " + meeting3.toString() + " Book: " + meeting3.getBook().toString());
        
    }
}
