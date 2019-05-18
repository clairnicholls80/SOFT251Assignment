
package com.jsf.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author clair
 */
public abstract class User implements Serializable{
    
    protected ArrayList observers;
    /**
     *
     */
    protected int userId;

    /**
     *
     */
    protected String forename;

    /**
     *
     */
    protected String surname;

    /**
     *
     */
    protected String email;

    /**
     *
     */
    protected String address;

    /**
     *
     */
    protected String password;

    /**
     *
     */
    protected Date lastLoginDate;

    /**
     *
     */
    protected Book book;

    /**
     *
     */
    protected String name;

    
    ArrayList bookList;


    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param fname
     * @param sname
     */
    public void setName(String fname, String sname) {
        this.name = fname + " " + sname;
    }

    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getForename() {
        return forename;
    }

    /**
     *
     * @param forename
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     *
     * @param lastLoginDate
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
        
    /**
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    /*public void setBook(Book book) {
        this.book = book;
        this.book.register(this);
    }*/
    
    public ArrayList getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList bookList) {
        this.bookList.add(this);
    }

    /**
     *
     * @return
     */
    public String getUserDetails(){
        return MessageFormat.format("{0} {1}, {2} ({3})", forename, surname, address, email);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
    
    public boolean authenticate(String username, String pass) {
        return this.email.equals(username) && this.password.equals(pass); 
    }
    
//    public User clone() {
//            return new User(userId, name);
//    }

    public void restore(User user) {
            this.userId = user.getUserId();
            this.name = user.getName();
    }
    
    
   
}