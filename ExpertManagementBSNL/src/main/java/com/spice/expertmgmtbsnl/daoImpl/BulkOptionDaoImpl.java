package com.spice.expertmgmtbsnl.daoImpl;

import java.net.InetAddress;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.BulkOptionDao;
import com.spice.expertmgmtbsnl.model.UserLoginModel;


@Repository
@Transactional
public class BulkOptionDaoImpl implements BulkOptionDao{

	Logger logger=Logger.getLogger(BulkOptionDaoImpl.class.getName());
	
	@Autowired
	HttpSession session;
	
	
	public String[] bulkOptionStatusChanged(String[] chatid,String zone,String operation)
	{
		
		try{
			Connection con=ConnectionFactory.getConnection();
			String[] w_chatid=new String[chatid.length];
			boolean f=false;
			InetAddress localhost = InetAddress.getLocalHost();
			String ip=localhost.getHostAddress();
			String action_taken_by=((UserLoginModel)session.getAttribute("loginObj")).getUserName();
			
			logger.info("Calling Procedure {[proc_bulk_update}]");
			for(int i=0;i<chatid.length;i++)
			{
				logger.info("chat id is {["+chatid[i]+"}] zone is {["+zone+"}] New Status is {["+operation+"}] Action_Taken_By "
						+ "{["+action_taken_by+"]} and IP is {["+ip+"}]");
				
			
			CallableStatement cst=con.prepareCall("{call proc_bulk_update(?,?,?,?,?,?)}");
			cst.setString(1, chatid[i].trim());
			cst.setString(2, zone);
			cst.setString(3, operation);
			cst.setString(4, action_taken_by);
			cst.setString(5, ip);
			
			cst.executeUpdate();
			String res=cst.getString(6);
			logger.info("Respnse Value of Procedure is  {["+res+"}]");
			
			if(res==null)
			{
				logger.info("{["+chatid[i]+"}] is not updated successfully");
				w_chatid[i]=chatid[i];
				
			}
			else
			{
				logger.info(chatid[i]+" is updated successfully");
			}
			
			}
			logger.info("length of array in dao "+w_chatid.length);
			return w_chatid;
}
		catch(Exception e)
		{
			logger.info(e.toString());
			return null;
		}
	}
	
	
	public String[] bulkOptionCallLimitChanged(String[] chatid,String zone,String operation,String call_limit)
	{
		
		try{
			Connection con=ConnectionFactory.getConnection();
			String[] w_chatid=new String[chatid.length];
			InetAddress localhost = InetAddress.getLocalHost();
			String ip=localhost.getHostAddress();
			String action_taken_by=((UserLoginModel)session.getAttribute("loginObj")).getUserName();
			logger.info("calling porcedures");
			for(int i=0;i<chatid.length;i++)
			{
				logger.info("chat id is "+chatid[i]+"zone is "+zone+" statsu is "+operation+" call limit is "+call_limit);
			
			CallableStatement cst=con.prepareCall("{call proc_bulk_update_call_limit(?,?,?,?,?,?,?)}");
			cst.setString(1, chatid[i].trim());
			cst.setString(2, zone);
			cst.setString(3, operation);
			cst.setString(4, action_taken_by);
			cst.setString(5, ip);
			cst.setInt(6, Integer.parseInt(call_limit));
			cst.executeUpdate();
			String res=cst.getString(7);
			logger.info("Result set Value is :  "+res);
			
			if(res.length()>0)
			{
				logger.info(chatid[i]+" is updated successfully");
			}
			else
			{
				logger.info(chatid[i]+" is not updated successfully");
				w_chatid[i]=chatid[i];
			}
			
			}
			
			return w_chatid;
}
		catch(Exception e)
		{
			logger.info(e.toString());
			return null;
		}
	}

}
