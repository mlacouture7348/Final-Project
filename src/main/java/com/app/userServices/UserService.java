package com.app.userServices;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.dto.UserRegistrationDto;
import com.app.model.User;

public interface UserService extends UserDetailsService{
	
	User findByUsername(String username);
	
	User save(UserRegistrationDto registration);

}
