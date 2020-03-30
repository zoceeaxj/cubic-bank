package com.rab3tech.customer.ui.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.vo.CustomerSavingVO;
import com.rab3tech.vo.CustomerVO;

@Controller
public class CustomerUIController {
	
	@Autowired
	private CustomerEnquiryService customerEnquiryService;
	
	@Autowired
	private CustomerService customerService;
	
	
	//http://localhost:444/customer/account/registration?cuid=1585a34b5277-dab2-475a-b7b4-042e032e8121603186515
	@GetMapping("/customer/account/registration")
	public String showCustomerRegistrationPage(@RequestParam String cuid,Model model) {
		Optional<CustomerSavingVO>  optional=customerEnquiryService.findCustomerEnquiryByUuid(cuid);
		CustomerVO customerVO=new CustomerVO();
		
		if(optional.isEmpty()) {
			return "error";	
		}else {
			//model is used to carry data from controller to the view =- JSP/
			CustomerSavingVO customerSavingVO=optional.get();
			customerVO.setEmail(customerSavingVO.getEmail());
			customerVO.setName(customerSavingVO.getName());
			customerVO.setMobile(customerSavingVO.getMobile());
			customerVO.setAddress(customerSavingVO.getLocation());
			customerVO.setToken(cuid);
			//model - is hash map which is used to carry data from controller to thyme leaf!!!!!
			// model is similar to request scope in jsp and servlet
			model.addAttribute("customerVO",customerVO);
			return "customer/customerRegistration";	//thyme leaf
		}
	}	

	@PostMapping("/customer/account/registration")
	public String createCustomer(@ModelAttribute CustomerVO customerVO,Model model) {
		    //saving customer into database
		    customerService.createAccount(customerVO);
		    //Write code to send email
			System.out.println(customerVO);
			model.addAttribute("message","Your account has been setup successfully , please check your email.");
			return "login";	
	}
}
