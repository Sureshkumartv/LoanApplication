package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppDeclarations;



public interface LoanAppDeclarationsRepository extends JpaRepository<LoanAppDeclarations, Long>{
	LoanAppDeclarations	 findByRecordId(Long recordId);
	
}
