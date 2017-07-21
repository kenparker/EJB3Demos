package com.maggioni.bean.multiple_interfaces.ejb.demo2;

import javax.ejb.Stateless;

@Stateless
public class BeanA implements InterfaceA{

    @Override
    public String returnString(String string) {
        return string + " from returnString";
    }
    
}
