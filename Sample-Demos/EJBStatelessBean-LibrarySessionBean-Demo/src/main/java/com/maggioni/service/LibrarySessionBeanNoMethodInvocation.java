package com.maggioni.service;

import com.maggioni.components.LibrarySessionBean;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/NoMethod")
@Stateless
public class LibrarySessionBeanNoMethodInvocation {
    
    private static final Logger log = Logger.getLogger("root.NoMethod");
    
    @EJB
    LibrarySessionBean librarySessionBean;
    
    @GET
    @Path("/dummy")
    public String dummyMethod() {
        log.info("-->> dummyMethod called");
        return "OK";
    }
}
