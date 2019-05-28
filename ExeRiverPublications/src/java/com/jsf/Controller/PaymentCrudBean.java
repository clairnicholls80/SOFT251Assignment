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

    /**
     *
     * @param util
     */
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    /**
     * initialise the data due to serialisation issues
     */
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
        resetAdd();
                
    }

    /**
     * empty constructor
     */
    public PaymentCrudBean(){}
    
    /**
     *
     * @return list of payments
     */
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    /**
     *
     * @param paymentList
     */
    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
    
    /**
     * adds the payment
     */
    public void add() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setData();
            item.saveResults();
            paymentList.add(item);
            item = new Payment();
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }
    }

    /**
     * resets the add
     */
    public void resetAdd() {
    	item = new Payment();

    	//util.redirectWithGet();
    }

    /**
     *
     * @param item
     */
    public void edit(Payment item) {
        this.item = item;
        edit = true;

    }

    /**
     * cancels the edit
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Payment();
        edit = false;

    }

    /**
     * saves the edit
     */
    public void saveEdit() {
    	// DAO save the edit
        this.item = new Payment();
        edit = false;

    }

    /**
     * removes the selected payment
     * @param item
     * @throws IOException
     */
    public void delete(Payment item) throws IOException {
    	// DAO save the delete
        paymentList.remove(item);

    }

    /**
     *
     * @return list of payments
     */
    public List<Payment> getList() {
        return paymentList;
    }

    /**
     *
     * @return item
     */
    public Payment getItem() {
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