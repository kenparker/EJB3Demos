package com.maggioni;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "info")
@SessionScoped
public class Info implements Serializable{

    private static final Logger log = Logger.getLogger("root.InfoCreator");
    private static final long serialVersionUID = 1L;
    
    @EJB
    InfoCreator infoCreator;
   
    
    public void setFirstName(String firstName) {
        infoCreator.setFirstName(firstName);
    }
    
    public void setLastName(String lastName) {
        infoCreator.setLastName(lastName);
        createAccount();
    }
    
    public void createAccount() {
        String createAccount = infoCreator.createAccount();
        log.info("-->> " + createAccount);
    }
}

