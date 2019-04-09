/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;
 
import com.jsf.Model.Administrator;
import com.jsf.Model.Author;
import com.jsf.Model.Editor;
import com.jsf.Model.Reviewer;
import com.jsf.Model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
/**
 *
 * @author clair
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    private String userName;
    private String password;
    private ArrayList bookList;
    @PostConstruct
    public void init() {
        Book.initialiseData();
        System.out.println("data created");
    }
    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }
 
    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    public String validateUserLogin() {
        //System.out.println(setUpUsers());
        String navResult = "";
        System.out.println("Entered Username is= " + userName + ", password is= " + password);
        //book1.observers.forEach((o)->System.out.println(o));
        
        if (userName.equalsIgnoreCase("clair") && password.equals("z")) {
            navResult = "success";
        } else {
            navResult = "failure";
        }
        return navResult;
    }

    /**
     *
     * @return
     */
    public String setUpUsers(){
        
        return "Users created";
    }
    
    public ArrayList bookList(){
        return bookList;
    }
    public List<LoginBean> books() {
	return Book.getAllBooks();		
    }
}
