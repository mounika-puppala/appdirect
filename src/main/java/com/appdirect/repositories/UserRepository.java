package com.appdirect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdirect.persistent.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	public User findByOpenId(String openId);

	public User findById(String accountIdentifier);

}
