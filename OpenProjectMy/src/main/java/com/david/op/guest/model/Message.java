package com.david.op.guest.model;

public class Message {
	private int message_id;
	private String USERID;
	private String USERNAME;
	private String message;

	public Message() {
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", USERID=" + USERID + ", USERNAME=" + USERNAME + ", message="
				+ message + "]";
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
