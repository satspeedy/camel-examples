package de.satspeedy.camel.route;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.apache.camel.cdi.CdiCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class BootStrap
 */
@Singleton
@Startup
@LocalBean
public class BootStrap {

	Logger logger = LoggerFactory.getLogger(BootStrap.class);

	@Inject
	ExampleRoute exampleRoute;

	@Inject
	CdiCamelContext camelCtx;

	@PostConstruct
	public void init() throws Exception {
		logger.info(">> Create CamelContext and register Camel Route.");

		// Set camel context name
		camelCtx.setName("deployableExampleContext");

		// Add camel route
		camelCtx.addRoutes(exampleRoute);

		// Start camel context
		camelCtx.start();

		logger.info(">> CamelContext created and camel route started.");
	}

	@PreDestroy
	public void stop() throws Exception {
		camelCtx.stop();
	}

}
