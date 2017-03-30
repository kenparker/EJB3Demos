package com.maggioni.service;

import com.maggioni.components.LibrarySessionBean;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/LibrarySession")
@Stateless
public class LibrarySessionBeanService {
    
    private static final Logger log = Logger.getLogger("root.librarySessionService");
    
    @EJB
    LibrarySessionBean libraySessionBean;
    
    @GET
    @Path("/addBooks")
    public String addBooks() {
        //log.info("-->> addBooks called + " + "SessionBean : " + libraySessionBean);
        
        libraySessionBean.addBook("first book");
        
        List books = libraySessionBean.getBooks();
        
        return books.toString();
    }
    
    @GET
    @Path("/getBooks")
    public String getBooks() {
        log.info("-->> getBooks called");
        List books = libraySessionBean.getBooks();
        return books.toString();
    }
    
    @GET
    @Path("/remove")
    public String removeEJB() {
        log.info("-->> removeEJB() called");
        libraySessionBean.remove();
        return "removed OK";
    }
}
