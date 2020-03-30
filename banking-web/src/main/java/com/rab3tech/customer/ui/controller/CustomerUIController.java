package com.rab3tech.customer.ui.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.vo.CustomerSavingVO;

@Controller
public class CustomerUIController {
	
	@Autowired
	private CustomerEnquiryService customerEnquiryService;
	
	@GetMapping("/customer/account/registration")
	public String showCustomerRegistrationPage(@RequestParam String cuid,Model model) {
		Optional<CustomerSavingVO>  optional=customerEnquiryService.findCustomerEnquiryByUuid(cuid);
		if(optional.isEmpty()) {
			return "error";	
		}else {
			//model is used to carry data from controller to the view =- JSP/
			model.addAttribute("customerAccountVO",optional.get());
			return "customer/customerRegistration";	
		}
	}

}
