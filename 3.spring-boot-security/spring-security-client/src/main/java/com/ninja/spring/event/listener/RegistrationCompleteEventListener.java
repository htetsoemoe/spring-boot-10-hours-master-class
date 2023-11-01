package com.ninja.spring.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ninja.spring.entity.User;
import com.ninja.spring.event.RegistrationCompleteEvent;
import com.ninja.spring.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	private UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		
		// Create the verification token for the user with link
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token, user);
		
		// Send mail to user
		String url = event.getApplicationUrl()
				+ "/verifyRegistration?token="
				+ token;
		
		// sendVerificationEmail()
		log.info("Click the link to verify your account: {}", url);
	}

}
