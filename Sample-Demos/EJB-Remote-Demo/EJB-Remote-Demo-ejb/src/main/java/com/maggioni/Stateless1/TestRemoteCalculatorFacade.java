package com.maggioni.Stateless1;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(TestRemoteCalculatorFacadeInterface.class)
public class TestRemoteCalculatorFacade implements TestRemoteCalculatorFacadeInterface{

    @Override
    public int add(int a, int b) {
       return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }
    
}
