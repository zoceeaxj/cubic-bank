package com.rab3tech.admin.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.customer.service.CustomerService;
import com.rab3tech.vo.CustomerVO;

@Controller
@RequestMapping("/admin")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String showCustomer(Model model) {
	   List<CustomerVO> customerVOs=customerService.findCustomers();
	   model.addAttribute("customerVOs", customerVOs);
	   return "admin/customers";
	}
	
	@GetMapping("/customers/photo")
	public void findCustomerPhoto(@RequestParam int cid,HttpServletResponse response) throws IOException {
	   byte[] photo=customerService.findPhotoByid(cid);
	   response.setContentType("image/png");
	   ServletOutputStream outputStream=response.getOutputStream();
	   if(photo!=null) {
		   outputStream.write(photo);
	   }else {
		   outputStream.write(new byte[] {});
	   }
	   outputStream.flush();
	   outputStream.close();
	}
}
