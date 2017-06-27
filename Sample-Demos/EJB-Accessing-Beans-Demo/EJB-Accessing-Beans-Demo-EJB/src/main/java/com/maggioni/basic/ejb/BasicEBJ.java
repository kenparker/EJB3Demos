package com.maggioni.basic.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;

@Stateless
public class BasicEBJ {
    
    private static final Logger log = Logger.getLogger("root.BasicEBJ");
    
    public void sayHello() {
        log.info("-->> say Hello");
    }
}
