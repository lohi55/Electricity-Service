package com.powerx.renpower.utilitywebservice.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;

/**
 * @author Lohith Thota 
 * This class gets the customer details, populates the
 * customer object and sends back to the service layer.
 */
public class CustomerServiceDao {

	final static Logger logger = Logger.getLogger(CustomerServiceDao.class);

	/**
	 * This method gets the customer details, populates the customer object and
	 * sends back to the service layer.
	 * 
	 * @param id
	 *            is passed
	 * @return Customer object is returned
	 */
	public Customer getCustomerDetails(int id) {

		// Opening the session here
		Session session = HIbernateUtil.getSession().openSession();
		Customer cust = new Customer();

		try {

			cust = (Customer) session.get(Customer.class, id);
			// logger.info("Customer has been retrieved from the database");

			// Flushing the session
			session.flush();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.flush();
		}
		return cust;
	}
}
