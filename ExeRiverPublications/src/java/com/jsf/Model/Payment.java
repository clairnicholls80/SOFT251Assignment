/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.Serializable;

/**
 *
 * @author clair
 */
public class Payment implements Serializable{
    private Long paymentId;
    private String paymentType;
    private Integer amount;
    private Boolean paymentComplete;
    private Book book;


    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
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

}
