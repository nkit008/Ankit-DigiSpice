package com.digispice.cci.zambia.service;

import java.util.List;

import com.digispice.cci.zambia.entity.BeatsUserStatusBean;
import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.ZamtelBeatsBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;


public interface ZamtelBeatsService {
	
	public UserEntity checkLoginBeats(String userName, String password);
	public BeatsUserStatusBean checkUserDetailsBeats(String ani);
	public String singleSubscriptionBeats(String ani,String packType);
	public String singleUnSubscriptionBeats(String ani);
	public String zamtelBeatsBulkSub(String destPath,String pricePoint);
	public List<ZamtelBeatsBillingHistory> beatsBillingDetails(String ani);
	public List<ZamtelBeatsMISEntity> getzamtelBeatsMIS(String fromdate,String todate);
}
