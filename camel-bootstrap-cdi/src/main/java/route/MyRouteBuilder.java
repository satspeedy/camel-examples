package route;

import org.apache.camel.builder.RouteBuilder;

/**
 * {@link RouteBuilder} implementation class {@link MyRouteBuilder}
 * 
 * @author developer
 * 
 */
public class MyRouteBuilder extends RouteBuilder {

	public MyRouteBuilder() {
		System.out.println(">> MyRouteBuilder instantiated");
	}

	@Override
	public void configure() throws Exception {
		// @formatter:off

		// Set up a route that generates an event every 10 seconds
		from("timer://simple?fixedRate=true&period=10s")
			// Set Body with any text
			.setBody().simple("Bean Injected")
			// Lookup for bean injected by CdiContainer
			.beanRef("helloWorld", "sayHello")
		// Display response received in log when calling HelloWorld
		.log(">> Response : ${body}");
		
		// @formatter:on

	}

}
