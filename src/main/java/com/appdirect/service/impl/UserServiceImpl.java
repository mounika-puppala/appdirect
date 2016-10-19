package com.appdirect.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.persistent.entities.User;
import com.appdirect.repositories.UserRepository;
import com.appdirect.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public User save(User profile) {
		return repo.save(profile);
	}

	@Override
	public User findByOpenId(String openId) {
		return repo.findByOpenId(openId);
	}

	@Override
	public User findById(String accountIdentifier) {
		return repo.findById(accountIdentifier);
	}

}
