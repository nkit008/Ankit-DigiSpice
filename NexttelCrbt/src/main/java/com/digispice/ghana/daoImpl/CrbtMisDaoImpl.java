package com.digispice.ghana.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digispice.ghana.bean.CrbtMisBean;
import com.digispice.ghana.bean.NextMusicMISEntity;
import com.digispice.ghana.bean.NextVoiceMISEntity;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.CrbtMisDao;

@Repository
public class CrbtMisDaoImpl implements CrbtMisDao {

	@Autowired
	HttpSession session;

	private static final Logger logger = LoggerFactory.getLogger(CrbtMisDaoImpl.class.getName());

	public static Connection con = null;

	public List<CrbtMisBean> getMis(String startdate, String enddate) {
		try {
			con = GetConnection.getConnection();

			if (con == null) {
				logger.info("connection not establish");
				return null;
			}

			else {
				Statement st = con.createStatement();
				logger.info("start date is " + startdate + " and end date is " + enddate);
				ResultSet rs = st
						.executeQuery("Select DATE(date),total_calls_ivr,sub_user_calls_ivr,non_sub_user_calls_ivr,"
								+ "total_hits_ussd,sub_user_hits_ussd,nonsub_user_hits_ussd,total_hits_sms,"
								+ "sub_user_hits_sms,nonsub_user_hits_sms,total_unique_callers,unique_sub_callers,unique_nonsub_callers,"
								+ "p2p_call,daily_new_download,weekly_new_download,monthly_new_download,corp_tone_new_download,"
								+ "free_user_new_download,total_tone_download_new_download,total_tone_sub_attampt_new_download,"
								+ "total_tone_sub_fail_new_download,daily_tone_renew,weekly_tone_renew,monthly_tone_renew,"
								+ "corp_tone_renew,total_tone_download_tone_renew,total_tone_sub_attampt_tone_renew,total_tone_sub_fail_tone_renew,"
								+ "daily_new_sub,weekly_new_sub,monthly_new_sub,corp_tone_new_sub,free_user_new_sub,"
								+ "total_tone_download_new_sub,total_tone_sub_attampt_new_sub,total_tone_sub_fail_new_sub,"
								+ "daily_sub_renew,weekly_sub_renew,monthly_sub_renew,corp_sub_renew,total_tone_download_sub_renew,"
								+ "total_tone_sub_attampt_sub_renew,total_tone_sub_fail_sub_renew,sub_mode_ivr,sub_mode_cci,"
								+ "sub_mode_obd,sub_mode_sms,sub_mode_copy,sub_mode_gift,sub_mode_wap,sub_mode_ussd,"
								+ "sub_mode_others,voluntary_unsub,involuntary_unsub,gross_adds,unsub_mode_ivr,"
								+ "unsub_mode_ussd,unsub_mode_web,unsub_mode_cci,unsub_mode_sms,unsub_mode_others,"
								+ "total_name_tone_req,already_avail,not_avail,total_req_recived,accepted,rejected,"
								+ "daily_tone_revenue,weekly_tone_revenue,monthly_tone_revenue,daily_sub_revenue,weekly_sub_revenue,"
								+ "monthly_sub_revenue,daily_packwise_revenue,weekly_packwise_revenue,monthly_packwise_revenue,total_revenue_local,"
								+ "total_revenue_usd,active_subscriber_sub,active_subscriber_tone,new_tone,new_tone_low_bal,"
								+ "grace,renewal_low_bal_sub,renewal_low_bal_tone,billed_subscriber,total_base,no_of_tone_subscriber,"
								+ "users_without_tone,service_pentration,arpu from tbl_crbt_mis where date between '"
								+ startdate + "' and '" + enddate + "' " + "order by id ASC");

				List<CrbtMisBean> list = new ArrayList<CrbtMisBean>();
				while (rs.next()) {
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

	public List<NextMusicMISEntity> getNextMusicMis(String startdate, String enddate) {
		List<NextMusicMISEntity> list = new ArrayList<NextMusicMISEntity>();
		try {
			con = GetConnection.getConnectionNextMusic();

			if (con == null) {
				logger.info("connection not establish");
				return null;
			}

			else {
				Statement st = con.createStatement();
				logger.info("start date is " + startdate + " and end date is " + enddate);
				String query = "select IFNULL(id,0),IFNULL(DATE(date_time),0),IFNULL(total_calls,0),"
						+ "IFNULL(subscribed_user_calls,0),IFNULL(non_subscribed_user_calls,0),"
						+ "IFNULL(total_mou,0),IFNULL(subscribed_user_mou,0),IFNULL(non_subscribed_user_mou,0),"
						+ "IFNULL(total_pulses,0),IFNULL(subscribed_user_pulses,0),IFNULL(non_subscribed_user_pulses,0),"
						+ "IFNULL(total_unique_callers,0),IFNULL(unique_subscribed_callers,0),"
						+ "IFNULL(unique_non_subscribed_callers,0),IFNULL(monthly_subscriptions_requests_rececived,0),"
						+ "IFNULL(weekly_subscriptions_requests_rececived,0),IFNULL(daily_subscriptions_requests_rececived,0),"
						+ "IFNULL(monthly_subscriptions_successfull,0),IFNULL(weekly_subscriptions_successfull,0),"
						+ "IFNULL(daily_subscriptions_successfull,0),IFNULL(voluntary_unsubscription,0),"
						+ "IFNULL(involuntary_unsubscription,0),IFNULL(gross_adds,0),"
						+ "IFNULL(re_monthly_subscriptions,0),IFNULL(re_weekly_subscriptions,0),"
						+ "IFNULL(re_daily_subscriptions,0),IFNULL(subscription_ivr,0),IFNULL(subscription_cci,0),"
						+ "IFNULL(subscription_obd,0),IFNULL(subscription_sms,0),IFNULL(subscription_tnb,0),"
						+ "IFNULL(subscription_ussd,0),IFNULL(subscription_others,0),"
						+ "IFNULL(unsubscription_ivr,0),IFNULL(unsubscription_cci,0),"
						+ "IFNULL(unsubscription_sms,0),IFNULL(unsubscription_app,0),IFNULL(unsubscription_others,0),"
						+ "IFNULL(requested_songs,0),IFNULL(successfull_billed_songs,0),"
						+ "IFNULL(browsing_revenue,0),IFNULL(monthly_subscription_revnue,0),"
						+ "IFNULL(weekly_subscription_revenue,0),IFNULL(daily_subscription_revenue,0),"
						+ "IFNULL(song_download_revenue,0),IFNULL(gross_revenue,0),IFNULL(gross_revenue_usd,0),"
						+ "IFNULL(system_active_subscribers,0),IFNULL(billed_subscribers,0),"
						+ "IFNULL(calling_subscribers,0),IFNULL(activeBase_0_10,0),IFNULL(activeBase_11_30,0),"
						+ "IFNULL(activeBase_31_60,0),IFNULL(activeBase_61_90,0),IFNULL(activeBase_above90,0),"
						+ "IFNULL(average_non_subscriber_call_per_unique_caller,0),"
						+ "IFNULL(average_non_subscriber_mou_per_unique_caller,0),"
						+ "IFNULL(average_non_subscriber_mou_per_calls,0),IFNULL(average_subscriber_call_per_unique_caller,0),"
						+ "IFNULL(average_subscriber_mou_per_unique_caller,0),IFNULL(average_subscriber_mou_per_calls,0),"
						+ "IFNULL(average_dedication_mou_per_unique_caller,0),"
						+ "IFNULL(system_unique_caller_per_active_subscribers,0),"
						+ "IFNULL(service_penetration,0),IFNULL(arpu,0),"
						+ "IFNULL(subscribers_moved_from_active_to_grace,0),IFNULL(subscribers_moved_from_grace_to_active,0),"
						+ "IFNULL(subscribers_in_1_7_days_grace_with_service,0),IFNULL(subscribers_in_8_14_days_retry,0),"
						+ "IFNULL(subscribers_in_15_21_days_retry,0),IFNULL(subscribers_in_22_30_days_retry,0),"
						+ "IFNULL(mins_0_1,0),IFNULL(mins_1_2,0),IFNULL(mins_2_3,0),IFNULL(mins_3_4,0),"
						+ "IFNULL(mins_4_5,0),IFNULL(mins_5_6,0),IFNULL(mins_6_7,0),IFNULL(mins_7_8,0),"
						+ "IFNULL(mins_8_9,0),IFNULL(mins_9_10,0),IFNULL(mins_above10,0) "
						+ "from tbl_cameroon_mod_mis where date_time between '" + startdate + "' and '" + enddate + "'"
						+ " order by id ASC";
				ResultSet rs = st.executeQuery(query);
				logger.info("final query is {}", query);
				while (rs.next()) {
					NextMusicMISEntity musicMISEntity = new NextMusicMISEntity();
					musicMISEntity.setId(rs.getLong(1));
					musicMISEntity.setDate_time(rs.getString(2));
					musicMISEntity.setTotal_calls(rs.getString(3));
					musicMISEntity.setSubscribed_user_calls(rs.getString(4));
					musicMISEntity.setNon_subscribed_user_calls(rs.getString(5));
					musicMISEntity.setTotal_mou(rs.getString(6));
					musicMISEntity.setSubscribed_user_mou(rs.getString(7));
					musicMISEntity.setNon_subscribed_user_mou(rs.getString(8));
					musicMISEntity.setTotal_pulses(rs.getString(9));
					musicMISEntity.setSubscribed_user_pulses(rs.getString(10));
					musicMISEntity.setNon_subscribed_user_pulses(rs.getString(11));
					musicMISEntity.setTotal_unique_callers(rs.getString(12));
					musicMISEntity.setUnique_subscribed_callers(rs.getString(13));
					musicMISEntity.setUnique_non_subscribed_callers(rs.getString(14));
					musicMISEntity.setMonthly_subscriptions_requests_rececived(rs.getString(15));
					musicMISEntity.setWeekly_subscriptions_requests_rececived(rs.getString(16));
					musicMISEntity.setDaily_subscriptions_requests_rececived(rs.getString(17));
					musicMISEntity.setMonthly_subscriptions_successfull(rs.getString(18));
					musicMISEntity.setWeekly_subscriptions_successfull(rs.getString(19));
					musicMISEntity.setDaily_subscriptions_successfull(rs.getString(20));
					musicMISEntity.setVoluntary_unsubscription(rs.getString(21));
					musicMISEntity.setInvoluntary_unsubscription(rs.getString(22));
					musicMISEntity.setGross_adds(rs.getString(23));
					musicMISEntity.setRe_monthly_subscriptions(rs.getString(24));
					musicMISEntity.setRe_weekly_subscriptions(rs.getString(25));
					musicMISEntity.setRe_daily_subscriptions(rs.getString(26));
					musicMISEntity.setSubscription_ivr(rs.getString(27));
					musicMISEntity.setSubscription_cci(rs.getString(28));
					musicMISEntity.setSubscription_obd(rs.getString(29));
					musicMISEntity.setSubscription_sms(rs.getString(30));
					musicMISEntity.setSubscription_tnb(rs.getString(31));
					musicMISEntity.setSubscription_ussd(rs.getString(32));
					musicMISEntity.setSubscription_others(rs.getString(33));
					musicMISEntity.setUnsubscription_ivr(rs.getString(34));
					musicMISEntity.setUnsubscription_cci(rs.getString(35));
					musicMISEntity.setUnsubscription_sms(rs.getString(36));
					musicMISEntity.setUnsubscription_app(rs.getString(37));
					musicMISEntity.setUnsubscription_others(rs.getString(38));
					musicMISEntity.setRequested_songs(rs.getString(39));
					musicMISEntity.setSuccessfull_billed_songs(rs.getString(40));
					musicMISEntity.setBrowsing_revenue(rs.getString(41));
					musicMISEntity.setMonthly_subscription_revnue(rs.getString(42));
					musicMISEntity.setWeekly_subscription_revenue(rs.getString(43));
					musicMISEntity.setDaily_subscription_revenue(rs.getString(44));
					musicMISEntity.setSong_download_revenue(rs.getString(45));
					musicMISEntity.setGross_revenue(rs.getString(46));
					musicMISEntity.setGross_revenue_usd(rs.getString(47));
					musicMISEntity.setSystem_active_subscribers(rs.getString(48));
					musicMISEntity.setBilled_subscribers(rs.getString(49));
					musicMISEntity.setCalling_subscribers(rs.getString(50));
					musicMISEntity.setActiveBase_0_10(rs.getString(51));
					musicMISEntity.setActiveBase_11_30(rs.getString(52));
					musicMISEntity.setActiveBase_31_60(rs.getString(53));
					musicMISEntity.setActiveBase_61_90(rs.getString(54));
					musicMISEntity.setActiveBase_above90(rs.getString(55));
					musicMISEntity.setAverage_non_subscriber_call_per_unique_caller(rs.getString(56));
					musicMISEntity.setAverage_non_subscriber_mou_per_unique_caller(rs.getString(57));
					musicMISEntity.setAverage_non_subscriber_mou_per_calls(rs.getString(58));
					musicMISEntity.setAverage_subscriber_call_per_unique_caller(rs.getString(59));
					musicMISEntity.setAverage_subscriber_mou_per_unique_caller(rs.getString(60));
					musicMISEntity.setAverage_subscriber_mou_per_calls(rs.getString(61));
					musicMISEntity.setAverage_dedication_mou_per_unique_caller(rs.getString(62));
					musicMISEntity.setSystem_unique_caller_per_active_subscribers(rs.getString(63));
					musicMISEntity.setService_penetration(rs.getString(64));
					musicMISEntity.setArpu(rs.getString(65));
					musicMISEntity.setSubscribers_moved_from_active_to_grace(rs.getString(66));
					musicMISEntity.setSubscribers_moved_from_grace_to_active(rs.getString(67));
					musicMISEntity.setSubscribers_in_1_7_days_grace_with_service(rs.getString(68));
					musicMISEntity.setSubscribers_in_8_14_days_retry(rs.getString(69));
					musicMISEntity.setSubscribers_in_15_21_days_retry(rs.getString(70));
					musicMISEntity.setSubscribers_in_22_30_days_retry(rs.getString(71));
					musicMISEntity.setMins_0_1(rs.getString(72));
					musicMISEntity.setMins_1_2(rs.getString(73));
					musicMISEntity.setMins_2_3(rs.getString(74));
					musicMISEntity.setMins_3_4(rs.getString(75));
					musicMISEntity.setMins_4_5(rs.getString(76));
					musicMISEntity.setMins_5_6(rs.getString(77));
					musicMISEntity.setMins_6_7(rs.getString(78));
					musicMISEntity.setMins_7_8(rs.getString(79));
					musicMISEntity.setMins_8_9(rs.getString(80));
					musicMISEntity.setMins_9_10(rs.getString(81));
					musicMISEntity.setMins_above10(rs.getString(82));

					list.add(musicMISEntity);

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
		return list;

	}

	public List<NextVoiceMISEntity> getNextVoiceMis(String startdate, String enddate) {
		List<NextVoiceMISEntity> list = new ArrayList<NextVoiceMISEntity>();
		try {
			con = GetConnection.getConnectionNextVoice();

			if (con == null) {
				logger.info("connection not establish");
				return null;
			}

			else {
				Statement st = con.createStatement();
				logger.info("start date is " + startdate + " and end date is " + enddate);
				String query = "select IFNULL(id,0),IFNULL(DATE(date),0),IFNULL(total_calls,0),"
						+ "IFNULL(Subscribed_User_Calls,0),IFNULL(Non_Subscribed_User_Calls,0),"
						+ "IFNULL(Total_MOU,0),IFNULL(Subscribed_User_MOU,0),IFNULL(Non_Subscribed_User_MOU,0),"
						+ "IFNULL(Total_Pulses,0),IFNULL(Subscribed_User_Pulses,0),IFNULL(Non_Subscribed_User_Pulses,0),"
						+ "IFNULL(Total_Unique_Callers,0),IFNULL(Unique_subscribed_callers,0),"
						+ "IFNULL(Unique_Non_Subscribed_callers,0),IFNULL(Daily_Pack,0),"
						+ "IFNULL(Weekly_Pack,0),IFNULL(Montly_Pack,0),"
						+ "IFNULL(Yearly_Pack,0),IFNULL(Voluntary_Un_subscription,0),"
						+ "IFNULL(InVoluntary_Un_subscription,0),IFNULL(Gross_Adds,0),"
						+ "IFNULL(sub_IVR,0),IFNULL(sub_CCI,0)," + "IFNULL(sub_OBD,0),IFNULL(sub_SMS,0),"
						+ "IFNULL(sub_IBD,0),IFNULL(sub_USSD,0),IFNULL(sub_Others,0),"
						+ "IFNULL(Daily_Renewal,0),IFNULL(Weekly_Renewal_Pack,0),IFNULL(Montly_Renewal_Pack,0),"
						+ "IFNULL(Yearly_Renewal_Pack,0),IFNULL(unsub_IVR,0),"
						+ "IFNULL(unsub_CCI,0),IFNULL(unsub_SMS,0),"
						+ "IFNULL(unsub_Others,0),IFNULL(new_songs_Attempted,0),IFNULL(new_songs_Submitted,0),"
						+ "IFNULL(To_On_Net_Customer,0),IFNULL(To_Off_Net_Customer,0),IFNULL(dedication_Total,0),"
						+ "IFNULL(No_of_Voting_SMS,0),IFNULL(Unique_Users_Recorded_Songs,0),IFNULL(Total_Daily_Pack_Revenue,0),"
						+ "IFNULL(Total_Weekly_Pack_Revenue,0),"

						+ "IFNULL(Total_Monthly_Pack_Revenue,0),IFNULL(Total_Yearly_Pack_Revenue,0),"
						+ "IFNULL(Gross_Revenue_in_XAF,0),IFNULL(Gross_Revenue_in_USD,0),"
						+ "IFNULL(Active_Subscribers_in_the_System,0),IFNULL(Billed_Subscribers,0),"
						+ "IFNULL(Calling_Subscribers,0),IFNULL(Average_Subscriber_Call_Unique_Caller,0),"
						+ "IFNULL(Average_Subscriber_MOU_Unique_Caller,0),IFNULL(Average_Subscriber_MOU_Calls,0),"
						+ "IFNULL(Average_Dedication_Unique_Caller,0),"
						+ "IFNULL(Unique_Caller_Active_Subscribers_in_the_System,0),IFNULL(Service_Penetration,0),"
						+ "IFNULL(ARPU,0)," + "IFNULL(Subscribers_moved_from_Active_to_Grace,0),"
						+ "IFNULL(Subscribers_moved_from_Grace_to_Active,0),"
						+ "IFNULL(Subscribers_in_1_7_days_Grace_with_service,0),IFNULL(Subscribers_in_8_14_days_retry,0),"
						+ "IFNULL(Subscribers_in_15_21_Days_retry,0),IFNULL(Subscribers_in_22_30_days_retry,0),"
						+ "IFNULL(Mins0_1,0)," + "IFNULL(Mins1_2,0)," + "IFNULL(Mins2_3,0),IFNULL(Mins3_4,0),"
						+ "IFNULL(Mins4_5,0),IFNULL(Mins5_6,0)," + "IFNULL(Mins6_7,0),IFNULL(Mins7_8,0),"
						+ "IFNULL(Mins8_9,0),IFNULL(Mins9_10,0)," + "IFNULL(Mins10_Above,0)"
						+ "from tbl_cameroon_music_mis where date between '" + startdate + "' and '" + enddate + "'"
						+ " order by id ASC";

				ResultSet rs = st.executeQuery(query);
				logger.info("final query is {}", query);
				while (rs.next()) {
					NextVoiceMISEntity voiceMISEntity = new NextVoiceMISEntity();
					voiceMISEntity.setId(rs.getLong(1));
					voiceMISEntity.setDate(rs.getString(2));
					voiceMISEntity.setTotal_calls(rs.getString(3));
					voiceMISEntity.setSubscribed_User_Calls(rs.getString(4));
					voiceMISEntity.setNon_Subscribed_User_Calls(rs.getString(5));
					voiceMISEntity.setTotal_MOU(rs.getString(6));
					voiceMISEntity.setSubscribed_User_MOU(rs.getString(7));
					voiceMISEntity.setNon_Subscribed_User_MOU(rs.getString(8));
					voiceMISEntity.setTotal_Pulses(rs.getString(9));
					voiceMISEntity.setSubscribed_User_Pulses(rs.getString(10));
					voiceMISEntity.setNon_Subscribed_User_Pulses(rs.getString(11));
					voiceMISEntity.setTotal_Unique_Callers(rs.getString(12));
					voiceMISEntity.setUnique_subscribed_callers(rs.getString(13));
					voiceMISEntity.setUnique_Non_Subscribed_callers(rs.getString(14));
					voiceMISEntity.setDaily_Pack(rs.getString(15));
					voiceMISEntity.setWeekly_Pack(rs.getString(16));
					voiceMISEntity.setMontly_Pack(rs.getString(17));
					voiceMISEntity.setYearly_Pack(rs.getString(18));
					voiceMISEntity.setVoluntary_Un_subscription(rs.getString(19));
					voiceMISEntity.setInVoluntary_Un_subscription(rs.getString(20));
					voiceMISEntity.setGross_Adds(rs.getString(21));
					voiceMISEntity.setSub_IVR(rs.getString(22));
					voiceMISEntity.setSub_CCI(rs.getString(23));
					voiceMISEntity.setSub_OBD(rs.getString(24));
					voiceMISEntity.setSub_SMS(rs.getString(25));
					voiceMISEntity.setSub_IBD(rs.getString(26));
					voiceMISEntity.setSub_USSD(rs.getString(27));
					voiceMISEntity.setSub_Others(rs.getString(28));
					voiceMISEntity.setDaily_Renewal(rs.getString(29));
					voiceMISEntity.setWeekly_Renewal_Pack(rs.getString(30));
					voiceMISEntity.setMontly_Renewal_Pack(rs.getString(31));
					voiceMISEntity.setYearly_Renewal_Pack(rs.getString(32));
					voiceMISEntity.setUnsub_IVR(rs.getString(33));
					voiceMISEntity.setUnsub_CCI(rs.getString(34));
					voiceMISEntity.setUnsub_SMS(rs.getString(35));
					voiceMISEntity.setUnsub_Others(rs.getString(36));
					voiceMISEntity.setNew_songs_Attempted(rs.getString(37));
					voiceMISEntity.setNew_songs_Submitted(rs.getString(38));
					voiceMISEntity.setTo_On_Net_Customer(rs.getString(39));
					voiceMISEntity.setTo_Off_Net_Customer(rs.getString(40));
					voiceMISEntity.setDedication_Total(rs.getString(41));
					voiceMISEntity.setNo_of_Voting_SMS(rs.getString(42));
					voiceMISEntity.setUnique_Users_Recorded_Songs(rs.getString(43));
					voiceMISEntity.setTotal_Daily_Pack_Revenue(rs.getString(44));
					voiceMISEntity.setTotal_Weekly_Pack_Revenue(rs.getString(45));
					voiceMISEntity.setTotal_Monthly_Pack_Revenue(rs.getString(46));
					voiceMISEntity.setTotal_Yearly_Pack_Revenue(rs.getString(47));
					voiceMISEntity.setGross_Revenue_in_XAF(rs.getString(48));
					voiceMISEntity.setGross_Revenue_in_USD(rs.getString(49));
					voiceMISEntity.setActive_Subscribers_in_the_System(rs.getString(50));
					voiceMISEntity.setBilled_Subscribers(rs.getString(51));
					voiceMISEntity.setCalling_Subscribers(rs.getString(52));
					voiceMISEntity.setAverage_Subscriber_Call_Unique_Caller(rs.getString(53));
					voiceMISEntity.setAverage_Subscriber_MOU_Unique_Caller(rs.getString(54));
					voiceMISEntity.setAverage_Subscriber_MOU_Calls(rs.getString(55));
					voiceMISEntity.setAverage_Dedication_Unique_Caller(rs.getString(56));
					voiceMISEntity.setUnique_Caller_Active_Subscribers_in_the_System(rs.getString(57));
					voiceMISEntity.setService_Penetration(rs.getString(58));
					voiceMISEntity.setARPU(rs.getString(59));
					voiceMISEntity.setSubscribers_moved_from_Active_to_Grace(rs.getString(60));
					voiceMISEntity.setSubscribers_moved_from_Grace_to_Active(rs.getString(61));
					voiceMISEntity.setSubscribers_in_1_7_days_Grace_with_service(rs.getString(62));
					voiceMISEntity.setSubscribers_in_8_14_days_retry(rs.getString(63));
					voiceMISEntity.setSubscribers_in_15_21_Days_retry(rs.getString(64));
					voiceMISEntity.setSubscribers_in_22_30_days_retry(rs.getString(65));
					voiceMISEntity.setMins0_1(rs.getString(66));
					voiceMISEntity.setMins1_2(rs.getString(67));
					voiceMISEntity.setMins2_3(rs.getString(68));
					voiceMISEntity.setMins3_4(rs.getString(69));
					voiceMISEntity.setMins4_5(rs.getString(70));
					voiceMISEntity.setMins5_6(rs.getString(71));
					voiceMISEntity.setMins6_7(rs.getString(72));
					voiceMISEntity.setMins7_8(rs.getString(73));
					voiceMISEntity.setMins8_9(rs.getString(74));
					voiceMISEntity.setMins9_10(rs.getString(75));
					voiceMISEntity.setMins10_Above(rs.getString(76));
					list.add(voiceMISEntity);
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
		return list;

	}

}
