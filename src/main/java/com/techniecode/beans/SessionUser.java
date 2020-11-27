package com.techniecode.beans;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.techniecode.entities.LoanAppLogin;
import com.techniecode.entities.LoanAppStart;

public class SessionUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2308713524701911705L;
	private LoanAppLogin user;
	private String leadId;
	private boolean exist;
	private LoanAppStart appStartObject;
	public SessionUser() {

	}

	public SessionUser(LoanAppLogin user) {
		this.user = user;
		this.exist = true;
	}

	public LoanAppStart getAppStartObject() {
		return appStartObject;
	}

	public void setAppStartObject(LoanAppStart appStartObject) {
		this.appStartObject = appStartObject;
	}

	public void setLoginUser(LoanAppLogin user) {
		this.user= user;
	}
	public LoanAppLogin getLoginUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return user.getLoginPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public Long getRecordId() {
		try {
			return Long.parseLong(leadId);

		} catch (Exception ex) {

		}
		return -1L;
	}

	public boolean isLeadExist() {
		return leadId != null && leadId.trim().length() > 0;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

}