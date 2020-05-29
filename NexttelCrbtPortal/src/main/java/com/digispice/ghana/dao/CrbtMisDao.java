package com.digispice.ghana.dao;

import java.util.List;

import com.digispice.ghana.bean.CrbtMisBean;



public interface CrbtMisDao {
	
	public List<CrbtMisBean> getMis(String startdate, String enddate,String accesspage);

}
