package com.powerx.renpower.utilitywebservice.service;

import java.util.List;

import com.powerx.renpower.utilitywebservice.dao.ServicePlanDAO;
import com.powerx.renpower.utilitywebservice.model.ServicePlan;



public class UtilityService {

	public List<ServicePlan> getServicePlan() {
		ServicePlanDAO servicePlanDAO = new ServicePlanDAO();

		 List<ServicePlan> servicePlans = servicePlanDAO.getServicePlanDAO();

		return servicePlans;
	}
}
