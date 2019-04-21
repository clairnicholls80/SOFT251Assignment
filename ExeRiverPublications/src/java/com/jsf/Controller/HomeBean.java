/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Book;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author clair
 */
@Named(value = "homeBean")
@Dependent
public class HomeBean implements Serializable{

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
        
        
    }
    public void init() {
        try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("book1.ser"));
            Book book1 = (Book) os.readObject();;
            os.close();
            System.out.println(book1.getTitle());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        } 
    }
}
