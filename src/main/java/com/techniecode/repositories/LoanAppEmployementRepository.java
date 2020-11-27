package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppEmployement;

public interface LoanAppEmployementRepository extends JpaRepository<LoanAppEmployement, Long> {
	
	LoanAppEmployement findByRecordIdAndIncomeId(Long recordId,Long incomeId);

}
