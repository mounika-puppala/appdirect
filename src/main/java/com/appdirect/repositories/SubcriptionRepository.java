package com.appdirect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdirect.persistent.entities.Subscription;
import com.appdirect.persistent.entities.User;

@Repository
public interface SubcriptionRepository extends CrudRepository<Subscription,String>{

	@SuppressWarnings("unchecked")
	public Subscription save(Subscription sub);

	public Subscription findByUser(User user); 

}
