package com.techniecode.beans;

import java.util.Date;


//@Entity
//@Table(name = "lead_app_leads")
public class LeadAppLeads {

	
	private Long leadId;
	private String guid;
	private String loanNumber;
	private String _364;
	private String loanOfficerId;
	private Date leadAddedDate;
	private Date leadModifiedDate;
	private Date leadAssignedDate;
	private Integer leadStatus;
	private String loanfolder;
	private String nearestLocation;
	private Integer _createdBy;
	private Integer _updatedBy;
	private Date createdAt;
	private Date updatedAt;

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String get_364() {
		return _364;
	}

	public void set_364(String _364) {
		this._364 = _364;
	}

	public String getLoanOfficerId() {
		return loanOfficerId;
	}

	public void setLoanOfficerId(String loanOfficerId) {
		this.loanOfficerId = loanOfficerId;
	}

	public Date getLeadAddedDate() {
		return leadAddedDate;
	}

	public void setLeadAddedDate(Date leadAddedDate) {
		this.leadAddedDate = leadAddedDate;
	}

	public Date getLeadModifiedDate() {
		return leadModifiedDate;
	}

	public void setLeadModifiedDate(Date leadModifiedDate) {
		this.leadModifiedDate = leadModifiedDate;
	}

	public Date getLeadAssignedDate() {
		return leadAssignedDate;
	}

	public void setLeadAssignedDate(Date leadAssignedDate) {
		this.leadAssignedDate = leadAssignedDate;
	}

	public Integer getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(Integer leadStatus) {
		this.leadStatus = leadStatus;
	}

	public String getLoanfolder() {
		return loanfolder;
	}

	public void setLoanfolder(String loanfolder) {
		this.loanfolder = loanfolder;
	}

	public String getNearestLocation() {
		return nearestLocation;
	}

	public void setNearestLocation(String nearestLocation) {
		this.nearestLocation = nearestLocation;
	}

	public Integer get_createdBy() {
		return _createdBy;
	}

	public void set_createdBy(Integer _createdBy) {
		this._createdBy = _createdBy;
	}

	public Integer get_updatedBy() {
		return _updatedBy;
	}

	public void set_updatedBy(Integer _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
