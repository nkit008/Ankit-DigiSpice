package com.digispice.clicktocall.dao;

import java.util.List;
import java.util.Map;

import com.digispice.clicktocall.model.BannerModel;
import com.digispice.clicktocall.model.MetaInfoModel;
import com.digispice.clicktocall.model.MusicDetailsModel;
import com.digispice.clicktocall.model.PlaylistModel;
import com.digispice.clicktocall.model.UnassignCodeModel;

public interface AddPlaylistDao {

	public String addNewPlaylist(String playlistTitle, String playlistDesc);

	public String addBanner(int pid, String banner_name, String banner_path);

	public List<PlaylistModel> viewPlaylist();

	public List<MusicDetailsModel> viewMusic();

	public List<BannerModel> viewBanner();

	public List<MetaInfoModel> viewMetadataRecordsBypid(int id);

	public List<MetaInfoModel> viewMetadataRecords();

	public List<UnassignCodeModel> viewUnassignCodeDetails(String uid);

	public int updatePlaylist(String sno, String desc, boolean active);

	public String updatePlaylistWithBanner(String sno, String desc, boolean active, String feature_path,
			String smart_path);

	public void deletePlalylist(int pid);

	public Map<String, String> getnameByid();

	public int getpid(String playlistTitle);

	public int removeMusic(String id, String status);
}
