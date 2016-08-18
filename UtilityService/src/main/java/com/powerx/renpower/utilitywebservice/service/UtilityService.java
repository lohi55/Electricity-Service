package com.powerx.renpower.utilitywebservice.service;

import java.util.List;

import com.powerx.renpower.utilitywebservice.dao.ServicePlanDAO;
import com.powerx.renpower.utilitywebservice.model.ServicePlan;

/**
 * This service layer class makes a DAO layer call to get the list of service plans.
 * @author Lohith Thota
 */
public class UtilityService {

	/**
	 * This method call the DAO layer to get the list of service plans from the Database.
	 * @return list of service plans
	 */
	public List<ServicePlan> getServicePlan() {
		ServicePlanDAO servicePlanDAO = new ServicePlanDAO();

		 List<ServicePlan> servicePlans = servicePlanDAO.getServicePlans();

		return servicePlans;
	}
}
