package com.maggioni;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
    public float add(float a, float b);
    
    
}
