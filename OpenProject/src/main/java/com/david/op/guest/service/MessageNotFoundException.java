package com.david.op.guest.service;

public class MessageNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	
	public MessageNotFoundException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}