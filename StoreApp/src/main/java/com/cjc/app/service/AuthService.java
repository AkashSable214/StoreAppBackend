package com.cjc.app.service;

import com.cjc.app.dto.LoginRequest;

public interface AuthService {

	String login(LoginRequest request);
}
