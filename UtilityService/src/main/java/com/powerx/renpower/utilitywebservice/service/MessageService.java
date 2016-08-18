package com.powerx.renpower.utilitywebservice.service;

import com.powerx.renpower.utilitywebservice.dao.MessageServiceDao;

/**
 * This class calls the dao layer to update the service ID in the customer
 * table.
 * 
 * @author Lohith Thota
 */
public class MessageService {

	/**
	 * This method takes in customer id & Service ID to send them to the
	 * database.
	 * 
	 * @param c_id
	 * @param serv_id
	 */
	public void setCustomerService(int c_id, int serv_id) {

		MessageServiceDao messServiceDao = new MessageServiceDao();

		messServiceDao.updateCustomer(c_id, serv_id);

	}
}
