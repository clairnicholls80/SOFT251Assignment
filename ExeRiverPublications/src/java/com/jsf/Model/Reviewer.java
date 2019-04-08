/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;
/**
 *
 * @author clair
 */
public class Reviewer extends User {
         
    /**
     *
     */
    public Reviewer() {
    }
    
    /**
     *
     * @param forename
     * @param surname
     * @param email
     * @param address
     * @param password
     */
    public Reviewer(String forename, String surname, String email, String address, String password) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.password = password;
    }
    
    /**
     *
     */
    @Override
    public void update() {
        String msg = (String) book.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);    
    }
    
    /**
     *
     * @param copy
     */
    @Override
    public void setSubject(Book copy) {
       this.book=copy;    
    }
}
