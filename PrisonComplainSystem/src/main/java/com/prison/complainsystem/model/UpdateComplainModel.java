package com.prison.complainsystem.model;

public class UpdateComplainModel {

	private long sno;
	private String assign_to;
	private String observation_detail;
	private String repair_replace;
	private String status;
	private String date_of_visit;
	private String action_taken;

	
	
	public long getSno() {
		return sno;
	}
	public void setSno(long sno) {
		this.sno = sno;
	}
	public String getAssign_to() {
		return assign_to;
	}
	public void setAssign_to(String assign_to) {
		this.assign_to = assign_to;
	}
	public String getObservation_detail() {
		return observation_detail;
	}
	public void setObservation_detail(String observation_detail) {
		this.observation_detail = observation_detail;
	}
	public String getRepair_replace() {
		return repair_replace;
	}
	public void setRepair_replace(String repair_replace) {
		this.repair_replace = repair_replace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate_of_visit() {
		return date_of_visit;
	}
	public void setDate_of_visit(String date_of_visit) {
		this.date_of_visit = date_of_visit;
	}
	public String getAction_taken() {
		return action_taken;
	}
	public void setAction_taken(String action_taken) {
		this.action_taken = action_taken;
	}

	
	
}
