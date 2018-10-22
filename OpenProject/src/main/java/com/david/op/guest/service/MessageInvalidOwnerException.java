package com.david.op.guest.service;

public class MessageInvalidOwnerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MessageInvalidOwnerException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	
}
