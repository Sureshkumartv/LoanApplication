package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppPersonal;

public interface LoanAppPersonalRepository extends JpaRepository<LoanAppPersonal, Long> {

	LoanAppPersonal findByRecordId(Long recordId);

}
