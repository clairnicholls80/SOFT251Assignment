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

    /**
     *
     */
    public ReviewerCrudBean(){}
    

    /**
     * resets the add
     */
    public void resetAdd() {
    	item = new Reviewer();
    }

    /**
     *
     * @param item
     */
    public void edit(Reviewer item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

    }

    /**
     * cancels the edit
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Reviewer();
        edit = false;

    }

    /**
     * saves the edit
     */ 
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Reviewer();
        edit = false;

    }

    /**
     * removes the reviewer
     * @param item
     * @throws IOException
     */
    public void delete(Reviewer item) throws IOException {
    	// DAO save the delete
        reviewerList.remove(item);

    }

    /**
     *
     * @return list of reviewers
     */
    public List<Reviewer> getList() {
        return reviewerList;
    }

    /**
     *
     * @return item
     */
    public Reviewer getItem() {
        return this.item;
    }

    /**
     *
     * @return edit
     */
    public boolean isEdit() {
        return this.edit;
    }
    
    /**
     *
     * @return list of reviewers
     */
    public List<Reviewer> getReviewerList() {
        return reviewerList;
    }

    /**
     *
     * @param reviewerList
     */
    public void setReviewerList(List<Reviewer> reviewerList) {
        this.reviewerList = reviewerList;
    }
    
    /**
     * adds the reviewer
     */
    public void add() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setData();
            item.saveResults();
            reviewerList.add(item);
            item = new Reviewer();
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }
    }
}