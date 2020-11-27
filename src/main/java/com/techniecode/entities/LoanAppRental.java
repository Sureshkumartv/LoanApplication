package com.techniecode.entities;

import java.io.Serializable;
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

class LoanAppRentalId implements Serializable {
	Long recordId;
	Long incomeId;
}


@Entity
@IdClass(LoanAppRentalId.class)
@Table(name = "online_loan_app_rental")
public class LoanAppRental {
 
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;
	
	@Id
	@Column(name = "income_id")
	private Long incomeId;
	
	 

	@Column(name = "rental_property_owner")
	private String rentalPropertyOwner;
	
	@Column(name = "rental_property_type")
	private String rentalPropertyType;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_property_value")
	private Double rentalPropertyValue;
	
	@Column(name = "rental_property_address")
	private String rentalPropertyAddress;
	
	@Column(name = "rental_property_city")
	private String rentalPropertyCity;
	
	@Column(name = "rental_property_state")
	private String rentalPropertyState;
	
	@Column(name = "rental_property_zip")
	private String rentalPropertyZip;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_monthly_rent")
	private Double rentalMonthlyRent;
	
	@Column(name = "rental_no_of_mortgages")
	private Long rentalNoOfMortgages;
	
	@Column(name = "rental_bank_name")
	private String rentalBankName;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_balance_mortgage")
	private Double rentalBalanceMortgage;
	
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_monthly_payment")
	private Double rentalMonthlyPayment;
	
	@Column(name = "rental_second_bank_name")
	private String rentalSecondBankName;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_second_balance_mortgage")
	private Double rentalSecondBalanceMortgage;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "rental_second_monthly_payment")
	private Double rentalSecondMonthlyPayment;
	
	
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

	public String getRentalPropertyOwner() {
		return rentalPropertyOwner;
	}

	public void setRentalPropertyOwner(String rentalPropertyOwner) {
		this.rentalPropertyOwner = rentalPropertyOwner;
	}

	public String getRentalPropertyType() {
		return rentalPropertyType;
	}

	public void setRentalPropertyType(String rentalPropertyType) {
		this.rentalPropertyType = rentalPropertyType;
	}

	public Double getRentalPropertyValue() {
		return rentalPropertyValue;
	}

	public void setRentalPropertyValue(Double rentalPropertyValue) {
		this.rentalPropertyValue = rentalPropertyValue;
	}

	public String getRentalPropertyAddress() {
		return rentalPropertyAddress;
	}

	public void setRentalPropertyAddress(String rentalPropertyAddress) {
		this.rentalPropertyAddress = rentalPropertyAddress;
	}

	public String getRentalPropertyCity() {
		return rentalPropertyCity;
	}

	public void setRentalPropertyCity(String rentalPropertyCity) {
		this.rentalPropertyCity = rentalPropertyCity;
	}

	public String getRentalPropertyState() {
		return rentalPropertyState;
	}

	public void setRentalPropertyState(String rentalPropertyState) {
		this.rentalPropertyState = rentalPropertyState;
	}

	public String getRentalPropertyZip() {
		return rentalPropertyZip;
	}

	public void setRentalPropertyZip(String rentalPropertyZip) {
		this.rentalPropertyZip = rentalPropertyZip;
	}

	public Double getRentalMonthlyRent() {
		return rentalMonthlyRent;
	}

	public void setRentalMonthlyRent(Double rentalMonthlyRent) {
		this.rentalMonthlyRent = rentalMonthlyRent;
	}

	public Long getRentalNoOfMortgages() {
		return rentalNoOfMortgages;
	}

	public void setRentalNoOfMortgages(Long rentalNoOfMortgages) {
		this.rentalNoOfMortgages = rentalNoOfMortgages;
	}

	public String getRentalBankName() {
		return rentalBankName;
	}

	public void setRentalBankName(String rentalBankName) {
		this.rentalBankName = rentalBankName;
	}

	public Double getRentalBalanceMortgage() {
		return rentalBalanceMortgage;
	}

	public void setRentalBalanceMortgage(Double rentalBalanceMortgage) {
		this.rentalBalanceMortgage = rentalBalanceMortgage;
	}

	public Double getRentalMonthlyPayment() {
		return rentalMonthlyPayment;
	}

	public void setRentalMonthlyPayment(Double rentalMonthlyPayment) {
		this.rentalMonthlyPayment = rentalMonthlyPayment;
	}

	public String getRentalSecondBankName() {
		return rentalSecondBankName;
	}

	public void setRentalSecondBankName(String rentalSecondBankName) {
		this.rentalSecondBankName = rentalSecondBankName;
	}

	public Double getRentalSecondBalanceMortgage() {
		return rentalSecondBalanceMortgage;
	}

	public void setRentalSecondBalanceMortgage(Double rentalSecondBalanceMortgage) {
		this.rentalSecondBalanceMortgage = rentalSecondBalanceMortgage;
	}

	public Double getRentalSecondMonthlyPayment() {
		return rentalSecondMonthlyPayment;
	}

	public void setRentalSecondMonthlyPayment(Double rentalSecondMonthlyPayment) {
		this.rentalSecondMonthlyPayment = rentalSecondMonthlyPayment;
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