package com.maggioni.bean.multiple_interfaces.web.demo1;


import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.maggioni.bean.multiple_interfaces.ejb.demo1.BeanMultipleInterfacesBasic;
import javax.ejb.EJB;


@Path("MultipleInterfacesDemo3")
public class RESTMultipleInterfacesDemo3 {

    private static final String BEANS_BASIC_EQUALS = "beanbasics are equals: >";
        
    @EJB
    BeanMultipleInterfacesBasic beanBasic1;
    
    @EJB
    BeanMultipleInterfacesBasic beanBasic2;
    
    @GET
    @Path("A")
    @Produces(MediaType.TEXT_HTML)
    public String processGetA() {
        return formatOutputCheckBeans(); // beanbasics are equals: >true<
    }

    private String formatOutputCheckBeans() {
        return  BEANS_BASIC_EQUALS + checkBeans(beanBasic1, beanBasic2) + "<";
    }

        
    private Boolean checkBeans(Object bean1, Object bean2) {
        return bean1.equals(bean2);
    }   
}
