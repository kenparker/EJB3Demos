package com.maggioni.Local_LocalBean_Remote_Annotations.Demo;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(LocalA.class)
@Remote(RemoteA.class)
@LocalBean
public class EJBWithAnnotationsDemo1 {
    public String localA(){
        return "hi! I'm from localA";
    }
    public String remoteA() {
        return "hi! I'm from remoteA";
        
    }
    
}
