package com.appdirect.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.domain.SubscriptionStatus;
import com.appdirect.persistent.entities.Subscription;
import com.appdirect.persistent.entities.User;
import com.appdirect.repositories.SubcriptionRepository;
import com.appdirect.rest.presentation.SubscriptionChangeEvent;
import com.appdirect.service.SubscriptionService;


@Service
@Transactional
public class SubscriptionServiceImpl  implements SubscriptionService{

	@Autowired
	SubcriptionRepository repo;
	
	@Override
	public Subscription save(Subscription sub) {
		return repo.save(sub);
	}

	@Override
	public Subscription createSubscription(User user) {
		Subscription sub = new Subscription();
		sub.setUser(user);
		sub.setStatus(SubscriptionStatus.ACTIVE);
		return save(sub);
	}
	
	@Override
	public Subscription cancelSubscription(User user) {
		Subscription sub = repo.findByUser(user);
		sub.setStatus(SubscriptionStatus.CANCELLED);
		return save(sub);
	}

	@Override
	public Subscription changeSubscription(User user, SubscriptionChangeEvent event) {
		Subscription sub = repo.findByUser(user);
		sub.setStatus(SubscriptionStatus.valueOf(event.getPayload().getAccount().getStatus()));
		return save(sub);
	}

}
