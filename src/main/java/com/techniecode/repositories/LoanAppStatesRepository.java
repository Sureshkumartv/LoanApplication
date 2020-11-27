package com.techniecode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppStates;



public interface LoanAppStatesRepository extends JpaRepository<LoanAppStates, String>{
	
	 public List<LoanAppStates> findAll();
	
}
