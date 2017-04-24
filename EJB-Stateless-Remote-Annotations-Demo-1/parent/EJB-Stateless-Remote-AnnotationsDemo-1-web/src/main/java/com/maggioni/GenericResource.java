
package com.maggioni;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("CalculatorDemo")
@Stateless
public class GenericResource {

    @Context
    private UriInfo context;

    @EJB (lookup = "java:global/BeanC/EJB-Stateless-Remote-AnnotationsDemo-1-business/CalculatorService")
    private CalculatorService calculatorService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        Float add = calculatorService.add(10, 1);   
        return add.toString();
    }

}
