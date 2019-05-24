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
public class PaymentTest {
    
    private static Payment payment1, payment2, payment3;
    private static Book book1, book2;
    
    public PaymentTest() {
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        payment1 = new Payment(1,"Advance", 100, false, book1);        
        payment2 = new Payment(2, "Final", 500, true,book1);
        payment3 = new Payment(3, "Advance", 150, false, book2);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
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
        System.out.println("Payment 1: " + payment1.toString() + " Book: " + payment1.getBook().toString());
        System.out.println("Payment 2: " + payment2.toString() + " Book: " + payment2.getBook().toString());
        System.out.println("Book: " + book2);
        System.out.println("Payment 3: " + payment3.toString() + " Book: " + payment3.getBook().toString());
        
    }
    
}
