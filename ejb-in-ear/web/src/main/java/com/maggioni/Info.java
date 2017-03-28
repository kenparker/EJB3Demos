package com.maggioni;

import com.maggioni.InfoCreator;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "info")
@SessionScoped
public class Info implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EJB
    InfoCreator infoCreator;
   
    
    public String getHello() {
        return infoCreator.sayHello();
    }
}
