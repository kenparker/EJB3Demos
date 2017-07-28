package com.angelo.beans;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BeanALocalView {
    
    Logger logger = Logger.getLogger("root.beanlocalview");
    
    public String getWelcome(String name) {
        return "Hello " + name;
    }
    
    @PostConstruct
    public void postConstr() {
        logger.info("-->>  Post construct " + this.toString());
    }
}