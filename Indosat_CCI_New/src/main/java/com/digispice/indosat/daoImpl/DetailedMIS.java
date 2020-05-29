package com.digispice.indosat.daoImpl;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.digispice.indosat.connection.ConnectionFactory;

public class DetailedMIS {

	public static Logger logger = Logger.getLogger(DetailedMIS.class.getName());

	static HttpSession connection;

	static Connection con;

	@Autowired
	public static void setConnection(HttpSession connection) {
		DetailedMIS.connection = connection;
	}

	public static HashMap<Integer, Integer> getFailedCount(String date, String serviceName, String obdName) {
		HashMap map = new HashMap();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DatabaseMetaData meta = null;
		con = (Connection) connection.getAttribute("active_connection");

		if (con != null) {

			try {
				meta = con.getMetaData();
				if (meta.getDatabaseProductName().equalsIgnoreCase("Microsoft SQL Server")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("SQL_DetailedMIS_getFailedCount"), 1004,
							1007);
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("ORACLE_DetailedMIS_getFailedCount"), 1004,
							1007);
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("MySQL")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("MySQL_DetailedMIS_getFailedCount"), 1004,
							1007);
				}

				ps.setString(1, date);
				ps.setString(2, serviceName);
				ps.setString(3, obdName);
				rs = ps.executeQuery();
				while (rs.next()) {
					map.put(rs.getString("error_code"), rs.getInt("total_count"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception in  getFailedCount" + ex.getMessage());
			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException ex) {
					logger.info(ex);
				}
			}
		} else {
			logger.info("Connection not established");
		}
		return map;
	}

	public static ArrayList<Integer> getErrorCode(String fromDate, String toDate) {
		ArrayList code = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DatabaseMetaData meta = null;

		con = (Connection) connection.getAttribute("active_connection");

		if (con == null) {
			logger.info("---Connection is not established with Database--");
		}

		else {
			try {
				meta = con.getMetaData();
				if (meta.getDatabaseProductName().equalsIgnoreCase("Microsoft SQL Server")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("SQL_DetailedMIS_getErrorCode"), 1004,
							1007);
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("ORACLE_DetailedMIS_getErrorCode"), 1004,
							1007);
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("MySQL")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("MySQL_DetailedMIS_getErrorCode"), 1004,
							1007);
				}
				ps.setString(1, fromDate);
				ps.setString(2, toDate);
				rs = ps.executeQuery();
				while (rs.next()) {
					code.add(rs.getString("error_code"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Exception in  getErrorCode" + ex.getMessage());
			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException ex) {
					logger.info(ex);
				}
			}
		}
		return code;
	}

	public static ResultSet getMISSummaryData(String fromDate, String toDate) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		DatabaseMetaData meta = null;

		con = (Connection) connection.getAttribute("active_connection");

		if (con == null) {
			logger.info("---Connection is not established with Database--");
		}

		else {
			try {
				meta = con.getMetaData();
				if (meta.getDatabaseProductName().equalsIgnoreCase("Microsoft SQL Server")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("SQL_DetailedMIS_getMISSummaryData"), 1004,
							1007);
					logger.info("SQL Server Query is "
							+ ConnectionFactory.getProperty("SQL_DetailedMIS_getMISSummaryData"));
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("ORACLE_DetailedMIS_getMISSummaryData"),
							1004, 1007);
					logger.info(
							"Oracle Query is " + ConnectionFactory.getProperty("ORACLE_DetailedMIS_getMISSummaryData"));
				} else if (meta.getDatabaseProductName().equalsIgnoreCase("MySQL")) {
					ps = con.prepareStatement(ConnectionFactory.getProperty("MySQL_DetailedMIS_getMISSummaryData"),
							1004, 1007);
					logger.info(
							"Mysql Query is " + ConnectionFactory.getProperty("MySQL_DetailedMIS_getMISSummaryData"));
				}

				ps.setString(1, fromDate);
				ps.setString(2, toDate);
				logger.info("FROM DATE :: " + fromDate);
				logger.info("TO DATE :: " + toDate);
				rs = ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Exception in  getMISSummaryData " + e.getMessage());
			}
		}
		return rs;
	}

}
