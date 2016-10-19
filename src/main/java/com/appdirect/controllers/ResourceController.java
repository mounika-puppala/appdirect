package com.appdirect.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.dto.ResourceDTO;
import com.appdirect.persistent.entities.Resource;
import com.appdirect.rest.presentation.ResourceCreateRequest;
import com.appdirect.rest.presentation.ResourceUpdateRequest;
import com.appdirect.rest.presentation.ViewMapper;
import com.appdirect.service.ResourceService;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ViewMapper<ResourceDTO> resourceDtoMapper;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Resource> add(@RequestBody @Valid ResourceCreateRequest request) {
		try {
			ResourceDTO dto = resourceDtoMapper.map(request, ResourceDTO.class);
			Resource resource = resourceService.createResource(dto);
			return new ResponseEntity<Resource>(resource, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Resource>(new Resource(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource> get(@PathVariable("id") String id) {
		try {
			Resource resource = resourceService.getResource(id);
			return new ResponseEntity<Resource>(resource, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Resource>(new Resource(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Resource> update(@RequestBody @Valid ResourceUpdateRequest request) {
		try {
			ResourceDTO dto = resourceDtoMapper.map(request, ResourceDTO.class);
			Resource resource = resourceService.updateResource(dto);
			return new ResponseEntity<Resource>(resource, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Resource>(new Resource(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try {
			resourceService.deleteResource(id);
			return new ResponseEntity<String>("delete is successful", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	

	

}
