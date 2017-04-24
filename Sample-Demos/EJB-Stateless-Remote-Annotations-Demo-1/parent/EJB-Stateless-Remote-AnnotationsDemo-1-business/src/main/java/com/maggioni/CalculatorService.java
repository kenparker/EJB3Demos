package com.maggioni;

import javax.ejb.Stateless;

@Stateless
public class CalculatorService implements CalculatorRemote {

    @Override
    public float add(float a, float b) {
        return a + b;
    } 
}
