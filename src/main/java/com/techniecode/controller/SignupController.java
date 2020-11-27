package com.techniecode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techniecode.entities.LoanAppLogin;

@RestController ("/public")
public class SignupController {
	
	//@PostMapping("/signup")
	//@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@PostMapping("/signup")
	public String signup( LoanAppLogin	 login) {
		System.out.println("Signup -------");
		 return "mainpages/loan/signup";
		}
	
	
	
}
