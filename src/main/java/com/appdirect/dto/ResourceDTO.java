package com.appdirect.dto;

public class ResourceDTO {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringBuilder(100)
				.append("ResourceDTO [id=")
				.append(id).append(", name=").append(name)
				.append("]")
				.toString();
	}

}
