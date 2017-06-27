package com.maggioni.stateful.ejb.demo1;

import javax.ejb.Stateful;


@Stateful
public class EJBSwitch {
    
    private String switchString;
    
    public String getSwitch() {
        return switchString;
    }
    
    public String switch1() {
        switchString = "Angelo";
        return switchString;
    }
    
    public String switch2() {
        switchString = "Marco";
        return switchString;
    }
}
