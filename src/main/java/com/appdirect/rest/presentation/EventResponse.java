package com.appdirect.rest.presentation;

public class EventResponse {
	private String success;
	private String message;
	private String errorCode;
	private String accountIdentifier;

	public EventResponse(String success, String accountIdentifier,
			String errorCode, String message) {
		this.success = success;
		this.accountIdentifier = accountIdentifier;
		this.errorCode = errorCode;
		this.message = message;

	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

}
