package com.powerx.renpower.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerx.renpower.models.Customer;
import com.powerx.renpower.services.registration.RegistrationService;



@Controller
public class RegistrationContoller {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping("/registration")
	public String registratation(@ModelAttribute("customer") Customer customer, Model model) {

		String messege = registrationService.saveCustomer(customer);
		
		if (messege != null) {
			model.addAttribute("planinfo",messege);
			return "success";
		} else
			return "fail";
	}
}