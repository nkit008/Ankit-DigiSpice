package com.digispice.cci.zambia.dao;

import java.util.Date;
import java.util.List;

import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.ZamtelBeatsBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelGamesBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;

public interface LoginDao {

	public UserEntity checkLogin(String username, String password);

	public List<ZamtelGamesBillingHistory> gamesBillingDetails(String ani);

	public List<ZamtelBeatsBillingHistory> beatsBillingDetails(String ani);

	public List<ZamtelGamesMISEntity> getzamtelGamesMIS(Date fromdate, Date todate);
	
	public List<ZamtelBeatsMISEntity> getzamtelBeatsMIS(Date fromdate, Date todate);
}
