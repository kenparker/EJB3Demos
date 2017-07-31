package com.angelo.beans;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class SFSBLocalView {
    
    Logger logger = Logger.getLogger("root.SFSBlocalview");
    
    private Integer counter;
    
    public Integer getCounter() {
        return counter;
    }
    
    public void addToCounter(Integer addInteger) {
        counter+=addInteger;
    }
    
    @PostConstruct
    public void postConstr() {
        counter = new Integer(0);
        logger.info("-->>  Post construct " + this.toString());
    }
}
