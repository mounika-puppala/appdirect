package com.appdirect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdirect.persistent.entities.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, String> {

	public Resource findById(String id);

}
