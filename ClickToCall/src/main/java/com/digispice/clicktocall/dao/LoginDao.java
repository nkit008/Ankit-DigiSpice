package com.digispice.clicktocall.dao;

import java.util.List;

import com.digispice.clicktocall.model.UserModel;

public interface LoginDao {

	public List<UserModel> checkLogin(String username, String password);

	public List<String> getActivePlaylistName();
}
