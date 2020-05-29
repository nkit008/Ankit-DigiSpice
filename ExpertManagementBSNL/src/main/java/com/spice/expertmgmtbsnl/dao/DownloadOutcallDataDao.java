package com.spice.expertmgmtbsnl.dao;

import java.util.List;

import com.spice.expertmgmtbsnl.model.EtalkOutcallModel;

public interface DownloadOutcallDataDao {
	public List<EtalkOutcallModel> getDetailbyChatId(String chatId);
	public List<EtalkOutcallModel> getDetailbyAni(String ani);

}
