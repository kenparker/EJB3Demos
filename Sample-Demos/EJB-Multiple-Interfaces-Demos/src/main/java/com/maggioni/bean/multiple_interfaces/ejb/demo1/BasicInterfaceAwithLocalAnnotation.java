package com.maggioni.bean.multiple_interfaces.ejb.demo1;

import javax.ejb.Local;

@Local
public interface BasicInterfaceAwithLocalAnnotation {
    String getStringA();
}
