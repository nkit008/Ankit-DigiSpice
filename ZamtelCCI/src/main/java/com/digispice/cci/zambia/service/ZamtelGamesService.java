package com.digispice.cci.zambia.service;

import java.util.Date;
import java.util.List;

import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.UserStatusBean;
import com.digispice.cci.zambia.entity.ZamtelGamesBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;


public interface ZamtelGamesService {
	
	public UserEntity checkLogin(String userName, String password);
	public UserStatusBean checkUserDetails(String ani);
	public String singleSubscription(String ani,String packType);
	public String singleUnSubscription(String ani);
	public String zamtelGamesBulkSub(String destPath,String pricePoint);
	public List<ZamtelGamesBillingHistory> gamesBillingDetails(String ani);
	public List<ZamtelGamesMISEntity> getzamtelGamesMIS(String fromdate,String todate);
}
