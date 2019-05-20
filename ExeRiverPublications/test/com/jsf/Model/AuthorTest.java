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
public class AuthorTest {
    
    private static Author author;
    
    /**
     *
     */
    public AuthorTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        author = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        author.setName(author.forename, author.surname);
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
        System.out.println("Author Name is: " + author.getName());
        System.out.println("Author Details are: " + author.getUserDetails());        
    }
}
