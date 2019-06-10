package com.gaurav.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.spring.dao.RegistrationDAO;
import com.gaurav.spring.dto.LoginDTO;
import com.gaurav.spring.dto.UserDTO;

@Service
public class RegistrationService 
{
	@Autowired
	private RegistrationDAO resgistrationDAO;

	public boolean register(UserDTO userDTO) {
		Integer identifier = resgistrationDAO.saveUser(userDTO);
		if (identifier != null && identifier > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean login(LoginDTO loginDTO) {
		System.out.println("login service..");
		Integer identifier = resgistrationDAO.validateUser(loginDTO);
		if (identifier > 0) {
			return true;
		} else {
			return false;
		}
	}
}
