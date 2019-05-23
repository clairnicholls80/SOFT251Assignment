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
public class Meeting implements Serializable{
    private Integer meetingId;
    private String notes;
    private Book book;



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
    
    
    
}
