package com.powerx.renpower.clients.restclient;

import com.powerx.renpower.models.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Lohith Thota
 * This class is used to make a REST call to the webservice
 */
public class CustomerClient {

	/**
	 * This method takes customer id as a parameter and returns
	 * Customer details as a JSON Object
	 * @param id
	 * @return Customer
	 */
	public Customer getCustomerById(int id) {

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/UtilityService/rest/cust/" + id);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		Customer cust = response.getEntity(Customer.class);
		return cust;
	}
}
