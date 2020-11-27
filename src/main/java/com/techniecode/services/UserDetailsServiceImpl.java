package com.techniecode.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techniecode.beans.SessionUser;
import com.techniecode.entities.LoanAppLogin;
import com.techniecode.repositories.LoginRepository;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private LoginRepository loginRepository;
     
    @Override
    public UserDetails loadUserByUsername(String emailId)
            throws UsernameNotFoundException {
    	LoanAppLogin login = loginRepository.findByEmailId(emailId);
         
        if (login == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new SessionUser(login);
    }
 
}