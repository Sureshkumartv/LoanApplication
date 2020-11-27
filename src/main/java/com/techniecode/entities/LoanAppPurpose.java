package com.techniecode.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "online_loan_app_purpose")
public class LoanAppPurpose {
 
	@Column(name = "id",updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(name = "record_id")
	private Long recordId;

	
	@Column(name = "mortgage_purpose")
	private Integer mortgagePurpose;

	@Column(name = "property_type")
	private Integer propertyType;

	@Column(name = "no_of_units_refinance")
	private Integer noOfUnitsRefinance;

	@Column(name = "no_of_mortgages")
	private Integer noOfMortgages;

	@Column(name = "bank_name")
	private String bankName;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "balance_mortgage")
	private Double balanceMortgage;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "monthly_payment")
	private Double monthlyPayment;

	@Column(name = "second_bank_name")
	private String secondBankName;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "second_balance_mortgage")
	private Double seoncdBalanceMortgage;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "second_monthly_payment")
	private Double secondMonthlyPayment;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "request_loanamount")
	private Double requestLoanamount;

	@Column(name = "loan_reason")
	private String loanReason;

	@Column(name = "buying_process")
	private Long buyingProcess;

	@Column(name = "property_city")
	private String propertyCity;
	
	@Column(name = "property_state")
	private String propertyState;
	
	@Column(name = "property_zip")
	private String propertyZip;

	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "property_purchaseprice")
	private Double propertyPurchaseprice;
	

	@Column(name = "contract_expiration_date")
	private Date contractExpirationDate;
	
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "down_payment")
	private Double downPayment;
	
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "gift_amount")
	private Double giftAmount;
	

	@Column(name = "purchase_property_type")
	private Integer purchasePropertyType;
	
	@Column(name = "no_of_units_purchase")
	private Integer noOfUnitsPurchase;
	
	@Column(name = "property_owned")
	private String propertyOwned;
	
	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private Long createdBy;

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

	public Integer getMortgagePurpose() {
		return mortgagePurpose;
	}

	public void setMortgagePurpose(Integer mortgagePurpose) {
		this.mortgagePurpose = mortgagePurpose;
	}

	public Integer getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getNoOfUnitsRefinance() {
		return noOfUnitsRefinance;
	}

	public void setNoOfUnitsRefinance(Integer noOfUnitsRefinance) {
		this.noOfUnitsRefinance = noOfUnitsRefinance;
	}

	public Integer getNoOfMortgages() {
		return noOfMortgages;
	}

	public void setNoOfMortgages(Integer noOfMortgages) {
		this.noOfMortgages = noOfMortgages;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getBalanceMortgage() {
		return balanceMortgage;
	}

	public void setBalanceMortgage(Double balanceMortgage) {
		this.balanceMortgage = balanceMortgage;
	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public String getSecondBankName() {
		return secondBankName;
	}

	public void setSecondBankName(String secondBankName) {
		this.secondBankName = secondBankName;
	}

	public Double getSeoncdBalanceMortgage() {
		return seoncdBalanceMortgage;
	}

	public void setSeoncdBalanceMortgage(Double seoncdBalanceMortgage) {
		this.seoncdBalanceMortgage = seoncdBalanceMortgage;
	}

	public Double getSecondMonthlyPayment() {
		return secondMonthlyPayment;
	}

	public void setSecondMonthlyPayment(Double secondMonthlyPayment) {
		this.secondMonthlyPayment = secondMonthlyPayment;
	}

	public Double getRequestLoanamount() {
		return requestLoanamount;
	}

	public void setRequestLoanamount(Double requestLoanamount) {
		this.requestLoanamount = requestLoanamount;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public Long getBuyingProcess() {
		return buyingProcess;
	}

	public void setBuyingProcess(Long buyingProcess) {
		this.buyingProcess = buyingProcess;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	public String getPropertyZip() {
		return propertyZip;
	}

	public void setPropertyZip(String propertyZip) {
		this.propertyZip = propertyZip;
	}

	public Double getPropertyPurchaseprice() {
		return propertyPurchaseprice;
	}

	public void setPropertyPurchaseprice(Double propertyPurchaseprice) {
		this.propertyPurchaseprice = propertyPurchaseprice;
	}

	public Date getContractExpirationDate() {
		return contractExpirationDate;
	}

	public void setContractExpirationDate(Date contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}

	public Integer getPurchasePropertyType() {
		return purchasePropertyType;
	}

	public void setPurchasePropertyType(Integer purchasePropertyType) {
		this.purchasePropertyType = purchasePropertyType;
	}

	public Integer getNoOfUnitsPurchase() {
		return noOfUnitsPurchase;
	}

	public void setNoOfUnitsPurchase(Integer noOfUnitsPurchase) {
		this.noOfUnitsPurchase = noOfUnitsPurchase;
	}

	public String getPropertyOwned() {
		return propertyOwned;
	}

	public void setPropertyOwned(String propertyOwned) {
		this.propertyOwned = propertyOwned;
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

	public Double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(Double downPayment) {
		this.downPayment = downPayment;
	}

	public Double getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(Double giftAmount) {
		this.giftAmount = giftAmount;
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
	
	
	
	
}