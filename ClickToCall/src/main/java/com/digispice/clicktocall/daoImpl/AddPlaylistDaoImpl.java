package com.digispice.clicktocall.daoImpl;

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
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digispice.clicktocall.connection.ConnectionFactory;
import com.digispice.clicktocall.dao.AddPlaylistDao;
import com.digispice.clicktocall.model.BannerModel;
import com.digispice.clicktocall.model.MetaInfoModel;
import com.digispice.clicktocall.model.MusicDetailsModel;
import com.digispice.clicktocall.model.PlaylistModel;
import com.digispice.clicktocall.model.UnassignCodeModel;
import com.digispice.clicktocall.model.UserModel;

@Repository
public class AddPlaylistDaoImpl implements AddPlaylistDao {

	int i = 0;

	@Autowired
	HttpSession session;

	private static final Logger logger = Logger.getLogger(AddPlaylistDaoImpl.class.getName());

	Connection con = null;

	@Override
	public String addNewPlaylist(String playlistTitle, String playlistDesc) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return "connFailed";
			} else {

				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select count(1) from tbl_playlist where title='" + playlistTitle + "'");
				rs.next();
				int count = rs.getInt(1);
				logger.info("if playlist already exists then value 1 otherwise 0 ----->" + rs.getInt(1));
				if (count != 0) {

					return "exists";
				}

				else {
					Date date = new Date();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String curdate = df.format(date);

					PreparedStatement pst = con.prepareStatement(
							"insert into tbl_playlist (title,description,active,created_by,updated_by,"
									+ "created_at,updated_at) values(?,?,?,?,?,?,?)");
					pst.setString(1, playlistTitle);
					pst.setString(2, playlistDesc);
					pst.setBoolean(3, true);
					pst.setInt(4, ((UserModel) session.getAttribute("userObj")).getUser_id());
					pst.setInt(5, ((UserModel) session.getAttribute("userObj")).getUser_id());
					pst.setString(6, curdate);
					pst.setString(7, curdate);
					i = pst.executeUpdate();
					con.close();
					return "success";
				}
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
		return "error";
	}

	@Override
	public List<PlaylistModel> viewPlaylist() {
		List<PlaylistModel> list1 = new ArrayList<PlaylistModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select id,title,description,active,created_by,updated_by,created_at,"
						+ "updated_at from tbl_playlist ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') ASC");

				while (rs.next()) {
					PlaylistModel model = new PlaylistModel();
					model.setId(rs.getInt(1));
					model.setTitle(rs.getString(2));
					model.setDesc(rs.getString(3));
					model.setActive(rs.getBoolean(4));
					model.setCreated_by(rs.getInt(5));
					model.setUpdated_by(rs.getInt(6));
					model.setCreated_at(rs.getString(7).substring(0, rs.getString(7).length() - 5));
					model.setUpdated_at(rs.getString(8).substring(0, rs.getString(8).length() - 5));
					list1.add(model);
				}
			}

			return list1;
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
	public int updatePlaylist(String sno, String desc, boolean active) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return 0;
			} else {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String curdate = df.format(date);

				PreparedStatement pst = con.prepareStatement("update tbl_playlist set description=?,active=?"
						+ ",updated_by=?,updated_at=? where id=" + sno);
				pst.setString(1, desc);
				pst.setBoolean(2, active);
				pst.setInt(3, ((UserModel) session.getAttribute("userObj")).getUser_id());
				pst.setString(4, curdate);
				int i = pst.executeUpdate();
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

		return 0;

	}

	@Override
	public List<BannerModel> viewBanner()

	{
		List<BannerModel> list1 = new ArrayList<BannerModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();

				ResultSet rs = st.executeQuery("SELECT tbl_banner_details.id,tbl_banner_details.smartphone_path,"
						+ "tbl_banner_details.active,tbl_banner_details.created_by,tbl_banner_details.updated_by,"
						+ "tbl_banner_details.created_at,"
						+ "tbl_banner_details.updated_at,tbl_banner_details.feature_path,`tbl_playlist`.title FROM tbl_banner_details INNER JOIN "
						+ "`tbl_playlist` ON tbl_banner_details.playlist_id=tbl_playlist.id WHERE tbl_banner_details.active=1"
						+ " ORDER BY DATE_FORMAT(tbl_banner_details.created_at, '%Y-%m-%d %k:%i:%s') DESC");
				while (rs.next()) {
					BannerModel model = new BannerModel();
					model.setId(rs.getInt(1));
					model.setSmartphone_path(rs.getString(2));
					model.setActive(rs.getBoolean(3));
					model.setCreated_by(rs.getInt(4));
					model.setUpdated_by(rs.getInt(5));
					model.setCreated_at(rs.getString(6).substring(0, rs.getString(6).length() - 5));
					model.setUpdated_at(rs.getString(7).substring(0, rs.getString(7).length() - 5));
					model.setFeature_path(rs.getString(8));
					model.setPlaylist_name(rs.getString(9));
					list1.add(model);
				}
			}

			return list1;
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
	public Map<String, String> getnameByid() {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs1 = st.executeQuery("SELECT user_name,user_id FROM `tbl_user_login` "
						+ "GROUP BY user_id ORDER BY DATE_FORMAT(created_at, '%Y-%m-%d %k:%i:%s') DESC");

				Map<String, String> countMap = new HashMap<String, String>();
				while (rs1.next()) {
					countMap.put("abc_" + rs1.getInt(2), rs1.getString(1));
				}

				return countMap;

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
	public String addBanner(int pid, String feature_path, String smart_path) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return "connFailed";
			} else {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String curdate = df.format(date);

				PreparedStatement pst2 = con
						.prepareStatement("insert into tbl_banner_details(smartphone_path,active,playlist_id,"
								+ "created_by,updated_by,created_at,updated_at,feature_path) values(?,?,?,?,?,?,?,?)");
				pst2.setString(1, smart_path);
				pst2.setBoolean(2, true);
				pst2.setInt(3, pid);
				pst2.setInt(4, ((UserModel) session.getAttribute("userObj")).getUser_id());
				pst2.setInt(5, ((UserModel) session.getAttribute("userObj")).getUser_id());
				pst2.setString(6, curdate);
				pst2.setString(7, curdate);
				pst2.setString(8, feature_path);
				int res = pst2.executeUpdate();
				if (res > 0) {
					con.setAutoCommit(true);
					return "success";
				}

				else {
					return "nosuccess";
				}
			}
		} catch (Exception e) {
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
		return "error";
	}

	@Override
	public void deletePlalylist(int pid) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
			} else {
				logger.info("deleting record ");
				PreparedStatement pst = con.prepareStatement("delete from tbl_playlist where id=?");
				pst.setInt(1, pid);
				pst.executeUpdate();

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

	}

	@Override
	public int getpid(String playlistTitle) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return 0;
			} else {
				PreparedStatement pst = con.prepareStatement("select id from tbl_playlist where title=?");
				pst.setString(1, playlistTitle);
				ResultSet rs = pst.executeQuery();
				rs.next();
				int id = rs.getInt(1);
				return id;
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
		return 0;

	}

	@Override
	public String updatePlaylistWithBanner(String sno, String desc, boolean active, String feature_path,
			String smart_path) {

		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return "connFailed";
			} else {

				con.setAutoCommit(false);
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);
				int pid = Integer.parseInt(sno);

				PreparedStatement pst = con
						.prepareStatement("update tbl_playlist set description=?,active=?,updated_by=?,"
								+ "updated_at=? where id=" + sno);
				pst.setString(1, desc);
				pst.setBoolean(2, active);
				pst.setInt(3, ((UserModel) session.getAttribute("userObj")).getUser_id());
				pst.setString(4, curdate);
				i = pst.executeUpdate();

				if (i > 0) {
					pst = con.prepareStatement("select count(1) from tbl_banner_details where playlist_id=?");
					pst.setInt(1, pid);
					ResultSet rs = pst.executeQuery();
					rs.next();
					int count = rs.getInt(1);
					logger.info("Banner Already uploaded for PlaylistId=" + pid + "-- " + count);
					if (count > 0) {
						pst = con.prepareStatement("update tbl_banner_details set smartphone_path=?,updated_by=?,"
								+ "updated_at=?,feature_path=? where playlist_id=?");
						pst.setString(1, smart_path);
						pst.setInt(2, ((UserModel) session.getAttribute("userObj")).getUser_id());
						pst.setString(3, curdate);
						pst.setString(4, feature_path);
						pst.setString(5, sno);
						int j = pst.executeUpdate();
						if (j > 0) {
							con.commit();
							con.setAutoCommit(true);
							return "success";
						} else {
							con.rollback();
							con.setAutoCommit(true);
							return "fail";
						}
					}

					else {
						PreparedStatement pst1 = con
								.prepareStatement("insert into tbl_banner_details(smartphone_path,active,playlist_id,"
										+ "created_by,updated_by,created_at,updated_at,feature_path) values(?,?,?,?,?,?,?,?)");
						pst1.setString(1, smart_path);
						pst1.setBoolean(2, true);
						pst1.setInt(3, pid);
						pst1.setInt(4, ((UserModel) session.getAttribute("userObj")).getUser_id());
						pst1.setInt(5, ((UserModel) session.getAttribute("userObj")).getUser_id());
						pst1.setString(6, curdate);
						pst1.setString(7, curdate);
						pst1.setString(8, feature_path);
						int res = pst1.executeUpdate();
						if (res > 0) {
							con.commit();
							con.setAutoCommit(true);
							return "success";
						}

						else {
							con.rollback();
							con.setAutoCommit(true);
							return "fail";
						}
					}
				}
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
		return "fail";
	}

	public List<MusicDetailsModel> viewMusic() {
		List<MusicDetailsModel> list1 = new ArrayList<MusicDetailsModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT a.id,a.code,a.title,a.artist,a.album,a.active,a.created_at,a.updated_at,"
								+ "a.created_by,a.updated_by,"
								+ "IFNULL((SELECT CODE FROM tbl_multimodel_details WHERE music_id=a.id),'NA') AS CODE,"
								+ "IFNULL((SELECT title FROM tbl_playlist WHERE id=a.playlist_id),'NA') AS playlist"
								+ " FROM tbl_music_details a ORDER BY DATE_FORMAT(a.created_at, '%Y-%m-%d %k:%i:%s') DESC");

				while (rs.next()) {
					MusicDetailsModel model = new MusicDetailsModel();
					model.setId(rs.getInt(1));
					model.setCode(rs.getString(2));
					model.setTitle(rs.getString(3));
					model.setArtist(rs.getString(4));
					model.setAlbums(rs.getString(5));
					model.setActive(rs.getBoolean(6));
					model.setCreated_at(rs.getString(7).substring(0, rs.getString(7).length() - 5));
					model.setUpdated_at(rs.getString(8).substring(0, rs.getString(8).length() - 5));
					model.setCreated_by(rs.getInt(9));
					model.setUpdated_by(rs.getInt(10));
					model.setMm_code(rs.getString(11));
					model.setPlaylist_name(rs.getString(12));
					list1.add(model);
				}
			}

			return list1;
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

	public int removeMusic(String sno, String status) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return 0;
			} else {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);
				if (status.equalsIgnoreCase("true")) {
					PreparedStatement pst = con
							.prepareStatement("update tbl_music_details set active=?,updated_at=? where id=" + sno);
					pst.setBoolean(1, false);
					pst.setString(2, curdate);
					int res = pst.executeUpdate();
					return res;
				}

				else if (status.equalsIgnoreCase("false")) {
					PreparedStatement pst = con
							.prepareStatement("update tbl_music_details set active=?,updated_at=? where id=" + sno);
					pst.setBoolean(1, true);
					pst.setString(2, curdate);
					int res = pst.executeUpdate();
					return res;
				}
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
		return 0;

	}

	@Override
	public List<MetaInfoModel> viewMetadataRecordsBypid(int id)

	{
		List<MetaInfoModel> list1 = new ArrayList<MetaInfoModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT tbl_metadata_records.id,tbl_metadata_records.total_metafile_records,"
								+ "tbl_metadata_records.total_musicfile_inserted,tbl_metadata_records.total_musicfile_updated,"
								+ "tbl_metadata_records.total_mm_assign,tbl_metadata_records.total_mm_update,"
								+ "tbl_metadata_records.total_unassign_mm,tbl_metadata_records.total_free_mm,"
								+ "tbl_metadata_records.created_by,tbl_metadata_records.created_at,tbl_metadata_records.uid,"
								+ "`tbl_playlist`.title FROM tbl_metadata_records INNER JOIN "
								+ "`tbl_playlist` ON tbl_metadata_records.playlist_id=tbl_playlist.id "
								+ "where tbl_metadata_records.playlist_id=" + id
								+ " ORDER BY DATE_FORMAT(tbl_metadata_records.created_at, '%Y-%m-%d %k:%i:%s') DESC limit 5");
				while (rs.next()) {
					MetaInfoModel model = new MetaInfoModel();
					model.setId(rs.getInt(1));
					model.setTotal_metafile_records(rs.getInt(2));
					model.setTotal_musicfile_inserted(rs.getInt(3));
					model.setTotal_musicfile_updated(rs.getInt(4));
					model.setTotal_mm_assign(rs.getInt(5));
					model.setTotal_mm_update(rs.getInt(6));
					model.setTotal_unassign_mm(rs.getInt(7));
					model.setTotal_free_mm(rs.getInt(8));
					model.setCreated_by(rs.getInt(9));
					model.setCreated_at(rs.getString(10));
					model.setuid(rs.getString(11));
					model.setPlaylist_name(rs.getString(12));
					list1.add(model);
				}
			}

			return list1;
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
	public List<MetaInfoModel> viewMetadataRecords()

	{
		List<MetaInfoModel> list1 = new ArrayList<MetaInfoModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("SELECT tbl_metadata_records.id,tbl_metadata_records.total_metafile_records,"
								+ "tbl_metadata_records.total_musicfile_inserted,tbl_metadata_records.total_musicfile_updated,"
								+ "tbl_metadata_records.total_mm_assign,tbl_metadata_records.total_mm_update,"
								+ "tbl_metadata_records.total_unassign_mm,tbl_metadata_records.total_free_mm,"
								+ "tbl_metadata_records.created_by,tbl_metadata_records.created_at,tbl_metadata_records.uid,"
								+ "`tbl_playlist`.title FROM tbl_metadata_records INNER JOIN "
								+ "`tbl_playlist` ON tbl_metadata_records.playlist_id=tbl_playlist.id "
								+ " ORDER BY DATE_FORMAT(tbl_metadata_records.created_at, '%Y-%m-%d %k:%i:%s') DESC");
				while (rs.next()) {
					MetaInfoModel model = new MetaInfoModel();
					model.setId(rs.getInt(1));
					model.setTotal_metafile_records(rs.getInt(2));
					model.setTotal_musicfile_inserted(rs.getInt(3));
					model.setTotal_musicfile_updated(rs.getInt(4));
					model.setTotal_mm_assign(rs.getInt(5));
					model.setTotal_mm_update(rs.getInt(6));
					model.setTotal_unassign_mm(rs.getInt(7));
					model.setTotal_free_mm(rs.getInt(8));
					model.setCreated_by(rs.getInt(9));
					model.setCreated_at(rs.getString(10));
					model.setuid(rs.getString(11));
					model.setPlaylist_name(rs.getString(12));
					list1.add(model);
				}
			}

			return list1;
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
	public List<UnassignCodeModel> viewUnassignCodeDetails(String uid)

	{
		List<UnassignCodeModel> list1 = new ArrayList<UnassignCodeModel>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return null;
			} else {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT tbl_unassign_code.id,tbl_unassign_code.music_code,"
						+ "tbl_unassign_code.created_by,tbl_unassign_code.created_at,tbl_unassign_code.uid,"
						+ "`tbl_playlist`.title FROM tbl_unassign_code INNER JOIN "
						+ "`tbl_playlist` ON tbl_unassign_code.playlist_id=tbl_playlist.id "
						+ "where tbl_unassign_code.uid='" + uid
						+ "' ORDER BY DATE_FORMAT(tbl_unassign_code.created_at, '%Y-%m-%d %k:%i:%s') DESC");
				while (rs.next()) {
					UnassignCodeModel model = new UnassignCodeModel();
					model.setId(rs.getInt(1));
					model.setCode(rs.getString(2));
					model.setCreated_by(rs.getInt(3));
					model.setCreated_at(rs.getString(4));
					model.setUid(rs.getString(5));
					model.setPlaylist_name(rs.getString(6));
					list1.add(model);
				}
			}

			return list1;
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
