/*package com.powerx.renpower;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.service.CustomerService;

*//**
 * @author Lohith Thota
 *
 *//*
public class TestCaseForCustomerClient {

	CustomerService rsg = Mockito.mock(CustomerService.class);

	@Test
	public void testGetCustomer() {

		Customer customer = new Customer();
		customer.setFirstname("Lohith");
		customer.setLastname("Thota");
		customer.setUsername("lohith55");
		customer.setPassword("12345");

		when(rsg.getCustomerDetails(1)).thenReturn(customer);

		Customer cust = rsg.getCustomerDetails(1);

		assertEquals(cust, customer);

	}

}
*/