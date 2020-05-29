package com.digispice.ghana.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digispice.ghana.bean.CreateUserBean;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	HttpSession session;

	private static final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class.getName());

	public static Connection con = null;
	private PreparedStatement pst = null;
	private Statement st = null;

	@Override
	public List<CreateUserBean> CheckLogin(String username, String password) {
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				pst = con.prepareStatement(
						"select USER_ID,USER_PASSWORD,FIRST_NAME,LAST_NAME,SUPER_USER,ADMIN,CCI,MIS,CMS from tbl_user_master where USER_ID=? and USER_PASSWORD=? and active=?");
				pst.setString(1, username);
				pst.setString(2, password);
				pst.setBoolean(3, true);
				ResultSet rs = pst.executeQuery();

				List<CreateUserBean> list = new ArrayList<CreateUserBean>();
				while (rs.next()) {
					CreateUserBean user = new CreateUserBean();
					user.setUserId(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setFirst_name(rs.getString(3));
					user.setLast_name(rs.getString(4));
					user.setSuper_user(rs.getString(5));
					user.setAdmin_rights(rs.getString(6));
					user.setCci_rights(rs.getString(7));
					user.setMis_rights(rs.getString(8));
					user.setCms_rights(rs.getString(9));

					list.add(user);
				}

				return list;
			}

		}

		catch (Exception e) {
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
	public int createUser(CreateUserBean bean) {
		int i = 0;
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return 0;
			}

			else {
				logger.info("creating new user");
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);

				String updated_by = ((CreateUserBean) session.getAttribute("userobj")).getUserId();

				pst = con.prepareStatement("insert into tbl_user_master (USER_ID,USER_PASSWORD,FIRST_NAME,LAST_NAME,"
						+ "SUPER_USER,ADMIN,CCI,MIS,CMS,updated_at,updated_by,active) values(?,?,?,?,?,?,?,?,?,?,?,?)");

				pst.setString(1, bean.getUserId());
				pst.setString(2, bean.getPassword());
				pst.setString(3, bean.getFirst_name());
				pst.setString(4, bean.getLast_name());
				pst.setString(5, "N");
				pst.setString(6, bean.getAdmin_rights());
				pst.setString(7, bean.getCci_rights());
				pst.setString(8, bean.getMis_rights());
				pst.setString(9, bean.getCms_rights());
				pst.setString(10, curdate);
				pst.setString(11, updated_by);
				pst.setBoolean(12, true);

				i = pst.executeUpdate();

				return i;
			}
		}

		catch (Exception e) {
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

		return i;

	}

	@Override
	public int checkUserId(String userId) {
		int i = 0;
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return i;
			}

			else {
				logger.info("Checking that user id is already exists or not");
				pst = con.prepareStatement("select * from tbl_user_master where USER_ID=?");
				pst.setString(1, userId);
				ResultSet st = pst.executeQuery();
				if (!st.next()) {
					i = 1;
				}
			}

			return i;

		}

		catch (Exception e) {
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

		return i;

	}

	@Override
	public List<CreateUserBean> viewUser() {
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {
				String curUserId = ((CreateUserBean) session.getAttribute("userobj")).getUserId();
				st = con.createStatement();
				ResultSet rs = st
						.executeQuery("select USER_ID,USER_PASSWORD,FIRST_NAME,LAST_NAME,SUPER_USER,ADMIN,CCI,MIS,CMS,"
								+ "updated_at,updated_by,active from tbl_user_master where USER_ID !='" + curUserId
								+ "'");

				List<CreateUserBean> list = new ArrayList<CreateUserBean>();
				while (rs.next()) {
					CreateUserBean user = new CreateUserBean();
					user.setUserId(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setFirst_name(rs.getString(3));
					user.setLast_name(rs.getString(4));
					user.setSuper_user(rs.getString(5));
					user.setAdmin_rights(rs.getString(6));
					user.setCci_rights(rs.getString(7));
					user.setMis_rights(rs.getString(8));
					user.setCms_rights(rs.getString(9));
					user.setUpdated_at(rs.getString(10));
					user.setUpdated_by(rs.getString(11));
					user.setActive(rs.getBoolean(12));

					list.add(user);

				}
				return list;
			}

		}

		catch (Exception e) {
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

	public int editUser(CreateUserBean bean) {
		int j = 0;
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return j;
			}

			else {
				logger.info("--editing  user details--");
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);

				String updated_by = ((CreateUserBean) session.getAttribute("userobj")).getUserId();

				pst = con.prepareStatement(
						"update tbl_user_master set FIRST_NAME=?, LAST_NAME=?, USER_PASSWORD=?, active=?,"
								+ "ADMIN=?,CCI=?,MIS=?,CMS=?,updated_at=?,updated_by=? where USER_ID=?");

				pst.setString(1, bean.getFirst_name());
				pst.setString(2, bean.getLast_name());
				pst.setString(3, bean.getPassword());
				pst.setBoolean(4, bean.isActive());
				pst.setString(5, bean.getAdmin_rights());
				pst.setString(6, bean.getCci_rights());
				pst.setString(7, bean.getMis_rights());
				pst.setString(8, bean.getCms_rights());
				pst.setString(9, curdate);
				pst.setString(10, updated_by);
				pst.setString(11, bean.getUserId());

				j = pst.executeUpdate();
				return j;
			}
		}

		catch (Exception e) {
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
		return j;
	}

	@Override
	public int deleteUser(String id) {
		int j = 0;
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return j;
			}

			else {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);

				String updated_by = ((CreateUserBean) session.getAttribute("userobj")).getUserId();

				pst = con.prepareStatement(
						"update tbl_user_master set active=?,updated_at=?,updated_by=?" + " where USER_ID=?");

				pst.setBoolean(1, false);
				pst.setString(2, curdate);
				pst.setString(3, updated_by);
				pst.setString(4, id);
				j = pst.executeUpdate();
				return j;
			}
		}

		catch (Exception e) {
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
		return j;
	}

	public HashMap<String, String> getAllPack() {
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not established");
				return null;
			}

			else {

				String sql = GetConnection.loadProp("SQL_PACK_TYPE");
				ResultSet rs;
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {

					map.put(rs.getString("SERVICE_NAME_KEY").toUpperCase(),
							rs.getString("FULL_SERVICE_NAME").toUpperCase());
				}
			}

			return map;
		}

		catch (Exception e) {
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
}
