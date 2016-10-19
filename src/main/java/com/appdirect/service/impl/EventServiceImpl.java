package com.appdirect.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.SubscriptionOrderEvent;
import com.appdirect.service.EventService;
import com.appdirect.service.UserService;

@Service
@Transactional
public class EventServiceImpl implements EventService{
	
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

}
