package com.techniecode.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "online_loan_app_income")
public class LoanAppIncome {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	
	@Column(name = "record_id")
	private Long recordId;

	@Column(name = "account_owner")
	private String accountOwner;

	@Column(name = "income_type")
	private String incomeType;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "income_amount")
	private Double incomeAmount;

	@JsonIgnore
	@Column(name = "created_date")
	private Timestamp createdDate;

	@JsonIgnore
	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@JsonIgnore
	@Column(name = "created_by")
	private Long createdBy;

	@JsonIgnore
	@Column(name = "updated_by")
	private Long updatedBy;

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

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public Double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(Double incomeAmount) {
		this.incomeAmount = incomeAmount;
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

	// getters and setters are not shown for brevity

}