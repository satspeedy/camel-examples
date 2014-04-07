Simple standalone camel app example
===================================

A simple standalone application with embedded apache camel using Java DSL. 

This application route xml files from src/data to target/messages. 

MainApp.java creates a camel context and the add the route MyRouteBuilder.java.

MyRouteBuilder.java poll the source directory for a new file and move it to the correct 
target directory, dependent on the content (content based routing via xpath).


Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

