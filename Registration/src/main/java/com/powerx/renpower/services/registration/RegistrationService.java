package com.powerx.renpower.services.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.powerx.renpower.clients.restclient.CustomerClient;
import com.powerx.renpower.clients.soapclient.ServicePlanClient;
import com.powerx.renpower.dao.registration.RegistrationDAO;
import com.powerx.renpower.jms.MessageSender;
import com.powerx.renpower.models.Customer;
import com.powerx.renpower.utilitywebservice.ServicePlan;







public class RegistrationService {

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	CustomerClient custClient;

	@Autowired
	ServicePlanClient serviceClient;

	@Autowired
	MessageSender messageSender;
	
	@Transactional
	public String saveCustomer(Customer customer) {
		int custId = regDAO.saveCustomer(customer);

		String messege = null;
		if (custId != 0) {
			
			Customer cust = custClient.getCustomerById(custId);

			
			List<ServicePlan> servicePlansList = serviceClient.getServicePlans();

			
			messageSender.sendMessage(custId + " " + servicePlansList.get(2).getId());

			messege = "Name " + servicePlansList.get(2).getServicePlan() + " & Ends on "
					+ servicePlansList.get(2).getEndDate() ;

			return messege;
		} else {
			return messege;
		}
	}
}
