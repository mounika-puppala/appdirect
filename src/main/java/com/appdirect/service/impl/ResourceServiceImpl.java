package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appdirect.dto.ResourceDTO;
import com.appdirect.persistent.entities.Resource;
import com.appdirect.repositories.ResourceRepository;
import com.appdirect.service.ResourceService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	ResourceRepository repo;
	
	@Override
	public Resource createResource(ResourceDTO dto) {
		Resource resource = new Resource();
		resource.setName(dto.getName());
		resource = repo.save(resource);
		return resource;
	}

	@Override
	public Resource getResource(String id) throws Exception {
		Resource resource = repo.findById(id);
		if(resource == null){
			throw new Exception("Resource not found");
		}
		return resource;
	}

	@Override
	public Resource updateResource(ResourceDTO dto) throws Exception {
		Resource resource = repo.findById(dto.getId());
		if(resource == null){
			throw new Exception("Resource not found");
		}
		resource.setName(dto.getName());
		resource = repo.save(resource);
		return resource;
	}

	@Override
	public void deleteResource(String id) throws Exception {
		Resource resource = repo.findById(id);
		if(resource == null){
			throw new Exception("Resource not found");
		}
		repo.delete(resource);
	}

}
