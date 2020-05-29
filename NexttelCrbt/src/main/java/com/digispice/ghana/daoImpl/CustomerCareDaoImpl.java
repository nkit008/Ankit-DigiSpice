package com.digispice.ghana.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.CustomerCareDao;

@Repository
public class CustomerCareDaoImpl implements CustomerCareDao {

	private final static Logger logger = LoggerFactory.getLogger(CustomerCareDaoImpl.class.getName());
	private PreparedStatement pstmt = null;
	private CallableStatement cst = null;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
	SimpleDateFormat dbDateFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static Connection con = null;

	@Override
	public String unSubsCustomer(String ani) {
		String outPara = null;
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				logger.info("Unsubscribe the ani " + ani);
				String para1 = "UNSUB#" + ani + "#" + ani + "#CCI#CRBT_SUB1#ack#f#1#6";
				logger.info("calling procedure PROC_REQUEST_MASTER()");
				cst = con.prepareCall("{call PROC_REQUEST_MASTER(?,?)}");
				cst.setString(1, para1);
				cst.executeUpdate();
				logger.info("result in outpara: " + cst.getString(2));
				outPara = cst.getString(2);
				return outPara;
			}
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Map<String, String>> fetchSUBDetail(String msisdn, String userId, String IP) {
		logger.info("Number for check Status is --- " + msisdn);
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				ArrayList<Map<String, String>> subDetail = new ArrayList<Map<String, String>>();
				String query = GetConnection.loadProp("SQL_SUBS");
				logger.info("Query to be Exceuted ---" + query);

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, msisdn);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					HashMap<String, String> h = new HashMap<String, String>();

					String LANGUAGE = rs.getString("LANGUAGE");
					if (rs.wasNull()) {
						LANGUAGE = "-";
					}

					String STATUS = rs.getString("STATUS");
					if (rs.wasNull()) {
						STATUS = "-";
					} else {
						STATUS = GetConnection.loadProp(STATUS);
					}
					String SUB_DATE = rs.getString("SUB_DATE");
					if (rs.wasNull()) {
						SUB_DATE = "-";
					} else {
						SUB_DATE = sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
					}

					String RENEW_DATE = rs.getString("RENEW_DATE");
					if (rs.wasNull()) {
						RENEW_DATE = "-";
					} else {
						RENEW_DATE = sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
					}

					String BILLING_DATE = rs.getString("BILLING_DATE");
					if (rs.wasNull()) {
						BILLING_DATE = "-";
					} else {
						BILLING_DATE = sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
					}

					String AMOUNT = rs.getString("AMOUNT");
					if (rs.wasNull()) {
						AMOUNT = "-";
					}

					String PACK_TYPE = rs.getString("PACK_TYPE");
					if (rs.wasNull()) {
						PACK_TYPE = "-";
					}

					String ACT_SOURCE = rs.getString("ACT_SOURCE");
					if (rs.wasNull()) {
						ACT_SOURCE = "-";
					}

					String DAYS = rs.getString("DAYS");
					if (rs.wasNull()) {
						DAYS = "-";
					}
					h.put("DAYS", DAYS);
					h.put("MOBILE_NUMBER", msisdn);
					h.put("LANGUAGE", LANGUAGE);
					h.put("AMOUNT", AMOUNT);
					h.put("STATUS", STATUS);
					h.put("SUB_DATE", SUB_DATE);
					h.put("RENEW_DATE", RENEW_DATE);
					h.put("BILLING_DATE", BILLING_DATE);
					h.put("PACK_TYPE", PACK_TYPE);
					h.put("ACT_SOURCE", ACT_SOURCE);

					subDetail.add(h);
				}
				logger.info("size of subdetail " + subDetail.size());
				return subDetail;

			}

		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Map<String, String>> fetchCRBTSUBDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> subDetail = new ArrayList<Map<String, String>>();
		String prepStmtSql = GetConnection.loadProp("SQL_TONE_SUBS");
		pstmt = null;
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				pstmt = con.prepareStatement(prepStmtSql, 1004, 1007);
				pstmt.setString(1, msisdn);
				logger.info("Query to be Executed ---" + prepStmtSql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					HashMap<String, String> h = new HashMap<String, String>();

					String LANGUAGE = rs.getString("LANGUAGE");
					if (rs.wasNull()) {
						LANGUAGE = "-";
					}

					String TONE_CODE = rs.getString("TONE_CODE");
					if (rs.wasNull()) {
						TONE_CODE = "-";
					}

					String STATUS = rs.getString("STATUS");
					if (rs.wasNull()) {
						STATUS = "-";
					} else {
						STATUS = GetConnection.loadProp(STATUS);
					}
					String SUB_DATE = rs.getString("SUB_DATE");
					if (rs.wasNull()) {
						SUB_DATE = "-";
					} else {
						SUB_DATE = sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
					}

					String RENEW_DATE = rs.getString("RENEW_DATE");
					if (rs.wasNull()) {
						RENEW_DATE = "-";
					} else {
						RENEW_DATE = sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
					}

					String BILLING_DATE = rs.getString("BILLING_DATE");
					if (rs.wasNull()) {
						BILLING_DATE = "-";
					} else {
						BILLING_DATE = sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
					}

					String AMOUNT = rs.getString("AMOUNT");
					if (rs.wasNull()) {
						AMOUNT = "-";
					}

					String PACK_TYPE = rs.getString("PACK_TYPE");
					if (rs.wasNull()) {
						PACK_TYPE = "-";
					}

					String ACT_SOURCE = rs.getString("ACT_SOURCE");
					if (rs.wasNull()) {
						ACT_SOURCE = "-";
					}

					String RBT_NAME = rs.getString("RBT_NAME");
					if (rs.wasNull()) {
						RBT_NAME = "-";
					}

					String DAYS = rs.getString("DAYS");
					if (rs.wasNull()) {
						DAYS = "-";
					}
					h.put("DAYS", DAYS);
					h.put("MOBILE_NUMBER", msisdn);
					h.put("LANGUAGE", LANGUAGE);
					h.put("AMOUNT", AMOUNT);
					h.put("STATUS", STATUS);
					h.put("SUB_DATE", SUB_DATE);
					h.put("RENEW_DATE", RENEW_DATE);
					h.put("BILLING_DATE", BILLING_DATE);
					h.put("PACK_TYPE", PACK_TYPE);
					h.put("ACT_SOURCE", ACT_SOURCE);
					h.put("RBT_NAME", RBT_NAME);
					h.put("TONE_CODE", TONE_CODE);

					subDetail.add(h);

				}

				return subDetail;
			}

		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Map<String, String>> fetchUNSUBDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> unsubDetail = new ArrayList<Map<String, String>>();
		String prepStmtSql = GetConnection.loadProp("SQL_UNSUBSCRIPTION");
		pstmt = null;
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				pstmt = con.prepareStatement(prepStmtSql);
				pstmt.setString(1, msisdn);
				logger.info("Query to be Executed ---" + prepStmtSql);
				rs = pstmt.executeQuery();
				while (rs.next()) {

					String MOBILE_NUMBER = rs.getString("MOBILE_NUMBER");
					if (rs.wasNull()) {
						MOBILE_NUMBER = "-";
					}

					String LANGUAGE = rs.getString("LANGUAGE");
					if (rs.wasNull()) {
						LANGUAGE = "-";
					}

					String SUB_DATE = rs.getString("SUB_DATE");
					if (rs.wasNull()) {
						SUB_DATE = "-";
					}

					String RENEW_DATE = rs.getString("RENEW_DATE");
					if (rs.wasNull()) {
						RENEW_DATE = "-";
					}

					String BILLING_DATE = rs.getString("BILLING_DATE");
					if (rs.wasNull()) {
						BILLING_DATE = "-";
					}

					String UNSUB_DATE = rs.getString("UNSUB_DATE");
					if (rs.wasNull()) {
						UNSUB_DATE = "-";
					}

					String STATUS = rs.getString("STATUS");
					if (rs.wasNull()) {
						STATUS = "-";
					}

					String ACT_SOURCE = rs.getString("ACT_SOURCE");
					if (rs.wasNull()) {
						ACT_SOURCE = "-";
					}

					String UNSUB_SOURCE = rs.getString("UNSUB_SOURCE");
					if (rs.wasNull()) {
						UNSUB_SOURCE = "-";
					}

					String AMOUNT = rs.getString("AMOUNT");
					if (rs.wasNull()) {
						AMOUNT = "NA";
					}

					String PACK_TYPE = rs.getString("PACK_TYPE");
					if (rs.wasNull()) {
						PACK_TYPE = "NA";
					}

					HashMap<String, String> h = new HashMap<String, String>();
					h.put("MOBILE_NUMBER", MOBILE_NUMBER);
					h.put("LANGUAGE", LANGUAGE);
					h.put("SUB_DATE", SUB_DATE);
					h.put("RENEW_DATE", RENEW_DATE);
					h.put("BILLING_DATE", BILLING_DATE);
					h.put("UNSUB_DATE", UNSUB_DATE);
					h.put("STATUS", STATUS);
					h.put("ACT_SOURCE", ACT_SOURCE);
					h.put("UNSUB_SOURCE", UNSUB_SOURCE);
					h.put("AMOUNT", AMOUNT);
					h.put("PACK_TYPE", PACK_TYPE);
					unsubDetail.add(h);
				}

				return unsubDetail;

			}
		} catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public ArrayList<Map<String, String>> fetchSMSRenewalDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> fetchSMSRenewal = new ArrayList<Map<String, String>>();
		String prepStmtSql = GetConnection.loadProp("SQL_SMS_RENEWAL_ALERT");
		pstmt = null;
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				logger.info("Query to be Executed ---" + prepStmtSql);
				pstmt = con.prepareStatement(prepStmtSql);
				pstmt.setString(1, msisdn);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					HashMap<String, String> h = new HashMap<String, String>();
					String ani = msisdn.trim();

					String MSG = rs.getString("MSG");
					if (rs.wasNull()) {
						MSG = "NA";
					}

					String INSERT_TIME = rs.getString("INSERT_TIME");
					if (rs.wasNull()) {
						INSERT_TIME = "NA";
					} else {
						INSERT_TIME = sdf.format(dbDateFmt.parse(rs.getString("INSERT_TIME")));
					}

					String SENT_TIME = rs.getString("SENT_TIME");
					if (rs.wasNull()) {
						SENT_TIME = "NA";
					} else {
						SENT_TIME = sdf.format(dbDateFmt.parse(rs.getString("SENT_TIME")));
					}

					String SENT_FLAG = rs.getString("SENT_FLAG");
					if (rs.wasNull()) {
						SENT_FLAG = "NA";
					}

					h.put("MOBILE_NUMBER", ani);
					h.put("MSG", MSG);
					h.put("INSERT_TIME", INSERT_TIME);
					h.put("SENT_TIME", SENT_TIME);
					h.put("SENT_FLAG", SENT_FLAG);
					fetchSMSRenewal.add(h);
				}

				return fetchSMSRenewal;
			}

		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public ArrayList<Map<String, String>> fetchRESUBDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> fetchSMSRenewal = new ArrayList<Map<String, String>>();
		String prepStmtSql = GetConnection.loadProp("SQL_RESUB");
		pstmt = null;
		ResultSet rs = null;
		try {
			logger.info("Query to be Executed ---" + prepStmtSql);
			pstmt = con.prepareStatement(prepStmtSql);
			pstmt.setString(1, msisdn);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, String> h = new HashMap<String, String>();

				String STATUS = rs.getString("STATUS");
				if (rs.wasNull()) {
					STATUS = "-";
				} else {
					STATUS = GetConnection.loadProp(STATUS);
				}
				String SUB_DATE = rs.getString("SUB_DATE");
				if (rs.wasNull()) {
					SUB_DATE = "-";
				} else {
					SUB_DATE = sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
				}

				String RENEW_DATE = rs.getString("RENEW_DATE");
				if (rs.wasNull()) {
					RENEW_DATE = "-";
				} else {
					RENEW_DATE = sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
				}

				String BILLING_DATE = rs.getString("BILLING_DATE");
				if (rs.wasNull()) {
					BILLING_DATE = "-";
				} else {
					BILLING_DATE = sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
				}

				String PACK_TYPE = rs.getString("SERVICETYPEDESC");
				if (rs.wasNull()) {
					PACK_TYPE = "NA";
				}

				String ACT_SOURCE = rs.getString("ACT_SOURCE");
				if (rs.wasNull()) {
					ACT_SOURCE = "-";
				}

				h.put("MOBILE_NUMBER", msisdn);
				h.put("STATUS", STATUS);
				h.put("SUB_DATE", SUB_DATE);
				h.put("RENEW_DATE", RENEW_DATE);
				h.put("BILLING_DATE", BILLING_DATE);
				h.put("PACK_TYPE", PACK_TYPE);
				h.put("ACT_SOURCE", ACT_SOURCE);
				fetchSMSRenewal.add(h);
			}

			return fetchSMSRenewal;
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public ArrayList<Map<String, String>> fetchDownloadDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> fetchDownloadlist = new ArrayList<Map<String, String>>();
		String prepStmtSql = "select * from TBL_DOWNLOAD_LOGS where MOBILE_NUMBER='" + msisdn
				+ "'order by date_time desc";
		pstmt = null;
		ResultSet rs = null;
		try {
			logger.info("Query to be Executed ---" + prepStmtSql);
			pstmt = con.prepareStatement(prepStmtSql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, String> h = new HashMap<String, String>();
				h.put("MOBILE_NUMBER", rs.getString("MOBILE_NUMBER"));
				h.put("SONG_ID", rs.getString("SONG_ID"));
				h.put("DATE_TIME", rs.getString("DATE_TIME"));
				h.put("STATUS", rs.getString("STATUS"));
				fetchDownloadlist.add(h);
			}

			return fetchDownloadlist;
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public ArrayList<Map<String, String>> fetchDedicationDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> fetchdedicationlist = new ArrayList<Map<String, String>>();
		String prepStmtSql = "select *  from TBL_RADIO_DEDICATION where ANI='" + msisdn
				+ "' order by billing_date desc";
		pstmt = null;
		ResultSet rs = null;
		try {
			logger.info("Query to be Executed ---" + prepStmtSql);
			pstmt = con.prepareStatement(prepStmtSql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, String> h = new HashMap<String, String>();
				h.put("ANI", rs.getString("ANI"));
				h.put("BNI", rs.getString("BNI"));
				h.put("BILLING_DATE", rs.getString("BILLING_DATE"));
				h.put("MUSIC_FILE", rs.getString("MUSIC_FILE"));
				h.put("MODE", rs.getString("MODE"));
				h.put("STATUS", rs.getString("STATUS"));
				fetchdedicationlist.add(h);
			}

			return fetchdedicationlist;
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public ArrayList<Map<String, String>> fetchBrowsingDetail(String msisdn, String userId, String IP) {
		ArrayList<Map<String, String>> fetchBrowsingList = new ArrayList<Map<String, String>>();
		String prepStmtSql = "select ani,CALLDATE,sum(duration)as DURATION from MIS..tbl_radio_cdr where ANI='" + msisdn
				+ "' group by CALLDATE,ani order by calldate desc";
		pstmt = null;
		ResultSet rs = null;
		try {
			logger.info("Query to be Executed ---" + prepStmtSql);
			pstmt = con.prepareStatement(prepStmtSql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, String> h = new HashMap<String, String>();
				h.put("MOBILE_NUMBER", rs.getString("ani"));
				h.put("CALLDATE", rs.getString("CALLDATE"));
				h.put("DURATION", rs.getString("DURATION"));
				fetchBrowsingList.add(h);
			}

			return fetchBrowsingList;
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public ArrayList<Map<String, String>> fetchCustomerSummaryDetail(String msisdn, String userId, String IP) {
		try {

			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				ArrayList<Map<String, String>> summaryDetail = new ArrayList<Map<String, String>>();
				String prepStmtSql = GetConnection.loadProp("SQL_BILLING_DETAILS");
				pstmt = null;
				logger.info("Query to be Executed ---" + prepStmtSql);
				pstmt = con.prepareStatement(prepStmtSql);
				pstmt.setString(1, msisdn);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					HashMap<String, String> h = new HashMap<String, String>();
					String STATUS = rs.getString("STATUS");
					if (rs.wasNull()) {
						STATUS = "-";
					} else {
						STATUS = GetConnection.loadProp(STATUS);
					}
					String SUB_DATE = rs.getString("SUB_DATE");
					if (rs.wasNull()) {
						SUB_DATE = "-";
					} else {
						SUB_DATE = sdf.format(dbDateFmt.parse(rs.getString("SUB_DATE")));
					}
					String RENEW_DATE = rs.getString("RENEW_DATE");
					if (rs.wasNull()) {
						RENEW_DATE = "-";
					} else {
						RENEW_DATE = sdf.format(dbDateFmt.parse(rs.getString("RENEW_DATE")));
					}

					String BILLING_DATE = rs.getString("BILLING_DATE");
					if (rs.wasNull()) {
						BILLING_DATE = "-";
					} else {
						BILLING_DATE = sdf.format(dbDateFmt.parse(rs.getString("BILLING_DATE")));
					}
					String PACK_TYPE = rs.getString("PACK_TYPE");
					if (rs.wasNull()) {
						PACK_TYPE = "-";
					}

					String AMOUNT = rs.getString("AMOUNT");
					if (rs.wasNull()) {
						AMOUNT = "-";
					}

					String ACT_SOURCE = rs.getString("ACT_SOURCE");
					if (rs.wasNull()) {
						ACT_SOURCE = "-";
					}

					String PACK_VALIDITY = rs.getString("PACK_VALIDITY");
					if (rs.wasNull()) {
						PACK_VALIDITY = "-";
					}

					h.put("MOBILE_NUMBER", msisdn);
					h.put("SUB_DATE", SUB_DATE);
					h.put("RENEW_DATE", RENEW_DATE);
					h.put("BILLING_DATE", BILLING_DATE);
					h.put("PACK_TYPE", PACK_TYPE);
					h.put("ACT_SOURCE", ACT_SOURCE);
					h.put("AMOUNT", AMOUNT);
					h.put("PACK_VALIDITY", PACK_VALIDITY);
					summaryDetail.add(h);
				}

				return summaryDetail;
			}

		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public ArrayList<String> fetchSubcategory(String cat) {
		// String subcat=null;
		ArrayList<String> list = new ArrayList<String>();
		list.add("All");
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				logger.info("cat is " + cat);

				if (cat.equalsIgnoreCase("Local")) {
					logger.info("in local category");
					pstmt = null;
					String prepStmtSql = GetConnection.loadProp("SQL_GET_SUBCAT");
					logger.info("Query to be Executed ---" + prepStmtSql);
					pstmt = con.prepareStatement(prepStmtSql);
					pstmt.setString(1, cat);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						list.add(rs.getString("sub_category"));
					}

					return list;

				}

				else {
					return list;
				}

			}
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public ArrayList<Map<String, String>> getSearchMethod(String searchType, String searchString, String cat,
			String subCategory) {
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				ArrayList<Map<String, String>> songlist = new ArrayList<Map<String, String>>();
				logger.info("SearchType is --" + searchType + " Search String is-- " + searchString + " catagory is-- "
						+ cat + " and " + "subCategory is --" + subCategory);
				// String activity = "Search Song";
				// String msisdn = "NA";

				String query = "SELECT tone_code  AS SONG_ID , tone_name AS MUSIC_FILE , singer AS artist_name, tone_name  AS Song_Name , album  AS Album_Name ,  category  AS Category , sub_category  AS Sub_Category   FROM TBL_TONE_CATALOGUE   WHERE TONE_STATUS=1";

				if (!cat.equalsIgnoreCase("ALL")) {
					query = query + " and category='" + cat + "'";
				}

				if (!subCategory.equalsIgnoreCase("ALL")) {
					query = query + " and sub_category='" + subCategory + "'";
				}

				if (!searchType.equalsIgnoreCase("ALL")) {
					query = query + " and " + searchType + " like '%" + searchString + "%'";
				} else {
					query = query + " and album like '%" + searchString + "%' or singer like '%" + searchString
							+ "%' or tone_name like '%" + searchString + "%'";
				}

				logger.info("Final Query is----" + query);

				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					HashMap<String, String> h = new HashMap<String, String>();
					h.put("SONG_ID", rs.getString("song_id"));
					h.put("SONG_NAME", rs.getString("song_name"));
					h.put("ALBUM_NAME", rs.getString("album_name"));
					h.put("ARTIST_NAME", rs.getString("artist_name"));
					h.put("CATEGORY", rs.getString("category"));
					h.put("SUB_CATEGORY", rs.getString("sub_category"));
					songlist.add(h);
				}

				return songlist;
			}
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public String setRBTCustomer(String mobile_number, String tone_code, String pack, String rbt_name) {
		String result = null;
		try {
			con = GetConnection.getConnection();
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {

				String mobileNo = mobile_number.trim();
				String outpara = null;
				// String activity = "setRBT request";
				String para1 = "SET_RBT#" + mobileNo + "#" + mobileNo + "#CCI#	#" + pack + "#f#" + tone_code + "#6";
				CallableStatement callstmt = null;

				callstmt = con.prepareCall("{call PROC_REQUEST_MASTER(?,?)}");
				callstmt.setString(1, para1);
				callstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				logger.info("exececuteing  PROC_REQUEST_MASTER " + callstmt.execute());
				outpara = callstmt.getString(2);
				logger.info("outparameter value is :: " + outpara);

				if (outpara.equalsIgnoreCase("0")) {
					result = ("RBT  " + rbt_name + " is not set");
				} else {
					result = "Your request for CRBT '" + rbt_name + "' has been accepted, will notify soon";
				}

			}

			return result;
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			return "Sorry, We are unable to Process your request. Please contact administrator. And try again later";
		}

		finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String delTone(String mobile_number, String tone_code) {
		String result = null;
		try {
			con = GetConnection.getConnection();
			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {

				String mobileNo = mobile_number.trim();
				String outpara = null;
				String para1 = "DEL_RBT#" + mobileNo + "#" + mobileNo + "#CCI#CRBT_SUB1#TONE_SUB3#f#" + tone_code
						+ "#6";
				CallableStatement callstmt = null;
				logger.info("Deleting ToneCode {[" + tone_code + "]} for ANI {[" + mobileNo + "]}");
				callstmt = con.prepareCall("{call PROC_REQUEST_MASTER(?,?)}");
				callstmt.setString(1, para1);
				callstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				logger.info("exececuteing  PROC_REQUEST_MASTER " + callstmt.execute());
				outpara = callstmt.getString(2);
				logger.info("outparameter value is :: " + outpara);

				if (outpara.equalsIgnoreCase("0")) {
					result = ("Tone is not Deleted");
				} else {
					result = "Tone has been deleting successfully";
				}

			}
		}

		catch (Exception e) {
			logger.info("Error in Fetching Prepared Statement :" + e);
			result = "Sorry, We are unable to Process your request. Please contact administrator. And try again later";
		}

		finally {
			if (con != null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
