package de.satspeedy.camel.bean;

import javax.inject.Named;

import org.apache.camel.Body;

@Named
public class HelloWorld {

	public String sayHello(@Body String message) {
		return ">> Hello " + message + " user.";
	}

}
