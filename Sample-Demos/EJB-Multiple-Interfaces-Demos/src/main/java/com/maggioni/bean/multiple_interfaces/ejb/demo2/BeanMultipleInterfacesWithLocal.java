package com.maggioni.bean.multiple_interfaces.ejb.demo2;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BeanMultipleInterfacesWithLocal implements BasicInterfaceC, BasicInterfaceD{

    @Override
    public String getStringA() {
        return "I'm from A";
    }

    @Override
    public String getStringB() {
        return "I'm from B";
    }
    
}
