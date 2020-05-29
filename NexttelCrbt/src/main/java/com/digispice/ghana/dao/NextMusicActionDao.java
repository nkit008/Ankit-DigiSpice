package com.digispice.ghana.dao;


import java.util.ArrayList;
import java.util.List;

import com.digispice.ghana.bean.NextMusicSubDetails;
import com.digispice.ghana.bean.NextMusicUnsubDetail;
import com.digispice.ghana.bean.NextMusicUserBillingDetails;
public interface NextMusicActionDao {

	public List<NextMusicUserBillingDetails> getModUserBillingDetails(String ani);
	public String modSinleSubscription(String ani,String pack);
	public String bulkModSinleSubscription(String pack,String path);
	public String modUnSubscription(String ani);
	
	
	/*Fetching user details according to Detail Type*/	
	public ArrayList<NextMusicUnsubDetail> modUserDetailsforUnsub(String ani);
	public ArrayList<NextMusicSubDetails> modUserDetailsforsub(String ani);
}
