package com.maggioni.bean.multiple_interfaces.ejb.demo1;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BeanMultipleInterfaces implements BasicInterfaceA, BasicInterfaceB{

    @Override
    public String getStringA() {
        return  "String from A";
    }

    @Override
    public String getStringB() {
        return  "String from B";
    }
    
}
