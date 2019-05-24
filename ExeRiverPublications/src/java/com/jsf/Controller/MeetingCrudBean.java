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
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
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
        //item.setPayments((ArrayList<Payment>) paymentList);//save to the model list
        resetAdd();
        
        
    }
    public MeetingCrudBean(){}
    
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }
    
    public void add() {
    	// DAO save the add
//        item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
//        list.add(item);
//        item = new Agent();

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            //item.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
            
            item.setData();
            item.saveResults();
            meetingList.add(item);
            item = new Meeting();
            //resultPanel.setRendered(true);
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            //resultPanel.setRendered(false);
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }
        //util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Meeting();

    	//util.redirectWithGet();
    }

    public void edit(Meeting item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Meeting();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Meeting();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Meeting item) throws IOException {
    	// DAO save the delete
        meetingList.remove(item);

        //util.redirectWithGet();
    }

    public List<Meeting> getList() {
        return meetingList;
    }

    public Meeting getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}