/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Feedback;
import com.jsf.Model.State;
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
    private Book book1;
    private String message = null;
    private Feedback feedback = new Feedback();
    private String fb=null;

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
     * Initialise the data due to serialisation issues
     */
    @PostConstruct
    public void init() {
        
        authorList =  new ArrayList<Author>();
        item = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        item.setData();
        item.saveResults();
        authorList.add(item);
        
        item = new Author(2,"Anna", "Alyn", "anna_a@hotmail.co.uk", "79 Grammercy Lane, Exeter EX7 7SA", "lollipops");
        item.setData();
        item.saveResults();
        authorList.add(item);
        
        item = new Author(3,"Steve", "Robins", "steverobins@live.co.uk", "22 New Lane, Exeter EX4 9PQ", "mountain1");
        item.setName(item.getForename(), item.getSurname());        
        item.setData();
        item.saveResults();
        authorList.add(item);
        item.setAuthors((ArrayList<Author>) authorList);//save to the model list
        
        book1 = new Book(1, "The witch and the wand");
        book1.setObservers();// = new ArrayList();
        book1.register(item);          
        item.setSubject(book1);
        book1.setState(State.Accepted);
        book1.notifyObservers();
        item.update(State.Accepted);        
        
        feedback = new Feedback();
        feedback = new Feedback(1, "This is my first comment", 4, book1);
        feedback.setData();
        feedback.saveResults();
        setMessage("Book state updated to '" + book1.getState() + "' for book: " + book1.toString());
        setFeedback("This is my first comment.  Rating:4  Book: " + book1.toString());
        resetAdd();                
    }
    
    /**
     * adds the author
     */
    public void add() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            
            item.setData();
            item.saveResults();
            authorList.add(item);
            item = new Author();
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

    /**
     * resets the add
     */
    public void resetAdd() {
    	item = new Author();
        item.setForename(null);
        item.setSurname(null);
    }

    /**
     *
     * @param item
     */
    public void edit(Author item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    /**
     * cancels the edit
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Author();
        edit = false;
    }

    /**
     * saves the edit
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Author();
        edit = false;
    }

    /**
     * removes the selected author
     * @param item
     * @throws IOException
     */
    public void delete(Author item) throws IOException {
    	// DAO save the delete
        authorList.remove(item);
    }

    /**
     *
     * @return List of authors
     */
    public List<Author> getList() {
        return authorList;
    }

    /**
     *
     * @return item
     */
    public Author getItem() {
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
     * @param message
     * @return
     */
    public String setMessage(String message){
        return this.message = message;
    }   

    /**
     *
     * @return message
     */
    public String getMessage(){
        return message;
    }

    /**
     *
     * @param message
     * @return message
     */
    public String setFeedback(String message){
        return this.fb = message;
    }   

    /**
     *
     * @return feedback
     */
    public String getFeedback(){
        return fb;
    }
}