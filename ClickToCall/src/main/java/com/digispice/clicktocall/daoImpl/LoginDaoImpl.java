package com.digispice.clicktocall.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.digispice.clicktocall.connection.ConnectionFactory;
import com.digispice.clicktocall.dao.LoginDao;
import com.digispice.clicktocall.model.UserModel;

@Repository
public class LoginDaoImpl implements LoginDao {
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class.getName());

	Connection con = null;

	@Override
	public List<UserModel> checkLogin(String username, String password) {

		int i = 0;
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				PreparedStatement pst = con.prepareStatement(
						"select user_id,user_name,password,name,user_role,created_by,created_at from tbl_user_login where user_name=? and password=?");
				pst.setString(1, username);
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery();

				List<UserModel> list = new ArrayList<UserModel>();
				while (rs.next()) {
					UserModel model = new UserModel();
					model.setUser_id(rs.getInt(1));
					model.setUser_name(rs.getString(2));
					model.setPassword(rs.getString(3));
					model.setName(rs.getString(4));
					model.setUser_role(rs.getString(5));
					model.setCreated_by(rs.getString(6));
					model.setCreated_at(rs.getString(7));
					list.add(model);
				}
				con.close();
				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	}

	public List<String> getActivePlaylistName() {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				PreparedStatement pst = con.prepareStatement("select title from tbl_playlist where active=?");
				pst.setBoolean(1, true);
				ResultSet rs = pst.executeQuery();
				List<String> list = new ArrayList<String>();
				while (rs.next()) {
					list.add(rs.getString(1));
				}

				return list;

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
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

	}
}
