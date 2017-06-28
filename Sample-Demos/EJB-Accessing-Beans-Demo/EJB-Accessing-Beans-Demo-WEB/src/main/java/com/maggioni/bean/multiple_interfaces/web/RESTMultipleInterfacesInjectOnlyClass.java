package com.maggioni.bean.multiple_interfaces.web;

import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceA;
import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceB;
import com.maggioni.bean.multiple_interfaces.ejb.BeanMultipleInterfaces;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("MultipleInterfaces")
public class RESTMultipleInterfacesInjectOnlyClass {

        
    @Inject
    BeanMultipleInterfaces beanAB;
       
    @GET
    @Path("AB2")
    @Produces(MediaType.TEXT_HTML)
    public String processGetAB() {
        return "AB2: " + beanAB.toString()+ " " + beanAB.getStringA() + " " + beanAB.getStringB();
    }
}
