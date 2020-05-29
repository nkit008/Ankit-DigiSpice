<%@page import="com.sun.xml.internal.ws.api.message.Attachment"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.addHeader("content-disposition", "attachment; filename=AwccShyarai_MIS.xls");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: arial; font-size: 12px;">

	<div
		style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
	<table border="1" cellpadding="0" cellspacing="0"
										bgcolor="#FFFFFF" align="center" width="1200"
										style="padding-bottom: 0px">
						<tr>
					<td colspan="${sessionScope['mapdataLength']}" style="text-align: center;font-weight:bold;">Shayari Revenue MIS</td>
					</tr>
										<tr>
											<td colspan="3"><font color="BLACK"></font></td>
										</tr>
										<tr>
											<!-- <td style="width: 300px;" ><font color="red">LUCKY DRAW</font></td> -->
											<td width="136"><font color="red">Date</font></td>
											<td width="300" style="width: 300px;"><font color="red">KPI</font></td>

										<c:forEach var="map" items="${sessionScope['mapdata']}">
												<td valign="top"><table width="100%" border="1"
														cellpadding="0" cellspacing="0">
												<tr>
													<td>${map['date_time']}</td>
												</tr>
											</table></td>
											</c:forEach>
										</tr>
			<tr>
				<td style="width: 300px;text-align: center;vertical-align: middle;"><font color="red">Calls</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Total Calls</td>
						</tr>
						<tr>
							<td>Total Live Calls</td>
						</tr>
						<tr>
							<td>Total Non-Live Calls</td>
						</tr>	
						<tr>
							<td>Total MOUs</td>
						</tr>	
						<tr>
							<td>Total MOUs Live Calls</td>
						</tr>
						<tr>
							<td>Total MOUs Non-Live Calls</td>
						</tr>
						<tr>
							<td>Unique Users MTD</td>
						</tr>
						<tr>
							<td>Unique Live Users</td>
						</tr>
						<tr>
							<td>Unique Non-Live Users</td>
						</tr>
						<tr>
							<td>Unique Live Users MTD</td>
						</tr>
						</table>
						</td>
						
						<c:forEach var="map" items="${sessionScope['mapdata']}">
						<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
							<tr>	
								<td>${map['ivr_totalCalls']}</td>
							</tr>
							<tr>
								<td>${map['ivr_calls_Live_Callers']}</td>
							</tr>
							<tr>
								<td>${map['ivr_calls_NonLive_Callers']}</td>
							</tr>
							<tr>
								<td>${map['ivr_total_MOU']}</td>
							</tr>							
							<tr>
								<td>${map['ivr_mou_Live_Callers']}</td>
							</tr>
							<tr>
								<td>${map['ivr_mou_NonLive_Callers']}</td>
							</tr>							
							<tr>
								<td>${map['ivr_unique_Users_mtd']}</td>
							</tr>							
							<tr>
								<td>${map['ivr_unique_Live_Users']}</td>
							</tr>
							<tr>
								<td>${map['ivr_unique_NonLive_Users']}</td>
							</tr>
							<tr>
								<td>${map['ivr_total_Unique_Users']}</td>
							</tr>
							</table>
							</td>
							</c:forEach>
							</tr>
																												
			
			<! -- ============================================================================= -->
			<tr>
				<td id="2" style="text-align: center;vertical-align: middle;" rowspan="5"><font color="red">Subscribers</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">IVR</td>
						</tr>
						<tr>
							<td>Count of Single Consent users</td>
						</tr>
						<tr>
							<td>Subscription requests for Daily @2 AFN</td>
						</tr>						
						<tr>
							<td>Subscription requests for Monthly @30 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions for Daily @2  AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions for Monthly @30 AFN</td>
						</tr>
						</table>
						</td>
						<c:forEach var="map" items="${sessionScope['mapdata']}">
						<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
							</tr>
							
							<tr>
								<td>${map['ISingle_Consent_User']}</td>
							</tr>
							<tr>
								<td>${map['ISubscription_Requests_2_AFN']}</td>
							</tr>																																							
								
							<tr>
								<td>${map['ISubscription_Requests_30_AFN']}</td>
							</tr>
							<tr>
								<td>${map['ISuccessful_Subscriptions_2_AFN']}</td>
							</tr>
							<tr>
								<td>${map['ISuccessful_Subscriptions_30_AFN']}</td>
							</tr>
							</table>
							</td>
							</c:forEach>																						
						</tr>
						<tr>
						<td>
							<table border="1" cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td style="text-align: center;vertical-align: middle;background-color: green;color: #ffffff;font-weight: bold;">SMS</td>
							</tr>
							<tr>
								<td>Count of Single Consent users</td>
							</tr>
							<tr>
								<td>Subscription requests for Daily @2AFN</td>
							</tr>
							<tr>
								<td>Subscription requests for Monthly @30 AFN</td>
							</tr>
							<tr>
								<td>Successful Subscriptions for Daily @2 AFN</td>
							</tr>
							<tr>
								<td>Successful Subscriptions for Monthly @30 AFN</td>
							</tr>
							</table>
							</td>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>
								<tr>
									<td>${map['SSingle_Consent_User']}</td>
								</tr>
								<tr>
									<td>${map['SSubscription_Requests_2_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['SSubscription_Requests_30_AFN']}</td>
								</tr>
								<tr>
									<td>${map['SSuccessful_Subscriptions_2_AFN']}</td>
								</tr>
								<tr>
									<td>${map['SSuccessful_Subscriptions_30_AFN']}</td>
								</tr>
								</table>
								</td>
								</c:forEach>
								</tr>
								<tr>
								<td>
								<table border="1" cellpadding="0" cellspacing="0" width="300">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">CCI</td>
								</tr>
								<tr>
									<td>Subscription requests for Daily @2  AFN</td>
								</tr>
								<tr>
									<td>Subscription requests for Monthly @30 AFN</td>
								</tr>
								<tr>
									<td>Successful Subscriptions for Daily @2 AFN</td>
								</tr>
								<tr>
									<td>Successful Subscriptions for Monthly @30 AFN</td>
								</tr>
								<tr>
									<td>Total Gross Adds</td>
								</tr>
								</table>
								</td>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>
								<tr>
									<td>${map['CSubscription_Requests_2_AFN'] }</td>
							
								</tr>
								<tr>
									<td>${map['CSubscription_Requests_30_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['CSuccessful_Subscriptions_2_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['CSuccessful_Subscriptions_30_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['Total_Gross_Adds'] }</td>
								</tr>
								</table>
								</td>
							</c:forEach>
							</tr>
							<tr>
								<td>
								<table border="1" cellpadding="0" cellspacing="0" width="300">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">Renewal</td>
								</tr>
								<tr>
									<td>Renewal for Daily @2AFN</td>
								</tr>
								<tr>
									<td>Renewal for Monthly @30 AFN</td>
								</tr>
								<tr>
									<td>Total Renewal</td>
								</tr>
								</table>
								</td>																								
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>
								<tr>
									<td>${map['Renewal_Successful_2_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['Renewal_Successful_30_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['Total_Renewal_Successful'] }</td>
								</tr>
						</table>
						</td>
						</c:forEach>
						</tr>
							<tr>
								<td>
								<table border="1" cellpadding="0" cellspacing="0" width="300">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">CHURN</td>
								</tr>
								<tr>
									<td>IVR</td>
								</tr>
								<tr>
									<td>SMS</td>
								</tr>
								<tr>
									<td>CCI</td>
								</tr>
								<tr>
									<td>Others</td>
								</tr>
								<tr>
									<td>Involuntary Churn</td>
								</tr>
								<tr>
									<td>Voluntary Churn</td>
								</tr>
								<tr>
									<td>Total Churn</td>
								</tr>
								</table>
								</td>
																																																																
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>
								<tr>
									<td>${map['ivr']}</td>
								</tr>
								<tr>
									<td>${map['sms']}</td>
								</tr>
								<tr>
									<td>${map['cci']}</td>
								</tr>
								<tr>
									<td>${map['others']}</td>
								</tr>
								<tr>
									<td>${map['involuntary_churn']}</td>
								</tr>
								<tr>
									<td>${map['voluntary_Churn']}</td>
								</tr>
								<tr>
									<td>${map['total_churn']}</td>
								</tr>
								</table>
								</td>
							</c:forEach>
						</tr>
						<tr>
						<td id="2" style="text-align: center;vertical-align: middle;"><font color="red">Subscribers Base</font></td>	
						<td>
						<table border="1" cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td>Net Additions</td>
							</tr>
							<tr>
								<td>Active Base</td>
							</tr>
							<tr>
								<td>Grace Base</td>
							</tr>
							<tr>
								<td>Retry Base</td>
							</tr>
							<tr>
								<td>Total Base</td>
							</tr>
							</table>
							</td>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
							<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td>${map['net_Additions'] }</td>
								</tr>
								<tr>
									<td>${map['active_Base'] }</td>
								</tr>
								<tr>
									<td>${map['grace_Base'] }</td>
								</tr>																
								<tr>
									<td>${map['retry_base'] }</td>
								</tr>
								<tr>
									<td>${map['total_base'] }</td>
								</tr>
								</table>
								</td>
								</c:forEach>
								</tr>
						<tr>
						<td id="2" style="text-align: center;vertical-align: middle;"><font color="red">Content Delivery</font></td>	
						<td>
						<table border="1" cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td>No. of SMS sent Daily</td>
							</tr>
							<tr>
								<td>No. of SMS delivered Daily</td>
							</tr>
						</table>
						</td>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td>${map['sms_sent_daily'] }</td>
								</tr>
								<tr>
									<td>${map['sms_delivered_daily']}</td>
								</tr>
								</table>
								</td>
							</c:forEach>
						</tr>
						
					<tr>
						<td id="2" style="text-align: center;vertical-align: middle;"><font color="red">Revenue</font></td>	
						<td>
						<table border="1" cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td>Total Subcription Revenue</td>
							</tr>
							<tr>
								<td>Subscription Revenue for daily @2 AFN</td>
							</tr>
							<tr>
								<td>Subscription Revenue for monthly @30 AFN</td>
							</tr>
							<tr>
								<td>Total Resubscription Revenue</td>
							</tr>
							<tr>
								<td>Resub Revenue for Daily @2 AFN</td>
							</tr>
							<tr>
								<td>Resub Revenue for Monthly @30 AFN</td>
							</tr>
							<tr>
								<td>GRAND TOTAL</td>
							</tr>
							</table>
							</td>																					
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
							<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td>${map['Total_Subscription_Revenue'] }</td>
								</tr>
								<tr>
									<td>${map['Subscription_Revenue_2_AFN']}</td>
								</tr>
								<tr>
									<td>${map['Subscription_Revenue_30_AFN'] }</td>
								</tr>
								<tr>
									<td>${map['Total_Renewal_Revenue'] }</td>
								</tr>
								<tr>
									<td>${map['Renewal_Revenue_2_AFN']}</td>
								</tr>
								<tr>
									<td>${map['Renewal_Revenue_30_AFN']}</td>
								</tr>
								<tr>
									<td>${map['grand_total']}</td>
								</tr>
								</table>
								</td>
							</c:forEach>
						</tr>
						<tr>
						<td id="2" style="text-align: center;vertical-align: middle;"><font color="red">MOU'S Split</font></td>	
						<td>
						<table border="1" cellpadding="0" cellspacing="0" width="300">
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">101+ min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">51-100 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">30-50 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">15-30 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">5-15 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">2-5 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							<tr>
								<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">0-2 min</td>
							</tr>
							<tr>
								<td>Users</td>
							</tr>
							<tr>
								<td>Duration</td>
							</tr>
							</table>
							</td>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>
								<tr>
									<td>${map['mou_bucket101_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket101_Mins']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>								
								<tr>
									<td>${map['mou_bucket50_100_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket50_100_Mins']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>																
								<tr>
									<td>${map['mou_bucket30_50_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket30_50_Min']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>								
								<tr>
									<td>${map['mou_bucket15_30_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket15_30_Mins']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>								
								<tr>
									<td>${map['mou_bucket5_15_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket5_15_Mins']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>								
								<tr>
									<td>${map['mou_bucket2_5_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket2_5_Mins']}</td>
								</tr>
								<tr>
									<td style="text-align: center;background-color: green;color: #ffffff;font-weight: bold;">&#x00A0;</td>
								</tr>								
								<tr>
									<td>${map['mou_bucket0_2_User'] }</td>
								</tr>
								<tr>
									<td>${map['mou_bucket0_2_Mins']}</td>
								</tr>
								</table>
								</td>
								
							</c:forEach>
						</tr>
					</table>
					</div>
</body>
</html>