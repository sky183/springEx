package com.david.op.guest.model;

public class Message {
	private int id;
	private String USERID;
	private String USERNAME;
	private String message;

	public Message() {
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", USERID=" + USERID + ", USERNAME=" + USERNAME + ", message=" + message + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
