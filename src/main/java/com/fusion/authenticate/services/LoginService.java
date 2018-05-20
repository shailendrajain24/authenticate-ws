package com.fusion.authenticate.services;

import com.fusion.authenticate.model.LoginRequest;
import com.fusion.authenticate.model.LoginResponse;

public interface LoginService {
	public LoginResponse validateLogin (LoginRequest loginRequest); 
}
