package com.spice.vchatinterfacebulk.dao;

import java.util.List;

import com.spice.vchatinterfacebulk.beans.ChatLoginStatusResp;

public interface IChatLoginStatusDao {

	public List<ChatLoginStatusResp> getDetailsByChatid(String hub,String chatId);
	
	public List<ChatLoginStatusResp> getDetailsByHub(String hub);
	
	public int editUser(String userHub,String bAni,String loginStatus,String priorityFlag);
	
}
