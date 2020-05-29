package com.digispice.cci.zambia.serviceImpl;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digispice.cci.zambia.connection.GetConnection;
import com.digispice.cci.zambia.dao.LoginDao;
import com.digispice.cci.zambia.entity.BeatsUserStatusBean;
import com.digispice.cci.zambia.entity.BundleBean;
import com.digispice.cci.zambia.entity.KaraokeBean;
import com.digispice.cci.zambia.entity.MusicBean;
import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.ZamtelBeatsBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;
import com.digispice.cci.zambia.service.ZamtelBeatsService;

@Service
@Transactional
public class ZamtelBeatsServiceImpl implements ZamtelBeatsService {

	public static final Logger logger = LoggerFactory.getLogger(ZamtelBeatsServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Autowired
	BeatsUserStatusBean beatsUserStatusBean;

	@Autowired
	MusicBean musicBean;

	@Autowired
	BundleBean bundleBean;

	@Autowired
	KaraokeBean karaokeBean;

	HttpURLConnection httpCon = null;
	OutputStream os = null;
	BufferedReader br = null;
	JSONParser jSONParser = new JSONParser();

	@Override
	public UserEntity checkLoginBeats(String userName, String password) {
		return loginDao.checkLogin(userName, password);
	}

	@Override
	public BeatsUserStatusBean checkUserDetailsBeats(String ani) {
		try {
			String checkUserDetailAPI = GetConnection.loadProp("zamtel.beats.checkUserAPI");
			logger.info("API for Zemtal Games Check User is {}", checkUserDetailAPI);
			String jsonInputString = "{\"mobileNumber\":\"" + ani + "\"}";
			String strResponseData = hitConnection(checkUserDetailAPI, jsonInputString);
			logger.info("Response from API :-  {} is {}", checkUserDetailAPI, strResponseData);

			JSONObject jsonObject = (JSONObject) jSONParser.parse(strResponseData);
			beatsUserStatusBean.setCode((String) jsonObject.get("code"));
			beatsUserStatusBean.setMessage((String) jsonObject.get("message"));
			beatsUserStatusBean.setPopUpmessage((String) jsonObject.get("popUpmessage"));

			Map musicBeanMap = (Map) (jsonObject.get("musicBean"));

			if (((String) musicBeanMap.get("packageId")) != null || !((String) musicBeanMap.get("packageId")).isEmpty())
				musicBean.setPackageId((String) musicBeanMap.get("packageId"));
			else
				musicBean.setPackageId("-");

			if (((String) musicBeanMap.get("packageName")) != null || ((String) musicBeanMap.get("packageName")) != "")
				musicBean.setPackageName((String) musicBeanMap.get("packageName"));
			else
				musicBean.setPackageName("-");

			if (((String) musicBeanMap.get("packagePrice")) != null
					|| ((String) musicBeanMap.get("packagePrice")) != "")
				musicBean.setPackagePrice((String) musicBeanMap.get("packagePrice"));
			else
				musicBean.setPackagePrice("-");

			if (((String) musicBeanMap.get("msisdn")) != null || ((String) musicBeanMap.get("msisdn")) != "")
				musicBean.setMsisdn((String) musicBeanMap.get("msisdn"));
			else
				musicBean.setMsisdn("-");

			if (((String) musicBeanMap.get("package_sub_date")) != null
					|| ((String) musicBeanMap.get("package_sub_date")) != "")
				musicBean.setpackageSubDate((String) musicBeanMap.get("package_sub_date"));
			else
				musicBean.setpackageSubDate("-");

			if (((String) musicBeanMap.get("package_renew_date")) != null
					|| ((String) musicBeanMap.get("package_renew_date")) != "")
				musicBean.setpackageRenewDate((String) musicBeanMap.get("package_renew_date"));
			else
				musicBean.setpackageRenewDate("-");

			if (((String) musicBeanMap.get("package_billing_date")) != null
					|| ((String) musicBeanMap.get("package_billing_date")) != "")
				musicBean.setpackageBillingDate((String) musicBeanMap.get("package_billing_date"));
			else
				musicBean.setpackageBillingDate("-");

			if (((String) musicBeanMap.get("status")) != null || ((String) musicBeanMap.get("status")) != "")
				musicBean.setStatus((String) musicBeanMap.get("status"));
			else
				musicBean.setStatus("-");

			if (musicBean.getPackageName().equalsIgnoreCase("MUSIC_SUB1"))
				musicBean.setPackageName("MUSIC_MONTHLY");
			else if (musicBean.getPackageName().equalsIgnoreCase("MUSIC_SUB2"))
				musicBean.setPackageName("MUSIC_WEEKLY");
			else if (musicBean.getPackageName().equalsIgnoreCase("MUSIC_SUB3"))
				musicBean.setPackageName("MUSIC_DAILY");

			beatsUserStatusBean.setMusicBean(musicBean);

			Map krkBeanMap = (Map) (jsonObject.get("krkBean"));

			if (((String) krkBeanMap.get("packageId")) != null || ((String) krkBeanMap.get("packageId")) != "")
				karaokeBean.setPackageId((String) krkBeanMap.get("packageId"));
			else
				karaokeBean.setPackageId("-");

			if (((String) krkBeanMap.get("packageName")) != null || ((String) krkBeanMap.get("packageName")) != "")
				karaokeBean.setPackageName((String) krkBeanMap.get("packageName"));
			else
				karaokeBean.setPackageName("-");

			if (((String) krkBeanMap.get("packagePrice")) != null || ((String) krkBeanMap.get("packagePrice")) != "")
				karaokeBean.setPackagePrice((String) krkBeanMap.get("packagePrice"));
			else
				karaokeBean.setPackagePrice("-");

			if (((String) krkBeanMap.get("msisdn")) != null || ((String) krkBeanMap.get("msisdn")) != "")
				karaokeBean.setMsisdn((String) krkBeanMap.get("msisdn"));
			else
				karaokeBean.setMsisdn("-");

			if (((String) krkBeanMap.get("package_sub_date")) != null
					|| ((String) krkBeanMap.get("package_sub_date")) != "")
				karaokeBean.setpackageSubDate((String) krkBeanMap.get("package_sub_date"));
			else
				karaokeBean.setpackageSubDate("-");

			if (((String) krkBeanMap.get("package_renew_date")) != null
					|| ((String) krkBeanMap.get("package_renew_date")) != "")
				karaokeBean.setpackageRenewDate((String) krkBeanMap.get("package_renew_date"));
			else
				karaokeBean.setpackageRenewDate("-");

			if (((String) krkBeanMap.get("package_billing_date")) != null
					|| ((String) krkBeanMap.get("package_billing_date")) != "")
				karaokeBean.setpackageBillingDate((String) krkBeanMap.get("package_billing_date"));
			else
				karaokeBean.setpackageBillingDate("-");

			if (((String) krkBeanMap.get("status")) != null || ((String) krkBeanMap.get("status")) != "")
				karaokeBean.setStatus((String) krkBeanMap.get("status"));
			else
				karaokeBean.setStatus("-");

			if (karaokeBean.getPackageName().equalsIgnoreCase("KRK_SUB1"))
				karaokeBean.setPackageName("KARAOKE_MONTHLY");
			else if (karaokeBean.getPackageName().equalsIgnoreCase("KRK_SUB2"))
				karaokeBean.setPackageName("KARAOKE_WEEKLY");
			else if (karaokeBean.getPackageName().equalsIgnoreCase("KRK_SUB3"))
				karaokeBean.setPackageName("KARAOKE_DAILY");

			beatsUserStatusBean.setKaraokeBean(karaokeBean);

			Map bundleBeanMap = (Map) (jsonObject.get("bundleBean"));

			if (((String) bundleBeanMap.get("packageId")) != null || ((String) bundleBeanMap.get("packageId")) != "")
				bundleBean.setPackageId((String) bundleBeanMap.get("packageId"));
			else
				bundleBean.setPackageId("-");

			if (((String) bundleBeanMap.get("packageName")) != null
					|| ((String) bundleBeanMap.get("packageName")) != "")
				bundleBean.setPackageName((String) bundleBeanMap.get("packageName"));
			else
				bundleBean.setPackageName("-");

			if (((String) bundleBeanMap.get("packagePrice")) != null
					|| ((String) bundleBeanMap.get("packagePrice")) != "")
				bundleBean.setPackagePrice((String) bundleBeanMap.get("packagePrice"));
			else
				bundleBean.setPackagePrice("-");

			if (((String) bundleBeanMap.get("msisdn")) != null || ((String) bundleBeanMap.get("msisdn")) != "")
				bundleBean.setMsisdn((String) bundleBeanMap.get("msisdn"));
			else
				bundleBean.setMsisdn("-");

			if (((String) bundleBeanMap.get("package_sub_date")) != null
					|| ((String) bundleBeanMap.get("package_sub_date")) != "")
				bundleBean.setpackageSubDate((String) bundleBeanMap.get("package_sub_date"));
			else
				bundleBean.setpackageSubDate("-");

			if (((String) bundleBeanMap.get("package_renew_date")) != null
					|| ((String) bundleBeanMap.get("package_renew_date")) != "")
				bundleBean.setpackageRenewDate((String) bundleBeanMap.get("package_renew_date"));
			else
				bundleBean.setpackageRenewDate("-");

			if (((String) bundleBeanMap.get("package_billing_date")) != null
					|| ((String) bundleBeanMap.get("package_billing_date")) != "")
				bundleBean.setpackageBillingDate((String) bundleBeanMap.get("package_billing_date"));
			else
				bundleBean.setpackageBillingDate("-");

			if (((String) bundleBeanMap.get("status")) != null || ((String) bundleBeanMap.get("status")) != "")
				bundleBean.setStatus((String) bundleBeanMap.get("status"));
			else
				bundleBean.setStatus("-");

			if (bundleBean.getPackageName().equalsIgnoreCase("BUNDLE_SUB1"))
				bundleBean.setPackageName("BUNDLE_MONTHLY");

			else if (bundleBean.getPackageName().equalsIgnoreCase("BUNDLE_SUB2"))
				bundleBean.setPackageName("BUNDLE_WEEKLY");

			else if (bundleBean.getPackageName().equalsIgnoreCase("BUNDLE_SUB3"))
				bundleBean.setPackageName("BUNDLE_DAILY");

			beatsUserStatusBean.setBundleBean(bundleBean);

			System.out.println(beatsUserStatusBean.toString());

		} catch (Exception e) {
			logger.info("Exception Occured getting Zamtel Games {}", e);
		}

		return beatsUserStatusBean;
	}

	@Override
	public String singleSubscriptionBeats(String ani, String packType) {
		String response = "";
		try {
			String checkSingleSubAPI = GetConnection.loadProp("zamtel.beats.singleSub");
			logger.info("API for Zemtal Games Single Subscription is {}", checkSingleSubAPI);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String sDate = sdf.format(date);
			logger.info("Current Time Stamp is {}", sDate);

			String jsonInputString = "{\"mobileNumber\":\"" + ani + "\",\"packType\":\"" + packType
					+ "\",\"actSource\":\"CCI\",\"transId\":\"" + sDate + "\",\"clickID\":\"0\",\"vendorID\":\"0\"}";
			logger.info("Json Input String {}", jsonInputString);
			String strResponseData = hitConnection(checkSingleSubAPI, jsonInputString);
			logger.info("Response from API :-  {} is {}", checkSingleSubAPI, strResponseData);

			JSONObject jsonObject = (JSONObject) jSONParser.parse(strResponseData);
			if (((String) jsonObject.get("message")).equalsIgnoreCase("SUBSCRIBED"))
				response = "We have initiated your subscription request. You will get confirmation SMS Shortly.";
			else if (((String) jsonObject.get("message")).equalsIgnoreCase("CANT_SUBSCRIBE_AGAIN_WITHIN_24H"))
				response = "Can't Subscribe Again within 24 Hours.";
			else
				response = "User not Subscribe Successfully";

		} catch (Exception e) {
			logger.info("Exception Occured During Zemtal Games Single Subscription");
		}

		return response;
	}

	@Override
	public String singleUnSubscriptionBeats(String ani) {
		String response = "";
		try {
			String checkSingleUnSubAPI = GetConnection.loadProp("zamtel.beats.singleUnSub");
			logger.info("API for Zemtal Games Single UnSubscription is {}", checkSingleUnSubAPI);
			String packType = "GAMES_SUB1";
			String jsonInputString = "{\"mobileNumber\":\"" + ani + "\",\"packType\":\"" + packType
					+ "\",\"actSource\":\"CCI\"}";
			logger.info("Json Input String {}", jsonInputString);
			String strResponseData = hitConnection(checkSingleUnSubAPI, jsonInputString);
			logger.info("Response from API :-  {} is {}", checkSingleUnSubAPI, strResponseData);

			JSONObject jsonObject = (JSONObject) jSONParser.parse(strResponseData);
			if (((String) jsonObject.get("message")).equalsIgnoreCase("SUCCESSFULLY_UNSUB"))
				response = "This user will move out from DND after 90 days.";
			if (((String) jsonObject.get("message")).equalsIgnoreCase("ALREADY_UNSUB"))
				response = "We have already initiated your UnSubscription request.";
			else
				response = "User not UnSubscribe Successfully";

		} catch (Exception e) {
			logger.info("Exception Occured During Zemtal Games Single UnSubscription");
		}

		return response;
	}

	@Override
	public String zamtelBeatsBulkSub(String destPath, String pricePoint) {
		BufferedReader bf = null;
		String line = null;
		String response = "";

		try {
			bf = new BufferedReader(new FileReader(new File(destPath)));
			while ((line = bf.readLine()) != null) {
				boolean isNO = true;
				try {
					Integer.parseInt(line);
				} catch (Exception er) {
					logger.info("Given Line is not in Number Format {}", line);
					isNO = false;
				}
				if (line.length() == 9 && isNO) {

					String checkSingleSubAPI = GetConnection.loadProp("zamtel.beats.singleSub");
					logger.info("API for Zemtal Games Single Subscription is {}", checkSingleSubAPI);
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String sDate = sdf.format(date);
					logger.info("Current Time Stamp is {}", sDate);

					String jsonInputString = "{\"mobileNumber\":\"" + line.trim() + "\",\"packType\":\"" + pricePoint
							+ "\",\"actSource\":\"CCI\",\"transId\":\"" + sDate
							+ "\",\"clickID\":\"0\",\"vendorID\":\"0\"}";
					logger.info("Json Input String {}", jsonInputString);
					String strResponseData = hitConnection(checkSingleSubAPI, jsonInputString);
					logger.info("Response from API :-  {} is {}", checkSingleSubAPI, strResponseData);

					JSONObject jsonObject = (JSONObject) jSONParser.parse(strResponseData);
					if (((String) jsonObject.get("message")).equalsIgnoreCase("SUBSCRIBED"))
						response = "We have initiated your subscription request. You will get confirmation SMS Shortly.";
					else if (((String) jsonObject.get("message")).equalsIgnoreCase("CANT_SUBSCRIBE_AGAIN_WITHIN_24H"))
						response = "Can't Subscribe Again within 24 Hours.";
					else
						response = "User not Subscribe Successfully";
				}

				else {
					logger.info("{} Length of Number is not equal to 9", line);
				}

				response = "Bulk Uploaded Successfully";
			}
		} catch (Exception e) {
			logger.info("Exception Occured in Bulk Sub {}", e);
			response = "Something went Wrong!! Contact to your Administrator";
		}

		return response;
	}

	
	public String hitConnection(String checkUserDetailAPI, String jsonInputString) {
		String strResponseData = "";
		try {
			URL url = new URL(checkUserDetailAPI);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type", "application/json; utf-8");
			httpCon.setRequestProperty("Accept", "application/json");
			httpCon.setDoInput(true);
			httpCon.setDoOutput(true);

			os = httpCon.getOutputStream();

			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);

			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			strResponseData = response.toString();
		} catch (Exception e) {
			logger.info("Exception Occured {}", e);
		}

		return strResponseData;
	}

	@Override
	public List<ZamtelBeatsBillingHistory> beatsBillingDetails(String ani) {
		return loginDao.beatsBillingDetails(ani);
	}
	
	
	@Override
	public List<ZamtelBeatsMISEntity> getzamtelBeatsMIS(String fromDate,String toDate)
	{
		Date date = new Date();
		Date date2 = new Date();
		
		System.out.println("fromd date is "+fromDate +" and end date is toDate");
		
		try
		{	toDate = toDate.concat(" 23:59:59");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			date = df.parse(fromDate);
			date2 = df1.parse(toDate);
			
			return loginDao.getzamtelBeatsMIS(date, date2);
		}
		catch (Exception e) {
			logger.info("exception occured while converting date String into Date Object {}",e);
			e.printStackTrace();
		}
		
		return null;
		
	}

}
