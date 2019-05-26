/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import com.jsf.Model.Agent;
import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Editor;
import com.jsf.Model.Feedback;
import com.jsf.Model.Reviewer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

/**
 *
 * @author clair
 */
@ManagedBean(name="feedbackCrudBean")
@SessionScoped
public class FeedbackCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Feedback> feedbackList;
    private Feedback item = new Feedback();
    private Feedback beforeEditItem = null;
    private boolean edit;
    private List<Author> authorList;
    private List<Reviewer> reviewerList;
    private Administrator admin1;
    private Editor editor1, editor2;
    private Author author1, author2, author3;    
    private Reviewer reviewer1, reviewer2, reviewer3, reviewer4;
    private Agent agent1;
    private Book book1, book2, book3, book4;
    //private List<Author> authors;
    //private UIPanel resultPanel;

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
        //create reviewers
        reviewer1 = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.getForename(), reviewer1.getSurname());
        reviewer2 = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer2.getForename(), reviewer2.getSurname());
        reviewer3 = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer3.getForename(), reviewer3.getSurname());
        reviewer4 = new Reviewer(4,"Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        reviewer4.setName(reviewer4.getForename(), reviewer4.getSurname());         
               
        feedbackList = new ArrayList<Feedback>();
        item = new Feedback(1, "This is my first comment", 4, book1, reviewer1);
        item.setData();
        item.saveResults();
        feedbackList.add(item);
        item = new Feedback(2, "This is more comments", 5, book2, reviewer2);
        item.setData();
        item.saveResults();
        feedbackList.add(item);
        item = new Feedback(3, "This is another comment", 4, book3, reviewer3);
        item.setData();
        item.saveResults();
        feedbackList.add(item);
        item = new Feedback(4, "This is even more comments", 3, book4, reviewer4);
        item.setData();
        item.saveResults();
        feedbackList.add(item);
        
        item.setFeedbackList((ArrayList<Feedback>) feedbackList);//save to the model list
        resetAdd();

    }
    public FeedbackCrudBean(){}
    
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
    
    public void add() {
    	// DAO save the add
        //item.setBookId(list.isEmpty() ? 1 : list.get(list.size() - 1).getBookId() + 1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            //item.setBookId(bookList.isEmpty() ? 1 : bookList.get(bookList.size() - 1).getBookId()+ 1);
            item.setData();
            item.saveResults();
            feedbackList.add(item);
            //item.setBooks((ArrayList<Book>) bookList);//save to the model list
            resetAdd();
//            item.setBookList(bookList);
//            item.saveListResults();
            item = new Feedback();
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
    	item = new Feedback();
    	//util.redirectWithGet();
    }

    public void edit(Feedback item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Feedback();
        edit = false;
        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Feedback();
        edit = false;
        //util.redirectWithGet();
    }

    public void delete(Feedback item) throws IOException {
    	// DAO save the delete
        feedbackList.remove(item);
        //util.redirectWithGet();
    }

    public List<Feedback> getList() {
        return feedbackList;
    }

    public Feedback getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
  

    public List<Reviewer> getReviewerList() {
        return reviewerList;
    }

    public void setReviewerList(List<Reviewer> reviewerList) {
        this.reviewerList = reviewerList;
    }

}