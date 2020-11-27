package com.techniecode.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techniecode.entities.LoanAppLogin;

@Controller
public class DefaultController {
	
	@RequestMapping(value = "/appsignup", method = RequestMethod.POST)
	public @ResponseBody String appsignup(@ModelAttribute("login") LoanAppLogin login) {
		System.out.println("*************************Signup Record Inserting/Updating***************************");
		return "pages/loginpage";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("************************Login***********************");
		return "pages/loginpage";
	} 
	@GetMapping("/modalDialog")
	public String modalDialog() {
		return "modalDialog";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	
}
