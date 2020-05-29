package com.digispice.clicktocall.model;

public class MetaInfoModel {

	private int id;
	private String playlist_name;
	private int total_metafile_records;
	private int total_musicfile_inserted;
	private int total_musicfile_updated;
	private int total_mm_assign;
	private int total_mm_update;
	private int total_unassign_mm;
	private int total_free_mm;
	private int created_by;
	private String created_at;
	private String uid;

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaylist_name() {
		return playlist_name;
	}

	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

	public int getTotal_metafile_records() {
		return total_metafile_records;
	}

	public void setTotal_metafile_records(int total_metafile_records) {
		this.total_metafile_records = total_metafile_records;
	}

	public int getTotal_musicfile_inserted() {
		return total_musicfile_inserted;
	}

	public void setTotal_musicfile_inserted(int total_musicfile_inserted) {
		this.total_musicfile_inserted = total_musicfile_inserted;
	}

	public int getTotal_musicfile_updated() {
		return total_musicfile_updated;
	}

	public void setTotal_musicfile_updated(int total_musicfile_updated) {
		this.total_musicfile_updated = total_musicfile_updated;
	}

	public int getTotal_mm_assign() {
		return total_mm_assign;
	}

	public void setTotal_mm_assign(int total_mm_assign) {
		this.total_mm_assign = total_mm_assign;
	}

	public int getTotal_mm_update() {
		return total_mm_update;
	}

	public void setTotal_mm_update(int total_mm_update) {
		this.total_mm_update = total_mm_update;
	}

	public int getTotal_unassign_mm() {
		return total_unassign_mm;
	}

	public void setTotal_unassign_mm(int total_unassign_mm) {
		this.total_unassign_mm = total_unassign_mm;
	}

	public int getTotal_free_mm() {
		return total_free_mm;
	}

	public void setTotal_free_mm(int total_free_mm) {
		this.total_free_mm = total_free_mm;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getuid() {
		return uid;
	}

	public void setuid(String uid) {
		this.uid = uid;
	}

}
