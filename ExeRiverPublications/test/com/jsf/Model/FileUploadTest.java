/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class FileUploadTest {
    static String fileName =null;
    String line = null;
    
    public FileUploadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // The name of the file to open.
        fileName = "c:\\temp\\manscript1.txt";

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
        try {            
            FileReader fileReader = new FileReader(fileName);// FileReader reads text files in the default encoding.
            BufferedReader bufferedReader = new BufferedReader(fileReader);// Always wrap FileReader in BufferedReader.
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }               
            bufferedReader.close(); // Always close files.        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: // ex.printStackTrace();
        }
    }    
}
