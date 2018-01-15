package com.yanalysis.oathink.orgnization.model;

public class DepartmentVO {
	private String deptName = "";
	private String deptDesc = "";
	private String code = "";
	private int id = -1;
	private int pgid = -1;
	private boolean enable = true;
	
    private String orgDomain = "";
    
    public DepartmentVO(){}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgDomain() {
		return orgDomain;
	}

	public void setOrgDomain(String orgDomain) {
		this.orgDomain = orgDomain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPgid() {
		return pgid;
	}

	public void setPgid(int pgid) {
		this.pgid = pgid;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
    
    
}
