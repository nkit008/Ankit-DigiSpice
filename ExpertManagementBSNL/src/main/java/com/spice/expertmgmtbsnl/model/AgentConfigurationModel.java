package com.spice.expertmgmtbsnl.model;

import java.util.Date;

public class AgentConfigurationModel {

	private String ani;
	private String chatId;
	private String partner_name;
	private String expert_name;
	private String hub;
	private String circle;
	private String location;
	private String agent_type;
	private int age;
	private String gender;
	private String language;
	private String subcategory;
	private int max_calls;
	private Long adhaar_card;
	private String configure_date;
	private String configure_by;
	private String updated_at;
	private String updated_by;
	
	
	
	
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
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
	public String  getLanguage() {
		return language;
	}
	public void setLanguage(String  language) {
		this.language = language;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getPartner_name() {
		return partner_name;
	}
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}
	public String getExpert_name() {
		return expert_name;
	}
	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}
	public String getHub() {
		return hub;
	}
	public void setHub(String hub) {
		this.hub = hub;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAgent_type() {
		return agent_type;
	}
	public void setAgent_type(String agent_type) {
		this.agent_type = agent_type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMax_calls() {
		return max_calls;
	}
	public void setMax_calls(int max_calls) {
		this.max_calls = max_calls;
	}
	public Long getAdhaar_card() {
		return adhaar_card;
	}
	public void setAdhaar_card(Long adhaar_card) {
		this.adhaar_card = adhaar_card;
	}
	public String getConfigure_date() {
		return configure_date;
	}
	public void setConfigure_date(String configure_date) {
		this.configure_date = configure_date;
	}
	public String getConfigure_by() {
		return configure_by;
	}
	public void setConfigure_by(String configure_by) {
		this.configure_by = configure_by;
	}
	
	@Override
	public String toString() {
		return "AgentConfigurationModel [ani=" + ani + ", chatId=" + chatId + ", partner_name=" + partner_name
				+ ", expert_name=" + expert_name + ", hub=" + hub + ", circle=" + circle + ", location=" + location
				+ ", agent_type=" + agent_type + ", age=" + age + ", gender=" + gender + ", language=" + language
				+ ", max_calls=" + max_calls + ", adhaar_card=" + adhaar_card + ", configure_date=" + configure_date
				+ ", configure_by=" + configure_by + ", updated_at=" + updated_at + ", updated_by=" + updated_by + "]";
	}
	
	
	
}
