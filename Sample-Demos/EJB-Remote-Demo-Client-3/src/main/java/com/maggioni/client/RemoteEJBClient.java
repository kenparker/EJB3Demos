package com.maggioni.client;

import com.maggioni.Stateless2.CalculatorBean;
import com.maggioni.Stateless2.RemoteCalculator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Hashtable;

public class RemoteEJBClient {

    public static void main(String[] args) throws Exception {
        // Invoke a stateless bean
        invokeStatelessBean();

    }

    private static void invokeStatelessBean() throws NamingException {
        // Let's lookup the remote stateless calculator
        final RemoteCalculator statelessRemoteCalculator = lookupRemoteStatelessCalculator();
        System.out.println("-> Obtained a remote stateless calculator for invocation");
        // invoke on the remote calculator
        int a = 204;
        int b = 340;
        System.out.println("-> Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
        int sum = statelessRemoteCalculator.add(a, b);
        System.out.println("-> Remote calculator returned sum = " + sum);
        if (sum != a + b) {
            throw new RuntimeException("-> Remote stateless calculator returned an incorrect sum " + sum + " ,expected sum was "
                + (a + b));
        }
        // try one more invocation, this time for subtraction
        int num1 = 3434;
        int num2 = 2332;
        System.out.println("-> Subtracting " + num2 + " from " + num1
            + " via the remote stateless calculator deployed on the server");
        int difference = statelessRemoteCalculator.subtract(num1, num2);
        System.out.println("-> Remote calculator returned difference = " + difference);
        if (difference != num1 - num2) {
            throw new RuntimeException("-> Remote stateless calculator returned an incorrect difference " + difference
                + " ,expected difference was " + (num1 - num2));
        }
    }

    private static RemoteCalculator lookupRemoteStatelessCalculator() throws NamingException {
        Hashtable jndiProperties = getJndiProperties();
        final Context context = new InitialContext(jndiProperties);

        String jndiname = createLookUpName();
        System.out.println("-> jndiname is : " + jndiname);
        return (RemoteCalculator) context.lookup(jndiname);
    }

    private static String createLookUpName() {
        // java:jboss/exported/Remote/EJB-Remote-Demo-ejb-1.0/CalculatorBean!com.maggioni.Stateless2.RemoteCalculator
        // let's do the lookup
        // Normally the appName is the EAR name
        // Leave it empty if your application isn't packaged in a EAR
        String appName = "Remote/";
        // The EJB module name
        String moduleName = "EJB-Remote-Demo-ejb-1.0/";
        String beanName = CalculatorBean.class.getSimpleName();
        String viewClassName = RemoteCalculator.class.getName();
        final String jndiname = "ejb:" + appName + moduleName + "/" + beanName + "!" + viewClassName;
        return jndiname;
    }

    private static Hashtable getJndiProperties() {
        final Hashtable jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        return jndiProperties;
    }

}
