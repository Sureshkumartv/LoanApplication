package com.techniecode.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "online_loan_app_start")
public class LoanAppStart {

	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "record_id", referencedColumnName = "record_id")
	private LoanAppFlags app_flags;

 
	@Column(name = "borrower_first_name")
	private String borrowerFirstName;

	@Column(name = "borrower_middle_name")
	private String borrowerMiddleName;

	@Column(name = "borrower_last_name")
	private String borrowerLastName;

	@Column(name = "borrower_suffix")
	private String borrowerSuffix;

	@Column(name = "borrower_emailid")
	private String borrowerEmailid;

	@Column(name = "borrower_cellphone")
	private String borrowerCellphone;

	@Column(name = "co_borrower_status")
	private String coBorrowerStatus;

	@Column(name = "co_borrower_first_name")
	private String coBorrowerFirstName;

	@Column(name = "co_borrower_middle_name")
	private String coBorrowerMiddleName;

	@Column(name = "co_borrower_last_name")
	private String coBorrowerLastName;

	@Column(name = "co_borrower_suffix")
	private String coBorrowerSuffix;

	@Column(name = "co_borrower_emailid")
	private String coBorrowerEmailid;

	@Column(name = "co_borrower_cellphone")
	private String coBorrowerCellphone;

	@Column(name = "active_military_status")
	private String activeMilitaryStatus;

	@Column(name = "borrower_citizenship")
	private Integer borrowerCitizenship;

	@Column(name = "borrower_Marital_status")
	private Integer borrowerMaritalStatus;

	@Column(name = "applying_for")
	private Integer applyingFor;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;

	public String getBorrowerFullName() {
		return borrowerFirstName == null ? ""
				: borrowerFirstName + (borrowerLastName == null ? "" : " ," + borrowerLastName);
	}

	public String getCoBorrowerFullName() {
		return coBorrowerFirstName == null ? ""
				: coBorrowerFirstName + (coBorrowerLastName == null ? "" : " ," + coBorrowerLastName);
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

	public String getBorrowerFirstName() {
		return borrowerFirstName;
	}

	public void setBorrowerFirstName(String borrowerFirstName) {
		this.borrowerFirstName = borrowerFirstName;
	}

	public String getBorrowerMiddleName() {
		return borrowerMiddleName;
	}

	public void setBorrowerMiddleName(String borrowerMiddleName) {
		this.borrowerMiddleName = borrowerMiddleName;
	}

	public String getBorrowerLastName() {
		return borrowerLastName;
	}

	public void setBorrowerLastName(String borrowerLastName) {
		this.borrowerLastName = borrowerLastName;
	}

	public String getBorrowerSuffix() {
		return borrowerSuffix;
	}

	public void setBorrowerSuffix(String borrowerSuffix) {
		this.borrowerSuffix = borrowerSuffix;
	}

	public String getBorrowerEmailid() {
		return borrowerEmailid;
	}

	public void setBorrowerEmailid(String borrowerEmailid) {
		this.borrowerEmailid = borrowerEmailid;
	}

	public String getBorrowerCellphone() {
		return borrowerCellphone;
	}

	public void setBorrowerCellphone(String borrowerCellphone) {
		this.borrowerCellphone = borrowerCellphone;
	}

	public String getCoBorrowerStatus() {
		return coBorrowerStatus;
	}

	public void setCoBorrowerStatus(String coBorrowerStatus) {
		this.coBorrowerStatus = coBorrowerStatus;
	}

	public String getCoBorrowerFirstName() {
		return coBorrowerFirstName;
	}

	public void setCoBorrowerFirstName(String coBorrowerFirstName) {
		this.coBorrowerFirstName = coBorrowerFirstName;
	}

	public String getCoBorrowerMiddleName() {
		return coBorrowerMiddleName;
	}

	public void setCoBorrowerMiddleName(String coBorrowerMiddleName) {
		this.coBorrowerMiddleName = coBorrowerMiddleName;
	}

	public String getCoBorrowerLastName() {
		return coBorrowerLastName;
	}

	public void setCoBorrowerLastName(String coBorrowerLastName) {
		this.coBorrowerLastName = coBorrowerLastName;
	}

	public String getCoBorrowerSuffix() {
		return coBorrowerSuffix;
	}

	public void setCoBorrowerSuffix(String coBorrowerSuffix) {
		this.coBorrowerSuffix = coBorrowerSuffix;
	}

	public String getCoBorrowerEmailid() {
		return coBorrowerEmailid;
	}

	public void setCoBorrowerEmailid(String coBorrowerEmailid) {
		this.coBorrowerEmailid = coBorrowerEmailid;
	}

	public String getCoBorrowerCellphone() {
		return coBorrowerCellphone;
	}

	public void setCoBorrowerCellphone(String coBorrowerCellphone) {
		this.coBorrowerCellphone = coBorrowerCellphone;
	}

	public String getActiveMilitaryStatus() {
		return activeMilitaryStatus;
	}

	public void setActiveMilitaryStatus(String activeMilitaryStatus) {
		this.activeMilitaryStatus = activeMilitaryStatus;
	}

	public Integer getBorrowerCitizenship() {
		return borrowerCitizenship;
	}

	public void setBorrowerCitizenship(Integer borrowerCitizenship) {
		this.borrowerCitizenship = borrowerCitizenship;
	}

	public Integer getBorrowerMaritalStatus() {
		return borrowerMaritalStatus;
	}

	public void setBorrowerMaritalStatus(Integer borrowerMaritalStatus) {
		this.borrowerMaritalStatus = borrowerMaritalStatus;
	}

	public Integer getApplyingFor() {
		return applyingFor;
	}

	public void setApplyingFor(Integer applyingFor) {
		this.applyingFor = applyingFor;
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

	public LoanAppFlags getApp_flags() {
		return app_flags;
	}

	public void setApp_flags(LoanAppFlags app_flags) {
		this.app_flags = app_flags;
	}

	// getters and setters are not shown for brevity

}