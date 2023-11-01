package com.ninja.spring.service;

import com.ninja.spring.entity.User;
import com.ninja.spring.model.UserModel;

public interface UserService {
	
	User registerUser(UserModel userModel);

	void saveVerificationTokenForUser(String token, User user);

}
