package com.david.op.guest.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
