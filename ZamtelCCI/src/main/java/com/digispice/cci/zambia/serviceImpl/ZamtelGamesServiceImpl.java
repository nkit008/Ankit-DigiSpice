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

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digispice.cci.zambia.connection.GetConnection;
import com.digispice.cci.zambia.dao.LoginDao;
import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.entity.UserStatusBean;
import com.digispice.cci.zambia.entity.ZamtelGamesBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;
import com.digispice.cci.zambia.service.ZamtelGamesService;

@Service
@Transactional
public class ZamtelGamesServiceImpl implements ZamtelGamesService {

	public static final Logger logger = LoggerFactory.getLogger(ZamtelGamesServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Autowired
	UserStatusBean userStatusBean;

	HttpURLConnection httpCon = null;
	OutputStream os = null;
	BufferedReader br = null;

	@Override
	public UserEntity checkLogin(String userName, String password) {
		return loginDao.checkLogin(userName, password);
	}

	@Override
	public UserStatusBean checkUserDetails(String ani) {
		try {
			String checkUserDetailAPI = GetConnection.loadProp("zamtel.games.checkUserAPI");
			logger.info("API for Zemtal Games Check User is {}", checkUserDetailAPI);
			String jsonInputString = "{\"mobileNumber\":\"" + ani + "\"}";
			String strResponseData = hitConnection(checkUserDetailAPI, jsonInputString);
			logger.info("Response from API :-  {} is {}", checkUserDetailAPI, strResponseData);
			JSONObject jsonObject = new JSONObject(strResponseData);
			if (!jsonObject.isNull("mobilenumber"))
				userStatusBean.setMobileNumber(jsonObject.getString("mobilenumber"));
			else
				userStatusBean.setMobileNumber("-");

			if (!jsonObject.isNull("packType"))
				userStatusBean.setPackType(jsonObject.getString("packType"));
			else
				userStatusBean.setPackType("-");

			if (!jsonObject.isNull("quantity"))
				userStatusBean.setQuantity(jsonObject.getString("quantity"));
			else
				userStatusBean.setQuantity("-");

			if (!jsonObject.isNull("subDate"))
				userStatusBean.setSubDate(jsonObject.getString("subDate"));
			else
				userStatusBean.setSubDate("-");

			if (!jsonObject.isNull("lastBillingDate"))
				userStatusBean.setLastBillingDate(jsonObject.getString("lastBillingDate"));
			else
				userStatusBean.setLastBillingDate("-");

			if (!jsonObject.isNull("nextBillingDate"))
				userStatusBean.setNextBillingDate(jsonObject.getString("nextBillingDate"));
			else
				userStatusBean.setNextBillingDate("-");

			if (!jsonObject.isNull("actSource"))
				userStatusBean.setActSource(jsonObject.getString("actSource"));
			else
				userStatusBean.setActSource("-");

			if (!jsonObject.isNull("status"))
				userStatusBean.setStatus(jsonObject.getString("status"));
			else
				userStatusBean.setStatus("-");

			logger.info("userStatusBean is {}", userStatusBean.toString());

			if (userStatusBean.getPackType().equalsIgnoreCase("GAMES_SUB1"))
				userStatusBean.setPackType("Games_Monthly");
			else if (userStatusBean.getPackType().equalsIgnoreCase("GAMES_SUB2"))
				userStatusBean.setPackType("Games_Weekly");
			else if (userStatusBean.getPackType().equalsIgnoreCase("GAMES_SUB3"))
				userStatusBean.setPackType("Games_Daily");
		} catch (Exception e) {
			logger.info("Exception Occured getting Zamtel Games {}", e);
		}

		return userStatusBean;
	}

	@Override
	public String singleSubscription(String ani, String packType) {
		String response = "";
		try {
			String checkSingleSubAPI = GetConnection.loadProp("zamtel.games.singleSub");
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

			JSONObject jsonObject = new JSONObject(strResponseData);
			if (jsonObject.getString("message").equalsIgnoreCase("SUBSCRIBED"))
				response = "We have initiated your subscription request. You will get confirmation SMS Shortly.";
			else if (jsonObject.getString("message").equalsIgnoreCase("CANT_SUBSCRIBE_AGAIN_WITHIN_24H"))
				response = "Can't Subscribe Again within 24 Hours.";
			else
				response = "User not Subscribe Successfully";

		} catch (Exception e) {
			logger.info("Exception Occured During Zemtal Games Single Subscription");
		}

		return response;
	}

	@Override
	public String singleUnSubscription(String ani) {
		String response = "";
		try {
			String checkSingleUnSubAPI = GetConnection.loadProp("zamtel.games.singleUnSub");
			logger.info("API for Zemtal Games Single UnSubscription is {}", checkSingleUnSubAPI);
			String packType = "GAMES_SUB1";
			String jsonInputString = "{\"mobileNumber\":\"" + ani + "\",\"packType\":\"" + packType
					+ "\",\"actSource\":\"CCI\"}";
			logger.info("Json Input String {}", jsonInputString);
			String strResponseData = hitConnection(checkSingleUnSubAPI, jsonInputString);
			logger.info("Response from API :-  {} is {}", checkSingleUnSubAPI, strResponseData);

			JSONObject jsonObject = new JSONObject(strResponseData);
			logger.info("------- {}", jsonObject.getString("message"));
			if (jsonObject.getString("message").equalsIgnoreCase("SUCCESSFULLY_UNSUB"))
				response = "This user will move out from DND after 90 days.";
			else if (jsonObject.getString("message").equalsIgnoreCase("ALREADY_UNSUB"))
				response = "We have already initiated your UnSubscription request.";
			else
				response = "User not UnSubscribe Successfully";

		} catch (Exception e) {
			logger.info("Exception Occured During Zemtal Games Single UnSubscription");
		}

		return response;
	}

	@Override
	public String zamtelGamesBulkSub(String destPath, String pricePoint) {
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

					String checkSingleSubAPI = GetConnection.loadProp("zamtel.games.singleSub");
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

					JSONObject jsonObject = new JSONObject(strResponseData);
					if (jsonObject.getString("message").equalsIgnoreCase("SUBSCRIBED"))
						response = "We have initiated your subscription request. You will get confirmation SMS Shortly.";
					else if (jsonObject.getString("message").equalsIgnoreCase("CANT_SUBSCRIBE_AGAIN_WITHIN_24H"))
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
	public List<ZamtelGamesBillingHistory> gamesBillingDetails(String ani) {
		return loginDao.gamesBillingDetails(ani);
	}

	@Override
	public List<ZamtelGamesMISEntity> getzamtelGamesMIS(String fromDate, String toDate) {
		
		Date date = new Date();
		Date date2 = new Date();
		
		try
		{	toDate = toDate.concat(" 23:59:59");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			date = df.parse(fromDate);
			date2 = df1.parse(toDate);
			
			return loginDao.getzamtelGamesMIS(date, date2);
		}
		catch (Exception e) {
			logger.info("exception occured while converting date String into Date Object {}",e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}