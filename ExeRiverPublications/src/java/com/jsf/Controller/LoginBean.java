package com.jsf.Controller;
 
import com.jsf.Model.Administrator;
import com.jsf.Model.Author;
import com.jsf.Model.Editor;
import com.jsf.Model.Reviewer;
import com.jsf.Model.Book;
import com.jsf.Model.User;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
 
/**
 *
 * @author clair
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String userName;
    private String password;
    private ArrayList bookList;
    public Book book1;
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
        System.out.println(setUpUsers());
        String navResult = "";
        System.out.println("Entered Username is= " + userName + ", password is= " + password);
        //book1.observers.forEach((o)->System.out.println(o));
        
        if (userName.equalsIgnoreCase("clair") && password.equals("z")) {
            navResult = "success";
        } else {
            navResult = "failure";
        }
        //Book.initialiseData();
        //System.out.println("data created");
        return navResult;
    }

    /**
     *
     * @return
     */
    public String setUpUsers(){
        
        return "Users created";
    }
    
    
    
    public String getBook(){
        /*try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("book1.ser"));
            book1 = (Book) os.readObject();;
            os.close();
            System.out.println(book1.getTitle());
            return book1.getTitle();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        } */
        return null;
    }
    
    public void load(){
        /*try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("book1.ser"));
            Book book1 = (Book) os.readObject();;
            os.close();
            System.out.println(book1.getTitle());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        } */
    }
    
}
