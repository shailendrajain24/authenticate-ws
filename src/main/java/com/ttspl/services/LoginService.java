package com.ttspl.services;

import com.ttspl.model.LoginRequest;
import com.ttspl.model.LoginResponse;

public interface LoginService {
	public LoginResponse validateLogin (LoginRequest loginRequest); 
}
