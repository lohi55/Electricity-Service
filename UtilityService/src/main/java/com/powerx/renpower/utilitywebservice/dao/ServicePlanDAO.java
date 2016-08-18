package com.powerx.renpower.utilitywebservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powerx.renpower.utilitywebservice.model.ServicePlan;
import com.powerx.renpower.utilitywebservice.util.HIbernateUtil;

/**
 * @author Lohith Thota This class gets all the service plans present in the
 *         database serviceplan table in the form of a list.
 */
public class ServicePlanDAO {

	/**
	 * This method gets all the service plans present in the database
	 * serviceplan table in the form of a list.
	 * 
	 * @return list of plans
	 */
	@SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlanDAO() {

		List<ServicePlan> serviceList = new ArrayList<ServicePlan>();
		Session session = HIbernateUtil.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();
			
			serviceList = session.createQuery("from ServicePlan").list();
			session.getTransaction().commit();
		
		} catch (HibernateException e) {
			
			e.printStackTrace();
			session.close();
		}

		if (serviceList.isEmpty()) {
			return null;
		
		} else {
			return serviceList;
		}

	}

}
