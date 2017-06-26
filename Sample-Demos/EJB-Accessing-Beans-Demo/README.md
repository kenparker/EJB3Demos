Accessing Session Beans Demos
=============================


the first example is accessing a BasicEJB using the @EJB annotation   

## the EJB
    @Stateless
    public class BasicEBJ {

        private static final Logger log = Logger.getLogger("root.BasicEBJ");

        public void sayHello() {
            log.info("-->> say Hello");
        }
    }

## the JNDI entries
    java:global/demo/EJB-Accessing-Beans-EJB-1.0/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:app/EJB-Accessing-Beans-EJB-1.0/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:module/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:global/demo/EJB-Accessing-Beans-EJB-1.0/BasicEBJ 
    java:app/EJB-Accessing-Beans-EJB-1.0/BasicEBJ java:module/BasicEBJ


## the servlet
    @WebServlet(name = "BasicServlet", urlPatterns = {"/BasicServlet"})
    public class BasicServlet extends HttpServlet {

        @EJB
        BasicEBJ basicEBJ;

        ....
    }
