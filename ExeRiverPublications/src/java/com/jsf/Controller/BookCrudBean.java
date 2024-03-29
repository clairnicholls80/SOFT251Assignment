/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import com.jsf.Model.Agent;
import com.jsf.Model.Author;
import com.jsf.Model.Book;
import com.jsf.Model.Editor;
import com.jsf.Model.Reviewer;
import com.jsf.Model.State;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import javax.servlet.http.Part;
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
    private List<Author> authorList;
    private List<Reviewer> reviewerList;
    private Administrator admin1;
    private Editor editor1, editor2;
    private Author author1, author2, author3;    
    private Reviewer reviewer1, reviewer2, reviewer3, reviewer4;
    private Agent agent1;
    private Part uploadedFile;
    private String folder = "c:\\temp2";


    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;

    /**
     *
     * @param util
     */
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    /**
     * initialises the data due to serialisation issues
     */
    @PostConstruct
    public void init() {
        
        admin1 = new Administrator(1, "Clair", "Nicholls", "clair@gmail.com", "8 Copper Meadows, Redruth, TR152NX", "letmein");
        admin1.setName(admin1.getForename(), admin1.getSurname());
        
        //create Editors
        editor1 = new Editor(1,"Edward", "Richey", "erichey@exeriverpublishing.co.uk", "1a Long Drive, Exmouth EX10 3ER", "richness");
        editor1.setName(editor1.getForename(), editor1.getSurname());        
        editor2 = new Editor(2,"Phillipa", "Frost", "pfrost@exeriverpublishing.co.uk", "13 Prospect Street, Exeter EX2 4RR", "prospects");
        editor2.setName(editor1.getForename(), editor1.getSurname());
        
        //Create authors        
        authorList =  new ArrayList<Author>();
        author1 = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        author1.setName(author1.getForename(), author1.getSurname());
        authorList.add(author1);

        author2 = new Author(2,"Anna", "Alyn", "anna_a@hotmail.co.uk", "79 Grammercy Lane, Exeter EX7 7SA", "lollipops");
        author2.setName(author2.getForename(), author2.getSurname());
        authorList.add(author2);
        
        author3 = new Author(3,"Steve", "Robins", "steverobins@live.co.uk", "22 New Lane, Exeter EX4 9PQ", "mountain1");
        author3.setName(author3.getForename(), author3.getSurname());        
        authorList.add(author3);
        
        //create reviewers
        reviewer1 = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.getForename(), reviewer1.getSurname());
        reviewer2 = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer2.getForename(), reviewer2.getSurname());
        reviewer3 = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer3.getForename(), reviewer3.getSurname());
        reviewer4 = new Reviewer(4,"Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        reviewer4.setName(reviewer4.getForename(), reviewer4.getSurname());         
        
        //create agent
        agent1 = new Agent(1,"Philip", "Davey", "pdavey@publishinghouse.co.uk", "33 Station Road, Exeter EX1 1AB", "davesrbest");
        agent1.setName(agent1.getForename(), agent1.getSurname());
        
        //create books        
        bookList = new ArrayList<Book>();
        item = new Book(1, "The witch and the wand");
        item.setFileName(folder + "\\manuscript1.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);  
        item.setObservers();
        item.register(author1);
        item.setAuthor(author1);      
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer1);
        item.setSecondReviewer(reviewer2);        
        item.notifyObservers();
        item = new Book(2, "Darcy's Doughnuts");
        item.setFileName(folder + "\\manuscript2.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);  
        item.setAuthor(author2);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer3);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();
        item = new Book(3, "We're going on a turtle adventure");
        item.setFileName(folder + "\\manuscript3.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);   
        item.setAuthor(author2);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer1);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();
        item = new Book(4, "Diary of a cool kid");
        item.setFileName(folder + "\\manuscript4.docx");
        item.setData();
        item.saveResults();
        bookList.add(item); 
        item.setAuthor(author3);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer3);
        item.setSecondReviewer(reviewer2);
        item.notifyObservers();        
        item = new Book(5, "Wonky Donky");
        item.setFileName(folder + "\\manuscript5.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);  
        item.setAuthor(author3);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer2);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();        
        item = new Book(6, "Cornish Coves");
        item.setFileName(folder + "\\manuscript62.docx");
        item.setData();
        item.saveResults();
        bookList.add(item); 
        item.setAuthor(author3);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer1);
        item.setSecondReviewer(reviewer3);
        item.notifyObservers();        
        item = new Book(7, "Dark tides");
        item.setFileName(folder + "\\manuscript7.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);
        item.setAuthor(author2);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer2);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();        
        item = new Book(8, "Lines of order");
        item.setFileName(folder + "\\manuscript8.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);  
        item.setAuthor(author3);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer1);
        item.setSecondReviewer(reviewer2);
        item.notifyObservers();        
        item = new Book(9, "The story of my life");
        item.setFileName(folder + "\\manuscript9.docx");
        item.setData();
        item.saveResults();
        bookList.add(item); 
        item.setAuthor(author2);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer3);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();
        item = new Book(10, "Village life");
        item.setFileName(folder + "\\manuscript10.docx");
        item.setData();
        item.saveResults();
        bookList.add(item);  
        item.setAuthor(author2);
        item.setAgent(agent1);
        item.setFirstReviewer(reviewer1);
        item.setSecondReviewer(reviewer4);
        item.notifyObservers();        
        item.setBooks((ArrayList<Book>) bookList);//save to the model list
        resetAdd();        
    }

    /**
     * empty constructor
     */
    public BookCrudBean(){}
    
    /**
     *
     * @return List of books
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     *
     * @param bookList
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
    /**
     * adds the book to the system and uploads the manuscript
     */
    public void add() {
    	// DAO save the add
        //item.setBookId(list.isEmpty() ? 1 : list.get(list.size() - 1).getBookId() + 1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            //item.setBookId(bookList.isEmpty() ? 1 : bookList.get(bookList.size() - 1).getBookId()+ 1);
            InputStream input = uploadedFile.getInputStream();
            String file = uploadedFile.getSubmittedFileName();
            Files.copy(input, new File(folder, file).toPath());            
            this.item.setFileName(folder + "\\" + file);
            item.setData();
            item.saveResults();
            bookList.add(item);
            item.setBooks((ArrayList<Book>) bookList);//save to the model list
            resetAdd();
            item = new Book();
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Saved", null));
        } catch (Exception ex) {
            ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
        }
    }

    /**
     * resets the add for new book
     */
    public void resetAdd() {
    	item = new Book();
    	//util.redirectWithGet();
    }

    /**
     *
     * @param item
     */
    public void edit(Book item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
        //util.redirectWithGet();
    }

    /**
     * cancels the edit to restore to the previous version
     */
    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Book();
        edit = false;
        //util.redirectWithGet();
    }

    /**
     * saves the edit and upload manuscript
     */
    public void saveEdit() {
    	// DAO save the edit
        try {
            InputStream input = uploadedFile.getInputStream();
            String file = uploadedFile.getSubmittedFileName();
            Files.copy(input, new File(folder, file).toPath());
            this.item.setFileName(folder + "\\" + file);
            this.item = new Book();
            edit = false;           
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * removes the selected book
     * @param item
     * @throws IOException
     */
    public void delete(Book item) throws IOException {
    	// DAO save the delete
        bookList.remove(item);
    }

    /**
     *
     * @return list of Books
     */
    public List<Book> getList() {
        return bookList;
    }

    /**
     *
     * @return item
     */
    public Book getItem() {
        return this.item;
    }

    /**
     *
     * @return edit
     */
    public boolean isEdit() {
        return this.edit;
    }
  
    /**
     *
     * @return List of Reviewers
     */
    public List<Reviewer> getReviewerList() {
        return reviewerList;
    }

    /**
     *
     * @param reviewerList
     */
    public void setReviewerList(List<Reviewer> reviewerList) {
        this.reviewerList = reviewerList;
    }
    
    /**
     *
     */
    public State[] stateList;
	
    /**
     *
     * @return list of states (enum)
     */
    public State[] getStateList() {
        stateList = State.values();
        return stateList;        	
    }
    
    /**
     *
     * @return list of states
     */
    public State[] setStateList() {
        return this.stateList = State.values();
    }
         
    /**
     *
     * @return uploaded file
     */
    public Part getUploadedFile() {
        return uploadedFile;
    }

    /**
     *
     * @param uploadedFile
     */
    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}