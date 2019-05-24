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
    
    public Payment(Integer paymentId, String paymentType, Integer amount, Boolean paymentComplete, Book book) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.paymentComplete = paymentComplete;
        this.book = book;
        
    }

    public Payment() {      
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getPaymentComplete() {
        return paymentComplete;
    }

    public void setPaymentComplete(Boolean paymentComplete) {
        this.paymentComplete = paymentComplete;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return paymentId + ", " + paymentType + ", " + paymentComplete + ", " + amount + ", " + book;
    }

    public void restore(Payment p) {
        this.paymentType = p.paymentType;
        this.amount = p.amount;
        this.paymentComplete = p.paymentComplete;
        this.book = p.book;
    }

    public void setData() {
        payment=this.paymentType + ", " + this.amount + ", " + this.paymentComplete + ", " + this.book;
        setResult(payment);
        thisSaveData.setdata(result);    }

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

    public String getResult() {
       return result;
    }

    public void setResult(String result1) {
       result = result1;
    }

}
