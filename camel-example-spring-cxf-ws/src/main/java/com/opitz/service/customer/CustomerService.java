package com.opitz.service.customer;

public interface CustomerService {

	/**
	 * Operation to report something      
	 */
	OutputReportSomething reportSomething(InputReportSomething input);

	/**
	 * Operation to get the status of an customer      
	 */
	OutputCustomerStatus customerStatus(InputCustomerStatus input);

}
