/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Agent;
import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Payment;
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
@ManagedBean(name="paymentCrudBean")
@SessionScoped
public class PaymentCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    //private List<Agent> list;
    private Payment item = new Payment();
    private Payment beforeEditItem = null;
    private boolean edit;
    private Payment payment1;
    private List<Payment> paymentList;    
    private Book book1, book2, book3, book4;

  
    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
                //create books
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        book3 = new Book(3, "We're going on a turtle adventure");
        book4 = new Book(4, "Diary of a cool kid");
        paymentList = new ArrayList<Payment>();
        item = new Payment(1,"Advance", 300,true,book1);        
        item.setData();
        item.saveResults();
        paymentList.add(item);   
        
        item = new Payment(2,"Advance", 200,true,book2);        
        item.setData();
        item.saveResults();
        paymentList.add(item);   
                
        item = new Payment(3,"Final", 1200,true,book1);        
        item.setData();
        item.saveResults();
        paymentList.add(item); 
                
        item = new Payment(4,"Advance", 1800,false,book3);        
        item.setData();
        item.saveResults();
        paymentList.add(item);
        
        item = new Payment(5,"Final", 1500,false,book4);        
        item.setData();
        item.saveResults();
        paymentList.add(item);
        //item.setPayments((ArrayList<Payment>) paymentList);//save to the model list
        resetAdd();
        
        
    }
    public PaymentCrudBean(){}
    
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
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
            paymentList.add(item);
            item = new Payment();
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
    	item = new Payment();

    	//util.redirectWithGet();
    }

    public void edit(Payment item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Payment();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Payment();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Payment item) throws IOException {
    	// DAO save the delete
        paymentList.remove(item);

        //util.redirectWithGet();
    }

    public List<Payment> getList() {
        return paymentList;
    }

    public Payment getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}