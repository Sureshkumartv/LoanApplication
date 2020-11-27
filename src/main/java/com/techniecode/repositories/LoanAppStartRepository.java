package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppStart;



public interface LoanAppStartRepository extends JpaRepository<LoanAppStart, Integer>{
	
	LoanAppStart findByRecordId(Long recordId);
	 
}
