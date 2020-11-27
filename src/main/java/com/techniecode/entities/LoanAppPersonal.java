package com.techniecode.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "online_loan_app_personal")
public class LoanAppPersonal {

	@Column(name = "id",updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;

	@Column(name = "borrower_name")
	private String borrowerName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "date_of_birth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	//@NotNull
	private Date dateOfBirth;

	@Column(name = "ssn")
	private Integer ssn;

	@Column(name = "home_phone")
	private String homePhone;

	@Column(name = "cell_phone")
	private String cellPhone;

	@Column(name = "work_phone")
	private String workPhone;

	@Column(name = "current_street")
	private String currentStreet;

	@Column(name = "current_city")
	private String currentCity;

	@Column(name = "current_state")
	private String currentState;

	@Column(name = "current_zip")
	private String currentZip;

	@Column(name = "no_of_years")
	private Integer noOfYears;

	@Column(name = "no_of_months")
	private Integer noOfMonths;

	@Column(name = "house_type")
	private String houseType;

	@Column(name = "current_mailing_address")
	private String currentMailingAddress;

	@Column(name = "mailing_street")
	private String mailingStreet;

	@Column(name = "mailing_city")
	private String mailingCity;

	@Column(name = "mailing_state")
	private String mailingState;

	@Column(name = "mailing_zip")
	private String mailingZip;

	/* Co - Borrower Details */
	@Column(name = "co_borrower_name")
	private String coBorrowerName;

	public String getCoEmailId() {
		return coEmailId;
	}

	public void setCoEmailId(String coEmailId) {
		this.coEmailId = coEmailId;
	}

	public Date getCoDateOfBirth() {
		return coDateOfBirth;
	}

	public void setCoDateOfBirth(Date coDateOfBirth) {
		this.coDateOfBirth = coDateOfBirth;
	}

	public Integer getCoSsn() {
		return coSsn;
	}

	public void setCoSsn(Integer coSsn) {
		this.coSsn = coSsn;
	}

	public String getCoHomePhone() {
		return coHomePhone;
	}

	public void setCoHomePhone(String coHomePhone) {
		this.coHomePhone = coHomePhone;
	}

	public String getCoCellPhone() {
		return coCellPhone;
	}

	public void setCoCellPhone(String coCellPhone) {
		this.coCellPhone = coCellPhone;
	}

	public String getCoWorkPhone() {
		return coWorkPhone;
	}

	public void setCoWorkPhone(String coWorkPhone) {
		this.coWorkPhone = coWorkPhone;
	}

	public String getCoCurrentStreet() {
		return coCurrentStreet;
	}

	public void setCoCurrentStreet(String coCurrentStreet) {
		this.coCurrentStreet = coCurrentStreet;
	}

	public String getCoCurrentCity() {
		return coCurrentCity;
	}

	public void setCoCurrentCity(String coCurrentCity) {
		this.coCurrentCity = coCurrentCity;
	}

	public String getCoCurrentState() {
		return coCurrentState;
	}

	public void setCoCurrentState(String coCurrentState) {
		this.coCurrentState = coCurrentState;
	}

	public String getCoCurrentZip() {
		return coCurrentZip;
	}

	public void setCoCurrentZip(String coCurrentZip) {
		this.coCurrentZip = coCurrentZip;
	}

	public Integer getCoNoOfYears() {
		return coNoOfYears;
	}

	public void setCoNoOfYears(Integer coNoOfYears) {
		this.coNoOfYears = coNoOfYears;
	}

	public Integer getCoNoOfMonths() {
		return coNoOfMonths;
	}

	public void setCoNoOfMonths(Integer coNoOfMonths) {
		this.coNoOfMonths = coNoOfMonths;
	}

	public String getCoHouseType() {
		return coHouseType;
	}

	public void setCoHouseType(String coHouseType) {
		this.coHouseType = coHouseType;
	}

	public String getCoCurrentMailingAddress() {
		return coCurrentMailingAddress;
	}

	public void setCoCurrentMailingAddress(String coCurrentMailingAddress) {
		this.coCurrentMailingAddress = coCurrentMailingAddress;
	}

	public String getCoMailingStreet() {
		return coMailingStreet;
	}

	public void setCoMailingStreet(String coMailingStreet) {
		this.coMailingStreet = coMailingStreet;
	}

	public String getCoMailingCity() {
		return coMailingCity;
	}

	public void setCoMailingCity(String coMailingCity) {
		this.coMailingCity = coMailingCity;
	}

	public String getCoMailingState() {
		return coMailingState;
	}

	public void setCoMailingState(String coMailingState) {
		this.coMailingState = coMailingState;
	}

	public String getCoMailingZip() {
		return coMailingZip;
	}

	public void setCoMailingZip(String coMailingZip) {
		this.coMailingZip = coMailingZip;
	}

	@Column(name = "co_email_id")
	private String coEmailId;

	@Column(name = "co_date_of_birth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date coDateOfBirth;

	@Column(name = "co_ssn")
	private Integer coSsn;

	@Column(name = "co_home_phone")
	private String coHomePhone;

	@Column(name = "co_cell_phone")
	private String coCellPhone;

	@Column(name = "co_work_phone")
	private String coWorkPhone;

	@Column(name = "co_current_street")
	private String coCurrentStreet;

	@Column(name = "co_current_city")
	private String coCurrentCity;

	@Column(name = "co_current_state")
	private String coCurrentState;

	@Column(name = "co_current_zip")
	private String coCurrentZip;

	@Column(name = "co_no_of_years")
	private Integer coNoOfYears;

	@Column(name = "co_no_of_months")
	private Integer coNoOfMonths;

	@Column(name = "co_house_type")
	private String coHouseType;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "house_rent")
	private Double houseRent;
	
	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "co_house_rent")
	private Double coHouseRent;
	

	public String getCoBorrowerName() {
		return coBorrowerName;
	}

	public void setCoBorrowerName(String coBorrowerName) {
		this.coBorrowerName = coBorrowerName;
	}

	public Double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(Double houseRent) {
		this.houseRent = houseRent;
	}

	public Double getCoHouseRent() {
		return coHouseRent;
	}

	public void setCoHouseRent(Double coHouseRent) {
		this.coHouseRent = coHouseRent;
	}

	@Column(name = "co_current_mailing_address")
	private String coCurrentMailingAddress;

	@Column(name = "co_mailing_street")
	private String coMailingStreet;

	@Column(name = "co_mailing_city")
	private String coMailingCity;

	@Column(name = "co_mailing_state")
	private String coMailingState;

	@Column(name = "co_mailing_zip")
	private String coMailingZip;

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

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getCurrentStreet() {
		return currentStreet;
	}

	public void setCurrentStreet(String currentStreet) {
		this.currentStreet = currentStreet;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentZip() {
		return currentZip;
	}

	public void setCurrentZip(String currentZip) {
		this.currentZip = currentZip;
	}

	public Integer getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(Integer noOfYears) {
		this.noOfYears = noOfYears;
	}

	public Integer getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(Integer noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getCurrentMailingAddress() {
		return currentMailingAddress;
	}

	public void setCurrentMailingAddress(String currentMailingAddress) {
		this.currentMailingAddress = currentMailingAddress;
	}

	public String getMailingStreet() {
		return mailingStreet;
	}

	public void setMailingStreet(String mailingStreet) {
		this.mailingStreet = mailingStreet;
	}

	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public String getMailingZip() {
		return mailingZip;
	}

	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
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