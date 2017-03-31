package com.maggioni.maven.basic.ejb;


import javax.ejb.Stateless;
import org.jboss.logging.Logger;

@Stateless
public class BasicEBJ {
    
    private static final Logger log = Logger.getLogger(BasicEBJ.class.getName());
            
    
    public void sayHello() {
        log.info("-->> say Hello");
    }
}
