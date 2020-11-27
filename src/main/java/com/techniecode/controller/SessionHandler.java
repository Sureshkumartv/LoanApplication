package com.techniecode.controller;

import javax.servlet.http.HttpSession;

import com.techniecode.beans.SessionUser;

public class SessionHandler {

	public SessionUser getSessionUser(HttpSession session) {
		// TODO Auto-generated method stub
		 
		return session.getAttribute("user") !=null ? (SessionUser)session.getAttribute("user"):new SessionUser();
	}

	public void setSessionUser(HttpSession session, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		sessionUser.setExist(true);
		session.setAttribute("user", sessionUser);
	}

}
