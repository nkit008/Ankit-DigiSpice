package com.digispice.ghana.dao;

import java.util.List;

import com.digispice.ghana.bean.CrbtMisBean;
import com.digispice.ghana.bean.NextMusicMISEntity;
import com.digispice.ghana.bean.NextVoiceMISEntity;



public interface CrbtMisDao {
	
	public List<CrbtMisBean> getMis(String startdate, String enddate);
	public List<NextMusicMISEntity> getNextMusicMis(String startdate, String enddate);
	public List<NextVoiceMISEntity> getNextVoiceMis(String startdate, String enddate);

}
