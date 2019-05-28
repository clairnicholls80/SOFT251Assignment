/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author clair
 */
public class Payment implements Serializable{
    private Integer paymentId;
    private String paymentType;
    private Integer amount;
    private Boolean paymentComplete;
    private Book book;
    private String result;
    private ArrayList<Payment> payments;
    private SaveData thisSaveData = new SaveData();
    private String payment;
    
    /**
     * Parameterised constructor for Payment
     * @param paymentId
     * @param paymentType
     * @param amount
     * @param paymentComplete
     * @param book
     */
    public Payment(Integer paymentId, String paymentType, Integer amount, Boolean paymentComplete, Book book) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.paymentComplete = paymentComplete;
        this.book = book;
        
    }

    /**
     * Empty constructor for Payment
     */
    public Payment() {      
    }

    /**
     *
     * @return paymentId
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     *
     * @param paymentId
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     *
     * @return paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     *
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     *
     * @return paymentCompletee
     */
    public Boolean getPaymentComplete() {
        return paymentComplete;
    }

    /**
     *
     * @param paymentComplete
     */
    public void setPaymentComplete(Boolean paymentComplete) {
        this.paymentComplete = paymentComplete;
    }
    
    /**
     *
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * @return payment details as a string
     */
    @Override
    public String toString() {
        return paymentId + ", " + paymentType + ", " + paymentComplete + ", " + amount + ", " + book;
    }

    /**
     *
     * @param p
     */
    public void restore(Payment p) {
        this.paymentType = p.paymentType;
        this.amount = p.amount;
        this.paymentComplete = p.paymentComplete;
        this.book = p.book;
    }

    /**
     * sets the data ready for saving
     */
    public void setData() {
        payment=this.paymentType + ", " + this.amount + ", " + this.paymentComplete + ", " + this.book;
        setResult(payment);
        thisSaveData.setdata(result);    }

    /**
     * save results to a serialised file for payments
     */
    public void saveResults() {
        String filename = "payment.ser";
        System.out.println("This is what we are trying to save: "+ thisSaveData.getdata());
     
        try
        {
            FileOutputStream fout = new FileOutputStream(filename,true);
            ObjectOutputStream oos = new ObjectOutputStream(fout);  
            oos.writeObject(thisSaveData);
            oos.close();
            System.out.println("Done");
        }
        catch(Exception ex)
        {
             ex.printStackTrace();
        } 

        thisSaveData.cleardata();    
    }

    /**
     *
     * @return result
     */
    public String getResult() {
       return result;
    }

    /**
     *
     * @param result1
     */
    public void setResult(String result1) {
       result = result1;
    }

}
