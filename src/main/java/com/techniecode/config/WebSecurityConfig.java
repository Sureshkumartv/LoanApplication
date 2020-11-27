package com.techniecode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.techniecode.services.UserDetailsServiceImpl;
 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new AuthHandler();
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new AuthHandler();
	}
	@Bean
	public LogoutHandler logoutHandler() {
		return new AuthHandler();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().disable().cors().and().csrf().disable().authorizeRequests()
//				.antMatchers("/assets/**", "/login/**", "**/public/**").permitAll().anyRequest().authenticated()
//				.and()
//				// .formLogin().permitAll().and().logout().permitAll();
//				.formLogin().loginPage("/login").loginProcessingUrl("/login/check").successHandler(authenticationSuccessHandler())
//				.failureHandler(authenticationFailureHandler()).permitAll().and().logout().addLogoutHandler(logoutHandler()).permitAll();
		http.headers().disable().cors().and().csrf().disable().authorizeRequests()
		.antMatchers("**").permitAll().anyRequest().authenticated();
 }
}