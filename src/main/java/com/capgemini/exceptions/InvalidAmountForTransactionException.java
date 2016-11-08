package com.capgemini.exceptions;

public class InvalidAmountForTransactionException extends Exception {
	
	private static final long serialVersionUID = 3621536540455107039L;

	public InvalidAmountForTransactionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidAmountForTransactionException(String message) {
		super();
		this.message = message;
	}

}
