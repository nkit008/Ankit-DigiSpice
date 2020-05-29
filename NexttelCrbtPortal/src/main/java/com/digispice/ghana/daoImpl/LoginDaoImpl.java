package com.digispice.ghana.daoImpl;

import com.digispice.ghana.bean.UserDetails;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class LoginDaoImpl
  implements LoginDao
{
  @Autowired
  HttpSession session;
  private static final Logger logger = Logger.getLogger(LoginDaoImpl.class.getName());
  
  public static Connection con = null;
  
  public LoginDaoImpl() {}
  
  public List<UserDetails> CheckLogin(String username, String password)
  {
    try
    {
      con = GetConnection.getConnection();
      
      if (con == null)
      {
        logger.info("connection not establish");
        return null;
      }
      


      PreparedStatement pst = con.prepareStatement("select id,username,password,role,login_as from tbl_user_login where username=? and password=?");
      pst.setString(1, username);
      pst.setString(2, password);
      ResultSet rs = pst.executeQuery();
      
      List<UserDetails> list = new ArrayList();
      while (rs.next())
      {
        UserDetails user = new UserDetails();
        
        user.setId(rs.getInt(1));
        user.setUsername(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setRole(rs.getString(4));
        user.setLogin_as(rs.getString(5));
        list.add(user);
      }
      
      return list;


    }
    catch (Exception e)
    {

      e.printStackTrace();

    }
    finally
    {
      if (con != null) {
        try
        {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}