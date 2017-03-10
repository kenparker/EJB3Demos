package com.maggioni.service;

import com.maggioni.components.LibrarySessionBean;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/onlyAddBook")
@Stateless
public class LibrarySessionBeanOnlyAddBook {
    
    private static final Logger log = Logger.getLogger("root.librarySessionService");
    
    @EJB
    LibrarySessionBean librarySessionBean;
    
    @GET
    @Path("/addBook")
    public String addBook(){
        //log.info("-->> addBookOnly called + " + "SessionBean : " + librarySessionBean);
        librarySessionBean.addBook("HarryPotter book");
        return "OK";
    }
}
