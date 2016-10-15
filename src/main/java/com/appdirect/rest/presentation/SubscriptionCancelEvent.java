package com.appdirect.rest.presentation;

public class SubscriptionCancelEvent extends Event {

	private SubscriptionCancelCreator creator;
	private SubscriptionCancelPayload payload;

	public SubscriptionCancelEvent() {
		super(EventType.SUBSCRIPTION_CANCEL);
	}

	public SubscriptionCancelCreator getCreator() {
		return creator;
	}

	public void setCreator(SubscriptionCancelCreator creator) {
		this.creator = creator;
	}

	public SubscriptionCancelPayload getPayload() {
		return payload;
	}

	public void setPayload(SubscriptionCancelPayload payload) {
		this.payload = payload;
	}

}
