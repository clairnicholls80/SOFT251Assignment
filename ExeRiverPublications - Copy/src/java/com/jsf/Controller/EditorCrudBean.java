/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import com.jsf.Model.Editor;
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
@ManagedBean(name="editorCrudBean")
@SessionScoped
public class EditorCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Editor> list;
    private Editor item = new Editor();
    private Editor beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        list = new ArrayList<Editor>();
    }
    public EditorCrudBean(){}
    
    public void add() {
    	// DAO save the add
        item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
        list.add(item);
        item = new Editor();

        //util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Editor();

    	//util.redirectWithGet();
    }

    public void edit(Editor item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Editor();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Editor();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Editor item) throws IOException {
    	// DAO save the delete
        list.remove(item);

        //util.redirectWithGet();
    }

    public List<Editor> getList() {
        return list;
    }

    public Editor getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}