package com.appdirect.rest.presentation;

import javax.validation.constraints.NotNull;

public class ResourceCreateRequest {

	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
