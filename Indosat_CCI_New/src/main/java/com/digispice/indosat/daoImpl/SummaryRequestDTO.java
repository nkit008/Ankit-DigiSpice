package com.digispice.indosat.daoImpl;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class SummaryRequestDTO {
	
	
	public static Logger logger=Logger.getLogger(SummaryRequestDTO.class.getName());
	
    static Connection conn;
    
    private static HttpSession session;
    
    	@Autowired
    	public void setSession(HttpSession session) {
		SummaryRequestDTO.session = session;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	public static synchronized ArrayList cust_getRevenueMISData(String startDate, String endDate) {
		
		logger.info("in summary con is "+session.getAttribute("active_connection"));
		conn = (Connection)session.getAttribute("active_connection");
		
		
		
		ArrayList revenueData = null;
		ResultSet rs = null;
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;
		ResultSet rs4;
		ResultSet rs5;
		ResultSet rs6;
		ResultSet rs7;
		ResultSet rs8;
		ResultSet rs9;
		PreparedStatement pstmt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		DecimalFormat df = new DecimalFormat("##.##");
		
		if(conn!=null)
		{

		try {
			revenueData = new ArrayList();
			pstmt = conn.prepareStatement(
					"select * from mobile_radio.tbl_indomusik_daily_summary  where DATE(DATE_TIME) between '"
							+ startDate + "' and  '" + endDate + "' order by DATE_TIME asc ");
			rs = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? ");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs1 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status = 1");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs2 = pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status not in (1)");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs3 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and substring(CALLTIME,1,2) not in ('22','23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs4 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status = 1 and substring(CALLTIME,1,2) not in ('22','23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs5 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status not in (1) and substring(CALLTIME,1,2) not in ('22','23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs6 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and substring(CALLTIME,1,2)  in ('23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs7 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status = 1 and substring(CALLTIME,1,2)  in ('23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs8 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from mobile_radio.tbl_indomusik_cdr where calldate between ? and ? and status not in (1) and substring(CALLTIME,1,2)  in ('23','00','01','02','03','04','05')");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs9 = pstmt.executeQuery();

			long operatorbase = 3800000;
			// Mobile Radio
			long MRADIO_TOTAL_CALLS_gt = 0;
			long MRADIO_SUBS_USERS_CALLS_gt = 0;
			long MRADIO_NON_SUBS_USERS_CALLS_gt = 0;
			long MRADIO_TOTAL_MOUS_gt = 0;
			long MRADIO_SUBS_USERS_MOU_gt = 0;
			long MRADIO_NON_SUBS_USERS_MOU_gt = 0;
			long MRADIO_TOTAL_PULSES_gt = 0;
			long MRADIO_SUBS_USERS_PULSES_gt = 0;
			long MRADIO_NON_SUBS_USERS_PULSES_gt = 0;
			float MRADIO_TOTAL_UNIQUE_CALLERS_gt = 0;
			long MRADIO_UNIQUE_SUBS_CALLERS_gt = 0;
			long MRADIO_UNIQUE_NON_SUBS_CALLERS_gt = 0;
			// Day Radio
			long DAY_TOTAL_CALLS_gt = 0;
			long DAY_SUBS_USERS_CALLS_gt = 0;
			long DAY_NON_SUBS_USERS_CALLS_gt = 0;
			long DAY_TOTAL_MOUS_gt = 0;
			long DAY_SUBS_USERS_MOU_gt = 0;
			long DAY_NON_SUBS_USERS_MOU_gt = 0;
			long DAY_TOTAL_PULSES_gt = 0;
			long DAY_SUBS_USERS_PULSES_gt = 0;
			long DAY_NON_SUBS_USERS_PULSES_gt = 0;
			long DAY_TOTAL_UNIQUE_CALLERS_gt = 0;
			long DAY_UNIQUE_SUBS_CALLERS_gt = 0;
			long DAY_UNIQUE_NON_SUBS_CALLERS_gt = 0;
			// Night Radio
			long NIGHT_TOTAL_CALLS_gt = 0;
			long NIGHT_SUBS_USERS_CALLS_gt = 0;
			long NIGHT_NON_SUBS_USERS_CALLS_gt = 0;
			long NIGHT_TOTAL_MOUS_gt = 0;
			long NIGHT_SUBS_USERS_MOU_gt = 0;
			long NIGHT_NON_SUBS_USERS_MOU_gt = 0;
			long NIGHT_TOTAL_PULSES_gt = 0;
			long NIGHT_SUBS_USERS_PULSES_gt = 0;
			long NIGHT_NON_SUBS_USERS_PULSES_gt = 0;
			long NIGHT_TOTAL_UNIQUE_CALLERS_gt = 0;
			long NIGHT_UNIQUE_SUBS_CALLERS_gt = 0;
			long NIGHT_UNIQUE_NON_SUBS_CALLERS_gt = 0;

			long SUB1_REQ_gt = 0;
			long SUB2_REQ_gt = 0;
			long SUB3_REQ_gt = 0;
			// Subscription
			long SUB1_gt = 0;
			long SUB2_gt = 0;
			long SUB3_gt = 0;
			long SUB4_gt = 0;
			long SUB5_gt = 0;
			long SUB6_gt = 0;
			long SUB7_gt = 0;
			long SUB8_gt = 0;
			long TOTAL_SUBS_REQ_gt = 0;
			long TOTAL_UNSUBS_REQ_gt = 0;

			long VOLUNTARY_UNSUBS_gt = 0;
			long INVOLUNTARY_UNSUBS_gt = 0;
			long GROSS_ADDS_gt = 0;

			// Resubs
			long RESUB1_gt = 0;
			long RESUB2_gt = 0;
			long RESUB3_gt = 0;
			long RESUB4_gt = 0;
			long RESUB5_gt = 0;
			long RESUB6_gt = 0;
			long RESUB7_gt = 0;
			long RESUB8_gt = 0;

			// Mode of subscription
			long IVR_SUBS_gt = 0;
			long CCI_SUBS_gt = 0;
			long OBD_SUBS_gt = 0;
			long SMS_SUBS_gt = 0;
			long IBD_SUBS_gt = 0;
			long USSD_SUBS_gt = 0;
			long OTHERS_SUBS_gt = 0;

			// Mode of unsubscrition
			long IVR_UNSUBS_gt = 0;
			long CCI_UNSUBS_gt = 0;
			long USSD_UNSUBS_gt = 0;
			long SMS_UNSUBS_gt = 0;
			long OTHER_UNSUBS_gt = 0;

			// Mode of Download
			long IVR_DWLD_gt = 0;
			long OBD_DWLD_gt = 0;
			long CCI_DWLD_gt = 0;
			long SMS_DWLD_gt = 0;
			long MOBI_DWLD_gt = 0;
			long OTHERS_DWLD_gt = 0;
			// TOP UO

			long TOPUP1_gt = 0;
			long TOPUP2_gt = 0;
			long TOPUP3_gt = 0;

			// Dedication
			long ON_NET_DED_gt = 0;
			long OFF_NET_DED_gt = 0;
			float TOTAL_DED_gt = 0;

			// Revenue
			long DOWNLOADS_gt = 0;
			long CRBT_TONE_DOWNLOAD_gt = 0;
			double BROWSING_REVENUE_gt = 0;

			double SUB1_REVENUE_gt = 0;
			double SUB2_REVENUE_gt = 0;
			double SUB3_REVENUE_gt = 0;
			double SUB4_REVENUE_gt = 0;
			double SUB5_REVENUE_gt = 0;
			double SUB6_REVENUE_gt = 0;
			double SUB7_REVENUE_gt = 0;
			double SUB8_REVENUE_gt = 0;

			double TOPUP1_REVENUE_gt = 0;
			double TOPUP2_REVENUE_gt = 0;
			double TOPUP3_REVENUE_gt = 0;

			double DOWNLOAD_REVENUE_gt = 0;
			double DEDICATION_REVENUE_gt = 0;
			double GROSS_REVENUE_LOCAL_gt = 0;
			double GROSS_REVENUE_USD_gt = 0;

			// Active Subscriber
			int ACTIVE_SUBSCRIBERS_gt = 0;
			int BILLED_SUBSCRIBERS_gt = 0;
			int CALLING_SUBSCRIBERS_gt = 0;

			// Product Kpi
			float AVG_CALL_UNIQUE_gt = 0;
			float AVG_MOU_UNIQUE_gt = 0;
			float AVG_MOU_CALL_gt = 0;
			float AVG_DWLD_UNIQUE_gt = 0;
			float AVG_DED_UNIQUE_gt = 0;
			float AVG_RBT_UNIQUE_gt = 0;
			float UNIQUE_CALLER_ACTIVE_gt = 0;
			float SERVICE_PENETRATION_gt = 0;
			float ARPU_gt = 0;

			// Grace Subscriber
			int ACTIVE_TO_GRACE_gt = 0;
			int GRACE_TO_ACTIVE_gt = 0;
			int GRACE1TO7_gt = 0;
			int GRACE8TO14_gt = 0;
			int GRACE14TO21_gt = 0;
			int GRACE22TO30_gt = 0;

			// Usage Pattern
			int MIN1_gt = 0;
			int MIN2_gt = 0;
			int MIN3_gt = 0;
			int MIN4_gt = 0;
			int MIN5_gt = 0;
			int MIN6_gt = 0;
			int MIN7_gt = 0;
			int MIN8_gt = 0;
			int MIN9_gt = 0;
			int MIN10_gt = 0;
			int MIN10ABOVE_gt = 0;

			// Hour Utilization
			String HR0_gt = null;
			String HR1_gt = null;
			String HR2_gt = null;
			String HR3_gt = null;
			String HR4_gt = null;
			String HR5_gt = null;
			String HR6_gt = null;
			String HR7_gt = null;
			String HR8_gt = null;
			String HR9_gt = null;
			String HR10_gt = null;
			String HR11_gt = null;
			String HR12_gt = null;
			String HR13_gt = null;
			String HR14_gt = null;
			String HR15_gt = null;
			String HR16_gt = null;
			String HR17_gt = null;
			String HR18_gt = null;
			String HR19_gt = null;
			String HR20_gt = null;
			String HR21_gt = null;
			String HR22_gt = null;
			String HR23_gt = null;

			while (rs1.next()) {

				String MRADIO_TOTAL_UNIQUE_CALLERS_gt1 = rs1.getString(1);

				logger.info("MRADIO_TOTAL_UNIQUE_CALLERS_gt :::::::" + MRADIO_TOTAL_UNIQUE_CALLERS_gt1);

				MRADIO_TOTAL_UNIQUE_CALLERS_gt = Float.parseFloat(MRADIO_TOTAL_UNIQUE_CALLERS_gt1);

			}

			while (rs2.next()) {

				// logger.info("code comes here in unique caller");
				String MRADIO_UNIQUE_SUBS_CALLERS_gt1 = rs2.getString(1);

				logger.info("MRADIO_UNIQUE_SUBS_CALLERS_gt::::" + MRADIO_UNIQUE_SUBS_CALLERS_gt1);

				MRADIO_UNIQUE_SUBS_CALLERS_gt = Integer.parseInt(MRADIO_UNIQUE_SUBS_CALLERS_gt1);

			}

			while (rs3.next()) {

				// logger.info("code comes here in unique caller");
				String MRADIO_UNIQUE_NON_SUBS_CALLERS_gt1 = rs3.getString(1);

				logger.info("MRADIO_UNIQUE_NON_SUBS_CALLERS_gt :::::::" + MRADIO_UNIQUE_NON_SUBS_CALLERS_gt1);

				MRADIO_UNIQUE_NON_SUBS_CALLERS_gt = Integer.parseInt(MRADIO_UNIQUE_NON_SUBS_CALLERS_gt1);

			}

			while (rs4.next()) {

				// logger.info("code comes here in unique caller");
				String DAY_TOTAL_UNIQUE_CALLERS_gt1 = rs4.getString(1);

				logger.info("DAY_TOTAL_UNIQUE_CALLERS_gt :::::::" + DAY_TOTAL_UNIQUE_CALLERS_gt1);

				DAY_TOTAL_UNIQUE_CALLERS_gt = Integer.parseInt(DAY_TOTAL_UNIQUE_CALLERS_gt1);

			}

			while (rs5.next()) {

				// logger.info("code comes here in unique caller");
				String DAY_UNIQUE_SUBS_CALLERS_gt1 = rs5.getString(1);

				logger.info("DAY_UNIQUE_SUBS_CALLERS_gt :::::::" + DAY_UNIQUE_SUBS_CALLERS_gt1);

				DAY_UNIQUE_SUBS_CALLERS_gt = Integer.parseInt(DAY_UNIQUE_SUBS_CALLERS_gt1);

			}

			while (rs6.next()) {

				// logger.info("code comes here in unique caller");
				String DAY_UNIQUE_NON_SUBS_CALLERS_gt1 = rs6.getString(1);

				logger.info("DAY_UNIQUE_NON_SUBS_CALLERS_gt :::::::" + DAY_UNIQUE_NON_SUBS_CALLERS_gt1);

				DAY_UNIQUE_NON_SUBS_CALLERS_gt = Integer.parseInt(DAY_UNIQUE_NON_SUBS_CALLERS_gt1);

			}

			while (rs7.next()) {

				// logger.info("code comes here in unique caller");
				String NIGHT_TOTAL_UNIQUE_CALLERS_gt1 = rs7.getString(1);

				logger.info("NIGHT_TOTAL_UNIQUE_CALLERS_gt :::::::" + NIGHT_TOTAL_UNIQUE_CALLERS_gt1);

				NIGHT_TOTAL_UNIQUE_CALLERS_gt = Integer.parseInt(NIGHT_TOTAL_UNIQUE_CALLERS_gt1);

			}

			while (rs8.next()) {

				// logger.info("code comes here in unique caller");
				String NIGHT_UNIQUE_SUBS_CALLERS_gt1 = rs8.getString(1);

				logger.info("NIGHT_UNIQUE_SUBS_CALLERS_gt :::::::" + NIGHT_UNIQUE_SUBS_CALLERS_gt1);

				NIGHT_UNIQUE_SUBS_CALLERS_gt = Integer.parseInt(NIGHT_UNIQUE_SUBS_CALLERS_gt1);

			}

			while (rs9.next()) {

				// logger.info("code comes here in unique caller");
				String NIGHT_UNIQUE_NON_SUBS_CALLERS_gt1 = rs9.getString(1);

				logger.info("code comes here :::::::" + NIGHT_UNIQUE_NON_SUBS_CALLERS_gt1);

				NIGHT_UNIQUE_NON_SUBS_CALLERS_gt = Integer.parseInt(NIGHT_UNIQUE_NON_SUBS_CALLERS_gt1);

			}

			int count = 0;
			while (rs.next()) {

				count = count + 1;

				HashMap<String, String> ht = new HashMap<String, String>();
				String str_SUMMARY_DATE = sdf.format(rs.getDate("DATE_TIME"));
				ht.put("DATE_TIME", str_SUMMARY_DATE);

				logger.info("DATE_TIME = " + rs.getString("DATE_TIME"));

				String str_MRADIO_TOTAL_CALLS = rs.getString("MRADIO_TOTAL_CALLS");

				if (str_MRADIO_TOTAL_CALLS == null || str_MRADIO_TOTAL_CALLS.equals("")) {
					str_MRADIO_TOTAL_CALLS = "0";
				}
				// int MRADIO_TOTAL_CALLS_int =
				// Integer.parseInt(str_MRADIO_TOTAL_CALLS);

				float MRADIO_TOTAL_CALLS_float = Float.parseFloat(str_MRADIO_TOTAL_CALLS);
				MRADIO_TOTAL_CALLS_gt += MRADIO_TOTAL_CALLS_float;
				ht.put("MRADIO_TOTAL_CALLS", "" + MRADIO_TOTAL_CALLS_float);
				logger.info("MRADIO_TOTAL_CALLS= " + MRADIO_TOTAL_CALLS_float);

				String str_MRADIO_SUBS_USERS_CALLS = rs.getString("MRADIO_SUBS_USERS_CALLS");

				if (str_MRADIO_SUBS_USERS_CALLS == null || str_MRADIO_SUBS_USERS_CALLS.equals("")) {
					str_MRADIO_SUBS_USERS_CALLS = "0";
				}
				int MRADIO_SUBS_USERS_CALLS_int = Integer.parseInt(str_MRADIO_SUBS_USERS_CALLS);

				// float MRADIO_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_MRADIO_SUBS_USERS_CALLS);
				MRADIO_SUBS_USERS_CALLS_gt += MRADIO_SUBS_USERS_CALLS_int;
				ht.put("MRADIO_SUBS_USERS_CALLS", "" + MRADIO_SUBS_USERS_CALLS_int);
				logger.info("MRADIO_SUBS_USERS_CALLS= " + MRADIO_SUBS_USERS_CALLS_int);

				String str_MRADIO_NON_SUBS_USERS_CALLS = rs.getString("MRADIO_NON_SUBS_USERS_CALLS");

				if (str_MRADIO_NON_SUBS_USERS_CALLS == null || str_MRADIO_NON_SUBS_USERS_CALLS.equals("")) {
					str_MRADIO_NON_SUBS_USERS_CALLS = "0";

				}
				int MRADIO_NON_SUBS_USERS_CALLS_int = Integer.parseInt(str_MRADIO_NON_SUBS_USERS_CALLS);

				// float MRADIO_NON_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_MRADIO_NON_SUBS_USERS_CALLS);
				MRADIO_NON_SUBS_USERS_CALLS_gt += MRADIO_NON_SUBS_USERS_CALLS_int;
				ht.put("MRADIO_NON_SUBS_USERS_CALLS", "" + MRADIO_NON_SUBS_USERS_CALLS_int);
				logger.info("MRADIO_NON_SUBS_USERS_CALLS= " + MRADIO_NON_SUBS_USERS_CALLS_int);

				String str_MRADIO_TOTAL_MOUS = rs.getString("MRADIO_TOTAL_MOUS");

				if (str_MRADIO_TOTAL_MOUS == null || str_MRADIO_TOTAL_MOUS.equals("")) {
					str_MRADIO_TOTAL_MOUS = "0";

				}
				// int MRADIO_TOTAL_MOUS_int =
				// Integer.parseInt(str_MRADIO_TOTAL_MOUS);

				float MRADIO_TOTAL_MOUS_float = Float.parseFloat(str_MRADIO_TOTAL_MOUS);
				MRADIO_TOTAL_MOUS_gt += MRADIO_TOTAL_MOUS_float;
				ht.put("MRADIO_TOTAL_MOUS", "" + MRADIO_TOTAL_MOUS_float);
				logger.info("MRADIO_TOTAL_MOUS= " + MRADIO_TOTAL_MOUS_float);

				String str_MRADIO_SUBS_USERS_MOU = rs.getString("MRADIO_SUBS_USERS_MOU");

				if (str_MRADIO_SUBS_USERS_MOU == null || str_MRADIO_SUBS_USERS_MOU.equals("")) {
					str_MRADIO_SUBS_USERS_MOU = "0";

				}
				int MRADIO_SUBS_USERS_MOU_int = Integer.parseInt(str_MRADIO_SUBS_USERS_MOU);

				// float MRADIO_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_MRADIO_SUBS_USERS_MOU);
				MRADIO_SUBS_USERS_MOU_gt += MRADIO_SUBS_USERS_MOU_int;
				ht.put("MRADIO_SUBS_USERS_MOU", "" + MRADIO_SUBS_USERS_MOU_int);
				logger.info("MRADIO_SUBS_USERS_MOU= " + MRADIO_SUBS_USERS_MOU_int);

				String str_MRADIO_NON_SUBS_USERS_MOU = rs.getString("MRADIO_NON_SUBS_USERS_MOU");

				if (str_MRADIO_NON_SUBS_USERS_MOU == null || str_MRADIO_NON_SUBS_USERS_MOU.equals("")) {
					str_MRADIO_NON_SUBS_USERS_MOU = "0";

				}
				int MRADIO_NON_SUBS_USERS_MOU_int = Integer.parseInt(str_MRADIO_NON_SUBS_USERS_MOU);

				// float MRADIO_NON_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_MRADIO_NON_SUBS_USERS_MOU);
				MRADIO_NON_SUBS_USERS_MOU_gt += MRADIO_NON_SUBS_USERS_MOU_int;
				ht.put("MRADIO_NON_SUBS_USERS_MOU", "" + MRADIO_NON_SUBS_USERS_MOU_int);
				logger.info("MRADIO_NON_SUBS_USERS_MOU= " + MRADIO_NON_SUBS_USERS_MOU_int);

				String str_MRADIO_TOTAL_PULSES = rs.getString("MRADIO_TOTAL_PULSES");

				if (str_MRADIO_TOTAL_PULSES == null || str_MRADIO_TOTAL_PULSES.equals("")) {
					str_MRADIO_TOTAL_PULSES = "0";

				}
				int MRADIO_TOTAL_PULSES_int = Integer.parseInt(str_MRADIO_TOTAL_PULSES);

				// float MRADIO_TOTAL_PULSES_float =
				// Float.parseFloat(str_MRADIO_TOTAL_PULSES);
				MRADIO_TOTAL_PULSES_gt += MRADIO_TOTAL_PULSES_int;
				ht.put("MRADIO_TOTAL_PULSES", "" + MRADIO_TOTAL_PULSES_int);
				logger.info("MRADIO_TOTAL_PULSES= " + MRADIO_TOTAL_PULSES_int);

				String str_MRADIO_SUBS_USERS_PULSES = rs.getString("MRADIO_SUBS_USERS_PULSES");

				if (str_MRADIO_SUBS_USERS_PULSES == null || str_MRADIO_SUBS_USERS_PULSES.equals("")) {
					str_MRADIO_SUBS_USERS_PULSES = "0";

				}
				int MRADIO_SUBS_USERS_PULSES_int = Integer.parseInt(str_MRADIO_SUBS_USERS_PULSES);

				// float MRADIO_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_MRADIO_SUBS_USERS_PULSES);
				MRADIO_SUBS_USERS_PULSES_gt += MRADIO_SUBS_USERS_PULSES_int;
				ht.put("MRADIO_SUBS_USERS_PULSES", "" + MRADIO_SUBS_USERS_PULSES_int);
				logger.info("MRADIO_SUBS_USERS_PULSES= " + MRADIO_SUBS_USERS_PULSES_int);

				String str_MRADIO_NON_SUBS_USERS_PULSES = rs.getString("MRADIO_NON_SUBS_USERS_PULSES");

				if (str_MRADIO_NON_SUBS_USERS_PULSES == null || str_MRADIO_NON_SUBS_USERS_PULSES.equals("")) {
					str_MRADIO_NON_SUBS_USERS_PULSES = "0";

				}
				int MRADIO_NON_SUBS_USERS_PULSES_int = Integer.parseInt(str_MRADIO_NON_SUBS_USERS_PULSES);

				// float MRADIO_NON_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_MRADIO_NON_SUBS_USERS_PULSES);
				MRADIO_NON_SUBS_USERS_PULSES_gt += MRADIO_NON_SUBS_USERS_PULSES_int;
				ht.put("MRADIO_NON_SUBS_USERS_PULSES", "" + MRADIO_NON_SUBS_USERS_PULSES_int);
				logger.info("MRADIO_NON_SUBS_USERS_PULSES= " + MRADIO_NON_SUBS_USERS_PULSES_int);

				String str_MRADIO_TOTAL_UNIQUE_CALLERS = rs.getString("MRADIO_TOTAL_UNIQUE_CALLERS");

				if (str_MRADIO_TOTAL_UNIQUE_CALLERS == null || str_MRADIO_TOTAL_UNIQUE_CALLERS.equals("")) {
					str_MRADIO_TOTAL_UNIQUE_CALLERS = "0";

				}
				int MRADIO_TOTAL_UNIQUE_CALLERS_int = Integer.parseInt(str_MRADIO_TOTAL_UNIQUE_CALLERS);

				// float MRADIO_TOTAL_UNIQUE_CALLERS_float =
				// Float.parseFloat(str_MRADIO_TOTAL_UNIQUE_CALLERS);
				// MRADIO_TOTAL_UNIQUE_CALLERS_gt +=
				// MRADIO_TOTAL_UNIQUE_CALLERS_int;
				ht.put("MRADIO_TOTAL_UNIQUE_CALLERS", "" + MRADIO_TOTAL_UNIQUE_CALLERS_int);
				logger.info("MRADIO_TOTAL_UNIQUE_CALLERS= " + MRADIO_TOTAL_UNIQUE_CALLERS_int);

				String str_MRADIO_UNIQUE_SUBS_CALLERS = rs.getString("MRADIO_UNIQUE_SUBS_CALLERS");

				if (str_MRADIO_UNIQUE_SUBS_CALLERS == null || str_MRADIO_UNIQUE_SUBS_CALLERS.equals("")) {
					str_MRADIO_UNIQUE_SUBS_CALLERS = "0";

				}
				int MRADIO_UNIQUE_SUBS_CALLERS_int = Integer.parseInt(str_MRADIO_UNIQUE_SUBS_CALLERS);

				// float MRADIO_UNIQUE_SUBS_CALLERS_float =
				// Float.parseFloat(str_MRADIO_UNIQUE_SUBS_CALLERS);
				// MRADIO_UNIQUE_SUBS_CALLERS_gt +=
				// MRADIO_UNIQUE_SUBS_CALLERS_int;
				ht.put("MRADIO_UNIQUE_SUBS_CALLERS", "" + MRADIO_UNIQUE_SUBS_CALLERS_int);
				logger.info("MRADIO_UNIQUE_SUBS_CALLERS= " + MRADIO_UNIQUE_SUBS_CALLERS_int);

				String str_MRADIO_UNIQUE_NON_SUBS_CALLERS = rs.getString("MRADIO_UNIQUE_NON_SUBS_CALLERS");

				if (str_MRADIO_UNIQUE_NON_SUBS_CALLERS == null || str_MRADIO_UNIQUE_NON_SUBS_CALLERS.equals("")) {
					str_MRADIO_UNIQUE_NON_SUBS_CALLERS = "0";

				}
				int MRADIO_UNIQUE_NON_SUBS_CALLERS_int = Integer.parseInt(str_MRADIO_UNIQUE_NON_SUBS_CALLERS);

				// float MRADIO_UNIQUE_NON_SUBS_CALLERS_float =
				// Float.parseFloat(str_MRADIO_UNIQUE_NON_SUBS_CALLERS);
				// MRADIO_UNIQUE_NON_SUBS_CALLERS_gt +=
				// MRADIO_UNIQUE_NON_SUBS_CALLERS_int;
				ht.put("MRADIO_UNIQUE_NON_SUBS_CALLERS", "" + MRADIO_UNIQUE_NON_SUBS_CALLERS_int);
				logger.info("MRADIO_UNIQUE_NON_SUBS_CALLERS= " + MRADIO_UNIQUE_NON_SUBS_CALLERS_int);

				String str_DAY_TOTAL_CALLS = rs.getString("DAY_TOTAL_CALLS");

				if (str_DAY_TOTAL_CALLS == null || str_DAY_TOTAL_CALLS.equals("")) {
					str_DAY_TOTAL_CALLS = "0";
				}
				int DAY_TOTAL_CALLS_int = Integer.parseInt(str_DAY_TOTAL_CALLS);

				// float DAY_TOTAL_CALLS_float =
				// Float.parseFloat(str_DAY_TOTAL_CALLS);
				DAY_TOTAL_CALLS_gt += DAY_TOTAL_CALLS_int;
				ht.put("DAY_TOTAL_CALLS", "" + DAY_TOTAL_CALLS_int);
				logger.info("DAY_TOTAL_CALLS= " + DAY_TOTAL_CALLS_int);

				String str_DAY_SUBS_USERS_CALLS = rs.getString("DAY_SUBS_USERS_CALLS");

				if (str_DAY_SUBS_USERS_CALLS == null || str_DAY_SUBS_USERS_CALLS.equals("")) {
					str_DAY_SUBS_USERS_CALLS = "0";
				}
				int DAY_SUBS_USERS_CALLS_int = Integer.parseInt(str_DAY_SUBS_USERS_CALLS);

				// float DAY_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_DAY_SUBS_USERS_CALLS);
				DAY_SUBS_USERS_CALLS_gt += DAY_SUBS_USERS_CALLS_int;
				ht.put("DAY_SUBS_USERS_CALLS", "" + DAY_SUBS_USERS_CALLS_int);
				logger.info("DAY_SUBS_USERS_CALLS= " + DAY_SUBS_USERS_CALLS_int);

				String str_DAY_NON_SUBS_USERS_CALLS = rs.getString("DAY_NON_SUBS_USERS_CALLS");

				if (str_DAY_NON_SUBS_USERS_CALLS == null || str_DAY_NON_SUBS_USERS_CALLS.equals("")) {
					str_DAY_NON_SUBS_USERS_CALLS = "0";

				}
				int DAY_NON_SUBS_USERS_CALLS_int = Integer.parseInt(str_DAY_NON_SUBS_USERS_CALLS);

				// float DAY_NON_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_DAY_NON_SUBS_USERS_CALLS);
				DAY_NON_SUBS_USERS_CALLS_gt += DAY_NON_SUBS_USERS_CALLS_int;
				ht.put("DAY_NON_SUBS_USERS_CALLS", "" + DAY_NON_SUBS_USERS_CALLS_int);
				logger.info("DAY_NON_SUBS_USERS_CALLS= " + DAY_NON_SUBS_USERS_CALLS_int);

				String str_DAY_TOTAL_MOUS = rs.getString("DAY_TOTAL_MOUS");

				if (str_DAY_TOTAL_MOUS == null || str_DAY_TOTAL_MOUS.equals("")) {
					str_DAY_TOTAL_MOUS = "0";

				}
				int DAY_TOTAL_MOUS_int = Integer.parseInt(str_DAY_TOTAL_MOUS);

				// float DAY_TOTAL_MOUS_float =
				// Float.parseFloat(str_DAY_TOTAL_MOUS);
				DAY_TOTAL_MOUS_gt += DAY_TOTAL_MOUS_int;
				ht.put("DAY_TOTAL_MOUS", "" + DAY_TOTAL_MOUS_int);
				logger.info("DAY_TOTAL_MOUS= " + DAY_TOTAL_MOUS_int);

				String str_DAY_SUBS_USERS_MOU = rs.getString("DAY_SUBS_USERS_MOU");

				if (str_DAY_SUBS_USERS_MOU == null || str_DAY_SUBS_USERS_MOU.equals("")) {
					str_DAY_SUBS_USERS_MOU = "0";

				}
				int DAY_SUBS_USERS_MOU_int = Integer.parseInt(str_DAY_SUBS_USERS_MOU);

				// float DAY_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_DAY_SUBS_USERS_MOU);
				DAY_SUBS_USERS_MOU_gt += DAY_SUBS_USERS_MOU_int;
				ht.put("DAY_SUBS_USERS_MOU", "" + DAY_SUBS_USERS_MOU_int);
				logger.info("DAY_SUBS_USERS_MOU= " + DAY_SUBS_USERS_MOU_int);

				String str_DAY_NON_SUBS_USERS_MOU = rs.getString("DAY_NON_SUBS_USERS_MOU");

				if (str_DAY_NON_SUBS_USERS_MOU == null || str_DAY_NON_SUBS_USERS_MOU.equals("")) {
					str_DAY_NON_SUBS_USERS_MOU = "0";

				}
				int DAY_NON_SUBS_USERS_MOU_int = Integer.parseInt(str_DAY_NON_SUBS_USERS_MOU);

				// float DAY_NON_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_DAY_NON_SUBS_USERS_MOU);
				DAY_NON_SUBS_USERS_MOU_gt += DAY_NON_SUBS_USERS_MOU_int;
				ht.put("DAY_NON_SUBS_USERS_MOU", "" + DAY_NON_SUBS_USERS_MOU_int);
				logger.info("DAY_NON_SUBS_USERS_MOU= " + DAY_NON_SUBS_USERS_MOU_int);

				String str_DAY_TOTAL_PULSES = rs.getString("DAY_TOTAL_PULSES");

				if (str_DAY_TOTAL_PULSES == null || str_DAY_TOTAL_PULSES.equals("")) {
					str_DAY_TOTAL_PULSES = "0";

				}
				int DAY_TOTAL_PULSES_int = Integer.parseInt(str_DAY_TOTAL_PULSES);

				// float DAY_TOTAL_PULSES_float =
				// Float.parseFloat(str_DAY_TOTAL_PULSES);
				DAY_TOTAL_PULSES_gt += DAY_TOTAL_PULSES_int;
				ht.put("DAY_TOTAL_PULSES", "" + DAY_TOTAL_PULSES_int);
				logger.info("DAY_TOTAL_PULSES= " + DAY_TOTAL_PULSES_int);

				String str_DAY_SUBS_USERS_PULSES = rs.getString("DAY_SUBS_USERS_PULSES");

				if (str_DAY_SUBS_USERS_PULSES == null || str_DAY_SUBS_USERS_PULSES.equals("")) {
					str_DAY_SUBS_USERS_PULSES = "0";

				}
				int DAY_SUBS_USERS_PULSES_int = Integer.parseInt(str_DAY_SUBS_USERS_PULSES);

				// float DAY_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_DAY_SUBS_USERS_PULSES);
				DAY_SUBS_USERS_PULSES_gt += DAY_SUBS_USERS_PULSES_int;
				ht.put("DAY_SUBS_USERS_PULSES", "" + DAY_SUBS_USERS_PULSES_int);
				logger.info("DAY_SUBS_USERS_PULSES= " + DAY_SUBS_USERS_PULSES_int);

				String str_DAY_NON_SUBS_USERS_PULSES = rs.getString("DAY_NON_SUBS_USERS_PULSES");

				if (str_DAY_NON_SUBS_USERS_PULSES == null || str_DAY_NON_SUBS_USERS_PULSES.equals("")) {
					str_DAY_NON_SUBS_USERS_PULSES = "0";

				}
				int DAY_NON_SUBS_USERS_PULSES_int = Integer.parseInt(str_DAY_NON_SUBS_USERS_PULSES);

				// float DAY_NON_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_DAY_NON_SUBS_USERS_PULSES);
				DAY_NON_SUBS_USERS_PULSES_gt += DAY_NON_SUBS_USERS_PULSES_int;
				ht.put("DAY_NON_SUBS_USERS_PULSES", "" + DAY_NON_SUBS_USERS_PULSES_int);
				logger.info("DAY_NON_SUBS_USERS_PULSES= " + DAY_NON_SUBS_USERS_PULSES_int);

				String str_DAY_TOTAL_UNIQUE_CALLERS = rs.getString("DAY_TOTAL_UNIQUE_CALLERS");

				if (str_DAY_TOTAL_UNIQUE_CALLERS == null || str_DAY_TOTAL_UNIQUE_CALLERS.equals("")) {
					str_DAY_TOTAL_UNIQUE_CALLERS = "0";

				}
				int DAY_TOTAL_UNIQUE_CALLERS_int = Integer.parseInt(str_DAY_TOTAL_UNIQUE_CALLERS);

				// float DAY_TOTAL_UNIQUE_CALLERS_float =
				// Float.parseFloat(str_DAY_TOTAL_UNIQUE_CALLERS);
				// DAY_TOTAL_UNIQUE_CALLERS_gt += DAY_TOTAL_UNIQUE_CALLERS_int;
				ht.put("DAY_TOTAL_UNIQUE_CALLERS", "" + DAY_TOTAL_UNIQUE_CALLERS_int);
				logger.info("DAY_TOTAL_UNIQUE_CALLERS= " + DAY_TOTAL_UNIQUE_CALLERS_int);

				String str_DAY_UNIQUE_SUBS_CALLERS = rs.getString("DAY_UNIQUE_SUBS_CALLERS");

				if (str_DAY_UNIQUE_SUBS_CALLERS == null || str_DAY_UNIQUE_SUBS_CALLERS.equals("")) {
					str_DAY_UNIQUE_SUBS_CALLERS = "0";

				}
				int DAY_UNIQUE_SUBS_CALLERS_int = Integer.parseInt(str_DAY_UNIQUE_SUBS_CALLERS);

				// float DAY_UNIQUE_SUBS_CALLERS_float =
				// Float.parseFloat(str_DAY_UNIQUE_SUBS_CALLERS);
				// DAY_UNIQUE_SUBS_CALLERS_gt += DAY_UNIQUE_SUBS_CALLERS_int;
				ht.put("DAY_UNIQUE_SUBS_CALLERS", "" + DAY_UNIQUE_SUBS_CALLERS_int);
				logger.info("DAY_UNIQUE_SUBS_CALLERS= " + DAY_UNIQUE_SUBS_CALLERS_int);

				String str_DAY_UNIQUE_NON_SUBS_CALLERS = rs.getString("DAY_UNIQUE_NON_SUBS_CALLERS");

				if (str_DAY_UNIQUE_NON_SUBS_CALLERS == null || str_DAY_UNIQUE_NON_SUBS_CALLERS.equals("")) {
					str_DAY_UNIQUE_NON_SUBS_CALLERS = "0";

				}
				int DAY_UNIQUE_NON_SUBS_CALLERS_int = Integer.parseInt(str_DAY_UNIQUE_NON_SUBS_CALLERS);

				// float DAY_UNIQUE_NON_SUBS_CALLERS_float =
				// Float.parseFloat(str_DAY_UNIQUE_NON_SUBS_CALLERS);
				// DAY_UNIQUE_NON_SUBS_CALLERS_gt +=
				// DAY_UNIQUE_NON_SUBS_CALLERS_int;
				ht.put("DAY_UNIQUE_NON_SUBS_CALLERS", "" + DAY_UNIQUE_NON_SUBS_CALLERS_int);
				logger.info("DAY_UNIQUE_NON_SUBS_CALLERS= " + DAY_UNIQUE_NON_SUBS_CALLERS_int);

				String str_NIGHT_TOTAL_CALLS = rs.getString("NIGHT_TOTAL_CALLS");

				if (str_NIGHT_TOTAL_CALLS == null || str_NIGHT_TOTAL_CALLS.equals("")) {
					str_NIGHT_TOTAL_CALLS = "0";
				}
				// int NIGHT_TOTAL_CALLS_int =
				// Integer.parseInt(str_NIGHT_TOTAL_CALLS);

				float NIGHT_TOTAL_CALLS_float = Float.parseFloat(str_NIGHT_TOTAL_CALLS);
				NIGHT_TOTAL_CALLS_gt += NIGHT_TOTAL_CALLS_float;
				ht.put("NIGHT_TOTAL_CALLS", "" + NIGHT_TOTAL_CALLS_float);
				logger.info("NIGHT_TOTAL_CALLS= " + NIGHT_TOTAL_CALLS_float);

				String str_NIGHT_SUBS_USERS_CALLS = rs.getString("NIGHT_SUBS_USERS_CALLS");

				if (str_NIGHT_SUBS_USERS_CALLS == null || str_NIGHT_SUBS_USERS_CALLS.equals("")) {
					str_NIGHT_SUBS_USERS_CALLS = "0";
				}
				int NIGHT_SUBS_USERS_CALLS_int = Integer.parseInt(str_NIGHT_SUBS_USERS_CALLS);

				// float NIGHT_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_NIGHT_SUBS_USERS_CALLS);
				NIGHT_SUBS_USERS_CALLS_gt += NIGHT_SUBS_USERS_CALLS_int;
				ht.put("NIGHT_SUBS_USERS_CALLS", "" + NIGHT_SUBS_USERS_CALLS_int);
				logger.info("NIGHT_SUBS_USERS_CALLS= " + NIGHT_SUBS_USERS_CALLS_int);

				String str_NIGHT_NON_SUBS_USERS_CALLS = rs.getString("NIGHT_NON_SUBS_USERS_CALLS");

				if (str_NIGHT_NON_SUBS_USERS_CALLS == null || str_NIGHT_NON_SUBS_USERS_CALLS.equals("")) {
					str_NIGHT_NON_SUBS_USERS_CALLS = "0";

				}
				int NIGHT_NON_SUBS_USERS_CALLS_int = Integer.parseInt(str_NIGHT_NON_SUBS_USERS_CALLS);

				// float NIGHT_NON_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_NIGHT_NON_SUBS_USERS_CALLS);
				NIGHT_NON_SUBS_USERS_CALLS_gt += NIGHT_NON_SUBS_USERS_CALLS_int;
				ht.put("NIGHT_NON_SUBS_USERS_CALLS", "" + NIGHT_NON_SUBS_USERS_CALLS_int);
				logger.info("NIGHT_NON_SUBS_USERS_CALLS= " + NIGHT_NON_SUBS_USERS_CALLS_int);

				String str_NIGHT_TOTAL_MOUS = rs.getString("NIGHT_TOTAL_MOUS");

				if (str_NIGHT_TOTAL_MOUS == null || str_NIGHT_TOTAL_MOUS.equals("")) {
					str_NIGHT_TOTAL_MOUS = "0";

				}
				// int NIGHT_TOTAL_MOUS_int =
				// Integer.parseInt(str_NIGHT_TOTAL_MOUS);

				float NIGHT_TOTAL_MOUS_float = Float.parseFloat(str_NIGHT_TOTAL_MOUS);
				NIGHT_TOTAL_MOUS_gt += NIGHT_TOTAL_MOUS_float;
				ht.put("NIGHT_TOTAL_MOUS", "" + NIGHT_TOTAL_MOUS_float);
				logger.info("NIGHT_TOTAL_MOUS= " + NIGHT_TOTAL_MOUS_float);

				String str_NIGHT_SUBS_USERS_MOU = rs.getString("NIGHT_SUBS_USERS_MOU");

				if (str_NIGHT_SUBS_USERS_MOU == null || str_NIGHT_SUBS_USERS_MOU.equals("")) {
					str_NIGHT_SUBS_USERS_MOU = "0";

				}
				int NIGHT_SUBS_USERS_MOU_int = Integer.parseInt(str_NIGHT_SUBS_USERS_MOU);

				// float NIGHT_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_NIGHT_SUBS_USERS_MOU);
				NIGHT_SUBS_USERS_MOU_gt += NIGHT_SUBS_USERS_MOU_int;
				ht.put("NIGHT_SUBS_USERS_MOU", "" + NIGHT_SUBS_USERS_MOU_int);
				logger.info("NIGHT_SUBS_USERS_MOU= " + NIGHT_SUBS_USERS_MOU_int);

				String str_NIGHT_NON_SUBS_USERS_MOU = rs.getString("NIGHT_NON_SUBS_USERS_MOU");

				if (str_NIGHT_NON_SUBS_USERS_MOU == null || str_NIGHT_NON_SUBS_USERS_MOU.equals("")) {
					str_NIGHT_NON_SUBS_USERS_MOU = "0";

				}
				int NIGHT_NON_SUBS_USERS_MOU_int = Integer.parseInt(str_NIGHT_NON_SUBS_USERS_MOU);

				// float NIGHT_NON_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_NIGHT_NON_SUBS_USERS_MOU);
				NIGHT_NON_SUBS_USERS_MOU_gt += NIGHT_NON_SUBS_USERS_MOU_int;
				ht.put("NIGHT_NON_SUBS_USERS_MOU", "" + NIGHT_NON_SUBS_USERS_MOU_int);
				logger.info("NIGHT_NON_SUBS_USERS_MOU= " + NIGHT_NON_SUBS_USERS_MOU_int);

				String str_NIGHT_TOTAL_PULSES = rs.getString("NIGHT_TOTAL_PULSES");

				if (str_NIGHT_TOTAL_PULSES == null || str_NIGHT_TOTAL_PULSES.equals("")) {
					str_NIGHT_TOTAL_PULSES = "0";

				}
				int NIGHT_TOTAL_PULSES_int = Integer.parseInt(str_NIGHT_TOTAL_PULSES);

				// float NIGHT_TOTAL_PULSES_float =
				// Float.parseFloat(str_NIGHT_TOTAL_PULSES);
				NIGHT_TOTAL_PULSES_gt += NIGHT_TOTAL_PULSES_int;
				ht.put("NIGHT_TOTAL_PULSES", "" + NIGHT_TOTAL_PULSES_int);
				logger.info("NIGHT_TOTAL_PULSES= " + NIGHT_TOTAL_PULSES_int);

				String str_NIGHT_SUBS_USERS_PULSES = rs.getString("NIGHT_SUBS_USERS_PULSES");

				if (str_NIGHT_SUBS_USERS_PULSES == null || str_NIGHT_SUBS_USERS_PULSES.equals("")) {
					str_NIGHT_SUBS_USERS_PULSES = "0";

				}
				int NIGHT_SUBS_USERS_PULSES_int = Integer.parseInt(str_NIGHT_SUBS_USERS_PULSES);

				// float NIGHT_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_NIGHT_SUBS_USERS_PULSES);
				NIGHT_SUBS_USERS_PULSES_gt += NIGHT_SUBS_USERS_PULSES_int;
				ht.put("NIGHT_SUBS_USERS_PULSES", "" + NIGHT_SUBS_USERS_PULSES_int);
				logger.info("NIGHT_SUBS_USERS_PULSES= " + NIGHT_SUBS_USERS_PULSES_int);

				String str_NIGHT_NON_SUBS_USERS_PULSES = rs.getString("NIGHT_NON_SUBS_USERS_PULSES");

				if (str_NIGHT_NON_SUBS_USERS_PULSES == null || str_NIGHT_NON_SUBS_USERS_PULSES.equals("")) {
					str_NIGHT_NON_SUBS_USERS_PULSES = "0";

				}
				int NIGHT_NON_SUBS_USERS_PULSES_int = Integer.parseInt(str_NIGHT_NON_SUBS_USERS_PULSES);

				// float NIGHT_NON_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_NIGHT_NON_SUBS_USERS_PULSES);
				NIGHT_NON_SUBS_USERS_PULSES_gt += NIGHT_NON_SUBS_USERS_PULSES_int;
				ht.put("NIGHT_NON_SUBS_USERS_PULSES", "" + NIGHT_NON_SUBS_USERS_PULSES_int);
				logger.info("NIGHT_NON_SUBS_USERS_PULSES= " + NIGHT_NON_SUBS_USERS_PULSES_int);

				String str_NIGHT_TOTAL_UNIQUE_CALLERS = rs.getString("NIGHT_TOTAL_UNIQUE_CALLERS");

				if (str_NIGHT_TOTAL_UNIQUE_CALLERS == null || str_NIGHT_TOTAL_UNIQUE_CALLERS.equals("")) {
					str_NIGHT_TOTAL_UNIQUE_CALLERS = "0";

				}
				int NIGHT_TOTAL_UNIQUE_CALLERS_int = Integer.parseInt(str_NIGHT_TOTAL_UNIQUE_CALLERS);

				// float NIGHT_TOTAL_UNIQUE_CALLERS_float =
				// Float.parseFloat(str_NIGHT_TOTAL_UNIQUE_CALLERS);
				// NIGHT_TOTAL_UNIQUE_CALLERS_gt +=
				// NIGHT_TOTAL_UNIQUE_CALLERS_int;
				ht.put("NIGHT_TOTAL_UNIQUE_CALLERS", "" + NIGHT_TOTAL_UNIQUE_CALLERS_int);
				logger.info("NIGHT_TOTAL_UNIQUE_CALLERS= " + NIGHT_TOTAL_UNIQUE_CALLERS_int);

				String str_NIGHT_UNIQUE_SUBS_CALLERS = rs.getString("NIGHT_UNIQUE_SUBS_CALLERS");

				if (str_NIGHT_UNIQUE_SUBS_CALLERS == null || str_NIGHT_UNIQUE_SUBS_CALLERS.equals("")) {
					str_NIGHT_UNIQUE_SUBS_CALLERS = "0";

				}
				int NIGHT_UNIQUE_SUBS_CALLERS_int = Integer.parseInt(str_NIGHT_UNIQUE_SUBS_CALLERS);
				ht.put("NIGHT_UNIQUE_SUBS_CALLERS", "" + NIGHT_UNIQUE_SUBS_CALLERS_int);
				logger.info("NIGHT_UNIQUE_SUBS_CALLERS= " + NIGHT_UNIQUE_SUBS_CALLERS_int);

				String str_NIGHT_UNIQUE_NON_SUBS_CALLERS = rs.getString("NIGHT_UNIQUE_NON_SUBS_CALLERS");
				if (str_NIGHT_UNIQUE_NON_SUBS_CALLERS == null || str_NIGHT_UNIQUE_NON_SUBS_CALLERS.equals("")) {
					str_NIGHT_UNIQUE_NON_SUBS_CALLERS = "0";
				}
				int NIGHT_UNIQUE_NON_SUBS_CALLERS_int = Integer.parseInt(str_NIGHT_UNIQUE_NON_SUBS_CALLERS);
				ht.put("NIGHT_UNIQUE_NON_SUBS_CALLERS", "" + NIGHT_UNIQUE_NON_SUBS_CALLERS_int);
				logger.info("NIGHT_UNIQUE_NON_SUBS_CALLERS= " + NIGHT_UNIQUE_NON_SUBS_CALLERS_int);

				int SUB1_REQ = rs.getInt("SUB1_REQ");
				if (rs.wasNull()) {
					SUB1_REQ = 0;
				}
				SUB1_REQ_gt += SUB1_REQ;
				ht.put("SUB1_REQ", "" + SUB1_REQ);

				int SUB2_REQ = rs.getInt("SUB2_REQ");
				if (rs.wasNull()) {
					SUB2_REQ = 0;
				}
				SUB2_REQ_gt += SUB2_REQ;
				ht.put("SUB2_REQ", "" + SUB2_REQ);

				int SUB3_REQ = rs.getInt("SUB3_REQ");
				if (rs.wasNull()) {
					SUB3_REQ = 0;
				}
				SUB3_REQ_gt += SUB3_REQ;
				ht.put("SUB3_REQ", "" + SUB3_REQ);

				int SUB1 = rs.getInt("SUB1");
				if (rs.wasNull()) {
					SUB1 = 0;
				}
				SUB1_gt += SUB1;
				ht.put("SUB1", "" + SUB1);

				int SUB2 = rs.getInt("SUB2");
				if (rs.wasNull()) {
					SUB2 = 0;
				}
				SUB2_gt += SUB2;
				ht.put("SUB2", "" + SUB2);

				int SUB3 = rs.getInt("SUB3");
				if (rs.wasNull()) {
					SUB3 = 0;
				}
				SUB3_gt += SUB3;
				ht.put("SUB3", "" + SUB3);

				int SUB4 = rs.getInt("SUB4");
				if (rs.wasNull()) {
					SUB4 = 0;
				}
				SUB4_gt += SUB4;
				ht.put("SUB4", "" + SUB4);

				int SUB5 = rs.getInt("SUB5");
				if (rs.wasNull()) {
					SUB5 = 0;
				}
				SUB5_gt += SUB5;
				ht.put("SUB5", "" + SUB5);

				int SUB6 = rs.getInt("SUB6");
				if (rs.wasNull()) {
					SUB6 = 0;
				}
				SUB6_gt += SUB6;
				ht.put("SUB6", "" + SUB6);

				int SUB7 = rs.getInt("SUB7");
				if (rs.wasNull()) {
					SUB7 = 0;
				}
				SUB7_gt += SUB7;
				ht.put("SUB7", "" + SUB7);

				int SUB8 = rs.getInt("SUB8");
				if (rs.wasNull()) {
					SUB8 = 0;
				}
				SUB8_gt += SUB8;
				ht.put("SUB8", "" + SUB8);

				int TOTAL_SUBS_REQ = rs.getInt("TOTAL_SUBS_REQ");
				if (rs.wasNull()) {
					TOTAL_SUBS_REQ = 0;
				}
				TOTAL_SUBS_REQ_gt += TOTAL_SUBS_REQ;
				ht.put("TOTAL_SUBS_REQ", "" + TOTAL_SUBS_REQ);

				int TOTAL_UNSUBS_REQ = rs.getInt("TOTAL_UNSUBS_REQ");
				if (rs.wasNull()) {
					TOTAL_UNSUBS_REQ = 0;
				}
				TOTAL_UNSUBS_REQ_gt += TOTAL_UNSUBS_REQ;
				ht.put("TOTAL_UNSUBS_REQ", "" + TOTAL_UNSUBS_REQ);

				int VOLUNTARY_UNSUBS = rs.getInt("VOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					VOLUNTARY_UNSUBS = 0;
				}
				VOLUNTARY_UNSUBS_gt += VOLUNTARY_UNSUBS;
				ht.put("VOLUNTARY_UNSUBS", "" + VOLUNTARY_UNSUBS);

				int INVOLUNTARY_UNSUBS = rs.getInt("INVOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					INVOLUNTARY_UNSUBS = 0;
				}
				INVOLUNTARY_UNSUBS_gt += INVOLUNTARY_UNSUBS;
				ht.put("INVOLUNTARY_UNSUBS", "" + INVOLUNTARY_UNSUBS);

				int GROSS_ADDS = rs.getInt("GROSS_ADDS");
				if (rs.wasNull()) {
					GROSS_ADDS = 0;
				}
				GROSS_ADDS_gt += GROSS_ADDS;
				ht.put("GROSS_ADDS", "" + GROSS_ADDS);

				int RESUB1 = rs.getInt("RESUB1");
				if (rs.wasNull()) {
					RESUB1 = 0;
				}
				RESUB1_gt += RESUB1;
				ht.put("RESUB1", "" + RESUB1);

				int RESUB2 = rs.getInt("RESUB2");
				if (rs.wasNull()) {
					RESUB2 = 0;
				}
				RESUB2_gt += RESUB2;
				ht.put("RESUB2", "" + RESUB2);

				int RESUB3 = rs.getInt("RESUB3");
				if (rs.wasNull()) {
					RESUB3 = 0;
				}
				RESUB3_gt += RESUB3;
				ht.put("RESUB3", "" + RESUB3);

				int RESUB4 = rs.getInt("RESUB4");
				if (rs.wasNull()) {
					RESUB4 = 0;
				}
				RESUB4_gt += RESUB4;
				ht.put("RESUB4", "" + RESUB4);

				int RESUB5 = rs.getInt("RESUB5");
				if (rs.wasNull()) {
					RESUB5 = 0;
				}
				RESUB5_gt += RESUB5;
				ht.put("RESUB5", "" + RESUB5);

				int RESUB6 = rs.getInt("RESUB6");
				if (rs.wasNull()) {
					RESUB6 = 0;
				}
				RESUB6_gt += RESUB6;
				ht.put("RESUB6", "" + RESUB6);

				int RESUB7 = rs.getInt("RESUB7");
				if (rs.wasNull()) {
					RESUB7 = 0;
				}
				RESUB7_gt += RESUB7;
				ht.put("RESUB7", "" + RESUB7);

				int RESUB8 = rs.getInt("RESUB8");
				if (rs.wasNull()) {
					RESUB8 = 0;
				}
				RESUB8_gt += RESUB8;
				ht.put("RESUB8", "" + RESUB8);

				int TOPUP1 = rs.getInt("TOPUP1");
				if (rs.wasNull()) {
					TOPUP1 = 0;
				}
				TOPUP1_gt += TOPUP1;
				ht.put("TOPUP1", "" + TOPUP1);

				int TOPUP2 = rs.getInt("TOPUP2");
				if (rs.wasNull()) {
					TOPUP2 = 0;
				}
				TOPUP2_gt += TOPUP2;
				ht.put("TOPUP2", "" + TOPUP2);

				int TOPUP3 = rs.getInt("TOPUP3");
				if (rs.wasNull()) {
					TOPUP3 = 0;
				}
				TOPUP3_gt += TOPUP3;
				ht.put("TOPUP3", "" + TOPUP3);

				String IVR_SUBS = rs.getString("IVR_SUBS");
				if (IVR_SUBS == null || IVR_SUBS.equals("")) {
					IVR_SUBS = "0";
				}
				int IVR_SUBS_int = Integer.parseInt(IVR_SUBS);
				IVR_SUBS_gt += IVR_SUBS_int;
				ht.put("IVR_SUBS", "" + IVR_SUBS_int);
				logger.info("IVR_SUBS= " + IVR_SUBS_int);

				String CCI_SUBS = rs.getString("CCI_SUBS");
				if (CCI_SUBS == null || CCI_SUBS.equals("")) {
					CCI_SUBS = "0";
				}
				int CCI_SUBS_int = Integer.parseInt(CCI_SUBS);
				CCI_SUBS_gt += CCI_SUBS_int;
				ht.put("CCI_SUBS", "" + CCI_SUBS_int);
				logger.info("CCI_SUBS= " + CCI_SUBS_int);

				String OBD_SUBS = rs.getString("OBD_SUBS");
				if (OBD_SUBS == null || OBD_SUBS.equals("")) {
					OBD_SUBS = "0";
				}
				int OBD_SUBS_int = Integer.parseInt(OBD_SUBS);
				OBD_SUBS_gt += OBD_SUBS_int;
				ht.put("OBD_SUBS", "" + OBD_SUBS_int);
				logger.info("OBD_SUBS= " + OBD_SUBS_int);

				String SMS_SUBS = rs.getString("SMS_SUBS");
				if (SMS_SUBS == null || SMS_SUBS.equals("")) {
					SMS_SUBS = "0";
				}
				int SMS_SUBS_int = Integer.parseInt(SMS_SUBS);
				SMS_SUBS_gt += SMS_SUBS_int;
				ht.put("SMS_SUBS", "" + SMS_SUBS_int);
				logger.info("SMS_SUBS= " + SMS_SUBS_int);

				String IBD_SUBS = rs.getString("IBD_SUBS");
				if (IBD_SUBS == null || IBD_SUBS.equals("")) {
					IBD_SUBS = "0";
				}
				int IBD_SUBS_int = Integer.parseInt(IBD_SUBS);
				IBD_SUBS_gt += IBD_SUBS_int;
				ht.put("IBD_SUBS", "" + IBD_SUBS_int);
				logger.info("IBD_SUBS= " + IBD_SUBS_int);

				String USSD_SUBS = rs.getString("USSD_SUBS");
				if (USSD_SUBS == null || USSD_SUBS.equals("")) {
					USSD_SUBS = "0";
				}
				int USSD_SUBS_int = Integer.parseInt(USSD_SUBS);
				USSD_SUBS_gt += USSD_SUBS_int;
				ht.put("USSD_SUBS", "" + USSD_SUBS_int);
				logger.info("USSD_SUBS= " + USSD_SUBS_int);

				String OTHERS_SUBS = rs.getString("OTHERS_SUBS");
				if (OTHERS_SUBS == null || OTHERS_SUBS.equals("")) {
					OTHERS_SUBS = "0";
				}
				int OTHERS_SUBS_int = Integer.parseInt(OTHERS_SUBS);
				OTHERS_SUBS_gt += OTHERS_SUBS_int;
				ht.put("OTHERS_SUBS", "" + OTHERS_SUBS_int);
				logger.info("OTHERS_SUBS= " + OTHERS_SUBS_int);

				String IVR_UNSUBS = rs.getString("IVR_UNSUBS");
				if (IVR_UNSUBS == null || IVR_UNSUBS.equals("")) {
					IVR_UNSUBS = "0";
				}
				int IVR_UNSUBS_int = Integer.parseInt(IVR_UNSUBS);
				IVR_UNSUBS_gt += IVR_UNSUBS_int;
				ht.put("IVR_UNSUBS", "" + IVR_UNSUBS_int);
				logger.info("IVR_UNSUBS= " + IVR_UNSUBS_int);

				String CCI_UNSUBS = rs.getString("CCI_UNSUBS");
				if (CCI_UNSUBS == null || CCI_UNSUBS.equals("")) {
					CCI_UNSUBS = "0";
				}
				int CCI_UNSUBS_int = Integer.parseInt(CCI_UNSUBS);
				CCI_UNSUBS_gt += CCI_UNSUBS_int;
				ht.put("CCI_UNSUBS", "" + CCI_UNSUBS_int);
				logger.info("CCI_UNSUBS= " + CCI_UNSUBS_int);

				long USSD_UNSUBS = rs.getInt("USSD_UNSUBS");
				if (rs.wasNull()) {
					USSD_UNSUBS = 0;
				}
				USSD_UNSUBS_gt += USSD_UNSUBS;
				ht.put("USSD_UNSUBS", "" + USSD_UNSUBS);

				String SMS_UNSUBS = rs.getString("SMS_UNSUBS");
				if (SMS_UNSUBS == null || SMS_UNSUBS.equals("")) {
					SMS_UNSUBS = "0";
				}
				int SMS_UNSUBS_int = Integer.parseInt(SMS_UNSUBS);
				SMS_UNSUBS_gt += SMS_UNSUBS_int;
				ht.put("SMS_UNSUBS", "" + SMS_UNSUBS_int);
				logger.info("SMS_UNSUBS= " + SMS_UNSUBS_int);

				String OTHER_UNSUBS = rs.getString("OTHERS_UNSUBS");
				if (rs.wasNull()) {
					OTHER_UNSUBS = "0";
				}
				OTHER_UNSUBS_gt += Long.parseLong(OTHER_UNSUBS);
				ht.put("OTHER_UNSUBS", "" + Long.parseLong(OTHER_UNSUBS));
				logger.info("OTHER_UNSUBS= " + Long.parseLong(OTHER_UNSUBS));

				String IVR_DWLD = rs.getString("IVR_DWLD");
				if (IVR_DWLD == null || IVR_DWLD.equals("")) {
					IVR_DWLD = "0";
				}
				int IVR_DWLD_int = Integer.parseInt(IVR_DWLD);
				IVR_DWLD_gt += IVR_DWLD_int;
				ht.put("IVR_DWLD", "" + IVR_DWLD_int);
				logger.info("IVR_DWLD= " + IVR_DWLD_int);

				String OBD_DWLD = rs.getString("OBD_DWLD");
				if (OBD_DWLD == null || OBD_DWLD.equals("")) {
					OBD_DWLD = "0";
				}
				int OBD_DWLD_int = Integer.parseInt(OBD_DWLD);
				OBD_DWLD_gt += OBD_DWLD_int;
				ht.put("OBD_DWLD", "" + OBD_DWLD_int);
				logger.info("OBD_DWLD= " + OBD_DWLD_int);

				String CCI_DWLD = rs.getString("CCI_DWLD");
				if (CCI_DWLD == null || CCI_DWLD.equals("")) {
					CCI_DWLD = "0";
				}
				int CCI_DWLD_int = Integer.parseInt(CCI_DWLD);
				CCI_DWLD_gt += CCI_DWLD_int;
				ht.put("CCI_DWLD", "" + CCI_DWLD_int);
				logger.info("CCI_DWLD= " + CCI_DWLD_int);

				String SMS_DWLD = rs.getString("SMS_DWLD");
				if (SMS_DWLD == null || SMS_DWLD.equals("")) {
					SMS_DWLD = "0";
				}
				int SMS_DWLD_int = Integer.parseInt(SMS_DWLD);
				SMS_DWLD_gt += SMS_DWLD_int;
				ht.put("SMS_DWLD", "" + SMS_DWLD_int);
				logger.info("SMS_DWLD= " + SMS_DWLD_int);

				String OTHERS_DWLD = rs.getString("OTHERS_DWLD");
				if (rs.wasNull()) {
					OTHERS_DWLD = "0";
				}
				OTHERS_DWLD_gt += Long.parseLong(OTHERS_DWLD);
				ht.put("OTHERS_DWLD", "" + Long.parseLong(OTHERS_DWLD));
				logger.info("OTHERS_DWLD= " + Long.parseLong(OTHERS_DWLD));

				String ON_NET_DED = rs.getString("ON_NET_DED");
				if (ON_NET_DED == null || ON_NET_DED.equals("")) {
					ON_NET_DED = "0";
				}
				int ON_NET_DED_int = Integer.parseInt(ON_NET_DED);
				ON_NET_DED_gt += ON_NET_DED_int;
				ht.put("ON_NET_DED", "" + ON_NET_DED_int);
				logger.info("ON_NET_DED= " + ON_NET_DED_int);

				String OFF_NET_DED = rs.getString("OFF_NET_DED");
				if (OFF_NET_DED == null || OFF_NET_DED.equals("")) {
					OFF_NET_DED = "0";
				}
				int OFF_NET_DED_int = Integer.parseInt(OFF_NET_DED);
				OFF_NET_DED_gt += OFF_NET_DED_int;
				ht.put("OFF_NET_DED", "" + OFF_NET_DED_int);
				logger.info("OFF_NET_DED= " + OFF_NET_DED_int);

				String TOTAL_DED = rs.getString("TOTAL_DED");
				if (TOTAL_DED == null || TOTAL_DED.equals("")) {
					TOTAL_DED = "0";
				}
				float TOTAL_DED_float = Float.parseFloat(TOTAL_DED);
				TOTAL_DED_gt += TOTAL_DED_float;
				ht.put("TOTAL_DED", "" + TOTAL_DED_float);
				logger.info("TOTAL_DED= " + TOTAL_DED_float);

				String DOWNLOADS = rs.getString("DOWNLOADS");
				if (DOWNLOADS == null || DOWNLOADS.equals("")) {
					DOWNLOADS = "0";
				}
				float DOWNLOADS_float = Float.parseFloat(DOWNLOADS);
				DOWNLOADS_gt += DOWNLOADS_float;
				ht.put("DOWNLOADS", "" + DOWNLOADS_float);
				logger.info("DOWNLOADS= " + DOWNLOADS_float);

				String CRBT_TONE_DOWNLOAD = rs.getString("CRBT_TONE_DOWNLOAD");
				if (CRBT_TONE_DOWNLOAD == null || CRBT_TONE_DOWNLOAD.equals("")) {
					CRBT_TONE_DOWNLOAD = "0";
				}
				float CRBT_TONE_DOWNLOAD_float = Float.parseFloat(CRBT_TONE_DOWNLOAD);
				CRBT_TONE_DOWNLOAD_gt += CRBT_TONE_DOWNLOAD_float;
				ht.put("CRBT_TONE_DOWNLOAD", "" + CRBT_TONE_DOWNLOAD_float);
				logger.info("CRBT_TONE_DOWNLOAD= " + CRBT_TONE_DOWNLOAD_float);

				float BROWSING_REVENUE = rs.getFloat("BROWSING_REVENUE");
				if (rs.wasNull()) {
					BROWSING_REVENUE = 0;
				}
				BROWSING_REVENUE_gt += BROWSING_REVENUE;
				ht.put("BROWSING_REVENUE", "" + BROWSING_REVENUE);

				float SUB1_REVENUE = rs.getFloat("SUB1_REVENUE");
				if (rs.wasNull()) {
					SUB1_REVENUE = 0;
				}
				SUB1_REVENUE_gt += SUB1_REVENUE;
				ht.put("SUB1_REVENUE", "" + SUB1_REVENUE);

				float SUB2_REVENUE = rs.getFloat("SUB2_REVENUE");
				if (rs.wasNull()) {
					SUB2_REVENUE = 0;
				}
				SUB2_REVENUE_gt += SUB2_REVENUE;
				ht.put("SUB2_REVENUE", "" + SUB2_REVENUE);

				float SUB3_REVENUE = rs.getFloat("SUB3_REVENUE");
				if (rs.wasNull()) {
					SUB3_REVENUE = 0;
				}
				SUB3_REVENUE_gt += SUB3_REVENUE;
				ht.put("SUB3_REVENUE", "" + SUB3_REVENUE);

				float SUB4_REVENUE = rs.getFloat("SUB4_REVENUE");
				if (rs.wasNull()) {
					SUB4_REVENUE = 0;
				}
				SUB4_REVENUE_gt += SUB4_REVENUE;
				ht.put("SUB4_REVENUE", "" + SUB4_REVENUE);

				float SUB5_REVENUE = rs.getFloat("SUB5_REVENUE");
				if (rs.wasNull()) {
					SUB5_REVENUE = 0;
				}
				SUB5_REVENUE_gt += SUB5_REVENUE;
				ht.put("SUB5_REVENUE", "" + SUB5_REVENUE);

				float SUB6_REVENUE = rs.getFloat("SUB6_REVENUE");
				if (rs.wasNull()) {
					SUB6_REVENUE = 0;
				}
				SUB6_REVENUE_gt += SUB6_REVENUE;
				ht.put("SUB6_REVENUE", "" + SUB6_REVENUE);

				float SUB7_REVENUE = rs.getFloat("SUB7_REVENUE");
				if (rs.wasNull()) {
					SUB7_REVENUE = 0;
				}
				SUB7_REVENUE_gt += SUB7_REVENUE;
				ht.put("SUB7_REVENUE", "" + SUB7_REVENUE);

				float SUB8_REVENUE = rs.getFloat("SUB8_REVENUE");
				if (rs.wasNull()) {
					SUB8_REVENUE = 0;
				}
				SUB8_REVENUE_gt += SUB8_REVENUE;
				ht.put("SUB8_REVENUE", "" + SUB8_REVENUE);

				float TOPUP1_REVENUE = rs.getFloat("TOPUP1_REVENUE");
				if (rs.wasNull()) {
					TOPUP1_REVENUE = 0;
				}
				TOPUP1_REVENUE_gt += TOPUP1_REVENUE;
				ht.put("TOPUP1_REVENUE", "" + TOPUP1_REVENUE);

				float TOPUP2_REVENUE = rs.getFloat("TOPUP2_REVENUE");
				if (rs.wasNull()) {
					TOPUP2_REVENUE = 0;
				}
				TOPUP2_REVENUE_gt += TOPUP2_REVENUE;
				ht.put("TOPUP2_REVENUE", "" + TOPUP2_REVENUE);

				float TOPUP3_REVENUE = rs.getFloat("TOPUP3_REVENUE");
				if (rs.wasNull()) {
					TOPUP3_REVENUE = 0;
				}
				TOPUP3_REVENUE_gt += TOPUP3_REVENUE;
				ht.put("TOPUP3_REVENUE", "" + TOPUP3_REVENUE);

				float DOWNLOAD_REVENUE = rs.getFloat("DOWNLOAD_REVENUE");
				if (rs.wasNull()) {
					DOWNLOAD_REVENUE = 0;
				}
				DOWNLOAD_REVENUE_gt += DOWNLOAD_REVENUE;
				ht.put("DOWNLOAD_REVENUE", "" + DOWNLOAD_REVENUE);

				float DEDICATION_REVENUE = rs.getFloat("DEDICATION_REVENUE");
				if (rs.wasNull()) {
					DEDICATION_REVENUE = 0;
				}
				DEDICATION_REVENUE_gt += DEDICATION_REVENUE;
				ht.put("DEDICATION_REVENUE", "" + DEDICATION_REVENUE);

				float GROSS_REVENUE_LOCAL = rs.getFloat("GROSS_REVENUE_LOCAL");
				if (rs.wasNull()) {
					GROSS_REVENUE_LOCAL = 0;
				}
				GROSS_REVENUE_LOCAL_gt += GROSS_REVENUE_LOCAL;
				ht.put("GROSS_REVENUE_LOCAL", "" + GROSS_REVENUE_LOCAL);

				float GROSS_REVENUE_USD = rs.getFloat("GROSS_REVENUE_USD");
				if (rs.wasNull()) {
					GROSS_REVENUE_USD = 0;
				}
				GROSS_REVENUE_USD_gt += GROSS_REVENUE_USD;
				ht.put("GROSS_REVENUE_USD", "" + GROSS_REVENUE_USD);

				int ACTIVE_SUBSCRIBERS = rs.getInt("ACTIVE_SUBSCRIBERS");
				if (rs.wasNull()) {
					ACTIVE_SUBSCRIBERS = 0;
				}
				ACTIVE_SUBSCRIBERS_gt = ACTIVE_SUBSCRIBERS;
				ht.put("ACTIVE_SUBSCRIBERS", "" + ACTIVE_SUBSCRIBERS);

				String str_BILLED_SUBSCRIBERS = rs.getString("BILLED_SUBSCRIBERS");
				if (str_BILLED_SUBSCRIBERS == null || str_BILLED_SUBSCRIBERS.equals("")) {
					str_BILLED_SUBSCRIBERS = "0";
				}
				int BILLED_SUBSCRIBERS_int = Integer.parseInt(str_BILLED_SUBSCRIBERS);
				BILLED_SUBSCRIBERS_gt += BILLED_SUBSCRIBERS_int;
				ht.put("BILLED_SUBSCRIBERS", "" + BILLED_SUBSCRIBERS_int);
				logger.info("BILLED_SUBSCRIBERS= " + BILLED_SUBSCRIBERS_int);

				String str_CALLING_SUBSCRIBERS = rs.getString("CALLING_SUBSCRIBERS");

				if (str_CALLING_SUBSCRIBERS == null || str_CALLING_SUBSCRIBERS.equals("")) {
					str_CALLING_SUBSCRIBERS = "0";

				}
				int CALLING_SUBSCRIBERS_int = Integer.parseInt(str_CALLING_SUBSCRIBERS);

				// float CALLING_SUBSCRIBERS_float =
				// Float.parseFloat(str_CALLING_SUBSCRIBERS);
				CALLING_SUBSCRIBERS_gt = CALLING_SUBSCRIBERS_int;
				ht.put("CALLING_SUBSCRIBERS", "" + CALLING_SUBSCRIBERS_int);
				logger.info("CALLING_SUBSCRIBERS= " + CALLING_SUBSCRIBERS_int);

				float AVG_CALL_UNIQUE = rs.getFloat("AVG_CALL_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_CALL_UNIQUE_gt += AVG_CALL_UNIQUE;
				ht.put("AVG_CALL_UNIQUE", "" + AVG_CALL_UNIQUE);
				logger.info("AVG_CALL_UNIQUE= " + AVG_CALL_UNIQUE);

				float AVG_MOU_UNIQUE = rs.getFloat("AVG_MOU_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_MOU_UNIQUE_gt += AVG_MOU_UNIQUE;
				ht.put("AVG_MOU_UNIQUE", "" + AVG_MOU_UNIQUE);
				logger.info("AVG_MOU_UNIQUE= " + AVG_MOU_UNIQUE);

				float AVG_MOU_CALL = rs.getFloat("AVG_MOU_CALL");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_MOU_CALL_gt += AVG_MOU_CALL;
				ht.put("AVG_MOU_CALL", "" + AVG_MOU_CALL);
				logger.info("AVG_MOU_CALL= " + AVG_MOU_CALL);

				float AVG_DWLD_UNIQUE = rs.getFloat("AVG_DWLD_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_DWLD_UNIQUE_gt += AVG_DWLD_UNIQUE;
				ht.put("AVG_DWLD_UNIQUE", "" + AVG_DWLD_UNIQUE);
				logger.info("AVG_DWLD_UNIQUE= " + AVG_DWLD_UNIQUE);

				float AVG_DED_UNIQUE = rs.getFloat("AVG_DED_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_DED_UNIQUE_gt += AVG_DED_UNIQUE;
				ht.put("AVG_DED_UNIQUE", "" + AVG_DED_UNIQUE);
				logger.info("AVG_DED_UNIQUE= " + AVG_DED_UNIQUE);

				float AVG_RBT_UNIQUE = rs.getFloat("AVG_RBT_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_RBT_UNIQUE_gt += AVG_RBT_UNIQUE;
				ht.put("AVG_RBT_UNIQUE", "" + AVG_RBT_UNIQUE);
				logger.info("AVG_RBT_UNIQUE= " + AVG_RBT_UNIQUE);

				float UNIQUE_CALLER_ACTIVE = rs.getFloat("UNIQUE_CALLER_ACTIVE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// UNIQUE_CALLER_ACTIVE_gt += UNIQUE_CALLER_ACTIVE;
				ht.put("UNIQUE_CALLER_ACTIVE", "" + UNIQUE_CALLER_ACTIVE);
				logger.info("UNIQUE_CALLER_ACTIVE= " + UNIQUE_CALLER_ACTIVE);

				float SERVICE_PENETRATION = rs.getFloat("SERVICE_PENETRATION");
				// float HR0_float = Float.parseFloat(str_HR0);
				// SERVICE_PENETRATION_gt += SERVICE_PENETRATION;
				ht.put("SERVICE_PENETRATION", "" + SERVICE_PENETRATION);
				logger.info("SERVICE_PENETRATION= " + SERVICE_PENETRATION);

				float ARPU = rs.getFloat("ARPU");
				// float HR0_float = Float.parseFloat(str_HR0);
				ARPU_gt += ARPU;
				ht.put("ARPU", "" + ARPU);
				logger.info("ARPU= " + ARPU);

				String str_ACTIVE_TO_GRACE = rs.getString("ACTIVE_TO_GRACE");

				if (str_ACTIVE_TO_GRACE == null || str_ACTIVE_TO_GRACE.equals("")) {
					str_ACTIVE_TO_GRACE = "0";

				}
				int ACTIVE_TO_GRACE_int = Integer.parseInt(str_ACTIVE_TO_GRACE);

				// float ACTIVE_TO_GRACE_float =
				// Float.parseFloat(str_ACTIVE_TO_GRACE);
				ACTIVE_TO_GRACE_gt = ACTIVE_TO_GRACE_int;
				ht.put("ACTIVE_TO_GRACE", "" + ACTIVE_TO_GRACE_int);
				logger.info("ACTIVE_TO_GRACE= " + ACTIVE_TO_GRACE_int);

				String str_GRACE_TO_ACTIVE = rs.getString("GRACE_TO_ACTIVE");

				if (str_GRACE_TO_ACTIVE == null || str_GRACE_TO_ACTIVE.equals("")) {
					str_GRACE_TO_ACTIVE = "0";

				}
				int GRACE_TO_ACTIVE_int = Integer.parseInt(str_GRACE_TO_ACTIVE);

				// float GRACE_TO_ACTIVE_float =
				// Float.parseFloat(str_GRACE_TO_ACTIVE);
				GRACE_TO_ACTIVE_gt = GRACE_TO_ACTIVE_int;
				ht.put("GRACE_TO_ACTIVE", "" + GRACE_TO_ACTIVE_int);
				logger.info("GRACE_TO_ACTIVE= " + GRACE_TO_ACTIVE_int);

				String str_GRACE1TO7 = rs.getString("GRACE1TO7");

				if (str_GRACE1TO7 == null || str_GRACE1TO7.equals("")) {
					str_GRACE1TO7 = "0";

				}
				int GRACE1TO7_int = Integer.parseInt(str_GRACE1TO7);

				// float GRACE1TO7_float = Float.parseFloat(str_GRACE1TO7);
				GRACE1TO7_gt = GRACE1TO7_int;
				ht.put("GRACE1TO7", "" + GRACE1TO7_int);
				logger.info("GRACE1TO7= " + GRACE1TO7_int);

				String str_GRACE8TO14 = rs.getString("GRACE8TO14");

				if (str_GRACE8TO14 == null || str_GRACE8TO14.equals("")) {
					str_GRACE8TO14 = "0";

				}
				int GRACE8TO14_int = Integer.parseInt(str_GRACE8TO14);

				// float GRACE8TO14_float = Float.parseFloat(str_GRACE8TO14);
				GRACE8TO14_gt = GRACE8TO14_int;
				ht.put("GRACE8TO14", "" + GRACE8TO14_int);
				logger.info("GRACE8TO14= " + GRACE8TO14_int);

				String str_GRACE14TO21 = rs.getString("GRACE14TO21");

				if (str_GRACE14TO21 == null || str_GRACE14TO21.equals("")) {
					str_GRACE14TO21 = "0";

				}
				int GRACE14TO21_int = Integer.parseInt(str_GRACE14TO21);

				// float GRACE14TO21_float = Float.parseFloat(str_GRACE14TO21);
				GRACE14TO21_gt = GRACE14TO21_int;
				ht.put("GRACE14TO21", "" + GRACE14TO21_int);
				logger.info("GRACE14TO21= " + GRACE14TO21_int);

				String str_GRACE22TO30 = rs.getString("GRACE22TO30");

				if (str_GRACE22TO30 == null || str_GRACE22TO30.equals("")) {
					str_GRACE22TO30 = "0";

				}
				int GRACE22TO30_int = Integer.parseInt(str_GRACE22TO30);

				// float GRACE22TO30_float = Float.parseFloat(str_GRACE22TO30);
				GRACE22TO30_gt = GRACE22TO30_int;
				ht.put("GRACE22TO30", "" + GRACE22TO30_int);
				logger.info("GRACE22TO30= " + GRACE22TO30_int);

				String str_MIN1 = rs.getString("MIN1");

				if (str_MIN1 == null || str_MIN1.equals("")) {
					str_MIN1 = "0";

				}
				int MIN1_int = Integer.parseInt(str_MIN1);

				// float MIN1_float = Float.parseFloat(str_MIN1);
				MIN1_gt += MIN1_int;
				ht.put("MIN1", "" + MIN1_int);
				logger.info("MIN1= " + MIN1_int);

				String str_MIN2 = rs.getString("MIN2");

				if (str_MIN2 == null || str_MIN2.equals("")) {
					str_MIN2 = "0";

				}
				int MIN2_int = Integer.parseInt(str_MIN2);

				// float MIN2_float = Float.parseFloat(str_MIN2);
				MIN2_gt += MIN2_int;
				ht.put("MIN2", "" + MIN2_int);
				logger.info("MIN2= " + MIN2_int);

				String str_MIN3 = rs.getString("MIN3");

				if (str_MIN3 == null || str_MIN3.equals("")) {
					str_MIN3 = "0";

				}
				int MIN3_int = Integer.parseInt(str_MIN3);

				// float MIN3_float = Float.parseFloat(str_MIN3);
				MIN3_gt += MIN3_int;
				ht.put("MIN3", "" + MIN3_int);
				logger.info("MIN3= " + MIN3_int);

				String str_MIN4 = rs.getString("MIN4");

				if (str_MIN4 == null || str_MIN4.equals("")) {
					str_MIN4 = "0";

				}
				int MIN4_int = Integer.parseInt(str_MIN4);

				// float MIN4_float = Float.parseFloat(str_MIN4);
				MIN4_gt += MIN4_int;
				ht.put("MIN4", "" + MIN4_int);
				logger.info("MIN4= " + MIN4_int);

				String str_MIN5 = rs.getString("MIN5");

				if (str_MIN5 == null || str_MIN5.equals("")) {
					str_MIN5 = "0";

				}
				int MIN5_int = Integer.parseInt(str_MIN5);

				// float MIN5_float = Float.parseFloat(str_MIN5);
				MIN5_gt += MIN5_int;
				ht.put("MIN5", "" + MIN5_int);
				logger.info("MIN5= " + MIN5_int);

				String str_MIN6 = rs.getString("MIN6");

				if (str_MIN6 == null || str_MIN6.equals("")) {
					str_MIN6 = "0";

				}
				int MIN6_int = Integer.parseInt(str_MIN6);

				// float MIN6_float = Float.parseFloat(str_MIN6);
				MIN6_gt += MIN6_int;
				ht.put("MIN6", "" + MIN6_int);
				logger.info("MIN6= " + MIN6_int);

				String str_MIN7 = rs.getString("MIN7");

				if (str_MIN7 == null || str_MIN7.equals("")) {
					str_MIN7 = "0";

				}
				int MIN7_int = Integer.parseInt(str_MIN7);

				// float MIN7_float = Float.parseFloat(str_MIN7);
				MIN7_gt += MIN7_int;
				ht.put("MIN7", "" + MIN7_int);
				logger.info("MIN7= " + MIN7_int);

				String str_MIN8 = rs.getString("MIN8");

				if (str_MIN8 == null || str_MIN8.equals("")) {
					str_MIN8 = "0";

				}
				int MIN8_int = Integer.parseInt(str_MIN8);

				// float MIN8_float = Float.parseFloat(str_MIN8);
				MIN8_gt += MIN8_int;
				ht.put("MIN8", "" + MIN8_int);
				logger.info("MIN8= " + MIN8_int);

				String str_MIN9 = rs.getString("MIN9");

				if (str_MIN9 == null || str_MIN9.equals("")) {
					str_MIN9 = "0";

				}
				int MIN9_int = Integer.parseInt(str_MIN9);

				// float MIN9_float = Float.parseFloat(str_MIN9);
				MIN9_gt += MIN9_int;
				ht.put("MIN9", "" + MIN9_int);
				logger.info("MIN9= " + MIN9_int);

				String str_MIN10 = rs.getString("MIN10");

				if (str_MIN10 == null || str_MIN10.equals("")) {
					str_MIN10 = "0";

				}
				int MIN10_int = Integer.parseInt(str_MIN10);

				// float MIN10_float = Float.parseFloat(str_MIN10);
				MIN10_gt += MIN10_int;
				ht.put("MIN10", "" + MIN10_int);
				logger.info("MIN10= " + MIN10_int);

				String str_MIN10ABOVE = rs.getString("MIN10ABOVE");

				if (str_MIN10ABOVE == null || str_MIN10ABOVE.equals("")) {
					str_MIN10ABOVE = "0";

				}
				int MIN10ABOVE_int = Integer.parseInt(str_MIN10ABOVE);

				// float MIN10ABOVE_float = Float.parseFloat(str_MIN10ABOVE);
				MIN10ABOVE_gt += MIN10ABOVE_int;
				ht.put("MIN10ABOVE", "" + MIN10ABOVE_int);
				logger.info("MIN10ABOVE= " + MIN10ABOVE_int);

				float HR0 = rs.getFloat("HR0");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR0_gt += HR0;
				ht.put("HR0", "" + HR0);
				logger.info("HR0= " + HR0);

				float HR1 = rs.getFloat("HR1");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR1_gt += HR1;
				ht.put("HR1", "" + HR1);
				logger.info("HR1= " + HR1);

				float HR2 = rs.getFloat("HR2");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR2_gt += HR2;
				ht.put("HR2", "" + HR2);
				logger.info("HR2= " + HR2);

				float HR3 = rs.getFloat("HR3");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR3_gt += HR3;
				ht.put("HR3", "" + HR3);
				logger.info("HR3= " + HR3);

				float HR4 = rs.getFloat("HR4");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR4_gt += HR4;
				ht.put("HR4", "" + HR4);
				logger.info("HR4= " + HR4);

				float HR5 = rs.getFloat("HR5");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR5_gt += HR5;
				ht.put("HR5", "" + HR5);
				logger.info("HR5= " + HR5);

				float HR6 = rs.getFloat("HR6");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR6_gt += HR6;
				ht.put("HR6", "" + HR6);
				logger.info("HR6= " + HR6);

				float HR7 = rs.getFloat("HR7");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR7_gt += HR7;
				ht.put("HR7", "" + HR7);
				logger.info("HR7= " + HR7);

				float HR8 = rs.getFloat("HR8");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR8_gt += HR8;
				ht.put("HR8", "" + HR8);
				logger.info("HR8= " + HR8);

				float HR9 = rs.getFloat("HR9");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR9_gt += HR9;
				ht.put("HR9", "" + HR9);
				logger.info("HR9= " + HR9);

				float HR10 = rs.getFloat("HR10");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR10_gt += HR10;
				ht.put("HR10", "" + HR10);
				logger.info("HR10= " + HR10);

				float HR11 = rs.getFloat("HR11");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR11_gt += HR11;
				ht.put("HR11", "" + HR11);
				logger.info("HR11= " + HR11);

				float HR12 = rs.getFloat("HR12");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR12_gt += HR12;
				ht.put("HR12", "" + HR12);
				logger.info("HR12= " + HR12);

				float HR13 = rs.getFloat("HR13");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR13_gt += HR13;
				ht.put("HR13", "" + HR13);
				logger.info("HR13= " + HR13);

				float HR14 = rs.getFloat("HR14");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR14_gt += HR14;
				ht.put("HR14", "" + HR14);
				logger.info("HR14= " + HR14);

				float HR15 = rs.getFloat("HR15");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR15_gt += HR15;
				ht.put("HR15", "" + HR15);
				logger.info("HR15= " + HR15);

				float HR16 = rs.getFloat("HR16");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR16_gt += HR16;
				ht.put("HR16", "" + HR16);
				logger.info("HR16= " + HR16);

				float HR17 = rs.getFloat("HR17");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR17_gt += HR17;
				ht.put("HR17", "" + HR17);
				logger.info("HR17= " + HR17);

				float HR18 = rs.getFloat("HR18");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR18_gt += HR18;
				ht.put("HR18", "" + HR18);
				logger.info("HR18= " + HR18);

				float HR19 = rs.getFloat("HR19");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR19_gt += HR19;
				ht.put("HR19", "" + HR19);
				logger.info("HR19= " + HR19);

				float HR20 = rs.getFloat("HR20");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR20_gt += HR20;
				ht.put("HR20", "" + HR20);
				logger.info("HR20= " + HR20);

				float HR21 = rs.getFloat("HR21");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR21_gt += HR21;
				ht.put("HR21", "" + HR21);
				logger.info("HR21= " + HR21);

				float HR22 = rs.getFloat("HR22");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR22_gt += HR22;
				ht.put("HR22", "" + HR22);
				logger.info("HR22= " + HR22);

				float HR23 = rs.getFloat("HR23");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR23_gt += HR23;
				ht.put("HR23", "" + HR23);
				logger.info("HR23= " + HR23);

				revenueData.add(ht);
			}

			if (count > 0) {
				logger.info("count::" + count);

				// Average MOU/Unique Caller
				try {
					AVG_MOU_UNIQUE_gt = (float) (MRADIO_TOTAL_MOUS_gt / MRADIO_TOTAL_UNIQUE_CALLERS_gt);
				} catch (Exception e) {
					AVG_MOU_UNIQUE_gt = 0;
				}

				// Average MOU/Call
				try {
					AVG_MOU_CALL_gt = (float) (MRADIO_TOTAL_MOUS_gt / MRADIO_TOTAL_CALLS_gt);
				} catch (Exception e) {
					AVG_MOU_CALL_gt = 0;
				}

				try {
					AVG_DWLD_UNIQUE_gt = (float) (DOWNLOAD_REVENUE_gt / MRADIO_TOTAL_UNIQUE_CALLERS_gt);
				} catch (Exception e) {
					AVG_DWLD_UNIQUE_gt = 0;
				}

				// Average MOU/Unique Caller
				try {
					AVG_DED_UNIQUE_gt = (float) (TOTAL_DED_gt / MRADIO_TOTAL_UNIQUE_CALLERS_gt);
				} catch (Exception e) {
					AVG_DED_UNIQUE_gt = 0;
				}

				// Average MOU/Call
				try {
					AVG_RBT_UNIQUE_gt = (float) (CRBT_TONE_DOWNLOAD_gt / MRADIO_TOTAL_UNIQUE_CALLERS_gt);
				} catch (Exception e) {
				}

				// Unique caller/Active subscribers in the system
				try {
					UNIQUE_CALLER_ACTIVE_gt = (float) (MRADIO_TOTAL_UNIQUE_CALLERS_gt / ACTIVE_SUBSCRIBERS_gt);
				} catch (Exception e) {
				}

				// logger.info("UNIQUE_CALLER_ACTIVE_gt::"+UNIQUE_CALLER_ACTIVE_gt);
				// Service penetration(in %)
				try {
					SERVICE_PENETRATION_gt = (float) (ACTIVE_SUBSCRIBERS_gt * 100 / operatorbase);
				} catch (Exception e) {
				}
				// logger.info("SERVICE_PENETRATION_gt::"+SERVICE_PENETRATION_gt);

				// Service penetration(in %)
				try {
					ARPU_gt = (float) (GROSS_REVENUE_LOCAL_gt / ACTIVE_SUBSCRIBERS_gt);
				} catch (Exception e) {
				}

				HR0_gt = "-";
				HR1_gt = "-";
				HR2_gt = "-";
				HR3_gt = "-";
				HR4_gt = "-";
				HR5_gt = "-";
				HR6_gt = "-";
				HR7_gt = "-";
				HR8_gt = "-";
				HR9_gt = "-";
				HR10_gt = "-";
				HR11_gt = "-";
				HR12_gt = "-";
				HR13_gt = "-";
				HR14_gt = "-";
				HR15_gt = "-";
				HR16_gt = "-";
				HR17_gt = "-";
				HR18_gt = "-";
				HR19_gt = "-";
				HR20_gt = "-";
				HR21_gt = "-";
				HR22_gt = "-";
				HR23_gt = "-";

			}

			HashMap<String, String> ht = new HashMap<String, String>();
			ht.put("DATE_TIME", "Total");
			ht.put("MRADIO_TOTAL_CALLS", "" + MRADIO_TOTAL_CALLS_gt);
			ht.put("MRADIO_SUBS_USERS_CALLS", "" + MRADIO_SUBS_USERS_CALLS_gt);
			ht.put("MRADIO_NON_SUBS_USERS_CALLS", "" + MRADIO_NON_SUBS_USERS_CALLS_gt);
			ht.put("MRADIO_TOTAL_MOUS", "" + MRADIO_TOTAL_MOUS_gt);
			ht.put("MRADIO_SUBS_USERS_MOU", "" + MRADIO_SUBS_USERS_MOU_gt);
			ht.put("MRADIO_NON_SUBS_USERS_MOU", "" + MRADIO_NON_SUBS_USERS_MOU_gt);
			ht.put("MRADIO_TOTAL_PULSES", "" + MRADIO_TOTAL_PULSES_gt);
			ht.put("MRADIO_SUBS_USERS_PULSES", "" + MRADIO_SUBS_USERS_PULSES_gt);
			ht.put("MRADIO_NON_SUBS_USERS_PULSES", "" + MRADIO_NON_SUBS_USERS_PULSES_gt);
			ht.put("MRADIO_TOTAL_UNIQUE_CALLERS", "" + MRADIO_TOTAL_UNIQUE_CALLERS_gt);
			ht.put("MRADIO_UNIQUE_SUBS_CALLERS", "" + MRADIO_UNIQUE_SUBS_CALLERS_gt);
			ht.put("MRADIO_UNIQUE_NON_SUBS_CALLERS", "" + MRADIO_UNIQUE_NON_SUBS_CALLERS_gt);
			ht.put("DAY_TOTAL_CALLS", "" + DAY_TOTAL_CALLS_gt);
			ht.put("DAY_SUBS_USERS_CALLS", "" + DAY_SUBS_USERS_CALLS_gt);
			ht.put("DAY_NON_SUBS_USERS_CALLS", "" + DAY_NON_SUBS_USERS_CALLS_gt);
			ht.put("DAY_TOTAL_MOUS", "" + DAY_TOTAL_MOUS_gt);
			ht.put("DAY_SUBS_USERS_MOU", "" + DAY_SUBS_USERS_MOU_gt);
			ht.put("DAY_NON_SUBS_USERS_MOU", "" + DAY_NON_SUBS_USERS_MOU_gt);
			ht.put("DAY_TOTAL_PULSES", "" + DAY_TOTAL_PULSES_gt);
			ht.put("DAY_SUBS_USERS_PULSES", "" + DAY_SUBS_USERS_PULSES_gt);
			ht.put("DAY_NON_SUBS_USERS_PULSES", "" + DAY_NON_SUBS_USERS_PULSES_gt);
			ht.put("DAY_TOTAL_UNIQUE_CALLERS", "" + DAY_TOTAL_UNIQUE_CALLERS_gt);
			ht.put("DAY_UNIQUE_SUBS_CALLERS", "" + DAY_UNIQUE_SUBS_CALLERS_gt);
			ht.put("DAY_UNIQUE_NON_SUBS_CALLERS", "" + DAY_UNIQUE_NON_SUBS_CALLERS_gt);
			ht.put("NIGHT_TOTAL_CALLS", "" + NIGHT_TOTAL_CALLS_gt);
			ht.put("NIGHT_SUBS_USERS_CALLS", "" + NIGHT_SUBS_USERS_CALLS_gt);
			ht.put("NIGHT_NON_SUBS_USERS_CALLS", "" + NIGHT_NON_SUBS_USERS_CALLS_gt);
			ht.put("NIGHT_TOTAL_MOUS", "" + NIGHT_TOTAL_MOUS_gt);
			ht.put("NIGHT_SUBS_USERS_MOU", "" + NIGHT_SUBS_USERS_MOU_gt);
			ht.put("NIGHT_NON_SUBS_USERS_MOU", "" + NIGHT_NON_SUBS_USERS_MOU_gt);
			ht.put("NIGHT_TOTAL_PULSES", "" + NIGHT_TOTAL_PULSES_gt);
			ht.put("NIGHT_SUBS_USERS_PULSES", "" + NIGHT_SUBS_USERS_PULSES_gt);
			ht.put("NIGHT_NON_SUBS_USERS_PULSES", "" + NIGHT_NON_SUBS_USERS_PULSES_gt);
			ht.put("NIGHT_TOTAL_UNIQUE_CALLERS", "" + NIGHT_TOTAL_UNIQUE_CALLERS_gt);
			ht.put("NIGHT_UNIQUE_SUBS_CALLERS", "" + NIGHT_UNIQUE_SUBS_CALLERS_gt);
			ht.put("NIGHT_UNIQUE_NON_SUBS_CALLERS", "" + NIGHT_UNIQUE_NON_SUBS_CALLERS_gt);

			ht.put("SUB1_REQ", "" + SUB1_REQ_gt);
			ht.put("SUB2_REQ", "" + SUB2_REQ_gt);
			ht.put("SUB3_REQ", "" + SUB3_REQ_gt);
			ht.put("SUB1", "" + SUB1_gt);
			ht.put("SUB2", "" + SUB2_gt);
			ht.put("SUB3", "" + SUB3_gt);
			ht.put("SUB4", "" + SUB4_gt);
			ht.put("SUB5", "" + SUB5_gt);
			ht.put("SUB6", "" + SUB6_gt);
			ht.put("SUB7", "" + SUB7_gt);
			ht.put("SUB8", "" + SUB8_gt);
			ht.put("TOTAL_SUBS_REQ", "" + TOTAL_SUBS_REQ_gt);
			ht.put("TOTAL_UNSUBS_REQ", "" + TOTAL_UNSUBS_REQ_gt);

			ht.put("VOLUNTARY_UNSUBS", "" + VOLUNTARY_UNSUBS_gt);
			ht.put("INVOLUNTARY_UNSUBS", "" + INVOLUNTARY_UNSUBS_gt);
			ht.put("GROSS_ADDS", "" + GROSS_ADDS_gt);

			ht.put("RESUB1", "" + RESUB1_gt);
			ht.put("RESUB2", "" + RESUB2_gt);
			ht.put("RESUB3", "" + RESUB3_gt);
			ht.put("RESUB4", "" + RESUB4_gt);
			ht.put("RESUB5", "" + RESUB5_gt);
			ht.put("RESUB6", "" + RESUB6_gt);
			ht.put("RESUB7", "" + RESUB7_gt);
			ht.put("RESUB8", "" + RESUB8_gt);

			ht.put("IVR_SUBS", "" + IVR_SUBS_gt);
			ht.put("CCI_SUBS", "" + CCI_SUBS_gt);
			ht.put("OBD_SUBS", "" + OBD_SUBS_gt);
			ht.put("SMS_SUBS", "" + SMS_SUBS_gt);
			ht.put("IBD_SUBS", "" + IBD_SUBS_gt);
			ht.put("USSD_SUBS", "" + USSD_SUBS_gt);

			ht.put("OTHERS_SUBS", "" + OTHERS_SUBS_gt);

			ht.put("IVR_UNSUBS", "" + IVR_UNSUBS_gt);
			ht.put("CCI_UNSUBS", "" + CCI_UNSUBS_gt);
			ht.put("USSD_UNSUBS", "" + USSD_UNSUBS_gt);
			ht.put("SMS_UNSUBS", "" + SMS_UNSUBS_gt);
			ht.put("OTHER_UNSUBS", "" + OTHER_UNSUBS_gt);

			ht.put("IVR_DWLD", "" + IVR_DWLD_gt);
			ht.put("OBD_DWLD", "" + OBD_DWLD_gt);
			ht.put("CCI_DWLD", "" + CCI_DWLD_gt);
			ht.put("SMS_DWLD", "" + SMS_DWLD_gt);
			ht.put("OTHERS_DWLD", "" + OTHERS_DWLD_gt);

			ht.put("TOPUP1", "" + TOPUP1_gt);
			ht.put("TOPUP2", "" + TOPUP2_gt);
			ht.put("TOPUP3", "" + TOPUP3_gt);

			ht.put("ON_NET_DED", "" + ON_NET_DED_gt);
			ht.put("OFF_NET_DED", "" + OFF_NET_DED_gt);
			ht.put("TOTAL_DED", "" + TOTAL_DED_gt);
			ht.put("DOWNLOADS", "" + DOWNLOADS_gt);
			ht.put("CRBT_TONE_DOWNLOAD", "" + CRBT_TONE_DOWNLOAD_gt);

			ht.put("BROWSING_REVENUE", "" + df.format(BROWSING_REVENUE_gt));
			ht.put("SUB1_REVENUE", "" + df.format(SUB1_REVENUE_gt));
			ht.put("SUB2_REVENUE", "" + df.format(SUB2_REVENUE_gt));
			ht.put("SUB3_REVENUE", "" + df.format(SUB3_REVENUE_gt));
			ht.put("SUB4_REVENUE", "" + df.format(SUB4_REVENUE_gt));
			ht.put("SUB5_REVENUE", "" + df.format(SUB5_REVENUE_gt));
			ht.put("SUB6_REVENUE", "" + df.format(SUB6_REVENUE_gt));
			ht.put("SUB7_REVENUE", "" + df.format(SUB7_REVENUE_gt));
			ht.put("SUB8_REVENUE", "" + df.format(SUB8_REVENUE_gt));

			ht.put("TOPUP1_REVENUE", "" + df.format(TOPUP1_REVENUE_gt));
			ht.put("TOPUP2_REVENUE", "" + df.format(TOPUP2_REVENUE_gt));
			ht.put("TOPUP3_REVENUE", "" + df.format(TOPUP3_REVENUE_gt));
			ht.put("DOWNLOAD_REVENUE", "" + df.format(DOWNLOAD_REVENUE_gt));
			ht.put("DEDICATION_REVENUE", "" + df.format(DEDICATION_REVENUE_gt));

			ht.put("GROSS_REVENUE_LOCAL", "" + df.format(GROSS_REVENUE_LOCAL_gt));
			ht.put("GROSS_REVENUE_USD", "" + df.format(GROSS_REVENUE_USD_gt));

			ht.put("ACTIVE_SUBSCRIBERS", "" + ACTIVE_SUBSCRIBERS_gt);
			ht.put("BILLED_SUBSCRIBERS", "" + BILLED_SUBSCRIBERS_gt);
			ht.put("CALLING_SUBSCRIBERS", "" + CALLING_SUBSCRIBERS_gt);
			ht.put("AVG_CALL_UNIQUE", "" + df.format(AVG_CALL_UNIQUE_gt));
			ht.put("AVG_MOU_UNIQUE", "" + df.format(AVG_MOU_UNIQUE_gt));
			ht.put("AVG_MOU_CALL", "" + df.format(AVG_MOU_CALL_gt));
			ht.put("AVG_DWLD_UNIQUE", "" + df.format(AVG_DWLD_UNIQUE_gt));
			ht.put("AVG_DED_UNIQUE", "" + df.format(AVG_DED_UNIQUE_gt));
			ht.put("AVG_RBT_UNIQUE", "" + df.format(AVG_RBT_UNIQUE_gt));
			ht.put("UNIQUE_CALLER_ACTIVE", "" + df.format(UNIQUE_CALLER_ACTIVE_gt));
			ht.put("SERVICE_PENETRATION", "" + df.format(SERVICE_PENETRATION_gt));
			ht.put("ARPU", "" + df.format(ARPU_gt));

			ht.put("ACTIVE_TO_GRACE", "" + ACTIVE_TO_GRACE_gt);
			ht.put("GRACE_TO_ACTIVE", "" + GRACE_TO_ACTIVE_gt);
			ht.put("GRACE1TO7", "" + GRACE1TO7_gt);
			ht.put("GRACE8TO14", "" + GRACE8TO14_gt);
			ht.put("GRACE14TO21", "" + GRACE14TO21_gt);
			ht.put("GRACE22TO30", "" + GRACE22TO30_gt);
			ht.put("MIN1", "" + MIN1_gt);
			ht.put("MIN2", "" + MIN2_gt);
			ht.put("MIN3", "" + MIN3_gt);
			ht.put("MIN4", "" + MIN4_gt);
			ht.put("MIN5", "" + MIN5_gt);
			ht.put("MIN6", "" + MIN6_gt);
			ht.put("MIN7", "" + MIN7_gt);
			ht.put("MIN8", "" + MIN8_gt);
			ht.put("MIN9", "" + MIN9_gt);
			ht.put("MIN10", "" + MIN10_gt);
			ht.put("MIN10ABOVE", "" + MIN10ABOVE_gt);
			ht.put("HR0", "" + HR0_gt);
			ht.put("HR1", "" + HR1_gt);
			ht.put("HR2", "" + HR2_gt);
			ht.put("HR3", "" + HR3_gt);
			ht.put("HR4", "" + HR4_gt);
			ht.put("HR5", "" + HR5_gt);
			ht.put("HR6", "" + HR6_gt);
			ht.put("HR7", "" + HR7_gt);
			ht.put("HR8", "" + HR8_gt);
			ht.put("HR9", "" + HR9_gt);
			ht.put("HR10", "" + HR10_gt);
			ht.put("HR11", "" + HR11_gt);
			ht.put("HR12", "" + HR12_gt);
			ht.put("HR13", "" + HR13_gt);
			ht.put("HR14", "" + HR14_gt);
			ht.put("HR15", "" + HR15_gt);
			ht.put("HR16", "" + HR16_gt);
			ht.put("HR17", "" + HR17_gt);
			ht.put("HR18", "" + HR18_gt);
			ht.put("HR19", "" + HR19_gt);
			ht.put("HR20", "" + HR20_gt);
			ht.put("HR21", "" + HR21_gt);
			ht.put("HR22", "" + HR22_gt);
			ht.put("HR23", "" + HR23_gt);

			revenueData.add(ht);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception in cust_getRevenueMISData method::" + e);

		} finally {
			try {
				rs.close();
				pstmt.close();
				// pstmt1.close();
				// pstmt2.close();
				// pstmt3.close();

			} catch (SQLException ex) {
				logger.info(
						"exception while closing the resultset and prepared statement in cust_getRevenueMISData method ::"
								+ ex);

			}
		}
		}
		
		else
		{
			logger.info("---Connection is not established with Database--");
		}

		return revenueData;

	}

	public static synchronized ArrayList cust_getRevenueDevotionMISData(String startDate,
			String endDate) {
		ArrayList revenueData = null;
		ResultSet rs = null;
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;

		PreparedStatement pstmt = null;

		DecimalFormat df = new DecimalFormat("##.##");
		
		conn=(Connection)session.getAttribute("ActiveConection");
		
		if(conn!=null)
		{

		try {
			revenueData = new ArrayList();
			pstmt = conn.prepareStatement(
					"select * from Devotional.TBL_DEVOTIONAL_DAILY_SUMMARY  where DATE(DATE_TIME) between '" + startDate
							+ "' and  '" + endDate + "' order by DATE_TIME asc ");
			rs = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from Devotional.TBL_DEVOTIONAL_CDR where calldate between ? and ? ");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs1 = pstmt.executeQuery();

			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from Devotional.TBL_DEVOTIONAL_CDR where calldate between ? and ? and status = 1");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs2 = pstmt.executeQuery();

			// pstmt3 = conn.prepareStatement("select count(distinct ANI) from
			// Devotional.TBL_DEVOTIONAL_CDR where
			// trunc(To_Date(call_date,'dd-Mon-yy')) between
			// (To_Date(?,'dd-Mon-yy')) and (To_Date(?,'dd-Mon-yy'))and status
			// not in (1)" );
			pstmt = conn.prepareStatement(
					"select count(distinct ANI) from Devotional.TBL_DEVOTIONAL_CDR where calldate between ? and ? and status not in (1)");

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);

			rs3 = pstmt.executeQuery();

			long operatorbase = 3800000;

			long TOTAL_CALLS_gt = 0;
			long SUBS_USERS_CALLS_gt = 0;
			long NON_SUBS_USERS_CALLS_gt = 0;
			long TOTAL_MOUS_gt = 0;
			long SUBS_USERS_MOU_gt = 0;
			long NON_SUBS_USERS_MOU_gt = 0;
			long TOTAL_PULSES_gt = 0;
			long SUBS_USERS_PULSES_gt = 0;
			long NON_SUBS_USERS_PULSES_gt = 0;
			long TOTAL_UNIQUE_CALLERS_gt = 0;
			long UNIQUE_SUBS_CALLERS_gt = 0;
			long UNIQUE_NON_SUBS_CALLERS_gt = 0;
			long CP_DAILY_PACK_gt = 0;
			long CP_WEEKLY_PACK_gt = 0;
			long CP_FORTNIGHTLY_PACK_gt = 0;
			long CP_MONTHLY_PACK_gt = 0;
			long CP_VOLUNTARY_UNSUBS_gt = 0;
			long CP_INVOLUNTARY_UNSUBS_gt = 0;
			long CP_GROSS_ADDS_gt = 0;
			long ISP_DAILY_PACK_gt = 0;
			long ISP_WEEKLY_PACK_gt = 0;
			long ISP_FORTNIGHTLY_PACK_gt = 0;
			long ISP_MONTHLY_PACK_gt = 0;
			long ISP_VOLUNTARY_UNSUBS_gt = 0;
			long ISP_INVOLUNTARY_UNSUBS_gt = 0;
			long ISP_GROSS_ADDS_gt = 0;
			long CP_DAILY_RE_PACK_gt = 0;
			long CP_WEEKLY_RE_PACK_gt = 0;
			long CP_FORTNIGHTLY_RE_PACK_gt = 0;
			long CP_MONTHLY_RE_PACK_gt = 0;
			long ISP_DAILY_RE_PACK_gt = 0;
			long ISP_WEEKLY_RE_PACK_gt = 0;
			long ISP_FORTNIGHTLY_RE_PACK_gt = 0;
			long ISP_MONTHLY_RE_PACK_gt = 0;
			long TOPUP1_gt = 0;
			long TOPUP2_gt = 0;
			long TOPUP3_gt = 0;
			long TOPUP4_gt = 0;
			long IVR_SUBS_gt = 0;
			long CCI_SUBS_gt = 0;
			long OBD_SUBS_gt = 0;
			long SMS_SUBS_gt = 0;
			long IBD_SUBS_gt = 0;
			long USSD_SUBS_gt = 0;
			long OTHERS_SUBS_gt = 0;
			long IVR_UNSUBS_gt = 0;
			long CCI_UNSUBS_gt = 0;
			long SMS_UNSUBS_gt = 0;
			long USSD_UNSUBS_gt = 0;
			long APP_UNSUB_gt = 0;
			long OTHERS_UNSUB_gt = 0;
			long DAILY_GIFT_gt = 0;
			long WEEKLY_GIFT_gt = 0;
			long FORTNIGHTLY_GIFT_gt = 0;
			long MONTHLY_GIFT_gt = 0;
			double BROWSING_REVENUE_gt = 0;
			double ISP_DAILY_REVENUE_gt = 0;
			double ISP_WEEKLY_REVENUE_gt = 0;
			double ISP_FORTNIGHTLY_REVENUE_gt = 0;
			double ISP_MONTHLY_REVENUE_gt = 0;
			double CP_DAILY_REVENUE_gt = 0;
			double CP_WEEKLY_REVENUE_gt = 0;
			double CP_FORTNIGHTLY_REVENUE_gt = 0;
			double CP_MONTHLY_REVENUE_gt = 0;
			double TOPUP1_REVENUE_gt = 0;
			double TOPUP2_REVENUE_gt = 0;
			double TOPUP3_REVENUE_gt = 0;
			double TOPUP4_REVENUE_gt = 0;
			double SUBSCBINTION_DAILY_REVENUE_gt = 0;
			double SUBSCBINTION_WEEKLY_REVENUE_gt = 0;
			double SUBSCBINTION_FORTNIGHTLY_REVENUE_gt = 0;
			double SUBSCBINTION_MONTHLY_REVENUE_gt = 0;
			double GROSS_REVENUE_LOCAL_gt = 0;
			double GROSS_REVENUE_USD_gt = 0;
			long CP_ACTIVE_SUBSCRIBERS_gt = 0;
			long ISP_ACTIVE_SUBSCRIBERS_gt = 0;
			long ACTIVE_SUBSCRIBERS_gt = 0;
			long BILLED_SUBSCRIBERS_gt = 0;
			long CALLING_SUBSCRIBERS_gt = 0;
			long SERVICE_OBD_TOTAL_CALLS_gt = 0;
			long SERVICE_OBD_SUCCESS_CALLS_gt = 0;
			long SERVICE_OBD_FAIL_CALLS_gt = 0;
			double AVG_CALL_UNIQUE_gt = 0;
			double AVG_MOU_UNIQUE_gt = 0;
			double AVG_MOU_CALL_gt = 0;
			double UNIQUE_CALLER_ACTIVE_gt = 0;
			double SERVICE_PENETRATION_gt = 0;
			double ARPU_gt = 0;
			long ACTIVE_TO_GRACE_gt = 0;
			long GRACE_TO_ACTIVE_gt = 0;
			long GRACE1TO7_gt = 0;
			long GRACE8TO14_gt = 0;
			long GRACE15TO21_gt = 0;
			long GRACE22TO30_gt = 0;

			// Usage Pattern
			int MIN1_gt = 0;
			int MIN2_gt = 0;
			int MIN3_gt = 0;
			int MIN4_gt = 0;
			int MIN5_gt = 0;
			int MIN6_gt = 0;
			int MIN7_gt = 0;
			int MIN8_gt = 0;
			int MIN9_gt = 0;
			int MIN10_gt = 0;
			int MIN10ABOVE_gt = 0;

			// Hour Utilization
			String HR0_gt = null;
			String HR1_gt = null;
			String HR2_gt = null;
			String HR3_gt = null;
			String HR4_gt = null;
			String HR5_gt = null;
			String HR6_gt = null;
			String HR7_gt = null;
			String HR8_gt = null;
			String HR9_gt = null;
			String HR10_gt = null;
			String HR11_gt = null;
			String HR12_gt = null;
			String HR13_gt = null;
			String HR14_gt = null;
			String HR15_gt = null;
			String HR16_gt = null;
			String HR17_gt = null;
			String HR18_gt = null;
			String HR19_gt = null;
			String HR20_gt = null;
			String HR21_gt = null;
			String HR22_gt = null;
			String HR23_gt = null;

			while (rs1.next()) {

				// logger.info("code comes here in unique caller");
				int TOTAL_UNIQUE_CALLERS = rs1.getInt(1);
				logger.info("TOTAL_UNIQUE_CALLERS_gt :::::::" + TOTAL_UNIQUE_CALLERS);
				TOTAL_UNIQUE_CALLERS_gt = TOTAL_UNIQUE_CALLERS;
			}

			while (rs2.next()) {

				String UNIQUE_SUBS_CALLERS_gt1 = rs2.getString(1);
				logger.info("UNIQUE_SUBS_CALLERS_gt::::" + UNIQUE_SUBS_CALLERS_gt1);
				UNIQUE_SUBS_CALLERS_gt = Integer.parseInt(UNIQUE_SUBS_CALLERS_gt1);

			}

			while (rs3.next()) {
				String UNIQUE_NON_SUBS_CALLERS_gt1 = rs3.getString(1);
				logger.info("UNIQUE_NON_SUBS_CALLERS_gt :::::::" + UNIQUE_NON_SUBS_CALLERS_gt1);
				UNIQUE_NON_SUBS_CALLERS_gt = Integer.parseInt(UNIQUE_NON_SUBS_CALLERS_gt1);

			}

			int count = 0;
			while (rs.next()) {

				count += 1;

				HashMap<String, String> ht = new HashMap<String, String>();
				String str_SUMMARY_DATE = getSdf().format(rs.getDate("DATE_TIME"));
				ht.put("DATE_TIME", str_SUMMARY_DATE);

				logger.info("DATE_TIME = " + rs.getString("DATE_TIME"));

				String str_TOTAL_CALLS = rs.getString("TOTAL_CALLS");

				if (str_TOTAL_CALLS == null || str_TOTAL_CALLS.equals("")) {
					str_TOTAL_CALLS = "0";
				}
				// int TOTAL_CALLS_int = Integer.parseInt(str_TOTAL_CALLS);

				float TOTAL_CALLS_float = Float.parseFloat(str_TOTAL_CALLS);
				TOTAL_CALLS_gt += TOTAL_CALLS_float;
				ht.put("TOTAL_CALLS", "" + TOTAL_CALLS_float);
				logger.info("TOTAL_CALLS= " + TOTAL_CALLS_float);

				String str_SUBS_USERS_CALLS = rs.getString("SUBS_USERS_CALLS");

				if (str_SUBS_USERS_CALLS == null || str_SUBS_USERS_CALLS.equals("")) {
					str_SUBS_USERS_CALLS = "0";
				}
				int SUBS_USERS_CALLS_int = Integer.parseInt(str_SUBS_USERS_CALLS);

				// float SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_SUBS_USERS_CALLS);
				SUBS_USERS_CALLS_gt += SUBS_USERS_CALLS_int;
				ht.put("SUBS_USERS_CALLS", "" + SUBS_USERS_CALLS_int);
				logger.info("SUBS_USERS_CALLS= " + SUBS_USERS_CALLS_int);

				String str_NON_SUBS_USERS_CALLS = rs.getString("NON_SUBS_USERS_CALLS");

				if (str_NON_SUBS_USERS_CALLS == null || str_NON_SUBS_USERS_CALLS.equals("")) {
					str_NON_SUBS_USERS_CALLS = "0";

				}
				int NON_SUBS_USERS_CALLS_int = Integer.parseInt(str_NON_SUBS_USERS_CALLS);

				// float NON_SUBS_USERS_CALLS_float =
				// Float.parseFloat(str_NON_SUBS_USERS_CALLS);
				NON_SUBS_USERS_CALLS_gt += NON_SUBS_USERS_CALLS_int;
				ht.put("NON_SUBS_USERS_CALLS", "" + NON_SUBS_USERS_CALLS_int);
				logger.info("NON_SUBS_USERS_CALLS= " + NON_SUBS_USERS_CALLS_int);

				String str_TOTAL_MOUS = rs.getString("TOTAL_MOUS");

				if (str_TOTAL_MOUS == null || str_TOTAL_MOUS.equals("")) {
					str_TOTAL_MOUS = "0";

				}
				// int TOTAL_MOUS_int = Integer.parseInt(str_TOTAL_MOUS);

				float TOTAL_MOUS_float = Float.parseFloat(str_TOTAL_MOUS);
				TOTAL_MOUS_gt += TOTAL_MOUS_float;
				ht.put("TOTAL_MOUS", "" + TOTAL_MOUS_float);
				logger.info("TOTAL_MOUS= " + TOTAL_MOUS_float);

				String str_SUBS_USERS_MOU = rs.getString("SUBS_USERS_MOU");

				if (str_SUBS_USERS_MOU == null || str_SUBS_USERS_MOU.equals("")) {
					str_SUBS_USERS_MOU = "0";

				}
				int SUBS_USERS_MOU_int = Integer.parseInt(str_SUBS_USERS_MOU);

				// float SUBS_USERS_MOU_float =
				// Float.parseFloat(str_SUBS_USERS_MOU);
				SUBS_USERS_MOU_gt += SUBS_USERS_MOU_int;
				ht.put("SUBS_USERS_MOU", "" + SUBS_USERS_MOU_int);
				logger.info("SUBS_USERS_MOU= " + SUBS_USERS_MOU_int);

				String str_NON_SUBS_USERS_MOU = rs.getString("NON_SUBS_USERS_MOU");

				if (str_NON_SUBS_USERS_MOU == null || str_NON_SUBS_USERS_MOU.equals("")) {
					str_NON_SUBS_USERS_MOU = "0";

				}
				int NON_SUBS_USERS_MOU_int = Integer.parseInt(str_NON_SUBS_USERS_MOU);

				// float NON_SUBS_USERS_MOU_float =
				// Float.parseFloat(str_NON_SUBS_USERS_MOU);
				NON_SUBS_USERS_MOU_gt += NON_SUBS_USERS_MOU_int;
				ht.put("NON_SUBS_USERS_MOU", "" + NON_SUBS_USERS_MOU_int);
				logger.info("NON_SUBS_USERS_MOU= " + NON_SUBS_USERS_MOU_int);

				String str_TOTAL_PULSES = rs.getString("TOTAL_PULSES");

				if (str_TOTAL_PULSES == null || str_TOTAL_PULSES.equals("")) {
					str_TOTAL_PULSES = "0";

				}
				int TOTAL_PULSES_int = Integer.parseInt(str_TOTAL_PULSES);

				// float TOTAL_PULSES_float =
				// Float.parseFloat(str_TOTAL_PULSES);
				TOTAL_PULSES_gt += TOTAL_PULSES_int;
				ht.put("TOTAL_PULSES", "" + TOTAL_PULSES_int);
				logger.info("TOTAL_PULSES= " + TOTAL_PULSES_int);

				String str_SUBS_USERS_PULSES = rs.getString("SUBS_USERS_PULSES");

				if (str_SUBS_USERS_PULSES == null || str_SUBS_USERS_PULSES.equals("")) {
					str_SUBS_USERS_PULSES = "0";

				}
				int SUBS_USERS_PULSES_int = Integer.parseInt(str_SUBS_USERS_PULSES);

				// float SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_SUBS_USERS_PULSES);
				SUBS_USERS_PULSES_gt += SUBS_USERS_PULSES_int;
				ht.put("SUBS_USERS_PULSES", "" + SUBS_USERS_PULSES_int);
				logger.info("SUBS_USERS_PULSES= " + SUBS_USERS_PULSES_int);

				String str_NON_SUBS_USERS_PULSES = rs.getString("NON_SUBS_USERS_PULSES");

				if (str_NON_SUBS_USERS_PULSES == null || str_NON_SUBS_USERS_PULSES.equals("")) {
					str_NON_SUBS_USERS_PULSES = "0";

				}
				int NON_SUBS_USERS_PULSES_int = Integer.parseInt(str_NON_SUBS_USERS_PULSES);

				// float NON_SUBS_USERS_PULSES_float =
				// Float.parseFloat(str_NON_SUBS_USERS_PULSES);
				NON_SUBS_USERS_PULSES_gt += NON_SUBS_USERS_PULSES_int;
				ht.put("NON_SUBS_USERS_PULSES", "" + NON_SUBS_USERS_PULSES_int);
				logger.info("NON_SUBS_USERS_PULSES= " + NON_SUBS_USERS_PULSES_int);

				String str_TOTAL_UNIQUE_CALLERS = rs.getString("TOTAL_UNIQUE_CALLERS");

				if (str_TOTAL_UNIQUE_CALLERS == null || str_TOTAL_UNIQUE_CALLERS.equals("")) {
					str_TOTAL_UNIQUE_CALLERS = "0";

				}
				int TOTAL_UNIQUE_CALLERS_int = Integer.parseInt(str_TOTAL_UNIQUE_CALLERS);

				// float TOTAL_UNIQUE_CALLERS_float =
				// Float.parseFloat(str_TOTAL_UNIQUE_CALLERS);
				// TOTAL_UNIQUE_CALLERS_gt += TOTAL_UNIQUE_CALLERS_int;
				ht.put("TOTAL_UNIQUE_CALLERS", "" + TOTAL_UNIQUE_CALLERS_int);
				logger.info("TOTAL_UNIQUE_CALLERS= " + TOTAL_UNIQUE_CALLERS_int);

				String str_UNIQUE_SUBS_CALLERS = rs.getString("UNIQUE_SUBS_CALLERS");

				if (str_UNIQUE_SUBS_CALLERS == null || str_UNIQUE_SUBS_CALLERS.equals("")) {
					str_UNIQUE_SUBS_CALLERS = "0";

				}
				int UNIQUE_SUBS_CALLERS_int = Integer.parseInt(str_UNIQUE_SUBS_CALLERS);

				// float UNIQUE_SUBS_CALLERS_float =
				// Float.parseFloat(str_UNIQUE_SUBS_CALLERS);
				// UNIQUE_SUBS_CALLERS_gt += UNIQUE_SUBS_CALLERS_int;
				ht.put("UNIQUE_SUBS_CALLERS", "" + UNIQUE_SUBS_CALLERS_int);
				logger.info("UNIQUE_SUBS_CALLERS= " + UNIQUE_SUBS_CALLERS_int);

				String str_UNIQUE_NON_SUBS_CALLERS = rs.getString("UNIQUE_NON_SUBS_CALLERS");

				if (str_UNIQUE_NON_SUBS_CALLERS == null || str_UNIQUE_NON_SUBS_CALLERS.equals("")) {
					str_UNIQUE_NON_SUBS_CALLERS = "0";

				}
				int UNIQUE_NON_SUBS_CALLERS_int = Integer.parseInt(str_UNIQUE_NON_SUBS_CALLERS);

				// float UNIQUE_NON_SUBS_CALLERS_float =
				// Float.parseFloat(str_UNIQUE_NON_SUBS_CALLERS);
				// UNIQUE_NON_SUBS_CALLERS_gt += UNIQUE_NON_SUBS_CALLERS_int;
				ht.put("UNIQUE_NON_SUBS_CALLERS", "" + UNIQUE_NON_SUBS_CALLERS_int);
				logger.info("UNIQUE_NON_SUBS_CALLERS= " + UNIQUE_NON_SUBS_CALLERS_int);

				int CP_DAILY_PACK = rs.getInt("CP_DAILY_PACK");
				if (rs.wasNull()) {
					CP_DAILY_PACK = 0;
				}
				CP_DAILY_PACK_gt += CP_DAILY_PACK;
				ht.put("CP_DAILY_PACK", "" + CP_DAILY_PACK);

				int CP_WEEKLY_PACK = rs.getInt("CP_WEEKLY_PACK");
				if (rs.wasNull()) {
					CP_WEEKLY_PACK = 0;
				}
				CP_WEEKLY_PACK_gt += CP_WEEKLY_PACK;
				ht.put("CP_WEEKLY_PACK", "" + CP_WEEKLY_PACK);

				int CP_FORTNIGHTLY_PACK = rs.getInt("CP_FORTNIGHTLY_PACK");
				if (rs.wasNull()) {
					CP_FORTNIGHTLY_PACK = 0;
				}
				CP_FORTNIGHTLY_PACK_gt += CP_FORTNIGHTLY_PACK;
				ht.put("CP_FORTNIGHTLY_PACK", "" + CP_FORTNIGHTLY_PACK);

				int CP_MONTHLY_PACK = rs.getInt("CP_MONTHLY_PACK");
				if (rs.wasNull()) {
					CP_MONTHLY_PACK = 0;
				}
				CP_MONTHLY_PACK_gt += CP_MONTHLY_PACK;
				ht.put("CP_MONTHLY_PACK", "" + CP_MONTHLY_PACK);

				int CP_VOLUNTARY_UNSUBS = rs.getInt("CP_VOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					CP_VOLUNTARY_UNSUBS = 0;
				}
				CP_VOLUNTARY_UNSUBS_gt += CP_VOLUNTARY_UNSUBS;
				ht.put("CP_VOLUNTARY_UNSUBS", "" + CP_VOLUNTARY_UNSUBS);

				int CP_INVOLUNTARY_UNSUBS = rs.getInt("CP_INVOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					CP_INVOLUNTARY_UNSUBS = 0;
				}
				CP_INVOLUNTARY_UNSUBS_gt += CP_INVOLUNTARY_UNSUBS;
				ht.put("CP_INVOLUNTARY_UNSUBS", "" + CP_INVOLUNTARY_UNSUBS);

				int CP_GROSS_ADDS = rs.getInt("CP_GROSS_ADDS");
				if (rs.wasNull()) {
					CP_GROSS_ADDS = 0;
				}
				CP_GROSS_ADDS_gt += CP_GROSS_ADDS;
				ht.put("CP_GROSS_ADDS", "" + CP_GROSS_ADDS);

				int ISP_DAILY_PACK = rs.getInt("ISP_DAILY_PACK");
				if (rs.wasNull()) {
					ISP_DAILY_PACK = 0;
				}
				ISP_DAILY_PACK_gt += ISP_DAILY_PACK;
				ht.put("ISP_DAILY_PACK", "" + ISP_DAILY_PACK);

				int ISP_WEEKLY_PACK = rs.getInt("ISP_WEEKLY_PACK");
				if (rs.wasNull()) {
					ISP_WEEKLY_PACK = 0;
				}
				ISP_WEEKLY_PACK_gt += ISP_WEEKLY_PACK;
				ht.put("ISP_WEEKLY_PACK", "" + ISP_WEEKLY_PACK);

				int ISP_FORTNIGHTLY_PACK = rs.getInt("ISP_FORTNIGHTLY_PACK");
				if (rs.wasNull()) {
					ISP_FORTNIGHTLY_PACK = 0;
				}
				ISP_FORTNIGHTLY_PACK_gt += ISP_FORTNIGHTLY_PACK;
				ht.put("ISP_FORTNIGHTLY_PACK", "" + ISP_FORTNIGHTLY_PACK);

				int ISP_MONTHLY_PACK = rs.getInt("ISP_MONTHLY_PACK");
				if (rs.wasNull()) {
					ISP_MONTHLY_PACK = 0;
				}
				ISP_MONTHLY_PACK_gt += ISP_MONTHLY_PACK;
				ht.put("ISP_MONTHLY_PACK", "" + ISP_MONTHLY_PACK);

				int ISP_VOLUNTARY_UNSUBS = rs.getInt("ISP_VOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					ISP_VOLUNTARY_UNSUBS = 0;
				}
				ISP_VOLUNTARY_UNSUBS_gt += ISP_VOLUNTARY_UNSUBS;
				ht.put("ISP_VOLUNTARY_UNSUBS", "" + ISP_VOLUNTARY_UNSUBS);

				int ISP_INVOLUNTARY_UNSUBS = rs.getInt("ISP_INVOLUNTARY_UNSUBS");
				if (rs.wasNull()) {
					ISP_INVOLUNTARY_UNSUBS = 0;
				}
				ISP_INVOLUNTARY_UNSUBS_gt += ISP_INVOLUNTARY_UNSUBS;
				ht.put("ISP_INVOLUNTARY_UNSUBS", "" + ISP_INVOLUNTARY_UNSUBS);

				int ISP_GROSS_ADDS = rs.getInt("ISP_GROSS_ADDS");
				if (rs.wasNull()) {
					ISP_GROSS_ADDS = 0;
				}
				ISP_GROSS_ADDS_gt += ISP_GROSS_ADDS;
				ht.put("ISP_GROSS_ADDS", "" + ISP_GROSS_ADDS);

				int CP_DAILY_RE_PACK = rs.getInt("CP_DAILY_RE_PACK");
				if (rs.wasNull()) {
					CP_DAILY_RE_PACK = 0;
				}
				CP_DAILY_RE_PACK_gt += CP_DAILY_RE_PACK;
				ht.put("CP_DAILY_RE_PACK", "" + CP_DAILY_RE_PACK);

				int CP_WEEKLY_RE_PACK = rs.getInt("CP_WEEKLY_RE_PACK");
				if (rs.wasNull()) {
					CP_WEEKLY_RE_PACK = 0;
				}
				CP_WEEKLY_RE_PACK_gt += CP_WEEKLY_RE_PACK;
				ht.put("CP_WEEKLY_RE_PACK", "" + CP_WEEKLY_RE_PACK);

				int CP_FORTNIGHTLY_RE_PACK = rs.getInt("CP_FORTNIGHTLY_RE_PACK");
				if (rs.wasNull()) {
					CP_FORTNIGHTLY_RE_PACK = 0;
				}
				CP_FORTNIGHTLY_RE_PACK_gt += CP_FORTNIGHTLY_RE_PACK;
				ht.put("CP_FORTNIGHTLY_RE_PACK", "" + CP_FORTNIGHTLY_RE_PACK);

				int CP_MONTHLY_RE_PACK = rs.getInt("CP_MONTHLY_RE_PACK");
				if (rs.wasNull()) {
					CP_MONTHLY_RE_PACK = 0;
				}
				CP_MONTHLY_RE_PACK_gt += CP_MONTHLY_RE_PACK;
				ht.put("CP_MONTHLY_RE_PACK", "" + CP_MONTHLY_RE_PACK);

				int ISP_DAILY_RE_PACK = rs.getInt("ISP_DAILY_RE_PACK");
				if (rs.wasNull()) {
					ISP_DAILY_RE_PACK = 0;
				}
				ISP_DAILY_RE_PACK_gt += ISP_DAILY_RE_PACK;
				ht.put("ISP_DAILY_RE_PACK", "" + ISP_DAILY_RE_PACK);

				int ISP_WEEKLY_RE_PACK = rs.getInt("ISP_WEEKLY_RE_PACK");
				if (rs.wasNull()) {
					ISP_WEEKLY_RE_PACK = 0;
				}
				ISP_WEEKLY_RE_PACK_gt += ISP_WEEKLY_RE_PACK;
				ht.put("ISP_WEEKLY_RE_PACK", "" + ISP_WEEKLY_RE_PACK);

				int ISP_FORTNIGHTLY_RE_PACK = rs.getInt("ISP_FORTNIGHTLY_RE_PACK");
				if (rs.wasNull()) {
					ISP_FORTNIGHTLY_RE_PACK = 0;
				}
				ISP_FORTNIGHTLY_RE_PACK_gt += ISP_FORTNIGHTLY_RE_PACK;
				ht.put("ISP_FORTNIGHTLY_RE_PACK", "" + ISP_FORTNIGHTLY_RE_PACK);

				int ISP_MONTHLY_RE_PACK = rs.getInt("ISP_MONTHLY_RE_PACK");
				if (rs.wasNull()) {
					ISP_MONTHLY_RE_PACK = 0;
				}
				ISP_MONTHLY_RE_PACK_gt += ISP_MONTHLY_RE_PACK;
				ht.put("ISP_MONTHLY_RE_PACK", "" + ISP_MONTHLY_RE_PACK);

				int TOPUP1 = rs.getInt("TOPUP1");
				if (rs.wasNull()) {
					TOPUP1 = 0;
				}
				TOPUP1_gt += TOPUP1;
				ht.put("TOPUP1", "" + TOPUP1);

				int TOPUP2 = rs.getInt("TOPUP2");
				if (rs.wasNull()) {
					TOPUP2 = 0;
				}
				TOPUP2_gt += TOPUP2;
				ht.put("TOPUP2", "" + TOPUP2);

				int TOPUP3 = rs.getInt("TOPUP3");
				if (rs.wasNull()) {
					TOPUP3 = 0;
				}
				TOPUP3_gt += TOPUP3;
				ht.put("TOPUP3", "" + TOPUP3);

				String IVR_SUBS = rs.getString("IVR_SUBS");
				if (IVR_SUBS == null || IVR_SUBS.equals("")) {
					IVR_SUBS = "0";
				}
				int IVR_SUBS_int = Integer.parseInt(IVR_SUBS);
				IVR_SUBS_gt += IVR_SUBS_int;
				ht.put("IVR_SUBS", "" + IVR_SUBS_int);
				logger.info("IVR_SUBS= " + IVR_SUBS_int);

				String CCI_SUBS = rs.getString("CCI_SUBS");
				if (CCI_SUBS == null || CCI_SUBS.equals("")) {
					CCI_SUBS = "0";
				}
				int CCI_SUBS_int = Integer.parseInt(CCI_SUBS);
				CCI_SUBS_gt += CCI_SUBS_int;
				ht.put("CCI_SUBS", "" + CCI_SUBS_int);
				logger.info("CCI_SUBS= " + CCI_SUBS_int);

				String OBD_SUBS = rs.getString("OBD_SUBS");
				if (OBD_SUBS == null || OBD_SUBS.equals("")) {
					OBD_SUBS = "0";
				}
				int OBD_SUBS_int = Integer.parseInt(OBD_SUBS);
				OBD_SUBS_gt += OBD_SUBS_int;
				ht.put("OBD_SUBS", "" + OBD_SUBS_int);
				logger.info("OBD_SUBS= " + OBD_SUBS_int);

				String SMS_SUBS = rs.getString("SMS_SUBS");
				if (SMS_SUBS == null || SMS_SUBS.equals("")) {
					SMS_SUBS = "0";
				}
				int SMS_SUBS_int = Integer.parseInt(SMS_SUBS);
				SMS_SUBS_gt += SMS_SUBS_int;
				ht.put("SMS_SUBS", "" + SMS_SUBS_int);
				logger.info("SMS_SUBS= " + SMS_SUBS_int);

				String IBD_SUBS = rs.getString("IBD_SUBS");
				if (IBD_SUBS == null || IBD_SUBS.equals("")) {
					IBD_SUBS = "0";
				}
				int IBD_SUBS_int = Integer.parseInt(IBD_SUBS);
				IBD_SUBS_gt += IBD_SUBS_int;
				ht.put("IBD_SUBS", "" + IBD_SUBS_int);
				logger.info("IBD_SUBS= " + IBD_SUBS_int);

				String USSD_SUBS = rs.getString("USSD_SUBS");
				if (USSD_SUBS == null || USSD_SUBS.equals("")) {
					USSD_SUBS = "0";
				}
				int USSD_SUBS_int = Integer.parseInt(USSD_SUBS);
				USSD_SUBS_gt += USSD_SUBS_int;
				ht.put("USSD_SUBS", "" + USSD_SUBS_int);
				logger.info("USSD_SUBS= " + USSD_SUBS_int);

				String OTHERS_SUBS = rs.getString("OTHERS_SUBS");
				if (OTHERS_SUBS == null || OTHERS_SUBS.equals("")) {
					OTHERS_SUBS = "0";
				}
				int OTHERS_SUBS_int = Integer.parseInt(OTHERS_SUBS);
				OTHERS_SUBS_gt += OTHERS_SUBS_int;
				ht.put("OTHERS_SUBS", "" + OTHERS_SUBS_int);
				logger.info("OTHERS_SUBS= " + OTHERS_SUBS_int);

				String IVR_UNSUBS = rs.getString("IVR_UNSUBS");
				if (IVR_UNSUBS == null || IVR_UNSUBS.equals("")) {
					IVR_UNSUBS = "0";
				}
				int IVR_UNSUBS_int = Integer.parseInt(IVR_UNSUBS);
				IVR_UNSUBS_gt += IVR_UNSUBS_int;
				ht.put("IVR_UNSUBS", "" + IVR_UNSUBS_int);
				logger.info("IVR_UNSUBS= " + IVR_UNSUBS_int);

				String CCI_UNSUBS = rs.getString("CCI_UNSUBS");
				if (CCI_UNSUBS == null || CCI_UNSUBS.equals("")) {
					CCI_UNSUBS = "0";
				}
				int CCI_UNSUBS_int = Integer.parseInt(CCI_UNSUBS);
				CCI_UNSUBS_gt += CCI_UNSUBS_int;
				ht.put("CCI_UNSUBS", "" + CCI_UNSUBS_int);
				logger.info("CCI_UNSUBS= " + CCI_UNSUBS_int);

				long USSD_UNSUBS = rs.getInt("USSD_UNSUBS");
				if (rs.wasNull()) {
					USSD_UNSUBS = 0;
				}
				USSD_UNSUBS_gt += USSD_UNSUBS;
				ht.put("USSD_UNSUBS", "" + USSD_UNSUBS);

				String SMS_UNSUBS = rs.getString("SMS_UNSUBS");
				if (SMS_UNSUBS == null || SMS_UNSUBS.equals("")) {
					SMS_UNSUBS = "0";
				}
				int SMS_UNSUBS_int = Integer.parseInt(SMS_UNSUBS);
				SMS_UNSUBS_gt += SMS_UNSUBS_int;
				ht.put("SMS_UNSUBS", "" + SMS_UNSUBS_int);
				logger.info("SMS_UNSUBS= " + SMS_UNSUBS_int);

				int OTHERS_UNSUB = rs.getInt("OTHERS_UNSUB");
				if (rs.wasNull()) {
					OTHERS_UNSUB = 0;
				}
				OTHERS_UNSUB_gt += OTHERS_UNSUB;
				ht.put("OTHERS_UNSUB", "" + OTHERS_UNSUB);
				logger.info("OTHERS_UNSUB= " + OTHERS_UNSUB);

				float BROWSING_REVENUE = rs.getFloat("BROWSING_REVENUE");
				if (rs.wasNull()) {
					BROWSING_REVENUE = 0;
				}
				BROWSING_REVENUE_gt += BROWSING_REVENUE;
				ht.put("BROWSING_REVENUE", "" + BROWSING_REVENUE);

				float ISP_DAILY_REVENUE = rs.getFloat("ISP_DAILY_REVENUE");
				if (rs.wasNull()) {
					ISP_DAILY_REVENUE = 0;
				}
				ISP_DAILY_REVENUE_gt += ISP_DAILY_REVENUE;
				ht.put("ISP_DAILY_REVENUE", "" + ISP_DAILY_REVENUE);

				float ISP_WEEKLY_REVENUE = rs.getFloat("ISP_WEEKLY_REVENUE");
				if (rs.wasNull()) {
					ISP_WEEKLY_REVENUE = 0;
				}
				ISP_WEEKLY_REVENUE_gt += ISP_WEEKLY_REVENUE;
				ht.put("ISP_WEEKLY_REVENUE", "" + ISP_WEEKLY_REVENUE);

				float ISP_FORTNIGHTLY_REVENUE = rs.getFloat("ISP_FORTNIGHTLY_REVENUE");
				if (rs.wasNull()) {
					ISP_FORTNIGHTLY_REVENUE = 0;
				}
				ISP_FORTNIGHTLY_REVENUE_gt += ISP_FORTNIGHTLY_REVENUE;
				ht.put("ISP_FORTNIGHTLY_REVENUE", "" + ISP_FORTNIGHTLY_REVENUE);

				float ISP_MONTHLY_REVENUE = rs.getFloat("ISP_MONTHLY_REVENUE");
				if (rs.wasNull()) {
					ISP_MONTHLY_REVENUE = 0;
				}
				ISP_MONTHLY_REVENUE_gt += ISP_MONTHLY_REVENUE;
				ht.put("ISP_MONTHLY_REVENUE", "" + ISP_MONTHLY_REVENUE);

				float CP_DAILY_REVENUE = rs.getFloat("CP_DAILY_REVENUE");
				if (rs.wasNull()) {
					CP_DAILY_REVENUE = 0;
				}
				CP_DAILY_REVENUE_gt += CP_DAILY_REVENUE;
				ht.put("CP_DAILY_REVENUE", "" + CP_DAILY_REVENUE);

				float CP_WEEKLY_REVENUE = rs.getFloat("CP_WEEKLY_REVENUE");
				if (rs.wasNull()) {
					CP_WEEKLY_REVENUE = 0;
				}
				CP_WEEKLY_REVENUE_gt += CP_WEEKLY_REVENUE;
				ht.put("CP_WEEKLY_REVENUE", "" + CP_WEEKLY_REVENUE);

				float CP_FORTNIGHTLY_REVENUE = rs.getFloat("CP_FORTNIGHTLY_REVENUE");
				if (rs.wasNull()) {
					CP_FORTNIGHTLY_REVENUE = 0;
				}
				CP_FORTNIGHTLY_REVENUE_gt += CP_FORTNIGHTLY_REVENUE;
				ht.put("CP_FORTNIGHTLY_REVENUE", "" + CP_FORTNIGHTLY_REVENUE);

				float CP_MONTHLY_REVENUE = rs.getFloat("CP_MONTHLY_REVENUE");
				if (rs.wasNull()) {
					CP_MONTHLY_REVENUE = 0;
				}
				CP_MONTHLY_REVENUE_gt += CP_MONTHLY_REVENUE;
				ht.put("CP_MONTHLY_REVENUE", "" + CP_MONTHLY_REVENUE);

				float TOPUP1_REVENUE = rs.getFloat("TOPUP1_REVENUE");
				if (rs.wasNull()) {
					TOPUP1_REVENUE = 0;
				}
				TOPUP1_REVENUE_gt += TOPUP1_REVENUE;
				ht.put("TOPUP1_REVENUE", "" + TOPUP1_REVENUE);

				float TOPUP2_REVENUE = rs.getFloat("TOPUP2_REVENUE");
				if (rs.wasNull()) {
					TOPUP2_REVENUE = 0;
				}
				TOPUP2_REVENUE_gt += TOPUP2_REVENUE;
				ht.put("TOPUP2_REVENUE", "" + TOPUP2_REVENUE);

				float TOPUP3_REVENUE = rs.getFloat("TOPUP3_REVENUE");
				if (rs.wasNull()) {
					TOPUP3_REVENUE = 0;
				}
				TOPUP3_REVENUE_gt += TOPUP3_REVENUE;
				ht.put("TOPUP3_REVENUE", "" + TOPUP3_REVENUE);

				float GROSS_REVENUE_LOCAL = rs.getFloat("GROSS_REVENUE_LOCAL");
				if (rs.wasNull()) {
					GROSS_REVENUE_LOCAL = 0;
				}
				GROSS_REVENUE_LOCAL_gt += GROSS_REVENUE_LOCAL;
				ht.put("GROSS_REVENUE_LOCAL", "" + GROSS_REVENUE_LOCAL);

				float GROSS_REVENUE_USD = rs.getFloat("GROSS_REVENUE_USD");
				if (rs.wasNull()) {
					GROSS_REVENUE_USD = 0;
				}
				GROSS_REVENUE_USD_gt += GROSS_REVENUE_USD;
				ht.put("GROSS_REVENUE_USD", "" + GROSS_REVENUE_USD);

				int CP_ACTIVE_SUBSCRIBERS = rs.getInt("CP_ACTIVE_SUBSCRIBERS");
				if (rs.wasNull()) {
					CP_ACTIVE_SUBSCRIBERS = 0;
				}
				CP_ACTIVE_SUBSCRIBERS_gt = CP_ACTIVE_SUBSCRIBERS;
				ht.put("CP_ACTIVE_SUBSCRIBERS", "" + CP_ACTIVE_SUBSCRIBERS);

				int ISP_ACTIVE_SUBSCRIBERS = rs.getInt("ISP_ACTIVE_SUBSCRIBERS");
				if (rs.wasNull()) {
					ISP_ACTIVE_SUBSCRIBERS = 0;
				}
				ISP_ACTIVE_SUBSCRIBERS_gt = ISP_ACTIVE_SUBSCRIBERS;
				ht.put("ISP_ACTIVE_SUBSCRIBERS", "" + ISP_ACTIVE_SUBSCRIBERS);

				ACTIVE_SUBSCRIBERS_gt = CP_ACTIVE_SUBSCRIBERS + ISP_ACTIVE_SUBSCRIBERS;
				String str_BILLED_SUBSCRIBERS = rs.getString("BILLED_SUBSCRIBERS");
				if (str_BILLED_SUBSCRIBERS == null || str_BILLED_SUBSCRIBERS.equals("")) {
					str_BILLED_SUBSCRIBERS = "0";
				}
				int BILLED_SUBSCRIBERS_int = Integer.parseInt(str_BILLED_SUBSCRIBERS);
				BILLED_SUBSCRIBERS_gt += BILLED_SUBSCRIBERS_int;
				ht.put("BILLED_SUBSCRIBERS", "" + BILLED_SUBSCRIBERS_int);
				logger.info("BILLED_SUBSCRIBERS= " + BILLED_SUBSCRIBERS_int);

				String str_CALLING_SUBSCRIBERS = rs.getString("CALLING_SUBSCRIBERS");

				if (str_CALLING_SUBSCRIBERS == null || str_CALLING_SUBSCRIBERS.equals("")) {
					str_CALLING_SUBSCRIBERS = "0";

				}
				int CALLING_SUBSCRIBERS_int = Integer.parseInt(str_CALLING_SUBSCRIBERS);

				// float CALLING_SUBSCRIBERS_float =
				// Float.parseFloat(str_CALLING_SUBSCRIBERS);
				CALLING_SUBSCRIBERS_gt = CALLING_SUBSCRIBERS_int;
				ht.put("CALLING_SUBSCRIBERS", "" + CALLING_SUBSCRIBERS_int);
				logger.info("CALLING_SUBSCRIBERS= " + CALLING_SUBSCRIBERS_int);

				float AVG_CALL_UNIQUE = rs.getFloat("AVG_CALL_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_CALL_UNIQUE_gt += AVG_CALL_UNIQUE;
				ht.put("AVG_CALL_UNIQUE", "" + AVG_CALL_UNIQUE);
				logger.info("AVG_CALL_UNIQUE= " + AVG_CALL_UNIQUE);

				float AVG_MOU_UNIQUE = rs.getFloat("AVG_MOU_UNIQUE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_MOU_UNIQUE_gt += AVG_MOU_UNIQUE;
				ht.put("AVG_MOU_UNIQUE", "" + AVG_MOU_UNIQUE);
				logger.info("AVG_MOU_UNIQUE= " + AVG_MOU_UNIQUE);

				float AVG_MOU_CALL = rs.getFloat("AVG_MOU_CALL");
				// float HR0_float = Float.parseFloat(str_HR0);
				// AVG_MOU_CALL_gt += AVG_MOU_CALL;
				ht.put("AVG_MOU_CALL", "" + AVG_MOU_CALL);
				logger.info("AVG_MOU_CALL= " + AVG_MOU_CALL);

				float UNIQUE_CALLER_ACTIVE = rs.getFloat("UNIQUE_CALLER_ACTIVE");
				// float HR0_float = Float.parseFloat(str_HR0);
				// UNIQUE_CALLER_ACTIVE_gt += UNIQUE_CALLER_ACTIVE;
				ht.put("UNIQUE_CALLER_ACTIVE", "" + UNIQUE_CALLER_ACTIVE);
				logger.info("UNIQUE_CALLER_ACTIVE= " + UNIQUE_CALLER_ACTIVE);

				float SERVICE_PENETRATION = rs.getFloat("SERVICE_PENETRATION");
				// float HR0_float = Float.parseFloat(str_HR0);
				// SERVICE_PENETRATION_gt += SERVICE_PENETRATION;
				ht.put("SERVICE_PENETRATION", "" + SERVICE_PENETRATION);
				logger.info("SERVICE_PENETRATION= " + SERVICE_PENETRATION);

				float ARPU = rs.getFloat("ARPU");
				// float HR0_float = Float.parseFloat(str_HR0);
				ARPU_gt += ARPU;
				ht.put("ARPU", "" + ARPU);
				logger.info("ARPU= " + ARPU);

				String str_ACTIVE_TO_GRACE = rs.getString("ACTIVE_TO_GRACE");

				if (str_ACTIVE_TO_GRACE == null || str_ACTIVE_TO_GRACE.equals("")) {
					str_ACTIVE_TO_GRACE = "0";

				}
				int ACTIVE_TO_GRACE_int = Integer.parseInt(str_ACTIVE_TO_GRACE);

				// float ACTIVE_TO_GRACE_float =
				// Float.parseFloat(str_ACTIVE_TO_GRACE);
				ACTIVE_TO_GRACE_gt = ACTIVE_TO_GRACE_int;
				ht.put("ACTIVE_TO_GRACE", "" + ACTIVE_TO_GRACE_int);
				logger.info("ACTIVE_TO_GRACE= " + ACTIVE_TO_GRACE_int);

				String str_GRACE_TO_ACTIVE = rs.getString("GRACE_TO_ACTIVE");

				if (str_GRACE_TO_ACTIVE == null || str_GRACE_TO_ACTIVE.equals("")) {
					str_GRACE_TO_ACTIVE = "0";

				}
				int GRACE_TO_ACTIVE_int = Integer.parseInt(str_GRACE_TO_ACTIVE);

				// float GRACE_TO_ACTIVE_float =
				// Float.parseFloat(str_GRACE_TO_ACTIVE);
				GRACE_TO_ACTIVE_gt = GRACE_TO_ACTIVE_int;
				ht.put("GRACE_TO_ACTIVE", "" + GRACE_TO_ACTIVE_int);
				logger.info("GRACE_TO_ACTIVE= " + GRACE_TO_ACTIVE_int);

				String str_GRACE1TO7 = rs.getString("GRACE1TO7");

				if (str_GRACE1TO7 == null || str_GRACE1TO7.equals("")) {
					str_GRACE1TO7 = "0";

				}
				int GRACE1TO7_int = Integer.parseInt(str_GRACE1TO7);

				// float GRACE1TO7_float = Float.parseFloat(str_GRACE1TO7);
				GRACE1TO7_gt = GRACE1TO7_int;
				ht.put("GRACE1TO7", "" + GRACE1TO7_int);
				logger.info("GRACE1TO7= " + GRACE1TO7_int);

				String str_GRACE8TO14 = rs.getString("GRACE8TO14");

				if (str_GRACE8TO14 == null || str_GRACE8TO14.equals("")) {
					str_GRACE8TO14 = "0";

				}
				int GRACE8TO14_int = Integer.parseInt(str_GRACE8TO14);

				// float GRACE8TO14_float = Float.parseFloat(str_GRACE8TO14);
				GRACE8TO14_gt = GRACE8TO14_int;
				ht.put("GRACE8TO14", "" + GRACE8TO14_int);
				logger.info("GRACE8TO14= " + GRACE8TO14_int);

				int GRACE15TO21 = rs.getInt("GRACE15TO21");
				if (rs.wasNull()) {
					GRACE15TO21 = 0;
				}
				GRACE15TO21_gt = GRACE15TO21;
				ht.put("GRACE15TO21", "" + GRACE15TO21);
				logger.info("GRACE15TO21= " + GRACE15TO21);

				String str_GRACE22TO30 = rs.getString("GRACE22TO30");

				if (str_GRACE22TO30 == null || str_GRACE22TO30.equals("")) {
					str_GRACE22TO30 = "0";

				}
				int GRACE22TO30_int = Integer.parseInt(str_GRACE22TO30);

				// float GRACE22TO30_float = Float.parseFloat(str_GRACE22TO30);
				GRACE22TO30_gt = GRACE22TO30_int;
				ht.put("GRACE22TO30", "" + GRACE22TO30_int);
				logger.info("GRACE22TO30= " + GRACE22TO30_int);

				String str_MIN1 = rs.getString("MIN1");

				if (str_MIN1 == null || str_MIN1.equals("")) {
					str_MIN1 = "0";

				}
				int MIN1_int = Integer.parseInt(str_MIN1);

				// float MIN1_float = Float.parseFloat(str_MIN1);
				MIN1_gt += MIN1_int;
				ht.put("MIN1", "" + MIN1_int);
				logger.info("MIN1= " + MIN1_int);

				String str_MIN2 = rs.getString("MIN2");

				if (str_MIN2 == null || str_MIN2.equals("")) {
					str_MIN2 = "0";

				}
				int MIN2_int = Integer.parseInt(str_MIN2);

				// float MIN2_float = Float.parseFloat(str_MIN2);
				MIN2_gt += MIN2_int;
				ht.put("MIN2", "" + MIN2_int);
				logger.info("MIN2= " + MIN2_int);

				String str_MIN3 = rs.getString("MIN3");

				if (str_MIN3 == null || str_MIN3.equals("")) {
					str_MIN3 = "0";

				}
				int MIN3_int = Integer.parseInt(str_MIN3);

				// float MIN3_float = Float.parseFloat(str_MIN3);
				MIN3_gt += MIN3_int;
				ht.put("MIN3", "" + MIN3_int);
				logger.info("MIN3= " + MIN3_int);

				String str_MIN4 = rs.getString("MIN4");

				if (str_MIN4 == null || str_MIN4.equals("")) {
					str_MIN4 = "0";

				}
				int MIN4_int = Integer.parseInt(str_MIN4);

				// float MIN4_float = Float.parseFloat(str_MIN4);
				MIN4_gt += MIN4_int;
				ht.put("MIN4", "" + MIN4_int);
				logger.info("MIN4= " + MIN4_int);

				String str_MIN5 = rs.getString("MIN5");

				if (str_MIN5 == null || str_MIN5.equals("")) {
					str_MIN5 = "0";

				}
				int MIN5_int = Integer.parseInt(str_MIN5);

				// float MIN5_float = Float.parseFloat(str_MIN5);
				MIN5_gt += MIN5_int;
				ht.put("MIN5", "" + MIN5_int);
				logger.info("MIN5= " + MIN5_int);

				String str_MIN6 = rs.getString("MIN6");

				if (str_MIN6 == null || str_MIN6.equals("")) {
					str_MIN6 = "0";

				}
				int MIN6_int = Integer.parseInt(str_MIN6);

				// float MIN6_float = Float.parseFloat(str_MIN6);
				MIN6_gt += MIN6_int;
				ht.put("MIN6", "" + MIN6_int);
				logger.info("MIN6= " + MIN6_int);

				String str_MIN7 = rs.getString("MIN7");

				if (str_MIN7 == null || str_MIN7.equals("")) {
					str_MIN7 = "0";

				}
				int MIN7_int = Integer.parseInt(str_MIN7);

				// float MIN7_float = Float.parseFloat(str_MIN7);
				MIN7_gt += MIN7_int;
				ht.put("MIN7", "" + MIN7_int);
				logger.info("MIN7= " + MIN7_int);

				String str_MIN8 = rs.getString("MIN8");

				if (str_MIN8 == null || str_MIN8.equals("")) {
					str_MIN8 = "0";

				}
				int MIN8_int = Integer.parseInt(str_MIN8);

				// float MIN8_float = Float.parseFloat(str_MIN8);
				MIN8_gt += MIN8_int;
				ht.put("MIN8", "" + MIN8_int);
				logger.info("MIN8= " + MIN8_int);

				String str_MIN9 = rs.getString("MIN9");

				if (str_MIN9 == null || str_MIN9.equals("")) {
					str_MIN9 = "0";

				}
				int MIN9_int = Integer.parseInt(str_MIN9);

				// float MIN9_float = Float.parseFloat(str_MIN9);
				MIN9_gt += MIN9_int;
				ht.put("MIN9", "" + MIN9_int);
				logger.info("MIN9= " + MIN9_int);

				String str_MIN10 = rs.getString("MIN10");

				if (str_MIN10 == null || str_MIN10.equals("")) {
					str_MIN10 = "0";

				}
				int MIN10_int = Integer.parseInt(str_MIN10);

				// float MIN10_float = Float.parseFloat(str_MIN10);
				MIN10_gt += MIN10_int;
				ht.put("MIN10", "" + MIN10_int);
				logger.info("MIN10= " + MIN10_int);

				String str_MIN10ABOVE = rs.getString("MIN10ABOVE");

				if (str_MIN10ABOVE == null || str_MIN10ABOVE.equals("")) {
					str_MIN10ABOVE = "0";

				}
				int MIN10ABOVE_int = Integer.parseInt(str_MIN10ABOVE);

				// float MIN10ABOVE_float = Float.parseFloat(str_MIN10ABOVE);
				MIN10ABOVE_gt += MIN10ABOVE_int;
				ht.put("MIN10ABOVE", "" + MIN10ABOVE_int);
				logger.info("MIN10ABOVE= " + MIN10ABOVE_int);

				float HR0 = rs.getFloat("HR0");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR0_gt += HR0;
				ht.put("HR0", "" + HR0);
				logger.info("HR0= " + HR0);

				float HR1 = rs.getFloat("HR1");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR1_gt += HR1;
				ht.put("HR1", "" + HR1);
				logger.info("HR1= " + HR1);

				float HR2 = rs.getFloat("HR2");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR2_gt += HR2;
				ht.put("HR2", "" + HR2);
				logger.info("HR2= " + HR2);

				float HR3 = rs.getFloat("HR3");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR3_gt += HR3;
				ht.put("HR3", "" + HR3);
				logger.info("HR3= " + HR3);

				float HR4 = rs.getFloat("HR4");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR4_gt += HR4;
				ht.put("HR4", "" + HR4);
				logger.info("HR4= " + HR4);

				float HR5 = rs.getFloat("HR5");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR5_gt += HR5;
				ht.put("HR5", "" + HR5);
				logger.info("HR5= " + HR5);

				float HR6 = rs.getFloat("HR6");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR6_gt += HR6;
				ht.put("HR6", "" + HR6);
				logger.info("HR6= " + HR6);

				float HR7 = rs.getFloat("HR7");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR7_gt += HR7;
				ht.put("HR7", "" + HR7);
				logger.info("HR7= " + HR7);

				float HR8 = rs.getFloat("HR8");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR8_gt += HR8;
				ht.put("HR8", "" + HR8);
				logger.info("HR8= " + HR8);

				float HR9 = rs.getFloat("HR9");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR9_gt += HR9;
				ht.put("HR9", "" + HR9);
				logger.info("HR9= " + HR9);

				float HR10 = rs.getFloat("HR10");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR10_gt += HR10;
				ht.put("HR10", "" + HR10);
				logger.info("HR10= " + HR10);

				float HR11 = rs.getFloat("HR11");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR11_gt += HR11;
				ht.put("HR11", "" + HR11);
				logger.info("HR11= " + HR11);

				float HR12 = rs.getFloat("HR12");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR12_gt += HR12;
				ht.put("HR12", "" + HR12);
				logger.info("HR12= " + HR12);

				float HR13 = rs.getFloat("HR13");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR13_gt += HR13;
				ht.put("HR13", "" + HR13);
				logger.info("HR13= " + HR13);

				float HR14 = rs.getFloat("HR14");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR14_gt += HR14;
				ht.put("HR14", "" + HR14);
				logger.info("HR14= " + HR14);

				float HR15 = rs.getFloat("HR15");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR15_gt += HR15;
				ht.put("HR15", "" + HR15);
				logger.info("HR15= " + HR15);

				float HR16 = rs.getFloat("HR16");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR16_gt += HR16;
				ht.put("HR16", "" + HR16);
				logger.info("HR16= " + HR16);

				float HR17 = rs.getFloat("HR17");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR17_gt += HR17;
				ht.put("HR17", "" + HR17);
				logger.info("HR17= " + HR17);

				float HR18 = rs.getFloat("HR18");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR18_gt += HR18;
				ht.put("HR18", "" + HR18);
				logger.info("HR18= " + HR18);

				float HR19 = rs.getFloat("HR19");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR19_gt += HR19;
				ht.put("HR19", "" + HR19);
				logger.info("HR19= " + HR19);

				float HR20 = rs.getFloat("HR20");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR20_gt += HR20;
				ht.put("HR20", "" + HR20);
				logger.info("HR20= " + HR20);

				float HR21 = rs.getFloat("HR21");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR21_gt += HR21;
				ht.put("HR21", "" + HR21);
				logger.info("HR21= " + HR21);

				float HR22 = rs.getFloat("HR22");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR22_gt += HR22;
				ht.put("HR22", "" + HR22);
				logger.info("HR22= " + HR22);

				float HR23 = rs.getFloat("HR23");
				// float HR0_float = Float.parseFloat(str_HR0);
				// HR23_gt += HR23;
				ht.put("HR23", "" + HR23);
				logger.info("HR23= " + HR23);

				revenueData.add(ht);
			}

			if (count > 0) {
				logger.info("count::" + count);

				// Average MOU/Unique Caller
				try {
					AVG_MOU_UNIQUE_gt = (float) (TOTAL_MOUS_gt / TOTAL_UNIQUE_CALLERS_gt);
				} catch (Exception e) {
					AVG_MOU_UNIQUE_gt = 0;
				}

				// Average MOU/Call
				try {
					AVG_MOU_CALL_gt = (float) (TOTAL_MOUS_gt / TOTAL_CALLS_gt);
				} catch (Exception e) {
					AVG_MOU_CALL_gt = 0;
				}

				// Unique caller/Active subscribers in the system
				try {
					UNIQUE_CALLER_ACTIVE_gt = (float) (TOTAL_UNIQUE_CALLERS_gt / ACTIVE_SUBSCRIBERS_gt);
				} catch (Exception e) {
				}

				// logger.info("UNIQUE_CALLER_ACTIVE_gt::"+UNIQUE_CALLER_ACTIVE_gt);
				// Service penetration(in %)
				try {
					SERVICE_PENETRATION_gt = (float) (ACTIVE_SUBSCRIBERS_gt * 100 / operatorbase);
				} catch (Exception e) {
				}
				// logger.info("SERVICE_PENETRATION_gt::"+SERVICE_PENETRATION_gt);

				// Service penetration(in %)
				try {
					ARPU_gt = (float) (GROSS_REVENUE_LOCAL_gt / ACTIVE_SUBSCRIBERS_gt);
				} catch (Exception e) {
				}

				HR0_gt = "-";
				HR1_gt = "-";
				HR2_gt = "-";
				HR3_gt = "-";
				HR4_gt = "-";
				HR5_gt = "-";
				HR6_gt = "-";
				HR7_gt = "-";
				HR8_gt = "-";
				HR9_gt = "-";
				HR10_gt = "-";
				HR11_gt = "-";
				HR12_gt = "-";
				HR13_gt = "-";
				HR14_gt = "-";
				HR15_gt = "-";
				HR16_gt = "-";
				HR17_gt = "-";
				HR18_gt = "-";
				HR19_gt = "-";
				HR20_gt = "-";
				HR21_gt = "-";
				HR22_gt = "-";
				HR23_gt = "-";

			}

			HashMap<String, String> ht = new HashMap<String, String>();
			ht.put("DATE_TIME", "Total");
			ht.put("TOTAL_CALLS", "" + TOTAL_CALLS_gt);
			ht.put("SUBS_USERS_CALLS", "" + SUBS_USERS_CALLS_gt);
			ht.put("NON_SUBS_USERS_CALLS", "" + NON_SUBS_USERS_CALLS_gt);
			ht.put("TOTAL_MOUS", "" + TOTAL_MOUS_gt);
			ht.put("SUBS_USERS_MOU", "" + SUBS_USERS_MOU_gt);
			ht.put("NON_SUBS_USERS_MOU", "" + NON_SUBS_USERS_MOU_gt);
			ht.put("TOTAL_PULSES", "" + TOTAL_PULSES_gt);
			ht.put("SUBS_USERS_PULSES", "" + SUBS_USERS_PULSES_gt);
			ht.put("NON_SUBS_USERS_PULSES", "" + NON_SUBS_USERS_PULSES_gt);
			ht.put("TOTAL_UNIQUE_CALLERS", "" + TOTAL_UNIQUE_CALLERS_gt);
			ht.put("UNIQUE_SUBS_CALLERS", "" + UNIQUE_SUBS_CALLERS_gt);
			ht.put("UNIQUE_NON_SUBS_CALLERS", "" + UNIQUE_NON_SUBS_CALLERS_gt);
			ht.put("CP_DAILY_PACK", "" + CP_DAILY_PACK_gt);
			ht.put("CP_WEEKLY_PACK", "" + CP_WEEKLY_PACK_gt);
			ht.put("CP_FORTNIGHTLY_PACK", "" + CP_FORTNIGHTLY_PACK_gt);
			ht.put("CP_MONTHLY_PACK", "" + CP_MONTHLY_PACK_gt);
			ht.put("CP_VOLUNTARY_UNSUBS", "" + CP_VOLUNTARY_UNSUBS_gt);
			ht.put("CP_INVOLUNTARY_UNSUBS", "" + CP_INVOLUNTARY_UNSUBS_gt);
			ht.put("CP_GROSS_ADDS", "" + CP_GROSS_ADDS_gt);
			ht.put("ISP_DAILY_PACK", "" + ISP_DAILY_PACK_gt);
			ht.put("ISP_WEEKLY_PACK", "" + ISP_WEEKLY_PACK_gt);
			ht.put("ISP_FORTNIGHTLY_PACK", "" + ISP_FORTNIGHTLY_PACK_gt);
			ht.put("ISP_MONTHLY_PACK", "" + ISP_MONTHLY_PACK_gt);
			ht.put("ISP_VOLUNTARY_UNSUBS", "" + ISP_VOLUNTARY_UNSUBS_gt);
			ht.put("ISP_INVOLUNTARY_UNSUBS", "" + ISP_INVOLUNTARY_UNSUBS_gt);
			ht.put("ISP_GROSS_ADDS", "" + ISP_GROSS_ADDS_gt);
			ht.put("CP_DAILY_RE_PACK", "" + CP_DAILY_RE_PACK_gt);
			ht.put("CP_WEEKLY_RE_PACK", "" + CP_WEEKLY_RE_PACK_gt);
			ht.put("CP_FORTNIGHTLY_RE_PACK", "" + CP_FORTNIGHTLY_RE_PACK_gt);
			ht.put("CP_MONTHLY_RE_PACK", "" + CP_MONTHLY_RE_PACK_gt);
			ht.put("ISP_DAILY_RE_PACK", "" + ISP_DAILY_RE_PACK_gt);
			ht.put("ISP_WEEKLY_RE_PACK", "" + ISP_WEEKLY_RE_PACK_gt);
			ht.put("ISP_FORTNIGHTLY_RE_PACK", "" + ISP_FORTNIGHTLY_RE_PACK_gt);
			ht.put("ISP_MONTHLY_RE_PACK", "" + ISP_MONTHLY_RE_PACK_gt);
			ht.put("TOPUP1", "" + TOPUP1_gt);
			ht.put("TOPUP2", "" + TOPUP2_gt);
			ht.put("TOPUP3", "" + TOPUP3_gt);
			ht.put("TOPUP4", "" + TOPUP4_gt);
			ht.put("IVR_SUBS", "" + IVR_SUBS_gt);
			ht.put("CCI_SUBS", "" + CCI_SUBS_gt);
			ht.put("OBD_SUBS", "" + OBD_SUBS_gt);
			ht.put("SMS_SUBS", "" + SMS_SUBS_gt);
			ht.put("IBD_SUBS", "" + IBD_SUBS_gt);
			ht.put("USSD_SUBS", "" + USSD_SUBS_gt);
			ht.put("OTHERS_SUBS", "" + OTHERS_SUBS_gt);
			ht.put("IVR_UNSUBS", "" + IVR_UNSUBS_gt);
			ht.put("CCI_UNSUBS", "" + CCI_UNSUBS_gt);
			ht.put("SMS_UNSUBS", "" + SMS_UNSUBS_gt);
			ht.put("USSD_UNSUBS", "" + USSD_UNSUBS_gt);
			ht.put("APP_UNSUB", "" + APP_UNSUB_gt);
			ht.put("OTHERS_UNSUB", "" + OTHERS_UNSUB_gt);
			ht.put("DAILY_GIFT", "" + DAILY_GIFT_gt);
			ht.put("WEEKLY_GIFT", "" + WEEKLY_GIFT_gt);
			ht.put("FORTNIGHTLY_GIFT", "" + FORTNIGHTLY_GIFT_gt);
			ht.put("MONTHLY_GIFT", "" + MONTHLY_GIFT_gt);
			ht.put("BROWSING_REVENUE", "" + df.format(BROWSING_REVENUE_gt));
			ht.put("ISP_DAILY_REVENUE", "" + df.format(ISP_DAILY_REVENUE_gt));
			ht.put("ISP_WEEKLY_REVENUE", "" + df.format(ISP_WEEKLY_REVENUE_gt));
			ht.put("ISP_FORTNIGHTLY_REVENUE", "" + df.format(ISP_FORTNIGHTLY_REVENUE_gt));
			ht.put("ISP_MONTHLY_REVENUE", "" + df.format(ISP_MONTHLY_REVENUE_gt));
			ht.put("CP_DAILY_REVENUE", "" + df.format(CP_DAILY_REVENUE_gt));
			ht.put("CP_WEEKLY_REVENUE", "" + df.format(CP_WEEKLY_REVENUE_gt));
			ht.put("CP_FORTNIGHTLY_REVENUE", "" + df.format(CP_FORTNIGHTLY_REVENUE_gt));
			ht.put("CP_MONTHLY_REVENUE", "" + df.format(CP_MONTHLY_REVENUE_gt));
			ht.put("TOPUP1_REVENUE", "" + df.format(TOPUP1_REVENUE_gt));
			ht.put("TOPUP2_REVENUE", "" + df.format(TOPUP2_REVENUE_gt));
			ht.put("TOPUP3_REVENUE", "" + df.format(TOPUP3_REVENUE_gt));
			ht.put("TOPUP4_REVENUE", "" + df.format(TOPUP4_REVENUE_gt));
			ht.put("SUBSCBINTION_DAILY_REVENUE", "" + df.format(SUBSCBINTION_DAILY_REVENUE_gt));
			ht.put("SUBSCBINTION_WEEKLY_REVENUE", "" + df.format(SUBSCBINTION_WEEKLY_REVENUE_gt));
			ht.put("SUBSCBINTION_FORTNIGHTLY_REVENUE", "" + df.format(SUBSCBINTION_FORTNIGHTLY_REVENUE_gt));
			ht.put("SUBSCBINTION_MONTHLY_REVENUE", "" + df.format(SUBSCBINTION_MONTHLY_REVENUE_gt));
			ht.put("GROSS_REVENUE_LOCAL", "" + df.format(GROSS_REVENUE_LOCAL_gt));
			ht.put("GROSS_REVENUE_USD", "" + df.format(GROSS_REVENUE_USD_gt));
			ht.put("CP_ACTIVE_SUBSCRIBERS", "" + CP_ACTIVE_SUBSCRIBERS_gt);
			ht.put("ISP_ACTIVE_SUBSCRIBERS", "" + ISP_ACTIVE_SUBSCRIBERS_gt);
			ht.put("BILLED_SUBSCRIBERS", "" + BILLED_SUBSCRIBERS_gt);
			ht.put("CALLING_SUBSCRIBERS", "" + CALLING_SUBSCRIBERS_gt);
			ht.put("SERVICE_OBD_TOTAL_CALLS", "" + SERVICE_OBD_TOTAL_CALLS_gt);
			ht.put("SERVICE_OBD_SUCCESS_CALLS", "" + SERVICE_OBD_SUCCESS_CALLS_gt);
			ht.put("SERVICE_OBD_FAIL_CALLS", "" + SERVICE_OBD_FAIL_CALLS_gt);
			ht.put("AVG_CALL_UNIQUE", "" + AVG_CALL_UNIQUE_gt);
			ht.put("AVG_MOU_UNIQUE", "" + AVG_MOU_UNIQUE_gt);
			ht.put("AVG_MOU_CALL", "" + AVG_MOU_CALL_gt);
			ht.put("UNIQUE_CALLER_ACTIVE", "" + UNIQUE_CALLER_ACTIVE_gt);
			ht.put("SERVICE_PENETRATION", "" + SERVICE_PENETRATION_gt);
			ht.put("ARPU", "" + ARPU_gt);
			ht.put("ACTIVE_TO_GRACE", "" + ACTIVE_TO_GRACE_gt);
			ht.put("GRACE_TO_ACTIVE", "" + GRACE_TO_ACTIVE_gt);
			ht.put("GRACE1TO7", "" + GRACE1TO7_gt);
			ht.put("GRACE8TO14", "" + GRACE8TO14_gt);
			ht.put("GRACE15TO21", "" + GRACE15TO21_gt);
			ht.put("GRACE22TO30", "" + GRACE22TO30_gt);
			ht.put("MIN1", "" + MIN1_gt);
			ht.put("MIN2", "" + MIN2_gt);
			ht.put("MIN3", "" + MIN3_gt);
			ht.put("MIN4", "" + MIN4_gt);
			ht.put("MIN5", "" + MIN5_gt);
			ht.put("MIN6", "" + MIN6_gt);
			ht.put("MIN7", "" + MIN7_gt);
			ht.put("MIN8", "" + MIN8_gt);
			ht.put("MIN9", "" + MIN9_gt);
			ht.put("MIN10", "" + MIN10_gt);
			ht.put("MIN10ABOVE", "" + MIN10ABOVE_gt);
			ht.put("HR0", "" + HR0_gt);
			ht.put("HR1", "" + HR1_gt);
			ht.put("HR2", "" + HR2_gt);
			ht.put("HR3", "" + HR3_gt);
			ht.put("HR4", "" + HR4_gt);
			ht.put("HR5", "" + HR5_gt);
			ht.put("HR6", "" + HR6_gt);
			ht.put("HR7", "" + HR7_gt);
			ht.put("HR8", "" + HR8_gt);
			ht.put("HR9", "" + HR9_gt);
			ht.put("HR10", "" + HR10_gt);
			ht.put("HR11", "" + HR11_gt);
			ht.put("HR12", "" + HR12_gt);
			ht.put("HR13", "" + HR13_gt);
			ht.put("HR14", "" + HR14_gt);
			ht.put("HR15", "" + HR15_gt);
			ht.put("HR16", "" + HR16_gt);
			ht.put("HR17", "" + HR17_gt);
			ht.put("HR18", "" + HR18_gt);
			ht.put("HR19", "" + HR19_gt);
			ht.put("HR20", "" + HR20_gt);
			ht.put("HR21", "" + HR21_gt);
			ht.put("HR22", "" + HR22_gt);
			ht.put("HR23", "" + HR23_gt);

			revenueData.add(ht);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception in cust_getRevenueMISData method::" + e);

		} finally {
			try {
				rs.close();
				pstmt.close();
				// pstmt1.close();
				// pstmt2.close();
				// pstmt3.close();

			} catch (SQLException ex) {
				logger.info(
						"exception while closing the resultset and prepared statement in cust_getRevenueMISData method ::"
								+ ex);

			}
		}
		}
		
		else
		{
			logger.info("---Connection is not established with Database--");
		}

		return revenueData;

	}

	public static synchronized ResultSet getActSourceCount_bkp(String startDate, String endDate,
			boolean f) {
		CallableStatement callstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		conn = (Connection)session.getAttribute("active_connection");
		
		if(conn!=null)
		{
		try {
			if (f) {
				callstmt = conn.prepareCall("{call Devotional.PROC_PROMOTION_TRACKER(0)}");
				logger.info(" Devotional.PROC_PROMOTION_TRACKER executed " + callstmt.execute());
			}
			logger.info(
					"SQL of getActSourceCount ::   SELECT date_time,act_source,HR0,HR1,HR2,HR3,HR4,HR5,HR6,HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,total_succ,total_fail  FROM Devotional.tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   '"
							+ startDate + "'  AND  '" + endDate + "'   ORDER BY  date_time DESC  ");
			pstmt = conn.prepareStatement(
					" SELECT date(date_time) as date_time,act_source,HR0,HR1,HR2,HR3,HR4,HR5,HR6,HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,total_succ,total_fail  FROM Devotional.tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   ?  AND  ?  ORDER BY  date_time DESC  ");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		else
		{
			logger.info("---Connection is not established with Database--");
		}
			

		return rs;
	}

	public static synchronized ArrayList getActSourceCount(String startDate, String endDate,
			boolean f) {
		ArrayList revenueData = new ArrayList();
		CallableStatement callstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		conn = (Connection)session.getAttribute("active_connection");
		
		if(conn!=null)
		{
		try {
			if (f) {
				callstmt = conn.prepareCall("{call Devotional.PROC_PROMOTION_TRACKER(0)}");
				logger.info(" Devotional.PROC_PROMOTION_TRACKER executed " + callstmt.execute());
			}
			logger.info(
					"SQL of getActSourceCount ::   SELECT date_time,act_source,HR0,HR1,HR2,HR3,HR4,HR5,HR6,HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,total_succ,total_fail  FROM tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   '"
							+ startDate + "'  AND  '" + endDate + "'   ORDER BY  date_time DESC  ");
			pstmt = conn.prepareStatement(
					" SELECT date(date_time) as date_time,act_source,HR0,HR0_succ,HR0_fail,HR1,HR1_succ,HR1_fail,HR2,HR2_succ,HR2_fail,HR3,HR3_succ,HR3_fail,HR4,HR4_succ,HR4_fail,HR5,HR5_succ,HR5_fail,HR6,HR6_succ,HR6_fail,HR7,HR7_succ,HR7_fail,HR8,HR8_succ,HR8_fail,HR9,HR9_succ,HR9_fail,HR10,HR10_succ,HR10_fail,HR11,HR11_succ,HR11_fail,HR12,HR12_succ,HR12_fail,HR13,HR13_succ,HR13_fail,HR14,HR14_succ,HR14_fail,HR15,HR15_succ,HR15_fail,HR16,HR16_succ,HR16_fail,HR17,HR17_succ,HR17_fail,HR18,HR18_succ,HR18_fail,HR19,HR19_succ,HR19_fail,HR20,HR20_succ,HR20_fail,HR21,HR21_succ,HR21_fail,HR22,HR22_succ,HR22_fail,HR23,HR23_succ,HR23_fail,total,total_succ,total_fail  FROM tbl_promotion_tracker  WHERE DATE(date_time) BETWEEN   ?  AND  ?  ORDER BY  date_time DESC  ");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();

				String str_SUMMARY_DATE = getSdf().format(rs.getDate("DATE_TIME"));
				map.put("DATE_TIME", str_SUMMARY_DATE);
				String act_source = rs.getString("act_source");
				if (rs.wasNull()) {
					act_source = "-";
				}
				map.put("ACT_SOURCE", act_source);

				int HR0 = rs.getInt("HR0");
				if (rs.wasNull()) {
					HR0 = 0;
				}
				map.put("HR0", String.valueOf(HR0));
				int HR1 = rs.getInt("HR1");
				if (rs.wasNull()) {
					HR1 = 0;
				}
				map.put("HR1", String.valueOf(HR1));

				int HR2 = rs.getInt("HR2");
				if (rs.wasNull()) {
					HR2 = 0;
				}
				map.put("HR2", String.valueOf(HR2));

				int HR3 = rs.getInt("HR3");
				if (rs.wasNull()) {
					HR3 = 0;
				}
				map.put("HR3", String.valueOf(HR3));

				int HR4 = rs.getInt("HR4");
				if (rs.wasNull()) {
					HR4 = 0;
				}
				map.put("HR4", String.valueOf(HR4));

				int HR5 = rs.getInt("HR5");
				if (rs.wasNull()) {
					HR5 = 0;
				}
				map.put("HR5", String.valueOf(HR5));

				int HR6 = rs.getInt("HR6");
				if (rs.wasNull()) {
					HR6 = 0;
				}
				map.put("HR6", String.valueOf(HR6));

				int HR7 = rs.getInt("HR7");
				if (rs.wasNull()) {
					HR7 = 0;
				}
				map.put("HR7", String.valueOf(HR7));

				int HR8 = rs.getInt("HR8");
				if (rs.wasNull()) {
					HR8 = 0;
				}
				map.put("HR8", String.valueOf(HR8));

				int HR9 = rs.getInt("HR9");
				if (rs.wasNull()) {
					HR9 = 0;
				}
				map.put("HR9", String.valueOf(HR9));

				int HR10 = rs.getInt("HR10");
				if (rs.wasNull()) {
					HR10 = 0;
				}
				map.put("HR10", String.valueOf(HR10));

				int HR11 = rs.getInt("HR11");
				if (rs.wasNull()) {
					HR11 = 0;
				}
				map.put("HR11", String.valueOf(HR11));

				int HR12 = rs.getInt("HR12");
				if (rs.wasNull()) {
					HR12 = 0;
				}
				map.put("HR12", String.valueOf(HR12));

				int HR13 = rs.getInt("HR13");
				if (rs.wasNull()) {
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
				if (rs.wasNull()) {
					HR16 = 0;
				}
				map.put("HR16", String.valueOf(HR16));

				int HR17 = rs.getInt("HR17");
				if (rs.wasNull()) {
					HR17 = 0;
				}
				map.put("HR17", String.valueOf(HR17));

				int HR18 = rs.getInt("HR18");
				if (rs.wasNull()) {
					HR18 = 0;
				}
				map.put("HR18", String.valueOf(HR18));

				int HR19 = rs.getInt("HR19");
				if (rs.wasNull()) {
					HR19 = 0;
				}
				map.put("HR19", String.valueOf(HR19));

				int HR20 = rs.getInt("HR20");
				if (rs.wasNull()) {
					HR20 = 0;
				}
				map.put("HR20", String.valueOf(HR20));

				int HR21 = rs.getInt("HR21");
				if (rs.wasNull()) {
					HR21 = 0;
				}
				map.put("HR21", String.valueOf(HR21));

				int HR22 = rs.getInt("HR22");
				if (rs.wasNull()) {
					HR22 = 0;
				}
				map.put("HR22", String.valueOf(HR22));

				int HR23 = rs.getInt("HR23");
				if (rs.wasNull()) {
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
				if (rs.wasNull()) {
					HR3_succ = 0;
				}
				map.put("HR3_succ", String.valueOf(HR3_succ));

				int HR4_succ = rs.getInt("HR4_succ");
				if (rs.wasNull()) {
					HR4_succ = 0;
				}
				map.put("HR4_succ", String.valueOf(HR4_succ));

				int HR5_succ = rs.getInt("HR5_succ");
				if (rs.wasNull()) {
					HR5_succ = 0;
				}
				map.put("HR5_succ", String.valueOf(HR5_succ));

				int HR6_succ = rs.getInt("HR6_succ");
				if (rs.wasNull()) {
					HR6_succ = 0;
				}
				map.put("HR6_succ", String.valueOf(HR6_succ));

				int HR7_succ = rs.getInt("HR7_succ");
				if (rs.wasNull()) {
					HR7_succ = 0;
				}
				map.put("HR7_succ", String.valueOf(HR7_succ));

				int HR8_succ = rs.getInt("HR8_succ");
				if (rs.wasNull()) {
					HR8_succ = 0;
				}
				map.put("HR8_succ", String.valueOf(HR8_succ));

				int HR9_succ = rs.getInt("HR9_succ");
				if (rs.wasNull()) {
					HR9_succ = 0;
				}
				map.put("HR9_succ", String.valueOf(HR9_succ));

				int HR10_succ = rs.getInt("HR10_succ");
				if (rs.wasNull()) {
					HR10_succ = 0;
				}
				map.put("HR10_succ", String.valueOf(HR10_succ));

				int HR11_succ = rs.getInt("HR11_succ");
				if (rs.wasNull()) {
					HR11_succ = 0;
				}
				map.put("HR11_succ", String.valueOf(HR11_succ));

				int HR12_succ = rs.getInt("HR12_succ");
				if (rs.wasNull()) {
					HR12_succ = 0;
				}
				map.put("HR12_succ", String.valueOf(HR12_succ));

				int HR13_succ = rs.getInt("HR13_succ");
				if (rs.wasNull()) {
					HR13_succ = 0;
				}
				map.put("HR13_succ", String.valueOf(HR13_succ));

				int HR14_succ = rs.getInt("HR14_succ");
				if (rs.wasNull()) {
					HR14_succ = 0;
				}
				map.put("HR14_succ", String.valueOf(HR14_succ));

				int HR15_succ = rs.getInt("HR15_succ");
				if (rs.wasNull()) {
					HR15_succ = 0;
				}
				map.put("HR15_succ", String.valueOf(HR15_succ));

				int HR16_succ = rs.getInt("HR16_succ");
				if (rs.wasNull()) {
					HR16_succ = 0;
				}
				map.put("HR16_succ", String.valueOf(HR16_succ));

				int HR17_succ = rs.getInt("HR17_succ");
				if (rs.wasNull()) {
					HR17_succ = 0;
				}
				map.put("HR17_succ", String.valueOf(HR17_succ));

				int HR18_succ = rs.getInt("HR18_succ");
				if (rs.wasNull()) {
					HR18_succ = 0;
				}
				map.put("HR18_succ", String.valueOf(HR18_succ));

				int HR19_succ = rs.getInt("HR19_succ");
				if (rs.wasNull()) {
					HR19_succ = 0;
				}
				map.put("HR19_succ", String.valueOf(HR19_succ));

				int HR20_succ = rs.getInt("HR20_succ");
				if (rs.wasNull()) {
					HR20_succ = 0;
				}
				map.put("HR20_succ", String.valueOf(HR20_succ));

				int HR21_succ = rs.getInt("HR21_succ");
				if (rs.wasNull()) {
					HR21_succ = 0;
				}
				map.put("HR21_succ", String.valueOf(HR21_succ));

				int HR22_succ = rs.getInt("HR22_succ");
				if (rs.wasNull()) {
					HR22_succ = 0;
				}
				map.put("HR22_succ", String.valueOf(HR22_succ));

				int HR23_succ = rs.getInt("HR23_succ");
				if (rs.wasNull()) {
					HR23_succ = 0;
				}
				map.put("HR23_succ", String.valueOf(HR23_succ));

				int HR0_fail = rs.getInt("HR0_fail");
				if (rs.wasNull()) {
					HR0_fail = 0;
				}
				map.put("HR0_fail", String.valueOf(HR0_fail));

				int HR1_fail = rs.getInt("HR1_fail");
				if (rs.wasNull()) {
					HR1_fail = 0;
				}
				map.put("HR1_fail", String.valueOf(HR1_fail));

				int HR2_fail = rs.getInt("HR2_fail");
				if (rs.wasNull()) {
					HR2_fail = 0;
				}
				map.put("HR2_fail", String.valueOf(HR2_fail));

				int HR3_fail = rs.getInt("HR3_fail");
				if (rs.wasNull()) {
					HR3_fail = 0;
				}
				map.put("HR3_fail", String.valueOf(HR3_fail));

				int HR4_fail = rs.getInt("HR4_fail");
				if (rs.wasNull()) {
					HR4_fail = 0;
				}
				map.put("HR4_fail", String.valueOf(HR4_fail));

				int HR5_fail = rs.getInt("HR5_fail");
				if (rs.wasNull()) {
					HR5_fail = 0;
				}
				map.put("HR5_fail", String.valueOf(HR5_fail));

				int HR6_fail = rs.getInt("HR6_fail");
				if (rs.wasNull()) {
					HR6_fail = 0;
				}
				map.put("HR6_fail", String.valueOf(HR6_fail));

				int HR7_fail = rs.getInt("HR7_fail");
				if (rs.wasNull()) {
					HR7_fail = 0;
				}
				map.put("HR7_fail", String.valueOf(HR7_fail));

				int HR8_fail = rs.getInt("HR8_fail");
				if (rs.wasNull()) {
					HR8_fail = 0;
				}
				map.put("HR8_fail", String.valueOf(HR8_fail));

				int HR9_fail = rs.getInt("HR9_fail");
				if (rs.wasNull()) {
					HR9_fail = 0;
				}
				map.put("HR9_fail", String.valueOf(HR9_fail));

				int HR10_fail = rs.getInt("HR10_fail");
				if (rs.wasNull()) {
					HR10_fail = 0;
				}
				map.put("HR10_fail", String.valueOf(HR10_fail));

				int HR11_fail = rs.getInt("HR11_fail");
				if (rs.wasNull()) {
					HR11_fail = 0;
				}
				map.put("HR11_fail", String.valueOf(HR11_fail));

				int HR12_fail = rs.getInt("HR12_fail");
				if (rs.wasNull()) {
					HR12_fail = 0;
				}
				map.put("HR12_fail", String.valueOf(HR12_fail));

				int HR13_fail = rs.getInt("HR13_fail");
				if (rs.wasNull()) {
					HR13_fail = 0;
				}
				map.put("HR13_fail", String.valueOf(HR13_fail));

				int HR14_fail = rs.getInt("HR14_fail");
				if (rs.wasNull()) {
					HR14_fail = 0;
				}
				map.put("HR14_fail", String.valueOf(HR14_fail));

				int HR15_fail = rs.getInt("HR15_fail");
				if (rs.wasNull()) {
					HR15_fail = 0;
				}
				map.put("HR15_fail", String.valueOf(HR15_fail));

				int HR16_fail = rs.getInt("HR16_fail");
				if (rs.wasNull()) {
					HR16_fail = 0;
				}
				map.put("HR16_fail", String.valueOf(HR16_fail));

				int HR17_fail = rs.getInt("HR17_fail");
				if (rs.wasNull()) {
					HR17_fail = 0;
				}
				map.put("HR17_fail", String.valueOf(HR17_fail));

				int HR18_fail = rs.getInt("HR18_fail");
				if (rs.wasNull()) {
					HR18_fail = 0;
				}
				map.put("HR18_fail", String.valueOf(HR18_fail));

				int HR19_fail = rs.getInt("HR19_fail");
				if (rs.wasNull()) {
					HR19_fail = 0;
				}
				map.put("HR19_fail", String.valueOf(HR19_fail));

				int HR20_fail = rs.getInt("HR20_fail");
				if (rs.wasNull()) {
					HR20_fail = 0;
				}
				map.put("HR20_fail", String.valueOf(HR20_fail));

				int HR21_fail = rs.getInt("HR21_fail");
				if (rs.wasNull()) {
					HR21_fail = 0;
				}
				map.put("HR21_fail", String.valueOf(HR21_fail));

				int HR22_fail = rs.getInt("HR22_fail");
				if (rs.wasNull()) {
					HR22_fail = 0;
				}
				map.put("HR22_fail", String.valueOf(HR22_fail));

				int HR23_fail = rs.getInt("HR23_fail");
				if (rs.wasNull()) {
					HR23_fail = 0;
				}
				map.put("HR23_fail", String.valueOf(HR23_fail));

				int total = rs.getInt("total");
				if (rs.wasNull()) {
					total = 0;
				}
				map.put("total", String.valueOf(total));

				int total_succ = rs.getInt("total_succ");
				if (rs.wasNull()) {
					total_succ = 0;
				}
				map.put("total_succ", String.valueOf(total_succ));

				int total_fail = rs.getInt("total_fail");
				if (rs.wasNull()) {
					total_fail = 0;
				}
				map.put("total_fail", String.valueOf(total_fail));

				revenueData.add(map);

			}

		} catch (Exception e) {
			logger.info("fail in dao method.....................");
			e.printStackTrace();
		}
		}
		
		else
		{
			logger.info("---Connection is not established with Database--");
		}
		
		return revenueData;
		
	}

	/**
	 * @return the sdf
	 */
	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	/**
	 * @param aSdf
	 *            the sdf to set
	 */
	public static void setSdf(SimpleDateFormat aSdf) {
		sdf = aSdf;
	}

}
