package com.rab3tech.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.vo.ApplicationResponseVO;
import com.rab3tech.vo.CustomerSavingVO;
import com.rab3tech.vo.PayeeApproveVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v3")
public class CustomerStatusController {
	
	@Autowired
	private CustomerEnquiryService customerEnquiryService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customer/app/status")
	public CustomerSavingVO findCustomerStatus(@RequestParam String searchText){
		CustomerSavingVO customerSavingVO =customerEnquiryService.findAppStatus(searchText);
		return customerSavingVO;
	}
	
	@PostMapping("/customer/payee/approve")
	public ApplicationResponseVO approveOrDisapprovePayee(@RequestBody PayeeApproveVO approveVO){
		String response=customerService.approveDisApprovePayee(approveVO);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		if("approved".equalsIgnoreCase(response)){
			applicationResponseVO.setMessage("Yeap , it has been approved!!!!!!!!!!!");
			applicationResponseVO.setStatus("pass");
		}else{
			applicationResponseVO.setStatus("fail");
			applicationResponseVO.setMessage("Sorry , Your urn is not correct , please check it again!");
		}
		return applicationResponseVO;
	}

}
