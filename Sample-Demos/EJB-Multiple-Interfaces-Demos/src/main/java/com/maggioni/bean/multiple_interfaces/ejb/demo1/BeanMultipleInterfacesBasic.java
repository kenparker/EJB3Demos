package com.maggioni.bean.multiple_interfaces.ejb.demo1;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BeanMultipleInterfacesBasic implements BasicInterfaceAwithLocalAnnotation, BasicInterfaceBWithLocalAnnotation{

    @Override
    public String getStringA() {
        return "Hi, I'm from BeanMultipleInterfacesBasic getStringA";
    }

    @Override
    public String getStringB() {
        return "Hi, I'm from BeanMultipleInterfacesBasic getStringB";
    }
    
}
