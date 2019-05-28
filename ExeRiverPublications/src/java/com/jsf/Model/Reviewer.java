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
public class Reviewer extends User  implements UserInterface, Serializable{
         
    private String result;
    private ArrayList<Reviewer> reviewers;
    private SaveData thisSaveData = new SaveData();
    private String user;
    
    /**
     *
     * @return List of reviewers
     */
    public ArrayList<Reviewer> getReviewers() {
        return reviewers;
    }

    /**
     *
     * @param reviewers
     */
    public void setReviewers(ArrayList<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }
    /**
     * Empty constructor for Reviewer
     */
    public Reviewer() {
    }
    
    /**
     * Parameterised constructor for reviewer
     * @param userId
     * @param forename
     * @param surname
     * @param email
     * @param address
     * @param password
     */
    public Reviewer(int userId, String forename, String surname, String email, String address, String password) {
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
     * sets the data ready to save
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
        String filename = "reviewers.ser";
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
