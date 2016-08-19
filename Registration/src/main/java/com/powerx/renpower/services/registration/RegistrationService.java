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

/**
 * @author Lohith Thota 
 * This service class calls the DAO layer to pass the
 * customer object and save the customer details to the database.
 */
public class RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Autowired
	CustomerClient custClient;

	@Autowired
	ServicePlanClient serviceClient;

	@Autowired
	MessageSender messageSender;

	/**
	 * This method passes the customer object to the DAO layer and custId is
	 * returned.
	 * @param customer
	 * @return String containing the plan info.
	 */
	@Transactional
	public String saveCustomer(Customer customer) {
		
		//saving customer details to the database, getting customer id in return
		int custId = registrationDAO.saveCustomer(customer);

		String message = null;
		if (custId != 0) {

			// REST Call
			Customer cust = custClient.getCustomerById(custId);

			//SOAP Call
			List<ServicePlan> servicePlansList = serviceClient.getServicePlans();

			//JMS Message
			messageSender.sendMessage(custId + " " + servicePlansList.get(2).getId());

			//Service plan info sent to the frontend
			message = "Name " + servicePlansList.get(2).getServicePlan() + " & Ends on "
					+ servicePlansList.get(2).getEndDate();

			return message;

		} else {
			return message;
		}
	}
}
