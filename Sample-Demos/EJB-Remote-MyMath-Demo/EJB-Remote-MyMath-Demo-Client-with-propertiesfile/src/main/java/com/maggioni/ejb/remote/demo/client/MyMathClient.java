package com.maggioni.ejb.remote.demo.client;

import com.maggioni.stateless.MyMathBean;
import com.maggioni.stateless.MyMathRemote;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyMathClient {
 
    public static MyMathRemote lookupRemoteMyMath() throws NamingException {
        final Hashtable jndiProperties = getJndiPropertiesCoreApiPropertiesFile();
        final Context context = new InitialContext(jndiProperties);
        
        String jndiName = createLookUpName(false);
        MyMathRemote res = (MyMathRemote) context.lookup(jndiName);
        return res;
    }
    
    private static String createLookUpName(boolean remoteNamingProject) {
        // Application name of the deployed EJBs
        final String appName = "remote";
        // EJB Modul name
        final String moduleName = "EJB-Remote-MyMath-Demo-ejb-1.0";
        // not used
        final String distinctName = "";
        // The bean implementation class
        final String beanName = MyMathBean.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = MyMathRemote.class.getName();
        
        StringBuilder nameBuilder = new StringBuilder();
        if (!remoteNamingProject) {
            nameBuilder.append("ejb:");
        }
      
        nameBuilder.append(appName);
        nameBuilder.append("/");
        nameBuilder.append(moduleName);
        nameBuilder.append("/");
        nameBuilder.append(distinctName);
        nameBuilder.append("/");
        nameBuilder.append(beanName);
        nameBuilder.append("!");
        nameBuilder.append(viewClassName);
        System.out.println("-> nameBuilder = " + nameBuilder.toString());
        return nameBuilder.toString();
    }
    
    private static Hashtable getJndiPropertiesCoreApiPropertiesFile() {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        return jndiProperties;
    }
}
