package com.ninja.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.spring.entity.User;
import com.ninja.spring.event.RegistrationCompleteEvent;
import com.ninja.spring.model.UserModel;
import com.ninja.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth/")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("register")
	public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
		User registredUser = userService.registerUser(userModel);
		publisher.publishEvent(new RegistrationCompleteEvent(
				registredUser,
				applicationUrl(request)
				));
		
		return "User Registration Successful!";
	}
	
	@GetMapping("verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token) {
		String result = userService.validateVerificationToken(token);
		if (result.equalsIgnoreCase("valid")) {
			return "User Verified Successfully";
		}
		return "Bad User";
	}
	
	private String applicationUrl(HttpServletRequest request) {
		return "http://" +
				request.getServerName() +
				":" +
				request.getServerPort() +
				"/api/v1/auth" +
				request.getContextPath();
	}

}
