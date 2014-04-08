Simple deployable camel app example
===================================

A simple deployable application with embedded apache camel using Java DSL. 

This application create an event periodically, pass it to the bean and log the result. 

MainApp.java  

creates a camel context and add the route MyRouteBuilder.java.

ExmapleRoute.java contain the the routing process.
BootStrap.java contain the camel context.  

Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project
	
	deploy it on your favorite application server 
   	and observe the results on the application server console

For more help see the Apache Camel documentation

    http://camel.apache.org/

