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

import com.digispice.ghana.bean.NextMusicSubDetails;
import com.digispice.ghana.bean.NextMusicUnsubDetail;
import com.digispice.ghana.bean.NextMusicUserBillingDetails;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.NextMusicActionDao;

@Repository
public class NextMusicActionDaoImpl implements NextMusicActionDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(NextMusicActionDaoImpl.class);

	public static Connection con = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cst = null;
	private Statement st = null;

	@Override
	public String modSinleSubscription(String ani, String pack) {
		String mobile = ani.trim();
		String lang = "e";
		String mode = "cci";
		int inPara = 1;
		String response = null;

		try {
			con = GetConnection.getConnectionNextMusic();
			cst = con.prepareCall("{call PROC_RADIO_SUBS(?,?,?,?,?,?)}");
			cst.setString(1, mobile);
			cst.setString(2, pack);
			cst.setString(3, lang);
			cst.setString(4, mode);
			cst.setInt(5, inPara);
			cst.execute();
			response = cst.getString(6);
			LOGGER.info("calling procedure PROC_RADIO_SUBS with parameter {}", inPara);
			LOGGER.info("Transaction ID from new Single Subscription in neXtMusic is {}", response);
		} catch (Exception e) {
			LOGGER.info("exception occured in Single Subscription in neXtMusic {}", e);
			e.printStackTrace();
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

		return response;
	}

	@Override
	public List<NextMusicUserBillingDetails> getModUserBillingDetails(String ani) {
		List<NextMusicUserBillingDetails> listUserBillingDetails = new ArrayList<NextMusicUserBillingDetails>();
		try {
			con = GetConnection.getConnectionNextMusic();
			st = con.createStatement();
			String sql = "select IFNULL(ANI,0),IFNULL(BILL_STATUS,0),IFNULL(date(SUB_DATE),0)"
					+ ",IFNULL(date(RENEW_DATE),0),IFNULL(date(BILLING_DATE),0),IFNULL(PRE_POST,0),"
					+ "IFNULL(AMT_DEDUCTED,0),IFNULL(PACK_TYPE,0),IFNULL(ACT_SOURCE,0),IFNULL(TID,0),"
					+ "IFNULL(SERVICE_NAME,0) from TBL_MR_BILLING_HISTORY where ANI='" + ani + "'";

			LOGGER.info("executing query is {}", sql);
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				NextMusicUserBillingDetails user = new NextMusicUserBillingDetails();
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

				if (user.getPACK_TYPE().equalsIgnoreCase("MR_SUB1")) {
					user.setPACK_TYPE("Monthly");
					user.setVALIDITY("30 Days");
				}

				else if (user.getPACK_TYPE().equalsIgnoreCase("MR_SUB2")) {
					user.setVALIDITY("7 Days");
					user.setPACK_TYPE("Weekly");
				}

				else if (user.getPACK_TYPE().equalsIgnoreCase("MR_SUB3")) {
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

	public String bulkModSinleSubscription(String pack, String path) {
		BufferedReader bf = null;
		String line = null;
		String lang = "e";
		String mode = "cci";
		int inPara = 1;
		String response = null;

		try {
			con = GetConnection.getConnectionNextMusic();
			bf = new BufferedReader(new FileReader(new File(path)));
			while ((line = bf.readLine()) != null) {
				if (line.length() == 12) {
					cst = con.prepareCall("{call PROC_RADIO_SUBS(?,?,?,?,?,?)}");
					cst.setString(1, line.trim());
					cst.setString(2, pack);
					cst.setString(3, lang);
					cst.setString(4, mode);
					cst.setInt(5, inPara);
					LOGGER.info("calling procedure PROC_RADIO_SUBS with inPara {}", inPara);
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

	@Override
	public ArrayList<NextMusicUnsubDetail> modUserDetailsforUnsub(String ani) {
		ArrayList<NextMusicUnsubDetail> unsublist = new ArrayList<NextMusicUnsubDetail>();
		try {
			con = GetConnection.getConnectionNextMusic();
			st = con.createStatement();
			String query = "SELECT IFNULL(a.MOBILE_NUMBER,0),IFNULL(a.STATUS,0),IFNULL(a.SUB_DATE,0),"
					+ "IFNULL(a.RENEW_DATE,0),IFNULL(a.BILLING_DATE,0),IFNULL(a.PRE_POST,0)"
					+ ",IFNULL(a.TIME_LIMIT,0),IFNULL(a.PACK_TYPE,0),IFNULL(a.LANGUAGE,0),"
					+ "IFNULL(a.ACT_SOURCE,0),IFNULL(a.GRACE_DAYS,0),IFNULL(a.SUBS_ID,0)," + "IFNULL(a.TRANS_ID,0),"
					+ "IFNULL(a.USER_COUNTER,0),IFNULL(a.UNSUB_MODE,0),IFNULL(a.UNSUB_DATE,0),"
					+ "IFNULL(b.AMOUNT,0) FROM TBL_RADIO_UNSUBSCRIPTIONS a LEFT JOIN TBL_BILLINGINFO b "
					+ "ON a.PACK_TYPE = b.user_type WHERE MOBILE_NUMBER='" + ani + "'";

			LOGGER.info("executing query is {}", query);

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NextMusicUnsubDetail unsub = new NextMusicUnsubDetail();
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
				unsub.setUNSUB_MODE(rs.getString(15));
				unsub.setUNSUB_DATE(rs.getString(16));
				unsub.setAMOUNT(String.valueOf(rs.getInt(17)));

				if (unsub.getPACK_TYPE().equalsIgnoreCase("MR_SUB1"))
					unsub.setPACK_TYPE("Monthly");
				else if (unsub.getPACK_TYPE().equalsIgnoreCase("MR_SUB2"))
					unsub.setPACK_TYPE("Weekly");
				else if (unsub.getPACK_TYPE().equalsIgnoreCase("MR_SUB3"))
					unsub.setPACK_TYPE("Weekly");
				unsublist.add(unsub);
			}
		}

		catch (Exception e) {
			LOGGER.info("exception occured in getting user Details from Unsubscrption mode {}", e);
		}
		return unsublist;
	}

	@Override
	public ArrayList<NextMusicSubDetails> modUserDetailsforsub(String ani) {
		ArrayList<NextMusicSubDetails> sublist = new ArrayList<NextMusicSubDetails>();
		try {
			con = GetConnection.getConnectionNextMusic();
			if (con == null) {
				LOGGER.info("connection not established");
				return null;
			}

			else {
				System.out.println("-------- " + ani);
				st = con.createStatement();
				String query = "SELECT IFNULL(a.MOBILE_NUMBER,0),IFNULL(a.STATUS,0)," + "IFNULL(a.SUB_DATE,0),"
						+ "IFNULL(a.RENEW_DATE,0),IFNULL(a.BILLING_DATE,0),IFNULL(a.PRE_POST,0),"
						+ "IFNULL(a.TIME_LIMIT,0),IFNULL(a.PACK_TYPE,0),IFNULL(a.LANGUAGE,0),"
						+ "IFNULL(a.ACT_SOURCE,0),IFNULL(a.GRACE_DAYS,0),IFNULL(a.SUBS_ID,0),IFNULL(a.TRANS_ID,0),"
						+ "IFNULL(a.USER_COUNTER,0),"
						+ "IFNULL(b.AMOUNT,0) FROM TBL_RADIO_SUBS a LEFT JOIN TBL_BILLINGINFO b "
						+ "ON a.PACK_TYPE = b.user_type WHERE a.MOBILE_NUMBER='" + ani + "'";

				LOGGER.info("exceuting query is {}", query);
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					NextMusicSubDetails subDetails = new NextMusicSubDetails();
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

					if (subDetails.getPACK_TYPE().equalsIgnoreCase("MR_SUB1"))
						subDetails.setPACK_TYPE("Monthly");
					else if (subDetails.getPACK_TYPE().equalsIgnoreCase("MR_SUB2"))
						subDetails.setPACK_TYPE("Weekly");
					else if (subDetails.getPACK_TYPE().equalsIgnoreCase("MR_SUB3"))
						subDetails.setPACK_TYPE("Weekly");

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
	public String modUnSubscription(String ani) {
		String mobile = ani.trim();
		String lang = "e";
		String mode = "cci";
		int inPara = 4;
		String response = null;
		String pack = "MR_SUB1";

		try {
			con = GetConnection.getConnectionNextMusic();
			LOGGER.info("calling procedure PROC_RADIO_SUBS with inPara {}", inPara);
			cst = con.prepareCall("{call PROC_RADIO_SUBS(?,?,?,?,?,?)}");
			cst.setString(1, mobile);
			cst.setString(2, pack);
			cst.setString(3, lang);
			cst.setString(4, mode);
			cst.setInt(5, inPara);
			cst.execute();
			response = cst.getString(6);

			LOGGER.info("response from UnSubscription in neXtMusic is {}", response);
		} catch (Exception e) {
			LOGGER.info("exception occured in Single UnSubscription in neXtMusic {}", e);
			e.printStackTrace();
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
		return response;

	}

}
