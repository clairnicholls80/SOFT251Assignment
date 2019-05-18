/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
 
public class ReadObject{
 
   public static void main (String args[]) {
 
	   Author author;
	   
	   try{
 
		   FileInputStream fin = new FileInputStream("author.ser");
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   author = (Author) ois.readObject();
		   ois.close();
 
		   System.out.println(author);
		   
	   }catch(Exception ex){
		   ex.printStackTrace(); 
	   } 
   }
}

