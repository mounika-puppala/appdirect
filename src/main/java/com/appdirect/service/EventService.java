package com.appdirect.service;

import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.SubscriptionOrderEvent;

@Service
public interface EventService {
	
	public User saveUser(SubscriptionOrderEvent event);

}
