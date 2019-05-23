/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.Serializable;

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


    public Feedback(int feedbackId, String comments, Integer rating, Book book, Reviewer reviewer) {
        this.feedbackId = feedbackId;
        this.comments = comments;
        this.rating = rating;
        this.book = book;
        this.reviewer = reviewer;
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
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
        
    @Override
    public String toString() {
        return feedbackId + ", " + comments + ", " + rating;
    }
}
