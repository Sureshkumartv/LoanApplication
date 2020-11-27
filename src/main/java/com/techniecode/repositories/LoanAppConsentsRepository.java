package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppConsents;
 

public interface LoanAppConsentsRepository extends JpaRepository<LoanAppConsents, Long>{
	LoanAppConsents	 findByRecordId(Long recordId);
	
}
