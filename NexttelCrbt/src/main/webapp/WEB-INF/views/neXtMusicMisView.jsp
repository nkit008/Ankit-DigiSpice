<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>
</head>
<body style="font-family: 'Poppins', sans-serif;font-size:14px;">
			
					<table width="845" border="0" cellpadding="0" cellspacing="0"
						align="center">


						
						<tr>
							<td colspan="3" align="left" valign="top" class="mid">

								<div id="login-wrapper" style="width: 100%; margin-left: 12px;">
				<p style="background-color:#79797c;color:#fff;text-align:center;font-weight:bold;font-size: 18px;padding: 16px;">neXtMusic MIS</p>
	
									<div style="clear: both; padding-top: 42px;" align="center">
									<a href="reportxlsNextMusic" class="export">Export to Excel</a><img
										src="resources/mis/images/excel.jpg" style="padding-left: 7px;"
										align="absmiddle" />
										<button onclick="goBack()" style="float:right;margin-top: -10px;font-weight:bold;background-color:#f73b43;padding:12px;color:#fff;font-size:14px; ">Back</button>
								</div>
								
								</div>
							</td>
						</tr>
					</table>
				<div style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
								
		<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
			align="center" width="1200" style="padding-bottom: 0px">
			
			<tr style="background-color:#f73b43;color:#ffffff;">
			<th class="tg-c3ow" colspan="2">MIS</th>
			<th class="tg-c3ow">Description/Date</th>
		<c:forEach items="${reportdata}" var="data">
			<th>${data.date_time}</th>
	</c:forEach>
			
	</tr>

<tr>
    <th class="tg-c3ow" rowspan="12" style="background-color:#f73b43;">Music Scorer</th>
    <td class="tg-c3ow"  rowspan="3" style="text-align:center;">Calls</td>
    <td class="tg-0pky">Total Calls</td>
<c:forEach items="${reportdata}" var="data">
 					<c:choose>
				<c:when test="${empty data.total_calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_calls}</td>
				</c:otherwise>
			</c:choose>		
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Subscribed User Calls</td>
 <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.subscribed_user_calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_user_calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Non Subscribed User Calls</td>
    <c:forEach items="${reportdata}" var="data">
    		<c:choose>
				<c:when test="${empty data.non_subscribed_user_calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_subscribed_user_calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>		
			
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-c3ow" rowspan="3" style="text-align:center;background-color:#e5e3e3;">MOU</td>
    <td class="tg-0pky">Total MOU</td>
    <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_mou}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_mou}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribed User MOU</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.subscribed_user_mou}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_user_mou}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Non-Subscribed User MOU</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.non_subscribed_user_mou}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_subscribed_user_mou}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">Pulse (in Mins)</td>
    <td class="tg-0pky">Total Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribed_user_pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_user_pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non -Subscribed User Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.non_subscribed_user_pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_subscribed_user_pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-c3ow" rowspan="3" style="background-color:#e5e3e3;text-align:center;">Unique Callers</td>
    <td class="tg-0pky">Total Unique Callers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_unique_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_unique_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Unique subscribed callers</td>
<c:forEach items="${reportdata}" var="data">
		 			<c:choose>
				<c:when test="${empty data.unique_subscribed_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_subscribed_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Unique Non-Subscribed callers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unique_non_subscribed_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_non_subscribed_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr> 
  
  <tr>
    <th class="tg-0pky" rowspan="9" colspan="2">Subscriptions & Un-subscription</th>
    <td class="tg-0pky">Monthly Subscriptions (Requests Received)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_subscriptions_requests_rececived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_subscriptions_requests_rececived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly Subscriptions (Requests Rececived)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_subscriptions_requests_rececived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_subscriptions_requests_rececived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Daily Subscriptions (Requests Rececived)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_subscriptions_requests_rececived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_subscriptions_requests_rececived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Monthly Subscriptions (Successful)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_subscriptions_successfull}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_subscriptions_successfull}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Weekly Subscriptions (Successful)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_subscriptions_successfull}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_subscriptions_successfull}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Daily Subscriptions (Successful)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_subscriptions_successfull}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_subscriptions_successfull}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Voluntary Un-subscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.voluntary_unsubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.voluntary_unsubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">InVoluntary Un-subscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.involuntary_unsubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.involuntary_unsubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Gross Adds</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_adds}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_adds}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>  
  
  <tr style="background-color:#e5e3e3;">
    <th class="tg-c3ow" rowspan="3" colspan="2" style="background-color:#e5e3e3;text-align:center;">Re-Subscription/Renewals</th>
    <td class="tg-0pky">Re-Monthly Subscriptions</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.re_monthly_subscriptions}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.re_monthly_subscriptions}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Re-Weekly Subscriptions</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.re_weekly_subscriptions}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.re_weekly_subscriptions}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Re-Daily Subscriptions</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.re_daily_subscriptions}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.re_daily_subscriptions}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <th class="tg-0pky" rowspan="7" colspan="2">Mode of Subscription</th>
    <td class="tg-0pky">IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscription_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_ivr}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
  <tr>
    <td class="tg-0pky">CCI</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscription_cci}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_cci}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
<tr>
<td class="tg-0pky">OBD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscription_obd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_obd}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
<td class="tg-0pky">SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscription_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_sms}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
    <td class="tg-0pky">TNB</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.subscription_tnb}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_tnb}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
<td class="tg-0pky">USSD</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.subscription_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Others</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscription_others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscription_others}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
  </tr>

  <tr style="background-color:#e5e3e3;">
    <th class="tg-c3ow" rowspan="5" colspan="2" style="background-color:#e5e3e3;text-align:center;">Mode of Un-Subscription</th>
    <td class="tg-0pky">IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsubscription_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsubscription_ivr}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">CCI</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.unsubscription_cci}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsubscription_cci}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsubscription_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsubscription_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">APP</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsubscription_app}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsubscription_app}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Others</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsubscription_others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsubscription_others}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="2">Song Download</th>
    <td class="tg-0pky">Requested</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.requested_songs}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.requested_songs}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
</tr>
	<tr>
   <td class="tg-0pky">Successful Billed</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.successfull_billed_songs}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.successfull_billed_songs}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Browsing Revenue @0.0 per Pulse (in GHc)</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.browsing_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.browsing_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
   
 
 <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Monthly subscription Revnue @300 XAF per  month</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_subscription_revnue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_subscription_revnue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">weekly Subscription Revenue @ 150 XAF per week</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_subscription_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_subscription_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Daily Subscriptions Revenue @75  XAF  per  day</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_subscription_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_subscription_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr> 
 
 <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Song Download Revenue @150 XAF</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.song_download_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.song_download_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Gross Revenue (in XAF)</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
   
   
<tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="3">Gross Revenue (in USD) (1USD=580 XAF)</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_revenue_usd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_revenue_usd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>   
    
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Active Subscribers</th>
    <td class="tg-0pky">Active Subscribers in the System</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.system_active_subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.system_active_subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Billed Subscribers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.billed_subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.billed_subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Calling Subscribers (Subcribers who called within last 30 days)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.calling_subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.calling_subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="5" style="background-color:#e5e3e3;">AOS of Active Base</th>
    <td class="tg-0pky">0-10 Days</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.activeBase_0_10}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase_0_10}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
	
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">11-30 Days</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.activeBase_11_30}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase_11_30}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">31-60 Days</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.activeBase_31_60}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase_31_60}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
    <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">61-90 Days</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.activeBase_61_90}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase_61_90}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
    <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Above than 90 Day</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.activeBase_above90}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase_above90}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="10">Product KPI</th>
    <td class="tg-0pky">Average Non Subscriber Call/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_non_subscriber_call_per_unique_caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_non_subscriber_mou_per_unique_caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Average Non Subscriber MOU/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_non_subscriber_mou_per_unique_caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_non_subscriber_mou_per_unique_caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Average Non Subscriber MOU/Calls</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_non_subscriber_mou_per_calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_non_subscriber_mou_per_calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr>
    <td class="tg-0pky">Average Subscriber Call/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_subscriber_call_per_unique_caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_subscriber_call_per_unique_caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
 <tr>
    <td class="tg-0pky">Average Subscriber MOU/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_subscriber_mou_per_unique_caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_subscriber_mou_per_unique_caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Average Subscriber MOU/Calls</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_subscriber_mou_per_calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_subscriber_mou_per_calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr>
    <td class="tg-0pky">Average Dedication/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_dedication_mou_per_unique_caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_dedication_mou_per_unique_caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr>
    <td class="tg-0pky">Unique Caller/Active Subscribers in the System</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.system_unique_caller_per_active_subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.system_unique_caller_per_active_subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr>
    <td class="tg-0pky">Service Penetration(in%)(Total Operator Base=10000000)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.service_penetration}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.service_penetration}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr>
    <td class="tg-0pky">ARPU</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.arpu}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.arpu}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>   
  <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="6" style="background-color:#e5e3e3;">Grace Subscriber Classification</th>
    <td class="tg-0pky">Subscribers moved from Active to Grace</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_moved_from_active_to_grace}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_moved_from_active_to_grace}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribers moved from Grace to Active</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_moved_from_grace_to_active}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_moved_from_grace_to_active}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribers in 1-7 days Grace with service</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_1_7_days_grace_with_service}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_1_7_days_grace_with_service}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribers in 8-14 days retry</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_8_14_days_retry}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_8_14_days_retry}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribers in 15-21 Days retry</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_15_21_days_retry}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_15_21_days_retry}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribers in 22-30 days retry</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_22_30_days_retry}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_22_30_days_retry}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="11">Usage Pattern</th>
    <td class="tg-0pky">0-1 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_0_1}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_0_1}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">1-2 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_1_2}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_1_2}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">2-3 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_2_3}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_2_3}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">3-4 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_3_4}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_3_4}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">4-5 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_4_5}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_4_5}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">5-6 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_5_6}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_5_6}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">6-7 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_6_7}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_6_7}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">7-8 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_7_8}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_7_8}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">8-9 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_8_9}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_8_9}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">9-10 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_9_10}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_9_10}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">10 Mins & Above</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins_above10}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins_above10}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
</table>
</div>
	<script>
				function getContextPath() {
					return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
				}

				function goBack()
				{
					event.preventDefault();
					window.location.href=getContextPath()+"/neXtMusicMIShome";
					
				}
				</script>
			</body>
			
</html>
