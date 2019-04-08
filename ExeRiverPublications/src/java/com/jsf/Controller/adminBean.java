
package com.jsf.Controller;

import com.jsf.Model.Administrator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author clair
 */
@ManagedBean
@RequestScoped
public class adminBean {

    private String forename;
    private String surname;
    private String email;
    private String address;
    private String password;
    private List admins;
        
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
    public adminBean() {
        
    }
    
}
