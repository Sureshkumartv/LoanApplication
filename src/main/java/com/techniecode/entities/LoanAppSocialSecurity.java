package com.techniecode.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


class LoanAppSocialSecurityId implements Serializable {
	Long recordId;
	Long incomeId;
}



@Entity
@IdClass(LoanAppSocialSecurityId.class)
@Table(name = "online_loan_app_socialsecurity")
public class LoanAppSocialSecurity {
	 
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;
	
	@Id
	@Column(name = "income_id")
	private Long incomeId;
	

	@Column(name = "account_owner")
	private String accountOwner;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "anual_income")
	private Double anualIncome;
	
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

	public Long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
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

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
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