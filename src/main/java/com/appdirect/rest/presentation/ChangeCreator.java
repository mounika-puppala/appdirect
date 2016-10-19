package com.appdirect.rest.presentation;

public class ChangeCreator extends BasicCreator {
	private ChangeAddress address;
	private String locale;

	public ChangeAddress getAddress() {
		return address;
	}

	public void setAddress(ChangeAddress address) {
		this.address = address;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
