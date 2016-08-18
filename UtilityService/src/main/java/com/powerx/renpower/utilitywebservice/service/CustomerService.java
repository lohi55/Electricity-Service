package com.powerx.renpower.utilitywebservice.service;

import com.powerx.renpower.utilitywebservice.dao.CustomerServiceDao;
import com.powerx.renpower.utilitywebservice.model.Customer;


/**
 * The service layer is calling the DAO layer.
 * @author Lohith Thota
 */
public class CustomerService{
	
	/**
	 * This method takes in the customer ID and passes it to the DAO layer.
	 * @param c_id
	 * @return Customer object is returned
	 */
	public Customer getCustomerDetails(int c_id){
		
		CustomerServiceDao cust_DAO = new CustomerServiceDao();
		
		Customer cust = cust_DAO.getCustomerDAO(c_id);
		
		return cust;
	}

}
