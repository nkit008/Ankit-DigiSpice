package com.digispice.ghana.daoImpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.CheckStatusDao;

@Repository
public class CheckStatusDaoImpl implements CheckStatusDao {

	private static final Logger logger = LoggerFactory.getLogger(CheckStatusDaoImpl.class.getName());
	private PreparedStatement pstmt = null;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
	SimpleDateFormat dbDateFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static Connection con = null;

	@Override
	public int fetchCountSUBDetail(String msisdn, String userId) {
		int res = 0;
		logger.info("Number for check Status is --- " + msisdn);
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
			}

			else {
				String query = GetConnection.loadProp("SQL_SUBS");
				logger.info("Query to be Exceuted ---" + query);

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, msisdn);

				rs = pstmt.executeQuery();

				if (rs.next() == true)
					res = 1;
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

		return res;
	}

	public int fetchCountCRBTSUBDetail(String msisdn, String userId) {
		int res = 0;
		String prepStmtSql = GetConnection.loadProp("SQL_TONE_SUBS");
		pstmt = null;
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
			}

			else {

				pstmt = con.prepareStatement(prepStmtSql, 1004, 1007);
				pstmt.setString(1, msisdn);
				logger.info("Query to be Executed ---" + prepStmtSql);
				rs = pstmt.executeQuery();
				if (rs.next() == true)
					res = 1;
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
		return res;
	}

	public int fetchCountUNSUBDetail(String msisdn, String userId) {
		int res = 0;
		String prepStmtSql = GetConnection.loadProp("SQL_UNSUBSCRIPTION");
		pstmt = null;
		try {
			con = GetConnection.getConnection();
			ResultSet rs = null;
			if (con == null) {
				logger.info("connection not established");
			}

			else {
				pstmt = con.prepareStatement(prepStmtSql);
				pstmt.setString(1, msisdn);
				logger.info("Query to be Executed ---" + prepStmtSql);
				rs = pstmt.executeQuery();

				if (rs.next() == true)
					res = 1;
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

		return res;

	}

}
