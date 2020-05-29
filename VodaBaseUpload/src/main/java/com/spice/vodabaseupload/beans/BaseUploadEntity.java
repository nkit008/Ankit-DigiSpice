package com.spice.vodabaseupload.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_fresh_base")
public class BaseUploadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
	@SequenceGenerator(name="id_gen",sequenceName = "id_seq_gen")
	@Column(name="id")
	private long id;
	
	@Column(name="RETAILER_NUMBER")
	private String RETAILERNUMBER;
	
	@Column(name="DSE_MOB_NO")
	private String DSE_MOB_NO;
	
	@Column(name="DIST_Number")
	private String DIST_Number;
	
	@Column(name="TSM_NUMBER")
	private String TSM_NUMBER;
	
	@Column(name="ASM_NUMBER")
	private String ASM_NUMBER;
	
	@Column(name="ZM_NUMBER")
	private String ZM_NUMBER;
	
	
	@Column(name="CIRCLE_TEAM")
	private String CIRCLE_TEAM;
	
	@Column(name="CIRCLE_TEAM1")
	private String CIRCLE_TEAM1;
	
	@Column(name="CIRCLE_TEAM2")
	private String CIRCLE_TEAM2;
	
	@Column(name="CIRCLE_TEAM3")
	private String CIRCLE_TEAM3;
	
	@Column(name="BRAND	")
	private String Brand;
	
	@Column(name="UB_COUNT")
	private String UB_Count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRETAILERNUMBER() {
		return RETAILERNUMBER;
	}

	public void setRETAILERNUMBER(String rETAILERNUMBER) {
		RETAILERNUMBER = rETAILERNUMBER;
	}

	public String getDSE_MOB_NO() {
		return DSE_MOB_NO;
	}

	public void setDSE_MOB_NO(String dSE_MOB_NO) {
		DSE_MOB_NO = dSE_MOB_NO;
	}

	public String getDIST_Number() {
		return DIST_Number;
	}

	public void setDIST_Number(String dIST_Number) {
		DIST_Number = dIST_Number;
	}

	public String getTSM_NUMBER() {
		return TSM_NUMBER;
	}

	public void setTSM_NUMBER(String tSM_NUMBER) {
		TSM_NUMBER = tSM_NUMBER;
	}

	public String getASM_NUMBER() {
		return ASM_NUMBER;
	}

	public void setASM_NUMBER(String aSM_NUMBER) {
		ASM_NUMBER = aSM_NUMBER;
	}

	public String getZM_NUMBER() {
		return ZM_NUMBER;
	}

	public void setZM_NUMBER(String zM_NUMBER) {
		ZM_NUMBER = zM_NUMBER;
	}

	public String getCIRCLE_TEAM() {
		return CIRCLE_TEAM;
	}

	public void setCIRCLE_TEAM(String cIRCLE_TEAM) {
		CIRCLE_TEAM = cIRCLE_TEAM;
	}

	public String getCIRCLE_TEAM1() {
		return CIRCLE_TEAM1;
	}

	public void setCIRCLE_TEAM1(String cIRCLE_TEAM1) {
		CIRCLE_TEAM1 = cIRCLE_TEAM1;
	}

	public String getCIRCLE_TEAM2() {
		return CIRCLE_TEAM2;
	}

	public void setCIRCLE_TEAM2(String cIRCLE_TEAM2) {
		CIRCLE_TEAM2 = cIRCLE_TEAM2;
	}

	public String getCIRCLE_TEAM3() {
		return CIRCLE_TEAM3;
	}

	public void setCIRCLE_TEAM3(String cIRCLE_TEAM3) {
		CIRCLE_TEAM3 = cIRCLE_TEAM3;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getUB_Count() {
		return UB_Count;
	}

	public void setUB_Count(String uB_Count) {
		UB_Count = uB_Count;
	}

}
