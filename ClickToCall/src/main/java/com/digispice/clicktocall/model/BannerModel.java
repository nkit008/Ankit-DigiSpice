package com.digispice.clicktocall.model;

public class BannerModel {

	private int id;
	private String smartphone_path;
	private String feature_path;
	private boolean active;
	private int playlist_id;
	private String playlist_name;
	private int created_by;
	private int updated_by;
	private String created_at;
	private String updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmartphone_path() {
		return smartphone_path;
	}

	public void setSmartphone_path(String smartphone_path) {
		this.smartphone_path = smartphone_path;
	}

	public String getFeature_path() {
		return feature_path;
	}

	public void setFeature_path(String feature_path) {
		this.feature_path = feature_path;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(int playlist_id) {
		this.playlist_id = playlist_id;
	}

	public String getPlaylist_name() {
		return playlist_name;
	}

	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
