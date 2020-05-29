package com.digispice.ghana.bean;

public class UserDetails {
  private int id;
  private String username;
  private String password;
  private String role;
  private String login_as;
  
  public UserDetails() {}
  
  public int getId() { return id; }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getUsername() { return username; }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() { return password; }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getRole() { return role; }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public String getLogin_as() { return login_as; }
  
  public void setLogin_as(String login_as) {
    this.login_as = login_as;
  }
}