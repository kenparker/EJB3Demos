package com.maggioni.bean.multiple_interfaces.ejb.demo2;

import javax.ejb.Local;

@Local
public interface InterfaceA {
    public String returnString(String string);
}
