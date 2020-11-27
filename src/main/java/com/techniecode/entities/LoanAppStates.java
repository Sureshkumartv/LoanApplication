package com.techniecode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "online_loan_app_states")
public class LoanAppStates {
	@Id
	@Column(name = "property_code", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String propertyCode;

	
 
	@Column(name = "property_state")
	private String propertyState;



	public String getPropertyCode() {
		return propertyCode;
	}



	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}



	public String getPropertyState() {
		return propertyState;
	}



	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	// getters and setters are not shown for brevity
	

}