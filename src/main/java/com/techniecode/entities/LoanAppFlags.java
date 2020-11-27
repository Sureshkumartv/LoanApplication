package com.techniecode.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "online_loan_app_flags")
public class LoanAppFlags {

	@Id
	@Column(name = "record_id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;

	@OneToOne(mappedBy = "app_flags")
 	private LoanAppStart app_start;

	@Column(name = "application_position")
	private String applicationPosition;

	@Column(name = "prev_application_position")
	private String prevApplicationPosition;

	@Column(name = "start_submit")
	private Timestamp startSubmit;

	@Column(name = "consents_submit")
	private Timestamp consentsSubmit;

	@Column(name = "purpose_submit")
	private Timestamp purposeSubmit;

	@Column(name = "personal_submit")
	private Timestamp personalSubmit;

	@Column(name = "income_submit")
	private Timestamp incomeSubmit;

	@Column(name = "declaration_submit")
	private Timestamp declarationSubmit;

	@Column(name = "assets_submit")
	private Timestamp assetsSubmit;

	@Column(name = "preview_submit")
	private Timestamp previewSubmit;

	@Column(name = "confirmation_submit")
	private Timestamp confirmationSubmit;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getApplicationPosition() {
		return applicationPosition;
	}

	public void setApplicationPosition(String applicationPosition) {
		this.applicationPosition = applicationPosition;
	}

	public String getPrevApplicationPosition() {
		return prevApplicationPosition;
	}

	public void setPrevApplicationPosition(String prevApplicationPosition) {
		this.prevApplicationPosition = prevApplicationPosition;
	}

	public Timestamp getStartSubmit() {
		return startSubmit;
	}

	public void setStartSubmit(Timestamp startSubmit) {
		this.startSubmit = startSubmit;
	}

	public Timestamp getConsentsSubmit() {
		return consentsSubmit;
	}

	public void setConsentsSubmit(Timestamp consentsSubmit) {
		this.consentsSubmit = consentsSubmit;
	}

	public Timestamp getPurposeSubmit() {
		return purposeSubmit;
	}

	public void setPurposeSubmit(Timestamp purposeSubmit) {
		this.purposeSubmit = purposeSubmit;
	}

	public Timestamp getPersonalSubmit() {
		return personalSubmit;
	}

	public void setPersonalSubmit(Timestamp personalSubmit) {
		this.personalSubmit = personalSubmit;
	}

	

	public Timestamp getIncomeSubmit() {
		return incomeSubmit;
	}

	public void setIncomeSubmit(Timestamp incomeSubmit) {
		this.incomeSubmit = incomeSubmit;
	}

	public Timestamp getDeclarationSubmit() {
		return declarationSubmit;
	}

	public void setDeclarationSubmit(Timestamp declarationSubmit) {
		this.declarationSubmit = declarationSubmit;
	}

	public Timestamp getAssetsSubmit() {
		return assetsSubmit;
	}

	public void setAssetsSubmit(Timestamp assetsSubmit) {
		this.assetsSubmit = assetsSubmit;
	}

	public Timestamp getPreviewSubmit() {
		return previewSubmit;
	}

	public void setPreviewSubmit(Timestamp previewSubmit) {
		this.previewSubmit = previewSubmit;
	}

	public Timestamp getConfirmationSubmit() {
		return confirmationSubmit;
	}

	public void setConfirmationSubmit(Timestamp confirmationSubmit) {
		this.confirmationSubmit = confirmationSubmit;
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

	public LoanAppStart getApp_start() {
		return app_start;
	}

	public void setApp_start(LoanAppStart app_start) {
		this.app_start = app_start;
	}

 

}
