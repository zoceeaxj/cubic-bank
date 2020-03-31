package com.rab3tech.user.ui.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rab3tech.customer.service.LoginService;
import com.rab3tech.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value= {"/customer/login","/auth"})
	public String showCustomerLogin(Model model) {
			LoginVO loginVO=new LoginVO();
			model.addAttribute("loginVO",loginVO);
			return "customer/login";	//login.html
	}	
	
	@PostMapping(value= {"/customer/login","/auth"})
	public String postLogin(@ModelAttribute LoginVO loginVO,HttpSession session,Model model) {
			Optional<LoginVO> optional=loginService.authUser(loginVO);
			if(optional.isPresent()) {
				LoginVO  loginVO2=optional.get();
				loginVO2.setPassword("*@&@&^@^&@^@");
				session.setAttribute("userSessionVO", loginVO2);
				return "customer/dashboard";	//dashboard.html
			}else {
				model.addAttribute("error","Sorry , your username and password are not valid!");
				return "customer/login";	//login.html
			}
		
	}	

}
