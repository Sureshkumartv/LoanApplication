	package com.techniecode.config;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techniecode.beans.SessionUser;

//import com.pyxis.users.UserToken;

@Component
public class AuthHandler implements AuthenticationFailureHandler, AuthenticationSuccessHandler,LogoutHandler {

	 
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType("application/json");
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", Calendar.getInstance().getTime());
		data.put("error", exception.getMessage());

		response.getOutputStream().println(objectMapper.writeValueAsString(data));
	}
	 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json");
		String targetUrl = request.getContextPath();
		HttpSession session = request.getSession(false);
        if (session != null) {
        	SessionUser authObject=(SessionUser)authentication.getPrincipal();
            session.setAttribute("user", authObject);
        }
		System.out.println(" Return Url " + targetUrl);
		Map<String, Object> data = new HashMap<>();
		data.put("redirect", targetUrl);
		response.getOutputStream().println(objectMapper.writeValueAsString(data));
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
        if (session != null) {
        	session.removeAttribute("user");
        	 
        }
	}
}
