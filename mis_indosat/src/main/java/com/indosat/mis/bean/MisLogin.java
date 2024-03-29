package com.indosat.mis.bean;

import javax.persistence.*;


@Entity
@Table(name = "tbl_gamemislogin")
public class MisLogin {
	@Id @GeneratedValue
	   @Column(name = "id")
	   private int id;

	   @Column(name = "username")
	   private String username;

	   @Column(name = "password")
	   private String password;

	   @Column(name = "property")
	   private String property;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	} 
	   
	   
}
