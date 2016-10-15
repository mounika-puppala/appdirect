package com.appdirect.rest.presentation;

public abstract class Event {
	private EventType type;
	private Marketplace marketplace;

	public Event(EventType type) {
		this.type = type;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

}
