package com.yanalysis.oathink.user.model;

public class CompanyVO {
    private String orgName = "";
    private String orgDomain = "";
    private String userName = "";
    private String passwd = "";
    
    private String phone = "";
    private String code = "";
    
    public CompanyVO(){}
    
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgDomain() {
		return orgDomain;
	}
	public void setOrgDomain(String orgDomain) {
		this.orgDomain = orgDomain;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
