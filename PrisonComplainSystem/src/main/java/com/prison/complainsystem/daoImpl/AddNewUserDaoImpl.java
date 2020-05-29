package com.prison.complainsystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prison.complainsystem.connection.ConnectionFactory;
import com.prison.complainsystem.dao.AddNewComplainDao;
import com.prison.complainsystem.dao.AddNewUserDao;
import com.prison.complainsystem.model.AddNewUserModel;
import com.prison.complainsystem.model.AllComplainModel;
import com.prison.complainsystem.model.UserLogin;

@Repository
@Transactional
public class AddNewUserDaoImpl implements AddNewUserDao{

	@Autowired
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(GetComplainDetailsDaoImpl.class);
	Connection con = null;
	int i=0;
	@Override
	public int addNewUserRecord(AddNewUserModel user)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String createdAt=df.format(date);
				String creratedBy=((UserLogin)session.getAttribute("userObj")).getName();
				PreparedStatement pst=con.prepareStatement("insert into tbl_user_login "
						+ "(user_name,password,name,user_role,created_by,created_at,active,"
						+ "phone,email,updated_at,updated_by"
						+ ") values(?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, user.getUsername());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getName());
				pst.setString(4, user.getUser_role());
				pst.setString(5, creratedBy);
				pst.setString(6, createdAt);
				pst.setBoolean(7, true);
				pst.setString(8, user.getPhone());
				pst.setString(9, user.getMail());
				pst.setString(10, createdAt);
				pst.setString(11, creratedBy);
				
				i=pst.executeUpdate();
				return i;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
	
	}
	
	
	@Override
	public AllComplainModel findDetailsByPrisonId(String id)
	{	
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return null;
			}

			else 
			{
				PreparedStatement pst=con.prepareStatement("select prison_name,complain_logg_by,designation,phone,mail from tbl_complain_details where prison_id=? ORDER BY id DESC");
				pst.setString(1, id);
				
				ResultSet rs=pst.executeQuery();
				
				AllComplainModel model=new  AllComplainModel();
				rs.next();
				System.out.println(rs.getString(1));
				model.setPrison_name(rs.getString(1));
				model.setComplain_logg_by(rs.getString(2));
				model.setDesignation(rs.getString(3));
				model.setPhone(rs.getLong(4));
				model.setMail(rs.getString(5));
				return model;
				
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		
		return null;
	}
	
	public UserLogin updateUserRecord(String id)
	{
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return null;
			}

			else 
			{
				PreparedStatement pst=con.prepareStatement("select id,user_name,password,"
						+ "name,user_role,created_by,created_at,active,"
						+ "updated_at,updated_by,phone,email from tbl_user_login where user_name=?");
				pst.setString(1, id);
				
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()==false)
				{
					return null;
				}
				
				rs.beforeFirst();
				
				UserLogin user=new UserLogin();
				
				while(rs.next())
				{
					user.setId(rs.getLong(1));
					user.setUser_name(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setName(rs.getString(4));
					user.setUser_role(rs.getString(5));
					user.setCreated_by(rs.getString(6));
					user.setCreated_at(rs.getString(7));
					user.setActive(rs.getBoolean(8));
					user.setUpdated_at(rs.getString(9));
					user.setUpdated_by(rs.getString(10));
					user.setPhone(rs.getString(11));
					user.setEmail(rs.getString(12));
				}
				System.out.println(user.toString());
				return user;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		
		
		return null;
	}
	
	
	
	public int updateUserRecordAction(UserLogin user)
	{
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String updatedAt=df.format(date);
		String updatedBy=((UserLogin)session.getAttribute("userObj")).getName();
		int i=0;
		
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return 0;
			}

			else 
			{
				logger.info("update tbl_user_login set "
						+ "user_name=?,password=?,name=?,user_role=?,active=?,updated_by=?,updated_at=?,"
						+ "phone=?,email=? where "
						+ "id=?");
				PreparedStatement pst=con.prepareStatement("update tbl_user_login set "
						+ "user_name=?,password=?,name=?,user_role=?,active=?,updated_by=?,updated_at=?,"
						+ "phone=?,email=? where "
						+ "id=?");
				pst.setString(1, user.getUser_name());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getName());
				pst.setString(4, user.getUser_role());
				pst.setBoolean(5, user.isActive());
				pst.setString(6, updatedBy);
				pst.setString(7, updatedAt);
				pst.setString(8, user.getPhone());
				pst.setString(9, user.getEmail());
				pst.setLong(10, user.getId());
				
				i = pst.executeUpdate();
				
			}
			
			return i;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return i;
	}
	
	
	
	public List<UserLogin> getAllUsers()
	{
		long id=((UserLogin)session.getAttribute("userObj")).getId();
		List<UserLogin> list=new ArrayList<UserLogin>();
		try {
			con = ConnectionFactory.getConnection();
			if (con == null) {
				logger.info("connection is not establish!");
				return list;
			}

			else 
			{
				logger.info("Selecting all user Records");
				PreparedStatement pst=con.prepareStatement("select id,user_name,password,name,"
						+ "user_role,created_by,created_at,active,updated_at,updated_by,phone,email "
						+ "from tbl_user_login where id != ?");
				
				pst.setLong(1, id);
				ResultSet rs=pst.executeQuery();
				System.out.println(rs);
				if(rs.next()==false)
				{
					System.out.println("No record found");
					return list;
				}
				
				else
				{
					System.out.println("record found");
					rs.beforeFirst();
					while(rs.next())
					{
						UserLogin user=new UserLogin();
						user.setId(rs.getLong(1));
						user.setUser_name(rs.getString(2));
						user.setPassword(rs.getString(3));
						user.setName(rs.getString(4));
						user.setUser_role(rs.getString(5));
						user.setCreated_by(rs.getString(6));
						user.setCreated_at(rs.getString(7));
						user.setActive(rs.getBoolean(8));
						user.setUpdated_at(rs.getString(9));
						user.setUpdated_by(rs.getString(10));
						user.setPhone(rs.getString(11));
						user.setEmail(rs.getString(12));
						list.add(user);
					}
					
					return list;
				}
				
			}
			
			
			
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}
		
	
}
