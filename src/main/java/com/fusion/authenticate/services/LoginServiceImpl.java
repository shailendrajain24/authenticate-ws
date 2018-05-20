package com.fusion.authenticate.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fusion.authenticate.dao.UserDetailDAOImpl;
import com.fusion.authenticate.jdbc.model.UserDetail;
import com.fusion.authenticate.model.LoginRequest;
import com.fusion.authenticate.model.LoginResponse;

public class LoginServiceImpl implements LoginService {

	public LoginResponse validateLogin(LoginRequest loginRequest) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDetailDAOImpl userDetailDAOImpl = (UserDetailDAOImpl) context.getBean("userDetailDAOImpl");
		System.out.println("---validateLogin---");
		LoginResponse loginResponse = null;
		UserDetail userDetail = userDetailDAOImpl.getUser(loginRequest.getUserName());
		if (loginRequest.getUserName().equalsIgnoreCase(userDetail.getUserID())
				&& loginRequest.getPassword().equals(userDetail.getPass())) {
			System.out.println("validateLogin SUCESS");
			loginResponse = new LoginResponse();
			loginResponse.setStatus("SUCESS");
			loginResponse.setUserId(userDetail.getUserID());
			return loginResponse;
		}

			return null;
	}

}
