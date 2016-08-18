package com.powerx.renpower.utilitywebservice.service;

import com.powerx.renpower.utilitywebservice.dao.CustomerServiceDao;
import com.powerx.renpower.utilitywebservice.model.Customer;

public class CustomerService{
	
	public Customer getCustomerDetails(int c_id){
		
		CustomerServiceDao cust_DAO = new CustomerServiceDao();
		
		Customer cust = cust_DAO.getCustomerDAO(c_id);
		
		return cust;
	}

}
