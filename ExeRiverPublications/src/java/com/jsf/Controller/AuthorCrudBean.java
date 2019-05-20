/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name="authorCrudBean")
@SessionScoped
public class AuthorCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Author> authorList;
    private Author item = new Author();
    private Author beforeEditItem = null;
    private boolean edit;    
    //private UIPanel resultPanel;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
    @PostConstruct
    public void init() {
        //authorList = new ArrayList<Author>();
        
        authorList =  new ArrayList<Author>();
        item = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        //author1.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        //item.setName(item.forename, item.surname);
        item.setData();
        item.saveResults();
        authorList.add(item);
        //author1.setAuthors(authorList);

        //authorList.add(author1);
        //author1 = new Author();
        item = new Author(2,"Anna", "Alyn", "anna_a@hotmail.co.uk", "79 Grammercy Lane, Exeter EX7 7SA", "lollipops");
        //author2.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        //author2.setName(author2.forename, author2.surname);
        item.setData();
        item.saveResults();
        authorList.add(item);
        //author2.setAuthors(authorList);
        
        item = new Author(3,"Steve", "Robins", "steverobins@live.co.uk", "22 New Lane, Exeter EX4 9PQ", "mountain1");
        //author3.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        item.setName(item.getForename(), item.getSurname());        
        item.setData();
        item.saveResults();
        authorList.add(item);
        item.setAuthors((ArrayList<Author>) authorList);//save to the model list
        resetAdd();
        //item = new Author(4,"","","","","");
        //item.setData();
        
        //item = new Author();
        //authorList =  item.getAuthors(); // = getList();
    }
    
    
    public void add() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            //item.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
            
            item.setData();
            item.saveResults();
            authorList.add(item);
            item = new Author();
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
    }

    public void resetAdd() {
    	item = new Author();
        item.setForename(null);
        item.setSurname(null);
    }

    public void edit(Author item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Author();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Author();
        edit = false;
    }

    public void delete(Author item) throws IOException {
    	// DAO save the delete
        authorList.remove(item);
    }

    public List<Author> getList() {
        return authorList;
    }

    public Author getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}