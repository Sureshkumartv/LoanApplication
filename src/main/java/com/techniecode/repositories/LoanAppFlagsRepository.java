package com.techniecode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techniecode.entities.LoanAppFlags;

public interface LoanAppFlagsRepository extends JpaRepository<LoanAppFlags, Integer> {
	LoanAppFlags findByRecordId(Long recordId);
	
	// @Query("SELECT p FROM LoanAppFlags p where createdBy p.createdBy = :createdBy order by p.recordId desc  ")
	//    public LoanAppFlags LastRecord(@Param("createdBy")int createdBy);
	 
	 List<LoanAppFlags> findTop1ByCreatedByOrderByRecordIdDesc(Long createdBy);
}
	