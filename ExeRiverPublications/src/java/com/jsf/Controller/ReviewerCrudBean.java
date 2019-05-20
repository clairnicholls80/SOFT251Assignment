/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import com.jsf.Model.Author;
import com.jsf.Model.Reviewer;
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
@ManagedBean(name="reviewerCrudBean")
@SessionScoped
public class ReviewerCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Reviewer> reviewerList;
    private Reviewer item = new Reviewer();
    private Reviewer beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        reviewerList = new ArrayList<Reviewer>();
        
        item = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults(); 
        reviewerList.add(item);
        item = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults();         
        reviewerList.add(item);
        item = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults();         
        reviewerList.add(item);
        item = new Reviewer(4,"Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults(); 
        reviewerList.add(item);  
        item.setReviewers((ArrayList<Reviewer>) reviewerList);//save to the model list
        resetAdd();
    }
    public ReviewerCrudBean(){}
    
//    public void add() {
//    	// DAO save the add
//        item.setUserId(reviewerList.isEmpty() ? 1 : reviewerList.get(reviewerList.size() - 1).getUserId() + 1);
//        reviewerList.add(item);
//        item = new Reviewer();
//
//        //util.redirectWithGet();
//    }

    public void resetAdd() {
    	item = new Reviewer();

    	//util.redirectWithGet();
    }

    public void edit(Reviewer item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Reviewer();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Reviewer();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Reviewer item) throws IOException {
    	// DAO save the delete
        reviewerList.remove(item);

        //util.redirectWithGet();
    }

    public List<Reviewer> getList() {
        return reviewerList;
    }

    public Reviewer getItem() {
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
            reviewerList.add(item);
            item = new Reviewer();
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
}