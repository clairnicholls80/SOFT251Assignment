/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Agent;
import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Meeting;
import com.jsf.Model.Payment;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author clair
 */
@ManagedBean(name="meetingCrudBean")
@SessionScoped
public class MeetingCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Meeting item = new Meeting();
    private Meeting beforeEditItem = null;
    private boolean edit;
    private Meeting meeting1;
    private List<Meeting> meetingList;    
    private Book book1, book2, book3, book4;

  
    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;

    /**
     *
     * @param util
     */
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    /**
     *  initialise the data due to serialisation issues
     */
    @PostConstruct
    public void init() {
         //create books
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        book3 = new Book(3, "We're going on a turtle adventure");
        book4 = new Book(4, "Diary of a cool kid");
        meetingList = new ArrayList<Meeting>();
        item = new Meeting(1,"These are the notes from the first meeting.",book1);        
        item.setData();
        item.saveResults();
        meetingList.add(item);   
        
        item = new Meeting(2,"These are the notes from the second meeting.",book2);        
        item.setData();
        item.saveResults();
        meetingList.add(item);   
                
        item = new Meeting(3,"These are the notes from the third meeting",book1);        
        item.setData();
        item.saveResults();
        meetingList.add(item); 
                
        item = new Meeting(4,"Fourth meeting notes",book3);        
        item.setData();
        item.saveResults();
        meetingList.add(item);
        
        item = new Meeting(5,"Fifth book notes from telephone call",book4);        
        item.setData();
        item.saveResults();
        meetingList.add(item);
        resetAdd();
        
    }

    /**
     * empty constructor
     */
    public MeetingCrudBean(){}
    
    /**
     *
     * @return list of meetings
     */
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    /**
     *
     * @param meetingList
     */
    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }
    
    /**
     * adds the meeting
     */
    public void add() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setData();
            item.saveResults();
            meetingList.add(item);
            item = new Meeting();
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            //resultPanel.setRendered(false);
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }
    }

    /**
     * resets the add
     */
    public void resetAdd() {
    	item = new Meeting();
    }

    /**
     *
     * @param item
     */
    public void edit(Meeting item) {
        this.item = item;
        edit = true;
    }

    /**
     * cancels the edit
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Meeting();
        edit = false;

    }

    /**
     * saves the edit
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Meeting();
        edit = false;

    }

    /**
     * removes the selected meeting
     * @param item
     * @throws IOException
     */
    public void delete(Meeting item) throws IOException {
    	// DAO save the delete
        meetingList.remove(item);

    }

    /**
     *
     * @return list of meetings
     */
    public List<Meeting> getList() {
        return meetingList;
    }

    /**
     *
     * @return item
     */
    public Meeting getItem() {
        return this.item;
    }

    /**
     *
     * @return edit
     */
    public boolean isEdit() {
        return this.edit;
    }
}