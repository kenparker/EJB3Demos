package com.angelo.beans;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SLSBLocalView {
    
    Logger logger = Logger.getLogger("root.SLSBlocalview");
    
    @Resource
    private SessionContext sctx;
    
    public String getWelcome(String name) {
        return "Hello " + name;
    }
    
    public SessionContext getSessionContext() {
        return sctx;
    }
    
    @PostConstruct
    public void postConstr() {
        logger.info("-->>  Post construct " + this.toString());
    }
}
