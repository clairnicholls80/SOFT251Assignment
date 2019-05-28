/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;
import com.jsf.Model.Author;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
/**
 *
 * @author clair
 */
public class WriteObject{
 
    /**
     *
     * @param args
     */
    public static void main (String args[]) {
	 
	    Author author = new Author();
            author = new Author(1,"Coleen", "Cole", "ccole@gmail.com", "6 Castle Court, Exeter, EX1 1DS", "castles");
 
	    try{ 
		FileOutputStream fout = new FileOutputStream("author.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(author);
		oos.close();
		System.out.println("Done");
 
	    }catch(Exception ex){
		   ex.printStackTrace();
	    } 
	}
}