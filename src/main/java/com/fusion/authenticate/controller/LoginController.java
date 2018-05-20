/**
 * 
 */
package com.fusion.authenticate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fusion.authenticate.model.LoginRequest;
import com.fusion.authenticate.model.LoginResponse;
import com.fusion.authenticate.services.LoginService;
import com.fusion.authenticate.services.LoginServiceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class LoginController {
	private static final String SUCCESS_STATUS = "success";
	 private static final String ERROR_STATUS = "error";
	 private static final int HTTP_SUCCESS = 200;
	 private static final int HTTP_FAILURE = 400;
	 @RequestMapping(value = "/login/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<LoginResponse> login(@PathVariable(value = "userId") String userId, @RequestBody LoginRequest request) {
		 System.out.println("Hellooooooooo");
		 try {
		  if (request.getUserName().isEmpty() || request.getPassword().isEmpty()) {
			 return new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
		  } else {
			  System.out.println("Login Sucess");
			  System.out.println(request.getUserName());
			  System.out.println(request.getPassword());
			  LoginResponse loginResponse = new LoginServiceImpl().validateLogin(request);
			  System.out.println("Login loginResponse  :: "+ loginResponse.getStatus());
			  if(loginResponse != null && loginResponse.getStatus().equals("SUCESS"))
				  return new ResponseEntity<LoginResponse>(HttpStatus.OK);
			  else {
				  return new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
			  }
		  }
		  
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return null;}
	 
	/* @RequestMapping(value = "/loginGet/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<LoginResponse> login(@PathVariable(value = "userId") String userId, @RequestParam  (value = "password") String password) {
		 System.out.println("Hellooooooooo");
		  if (userId.isEmpty() || password.isEmpty()) {
			 return new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
		  } else {
			  System.out.println("Login Sucess");
			  System.out.println(userId);
			  System.out.println(password);
			  return new ResponseEntity<LoginResponse>(HttpStatus.OK);
		  }
		  
		 }*/
	 @RequestMapping("/test")
		public String test() {//Welcome page, non-rest
			return "User login.";
		}

		@RequestMapping(value = "/user/{userName}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Void> getUser(@PathVariable("userName") String userName, @PathVariable("password") String password) {
	        System.out.println("Fetching User with userName " + userName);
	        System.out.println("Fetching User with id " + password);
	        if (userName.isEmpty() || password.isEmpty()) {
	            System.out.println("User empty");
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        } else if(userName.equals("Shailendra")){
	        	
	        	return new ResponseEntity<Void>(HttpStatus.OK);
	        }
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	
}
