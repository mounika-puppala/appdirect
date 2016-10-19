package com.appdirect.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.transaction.Transactional;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.HmacSha1MessageSigner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.Event;
import com.appdirect.rest.presentation.EventType;
import com.appdirect.rest.presentation.SubscriptionCancelEvent;
import com.appdirect.rest.presentation.SubscriptionChangeEvent;
import com.appdirect.rest.presentation.SubscriptionOrderEvent;
import com.appdirect.service.EventService;
import com.appdirect.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	UserService userService;

	@Override
	public User saveUser(SubscriptionOrderEvent event) {
		User user = new User();
		user.setOpenId(event.getCreator().getOpenId());
		user.setFirstName(event.getCreator().getFirstName());
		user.setLastName(event.getCreator().getLastName());

		user = userService.save(user);
		return user;
	}

	@Override
	public Event getEvent(String eventUrl, EventType type)
			throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException,
			MalformedURLException, IOException, JsonParseException, JsonMappingException {
		OAuthConsumer consumer = new DefaultOAuthConsumer("myapp-139233",
				"GxsCp8C3ZfjE");
		consumer.setMessageSigner(new HmacSha1MessageSigner());
		URL url = new URL(eventUrl);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		consumer.sign(request);
		request.connect();
		InputStream inputStream = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Event event = null;
		switch (type) {
		case SUBSCRIPTION_ORDER:
			event = mapper.readValue(inputStream, SubscriptionOrderEvent.class);
			break;
		case SUBSCRIPTION_CANCEL:
			event = mapper.readValue(inputStream, SubscriptionCancelEvent.class);
			break;
		case SUBSCRIPTION_CHANGE:
			event = mapper.readValue(inputStream, SubscriptionChangeEvent.class);
			break;
		default:
			break;
		}
		inputStream.close();
		return event;
	}

}
