/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Administrator;
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
@Named(value = "administratorCrudBean")
@SessionScoped
public class AdministratorCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Administrator> list;
    private Administrator item = new Administrator();
    private Administrator beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        list = new ArrayList<Administrator>();
    }
    public AdministratorCrudBean(){}
    
    public void add() {
    	// DAO save the add
        item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
        list.add(item);
        item = new Administrator();

        //util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Administrator();

    	//util.redirectWithGet();
    }

    public void edit(Administrator item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Administrator();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Administrator();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Administrator item) throws IOException {
    	// DAO save the delete
        list.remove(item);

        //util.redirectWithGet();
    }

    public List<Administrator> getList() {
        return list;
    }

    public Administrator getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}