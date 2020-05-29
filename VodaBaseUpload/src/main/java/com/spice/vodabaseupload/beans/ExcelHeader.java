package com.spice.vodabaseupload.beans;

public class ExcelHeader {
	
	private String retailerNumber;
	private String dseMobNo;
	private String distNumber;
	private String tsmNumber;
	private String asmNumber;
	private String zmNumber;
	private String circleTeam1;
	private String circleTeam2;
	private String circleTeam3;
	private String circleTeam4;
	private String brand;
	private String ubCount;
	public String getRetailerNumber() {
		return retailerNumber;
	}
	public void setRetailerNumber(String retailerNumber) {
		this.retailerNumber = retailerNumber;
	}
	public String getDseMobNo() {
		return dseMobNo;
	}
	public void setDseMobNo(String dseMobNo) {
		this.dseMobNo = dseMobNo;
	}
	public String getDistNumber() {
		return distNumber;
	}
	public void setDistNumber(String distNumber) {
		this.distNumber = distNumber;
	}
	public String getTsmNumber() {
		return tsmNumber;
	}
	public void setTsmNumber(String tsmNumber) {
		this.tsmNumber = tsmNumber;
	}
	public String getAsmNumber() {
		return asmNumber;
	}
	public void setAsmNumber(String asmNumber) {
		this.asmNumber = asmNumber;
	}
	public String getZmNumber() {
		return zmNumber;
	}
	public void setZmNumber(String zmNumber) {
		this.zmNumber = zmNumber;
	}
	public String getCircleTeam1() {
		return circleTeam1;
	}
	public void setCircleTeam1(String circleTeam1) {
		this.circleTeam1 = circleTeam1;
	}
	public String getCircleTeam2() {
		return circleTeam2;
	}
	public void setCircleTeam2(String circleTeam2) {
		this.circleTeam2 = circleTeam2;
	}
	public String getCircleTeam3() {
		return circleTeam3;
	}
	public void setCircleTeam3(String circleTeam3) {
		this.circleTeam3 = circleTeam3;
	}
	public String getCircleTeam4() {
		return circleTeam4;
	}
	public void setCircleTeam4(String circleTeam4) {
		this.circleTeam4 = circleTeam4;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getUbCount() {
		return ubCount;
	}
	public void setUbCount(String ubCount) {
		this.ubCount = ubCount;
	}
	@Override
	public String toString() {
		return "ExcelHeader [retailerNumber=" + retailerNumber + ", dseMobNo=" + dseMobNo + ", distNumber=" + distNumber
				+ ", tsmNumber=" + tsmNumber + ", asmNumber=" + asmNumber + ", zmNumber=" + zmNumber + ", circleTeam1="
				+ circleTeam1 + ", circleTeam2=" + circleTeam2 + ", circleTeam3=" + circleTeam3 + ", circleTeam4="
				+ circleTeam4 + ", brand=" + brand + ", ubCount=" + ubCount + "]";
	}

	

}
