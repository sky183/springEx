package com.david.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class Memberinfo {
	private String USERID;
	private String USERPW;
	private String USERNAME;
	private String USERFILE;
	private MultipartFile PHOTOFILE;
	private String REGDATE;
	
	@Override
	public String toString() {
		return "Memberinfo [USERID=" + USERID + ", USERPW=" + USERPW + ", USERNAME=" + USERNAME + ", USERFILE="
				+ USERFILE + ", PHOTOFILE=" + PHOTOFILE + ", REGDATE=" + REGDATE + "]";
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERPW() {
		return USERPW;
	}

	public void setUSERPW(String uSERPW) {
		USERPW = uSERPW;
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

	public MultipartFile getPHOTOFILE() {
		return PHOTOFILE;
	}

	public void setPHOTOFILE(MultipartFile pHOTOFILE) {
		PHOTOFILE = pHOTOFILE;
	}

	public String getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(String rEGDATE) {
		REGDATE = rEGDATE;
	}
	
	
}
