/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.util.ArrayList;
import java.util.Arrays;
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
public class BookTest {
   
    private static Book book1, book2, book3, book4, book5, book6, book7, book8, book9, book10;
    private static Administrator admin1;
    private static Editor editor1, editor2;
    private static Author author1, author2, author3;
    private static Reviewer reviewer1, reviewer2, reviewer3, reviewer4;
    private static Agent agent1;
    //private static ArrayList<String> bookList;
    private static List<String> bookList;
    
    /**
     *
     */
    public BookTest() {
    }
    @BeforeClass
    public static void setUpClass() {              
        //create objects of books
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        book3 = new Book(3, "We're going on a turtle adventure");
        book4 = new Book(4, "Diary of a cool kid");
        book5 = new Book(5, "Wonky Donky");
        book6 = new Book(6, "Cornish Coves");
        book7 = new Book(7, "Dark tides");
        book8 = new Book(8, "Lines of order");
        book9 = new Book(9, "The story of my life");
        book10 = new Book(10, "Village life");
        
        /* Create users */
        //create Administrator
        admin1 = new Administrator(1,"Clair", "Nicholls", "clair@gmail.com", "8 Copper Meadows, Redruth, TR152NX", "letmein");
        admin1.setName(admin1.forename, admin1.surname);
        //create Editors
        editor1 = new Editor(1,"Edward", "Richey", "erichey@exeriverpublishing.co.uk", "1a Long Drive, Exmouth EX10 3ER", "richness");
        editor1.setName(editor1.forename, editor1.surname);        
        editor2 = new Editor(2,"Phillipa", "Frost", "pfrost@exeriverpublishing.co.uk", "13 Prospect Street, Exeter EX2 4RR", "prospects");
        editor2.setName(editor2.forename, editor2.surname);
        //Create authors
        author1 = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        author1.setName(author1.forename, author1.surname);
        author2 = new Author(2,"Anna", "Alyn", "anna_a@hotmail.co.uk", "79 Grammercy Lane, Exeter EX7 7SA", "lollipops");
        author2.setName(author2.forename, author2.surname);
        author3 = new Author(3,"Steve", "Robins", "steverobins@live.co.uk", "22 New Lane, Exeter EX4 9PQ", "mountain1");
        author3.setName(author3.forename, author3.surname);
        //create reviewers
        reviewer1 = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.forename, reviewer1.surname);
        reviewer2 = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer2.forename, reviewer2.surname);
        reviewer3 = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer3.forename, reviewer3.surname);
        reviewer4 = new Reviewer(4,"Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        reviewer4.setName(reviewer4.forename, reviewer4.surname);         
        //create agent
        agent1 = new Agent(1,"Philip", "Davey", "pdavey@publishinghouse.co.uk", "33 Station Road, Exeter EX1 1AB", "davesrbest");
        agent1.setName(agent1.forename, agent1.surname);
        
        //register users to books (register observers)
        book1.setObservers();// = new ArrayList();
        book1.register(admin1);
        book1.register(author1);
        book1.register(agent1);
        book1.register(reviewer1);
        book1.register(reviewer2);
        book1.notifyObservers();
        
        book2.setObservers(); //= new ArrayList();
        book2.register(admin1);
        book2.register(author2);
        book2.register(agent1);
        book2.register(reviewer3);
        book2.register(reviewer4);
        book2.notifyObservers();
        
        book3.setObservers();// = new ArrayList();
        book3.register(admin1);
        book3.register(author2);
        book3.register(agent1);
        book3.register(reviewer1);
        book3.register(reviewer4);
        book3.notifyObservers();
        
        book4.setObservers();// = new ArrayList();
        book4.register(admin1);
        book4.register(author3);
        book4.register(agent1);
        book4.register(reviewer3);
        book4.register(reviewer2);
        book4.notifyObservers();
        
        book5.setObservers();// = new ArrayList();
        book5.register(admin1);
        book5.register(author3);
        book5.register(agent1);
        book5.register(reviewer2);
        book5.register(reviewer4);
        book5.notifyObservers();
        
        book6.setObservers();// = new ArrayList();
        book6.register(admin1);
        book6.register(author3);
        book6.register(agent1);
        book6.register(reviewer1);
        book6.register(reviewer3);
        book6.notifyObservers();
        
        book7.setObservers();// = new ArrayList();
        book7.register(admin1);
        book7.register(author2);
        book7.register(agent1);
        book7.register(reviewer2);
        book7.register(reviewer4);
        book7.notifyObservers();
        
        book8.setObservers();// = new ArrayList();
        book8.register(admin1);
        book8.register(author3);
        book8.register(agent1);
        book8.register(reviewer1);
        book8.register(reviewer2);
        book8.notifyObservers();
        
        book9.setObservers();// = new ArrayList();
        book9.register(admin1);
        book9.register(author2);
        book9.register(agent1);
        book9.register(reviewer3);
        book9.register(reviewer4);
        book9.notifyObservers();
        
        book10.setObservers();// = new ArrayList();
        book10.register(admin1);
        book10.register(author1);
        book10.register(agent1);
        book10.register(reviewer1);
        book10.register(reviewer4);
        book10.notifyObservers();
        
        //link users to books        
        author1.setSubject(book1);
        author1.setSubject(book10);
        //author1.update();
        
        author2.setSubject(book2);
        author2.setSubject(book3);
        author2.setSubject(book7);
        author2.setSubject(book9);
        //author2.update();
        
        author3.setSubject(book4);
        author3.setSubject(book5);
        author3.setSubject(book6);
        author3.setSubject(book8);
        //author3.update();   
        
        agent1.setSubject(book1);
        agent1.setSubject(book2);
        agent1.setSubject(book3);
        agent1.setSubject(book4);
        agent1.setSubject(book5);
        agent1.setSubject(book6);
        agent1.setSubject(book7);
        agent1.setSubject(book8);
        agent1.setSubject(book9);
        agent1.setSubject(book10);
        //agent1.update();
        
        //editor1.setSubject(book2);
        //editor1.update();
        
        reviewer1.setSubject(book1);        
        reviewer1.setSubject(book3);        
        reviewer1.setSubject(book4);        
        reviewer1.setSubject(book8);        
        reviewer1.setSubject(book10);
        //reviewer1.update();
        
        reviewer2.setSubject(book1);        
        reviewer2.setSubject(book4);        
        reviewer2.setSubject(book5);        
        reviewer2.setSubject(book7);        
        reviewer2.setSubject(book8);
        //reviewer2.update();
                
        reviewer3.setSubject(book2);        
        reviewer3.setSubject(book4);        
        reviewer3.setSubject(book6);        
        reviewer3.setSubject(book9); 
        //reviewer3.update();
        
        reviewer4.setSubject(book2);        
        reviewer4.setSubject(book3);        
        reviewer4.setSubject(book5);        
        reviewer4.setSubject(book7);       
        reviewer4.setSubject(book9);        
        reviewer4.setSubject(book10);  
        //reviewer4.update();
        
        book1.setState(State.Accepted);
        book1.notifyObservers();
        
        bookList = Arrays.asList( book1.getTitle(), book2.getTitle(), book3.getTitle(), book4.getTitle(), book5.getTitle());

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
    public void testGetBookId() {
    }

    /**
     *
     */
    @Test
    public void testSetBookId() {
    }

    /**
     *
     */
    @Test
    public void testGetTitle() {
    }

    /**
     *
     */
    @Test
    public void testSetTitle() {
    }

    /**
     *
     */
    @Test
    public void testGetFileName() {
    }

    /**
     *
     */
    @Test
    public void testSetFileName() {
    }

    /**
     *
     */
    @Test
    public void testGetLocation() {
    }

    /**
     *
     */
    @Test
    public void testSetLocation() {
    }

    /**
     *
     */
    @Test
    public void testGetState() {
    }

    /**
     *
     */
    @Test
    public void testSetState() {
    }

    /**
     *
     */
    @Test
    public void testGetPayment() {
    }

    /**
     *
     */
    @Test
    public void testSetPayment() {
    }

    /**
     *
     */
    @Test
    public void testGetFeedback() {
    }

    /**
     *
     */
    @Test
    public void testSetFeedback() {
    }

    /**
     *
     */
    @Test
    public void testGetMeeting() {
    }

    /**
     *
     */
    @Test
    public void testSetMeeting() {
    }

    /**
     *
     */
    @Test
    public void testGetUpdate() {
    }

    /**
     *
     */
    @Test
    public void testRegister() {
    }

    /**
     *
     */
    @Test
    public void testUnregister() {
    }

    /**
     *
     */
    @Test
    public void testNotifyObservers() {
    }

    /**
     *
     */
    @Test
    public void testPostMessage() {
    }    

    /**
     *
     */
    @Test
    public void testIsComplete(){
        System.out.println("Admin1: " + admin1.getName());
        System.out.println("User = " + admin1.getUserDetails());
        System.out.println("Author1: " + author1.getName());
        System.out.println("User = " + author1.getUserDetails());    
               
        System.out.println("Book1 is: " + book1.getTitle()); 
        System.out.println("Observers are:");
        book1.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book2 is: " + book2.getTitle());  
        System.out.println("Observers are:");      
        book2.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book3 is: " + book3.getTitle()); 
        System.out.println("Observers are:");
        book3.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book4 is: " + book4.getTitle());  
        System.out.println("Observers are:");      
        book4.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");        
        System.out.println("Book5 is: " + book5.getTitle()); 
        System.out.println("Observers are:");
        book5.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book6 is: " + book6.getTitle());  
        System.out.println("Observers are:");      
        book6.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book7 is: " + book7.getTitle()); 
        System.out.println("Observers are:");
        book7.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book8 is: " + book8.getTitle());  
        System.out.println("Observers are:");      
        book8.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");                
        System.out.println("Book9 is: " + book9.getTitle()); 
        System.out.println("Observers are:");
        book9.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        System.out.println("Book10 is: " + book10.getTitle());  
        System.out.println("Observers are:");      
        book10.getObservers().forEach((o)->System.out.println(o));
        System.out.println("-----");
        
        System.out.println("BookList: " + bookList);
        //bookList.forEach((o)->System.out.println(o));
    }
    
}
