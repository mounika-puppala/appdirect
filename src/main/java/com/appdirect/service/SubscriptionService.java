package com.appdirect.service;

import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.Subscription;
import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.SubscriptionChangeEvent;

@Service
public interface SubscriptionService {
	public Subscription save(Subscription sub);

	public Subscription createSubscription(User user);

	public Subscription cancelSubscription(User user);

	public Subscription changeSubscription(User user, SubscriptionChangeEvent event);
}
