package com.powerx.renpower.utilitywebservice.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;

/**
 * This class is where the received JMS message is updated into database.
 * @author Lohith Thota
 */
public class MessageServiceDao {

	// Opening the session here
	Session session = HIbernateUtil.getSession().openSession();

	/**
	 * This method takes in the paramaters customer ID & Service ID
	 * @param custId
	 * @param serviceId
	 * @return boolean response based on the executeUpdate.
	 */
	public void updateCustomer(int custId, int serviceId) {
		System.out.println(serviceId);

		Query query = session.createQuery("update Customer set serv_id = :serviceId where id = :custId");

		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);

		query.executeUpdate();

		// Flushing the session
		session.flush();

	}
}
