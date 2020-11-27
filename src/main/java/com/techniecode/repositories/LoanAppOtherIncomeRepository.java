package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppOtherIncome;



public interface LoanAppOtherIncomeRepository extends JpaRepository<LoanAppOtherIncome, Long>{
	
	LoanAppOtherIncome	 findByRecordIdAndIncomeId(Long recordId,Long incomeId);
	
}
