package com.maggioni.EJB_and_Servlet_in_a_package.demo;

import javax.ejb.Stateful;

@Stateful
public class ABean {
    
    private String aString;
    
    public String getString() {
        return aString;
    }
    
    public void setString(String aString) {
        this.aString = aString;
    }
}
