package ERPWeb.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Satya Choudhury
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String userName = "";    
    private String email = "";
    private String password = "";
    /**
     * Creates a new instance of GreetingsBean
     */
    public LoginBean() {
        System.out.println("Created GreetingsBean instance...");
    }
    
    public String getUserName() {
        return this.userName.trim();
    }
    
    public void setUserName(String userName) {
        this.userName = userName.trim();
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
    
    public String validateUserLogin() {
        String navResult = "";
        System.out.println("Entered Username is= " + email + ", password is= " + password);
        if (email.equalsIgnoreCase("clair") && password.equals("123")) {
            navResult = "success";
        } else {
            navResult = "failure";
        }
        return navResult;
    }
    
    public void logout(){
        this.email="";
    }
    
}
