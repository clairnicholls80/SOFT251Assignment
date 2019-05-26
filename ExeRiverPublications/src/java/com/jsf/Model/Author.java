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


    
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    /**
     *
     */
    public Author() {
    }    
    /**
     *
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
    public void setBook(Book book) {
        this.book = book;
        this.book.register(this);
    }
     
    public void setData(){
        //setResult(this.toString());
        
        user=this.forename + ", " + this.surname + ", " + this.email + ", " + this.address;
        setResult(user);
        thisSaveData.setdata(result);
    }
       
   public String getResult() {
      return result;
   }

   public void setResult(String result1) {
      result = result1;
   }
   
//   public void setResultList(List<Author> list){
//       resultList = list;
//   }
    
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
   
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
