package com.powerx.renpower.utilitywebservice.service;

import com.powerx.renpower.utilitywebservice.dao.MessageServiceDao;

public class MessageService {

	public void setCustomerService(int c_id, int serv_id) {
	
		MessageServiceDao messServiceDao = new MessageServiceDao();
		messServiceDao.updateCustomer(c_id, serv_id);
		
	}
}
