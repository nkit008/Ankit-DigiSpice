package com.digispice.ghana.daoImpl;

import com.digispice.ghana.bean.CrbtMisBean;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.CrbtMisDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class CrbtMisDaoImpl
  implements CrbtMisDao
{
  @Autowired
  HttpSession session;
  private static final Logger logger = Logger.getLogger(CrbtMisDaoImpl.class.getName());
  
  public static Connection con = null;
  
  public CrbtMisDaoImpl() {}
  
  public List<CrbtMisBean> getMis(String startdate, String enddate, String mode) {
    try {
      con = GetConnection.getConnection();
      
      if (con == null)
      {
        logger.info("connection not establish");
        return null;
      }
      


      Statement st = con.createStatement();
      logger.info("start date is " + startdate + " and end date is " + enddate);
      ResultSet rs = st.executeQuery("Select date,total_calls_ivr,sub_user_calls_ivr,non_sub_user_calls_ivr,total_hits_ussd,sub_user_hits_ussd,nonsub_user_hits_ussd,total_hits_sms,sub_user_hits_sms,nonsub_user_hits_sms,total_unique_callers,unique_sub_callers,unique_nonsub_callers,p2p_call,daily_new_download,weekly_new_download,monthly_new_download,corp_tone_new_download,free_user_new_download,total_tone_download_new_download,total_tone_sub_attampt_new_download,total_tone_sub_fail_new_download,daily_tone_renew,weekly_tone_renew,monthly_tone_renew,corp_tone_renew,total_tone_download_tone_renew,total_tone_sub_attampt_tone_renew,total_tone_sub_fail_tone_renew,daily_new_sub,weekly_new_sub,monthly_new_sub,corp_tone_new_sub,free_user_new_sub,total_tone_download_new_sub,total_tone_sub_attampt_new_sub,total_tone_sub_fail_new_sub,daily_sub_renew,weekly_sub_renew,monthly_sub_renew,corp_sub_renew,total_tone_download_sub_renew,total_tone_sub_attampt_sub_renew,total_tone_sub_fail_sub_renew,sub_mode_ivr,sub_mode_cci,sub_mode_obd,sub_mode_sms,sub_mode_copy,sub_mode_gift,sub_mode_wap,sub_mode_ussd,sub_mode_others,voluntary_unsub,involuntary_unsub,gross_adds,unsub_mode_ivr,unsub_mode_ussd,unsub_mode_web,unsub_mode_cci,unsub_mode_sms,unsub_mode_others,total_name_tone_req,already_avail,not_avail,total_req_recived,accepted,rejected,daily_tone_revenue,weekly_tone_revenue,monthly_tone_revenue,daily_sub_revenue,weekly_sub_revenue,monthly_sub_revenue,daily_packwise_revenue,weekly_packwise_revenue,monthly_packwise_revenue,total_revenue_local,total_revenue_usd,active_subscriber_sub,active_subscriber_tone,new_tone,new_tone_low_bal,grace,renewal_low_bal_sub,renewal_low_bal_tone,billed_subscriber,total_base,no_of_tone_subscriber,users_without_tone,service_pentration,arpu from tbl_crbt_mis where date between '" + 
      

















        startdate + "' and '" + enddate + "' " + 
        "order by id ASC");
      


      List<CrbtMisBean> list = new ArrayList();
      while (rs.next())
      {
        CrbtMisBean mis = new CrbtMisBean();
        
        mis.setDate(rs.getString(1));
        mis.setTotal_calls_ivr(rs.getString(2));
        mis.setSub_user_calls_ivr(rs.getString(3));
        mis.setNon_sub_user_calls_ivr(rs.getString(4));
        mis.setTotal_hits_ussd(rs.getString(5));
        mis.setSub_user_hits_ussd(rs.getString(6));
        mis.setNonsub_user_hits_ussd(rs.getString(7));
        mis.setTotal_hits_sms(rs.getString(8));
        mis.setSub_user_hits_sms(rs.getString(9));
        mis.setNonsub_user_hits_sms(rs.getString(10));
        mis.setTotal_unique_callers(rs.getString(11));
        mis.setUnique_sub_callers(rs.getString(12));
        mis.setUnique_nonsub_callers(rs.getString(13));
        mis.setP2p_call(rs.getString(14));
        mis.setDaily_new_download(rs.getString(15));
        mis.setWeekly_new_download(rs.getString(16));
        mis.setMonthly_new_download(rs.getString(17));
        mis.setCorp_tone_new_download(rs.getString(18));
        mis.setFree_user_new_download(rs.getString(19));
        mis.setTotal_tone_download_new_download(rs.getString(20));
        mis.setTotal_tone_sub_attampt_new_download(rs.getString(21));
        mis.setTotal_tone_sub_fail_new_download(rs.getString(22));
        mis.setDaily_tone_renew(rs.getString(23));
        mis.setWeekly_tone_renew(rs.getString(24));
        mis.setMonthly_tone_renew(rs.getString(25));
        mis.setCorp_tone_renew(rs.getString(26));
        mis.setTotal_tone_download_tone_renew(rs.getString(27));
        mis.setTotal_tone_sub_attampt_tone_renew(rs.getString(28));
        mis.setTotal_tone_sub_fail_tone_renew(rs.getString(29));
        mis.setDaily_new_sub(rs.getString(30));
        mis.setWeekly_new_sub(rs.getString(31));
        mis.setMonthly_new_sub(rs.getString(32));
        mis.setCorp_tone_new_sub(rs.getString(33));
        mis.setFree_user_new_sub(rs.getString(34));
        mis.setTotal_tone_download_new_sub(rs.getString(35));
        mis.setTotal_tone_sub_attampt_new_sub(rs.getString(36));
        mis.setTotal_tone_sub_fail_new_sub(rs.getString(37));
        mis.setDaily_sub_renew(rs.getString(38));
        mis.setWeekly_sub_renew(rs.getString(39));
        mis.setMonthly_sub_renew(rs.getString(40));
        mis.setCorp_sub_renew(rs.getString(41));
        mis.setTotal_tone_download_sub_renew(rs.getString(42));
        mis.setTotal_tone_sub_attampt_sub_renew(rs.getString(43));
        mis.setTotal_tone_sub_fail_sub_renew(rs.getString(44));
        mis.setSub_mode_ivr(rs.getString(45));
        mis.setSub_mode_cci(rs.getString(46));
        mis.setSub_mode_obd(rs.getString(47));
        mis.setSub_mode_sms(rs.getString(48));
        mis.setSub_mode_copy(rs.getString(49));
        mis.setSub_mode_gift(rs.getString(50));
        mis.setSub_mode_wap(rs.getString(51));
        mis.setSub_mode_ussd(rs.getString(52));
        mis.setSub_mode_others(rs.getString(53));
        mis.setVoluntary_unsub(rs.getString(54));
        mis.setInvoluntary_unsub(rs.getString(55));
        mis.setGross_adds(rs.getString(56));
        mis.setUnsub_mode_ivr(rs.getString(57));
        mis.setUnsub_mode_ussd(rs.getString(58));
        mis.setUnsub_mode_web(rs.getString(59));
        mis.setUnsub_mode_cci(rs.getString(60));
        mis.setUnsub_mode_sms(rs.getString(61));
        mis.setUnsub_mode_others(rs.getString(62));
        mis.setTotal_name_tone_req(rs.getString(63));
        mis.setAlready_avail(rs.getString(64));
        mis.setNot_avail(rs.getString(65));
        mis.setTotal_req_recived(rs.getString(66));
        mis.setAccepted(rs.getString(67));
        mis.setRejected(rs.getString(68));
        mis.setDaily_tone_revenue(rs.getString(69));
        mis.setWeekly_tone_revenue(rs.getString(70));
        mis.setMonthly_tone_revenue(rs.getString(71));
        mis.setDaily_sub_revenue(rs.getString(72));
        mis.setWeekly_sub_revenue(rs.getString(73));
        mis.setMonthly_sub_revenue(rs.getString(74));
        mis.setDaily_packwise_revenue(rs.getString(75));
        mis.setWeekly_packwise_revenue(rs.getString(76));
        mis.setMonthly_packwise_revenue(rs.getString(77));
        mis.setTotal_revenue_local(rs.getString(78));
        mis.setTotal_revenue_usd(rs.getString(79));
        
        mis.setActive_subscriber_sub(rs.getString(80));
        mis.setActive_subscriber_tone(rs.getString(81));
        mis.setNew_tone(rs.getString(82));
        mis.setNew_tone_low_bal(rs.getString(83));
        mis.setGrace(rs.getString(84));
        mis.setRenewal_low_bal_sub(rs.getString(85));
        mis.setRenewal_low_bal_tone(rs.getString(86));
        mis.setBilled_subscriber(rs.getString(87));
        mis.setTotal_base(rs.getString(88));
        mis.setNo_of_tone_subscriber(rs.getString(89));
        mis.setUsers_without_tone(rs.getString(90));
        mis.setService_pentration(rs.getString(91));
        mis.setArpu(rs.getString(92));
        list.add(mis);
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