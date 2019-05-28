
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
    
    /**
     * 
     */
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
     * @return userId
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
     * @return forename
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
     * @return surname
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
     * @return email
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
     * @return address
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
     * @return password
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
     * @return lastLoginDate
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
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @return List of books
     */
    
    public ArrayList getBookList() {
        return bookList;
    }

    /**
     *
     * @param bookList
     */
    public void setBookList(ArrayList bookList) {
        this.bookList.add(this);
    }

    /**
     *
     * @return user details as string
     */
    public String getUserDetails(){
        return MessageFormat.format("{0} {1}, {2} ({3})", forename, surname, address, email);
    }

    /**
     *
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Used for the login to check username and password
     * @param username
     * @param pass
     * @return
     */
    public boolean authenticate(String username, String pass) {
        return this.email.equals(username) && this.password.equals(pass); 
    }
    
    /**
     *
     * @param user
     */

    public void restore(User user) {
            this.userId = user.getUserId();
            this.name = user.getName();
    }
    
}