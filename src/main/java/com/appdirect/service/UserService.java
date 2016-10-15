package com.appdirect.service;

import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;

@Service
public interface UserService {
	public User save(User profile);
	public User findByOpenId(String openId);
	public User findById(String accountIdentifier);

}
