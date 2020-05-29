package com.spice.vchatinterfacebulk.dao;

import java.util.List;

import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountCircleWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountPartnerWise;
import com.spice.vchatinterfacebulk.beans.ChatAgentLiveCountZoneWise;

public interface IChatAgentLiveCountDao {

	public List<ChatAgentLiveCountPartnerWise> getPartnerDetails(String hub);
	
	public List<ChatAgentLiveCountZoneWise> getZoneDetails(String hub);
	
	public List<ChatAgentLiveCountCircleWise> getCircleDetails(String hub);
	
	public List<ChatAgentLiveCountCircleWise> getPartnerCircleDetails(String hub,String pName);
	
	
	public List<List<ChatAgentLiveCountCircleWise>> getCircleDetailsHome();
	
	public List<ChatAgentLiveCountPartnerWise> getCirclewisePartnerDetails(String hub,String circle);
	
	
}
