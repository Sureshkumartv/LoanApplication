package com.techniecode.entities;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

class LoanAppEmployementId implements Serializable {
	Long recordId;
	Long incomeId;
}

@Entity
@IdClass(LoanAppEmployementId.class)
@Table(name = "online_loan_app_employement")
public class LoanAppEmployement {
 

	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Id
	@Column(name = "record_id")
	private Long recordId;

	@Id
	@Column(name = "income_id")
	private Long incomeId;

	@Column(name = "borrower_name")
	private String borrowerName;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "current_employer")
	private String currentEmployer;

	@Column(name = "employer_corporate_phone_number")
	private String employerCorporatePhoneNumber;

	@Column(name = "employer_address")
	private String employerAddress;

	@Column(name = "employer_city")
	private String employerCity;

	@Column(name = "employer_state")
	private String employerState;

	@Column(name = "employer_zip")
	private String employerZip;

	@Column(name = "start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "total_expr")
	private String totalExpr;

	@Column(name = "pay_type")
	private String payType;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "anual_base_salary")
	private Double anualBaseSalary;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "annual_overtime")
	private Double payannualOvertimeType;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "annual_Bonus")
	private Double annualBonus;

	@JsonSerialize(using = com.techniecode.json.MyDoubleSerialize.class)
	@JsonDeserialize(using = com.techniecode.json.MyDoubleDesirializer.class)
	@Column(name = "annual_Commission")
	private Double annualCommission;

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

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getCurrentEmployer() {
		return currentEmployer;
	}

	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	public String getEmployerCorporatePhoneNumber() {
		return employerCorporatePhoneNumber;
	}

	public void setEmployerCorporatePhoneNumber(String employerCorporatePhoneNumber) {
		this.employerCorporatePhoneNumber = employerCorporatePhoneNumber;
	}

	public String getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}

	public String getEmployerCity() {
		return employerCity;
	}

	public void setEmployerCity(String employerCity) {
		this.employerCity = employerCity;
	}

	public String getEmployerState() {
		return employerState;
	}

	public void setEmployerState(String employerState) {
		this.employerState = employerState;
	}

	public String getEmployerZip() {
		return employerZip;
	}

	public void setEmployerZip(String employerZip) {
		this.employerZip = employerZip;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getTotalExpr() {
		return totalExpr;
	}

	public void setTotalExpr(String totalExpr) {
		this.totalExpr = totalExpr;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Double getAnualBaseSalary() {
		return anualBaseSalary;
	}

	public void setAnualBaseSalary(Double anualBaseSalary) {
		this.anualBaseSalary = anualBaseSalary;
	}

	public Double getPayannualOvertimeType() {
		return payannualOvertimeType;
	}

	public void setPayannualOvertimeType(Double payannualOvertimeType) {
		this.payannualOvertimeType = payannualOvertimeType;
	}

	public Double getAnnualBonus() {
		return annualBonus;
	}

	public void setAnnualBonus(Double annualBonus) {
		this.annualBonus = annualBonus;
	}

	public Double getAnnualCommission() {
		return annualCommission;
	}

	public void setAnnualCommission(Double annualCommission) {
		this.annualCommission = annualCommission;
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
