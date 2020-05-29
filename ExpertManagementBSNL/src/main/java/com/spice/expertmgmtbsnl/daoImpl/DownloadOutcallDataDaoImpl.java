package com.spice.expertmgmtbsnl.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spice.expertmgmtbsnl.connection.ConnectionFactory;
import com.spice.expertmgmtbsnl.dao.DownloadOutcallDataDao;
import com.spice.expertmgmtbsnl.model.EtalkOutcallModel;

@Repository
@Transactional
public class DownloadOutcallDataDaoImpl implements DownloadOutcallDataDao{

	Logger logger=Logger.getLogger(DownloadOutcallDataDaoImpl.class.getName());
	
	public List<EtalkOutcallModel> getDetailbyChatId(String chatId){
		List<EtalkOutcallModel> list=new ArrayList<EtalkOutcallModel>();
		
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			String query = "select DATE_TIME,Log_datetime,TRANSACTIONID,LINE,"
					+ "CALL_DATE,CALL_TIME,DURATION,ANI,A_CHATID,A_CIRCLE,B_ANI,B_CHATID"
					+ ",B_CIRCLE,CLI,A_LINE,CALL_VALUE,CALL_CODE,REASON,INSTENT_DURATION,CALL_STATUS,"
					+ "DNIS,CATEGORY,USER_STATUS,SERVICE,DISCONNECT,IP from tbl_etalk_outcall where B_CHATID = '"+chatId+"' AND Log_datetime BETWEEN CURDATE() - INTERVAL 1 DAY AND NOW()"; 
			ResultSet rs=st.executeQuery(query);  
			
			logger.info("Query is {["+query+"}]");
			while(rs.next())
			{
				EtalkOutcallModel obj=new EtalkOutcallModel();
				
				obj.setDateTime(rs.getString(1));
				obj.setLogDateTime(rs.getString(2));
				obj.setTransactionId(rs.getString(3));
				obj.setLine(rs.getString(4));
				obj.setCallDate(rs.getString(5));
				obj.setCallTime(rs.getString(6));
				obj.setDuration(rs.getLong(7));
				obj.setAni(rs.getLong(8));
				obj.setaChatid(rs.getString(9));
				obj.setaCircle(rs.getString(10));
				obj.setbAni(rs.getString(11));
				obj.setbChatid(rs.getString(12));
				obj.setbCircle(rs.getString(13));
				obj.setCli(rs.getString(14));
				obj.setaLine(rs.getString(15));
				obj.setCallValue(rs.getString(16));
				obj.setCallCode(rs.getString(17));
				obj.setReason(rs.getString(18));
				obj.setInstentDuration(rs.getLong(19));
				obj.setCallStatus(rs.getString(20));
				obj.setDnis(rs.getString(21));
				obj.setCategory(rs.getString(22));
				obj.setUserStatus(rs.getString(23));
				obj.setService(rs.getString(24));
				obj.setDisconnect(rs.getString(25));
				obj.setIp(rs.getString(26));
				
				list.add(obj);
			}
			return list;
		}
		catch(Exception e)
		{
			logger.info(e);
			return null;
		}
	}
	
	
	public List<EtalkOutcallModel> getDetailbyAni(String ani)
	{
		
		List<EtalkOutcallModel> list=new ArrayList<EtalkOutcallModel>();
		
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select DATE_TIME,Log_datetime,TRANSACTIONID,LINE,"
					+ "CALL_DATE,CALL_TIME,DURATION,ANI,A_CHATID,A_CIRCLE,B_ANI,B_CHATID"
					+ ",B_CIRCLE,CLI,A_LINE,CALL_VALUE,CALL_CODE,REASON,INSTENT_DURATION,CALL_STATUS,"
					+ "DNIS,CATEGORY,USER_STATUS,SERVICE,DISCONNECT,IP from tbl_etalk_outcall where ANI = '"+ani +"' AND Log_datetime BETWEEN CURDATE() - INTERVAL 1 DAY AND NOW()");
			
			while(rs.next())
			{
				EtalkOutcallModel obj=new EtalkOutcallModel();
				
				obj.setDateTime(rs.getString(1));
				obj.setLogDateTime(rs.getString(2));
				obj.setTransactionId(rs.getString(3));
				obj.setLine(rs.getString(4));
				obj.setCallDate(rs.getString(5));
				obj.setCallTime(rs.getString(6));
				obj.setDuration(rs.getLong(7));
				obj.setAni(rs.getLong(8));
				obj.setaChatid(rs.getString(9));
				obj.setaCircle(rs.getString(10));
				obj.setbAni(rs.getString(11));
				obj.setbChatid(rs.getString(12));
				obj.setbCircle(rs.getString(13));
				obj.setCli(rs.getString(14));
				obj.setaLine(rs.getString(15));
				obj.setCallValue(rs.getString(16));
				obj.setCallCode(rs.getString(17));
				obj.setReason(rs.getString(18));
				obj.setInstentDuration(rs.getLong(19));
				obj.setCallStatus(rs.getString(20));
				obj.setDnis(rs.getString(21));
				obj.setCategory(rs.getString(22));
				obj.setUserStatus(rs.getString(23));
				obj.setService(rs.getString(24));
				obj.setDisconnect(rs.getString(25));
				obj.setIp(rs.getString(26));
				
				list.add(obj);
			}
			return list;
		}
		catch(Exception e)
		{
			logger.info(e);
			return null;
		}
	}
	

}
