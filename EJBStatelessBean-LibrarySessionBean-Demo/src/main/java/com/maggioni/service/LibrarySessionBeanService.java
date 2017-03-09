package com.maggioni.service;

import com.maggioni.components.LibrarySessionBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/LibrarySession")
@Stateless
public class LibrarySessionBeanService {
    
    @EJB
    LibrarySessionBean libraySessionBean;
    
    @GET
    public String addBook() {
       libraySessionBean.addBook("first book");
       return "OK";
    }
}
