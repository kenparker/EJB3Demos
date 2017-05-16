package com.maggioni.stateless;

import javax.ejb.Remote;

@Remote
public interface MyMathRemote {
    
    public Double max(Double a, Double b);
}
