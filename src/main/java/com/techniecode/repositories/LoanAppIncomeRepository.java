package com.techniecode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppIncome;

public interface LoanAppIncomeRepository extends JpaRepository<LoanAppIncome, Long> {

	List<LoanAppIncome> findByRecordId(Long recordId);
	 

}
