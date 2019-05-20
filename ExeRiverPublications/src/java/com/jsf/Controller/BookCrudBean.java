/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import com.jsf.Model.Book;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

/**
 *
 * @author clair
 */
@ManagedBean(name="bookCrudBean")
@SessionScoped
public class BookCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Book> bookList;
    private Book item = new Book();
    private Book beforeEditItem = null;
    private boolean edit;
    private List<Author> authors;
    //private UIPanel resultPanel;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        bookList = new ArrayList<Book>();
        //bookList = getList();
    }
    public BookCrudBean(){}
    
    public void add() {
    	// DAO save the add
        //item.setBookId(list.isEmpty() ? 1 : list.get(list.size() - 1).getBookId() + 1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            //item.setBookId(bookList.isEmpty() ? 1 : bookList.get(bookList.size() - 1).getBookId()+ 1);
            item.setData();
            item.saveResults();
            bookList.add(item);
//            item.setBookList(bookList);
//            item.saveListResults();
            item = new Book();
            //resultPanel.setRendered(true);
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            //resultPanel.setRendered(false);
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }


        //util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Book();

    	//util.redirectWithGet();
    }

    public void edit(Book item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;

        //util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Book();
        edit = false;

        //util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Book();
        edit = false;

        //util.redirectWithGet();
    }

    public void delete(Book item) throws IOException {
    	// DAO save the delete
        bookList.remove(item);

        //util.redirectWithGet();
    }

    public List<Book> getList() {
        return bookList;
    }

    public Book getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
//    
//    public List<Author> getAuthors() {
//        try{ 
//            FileInputStream fin = new FileInputStream("book.ser");
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            Author author = (Author) ois.readObject();
//            ois.close();
//
//            System.out.println(author);
//
//        }catch(Exception ex){
//                ex.printStackTrace(); 
//        } 
//        return authors;
//    }
//
//    public void setAuthors(List<Author> authors) {
//        this.authors = authors;
//    }
//    public String loadResults() {
//        FacesContext ctx = FacesContext.getCurrentInstance();
//        Author author = new Author();
//        try {
//            author.loadResults();
//            //resultPanel.setRendered(true);
//            ctx.addMessage(null, new
//               FacesMessage(FacesMessage.SEVERITY_INFO,
//            "loaded results", null));
//        } catch (Exception ex) {
//            //resultPanel.setRendered(false);
//            ctx.addMessage(null, new
//               FacesMessage(FacesMessage.SEVERITY_ERROR,
//            ex.getMessage(), null));
//        }
//        return null;
//   }    
//    public UIPanel getResultPanel() {
//      return resultPanel;
//    }
//    public void setResultPanel(UIPanel resultPanel) {
//      this.resultPanel = resultPanel;
//    }
  
}