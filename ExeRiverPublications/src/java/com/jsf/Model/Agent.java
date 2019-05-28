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
public class Agent extends User  implements UserInterface, Serializable{
    private String result;
    private ArrayList<Agent> agents;
    private SaveData thisSaveData = new SaveData();
    private String user;
    
    /**
     *
     * @return List of Agents
     */
    public ArrayList<Agent> getAgents() {
        return agents;
    }

    /**
     *
     * @param authors
     */
    public void setAgents(ArrayList<Agent> authors) {
        this.agents = agents;
    }
    
    
    /**
     * Empty constructor
     */
    public Agent() {
    }
    
    /**
     * Constructor for the Agent method using parameters
     * @param userId
     * @param forename
     * @param surname
     * @param email
     * @param address
     * @param password
     */
    public Agent(int userId,String forename, String surname, String email, String address, String password) {
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
     * sets the data for the save method
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
     * Method to save the data to the serialised file
     */
    public void saveResults() 
   {
        String filename = "agent.ser";
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
