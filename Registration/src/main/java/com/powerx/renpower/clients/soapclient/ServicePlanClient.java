package com.powerx.renpower.clients.soapclient;

import java.util.List;

import com.powerx.renpower.utilitywebservice.ServicePlan;
import com.powerx.renpower.utilitywebservice.ServicePlanWS;
import com.powerx.renpower.utilitywebservice.ServicePlanWSService;


/**
 * @author Lohith Thota
 * This class is used to make a SOAP call to the webservice
 */
public class ServicePlanClient {
	
	/**
	 * This method returns a list of all the available services in the database
	 * @return list of service plans
	 */
	public  List<ServicePlan> getServicePlans(){
		
		ServicePlanWSService service = new ServicePlanWSService();
		ServicePlanWS  powerPlans = service.getServicePlanWSPort();
		
		return powerPlans.getServicePlan();	
	}
	
	//Java client to test out in Eclipse
	/*public static void main(String[] args) {
		ServicePlanClient client = new ServicePlanClient();
		System.out.println(client.getServicePlans().get(1).getServicePlan());
		
	}*/
}
