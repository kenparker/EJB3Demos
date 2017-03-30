package com.maggioni;

import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful 
public class InfoCreator{

    private static final Logger log = Logger.getLogger("root.InfoCreator");
    
    private String firstName;
    private String lastName;
    
    private String name;
        
    public void setFirstName(String firstName) {
        log.info("-->> first name : " +  firstName);
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        log.info("-->> last name : " +  lastName);
        this.lastName = lastName;
    }
    
    @Remove
    public String createAccount() {
        this.name = firstName+lastName;
        return name;
    }
}
