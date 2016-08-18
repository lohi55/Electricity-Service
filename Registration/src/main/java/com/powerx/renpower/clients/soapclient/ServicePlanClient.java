package com.powerx.renpower.clients.soapclient;

import java.util.List;

import com.powerx.renpower.utilitywebservice.ServicePlan;
import com.powerx.renpower.utilitywebservice.ServicePlanWS;
import com.powerx.renpower.utilitywebservice.ServicePlanWSService;




public class ServicePlanClient {
	
	public  List<ServicePlan> getServicePlans(){
		ServicePlanWSService service = new ServicePlanWSService();
		ServicePlanWS  powerPlans = service.getServicePlanWSPort();
		return powerPlans.getServicePlan();	
	}
	
	/*public static void main(String[] args) {
		ServicePlanClient client = new ServicePlanClient();
		System.out.println(client.getServicePlans().get(1).getServicePlan());
		
	}*/
}
