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

    private static final String BEANS_EQUALS = "beanA, beanB and Basic are equals: ";
    
    @Inject
    BasicInterfaceAwithLocalAnnotation beanA;
    
    @Inject
    BasicInterfaceBWithLocalAnnotation beanB;
    
    @Inject
    BeanMultipleInterfacesBasic beanBasic;
    
    @GET
    @Path("A")
    @Produces(MediaType.TEXT_HTML)
    public String processGetA() {
        return BEANS_EQUALS + checkBeans() + " " + beanA.getStringA();
    }

    @GET
    @Path("B")
    @Produces(MediaType.TEXT_HTML)
    public String processGetB() {
        return BEANS_EQUALS + checkBeans() + " " + beanB.getStringB();
    }
    
    private Boolean checkBeans() {
        return beanA.equals(beanB) && beanA.equals(beanBasic);
    }   
}
