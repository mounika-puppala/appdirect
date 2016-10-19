package com.appdirect.rest.presentation;

public class SubscriptionCancelEvent extends Event {

	private CancelCreator creator;
	private CancelPayload payload;

	public CancelCreator getCreator() {
		return creator;
	}

	public void setCreator(CancelCreator creator) {
		this.creator = creator;
	}

	public CancelPayload getPayload() {
		return payload;
	}

	public void setPayload(CancelPayload payload) {
		this.payload = payload;
	}

}
