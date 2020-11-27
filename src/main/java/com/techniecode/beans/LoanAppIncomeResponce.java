package com.techniecode.beans;

public class LoanAppIncomeResponce {
 	private String leadId;
  
 	private com.techniecode.entities.LoanAppIncome[]  incomeDetails;
     
 	private Object editIncomeDetails;
    
 	private String incomeType;

	public String getIncomeType() {
		return incomeType;
	}



	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}



	public Object getEditIncomeDetails() {
		return editIncomeDetails;
	}



	public void setEditIncomeDetails(Object editIncomeDetails) {
		this.editIncomeDetails = editIncomeDetails;
	}



	public com.techniecode.entities.LoanAppIncome[]  getIncomeDetails() {
		return incomeDetails;
	}



	public void setIncomeDetails(com.techniecode.entities.LoanAppIncome[] incomeDetails) {
		this.incomeDetails = incomeDetails;
	}



	public String getLeadId() {
		return leadId;
	}



	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

 
}
