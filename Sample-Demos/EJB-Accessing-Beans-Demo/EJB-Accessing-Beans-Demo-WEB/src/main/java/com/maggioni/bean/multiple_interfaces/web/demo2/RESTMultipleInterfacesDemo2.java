package com.maggioni.bean.multiple_interfaces.web.demo2;

import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceA;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceB;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BeanMultipleInterfaces;
import com.maggioni.bean.multiple_interfaces.ejb.demo2.BeanMultipleInterfacesWithLocal;
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
