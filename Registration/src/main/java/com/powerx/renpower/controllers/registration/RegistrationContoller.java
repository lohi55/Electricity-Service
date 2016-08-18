package com.powerx.renpower.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerx.renpower.models.Customer;
import com.powerx.renpower.services.registration.RegistrationService;

/**
 * @author Lohith Thota 
 * This class is the registration controller. The dispatcher servlet looks in all the 
 * @controller annotated classes for the url patterns
 */
@Controller
public class RegistrationContoller {

	@Autowired
	RegistrationService registrationService;

	/**
	 * Based on the url this method is mapped 
	 */
	@RequestMapping("/registration")
	public String registratation(@ModelAttribute("customer") Customer customer, Model model) {

		String messege = registrationService.saveCustomer(customer);

		if (messege != null) {
			model.addAttribute("planinfo", messege);
			return "success";

		} else
			return "fail";
	}
}