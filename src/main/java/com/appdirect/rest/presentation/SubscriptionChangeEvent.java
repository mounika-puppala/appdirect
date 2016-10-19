package com.appdirect.rest.presentation;

public class SubscriptionChangeEvent extends Event {
	private ChangeCreator creator;
	private ChangePayload payload;

	public ChangeCreator getCreator() {
		return creator;
	}

	public void setCreator(ChangeCreator creator) {
		this.creator = creator;
	}

	public ChangePayload getPayload() {
		return payload;
	}

	public void setPayload(ChangePayload payload) {
		this.payload = payload;
	}

}
