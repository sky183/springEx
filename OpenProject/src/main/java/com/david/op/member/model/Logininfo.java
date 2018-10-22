package com.david.op.member.model;

public class Logininfo {
	private String USERID;
	private String USERNAME;
	private String USERFILE;
	private String REGDATE;
	
	public Logininfo() {
	}
	
	@Override
	public String toString() {
		return "Logininfo [USERID=" + USERID + ", USERNAME=" + USERNAME + ", USERFILE=" + USERFILE + ", REGDATE="
				+ REGDATE + "]";
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

	
	

}
