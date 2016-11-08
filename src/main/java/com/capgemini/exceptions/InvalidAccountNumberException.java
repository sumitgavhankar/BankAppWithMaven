package com.capgemini.exceptions;

public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076213703097836403L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
