package com.voda.ghaana.model;

public class NewsBean {
	
	private String category;
	private String mainCategory;
	private String subCategory;
	private String bulkMode;
	private String datepicker;
	private String alertsms;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getBulkMode() {
		return bulkMode;
	}
	public void setBulkMode(String bulkMode) {
		this.bulkMode = bulkMode;
	}
	public String getDatepicker() {
		return datepicker;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public String getAlertsms() {
		return alertsms;
	}
	public void setAlertsms(String alertsms) {
		this.alertsms = alertsms;
	}
	
	@Override
	public String toString() {
		return "NewsBean [category=" + category + ", mainCategory=" + mainCategory + ", subCategory=" + subCategory
				+ ", bulkMode=" + bulkMode + ", datepicker=" + datepicker + ", alertsms=" + alertsms + "]";
	}
	
	
	

}
