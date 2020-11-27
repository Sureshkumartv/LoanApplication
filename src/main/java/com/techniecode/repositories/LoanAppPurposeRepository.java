package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppPurpose;

public interface LoanAppPurposeRepository extends JpaRepository<LoanAppPurpose, Integer> {
	
	LoanAppPurpose findByRecordId(Long recordId);

}
