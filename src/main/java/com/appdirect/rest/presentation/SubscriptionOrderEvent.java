package com.appdirect.rest.presentation;

public class SubscriptionOrderEvent extends Event {

	private OrderCreator creator;
	private OrderPayload payload;

	public OrderCreator getCreator() {
		return creator;
	}

	public void setCreator(OrderCreator creator) {
		this.creator = creator;
	}

	public OrderPayload getPayload() {
		return payload;
	}

	public void setPayload(OrderPayload payload) {
		this.payload = payload;
	}

}
