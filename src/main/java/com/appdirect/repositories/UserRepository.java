package com.appdirect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdirect.persistent.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	User findByOpenId(String openId);

	User findById(String accountIdentifier);

}
