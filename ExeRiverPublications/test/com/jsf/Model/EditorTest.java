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
public class EditorTest {
    private static Editor editor;

    /**
     *
     */
    public EditorTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        editor = new Editor(1,"Phillipa", "Frost", "pfrost@exeriverpublishing.co.uk", "13 Prospect Street, Exeter EX2 4RR", "prospects");
        editor.setName(editor.forename, editor.surname);
        
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
        System.out.println("Editor Name is: " + editor.getName());
        System.out.println("Editor Details are: " + editor.getUserDetails());       
        assertEquals(editor.forename + " " + editor.surname, editor.name);
    }
}
