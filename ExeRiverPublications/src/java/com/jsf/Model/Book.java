package com.jsf.Model;
import com.jsf.Controller.LoginBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * @author clair
 */
public class Book implements BookInterface, Serializable{
    
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();    
    private int bookId;
    private String title;
    private Author author;
    private Agent agent;
    private Reviewer firstReviewer;
    private Reviewer secondReviewer;
    private Editor editor;
    private String fileName;
    private String location;
    private State state = State.Registered;
    private Payment payment;
    private Feedback feedback;
    private Meeting meeting;
    private ArrayList observers;
    private List<Book> bookList;
    private String result;
    private List<Book> listResult;
    private SaveData thisSaveData = new SaveData();
    private String book;
    private List<Book> data;    
    private ArrayList<Book> books;
    
    /**
     *
     * @return bookList
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
        //setListResult(this.bookList);
        //setdata(listResult);
    }

    /**
     *
     * @param thisdata
     */
    public void setdata( List<Book> thisdata)
    {
        data = thisdata;
    } 
    
    /**
     *
     * @return List of Books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     *
     * @param books
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    /**
     * Sets the observers
     */
    public Book(){
        this.observers=new ArrayList<UserInterface>();
    }    

    /**
     * Constructor for book
     * @param bookId
     * @param title
     */
    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;        
    }

    /**
     * Constructor for book
     * @param bookId
     * @param title
     * @param fileName
     * @param location
     */
    public Book(int bookId, String title, String fileName, String location) {
        this.bookId = bookId;
        this.title = title;
        this.fileName = fileName;
        this.location = location;
        //bookList.add(this.title);
        //bookList = Arrays.asList(this.title);
    }  

 
    /**
     *
     * @return
     */
    public int getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     *
     * @return
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     *
     * @param agent
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     *
     * @return firstReviewer
     */
    public Reviewer getFirstReviewer() {
        return firstReviewer;
    }

    /**
     *
     * @param firstReviewer
     */
    public void setFirstReviewer(Reviewer firstReviewer) {
        this.firstReviewer = firstReviewer;
    }

    /**
     *
     * @return secondReviewer
     */
    public Reviewer getSecondReviewer() {
        return secondReviewer;
    }

    /**
     *
     * @param secondReviewer
     */
    public void setSecondReviewer(Reviewer secondReviewer) {
        this.secondReviewer = secondReviewer;
    }

    /**
     *
     * @return List of observers
     */
    public ArrayList getObservers() {
        return observers;
    }

    /**
     *
     * @param observers
     */
    public void setObservers(ArrayList observers) {
        this.observers = observers;
    }

    /**
     *
     * @return filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     *
     * @return payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     *
     * @param payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     *
     * @return feedback
     */
    public Feedback getFeedback() {
        return feedback;
    }

    /**
     *
     * @param feedback
     */
    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    /**
     *
     * @return meeting
     */
    public Meeting getMeeting() {
        return meeting;
    }

    /**
     *
     * @param meeting
     */
    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }   

    /**
     *
     * @param obj
     * @return message
     */
    public Object getUpdate(UserInterface obj) {        
        return this.message;    
    } 
        
    /**
     * set the list of observers
     */
    public void setObservers(){
        this.observers = new ArrayList();
    }
    
    /**
     *
     * @param observer
     */
    public void register(UserInterface observer) {
        //if(observer == null) throw new NullPointerException("No Observer identified");
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
        notifyObservers();
    } 

    /**
     *
     * @param observer
     */
    public void unregister(UserInterface observer) {
        observers.remove(observer);
    } 
    
    /**
     * Overridden method for the notifyObservers method from the BookInterface
     */
    @Override
    public void notifyObservers() {
        List<UserInterface> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (UserInterface observer : observersLocal) {
            observer.update(this.state);
        } 
    } 

    //method to post message to the topic

    /**
     * Method to post message to the topic
     * @param msg
     */
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
        /**
     *
     * @return title
     */
    @Override
    public String toString() {
        return title;
    }
        
    /**
     *
     * @param book
     */
    public void restore(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
    }
    
    /**
     * set the data ready for saving
     */
    public void setData(){
        //setResult(this.toString());
        
        book=this.title + ", " + this.fileName + ", " + this.state;
        setResult(book);
        thisSaveData.setdata(result);
    }
    
    /**
     *
     * @return result
     */
    public String getResult() {
       return result;
    }

    /**
     *
     * @param result1
     */
    public void setResult(String result1) {
       result = result1;
    }
    
    /**
     * method to save the results
     */
    public void saveResults() 
    {
        String filename = "book.ser";
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
    
    
    //declare variables for data initialisation
    private static Book book1, book2, book3, book4, book5, book6, book7, book8, book9, book10;
    private static Administrator admin1;
    private static Editor editor1, editor2;
    private static Author author1, author2, author3;    
    private static ArrayList<Author> authorList;
    private static Reviewer reviewer1, reviewer2, reviewer3, reviewer4;
    private static Agent agent1;

    /**
     * method to initialise the data due to serialisation issues
     */
    public static void initialiseData()
    {
        //create objects of books
        book1 = new Book(1, "The witch and the wand");
        book2 = new Book(2, "Darcy's Doughnuts");
        book3 = new Book(3, "We're going on a turtle adventure");
        book4 = new Book(4, "Diary of a cool kid");
        book5 = new Book(5, "Wonky Donky");
        book6 = new Book(6, "Cornish Coves");
        book7 = new Book(7, "Dark tides");
        book8 = new Book(8, "Lines of order");
        book9 = new Book(9, "The story of my life");
        book10 = new Book(10, "Village life");
        
        /* Create users */
        //create Administrator
        admin1 = new Administrator(1, "Clair", "Nicholls", "clair@gmail.com", "8 Copper Meadows, Redruth, TR152NX", "letmein");
        admin1.setName(admin1.forename, admin1.surname);
        //create Editors
        editor1 = new Editor(1,"Edward", "Richey", "erichey@exeriverpublishing.co.uk", "1a Long Drive, Exmouth EX10 3ER", "richness");
        editor1.setName(editor1.forename, editor1.surname);        
        editor2 = new Editor(2,"Phillipa", "Frost", "pfrost@exeriverpublishing.co.uk", "13 Prospect Street, Exeter EX2 4RR", "prospects");
        editor2.setName(editor1.forename, editor1.surname);
        //Create authors
        
        authorList =  new ArrayList<Author>();
        author1 = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
        //author1.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        author1.setName(author1.forename, author1.surname);
        author1.setData();
        author1.saveResults();
        authorList.add(author1);
        //author1.setAuthors(authorList);

        //authorList.add(author1);
        //author1 = new Author();
        author2 = new Author(2,"Anna", "Alyn", "anna_a@hotmail.co.uk", "79 Grammercy Lane, Exeter EX7 7SA", "lollipops");
        //author2.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        author2.setName(author2.forename, author2.surname);
        author2.setData();
        author2.saveResults();
        authorList.add(author2);
        //author2.setAuthors(authorList);
        
        author3 = new Author(3,"Steve", "Robins", "steverobins@live.co.uk", "22 New Lane, Exeter EX4 9PQ", "mountain1");
        //author3.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
        author3.setName(author3.forename, author3.surname);        
        author3.setData();
        author3.saveResults();
        authorList.add(author3);
        author3.setAuthors(authorList);//save to the model list
        //create reviewers
        reviewer1 = new Reviewer(1,"Sarah", "Barkins", "sbarkins@exeriverpublishing.co.uk", "47 Rockne Drive, Exeter EX3 7NV", "creative10");
        reviewer1.setName(reviewer1.forename, reviewer1.surname);
        reviewer2 = new Reviewer(2,"Pete", "Chinn", "pchinn@exeriverpublishing.co.uk", "62 Woodside Court, Exeter, EX4 8DF", "woodward");
        reviewer2.setName(reviewer1.forename, reviewer1.surname);
        reviewer3 = new Reviewer(3,"Zelpah", "Ashton", "zashton@exeriverpublishing.co.uk", "67 Greenbelt Way, Exeter EX3 5 DF", "alpine50");
        reviewer3.setName(reviewer1.forename, reviewer1.surname);
        reviewer4 = new Reviewer(4,"Martin", "Hicks", "mhicks@exeriverpublishing.co.uk", "32 South Bank Avenue, Exeter EX2 1DK", "bank12345");
        reviewer4.setName(reviewer1.forename, reviewer1.surname);         
        //create agent
        agent1 = new Agent(1,"Philip", "Davey", "pdavey@publishinghouse.co.uk", "33 Station Road, Exeter EX1 1AB", "davesrbest");
        agent1.setName(agent1.forename, agent1.surname);
        
        //register users to books (register observers)
        book1.observers = new ArrayList();
        book1.register(admin1);
        book1.register(author1);
        book1.register(agent1);
        book1.register(reviewer1);
        book1.register(reviewer2);
        book1.notifyObservers();
        
        book2.observers = new ArrayList();
        book2.register(admin1);
        book2.register(author2);
        book2.register(agent1);
        book2.register(reviewer3);
        book2.register(reviewer4);
        book2.notifyObservers();
        
        book3.observers = new ArrayList();
        book3.register(admin1);
        book3.register(author2);
        book3.register(agent1);
        book3.register(reviewer1);
        book3.register(reviewer4);
        book3.notifyObservers();
        
        book4.observers = new ArrayList();
        book4.register(admin1);
        book4.register(author3);
        book4.register(agent1);
        book4.register(reviewer3);
        book4.register(reviewer2);
        book4.notifyObservers();
        
        book5.observers = new ArrayList();
        book5.register(admin1);
        book5.register(author3);
        book5.register(agent1);
        book5.register(reviewer2);
        book5.register(reviewer4);
        book5.notifyObservers();
        
        book6.observers = new ArrayList();
        book6.register(admin1);
        book6.register(author3);
        book6.register(agent1);
        book6.register(reviewer1);
        book6.register(reviewer3);
        book6.notifyObservers();
        
        book7.observers = new ArrayList();
        book7.register(admin1);
        book7.register(author2);
        book7.register(agent1);
        book7.register(reviewer2);
        book7.register(reviewer4);
        book7.notifyObservers();
        
        book8.observers = new ArrayList();
        book8.register(admin1);
        book8.register(author3);
        book8.register(agent1);
        book8.register(reviewer1);
        book8.register(reviewer2);
        book8.notifyObservers();
        
        book9.observers = new ArrayList();
        book9.register(admin1);
        book9.register(author2);
        book9.register(agent1);
        book9.register(reviewer3);
        book9.register(reviewer4);
        book9.notifyObservers();
        
        book10.observers = new ArrayList();
        book10.register(admin1);
        book10.register(author2);
        book10.register(agent1);
        book10.register(reviewer1);
        book10.register(reviewer4);
        book10.notifyObservers();
        
        System.out.println("Data initialised");        
    }
}
