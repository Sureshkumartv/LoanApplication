package com.techniecode.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "online_loan_app_consents")
public class LoanAppConsents {
 
	
	@Column(name = "id" , updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(name = "record_id")
	private Long recordId;

	@Column(name = "borrower_credit_check")
	private Long borrowerCreditCheck;

	@Column(name = "co_borroer_credit_check")
	private Long coBorrowerCreditCheck;
	
	@Column(name = "borrower_message_check")
	private Long borrowerMessageCheck;
	
	@Column(name = "borrower_advertising_check")
	private Long borrowerAdvertisingCheck;
	
	@Column(name = "borrower_offers_check")
	private Long borrowerOffersCheck;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;

 
	
	
	

	public Long getBorrowerCreditCheck() {
		return borrowerCreditCheck;
	}

	public void setBorrowerCreditCheck(Long borrowerCreditCheck) {
		this.borrowerCreditCheck = borrowerCreditCheck;
	}

	public Long getCoBorrowerCreditCheck() {
		return coBorrowerCreditCheck;
	}

	public void setCoBorrowerCreditCheck(Long coBorrowerCreditCheck) {
		this.coBorrowerCreditCheck = coBorrowerCreditCheck;
	}

	public Long getBorrowerMessageCheck() {
		return borrowerMessageCheck;
	}

	public void setBorrowerMessageCheck(Long borrowerMessageCheck) {
		this.borrowerMessageCheck = borrowerMessageCheck;
	}

	public Long getBorrowerAdvertisingCheck() {
		return borrowerAdvertisingCheck;
	}

	public void setBorrowerAdvertisingCheck(Long borrowerAdvertisingCheck) {
		this.borrowerAdvertisingCheck = borrowerAdvertisingCheck;
	}

	public Long getBorrowerOffersCheck() {
		return borrowerOffersCheck;
	}

	public void setBorrowerOffersCheck(Long borrowerOffersCheck) {
		this.borrowerOffersCheck = borrowerOffersCheck;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	
	// getters and setters are not shown for brevity

}