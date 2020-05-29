package com.digispice.cci.zambia.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digispice.cci.zambia.connection.EntityConnection;
import com.digispice.cci.zambia.dao.LoginDao;
import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.ZamtelBeatsBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelGamesBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	HttpSession session;

	@PersistenceContext
	EntityManager em;

	UserEntity userEntity = null;

	private static final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class.getName());

	@Override
	public UserEntity checkLogin(String userName, String password) {
		try {
			TypedQuery<UserEntity> typedQuery = em
					.createQuery("from UserEntity where userName=:name and password=:password", UserEntity.class);
			typedQuery.setParameter("name", userName);
			typedQuery.setParameter("password", password);

			userEntity = typedQuery.getSingleResult();
		} catch (Exception e) {
			logger.info("Exception Occured in Login {}", e);
			userEntity = null;
		}

		logger.info("User Entity in DAO {}", userEntity);
		return userEntity;
	}

	@Override
	public List<ZamtelGamesBillingHistory> gamesBillingDetails(String ani) {
		List<ZamtelGamesBillingHistory> beanList = new ArrayList<ZamtelGamesBillingHistory>();
		try {
			String query = "select TID,ANI,STATUS,SUB_DATE,RENEW_DATE,BILLING_DATE,PRE_POST,"
					+ "AMT_DEDUCTED,PACK_TYPE,ACT_SOURCE,SERVICE_TYPE,VENDOR_NAME,CLICK_ID from tbl_games_billing_history "
					+ "where ANI='" + ani + "' order by BILLING_DATE ASC";
			logger.info("Query is {}", query);
			List<Object[]> list = em.createNativeQuery(query).getResultList();

			for (Object[] o : list) {
				ZamtelGamesBillingHistory bean = new ZamtelGamesBillingHistory();
				bean.setTid(String.valueOf(o[0]));
				bean.setAni(String.valueOf(o[1]));
				bean.setStatus(String.valueOf(o[2]));
				bean.setSubDate(String.valueOf(o[3]));
				bean.setRenewDate(String.valueOf(o[4]));
				bean.setBillingDate(String.valueOf(o[5]));
				bean.setPrePost(String.valueOf(o[6]));
				bean.setAmtDeducted(String.valueOf(o[7]));
				bean.setPackType(String.valueOf(o[8]));
				bean.setActSource(String.valueOf(o[9]));
				bean.setServiceType(String.valueOf(o[10]));
				bean.setVendorName(String.valueOf(o[11]));
				bean.setClickId(String.valueOf(o[12]));

				if (bean.getPackType().equalsIgnoreCase("GAMES_SUB1"))
					bean.setPackType("Games_Monthly");
				else if (bean.getPackType().equalsIgnoreCase("GAMES_SUB2"))
					bean.setPackType("Games_Weekly");
				else if (bean.getPackType().equalsIgnoreCase("GAMES_SUB3"))
					bean.setPackType("Games_Daily");

				beanList.add(bean);
			}

		} catch (Exception e) {
			logger.info("Exception Occured from getting Billing History of Zemta Games {}", e);

		}

		return beanList;
	}

	@Override
	public List<ZamtelBeatsBillingHistory> beatsBillingDetails(String ani) {
		List<ZamtelBeatsBillingHistory> beanList = new ArrayList<ZamtelBeatsBillingHistory>();
		try {
			String query = "select TID,ANI,STATUS,SUB_DATE,RENEW_DATE,BILLING_DATE,PRE_POST,"
					+ "AMT_DEDUCTED,PACK_TYPE,ACT_SOURCE,SERVICE_TYPE,VENDOR_NAME,CLICK_ID from tbl_mapp_billing_history"
					+ " where ANI='" + ani + "' order by BILLING_DATE ASC";
			logger.info("Query is {}", query);
			EntityConnection c = new EntityConnection();
			EntityManager em2 = c.getBeatsEntityManager().createEntityManager();
			List<Object[]> list = em2.createNativeQuery(query).getResultList();
			
			for (Object[] o : list) {
				ZamtelBeatsBillingHistory bean = new ZamtelBeatsBillingHistory();
				bean.setTid(String.valueOf(o[0]));
				bean.setAni(String.valueOf(o[1]));
				bean.setStatus(String.valueOf(o[2]));
				bean.setSubDate(String.valueOf(o[3]));
				bean.setRenewDate(String.valueOf(o[4]));
				bean.setBillingDate(String.valueOf(o[5]));
				bean.setPrePost(String.valueOf(o[6]));
				bean.setAmtDeducted(String.valueOf(o[7]));
				bean.setPackType(String.valueOf(o[8]));
				bean.setActSource(String.valueOf(o[9]));
				bean.setServiceType(String.valueOf(o[10]));
				bean.setVendorName(String.valueOf(o[11]));
				bean.setClickId(String.valueOf(o[12]));

				if (bean.getPackType().equalsIgnoreCase("MUSIC_SUB1"))
					bean.setPackType("MUSIC_Monthly");
				else if (bean.getPackType().equalsIgnoreCase("MUSIC_SUB2"))
					bean.setPackType("MUSIC_Weekly");
				else if (bean.getPackType().equalsIgnoreCase("MUSIC_SUB3"))
					bean.setPackType("MUSIC_Daily");
				else if (bean.getPackType().equalsIgnoreCase("KRK_SUB1"))
					bean.setPackType("KARAOKE_Monthly");
				else if (bean.getPackType().equalsIgnoreCase("KRK_SUB2"))
					bean.setPackType("KARAOKE_Weekly");
				else if (bean.getPackType().equalsIgnoreCase("KRK_SUB3"))
					bean.setPackType("KARAOKE_Daily");
				else if (bean.getPackType().equalsIgnoreCase("BUNDLE_SUB1"))
					bean.setPackType("BUNDLE_Monthly");
				else if (bean.getPackType().equalsIgnoreCase("BUNDLE_SUB2"))
					bean.setPackType("BUNDLE_Weekly");
				else if (bean.getPackType().equalsIgnoreCase("BUNDLE_SUB3"))
					bean.setPackType("BUNDLE_Daily");

				beanList.add(bean);
			}

		} catch (Exception e) {
			logger.info("Exception Occured from getting Billing History of Zemta Games {}", e);

		}

		return beanList;
	}

	@Override
	public List<ZamtelGamesMISEntity> getzamtelGamesMIS(Date fromDate, Date toDate) {
		List<ZamtelGamesMISEntity> list = Collections.emptyList();
		try {

			logger.info("getting Zemtal Games MIS from date {} to {}", fromDate, toDate);
			TypedQuery<ZamtelGamesMISEntity> query = em.createQuery(
					"from ZamtelGamesMISEntity where date between :fromdate AND :todate order by date ASC",
					ZamtelGamesMISEntity.class);
			query.setParameter("fromdate", fromDate);
			query.setParameter("todate", toDate);
			list = query.getResultList();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (ZamtelGamesMISEntity e : list) {
				e.setsDate(sdf.format(e.getDate()));
			}
		} catch (Exception e) {
			logger.info("Exception occured in Zamtel Games MIS {}", e);
		}

		return list;
	}
	
	
	
	@Override
	public List<ZamtelBeatsMISEntity> getzamtelBeatsMIS(Date fromDate, Date toDate) {
		List<ZamtelBeatsMISEntity> list = Collections.emptyList();
		try {

			EntityConnection c = new EntityConnection();
			EntityManager em2 = c.getBeatsEntityManager().createEntityManager();
			
			logger.info("getting Zemtal Beats MIS from date {} to {}", fromDate, toDate);
			TypedQuery<ZamtelBeatsMISEntity> query = em2.createQuery(
					"from ZamtelBeatsMISEntity where DATETIME between :fromdate AND :todate order by DATETIME ASC",
					ZamtelBeatsMISEntity.class);
			query.setParameter("fromdate", fromDate);
			query.setParameter("todate", toDate);
			list = query.getResultList();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (ZamtelBeatsMISEntity e : list) {
				e.setsDate(sdf.format(e.getDATETIME()));
			}
		} catch (Exception e) {
			logger.info("Exception occured in Zamtel Beats MIS {}", e);
		}

		return list;
	}

}
