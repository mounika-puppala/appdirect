package com.appdirect.service;

import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.Subscription;
import com.appdirect.persistent.entities.User;

@Service
public interface SubscriptionService {
	public Subscription save(Subscription sub);

	public Subscription createSubscription(User user);

	public Subscription cancelSubscription(User user);
}
