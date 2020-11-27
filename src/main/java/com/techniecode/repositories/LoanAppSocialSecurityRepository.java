package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppSocialSecurity;

public interface LoanAppSocialSecurityRepository extends JpaRepository<LoanAppSocialSecurity, Long> {
	
	LoanAppSocialSecurity  findByRecordIdAndIncomeId(Long recordId,Long incomeId);

}
