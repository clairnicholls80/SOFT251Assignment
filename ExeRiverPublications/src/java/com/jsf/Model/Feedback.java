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

    /**
     * Parameterised constructor for Feedback
     * @param feedbackId
     * @param comments
     * @param rating
     * @param book
     * @param reviewer
     */
    public Feedback(int feedbackId, String comments, Integer rating, Book book, Reviewer reviewer) {
        this.feedbackId = feedbackId;
        this.comments = comments;
        this.rating = rating;
        this.book = book;
        this.reviewer = reviewer;
    }

    /**
     * Empty constructor for Feedback
     */
    public Feedback() {
    }

    /**
     *
     * @param feedbackId
     * @param comments
     * @param rating
     * @param book
     */
    public Feedback(int feedbackId, String comments, int rating, Book book) {
        this.feedbackId = feedbackId;
        this.comments = comments;
        this.rating = rating;
        this.book = book;
    }

    /**
     *
     * @return feedbackId
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     *
     * @param feedbackId
     */
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     *
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return rating
     */ 
    public Integer getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    /**
     *
     * @return list of feedback history
     */
    public List<Feedback> getFeedbackList() {
        return feedbackHistory;
    }

    /**
     *
     * @param feedbackHistory
     */
    public void setFeedbackList(List<Feedback> feedbackHistory) {
        this.feedbackHistory = feedbackHistory;
    }
    
    /**
     *
     * @return reviewer
     */
    public Reviewer getReviewer() {
        return reviewer;
    }

    /**
     *
     * @param reviewer
     */
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
    
    /**
     *
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * @return string of details of feedback
     */
    @Override
    public String toString() {
        return feedbackId + ", " + comments + ", " + rating;
    }

    /**
     *
     * @param fb
     */
    public void restore(Feedback fb) {        
        this.feedbackId = fb.getFeedbackId();
        this.comments = fb.getComments();
        this.rating = fb.getRating();
        this.reviewer = fb.getReviewer();
    }
    
    /**
     * sets the data ready for saving
     */
    public void setData(){        
        feedback=this.comments + ", " + this.rating + ", " + this.reviewer + ", " + this.book;
        setResult(feedback);
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
     * method to save the results to a serialised file
     */
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
