package com.techniecode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techniecode.entities.LoanAppLogin;
import com.techniecode.repositories.LoginRepository;

@Service
public class SignupService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	LoginRepository loginRepository;

	public String signup(LoanAppLogin login) {
		login.setLoginPassword(bCryptPasswordEncoder.encode(login.getPassword()));
		loginRepository.save(login);
		return "success";
	}

}
