package com.maggioni.bean.multiple_interfaces.web;

import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceA;
import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceB;
import com.maggioni.bean.multiple_interfaces.ejb.BeanMultipleInterfaces;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("MultipleInterfaces")
public class RESTMultipleInterfacesDemo {

    @Inject
    BasicInterfaceA beanA;
    
    @Inject
    BasicInterfaceB beanB;
    
    @Inject
    BeanMultipleInterfaces beanAB;

    @GET
    @Path("A")
    @Produces(MediaType.TEXT_HTML)
    public String processGetA() {
        return beanA.toString() + " " + beanA.getStringA();
    }

    @GET
    @Path("B")
    @Produces(MediaType.TEXT_HTML)
    public String processGetB() {
        return beanB.toString() + " " + beanB.getStringB();
    }
    
    @GET
    @Path("AB")
    @Produces(MediaType.TEXT_HTML)
    public String processGetAB() {
        return "AB: " + beanAB.toString() + " " + beanAB.getStringA() + " " + beanAB.getStringB();
    }
}
