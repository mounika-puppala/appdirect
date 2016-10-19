package com.appdirect.rest.presentation;

public abstract class Event {
	private String type;
	private Marketplace marketplace;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

}
