/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

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
    private List<Editor> editorList;
    private Editor item = new Editor();
    private Editor beforeEditItem = null;
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
     * initialises the data due to serialisation issues
     */
    @PostConstruct
    public void init() {
        editorList = new ArrayList<Editor>();
        
        item = new Editor(1,"Edward", "Richey", "erichey@exeriverpublishing.co.uk", "1a Long Drive, Exmouth EX10 3ER", "richness");
        item.setName(item.getForename(), item.getSurname());         
        item.setData();
        item.saveResults();
        editorList.add(item);
        item = new Editor(2,"Phillipa", "Frost", "pfrost@exeriverpublishing.co.uk", "13 Prospect Street, Exeter EX2 4RR", "prospects");
        item.setName(item.getForename(), item.getSurname());
        item.setData();
        item.saveResults();
        editorList.add(item);
               
        item.setEditors((ArrayList<Editor>) editorList);//save to the model list
        resetAdd();
        
    }

    /**
     * empty constructor
     */
    public EditorCrudBean(){}
    
    /**
     * adds the editor
     */
    public void add() {
    	// DAO save the add
        item.setUserId(editorList.isEmpty() ? 1 : editorList.get(editorList.size() - 1).getUserId() + 1);
        editorList.add(item);
        item = new Editor();

    }

    /**
     * resets the add function
     */
    public void resetAdd() {
    	item = new Editor();

    	//util.redirectWithGet();
    }

    /**
     *
     * @param item
     */
    public void edit(Editor item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

    }

    /**
     * cancel the edit and restore to previous version
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Editor();
        edit = false;

    }

    /**
     * save the edit
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Editor();
        edit = false;

    }

    /**
     * remove the selected editor
     * @param item
     * @throws IOException
     */
    public void delete(Editor item) throws IOException {
    	// DAO save the delete
        editorList.remove(item);
    }

    /**
     *
     * @return list of editors
     */
    public List<Editor> getEditorList() {
        return editorList;
    }

    /**
     *
     * @param editorList
     */
    public void setEditorList(List<Editor> editorList) {
        this.editorList = editorList;
    }
    
    /**
     *
     * @return item
     */
    public Editor getItem() {
        return this.item;
    }

    /**
     *
     * @return edit
     */
    public boolean isEdit() {
        return this.edit;
    }
}