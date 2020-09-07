package com.webapi.tasktracker.model;

public class AuthenticationModel {
	private String message;

	public AuthenticationModel(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AuthenticationModel [message=" + message + "]";
	}
}
