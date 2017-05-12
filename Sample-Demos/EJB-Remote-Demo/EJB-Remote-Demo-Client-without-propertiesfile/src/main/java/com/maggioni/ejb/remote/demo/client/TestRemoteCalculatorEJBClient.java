package com.maggioni.ejb.remote.demo.client;

import com.maggioni.Stateless1.TestRemoteCalculatorFacade;
import com.maggioni.Stateless1.TestRemoteCalculatorFacadeInterface;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestRemoteCalculatorEJBClient {

    public static void main(String[] args) throws Exception {
        // Testaufruf starten
        invokeStatelessBean();
    }

    private static void invokeStatelessBean() throws NamingException {
        // Let's lookup the remote stateless calculator
        final TestRemoteCalculatorFacadeInterface statelessRemoteCalculator
                = TestRemoteCalculatorEJBClient.lookupRemoteStatelessCalculator();
        System.out.println("Obtained a remote stateless calculator for invocation");
        int a = 204;
        int b = 340;
        System.out.println("Addition " + a + " + " + b);
        // Remote Methode Aufrufen
        int sum = statelessRemoteCalculator.add(a, b);
        System.out.println("Remote calculator returned sum = " + sum);
        if (sum != a + b) {
            throw new RuntimeException("Remote Aufruf mit falschem Resultat " + sum
                    + " ,erwartet " + (a + b));
        }
        int num1 = 3434;
        int num2 = 2332;
        System.out.println("Subtraktion " + num2 + " - " + num1);
        // Remote Methode Aufrufen
        int difference = statelessRemoteCalculator.subtract(num1, num2);
        System.out.println("Remote calculator returned difference = " + difference);
        if (difference != num1 - num2) {
            throw new RuntimeException("Remote Aufruf mit falschem Resultat " + difference
                    + " ,erwartet " + (num1 - num2));
        }
    }

    private static String createLookUpName(boolean remoteNamingProject) {
        // Application name of the deployed EJBs
        final String appName = "remote";
        // EJB Modul name
        final String moduleName = "EJB-Remote-Demo-ejb-1.0";
        // not used
        final String distinctName = "";
        // The bean implementation class
        final String beanName = TestRemoteCalculatorFacade.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = TestRemoteCalculatorFacadeInterface.class.getName();
        
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
        System.out.println("Test: nameBuilder = " + nameBuilder.toString());
        return nameBuilder.toString();
    }

    private static TestRemoteCalculatorFacadeInterface lookupRemoteStatelessCalculator() throws NamingException {
        final Hashtable jndiProperties = getJndiPropertiesCoreApiPropertiesFile();
        final Context context = new InitialContext(jndiProperties);
        
        String jndiName = createLookUpName(true);
        TestRemoteCalculatorFacadeInterface res = (TestRemoteCalculatorFacadeInterface) context.lookup(jndiName);
        return res;
    }

    private static Hashtable getJndiPropertiesCoreApiPropertiesFile() {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(javax.naming.Context.PROVIDER_URL, "http-remoting://env-1747105.jelastic.dogado.eu:8080");
        jndiProperties.put(javax.naming.Context.SECURITY_PRINCIPAL, "myuser");
        jndiProperties.put(javax.naming.Context.SECURITY_CREDENTIALS, "myuser");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        return jndiProperties;
    }

}
