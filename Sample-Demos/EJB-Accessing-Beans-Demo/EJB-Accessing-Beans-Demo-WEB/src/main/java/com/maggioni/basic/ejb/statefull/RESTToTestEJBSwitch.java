package com.maggioni.basic.ejb.statefull;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("EJBSwitch")
public class RESTToTestEJBSwitch {
    
    @Inject
    EJBSwitch ejbs;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getSwitch() {
        ejbs.switch1();
        return ejbs.getSwitch();
    }
}
