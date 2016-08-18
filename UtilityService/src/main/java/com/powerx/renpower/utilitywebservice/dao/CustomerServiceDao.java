package com.powerx.renpower.utilitywebservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;

/**
 * @author Lohith Thota This class gets the customer details, populates the
 *         customer object and sends back to the service layer.
 */
public class CustomerServiceDao {

	/**
	 * This method gets the customer details, populates the customer object and
	 * sends back to the service layer.
	 * 
	 * @param id
	 *            is passed
	 * @return Customer object is returned
	 */
	public Customer getCustomerDAO(int id) {

		Session session = HIbernateUtil.getSessionFactory().getCurrentSession();
		Customer cust = new Customer();

		try {
			session.getTransaction().begin();
			cust = (Customer) session.get(Customer.class, id);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return cust;
	}
}
