/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Agent;
import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Feedback;
import com.jsf.Model.State;
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
@ManagedBean(name="agentCrudBean")
@SessionScoped
public class AgentCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //private List<Agent> list;
    private Agent item = new Agent();
    private Agent beforeEditItem = null;
    private boolean edit;
    private Agent agent1;
    private Book book1;
    private List<Agent> agentList;
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
     * Initialises the data for the form due to serialisation issues
     */
    @PostConstruct
    public void init() {
        agentList = new ArrayList<Agent>();
        item = new Agent(1,"Philip", "Davey", "pdavey@publishinghouse.co.uk", "33 Station Road, Exeter EX1 1AB", "davesrbest");
        item.setName(item.getForename(), item.getSurname());

        item.setData();
        item.saveResults();
        agentList.add(item);        
        item.setAgents((ArrayList<Agent>) agentList);//save to the model list
                        
        book1 = new Book(2, "Darcy's Doughnuts");
        book1.setObservers();// = new ArrayList();
        book1.register(item);          
        item.setSubject(book1);
        book1.setState(State.Rejected);
        book1.notifyObservers();
        item.update(State.Accepted);
                
        feedback = new Feedback();
        feedback = new Feedback(1, "This is my rejected comment", 2, book1);
        feedback.setData();
        feedback.saveResults();
        setMessage("Book state updated to '" + book1.getState() + "' for book: " + book1.toString());
        setFeedback("This is my rejected comment.  Rating:2  Book: " + book1.toString());
        resetAdd();      
    }

    /**
     * Empty constructor
     */
    public AgentCrudBean(){}
    
    /**
     *
     * @return List of agents
     */
    public List<Agent> getAgentList() {
        return agentList;
    }

    /**
     *
     * @param agentList
     */
    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }
    
    /**
     * adds a new agent
     */
    public void add() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setData();
            item.saveResults();
            agentList.add(item);
            item = new Agent();
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
     * restores the old values
     */
    public void resetAdd() {
    	item = new Agent();
    }

    /**
     *
     * @param item
     */
    public void edit(Agent item) {
        this.item = item;
        edit = true;

    }

    /**
     * cancel the edit and restore values
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Agent();
        edit = false;
    }

    /**
     * save the edit
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Agent();
        edit = false;
    }

    /**
     * Deletes the selected agent
     * @param item
     * @throws IOException
     */
    public void delete(Agent item) throws IOException {
    	// DAO save the delete
        agentList.remove(item);
    }

    /**
     *
     * @return List of agents
     */
    public List<Agent> getList() {
        return agentList;
    }

    /**
     *
     * @return item
     */
    public Agent getItem() {
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
     * Sets the message
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
     * @return feedback message
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