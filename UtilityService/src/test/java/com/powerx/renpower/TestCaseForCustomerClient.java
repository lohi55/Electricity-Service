package com.powerx.renpower;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.service.CustomerService;

/**
 * @author Lohith Thota
 *
 */
public class TestCaseForCustomerClient {

	CustomerService rsg = Mockito.mock(CustomerService.class);

	@Test
	public void testGetCustomer() {

	Customer sampleCustomer = new Customer();
		sampleCustomer.setFirstname("Lohith");
		sampleCustomer.setLastname("Thota");
		sampleCustomer.setUsername("lohith55");
		sampleCustomer.setPassword("12345");

		Mockito.when(rsg.getCustomerDetails(1)).thenReturn(sampleCustomer);

		Customer cust = rsg.getCustomerDetails(1);

		assertEquals(cust.getFirstname(), sampleCustomer.getFirstname());
		assertEquals(cust.getLastname(), sampleCustomer.getLastname());
		assertEquals(cust.getUsername(), sampleCustomer.getUsername());
		assertEquals(cust.getPassword(), sampleCustomer.getPassword());

	}

}
