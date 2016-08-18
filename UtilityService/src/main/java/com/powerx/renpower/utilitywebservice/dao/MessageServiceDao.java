package com.powerx.renpower.utilitywebservice.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;

/**
 * This class is where the received JMS message is updated into database.
 * 
 * @author Lohith Thota
 */
public class MessageServiceDao {

	SessionFactory sessionFactory = (SessionFactory) HIbernateUtil.getSession();
	Session session = sessionFactory.getCurrentSession();

	/**
	 * This method takes in the paramaters customer ID & Service ID
	 * 
	 * @param custId
	 * @param serviceId
	 * @return boolean response based on the executeUpdate.
	 */
	public boolean updateCustomer(int custId, int serviceId) {
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update Customer set serv_id = :serviceId where id = :custId");

		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);

		int result = query.executeUpdate();
		tx.commit();

		if (result == 1)
			return true;

		else
			return false;
	}
}
