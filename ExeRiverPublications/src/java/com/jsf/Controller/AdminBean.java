
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import com.jsf.Model.Book;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author clair
 * /
 **/
@ManagedBean(name="adminBean")
@RequestScoped
public class AdminBean implements Serializable{

    private String forename;
    private String surname;
    private String email;
    private String address;
    private String password;
    private List admins;
    
        
    private List<Book> books;
    /**
     *
     * @return
     */
    public String createAdmin(){
    
    Administrator admin = new Administrator();
    admin.setForename(forename);
    admin.setSurname(surname);
    admin.setEmail(email);
    admin.setAddress(address);
    admin.setPassword(password);
    return "Admin user created (" + forename + " " + surname + ")";
    }
    
    /*public Administrator getAdmins(){
        var admins = new List<Administrator>();
    }*/
    
    /**
     *
     */
    public AdminBean() {
        
    }
        
     
    public List<Book> getBooks() {
        return books;
    }
     /*
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }*/
}
