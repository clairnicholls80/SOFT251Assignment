package com.jsf.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author clair
 */
public class AgentTest {
    
    private static Agent agent;
    
    /**
     *
     */
    public AgentTest() {
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
        System.out.println("Agent Name is: " + agent.getName());
        System.out.println("Agent details are: " + agent.getUserDetails());       
        assertEquals(agent.forename + " " + agent.surname, agent.name);
    }
}
