package com.maggioni.EJB_and_Servlet_splitted.ejb.demo;

import javax.ejb.Stateful;

@Stateful
public class BBean {
    
    private String bString;
    
    public String getString() {
        return bString;
    }
    
    public void setString(String bString) {
        this.bString = bString;
    }
}
