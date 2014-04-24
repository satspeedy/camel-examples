package bean;

import javax.inject.Named;

import org.apache.camel.Body;

@Named
public class HelloWorld {

	/**
	 * Return greeting text.
	 * 
	 * @param message
	 *          camel message {@link Body}
	 * @return greeting text
	 */
	public String sayHello(@Body String message) {
		return ">> Hello " + message + ".";
	}

}
