/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Agent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author clair
 */
@ManagedBean(name="agentCrudBean")
@SessionScoped
public class AgentCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Agent> list;
    private Agent item = new Agent();
    private Agent beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        list = new ArrayList<Agent>();
    }
    public AgentCrudBean(){}
    
    public void add() {
    	// DAO save the add
        item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
        list.add(item);
        item = new Agent();

        //util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Agent();

    	//util.redirectWithGet();
    }

    public void edit(Agent item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Agent();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Agent();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Agent item) throws IOException {
    	// DAO save the delete
        list.remove(item);

        //util.redirectWithGet();
    }

    public List<Agent> getList() {
        return list;
    }

    public Agent getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}