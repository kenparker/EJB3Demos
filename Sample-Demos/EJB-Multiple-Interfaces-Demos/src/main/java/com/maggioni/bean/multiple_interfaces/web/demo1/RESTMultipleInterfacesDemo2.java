package com.maggioni.bean.multiple_interfaces.web.demo1;


import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceAwithLocalAnnotation;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BasicInterfaceBWithLocalAnnotation;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BeanMultipleInterfacesBasic;


@Path("MultipleInterfacesDemo2")
public class RESTMultipleInterfacesDemo2 {

    private static final String BEANS_A_B_EQUALS = "beanA, beanB are equals: ";
    private static final String BEANS_BASIC_EQUALS = "beanbasics are equals: ";
    
    @Inject
    BasicInterfaceAwithLocalAnnotation beanA;
    
    @Inject
    BasicInterfaceAwithLocalAnnotation beanB;
    
    @Inject
    BeanMultipleInterfacesBasic beanBasic1;
    
    @Inject
    BeanMultipleInterfacesBasic beanBasic2;
    
    @GET
    @Path("A")
    @Produces(MediaType.TEXT_HTML)
    public String processGetA() {
        return formatOutputCheckBeans() +  " " + beanA.getStringA();
    }

    private String formatOutputCheckBeans() {
        return BEANS_A_B_EQUALS + checkBeans(beanA, beanB) + " " + BEANS_BASIC_EQUALS + checkBeans(beanBasic1, beanBasic2);
    }

    @GET
    @Path("B")
    @Produces(MediaType.TEXT_HTML)
    public String processGetB() {
        return formatOutputCheckBeans() + " " + beanB.getStringA();
    }
    
    private Boolean checkBeans(Object bean1, Object bean2) {
        return bean1.equals(bean2);
    }   
}
