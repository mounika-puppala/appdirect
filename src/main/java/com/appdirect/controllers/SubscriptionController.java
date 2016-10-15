package com.appdirect.controllers;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appdirect.domain.ErrorCode;
import com.appdirect.persistent.entities.User;
import com.appdirect.rest.presentation.Account;
import com.appdirect.rest.presentation.Company;
import com.appdirect.rest.presentation.EventResponse;
import com.appdirect.rest.presentation.SubscriptionCancelCreator;
import com.appdirect.rest.presentation.SubscriptionCancelEvent;
import com.appdirect.rest.presentation.SubscriptionCancelPayload;
import com.appdirect.rest.presentation.SubscriptionOrderCreator;
import com.appdirect.rest.presentation.SubscriptionOrderEvent;
import com.appdirect.rest.presentation.SubscriptionOrderPayload;
import com.appdirect.service.EventService;
import com.appdirect.service.SubscriptionService;
import com.appdirect.service.UserService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(value="/create",method=RequestMethod.GET)
	public @ResponseBody EventResponse createSubscription(@RequestParam("eventUrl") String eventUrl){
		EventResponse eventResponse = null;
		try{
			URL url = new URL(eventUrl);
			RestTemplate restTemplate = new RestTemplate();
			SubscriptionOrderEvent event = restTemplate.getForObject(url.toURI(), SubscriptionOrderEvent.class);
			if(userService.findByOpenId(event.getCreator().getOpenId())==null){
				User user = eventService.saveUser(event);
				subscriptionService.createSubscription(user);
				eventResponse = new EventResponse(Boolean.TRUE.toString(),user.getUserId(),null,"Subscription Order is Successful");
			}else{
				eventResponse = new EventResponse(Boolean.FALSE.toString(),null,ErrorCode.USER_ALREADY_EXISTS.toString(),"Subscription Order failed");
			}
		}catch(Exception e){
			e.printStackTrace();
			eventResponse = new EventResponse(Boolean.FALSE.toString(),null,null,e.getMessage());
		}
		return eventResponse;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody SubscriptionOrderEvent getSubscriptionEvent(){
			SubscriptionOrderEvent event = new SubscriptionOrderEvent();
			Company company = new Company();
			company.setName("Talentica");
			SubscriptionOrderCreator creator = new SubscriptionOrderCreator();
			SubscriptionOrderPayload payload = new SubscriptionOrderPayload();
			payload.setCompany(company);
			event.setPayload(payload);
			creator.setOpenId("1255676");
			creator.setFirstName("mounikaa");
			event.setCreator(creator);
		return event;
	}
	
	@RequestMapping(value="/cancel",method=RequestMethod.GET)
	public @ResponseBody EventResponse cancelSubscription(@RequestParam("eventUrl") String eventUrl){
		EventResponse eventResponse = null;
		try{
			URL url = new URL(eventUrl);
			RestTemplate restTemplate = new RestTemplate();
			SubscriptionCancelEvent event = restTemplate.getForObject(url.toURI(), SubscriptionCancelEvent.class);
			User user = userService.findById(event.getPayload().getAccount().getAccountIdentifier());
			if(user!=null){
				subscriptionService.cancelSubscription(user);
				eventResponse = new EventResponse(Boolean.TRUE.toString(),user.getUserId(),null,"Subscription Cancellation is Successful");
			}else{
				eventResponse = new EventResponse(Boolean.FALSE.toString(),null,ErrorCode.USER_NOT_FOUND.toString(),"Subscription Cancellation failed");
			}
		}catch(Exception e){
			e.printStackTrace();
			eventResponse = new EventResponse(Boolean.FALSE.toString(),null,null,e.getMessage());
		}
		return eventResponse;
	}
	
	@RequestMapping(value="/cancelTest",method=RequestMethod.GET)
	public @ResponseBody SubscriptionCancelEvent cancelSubscriptionEvent(){
			SubscriptionCancelEvent event = new SubscriptionCancelEvent();
			Company company = new Company();
			company.setName("Talentica");
			SubscriptionCancelCreator creator = new SubscriptionCancelCreator();
			SubscriptionCancelPayload payload = new SubscriptionCancelPayload();
			Account account = new Account();
			account.setAccountIdentifier("402880e457c96ed10157c96f26cb0002");
			payload.setAccount(account);
			event.setPayload(payload);
			creator.setOpenId("1255676");
			creator.setFirstName("mounikaa");
			event.setCreator(creator);
		return event;
	}

}
