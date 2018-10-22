package com.david.op.member.model;

public class Logininfo {
	private String USERID;
	private String USERNAME;
	private String USERFILE;
	private String REGDATE;
	private String logmsg;
	private String logid;
	
	public Logininfo() {
		
	}
	
	
	public Logininfo(String uSERID, String uSERNAME, String uSERFILE, String rEGDATE , String logmsg, String logid) {
		USERID = uSERID;
		USERNAME = uSERNAME;
		USERFILE = uSERFILE;
		REGDATE = rEGDATE;
		this.logmsg = logmsg;
		this.logid = logid;
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

	public String getUSERFILE() {
		return USERFILE;
	}

	public void setUSERFILE(String uSERFILE) {
		USERFILE = uSERFILE;
	}
	
	public String getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(String rEGDATE) {
		REGDATE = rEGDATE;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}
	
}
