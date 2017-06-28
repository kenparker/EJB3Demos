package com.maggioni.basic.ejb.stateless;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("BasicRest")
public class BasicREST {

    @Inject
    BasicEBJ basicEBJ;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String processGet() {
        return basicEBJ.returnHello();
    }

    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public String processPost() {
        return basicEBJ.returnHello();
    }
}
