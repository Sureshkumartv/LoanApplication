package com.techniecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppAssets;

public interface LoanAppAssetsRepository extends JpaRepository<LoanAppAssets, Long> {
	LoanAppAssets findByRecordId(Long recordId);

}
