package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppLogin;

public interface LoginRepository extends JpaRepository<LoanAppLogin, Integer> {

	LoanAppLogin findByEmailId(String emailId);

}
