package com.digispice.ghana.dao;

import java.util.ArrayList;
import java.util.List;

import com.digispice.ghana.bean.NextVoiceSubDetails;
import com.digispice.ghana.bean.NextVoiceUnsubDetail;
import com.digispice.ghana.bean.NextVoiceUserBillingDetails;

public interface NextVoiceActionDao {

	public ArrayList<NextVoiceSubDetails> nextVoiceUserDetailsforsub(String ani);
	public ArrayList<NextVoiceUnsubDetail> nextVoiceDetailsforUnsub(String ani);
	public List<NextVoiceUserBillingDetails> nextVoiceUserBillingDetails(String ani);
	public String neXtVoiceSinleSubscription(String ani,String pack);
	public String neXtVoiceUnSubscription(String ani);
	public String neXtVoiceBulkSubscription(String pack,String path); 

}
