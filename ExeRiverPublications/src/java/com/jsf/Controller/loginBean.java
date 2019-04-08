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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
/**
 *
 * @author clair
 */
@ManagedBean @SessionScoped
public class loginBean {
    private String userName;
    private String password;
 
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
        /*
        Administrator admin1 = new Administrator();
        //admin1.id *********** Set up ID's ******************
        admin1.forename = "Amanda";
        admin1.surname = "Collins";
        admin1.email = "acollins@exeriverpublishing.co.uk";
        admin1.address = "22 River Street, Exeter EX1 2DD";
        admin1.password = "riverstreet";
        
        Editor editor1 = new Editor();
        editor1.forename = "Edward";
        editor1.surname = "Richey";
        editor1.email = "erichey@exeriverpublishing.co.uk";
        editor1.address = "1a Long Drive, Exmouth EX10 3ER";
        editor1.password = "richness";
       
        Editor editor2 = new Editor();
        editor2.forename = "Phillipa";
        editor2.surname = "Frost";
        editor2.email = "pfrost@exeriverpublishing.co.uk";
        editor2.address = "13 Prospect Street, Exeter EX2 4RR";
        editor2.password = "prospects";
        
        Author author1 = new Author();
        author1.forename = "Coleen";
        author1.surname = "Cole";
        author1.email = "ccole@gmail.com";
        author1.address = "6 Castle Court, Exeter, EX1 1DS";
        author1.password = "castles";
 
        Author author2 = new Author();
        author2.forename = "Anna";
        author2.surname = "Alyn";
        author2.email = "anna_a@hotmail.co.uk";
        author2.address = "79 Grammercy Lane, Exeter EX7 7SA";
        author2.password = "lollipops";

        Author author3 = new Author();
        author3.forename = "Steve";
        author3.surname = "Robins";
        author3.email = "steverobins@live.co.uk";
        author3.address = "22 New Lane, Exeter EX4 9PQ";
        author3.password = "mountain1";     
        
        Reviewer reviewer1 = new Reviewer();
        reviewer1.forename = "Sarah";
        reviewer1.surname = "Barkins";
        reviewer1.email = "sbarkins@exeriverpublishing.co.uk";
        reviewer1.address = "47 Rockne Drive, Exeter EX3 7NV";
        reviewer1.password = "creative10";    
        
        Reviewer reviewer2 = new Reviewer();
        reviewer2.forename = "Pete";
        reviewer2.surname = "Chinn";
        reviewer2.email = "pchinn@exeriverpublishing.co.uk";
        reviewer2.address = "62 Woodside Court, Exeter, EX4 8DF";
        reviewer2.password = "woodward";    
        
        Reviewer reviewer3 = new Reviewer();
        reviewer3.forename = "Zelpah";
        reviewer3.surname = "Ashton";
        reviewer3.email = "zashton@exeriverpublishing.co.uk";
        reviewer3.address = "67 Greenbelt Way, Exeter EX3 5DF";
        reviewer3.password = "alpine50";    
        
        Reviewer reviewer4 = new Reviewer();
        reviewer4.forename = "Martin";
        reviewer4.surname = "Hicks";
        reviewer4.email = "mhicks@exeriverpublishing.co.uk";
        reviewer4.address = "32 South Bank Avenue, Exeter EX2 1DK";
        reviewer4.password = "bank12345"; 
                     
        
        //***** TO DO Add agent *********************
        
        Book book1 = new Book();*/
        
        
        return "Users created";
    }
    
}
