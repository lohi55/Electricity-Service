package com.powerx.renpower.utilitywebservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powerx.renpower.utilitywebservice.model.Customer;
import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;



public class CustomerServiceDao{

	public Customer getCustomerDAO(int id){
		
		Session session = HIbernateUtil.getSessionFactory().getCurrentSession();
		Customer cust = new Customer();
		
		try {
			session.getTransaction().begin();
			cust = (Customer)session.get(Customer.class, id);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return cust;	
	}
}
