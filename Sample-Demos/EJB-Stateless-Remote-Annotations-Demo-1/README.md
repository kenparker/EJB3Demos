The Demo has mainly two goals:

+ Demostrate how to package an application using a BOM-Parent-EAR Structure
+ @Remote Annotation on the EJB (not the Interface)
+ @Stateless(name=xxxxx)
+ Use of Common Utilities


Example of JNDI entries

* Case 1: No @Remote Annotation<br>
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService!com.maggioni.LogService   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService!com.maggioni.LogService   
java:module/LogService!com.maggioni.LogService   
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService   
java:module/LogService   

* case 2: @Remote Annotation<br>
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService!**com.maggioni.LogServiceRemote**   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService!com.maggioni.LogServiceRemote   
java:module/LogService!com.maggioni.LogServiceRemote   
**java:jboss/exported/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService!com.maggioni.LogServiceRemote**   
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/LogService   
java:module/LogService 

* case 3: @Stateless(name="Service")<br>
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/**Service**!com.maggioni.LogServiceRemote   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/Service!com.maggioni.LogServiceRemote   
java:module/Service!com.maggioni.LogServiceRemote   
java:jboss/exported/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/Service!com.maggioni.LogServiceRemote   
java:global/Log/EJB-Stateless-Remote-AnnotationsDemo-1-business/Service   
java:app/EJB-Stateless-Remote-AnnotationsDemo-1-business/Service  
java:module/Service   

## LogService   
    @Stateless(name = "Service")   
    @Remote(LogServiceRemote.class)    
    public class LogService implements LogServiceRemote{

      Logger logger = Logger.getLogger("Root.Service");

      @Override
      public void logTestString() {
          final String actual = new ToStringBuilder(this)
                  .add("key1", "value")
                  .add("key2", Boolean.FALSE)
                  .add("key3", 442)
                  .add("key4", false)
                  .build();
          logger.info(actual);

      }
    }
