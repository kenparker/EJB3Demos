EJB Remote 
==================

The purpose of this demo is to demonstrate how to access an EJB through a client.
The EJB is packaged in an EAR file and deployed to a WildFly 10.1 application server.
In order to access an EJB on a remote server the client need to do the following steps:
+ Configure the server either through a configuration file or directly in a Java code.
+ Build a JNDI lookup string
+ Add the Wildlfy-ejb-client-bom to the pom.file

