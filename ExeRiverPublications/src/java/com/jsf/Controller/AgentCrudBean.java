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
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
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
    public AgentCrudBean(){}
    
    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
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
            agentList.add(item);
            item = new Agent();
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
        agentList.remove(item);

        //util.redirectWithGet();
    }

    public List<Agent> getList() {
        return agentList;
    }

    public Agent getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
        public String setMessage(String message){
        return this.message = message;
    }   
    public String getMessage(){
        return message;
    }
    public String setFeedback(String message){
        return this.fb = message;
    }   
    public String getFeedback(){
        return fb;
    }
}