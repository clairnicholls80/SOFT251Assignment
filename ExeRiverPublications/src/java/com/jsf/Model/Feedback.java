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
import java.util.List;

/**
 *
 * @author clair
 */
public class Feedback implements Serializable {
    private int feedbackId;
    private String comments;
    private Integer rating;
    private Book book;
    private Reviewer reviewer;
    private String feedback;
    private String result;
    private List<Feedback> feedbackHistory;
    private SaveData thisSaveData = new SaveData();


    public Feedback(int feedbackId, String comments, Integer rating, Book book, Reviewer reviewer) {
        this.feedbackId = feedbackId;
        this.comments = comments;
        this.rating = rating;
        this.book = book;
        this.reviewer = reviewer;
    }

    public Feedback() {
    }

    public Feedback(int i, String this_is_my_first_comment, int i0, Book book1) {
        this.feedbackId = feedbackId;
        this.comments = comments;
        this.rating = rating;
        this.book = book;
    }


    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public List<Feedback> getFeedbackList() {
        return feedbackHistory;
    }

    public void setFeedbackList(List<Feedback> feedbackHistory) {
        this.feedbackHistory = feedbackHistory;
    }
    
    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

        
    @Override
    public String toString() {
        return feedbackId + ", " + comments + ", " + rating;
    }

    public void restore(Feedback fb) {        
        this.feedbackId = fb.getFeedbackId();
        this.comments = fb.getComments();
        this.rating = fb.getRating();
        this.reviewer = fb.getReviewer();
    }
    
    public void setData(){
        //setResult(this.toString());
        
        feedback=this.comments + ", " + this.rating + ", " + this.reviewer + ", " + this.book;
        setResult(feedback);
        thisSaveData.setdata(result);
    }
    public String getResult() {
       return result;
    }

    public void setResult(String result1) {
       result = result1;
    }
    public void saveResults() 
   {
        String filename = "feedback.ser";
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
