package com.appdirect.rest.presentation;

public class SubscriptionOrderPayload {
	private Company company;
	private Order order;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
