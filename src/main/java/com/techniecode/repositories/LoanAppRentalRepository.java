package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppRental;

public interface LoanAppRentalRepository extends JpaRepository<LoanAppRental, Long> {
	
	LoanAppRental  findByRecordIdAndIncomeId(Long recordId,Long incomeId);

}
