package com.powerx.renpower.utilitywebservice.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.powerx.renpower.utilitywebservice.model.ServicePlan;
import com.powerx.renpower.utilitywebservice.service.UtilityService;



@WebService
public class ServicePlanWS {

	@WebMethod
	public List<ServicePlan> getServicePlan() {

		UtilityService utilityService = new UtilityService();

		 List<ServicePlan> servicePlans = new ArrayList<ServicePlan>();
		 servicePlans = utilityService.getServicePlan();
		
		return servicePlans;
	}
	
}
