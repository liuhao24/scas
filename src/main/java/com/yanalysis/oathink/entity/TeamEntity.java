package com.yanalysis.oathink.entity;

import java.util.Date;

public class TeamEntity {
	public static final long serialVersionUID = 1L;
	private Integer id;

	private String name;
	private String domain;
	private String description;
	private String logo;
	private String address;
	
	private int status = 0;
	private int owner = 0;
	private String ownerEmail = "";
	private String signupLink = "";
	private String tokenLink = "";

	private Date createAt;
	private String createBy;
	private Date updateAt;
	private String updateBy;
	
	public TeamEntity(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getSignupLink() {
		return signupLink;
	}

	public void setSignupLink(String signupLink) {
		this.signupLink = signupLink;
	}

	public String getTokenLink() {
		return tokenLink;
	}

	public void setTokenLink(String tokenLink) {
		this.tokenLink = tokenLink;
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

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}
