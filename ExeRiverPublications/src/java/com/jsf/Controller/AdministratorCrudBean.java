/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import com.jsf.Model.Agent;
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
@ManagedBean(name="administratorCrudBean")
@SessionScoped
public class AdministratorCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Administrator> adminList;
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
        adminList = new ArrayList<Administrator>();
        
        item = new Administrator(1,"Clair", "Nicholls", "clair@gmail.com", "8 Copper Meadows, Redruth, TR152NX", "letmein");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults();
        adminList.add(item);        
        item.setAdmins((ArrayList<Administrator>) adminList);//save to the model list
        resetAdd();
    }
    public AdministratorCrudBean(){}
    
//    public void add() {
//    	// DAO save the add
//        item.setUserId(adminList.isEmpty() ? 1 : adminList.get(adminList.size() - 1).getUserId() + 1);
//        adminList.add(item);
//        item = new Administrator();
//
//        //util.redirectWithGet();
//    }

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
        adminList.remove(item);

        //util.redirectWithGet();
    }

    public List<Administrator> getList() {
        return adminList;
    }

    public Administrator getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }    
    
    public List<Administrator> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Administrator> adminList) {
        this.adminList = adminList;
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
            adminList.add(item);
            item = new Administrator();
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