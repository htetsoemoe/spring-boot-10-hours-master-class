package com.ninja.spring.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ninja.spring.entity.User;
import com.ninja.spring.entity.VerificationToken;
import com.ninja.spring.model.UserModel;
import com.ninja.spring.repository.UserRepository;
import com.ninja.spring.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Override
	public User registerUser(UserModel userModel) {
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken = new VerificationToken(user, token);
		verificationTokenRepository.save(verificationToken);
	}

	@Override
	public String validateVerificationToken(String token) {
		VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
		
		if (verificationToken == null) {
			return "invalid";
		}
		
		// OneToOne relationship with User and Token
		User user = verificationToken.getUser();
		Calendar calendar = Calendar.getInstance();
		
		if ((verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
			verificationTokenRepository.delete(verificationToken);
			return "expired";
		}
		
		// If 'verificationToken' is still valid, registered user need to enable state to 'true'
		user.setEnabled(true);
		userRepository.save(user);
		
		return "valid";
	}

}
