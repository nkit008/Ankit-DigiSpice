package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class GetMisDao {
	
	public static Logger logger=Logger.getLogger(GetMisDao.class.getName());
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	
	@Autowired
	HttpSession session;
	
	Connection conn=null;
	
    public ArrayList getActSourceCount(String startDate, String endDate, boolean f)
    {
    	
    	ArrayList revenueData = new ArrayList();
		conn=(Connection)session.getAttribute("active_connection");
		
		if(conn==null)
		{
			logger.info("---connection is not established with database---");
			return null;
		}
			
		else
		{
			CallableStatement callstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try 
			{
				if(f)
				{
					callstmt = conn.prepareCall("{call Devotional.PROC_PROMOTION_TRACKER(0)}");
					logger.info(" Devotional.PROC_PROMOTION_TRACKER executed " + callstmt.execute());
				}
				logger.info("SQL of getActSourceCount ::   SELECT date_time,act_source,HR0,HR1,HR2,HR3,HR4,HR5,HR6,HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,total_succ,total_fail  FROM tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   '" + startDate + "'  AND  '" + endDate + "'   ORDER BY  date_time DESC");
				pstmt = conn.prepareStatement(" SELECT date(date_time) as date_time,act_source,HR0,HR0_succ,HR0_fail,HR1,HR1_succ,HR1_fail,HR2,HR2_succ,HR2_fail,HR3,HR3_succ,HR3_fail,HR4,HR4_succ,HR4_fail,HR5,HR5_succ,HR5_fail,HR6,HR6_succ,HR6_fail,HR7,HR7_succ,HR7_fail,HR8,HR8_succ,HR8_fail,HR9,HR9_succ,HR9_fail,HR10,HR10_succ,HR10_fail,HR11,HR11_succ,HR11_fail,HR12,HR12_succ,HR12_fail,HR13,HR13_succ,HR13_fail,HR14,HR14_succ,HR14_fail,HR15,HR15_succ,HR15_fail,HR16,HR16_succ,HR16_fail,HR17,HR17_succ,HR17_fail,HR18,HR18_succ,HR18_fail,HR19,HR19_succ,HR19_fail,HR20,HR20_succ,HR20_fail,HR21,HR21_succ,HR21_fail,HR22,HR22_succ,HR22_fail,HR23,HR23_succ,HR23_fail,total,total_succ,total_fail  FROM tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   ?  AND  ?  ORDER BY  date_time DESC  ");
				pstmt.setString(1, startDate);
				pstmt.setString(2, endDate);
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					HashMap<String, String> map = new HashMap<String, String>();
					String str_SUMMARY_DATE = sdf.format(rs.getDate("DATE_TIME"));
					map.put("DATE_TIME", str_SUMMARY_DATE);
					String act_source = rs.getString("act_source");
					if (rs.wasNull())
					{
						act_source = "-";
					}
					map.put("ACT_SOURCE", act_source);
	
					int HR0 = rs.getInt("HR0");
					if (rs.wasNull())
					{
						HR0 = 0;
	                }
					map.put("HR0", String.valueOf(HR0));
					int HR1 = rs.getInt("HR1");
					if (rs.wasNull())
					{
						HR1 = 0;
					}
					map.put("HR1", String.valueOf(HR1));
	
					int HR2 = rs.getInt("HR2");
					if (rs.wasNull())
					{
						HR2 = 0;
					}
					map.put("HR2", String.valueOf(HR2));
	
					int HR3 = rs.getInt("HR3");
					if (rs.wasNull())
					{
						HR3 = 0;
					}
					map.put("HR3", String.valueOf(HR3));
	
					int HR4 = rs.getInt("HR4");
					if (rs.wasNull())
					{
						HR4 = 0;
					}
					map.put("HR4", String.valueOf(HR4));
	
					int HR5 = rs.getInt("HR5");
					if (rs.wasNull())
					{
						HR5 = 0;
					}
					map.put("HR5", String.valueOf(HR5));
	
					int HR6 = rs.getInt("HR6");
					if (rs.wasNull())
					{
						HR6 = 0;
					}
					map.put("HR6", String.valueOf(HR6));
	
					int HR7 = rs.getInt("HR7");
					if (rs.wasNull())
					{
						HR7 = 0;
					}
					map.put("HR7", String.valueOf(HR7));
	
					int HR8 = rs.getInt("HR8");
					if (rs.wasNull())
					{
						HR8 = 0;
					}
					map.put("HR8", String.valueOf(HR8));
	
					int HR9 = rs.getInt("HR9");
					if (rs.wasNull())
					{
						HR9 = 0;
					}
					map.put("HR9", String.valueOf(HR9));
	
					int HR10 = rs.getInt("HR10");
					if (rs.wasNull())
					{
						HR10 = 0;
					}
					map.put("HR10", String.valueOf(HR10));
	
					int HR11 = rs.getInt("HR11");
					if (rs.wasNull())
					{
						HR11 = 0;
					}
					map.put("HR11", String.valueOf(HR11));
	
					int HR12 = rs.getInt("HR12");
					if (rs.wasNull())
					{
						HR12 = 0;
					}
					map.put("HR12", String.valueOf(HR12));
	
					int HR13 = rs.getInt("HR13");
					if (rs.wasNull())
					{
						HR13 = 0;
					}
					map.put("HR13", String.valueOf(HR13));
	
		            int HR14 = rs.getInt("HR14");
		            if (rs.wasNull()) {
		                HR14 = 0;
		            }
		            map.put("HR14", String.valueOf(HR14));
		
		            int HR15 = rs.getInt("HR15");
		            if (rs.wasNull()) {
		                HR15 = 0;
		            }
		            map.put("HR15", String.valueOf(HR15));
		
		            int HR16 = rs.getInt("HR16");
		            if (rs.wasNull())
		            {
		                HR16 = 0;
		            }
		            map.put("HR16", String.valueOf(HR16));
		
		            int HR17 = rs.getInt("HR17");
		            if (rs.wasNull())
		            {
		                HR17 = 0;
		            }
		            map.put("HR17", String.valueOf(HR17));
		
		            int HR18 = rs.getInt("HR18");
		            if (rs.wasNull())
		            {
		                HR18 = 0;
		            }
		            map.put("HR18", String.valueOf(HR18));
		
		            int HR19 = rs.getInt("HR19");
		            if (rs.wasNull())
		            {
		                HR19 = 0;
		            }
		            map.put("HR19", String.valueOf(HR19));
		
		            int HR20 = rs.getInt("HR20");
		            if (rs.wasNull())
		            {
		                HR20 = 0;
		            }
		            map.put("HR20", String.valueOf(HR20));
		
		            int HR21 = rs.getInt("HR21");
		            if (rs.wasNull())
		            {
		                HR21 = 0;
		            }
		            map.put("HR21", String.valueOf(HR21));
		
		            int HR22 = rs.getInt("HR22");
		            if (rs.wasNull())
		            {
		                HR22 = 0;
		            }
		            map.put("HR22", String.valueOf(HR22));
		
		            int HR23 = rs.getInt("HR23");
		            if (rs.wasNull())
		            {
		                HR23 = 0;
		            }
		            map.put("HR23", String.valueOf(HR23));
		
		            int HR0_succ = rs.getInt("HR0_succ");
		            if (rs.wasNull()) {
		                HR0_succ = 0;
		            }
		            map.put("HR0_succ", String.valueOf(HR0_succ));
		
		            int HR1_succ = rs.getInt("HR1_succ");
		            if (rs.wasNull()) {
		                HR1_succ = 0;
		            }
		            map.put("HR1_succ", String.valueOf(HR1_succ));
		
		            int HR2_succ = rs.getInt("HR2_succ");
		            if (rs.wasNull()) {
		                HR2_succ = 0;
		            }
		            map.put("HR2_succ", String.valueOf(HR2_succ));
		
		            int HR3_succ = rs.getInt("HR3_succ");
		            if (rs.wasNull())
		            {
		                HR3_succ = 0;
		            }
		            map.put("HR3_succ", String.valueOf(HR3_succ));
		
		            int HR4_succ = rs.getInt("HR4_succ");
		            if (rs.wasNull())
		            {
		                HR4_succ = 0;
		            }
		            map.put("HR4_succ", String.valueOf(HR4_succ));
		
		            int HR5_succ = rs.getInt("HR5_succ");
		            if (rs.wasNull())
		            {
		                HR5_succ = 0;
		            }
		            map.put("HR5_succ", String.valueOf(HR5_succ));
		
		            int HR6_succ = rs.getInt("HR6_succ");
		            if (rs.wasNull())
		            {
		                HR6_succ = 0;
		            }
		            map.put("HR6_succ", String.valueOf(HR6_succ));
		
		            int HR7_succ = rs.getInt("HR7_succ");
		            if (rs.wasNull())
		            {
		                HR7_succ = 0;
		            }
		            map.put("HR7_succ", String.valueOf(HR7_succ));
		
		            int HR8_succ = rs.getInt("HR8_succ");
		            if (rs.wasNull())
		            {
		                HR8_succ = 0;
		            }
		            map.put("HR8_succ", String.valueOf(HR8_succ));
		
		            int HR9_succ = rs.getInt("HR9_succ");
		            if (rs.wasNull())
		            {
		                HR9_succ = 0;
		            }
		            map.put("HR9_succ", String.valueOf(HR9_succ));
		
		            int HR10_succ = rs.getInt("HR10_succ");
		            if (rs.wasNull())
		            {
		                HR10_succ = 0;
		            }
		            map.put("HR10_succ", String.valueOf(HR10_succ));
		
		            int HR11_succ = rs.getInt("HR11_succ");
		            if (rs.wasNull())
		            {
		                HR11_succ = 0;
		            }
		            map.put("HR11_succ", String.valueOf(HR11_succ));
		
		            int HR12_succ = rs.getInt("HR12_succ");
		            if (rs.wasNull())
		            {
		                HR12_succ = 0;
		            }
		            map.put("HR12_succ", String.valueOf(HR12_succ));
		
		            int HR13_succ = rs.getInt("HR13_succ");
		            if (rs.wasNull())
		            {
		                HR13_succ = 0;
		            }
		            map.put("HR13_succ", String.valueOf(HR13_succ));
		
		            int HR14_succ = rs.getInt("HR14_succ");
		            if (rs.wasNull())
		            {
		                HR14_succ = 0;
		            }
		            map.put("HR14_succ", String.valueOf(HR14_succ));
		
		            int HR15_succ = rs.getInt("HR15_succ");
		            if (rs.wasNull())
		            {
		                HR15_succ = 0;
		            }
		            map.put("HR15_succ", String.valueOf(HR15_succ));
		
		            int HR16_succ = rs.getInt("HR16_succ");
		            if (rs.wasNull())
		            {
		                HR16_succ = 0;
		            }
		            map.put("HR16_succ", String.valueOf(HR16_succ));
		
		            int HR17_succ = rs.getInt("HR17_succ");
		            if (rs.wasNull())
		            {
		                HR17_succ = 0;
		            }
		            map.put("HR17_succ", String.valueOf(HR17_succ));
		
		            int HR18_succ = rs.getInt("HR18_succ");
		            if (rs.wasNull())
		            {
		                HR18_succ = 0;
		            }
		            map.put("HR18_succ", String.valueOf(HR18_succ));
		
		            int HR19_succ = rs.getInt("HR19_succ");
		            if (rs.wasNull())
		            {
		                HR19_succ = 0;
		            }
		            map.put("HR19_succ", String.valueOf(HR19_succ));
		
		            int HR20_succ = rs.getInt("HR20_succ");
		            if (rs.wasNull()) 
		            {
		                HR20_succ = 0;
		            }
		            map.put("HR20_succ", String.valueOf(HR20_succ));
		
		            int HR21_succ = rs.getInt("HR21_succ");
		            if (rs.wasNull())
		            {
		                HR21_succ = 0;
		            }
		            map.put("HR21_succ", String.valueOf(HR21_succ));
		
		            int HR22_succ = rs.getInt("HR22_succ");
		            if (rs.wasNull()) 
		            {
		                HR22_succ = 0;
		            }
		            map.put("HR22_succ", String.valueOf(HR22_succ));
		
		            int HR23_succ = rs.getInt("HR23_succ");
		            if (rs.wasNull()) 
		            {
		                HR23_succ = 0;
		            }
		            map.put("HR23_succ", String.valueOf(HR23_succ));
		
		            int HR0_fail = rs.getInt("HR0_fail");
		            if (rs.wasNull())
		            {
		                HR0_fail = 0;
		            }
		            map.put("HR0_fail", String.valueOf(HR0_fail));
		
		            int HR1_fail = rs.getInt("HR1_fail");
		            if (rs.wasNull())
		            {
		                HR1_fail = 0;
		            }
		            map.put("HR1_fail", String.valueOf(HR1_fail));
		
		            int HR2_fail = rs.getInt("HR2_fail");
		            if (rs.wasNull()) 
		            {
		                HR2_fail = 0;
		            }
		            map.put("HR2_fail", String.valueOf(HR2_fail));
		
		            int HR3_fail = rs.getInt("HR3_fail");
		            if (rs.wasNull())
		            {
		                HR3_fail = 0;
		            }
		            map.put("HR3_fail", String.valueOf(HR3_fail));
		
		            int HR4_fail = rs.getInt("HR4_fail");
		            if (rs.wasNull())
		            {
		                HR4_fail = 0;
		            }
		            map.put("HR4_fail", String.valueOf(HR4_fail));
		
		            int HR5_fail = rs.getInt("HR5_fail");
		            if (rs.wasNull())
		            {
		                HR5_fail = 0;
		            }
		            map.put("HR5_fail", String.valueOf(HR5_fail));
		
		            int HR6_fail = rs.getInt("HR6_fail");
		            if (rs.wasNull())
		            {
		                HR6_fail = 0;
		            }
		            map.put("HR6_fail", String.valueOf(HR6_fail));
		
		            int HR7_fail = rs.getInt("HR7_fail");
		            if (rs.wasNull())
		            {
		                HR7_fail = 0;
		            }
		            map.put("HR7_fail", String.valueOf(HR7_fail));
		
		            int HR8_fail = rs.getInt("HR8_fail");
		            if (rs.wasNull())
		            {
		                HR8_fail = 0;
		            }
		            map.put("HR8_fail", String.valueOf(HR8_fail));
		
		            int HR9_fail = rs.getInt("HR9_fail");
		            if (rs.wasNull())
		            {
		                HR9_fail = 0;
		            }
		            map.put("HR9_fail", String.valueOf(HR9_fail));
		
		            int HR10_fail = rs.getInt("HR10_fail");
		            if (rs.wasNull())
		            {
		                HR10_fail = 0;
		            }
		            map.put("HR10_fail", String.valueOf(HR10_fail));
		
		            int HR11_fail = rs.getInt("HR11_fail");
		            if (rs.wasNull())
		            {
		                HR11_fail = 0;
		            }
		            map.put("HR11_fail", String.valueOf(HR11_fail));
		
		            int HR12_fail = rs.getInt("HR12_fail");
		            if (rs.wasNull())
		            {
		                HR12_fail = 0;
		            }
		            map.put("HR12_fail", String.valueOf(HR12_fail));
		
		            int HR13_fail = rs.getInt("HR13_fail");
		            if (rs.wasNull())
		            {
		                HR13_fail = 0;
		            }
		            map.put("HR13_fail", String.valueOf(HR13_fail));
		
		            int HR14_fail = rs.getInt("HR14_fail");
		            if (rs.wasNull())
		            {
		                HR14_fail = 0;
		            }
		            map.put("HR14_fail", String.valueOf(HR14_fail));
		
		            int HR15_fail = rs.getInt("HR15_fail");
		            if (rs.wasNull())
		            {
		                HR15_fail = 0;
		            }
		            map.put("HR15_fail", String.valueOf(HR15_fail));
		
		            int HR16_fail = rs.getInt("HR16_fail");
		            if (rs.wasNull())
		            {
		                HR16_fail = 0;
		            }
		            map.put("HR16_fail", String.valueOf(HR16_fail));
		
		            int HR17_fail = rs.getInt("HR17_fail");
		            if (rs.wasNull())
		            {
		                HR17_fail = 0;
		            }
		            map.put("HR17_fail", String.valueOf(HR17_fail));
		
		            int HR18_fail = rs.getInt("HR18_fail");
		            if (rs.wasNull())
		            {
		                HR18_fail = 0;
		            }
		            map.put("HR18_fail", String.valueOf(HR18_fail));
		
		            int HR19_fail = rs.getInt("HR19_fail");
		            if (rs.wasNull())
		            {
		                HR19_fail = 0;
		            }
		            map.put("HR19_fail", String.valueOf(HR19_fail));
		
		            int HR20_fail = rs.getInt("HR20_fail");
		            if (rs.wasNull())
		            {
		                HR20_fail = 0;
		            }
		            map.put("HR20_fail", String.valueOf(HR20_fail));
		
		            int HR21_fail = rs.getInt("HR21_fail");
		            if (rs.wasNull())
		            {
		                HR21_fail = 0;
		            }
		            map.put("HR21_fail", String.valueOf(HR21_fail));
		
		            int HR22_fail = rs.getInt("HR22_fail");
		            if (rs.wasNull())
		            {
		                HR22_fail = 0;
		            }
		            map.put("HR22_fail", String.valueOf(HR22_fail));
		
		            int HR23_fail = rs.getInt("HR23_fail");
		            if (rs.wasNull())
		            {
		                HR23_fail = 0;
		            }
		            map.put("HR23_fail", String.valueOf(HR23_fail));
		
		            int total = rs.getInt("total");
		            if (rs.wasNull())
		            {
		                total = 0;
		            }
		            map.put("total", String.valueOf(total));
		
		            int total_succ = rs.getInt("total_succ");
		            if (rs.wasNull())
		            {
		                total_succ = 0;
		            }
		            map.put("total_succ", String.valueOf(total_succ));
		
		            int total_fail = rs.getInt("total_fail");
		            if (rs.wasNull())
		            {
		                total_fail = 0;
		            }
		            map.put("total_fail", String.valueOf(total_fail));
		
		            revenueData.add(map);
	
	        }
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	    return revenueData;
}

}
