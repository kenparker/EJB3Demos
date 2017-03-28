package com.maggioni;

import java.util.logging.Logger;
import javax.ejb.Stateful;

@Stateful 
public class InfoCreator{

    private static final Logger log = Logger.getLogger("root.InfoCreator");
    public String sayHello() {
      
       log.info("say Hello called");
       return "Hello there";
    }
}
