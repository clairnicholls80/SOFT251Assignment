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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author clair
 */
@ManagedBean(name="homeBean")
@ViewScoped
public class HomeBean implements Serializable{

    private List<Book> list;
    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
        Book.initialiseData();
        //list=Book.getBookList();
//        try{
//            ObjectInputStream os = new ObjectInputStream(new FileInputStream("book1.ser"));
//            Book book1 = (Book) os.readObject();;
//            os.close();
//            System.out.println(book1.getTitle());
//        }
//        catch(Exception ex) {
//            ex.printStackTrace();
//        }
      
        System.out.println(list.toString());
    }
   
    private List<Book> books;
         
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        
   
        
        
        //books = service.createCars(10);
    }
 
    public List<Book> getCars1() {
        return books;
    }
 
     
    public List<String> getBrands() {
        return service.getBrands();
    }
     
    public List<String> getColors() {
        return service.getColors();
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
     
    public void onRowEdit(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Car Edited", ((Book) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Edit Cancelled", ((Book) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
}
