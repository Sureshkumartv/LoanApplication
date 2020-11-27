package com.techniecode.beans;

public class LoanAppRequest {

	private String request;

	private String curPos;
	private String nextPos;
	private String leadId;
	private String incomeType;

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Long getRecordId() {
		try {
			return Long.parseLong(leadId);

		} catch (Exception ex) {

		}
		return -1L;
	}

	public String getNextPos() {
		return nextPos;
	}

	public void setNextPos(String nextPos) {
		this.nextPos = nextPos;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getCurPos() {
		return curPos;
	}

	public void setCurPos(String curPos) {
		this.curPos = curPos;
	}
}
