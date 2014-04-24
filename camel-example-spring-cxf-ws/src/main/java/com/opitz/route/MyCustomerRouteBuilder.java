package com.opitz.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.opitz.service.customer.CustomerService;
import com.opitz.service.customer.InputCustomerStatus;
import com.opitz.service.customer.InputReportSomething;
import com.opitz.service.customer.OutputCustomerStatus;
import com.opitz.service.customer.OutputReportSomething;

public class MyCustomerRouteBuilder extends RouteBuilder {

	// CXF webservice using code first approach
	private String uri = "cxf:/customer?serviceClass="
			+ CustomerService.class.getName();

	@Override
	public void configure() throws Exception {
		// @formatter:off
 
      from(uri)
        .to("log:input")
        // send the request to the route to handle the operation
        // the name of the operation is in that header
      .recipientList(simple("direct:${header.operationName}"));
 
      // report something
      from("direct:reportSomething")
      	.process(new Processor() {
              public void process(Exchange exchange) throws Exception {
                // get foo from input
                String foo = exchange.getIn().getBody(InputReportSomething.class).getFoo();
 
                // set reply including the id
                OutputReportSomething output = new OutputReportSomething();
                output.setCode("OK; your foo: " + foo);
                exchange.getOut().setBody(output);
              }
        })
      .to("log:output");
 
      // status customer
      from("direct:customerStatus")
        .process(new Processor() {
           public void process(Exchange exchange) throws Exception {
          	 String id = exchange.getIn().getBody(InputCustomerStatus.class).getCustomerId();
          	 
             // set reply
             OutputCustomerStatus output = new OutputCustomerStatus();
             output.setStatus("Status of customer " + id + " is in progress");
             exchange.getOut().setBody(output);
           }
        })
      .to("log:output");

      // @formatter:on	
	}
}