package com.maggioni.bean.multiple_interfaces.web.demo2;

import com.maggioni.bean.multiple_interfaces.ejb.demo2.BeanA;
import com.maggioni.bean.multiple_interfaces.ejb.demo2.InterfaceA;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testBeanEquals")
public class RESTTestBeanEquals {
    
    @EJB
    InterfaceA b1;
    
    @EJB
    InterfaceA b2;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String check() {
        return " equals? " + b1.equals(b2);
    }
}
