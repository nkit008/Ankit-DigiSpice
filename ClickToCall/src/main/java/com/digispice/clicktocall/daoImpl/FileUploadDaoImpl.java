package com.digispice.clicktocall.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digispice.clicktocall.connection.ConnectionFactory;
import com.digispice.clicktocall.dao.FileUploadDao;
import com.digispice.clicktocall.model.MetaFileModel;
import com.digispice.clicktocall.model.UserModel;

@Repository
public class FileUploadDaoImpl implements FileUploadDao {

	@Autowired
	HttpSession session;

	private static final Logger logger = Logger.getLogger(FileUploadDaoImpl.class.getName());

	Connection con = null;

	/*
	 * public int MultiModelUpload(String path) {
	 * 
	 * try { con=ConnectionFactory.getConnection(); if(con==null) {
	 * logger.info("Connection not established"); return 0; } else { Statement
	 * st=con.createStatement(); Date date=new Date(); DateFormat df=new
	 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); String curdate=df.format(date);
	 * int created_by=((UserModel)session.getAttribute("userObj")).getUser_id();
	 * System.out.println(created_by);
	 * System.out.println(":::Inserting data into table:::"); String loadQuery1
	 * = "LOAD DATA LOCAL INFILE '"
	 * +path+"' INTO TABLE tbl_multimodel_details FIELDS TERMINATED BY ','" +
	 * " LINES TERMINATED BY '\n' IGNORE 1 LINES (@code) set code= @code," +
	 * " created_at='"+curdate+"',created_by="+created_by;
	 * 
	 * int res=st.executeUpdate(loadQuery1);
	 * 
	 * System.out.println("rows affected "+res);
	 * 
	 * 
	 * 
	 * 
	 * con.close(); return res; }
	 * 
	 * }
	 * 
	 * catch(Exception e) { e.printStackTrace(); }
	 * 
	 * finally { if(con!=null) { try { con.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } }
	 * 
	 * return 0; }
	 */

	@Override
	public String metaFileUpload(List<MetaFileModel> model, int pid) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return "conn";
			} else {
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String curdate = df.format(date);

				Statement st = con.createStatement();
				st.executeUpdate("truncate table tbl_music_details_dummy");

				logger.info("---truncate  tbl_music_details_dummy---");
				PreparedStatement pst = con.prepareStatement(
						"insert into tbl_music_details_dummy(code,title,artist,album)" + " values(?,?,?,?)");
				for (MetaFileModel obj : model) {

					pst.setString(1, obj.getCode());
					pst.setString(2, obj.getTitle());
					pst.setString(3, obj.getArtist());
					pst.setString(4, obj.getAlbum());
					pst.addBatch();

				}
				int j[] = pst.executeBatch();
				logger.info(j.length + " records uploaded into tbl_music_details_dummy");
				if (j.length > 0) {
					logger.info("Calling procedure and the playlist id is " + pid);
					CallableStatement cs = con.prepareCall("{call proc_insert_music_multimodel(?,?,?)}");
					cs.setInt(1, ((UserModel) session.getAttribute("userObj")).getUser_id());
					cs.setInt(2, pid);
					// cs.registerOutParameter(3, Types.VARCHAR);
					cs.executeUpdate();
					String var = cs.getString(3);
					logger.info("PROCEDURE RESULT IS " + var);
					return var;
				}

				else {
					return "fail";
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

	public int addSmartPhoneThumbnail(String uploadPath, String fname) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return 0;
			} else {

				PreparedStatement st = con
						.prepareStatement("update tbl_music_details set smartphone_thumbnail=? where " + "code=?");
				st.setString(1, uploadPath);
				st.setString(2, fname);
				int i = st.executeUpdate();
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

	public int addFeaturedThumbnail(String uploadPath, String fname) {
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("Connection not established");
				return 0;
			} else {

				PreparedStatement st = con
						.prepareStatement("update tbl_music_details set featured_thumbnail=? where " + "code=?");
				st.setString(1, uploadPath);
				st.setString(2, fname);
				int i = st.executeUpdate();
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
}
