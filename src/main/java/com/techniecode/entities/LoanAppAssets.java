package com.techniecode.entities;

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
@Table(name = "online_loan_app_assets")
public class LoanAppAssets {

	 

	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;

	@Column(name = "account_owner")
	private String accountOwner;

	@Column(name = "account_checking")
	private String accountChecking;
	
	@Column(name = "savings")
	private String savings;
	
	@Column(name = "other_accounts")
	private String otherAccounts;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "account_balance")
	private Double accountBalance;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "total_assets")
	private Double totalAssets;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "down_payment")
	private Double downPayment;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "portion_downpayment")
	private Double portionDownpayment;

	@Column(name = "other_properties")
	private String otherProperties;
	
	@Column(name = "co_account_owner")
	private String coAccountOwner;

	@Column(name = "co_account_checking")
	private String coAccountChecking;
	
	@Column(name = "co_savings")
	private String coSavings;
	
	@Column(name = "co_other_accounts")
	private String coOtherAccounts;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "co_account_balance")
	private Double coAccountBalance;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "co_total_assets")
	private Double coTotalAssets;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "co_down_payment")
	private Double coDownPayment;
	
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "co_portion_downpayment")
	private Double coPortionDownpayment;

	@Column(name = "co_other_properties")
	private String coOtherProperties;

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

 
	
	 

	public String getCoAccountOwner() {
		return coAccountOwner;
	}

	public void setCoAccountOwner(String coAccountOwner) {
		this.coAccountOwner = coAccountOwner;
	}

	public String getCoAccountChecking() {
		return coAccountChecking;
	}

	public void setCoAccountChecking(String coAccountChecking) {
		this.coAccountChecking = coAccountChecking;
	}

	public String getCoSavings() {
		return coSavings;
	}

	public void setCoSavings(String coSavings) {
		this.coSavings = coSavings;
	}

	public String getCoOtherAccounts() {
		return coOtherAccounts;
	}

	public void setCoOtherAccounts(String coOtherAccounts) {
		this.coOtherAccounts = coOtherAccounts;
	}

	public Double getCoAccountBalance() {
		return coAccountBalance;
	}

	public void setCoAccountBalance(Double coAccountBalance) {
		this.coAccountBalance = coAccountBalance;
	}

	public Double getCoTotalAssets() {
		return coTotalAssets;
	}

	public void setCoTotalAssets(Double coTotalAssets) {
		this.coTotalAssets = coTotalAssets;
	}

	public Double getCoDownPayment() {
		return coDownPayment;
	}

	public void setCoDownPayment(Double coDownPayment) {
		this.coDownPayment = coDownPayment;
	}

	public Double getCoPortionDownpayment() {
		return coPortionDownpayment;
	}

	public void setCoPortionDownpayment(Double coPortionDownpayment) {
		this.coPortionDownpayment = coPortionDownpayment;
	}

	public String getCoOtherProperties() {
		return coOtherProperties;
	}

	public void setCoOtherProperties(String coOtherProperties) {
		this.coOtherProperties = coOtherProperties;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountChecking() {
		return accountChecking;
	}

	public void setAccountChecking(String accountChecking) {
		this.accountChecking = accountChecking;
	}

	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public String getOtherAccounts() {
		return otherAccounts;
	}

	public void setOtherAccounts(String otherAccounts) {
		this.otherAccounts = otherAccounts;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(Double downPayment) {
		this.downPayment = downPayment;
	}

	public Double getPortionDownpayment() {
		return portionDownpayment;
	}

	public void setPortionDownpayment(Double portionDownpayment) {
		this.portionDownpayment = portionDownpayment;
	}

	public String getOtherProperties() {
		return otherProperties;
	}

	public void setOtherProperties(String otherProperties) {
		this.otherProperties = otherProperties;
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