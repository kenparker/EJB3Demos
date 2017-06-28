package com.maggioni.bean.multiple_interfaces.web;

import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceA;
import com.maggioni.bean.multiple_interfaces.ejb.BasicInterfaceB;
import com.maggioni.bean.multiple_interfaces.ejb.BeanMultipleInterfaces;
import com.maggioni.bean.multiple_interfaces.ejb.BeanMultipleInterfacesWithLocal;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("MultipleInterfaces2")
public class RESTMultipleInterfacesDemo2 {

    
    @Inject
    BeanMultipleInterfacesWithLocal beanAB;

    
    
    @GET
    @Path("AB")
    @Produces(MediaType.TEXT_HTML)
    public String processGetAB() {
        return "AB3: " + beanAB.toString() + " " + beanAB.getStringA() + " " + beanAB.getStringB();
    }
}
