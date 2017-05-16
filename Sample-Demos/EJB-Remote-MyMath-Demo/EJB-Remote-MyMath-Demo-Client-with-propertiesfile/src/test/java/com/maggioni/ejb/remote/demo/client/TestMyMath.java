package com.maggioni.ejb.remote.demo.client;

import com.maggioni.stateless.MyMathRemote;
import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Test;

public class TestMyMath {
    
    MyMathClient myMathClient = new MyMathClient();
    
    @Test
    public void invokeMyMath() throws NamingException {
        // Let's lookup the remote stateless calculator
        final MyMathRemote myMath
                = myMathClient.lookupRemoteMyMath();
        
        Double a = 12.34;
        Double b = 55.23;
        
        Double max = myMath.max(a, b);
        Assert.assertEquals(b, max);
    }
    
}
