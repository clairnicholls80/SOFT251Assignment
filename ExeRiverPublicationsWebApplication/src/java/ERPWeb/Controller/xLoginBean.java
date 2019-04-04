package ERPWeb.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author clair
 */
@ManagedBean
@RequestScoped
public class xLoginBean {

    private String email = "";
    private String password = "";
    /**
     * Creates a new instance of LoginManagedBean
     */
    public xLoginBean() {
        System.out.println("Login Bean created");
    }
        
    public String getEmail() {
        return this.email.trim();
    }
    
    public void setEmail(String email) {
        this.email = email.trim();
    }
    
    public String getPassword() {
        return this.password.trim();
    }
    
    public void setPassword(String password) {
        this.password = password.trim();
    }
    
    
    public String login() {
        return "greeting";
    }
    public void logout(){
        this.email="";
    }
}
