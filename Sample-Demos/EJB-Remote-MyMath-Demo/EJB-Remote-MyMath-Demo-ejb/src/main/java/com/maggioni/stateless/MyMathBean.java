package com.maggioni.stateless;

import javax.ejb.Stateless;

@Stateless
public class MyMathBean implements MyMathRemote{

    @Override
    public Double max(Double a, Double b) {
        return Math.max(a, b);
    }
    
}
