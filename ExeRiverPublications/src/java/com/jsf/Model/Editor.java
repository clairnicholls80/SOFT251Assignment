/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author clair
 */
public class Editor extends User  implements UserInterface, Serializable{    
    private String result;
    private ArrayList<Editor> editors;
    private SaveData thisSaveData = new SaveData();
    private String user;
    
    /**
     *
     * @return List of Editors
     */
    public ArrayList<Editor> getEditors() {
        return editors;
    }

    /**
     *
     * @param editors
     */
    public void setEditors(ArrayList<Editor> editors) {
        this.editors = editors;
    }
    /**
     * Empty constructor for Editor
     */
    public Editor() {
    }
    
    /**
     * Parameterised constructor for Editor
     * @param userId
     * @param forename
     * @param surname
     * @param email
     * @param address
     * @param password
     */
    public Editor(int userId, String forename, String surname, String email, String address, String password) {
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
        String msg = (String) book.getUpdate(this);
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
     * Sets the data ready for saving
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
     * saves the results to a serialised file
     */
    public void saveResults() 
   {
        String filename = "editor.ser";
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
}
