/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import com.jsf.Model.Reviewer;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author clair
 */
@Named(value = "reviewerCrudBean")
@SessionScoped
public class ReviewerCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Reviewer> list;
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
        list = new ArrayList<Reviewer>();
    }
    public ReviewerCrudBean(){}
    
    public void add() {
    	// DAO save the add
        item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
        list.add(item);
        item = new Reviewer();

        //util.redirectWithGet();
    }

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
        list.remove(item);

        //util.redirectWithGet();
    }

    public List<Reviewer> getList() {
        return list;
    }

    public Reviewer getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}