Accessing Session Beans Demos
=============================


1. Bean with no-interface View
2. Bean with @Local, @LocalBean and @Remote Annotations
3. Bean with @Stateful, no-interface

## Demo 1: no-interface View


### the EJB
    @Stateless
    public class BasicEBJ {

        private static final Logger log = Logger.getLogger("root.BasicEBJ");

        public void sayHello() {
            log.info("-->> say Hello");
        }
    }

### the JNDI entries
    java:global/demo/EJB-Accessing-Beans-EJB-1.0/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:app/EJB-Accessing-Beans-EJB-1.0/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:module/BasicEBJ!com.maggioni.maven.basic.ejb.BasicEBJ 
    java:global/demo/EJB-Accessing-Beans-EJB-1.0/BasicEBJ 
    java:app/EJB-Accessing-Beans-EJB-1.0/BasicEBJ java:module/BasicEBJ


### the servlet
    @WebServlet(name = "BasicServlet", urlPatterns = {"/BasicServlet"})
    public class BasicServlet extends HttpServlet {

        @Inject
        BasicEBJ basicEBJ;

        ....
    }

## Demo 2: Bean with @Local, @LocalBean and @Remote Annotations

### EJB
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

### the JNDI ENtries
    java:global/demo/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.RemoteA 
    java:app/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.RemoteA 
    java:module/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.RemoteA 
    java:jboss/exported/demo/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.RemoteA 

    java:global/demo/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.LocalA 
    java:app/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.LocalA 
    java:module/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.LocalA 

    java:global/demo/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.EJBWithLocalAndRemoteInterfaces 
    java:app/EJB-Accessing-Beans-EJB-1.0/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.EJBWithLocalAndRemoteInterfaces 
    java:module/EJBWithLocalAndRemoteInterfaces!com.maggioni.LocalAndRemote.Demo.EJBWithLocalAndRemoteInterfaces

### the Test Servlet
    @WebServlet(name = "ServletToTestEJBDemo1", urlPatterns = {"/ServletToTestEJBDemo1"})
    public class ServletToTestEJBDemo1 extends HttpServlet {

        @EJB
        LocalA local;

        @EJB
        RemoteA remoteA;

        @EJB
        EJBWithAnnotationsDemo1 localBean;

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletToTestLocalAnnotation</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet at " + request.getContextPath() + "</h1>");

                out.println("<br>" + local.localA());
                out.println("<br>" + remoteA.remoteA());
                out.println("<br>" + localBean.remoteA());
                out.println("<br>" + localBean.localA());

                out.println("</body>");
                out.println("</html>");
            }
        }


    }

## Demo 3: Bean with @Stateful, no-interface

    @Stateful
    public class EJBSwitch {

        ...
    }

    @WebServlet(name = "ServletToTestEJBSwitch", urlPatterns = {"/ServletToTestEJBSwitch"})
    public class ServletToTestEJBSwitch extends HttpServlet {

        @Inject
        EJBSwitch switchString;
    }
