package com.techniecode.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "online_loan_app_declarations")
public class LoanAppDeclarations {

	 
	
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(name = "record_id")
	private Long recordId;

	@Column(name = "outstanding_judgments")
	private String outstandingJudgments;

	@Column(name = "default_federaldebt")
	private String defaultFederaldebt;
	
	@Column(name = "personal_financial_liability")
	private String personalFinancialLiability;
	
	@Column(name = "property_foreclosed")
	private String propertyForeclosed;
	
	@Column(name = "is_bankruptcy")
	private String isBankruptcy;
	
	@Column(name = "bankruptcy_type")
	private String bankruptcyType;
	
	@Column(name = "co_outstanding_judgments")
	private String coOutstandingJudgments;

	@Column(name = "co_default_federaldebt")
	private String coDefaultFederaldebt;
	
	@Column(name = "co_personal_financial_liability")
	private String coPersonalFinancialLiability;
	
	@Column(name = "co_property_foreclosed")
	private String coPropertyForeclosed;
	
	@Column(name = "co_is_bankruptcy")
	private String coIsBankruptcy;
	
	@Column(name = "co_bankruptcy_type")
	private String coBankruptcyType;


	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;




	public String getOutstandingJudgments() {
		return outstandingJudgments;
	}

	public void setOutstandingJudgments(String outstandingJudgments) {
		this.outstandingJudgments = outstandingJudgments;
	}

	public String getDefaultFederaldebt() {
		return defaultFederaldebt;
	}

	public void setDefaultFederaldebt(String defaultFederaldebt) {
		this.defaultFederaldebt = defaultFederaldebt;
	}

	public String getPersonalFinancialLiability() {
		return personalFinancialLiability;
	}

	public void setPersonalFinancialLiability(String personalFinancialLiability) {
		this.personalFinancialLiability = personalFinancialLiability;
	}

	public String getPropertyForeclosed() {
		return propertyForeclosed;
	}

	public void setPropertyForeclosed(String propertyForeclosed) {
		this.propertyForeclosed = propertyForeclosed;
	}

	public String getIsBankruptcy() {
		return isBankruptcy;
	}

	public void setIsBankruptcy(String isBankruptcy) {
		this.isBankruptcy = isBankruptcy;
	}

	public String getBankruptcyType() {
		return bankruptcyType;
	}

	public void setBankruptcyType(String bankruptcyType) {
		this.bankruptcyType = bankruptcyType;
	}

	public String getCoOutstandingJudgments() {
		return coOutstandingJudgments;
	}

	public void setCoOutstandingJudgments(String coOutstandingJudgments) {
		this.coOutstandingJudgments = coOutstandingJudgments;
	}

	public String getCoDefaultFederaldebt() {
		return coDefaultFederaldebt;
	}

	public void setCoDefaultFederaldebt(String coDefaultFederaldebt) {
		this.coDefaultFederaldebt = coDefaultFederaldebt;
	}

	public String getCoPersonalFinancialLiability() {
		return coPersonalFinancialLiability;
	}

	public void setCoPersonalFinancialLiability(String coPersonalFinancialLiability) {
		this.coPersonalFinancialLiability = coPersonalFinancialLiability;
	}

	public String getCoPropertyForeclosed() {
		return coPropertyForeclosed;
	}

	public void setCoPropertyForeclosed(String coPropertyForeclosed) {
		this.coPropertyForeclosed = coPropertyForeclosed;
	}

	public String getCoIsBankruptcy() {
		return coIsBankruptcy;
	}

	public void setCoIsBankruptcy(String coIsBankruptcy) {
		this.coIsBankruptcy = coIsBankruptcy;
	}

	public String getCoBankruptcyType() {
		return coBankruptcyType;
	}

	public void setCoBankruptcyType(String coBankruptcyType) {
		this.coBankruptcyType = coBankruptcyType;
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