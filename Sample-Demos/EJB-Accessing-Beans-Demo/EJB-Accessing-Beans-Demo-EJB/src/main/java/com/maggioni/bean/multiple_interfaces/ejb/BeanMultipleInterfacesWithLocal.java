package com.maggioni.bean.multiple_interfaces.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(BasicInterfaceC.class)
@Remote(BasicInterfaceD.class)
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
