package com.powerx.renpower.utilitywebservice.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.powerx.renpower.utilitywebservice.model.ServicePlan;
import com.powerx.renpower.utilitywebservice.service.UtilityService;

/**
 * This class is being projected as a webservice using the @webservice
 * annotations
 * 
 * @author Lohith Thota
 *
 */
@WebService
public class ServicePlanWS {

	/**
	 * This method gets the list of service plans from the database.
	 * @return list of services
	 */
	@WebMethod
	public List<ServicePlan> getServicePlan() {

		UtilityService utilityService = new UtilityService();

		List<ServicePlan> servicePlans = new ArrayList<ServicePlan>();
		
		servicePlans = utilityService.getServicePlan();

		return servicePlans;
	}

}
