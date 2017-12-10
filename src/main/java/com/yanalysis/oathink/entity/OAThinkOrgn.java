package com.yanalysis.oathink.entity;

import java.io.Serializable;
import java.util.Date;

public class OAThinkOrgn implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orgid;

	private String name;
	private String domain;
	private String phone;
	private String email;
	private String addr;

	private Date createAt;
	private String createBy;

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "OAThinkOrgn [orgid=" + orgid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", addr="
				+ addr + ", createAt=" + createAt + ", createBy=" + createBy + "]";
	}

}
