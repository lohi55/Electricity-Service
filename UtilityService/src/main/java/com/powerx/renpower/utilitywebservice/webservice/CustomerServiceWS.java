package com.powerx.renpower.utilitywebservice.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.service.CustomerService;


/**
 * This class is the webservice that actually being projected using the
 * 
 * @path annotation.
 * @author Lohith Thota The data is being received in the form of a JSON object
 */
@Path("/cust")
@Produces("application/json")
public class CustomerServiceWS {
	
	final static Logger logger = Logger.getLogger(CustomerServiceWS.class);

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetails(@PathParam("id") int id) {

		CustomerService custService = new CustomerService();

		Customer customer = custService.getCustomerDetails(id);

		return customer;
	}

}
