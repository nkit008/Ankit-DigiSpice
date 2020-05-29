package com.digispice.ghana.bean;

public class CreateUserBean {

	private String userId;
	private String first_name;
	private String last_name;
	private String password;
	private String admin_rights;
	private String cci_rights;
	private String cms_rights;
	private String mis_rights;
	private String super_user;
	private String updated_at;
	private String updated_by;
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getSuper_user() {
		return super_user;
	}

	public void setSuper_user(String super_user) {
		this.super_user = super_user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin_rights() {
		return admin_rights;
	}

	public void setAdmin_rights(String admin_rights) {
		this.admin_rights = admin_rights;
	}

	public String getCci_rights() {
		return cci_rights;
	}

	public void setCci_rights(String cci_rights) {
		this.cci_rights = cci_rights;
	}

	public String getCms_rights() {
		return cms_rights;
	}

	public void setCms_rights(String cms_rights) {
		this.cms_rights = cms_rights;
	}

	public String getMis_rights() {
		return mis_rights;
	}

	public void setMis_rights(String mis_rights) {
		this.mis_rights = mis_rights;
	}

	@Override
	public String toString() {
		return "CreateUserBean [userId=" + userId + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", admin_rights=" + admin_rights + ", cci_rights=" + cci_rights
				+ ", cms_rights=" + cms_rights + ", mis_rights=" + mis_rights + "]";
	}

}
