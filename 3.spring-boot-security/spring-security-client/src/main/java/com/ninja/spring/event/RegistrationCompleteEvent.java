package com.ninja.spring.event;

import org.springframework.context.ApplicationEvent;

import com.ninja.spring.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;
	
	private final User user;
	private final String applicationUrl;

	public RegistrationCompleteEvent(User user, String applicationUrl) {
		super(user);
		this.user = user;
		this.applicationUrl = applicationUrl;
	}

}
