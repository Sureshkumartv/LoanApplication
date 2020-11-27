package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppPension;

public interface LoanAppPensionRepository extends JpaRepository<LoanAppPension, Long> {
	
	LoanAppPension findByRecordIdAndIncomeId(Long recordId,Long incomeId);

}
