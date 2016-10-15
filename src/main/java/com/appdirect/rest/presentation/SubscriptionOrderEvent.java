package com.appdirect.rest.presentation;

public class SubscriptionOrderEvent extends Event {

	private SubscriptionOrderCreator creator;
	private SubscriptionOrderPayload payload;

	public SubscriptionOrderEvent() {
		super(EventType.SUBSCRIPTION_ORDER);
	}

	public SubscriptionOrderCreator getCreator() {
		return creator;
	}

	public void setCreator(SubscriptionOrderCreator creator) {
		this.creator = creator;
	}

	public SubscriptionOrderPayload getPayload() {
		return payload;
	}

	public void setPayload(SubscriptionOrderPayload payload) {
		this.payload = payload;
	}

}
