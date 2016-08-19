package com.powerx.renpower.dao.registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.powerx.renpower.models.Customer;

/**
 * @author Lohith Thota
 * This class saves the customer details into the database
 */
@Repository
public class RegistrationDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	
	/**
	 * This method begins the session and then saves the customer
	 * details into the database.
	 * @param customer object
	 * @return customer ID
	 */
	public int saveCustomer(Customer customer) {
		
		Session session = mySessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		int custId = (Integer) session.save(customer);
		trans.commit();
		
		return custId;
	}
}
