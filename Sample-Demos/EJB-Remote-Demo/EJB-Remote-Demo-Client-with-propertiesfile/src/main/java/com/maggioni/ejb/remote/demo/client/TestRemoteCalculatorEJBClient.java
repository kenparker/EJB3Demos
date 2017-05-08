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
        // Name der Anwendnung - Achtuung evtl. ist der Name in application.xml verändert worden
        final String appName = "remote";
        // EJB Modul i.A. Name des EJB projekts
        final String moduleName = "EJB-Remote-Demo-ejb-1.0";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for our EJB deployment, so this is an empty string
        // Wird bei uns nicht benutzt!
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = TestRemoteCalculatorFacade.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = TestRemoteCalculatorFacadeInterface.class.getName();
        // Namen zusammenstellen
        StringBuilder nameBuilder = new StringBuilder();
        if (!remoteNamingProject) {
            nameBuilder.append("ejb:");
        }
        // Doppelte Trennzeichen sind unproblematisch
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
        
        String jndiName = createLookUpName(false);
        TestRemoteCalculatorFacadeInterface res = (TestRemoteCalculatorFacadeInterface) context.lookup(jndiName);
        return res;
    }

    private static Hashtable getJndiPropertiesCoreApiPropertiesFile() {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        return jndiProperties;
    }

}
