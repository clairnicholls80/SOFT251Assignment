/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Controller;

import com.jsf.Model.Author;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
@ManagedBean(name="authorCrudBean")
@SessionScoped
public class AuthorCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Author> authorList;
    private Author item = new Author();
    private Author beforeEditItem = null;
    private boolean edit;
    private UIPanel resultPanel;

    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
            this.util = util;
    }
        
    @PostConstruct
    public void init() {
        getList();
        //authorList=authorList;
        //authorList = new ArrayList<Author>();
    }
    //public AuthorCrudBean(){}
    
    
//    public String saveResults() {
//        FacesContext ctx = FacesContext.getCurrentInstance();
//        try {
//            item.saveResults();
//            //resultPanel.setRendered(true);
//            ctx.addMessage(null, new
//               FacesMessage(FacesMessage.SEVERITY_INFO,
//            "Results Saved", null));
//        } catch (Exception ex) {
//            //resultPanel.setRendered(false);
//            ctx.addMessage(null, new
//               FacesMessage(FacesMessage.SEVERITY_ERROR,
//            ex.getMessage(), null));
//        }
//        return null;
//   }
    
    public void add() {
    	// DAO save the add
        //item.setUserId(list.isEmpty() ? 1 : list.get(list.size() - 1).getUserId() + 1);
        //list.add(item);
        //item = new Author();
        //FacesContext ctx = FacesContext.getCurrentInstance();
        
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            item.setUserId(authorList.isEmpty() ? 1 : authorList.get(authorList.size() - 1).getUserId() + 1);
            
            item.setData();
            item.saveResults();
            authorList.add(item);
            item = new Author();
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
        //return null;
//        try {
//            item.setData();
//            item.saveResults();
//            //resultPanel.setRendered(true);
//            ctx.addMessage(null, new
//                  FacesMessage(FacesMessage.SEVERITY_INFO,
//            "Results Saved", null));
//        } catch (Exception ex) {
//            //resultPanel.setRendered(false);
//            ctx.addMessage(null, new
//               FacesMessage(FacesMessage.SEVERITY_ERROR,
//            ex.getMessage(), null));
//        }
        //return null;
        //item.saveResults();
        //util.redirectWithGet();
        
        
//        try{ 
//            FileOutputStream fout = new FileOutputStream("author.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fout);   
//            oos.writeObject(this);
//            oos.close();
//            System.out.println("Done");
//
//        }catch(Exception ex){
//               ex.printStackTrace();
//        } 
    }

    public void resetAdd() {
    	item = new Author();
    }

    public void edit(Author item) {
    	//beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Author();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Author();
        edit = false;
    }

    public void delete(Author item) throws IOException {
    	// DAO save the delete
        authorList.remove(item);
    }

    public List<Author> getList() {
        return authorList;
    }

    public Author getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }

    public UIPanel getResultPanel() {
      return resultPanel;
    }
    public void setResultPanel(UIPanel resultPanel) {
      this.resultPanel = resultPanel;
    }
     public String loadResults() {
      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         item.loadResults();
         resultPanel.setRendered(true);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "loaded results", null));
      } catch (Exception ex) {
         resultPanel.setRendered(false);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
         }
         return null;
   }
}