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
public class Meeting implements Serializable{
    private Integer meetingId;
    private String notes;
    private Book book;
    private String result;
    private ArrayList<Meeting> meetings;
    private SaveData thisSaveData = new SaveData();
    private String meeting;
    
    public Meeting() {        
    }



    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
        
    public Meeting(Integer meetingId, String notes, Book book) {
        this.meetingId = meetingId;
        this.notes = notes;
        this.book = book;
    }

    @Override
    public String toString() {
        return meetingId + ", " + notes;
    }

    public void restore(Meeting m) {
        this.notes = m.notes;
        this.book = m.book;
                
    }
    public void setData() {
        meeting=this.notes + ", " + this.book;
        setResult(meeting);
        thisSaveData.setdata(result);    
    }

    public void saveResults() {
        String filename = "meeting.ser";
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

    public String getResult() {
       return result;
    }

    public void setResult(String result1) {
       result = result1;
    }
    
    
}
