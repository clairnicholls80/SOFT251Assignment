package com.jsf.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author clair
 */
public class SerialisationTest {
    
    private static Agent agent;
    
    /**
     *
     */
    public SerialisationTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        agent = new Agent("Philip", "Davey", "pdavey@publishinghouse.co.uk", "33 Station Road, Exeter EX1 1AB", "davesrbest");
        agent.setName(agent.forename, agent.surname);
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
        agent=null;
    }    

    /**
     *
     */
    @Before
    public void setUp() {
        try {
            FileOutputStream fs = new FileOutputStream("agent.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(agent);
            os.close();
        } 
        catch(Exception ex) {
            ex.printStackTrace();
        }
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
        try{
            FileInputStream fs = new FileInputStream("agent.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            Object one = os.readObject();
            Agent fileAgent = (Agent) one;
            os.close();
            System.out.println("Agent Name is: " + fileAgent.getName());
            System.out.println("Agent details are: " + fileAgent.getUserDetails());       
            assertEquals(agent.forename + " " + fileAgent.surname, fileAgent.name);        
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
