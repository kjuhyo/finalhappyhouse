package com.ssafy.vue.dto;

public class MemberDto {

//	private String userid;
//	private String username;
//	private String userpwd;
//	private String email;
//	private String address;
//	private String joindate;

//	memId			varchar(20)		primary key, 
//	memPwd	        varchar(20)		NOT NULL,
//	memName		varchar(20)		NOT NULL,
//	memEmail	varchar(30)

	private String memId;
	private String memPwd;
	private String memName;
	private String memEmail;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName + ", memEmail=" + memEmail
				+ "]";
	}

}
