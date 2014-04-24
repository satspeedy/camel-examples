package bootstrap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.apache.camel.cdi.CdiCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import route.MyRouteBuilder;

/**
 * Session Bean implementation class BootStrap
 */
@Singleton
@LocalBean
@Startup
public class BootStrap {

	Logger logger = LoggerFactory.getLogger(BootStrap.class);

	@Inject
	CdiCamelContext camelCtx;

	@Inject
	MyRouteBuilder myRouteBuilder;

	/**
	 * Initialize context
	 * 
	 * @throws Exception
	 */
	@PostConstruct
	public void init() throws Exception {
		logger.info(">> Create CamelContext and register Camel Route.");

		// Set camel context name
		camelCtx.setName("cdiExampleContext");

		// Add camel route
		camelCtx.addRoutes(myRouteBuilder);

		// Start camel context
		camelCtx.start();

		logger.info(">> Camel context created and camel route started.");
	}

	@PreDestroy
	public void stop() throws Exception {
		camelCtx.stop();
	}

}
