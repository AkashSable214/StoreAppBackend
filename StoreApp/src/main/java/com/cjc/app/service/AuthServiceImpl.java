package com.cjc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.dto.LoginRequest;
import com.cjc.app.repo.AdminRepo;
import com.cjc.app.repo.CustomerRepo;
import com.cjc.app.repo.DealerRepo;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	DealerRepo dealerRepo;

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public String login(LoginRequest request) {

		if (adminRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword()).isPresent())
			return "Admin Login Success";

		if (dealerRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword()).isPresent())
			return "Dealer Login Success";

		if (customerRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword()).isPresent())
			return "Customer Login Success";

		return "Invalid Credentials";
	}
}
