package com.appdirect.service;

import org.springframework.stereotype.Service;

import com.appdirect.dto.ResourceDTO;
import com.appdirect.persistent.entities.Resource;

@Service
public interface ResourceService {
	public Resource createResource(ResourceDTO dto);
	public Resource getResource(String id) throws Exception;
	public Resource updateResource(ResourceDTO dto) throws Exception;
	public void deleteResource(String id) throws Exception;
}
