/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author clair
 */
public class Author extends User implements UserInterface, Serializable {
    //private static final long serialVersionUID = 1L;

    private String result;
    private ArrayList<Author> authors;
    private SaveData thisSaveData = new SaveData();
    private String user;
    private String msg = null;

    /**
     *
     * @return List of Authors
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    /**
     * Empty constructor for Author
     */
    public Author() {
    }    
    /**
     * Constructor for parameterised author
     * @param userId
     * @param forename
     * @param surname
     * @param email
     * @param address
     * @param password
     */
    public Author(int userId, String forename, String surname, String email, String address, String password) {
        this.userId = userId;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    
    /**
     *
     * @param state
     */
    @Override
    public void update(State state) {
        setMsg((String) book.getUpdate(this));
        //String msg = (String) book.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);    
    }
    
    /**
     *
     * @param copy
     */
    @Override
    public void setSubject(Book copy) {
       this.book=copy;    
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
        this.book.register(this);
    }
     
    /**
     * sets the data ready to be saved
     */
    public void setData(){
        //setResult(this.toString());
        
        user=this.forename + ", " + this.surname + ", " + this.email + ", " + this.address;
        setResult(user);
        thisSaveData.setdata(result);
    }
       
    /**
     *
     * @return result
     */
    public String getResult() {
      return result;
   }

    /**
     *
     * @param result1
     */
    public void setResult(String result1) {
      result = result1;
   }
   
    /**
     * Saves the data to a serialised file
     */
    
    public void saveResults() 
    {
        String filename = "author.ser";
        System.out.println("This is what we are trying to save: "+ thisSaveData.getdata());
     
        try
        {
            FileOutputStream fout = new FileOutputStream(filename,true);
            ObjectOutputStream oos = new ObjectOutputStream(fout);  
            oos.writeObject(thisSaveData);
            oos.close();
            System.out.println("Done");
        }
        catch(Exception ex)
        {
             ex.printStackTrace();
        } 

        thisSaveData.cleardata();
   }
   
    /**
     * Method to load the data from the serialised file
     * @throws IOException
     */
    public void loadResults() throws IOException 
   {
       String filename = "author.ser";
       SaveData newSaver = null;
       Scanner sc = null;
       String output = null;
       try
       { 
            File file= new File(filename);
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fin);
                        
            newSaver = (SaveData) ois.readObject();
            newSaver = (SaveData) ois.readObject();
            newSaver = (SaveData) ois.readObject();
            newSaver = (SaveData) ois.readObject();
            newSaver = (SaveData) ois.readObject();                        	   
        }
            
        catch(Exception ex)
        {
            ex.printStackTrace(); 
	} 
       
       setResult(newSaver.getdata());
       System.out.println("The result saved was: " + result);
   }
   
    /**
     * Method used for getting the message on the home screen
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Method used for setting the message on the home screen
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
