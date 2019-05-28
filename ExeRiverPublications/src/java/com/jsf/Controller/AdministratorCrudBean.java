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

    /**
     *
     * @param util
     */
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    /**
     * This sets up the data for the form due to serialisation issues
     */
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

    /**
     *
     */
    public AdministratorCrudBean(){}

    /**
     * sets the new instance of Administrator
     */
    public void resetAdd() {
    	item = new Administrator();
    }

    /**
     *
     * @param item
     */
    public void edit(Administrator item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    /**
     * restores the previous values to cancel the changes
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Administrator();
        edit = false;

        //util.redirectWithGet();
    }

    /**
     * saves the changes
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Administrator();
        edit = false;
    }

    /**
     * removes the row selected
     * @param item
     * @throws IOException
     */
    public void delete(Administrator item) throws IOException {
    	// DAO save the delete
        adminList.remove(item);
    }

    /**
     *
     * @return List of admins
     */
    public List<Administrator> getList() {
        return adminList;
    }

    /**
     *
     * @return administrator
     */
    public Administrator getItem() {
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
     * @return List of admins
     */
    public List<Administrator> getAdminList() {
        return adminList;
    }

    /**
     *
     * @param adminList
     */
    public void setAdminList(List<Administrator> adminList) {
        this.adminList = adminList;
    }
    
    /**
     * adds a new administrator
     */
    public void add() {
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setData();
            item.saveResults();
            adminList.add(item);
            item = new Administrator();
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
}