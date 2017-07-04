package com.maggioni.bean.multiple_interfaces.web.demo1;


import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceAwithLocalAnnotation;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceBWithLocalAnnotation;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BeanMultipleInterfacesBasic;


@Path("MultipleInterfacesDemo1")
public class RESTMultipleInterfacesDemo1 {

    @Inject
    BasicInterfaceAwithLocalAnnotation beanA;
    
    @Inject
    BasicInterfaceBWithLocalAnnotation beanB;
    
    @Inject
    BeanMultipleInterfacesBasic beanAB;

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
