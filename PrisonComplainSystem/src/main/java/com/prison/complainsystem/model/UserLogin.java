package com.prison.complainsystem.model;

public class UserLogin {
	
	private long id;
	private String user_name;
	private String password;
	private String name;
	private String user_role;
	private String created_at;
	private String created_by;
	private boolean active;
	private String updated_at;
	private String updated_by;
	private String phone;
	private String email;
	
	

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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
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
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", user_name=" + user_name + ", password=" + password + ", name=" + name
				+ ", user_role=" + user_role + ", created_at=" + created_at + ", created_by=" + created_by + ", active="
				+ active + ", updated_at=" + updated_at + ", updated_by=" + updated_by + "]";
	}
	
	

}
