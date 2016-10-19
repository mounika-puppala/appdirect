package com.appdirect.service;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.Event;
import com.appdirect.rest.presentation.EventType;
import com.appdirect.rest.presentation.SubscriptionOrderEvent;

@Service
public interface EventService {
	
	public User saveUser(SubscriptionOrderEvent event);

	public Event getEvent(String eventUrl,EventType type) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException;

}
