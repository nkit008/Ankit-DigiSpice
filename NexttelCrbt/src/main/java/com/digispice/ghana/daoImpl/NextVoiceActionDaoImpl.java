package com.digispice.ghana.daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.digispice.ghana.bean.NextVoiceSubDetails;
import com.digispice.ghana.bean.NextVoiceUnsubDetail;
import com.digispice.ghana.bean.NextVoiceUserBillingDetails;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.NextVoiceActionDao;

@Repository
public class NextVoiceActionDaoImpl implements NextVoiceActionDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(NextVoiceActionDaoImpl.class);

	public static Connection con = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cst = null;
	private Statement st = null;

	@Override
	public ArrayList<NextVoiceSubDetails> nextVoiceUserDetailsforsub(String ani) {

		ArrayList<NextVoiceSubDetails> sublist = new ArrayList<NextVoiceSubDetails>();
		try {
			con = GetConnection.getConnectionNextVoice();
			if (con == null) {
				LOGGER.info("connection not established");
				return null;
			}

			else {

				st = con.createStatement();
				String query = "SELECT IFNULL(a.MOBILE_NUMBER,0),IFNULL(a.STATUS,0)," + "IFNULL(a.SUB_DATE,0),"
						+ "IFNULL(a.RENEW_DATE,0),IFNULL(a.BILLING_DATE,0),IFNULL(a.PRE_POST,0),"
						+ "IFNULL(a.TIME_LIMIT,0),IFNULL(a.PACK_TYPE,0),IFNULL(a.LANGUAGE,0),"
						+ "IFNULL(a.ACT_SOURCE,0),IFNULL(a.GRACE_DAYS,0),IFNULL(a.SUBS_ID,0),IFNULL(a.TRANS_ID,0),"
						+ "IFNULL(a.USER_COUNTER,0),"
						+ "IFNULL(b.AMOUNT,0) FROM TBL_MUSIC_SUBS a LEFT JOIN TBL_BILLINGINFO b "
						+ "ON a.PACK_TYPE = b.user_type WHERE a.MOBILE_NUMBER='" + ani + "'";

				LOGGER.info("exceuting query is {}", query);
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					NextVoiceSubDetails subDetails = new NextVoiceSubDetails();
					subDetails.setMOBILE_NUMBER(rs.getString(1));
					subDetails.setSTATUS((rs.getInt(2)));
					subDetails.setSUB_DATE(rs.getString(3));
					subDetails.setRENEW_DATE(rs.getString(4));
					subDetails.setBILLING_DATE(rs.getString(5));
					subDetails.setPRE_POST(rs.getInt(6));
					subDetails.setTIME_LIMIT(rs.getInt(7));
					subDetails.setPACK_TYPE(rs.getString(8));
					subDetails.setLANGUAGE(rs.getString(9));
					subDetails.setACT_SOURCE(rs.getString(10));
					subDetails.setGRACE_DAYS(rs.getInt(11));
					subDetails.setSUBS_ID(rs.getString(12));
					subDetails.setTRANS_ID(rs.getString(13));
					subDetails.setUSER_COUNTER(rs.getInt(14));
					subDetails.setAMOUNT(rs.getInt(15));

					if (subDetails.getPACK_TYPE().equalsIgnoreCase("MS_SUB1"))
						subDetails.setPACK_TYPE("Yearly");

					else if (subDetails.getPACK_TYPE().equalsIgnoreCase("MS_SUB2"))
						subDetails.setPACK_TYPE("Monthly");

					else if (subDetails.getPACK_TYPE().equalsIgnoreCase("MS_SUB3"))
						subDetails.setPACK_TYPE("Weekly");

					else if (subDetails.getPACK_TYPE().equalsIgnoreCase("MS_SUB4"))
						subDetails.setPACK_TYPE("Daily");

					sublist.add(subDetails);
				}
			}
		} catch (Exception e) {
			LOGGER.info("Exception Occured in getting user Details from Subscrption mode {}", e);
			System.out.println(e);
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return sublist;
	}

	@Override
	public ArrayList<NextVoiceUnsubDetail> nextVoiceDetailsforUnsub(String ani) {
		ArrayList<NextVoiceUnsubDetail> unsublist = new ArrayList<NextVoiceUnsubDetail>();
		try {
			con = GetConnection.getConnectionNextVoice();
			st = con.createStatement();
			String query = "SELECT IFNULL(a.MOBILE_NUMBER,0),IFNULL(a.STATUS,0),IFNULL(a.SUB_DATE,0),"
					+ "IFNULL(a.RENEW_DATE,0),IFNULL(a.BILLING_DATE,0),IFNULL(a.PRE_POST,0)"
					+ ",IFNULL(a.TIME_LIMIT,0),IFNULL(a.PACK_TYPE,0),IFNULL(a.LANGUAGE,0),"
					+ "IFNULL(a.ACT_SOURCE,0),IFNULL(a.GRACE_DAYS,0),IFNULL(a.SUBS_ID,0)," + "IFNULL(a.TRANS_ID,0),"
					+ "IFNULL(a.USER_COUNTER,0),IFNULL(a.UNSUB_REASON,0),IFNULL(a.UNSUB_DATE,0),"
					+ "IFNULL(b.AMOUNT,0) FROM TBL_MUSIC_UNSUBSCRIPTIONS a LEFT JOIN TBL_BILLINGINFO b "
					+ "ON a.PACK_TYPE = b.user_type WHERE MOBILE_NUMBER='" + ani + "'";

			LOGGER.info("executing query is {}", query);

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NextVoiceUnsubDetail unsub = new NextVoiceUnsubDetail();
				unsub.setMOBILE_NUMBER(rs.getString(1));
				unsub.setSTATUS(String.valueOf(rs.getInt(2)));
				unsub.setSUB_DATE(rs.getString(3));
				unsub.setRENEW_DATE(rs.getString(4));
				unsub.setBILLING_DATE(rs.getString(5));
				unsub.setPRE_POST(String.valueOf(rs.getInt(6)));
				unsub.setTIME_LIMIT(String.valueOf(rs.getInt(7)));
				unsub.setPACK_TYPE(rs.getString(8));
				unsub.setLANGUAGE(rs.getString(9));
				unsub.setACT_SOURCE(rs.getString(10));
				unsub.setGRACE_DAYS(String.valueOf(rs.getInt(11)));
				unsub.setSUBS_ID(rs.getString(12));
				unsub.setTRANS_ID(rs.getString(13));
				unsub.setUSER_COUNTER(String.valueOf(rs.getInt(14)));
				unsub.setUNSUB_REASON(rs.getString(15));
				unsub.setUNSUB_DATE(rs.getString(16));
				unsub.setAMOUNT(String.valueOf(rs.getInt(17)));

				if (unsub.getPACK_TYPE().equalsIgnoreCase("MS_SUB1"))
					unsub.setPACK_TYPE("Yearly");

				else if (unsub.getPACK_TYPE().equalsIgnoreCase("MS_SUB2"))
					unsub.setPACK_TYPE("Monthly");

				else if (unsub.getPACK_TYPE().equalsIgnoreCase("MS_SUB3"))
					unsub.setPACK_TYPE("Weekly");

				else if (unsub.getPACK_TYPE().equalsIgnoreCase("MS_SUB4"))
					unsub.setPACK_TYPE("Daily");

				unsublist.add(unsub);
			}
		}

		catch (Exception e) {
			LOGGER.info("exception occured in getting user Details from Unsubscrption mode {}", e);
		}
		return unsublist;
	}

	@Override
	public List<NextVoiceUserBillingDetails> nextVoiceUserBillingDetails(String ani) {
		List<NextVoiceUserBillingDetails> listUserBillingDetails = new ArrayList<NextVoiceUserBillingDetails>();
		try {
			con = GetConnection.getConnectionNextVoice();
			st = con.createStatement();
			String sql = "select IFNULL(ANI,0),IFNULL(BILL_STATUS,0),IFNULL(date(SUB_DATE),0)"
					+ ",IFNULL(date(RENEW_DATE),0),IFNULL(date(BILLING_DATE),0),IFNULL(PRE_POST,0),"
					+ "IFNULL(AMT_DEDUCTED,0),IFNULL(PACK_TYPE,0),IFNULL(ACT_SOURCE,0),IFNULL(TID,0),"
					+ "IFNULL(SERVICE_NAME,0) from TBL_MS_BILLING_HISTORY where ANI='" + ani + "'";

			LOGGER.info("executing query is {}", sql);
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				NextVoiceUserBillingDetails user = new NextVoiceUserBillingDetails();
				user.setANI(rs.getString(1));
				user.setBILL_STATUS(String.valueOf(rs.getInt(2)));
				user.setSUB_DATE(rs.getString(3));
				user.setRENEW_DATE(rs.getString(4));
				user.setBILLING_DATE(rs.getString(5));
				user.setPRE_POST(String.valueOf(rs.getInt(6)));
				user.setAMT_DEDUCTED(rs.getString(7));
				user.setPACK_TYPE(rs.getString(8));
				user.setACT_SOURCE(rs.getString(9));
				user.setTID(String.valueOf(rs.getInt(10)));
				user.setSERVICE_NAME(rs.getString(11));

				if (user.getPACK_TYPE().equalsIgnoreCase("MS_SUB1")) {
					user.setPACK_TYPE("Yearly");
					user.setVALIDITY("365 Days");
				}

				else if (user.getPACK_TYPE().equalsIgnoreCase("MS_SUB2")) {
					user.setPACK_TYPE("Monthly");
					user.setVALIDITY("30 Days");
				}

				else if (user.getPACK_TYPE().equalsIgnoreCase("MS_SUB3")) {
					user.setPACK_TYPE("Weekly");
					user.setVALIDITY("7 Days");
				}

				else if (user.getPACK_TYPE().equalsIgnoreCase("MS_SUB4")) {
					user.setPACK_TYPE("Daily");
					user.setVALIDITY("1 Days");
				}

				listUserBillingDetails.add(user);
			}

		}

		catch (Exception e) {
			LOGGER.info("exception occured to get user billing history details {}", e);
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return listUserBillingDetails;
	}

	@Override
	public String neXtVoiceSinleSubscription(String ani, String pack) {
		String mobile = ani.trim();
		String lang = "e";
		String mode = "cci";
		int inPara = 1;
		String response = null;

		try {
			con = GetConnection.getConnectionNextVoice();
			cst = con.prepareCall("{call PROC_MSCORER_SUBS(?,?,?,?,?,?)}");
			cst.setString(1, mobile);
			cst.setString(2, pack);
			cst.setString(3, lang);
			cst.setString(4, mode);
			cst.setInt(5, inPara);
			cst.execute();
			response = cst.getString(6);
			LOGGER.info("calling procedure PROC_MSCORER_SUBS with IN_PARA {}", inPara);
			LOGGER.info("Transaction ID from new Single Subscription in neXtVoice is {}", response);
		} catch (Exception e) {
			LOGGER.info("exception occured in Single Subscription in neXtVoice {}", e);
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return response;
	}

	@Override
	public String neXtVoiceUnSubscription(String ani) {
		String mobile = ani.trim();
		String lang = "e";
		String mode = "cci";
		int inPara = 3;
		String response = null;
		String pack = "MR_SUB1";

		try {
			con = GetConnection.getConnectionNextVoice();
			LOGGER.info("calling procedure PROC_MSCORER_SUBS with inPara {}", inPara);
			cst = con.prepareCall("{call PROC_MSCORER_SUBS(?,?,?,?,?,?)}");
			cst.setString(1, mobile);
			cst.setString(2, pack);
			cst.setString(3, lang);
			cst.setString(4, mode);
			cst.setInt(5, inPara);
			cst.execute();
			response = cst.getString(6);

			LOGGER.info("response from UnSubscription in neXtVoice is {}", response);
		} catch (Exception e) {
			LOGGER.info("exception occured in Single UnSubscription in neXtVoice {}", e);
			e.printStackTrace();
		} finally {

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return response;

	}

	public String neXtVoiceBulkSubscription(String pack, String path) {
		BufferedReader bf = null;
		String line = null;
		String lang = "e";
		String mode = "cci";
		int inPara = 1;
		String response = null;

		try {
			con = GetConnection.getConnectionNextVoice();
			bf = new BufferedReader(new FileReader(new File(path)));
			while ((line = bf.readLine()) != null) {
				if (line.length() == 12) {
					cst = con.prepareCall("{call PROC_MSCORER_SUBS(?,?,?,?,?,?)}");
					cst.setString(1, line);
					cst.setString(2, pack);
					cst.setString(3, lang);
					cst.setString(4, mode);
					cst.setInt(5, inPara);
					cst.execute();
					response = cst.getString(6);
					LOGGER.info("response for ANI {} is {}", line, response);
					response = "success";
				} else {
					LOGGER.info("ANI {} is incorrect", line);
					response = "incorrectNumber";
				}
			}
		} catch (Exception e) {
			LOGGER.info("exception occured during bulk subcription {}", e);
			e.printStackTrace();
			response = "exception";
		}

		finally {
			if (bf != null) {
				try {
					bf.close();
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return response;
	}

}
