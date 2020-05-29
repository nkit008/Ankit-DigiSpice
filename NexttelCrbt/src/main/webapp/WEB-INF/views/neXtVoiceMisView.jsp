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
				<p style="background-color:#79797c;color:#fff;text-align:center;font-weight:bold;font-size: 18px;padding: 16px;">neXtVoice MIS</p>
	
									<div style="clear: both; padding-top: 42px;" align="center">
									<a href="reportxlsNextVoice" class="export">Export to Excel</a><img
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
			<th>${data.date}</th>
	</c:forEach>
			
	</tr>

<tr>
    <th class="tg-c3ow" rowspan="12">Music Scorer</th>
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
				<c:when test="${empty data.subscribed_User_Calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_User_Calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Non Subscribed User Calls</td>
    <c:forEach items="${reportdata}" var="data">
    		<c:choose>
				<c:when test="${empty data.non_Subscribed_User_Calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_Subscribed_User_Calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>		
			
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-c3ow" rowspan="3" style="text-align:center;background-color:#e5e3e3;">MOU</td>
    <td class="tg-0pky">Total MOU</td>
    <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_MOU}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_MOU}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscribed User MOU</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.subscribed_User_MOU}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_User_MOU}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Non-Subscribed User MOU</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.non_Subscribed_User_MOU}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_Subscribed_User_MOU}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">Pulse (in Mins)</td>
    <td class="tg-0pky">Total Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribed_User_Pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribed_User_Pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non -Subscribed User Pulses</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.non_Subscribed_User_Pulses}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_Subscribed_User_Pulses}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-c3ow" rowspan="3" style="text-align:center;background-color:#e5e3e3;">Unique Callers</td>
    <td class="tg-0pky">Total Unique Callers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Unique_Callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Unique_Callers}</td>
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
				<c:when test="${empty data.unique_Non_Subscribed_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_Non_Subscribed_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr> 
  
  <tr>
    <th class="tg-0pky" rowspan="7" colspan="2">Subscriptions & Un-subscription</th>
    <td class="tg-0pky">Daily Pack @250 XAF</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">weekly Pack @1000 XAF</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Montly Pack @3000 XAF</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.montly_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.montly_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Yearly Pack @25000 XAF</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.yearly_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.yearly_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Voluntary Un-subscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.voluntary_Un_subscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.voluntary_Un_subscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">InVoluntary Un-subscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.inVoluntary_Un_subscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.inVoluntary_Un_subscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Gross Adds</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_Adds}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_Adds}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>  
  
  
<tr>
    <th class="tg-0pky" rowspan="7" colspan="2">Mode of Subscription</th>
    <td class="tg-0pky">IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_IVR}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_IVR}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
  <tr>
    <td class="tg-0pky">CCI</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_CCI}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_CCI}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
<tr>
<td class="tg-0pky">OBD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_OBD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_OBD}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
<td class="tg-0pky">SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_SMS}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_SMS}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
    <td class="tg-0pky">IBD</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.sub_IBD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_IBD}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
<td class="tg-0pky">USSD</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.sub_USSD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_USSD}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Others</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_Others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_Others}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
  </tr>


<tr style="background-color:#e5e3e3;">
    <th class="tg-c3ow" rowspan="4" colspan="2" style="text-align:center;background-color:#e5e3e3;">Re-Subscription/Renewals</th>
    <td class="tg-0pky">Daily Renewal@250 XAF</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_Renewal}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_Renewal}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>


  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Weekly Renewal Pack @1000 XAF</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.weekly_Renewal_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_Renewal_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
    <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Montly Renewal Pack @3000 XAF</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.montly_Renewal_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.montly_Renewal_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  
    <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Yearly Renewal Pack @25000 XAF</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.yearly_Renewal_Pack}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.yearly_Renewal_Pack}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>

  <tr style="background-color:#e5e3e3;">
    <th class="tg-c3ow" rowspan="4" colspan="2" style="text-align:center;background-color:#e5e3e3;">Mode of Un-Subscription</th>
    <td class="tg-0pky">IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_IVR}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_IVR}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">CCI</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.unsub_CCI}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_CCI}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_SMS}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_SMS}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Others</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_Others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_Others}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="2">New Songs</th>
    <td class="tg-0pky">Attempted</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.new_songs_Attempted}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.new_songs_Attempted}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
</tr>
	<tr>
   <td class="tg-0pky">Submitted</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.new_songs_Submitted}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.new_songs_Submitted}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="3" style="background-color:#e5e3e3;">Dedication</th>
    <td class="tg-0pky">To On-Net Customer</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.to_On_Net_Customer}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.to_On_Net_Customer}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
</tr>
	<tr style="background-color:#e5e3e3;">
   <td class="tg-0pky">To Off-Net Customer</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.to_Off_Net_Customer}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.to_Off_Net_Customer}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  	<tr style="background-color:#e5e3e3;">
   <td class="tg-0pky">Total</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.dedication_Total}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.dedication_Total}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
    	<tr>
   <th class="tg-0pky" colspan="3">No of Voting SMS</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.no_of_Voting_SMS}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.no_of_Voting_SMS}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  
    	<tr>
   <th class="tg-0pky" colspan="3">Unique Users Recorded Songs</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unique_Users_Recorded_Songs}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_Users_Recorded_Songs}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <th class="tg-0pky" colspan="3">Total Daily Pack Revenue @250 XAF</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Daily_Pack_Revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Daily_Pack_Revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr>
    <th class="tg-0pky" colspan="3">Total Weekly Pack Revenue @1000 XAF</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Weekly_Pack_Revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Weekly_Pack_Revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr>
    <th class="tg-0pky" colspan="3">Total Monthly Pack Revenue @3000 XAF</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Monthly_Pack_Revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Monthly_Pack_Revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr> 
 
 <tr>
    <th class="tg-0pky" colspan="3">Total Yearly Pack Revenue @25000 XAF</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_Yearly_Pack_Revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_Yearly_Pack_Revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
   
   
<tr>
    <th class="tg-0pky" colspan="3">Gross Revenue (in XAF)</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_Revenue_in_XAF}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_Revenue_in_XAF}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>   
   
<tr>
    <th class="tg-0pky" colspan="3">Gross Revenue (in USD)(1 USD= 585 XAF)</th>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.gross_Revenue_in_USD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.gross_Revenue_in_USD}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>   
    
  <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="3" style="background-color:#e5e3e3;">Active Subscribers</th>
    <td class="tg-0pky">Active Subscribers in the System</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.active_Subscribers_in_the_System}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.active_Subscribers_in_the_System}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Billed Subscribers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.billed_Subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.billed_Subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Calling Subscribers (Subcribers who called within last 30 days)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.calling_Subscribers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.calling_Subscribers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
   <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="7" style="background-color:#e5e3e3;">Product KPI</th>
    <td class="tg-0pky">Average Subscriber Call/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_Subscriber_Call_Unique_Caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_Subscriber_Call_Unique_Caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Average Subscriber MOU/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_Subscriber_MOU_Unique_Caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_Subscriber_MOU_Unique_Caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Average Subscriber MOU/Calls</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_Subscriber_MOU_Calls}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_Subscriber_MOU_Calls}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Average Dedication/Unique Caller</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.average_Dedication_Unique_Caller}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.average_Dedication_Unique_Caller}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Unique Caller/Active Subscribers in the System</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unique_Caller_Active_Subscribers_in_the_System}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_Caller_Active_Subscribers_in_the_System}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Service Penetration(in%)(Total Operator Base=6000000)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.service_Penetration}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.service_Penetration}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">ARPU</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.ARPU}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.ARPU}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>   
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="6">Grace Subscriber Classification</th>
    <td class="tg-0pky">Subscribers moved from Active to Grace</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_moved_from_Active_to_Grace}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_moved_from_Active_to_Grace}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribers moved from Grace to Active</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_moved_from_Grace_to_Active}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_moved_from_Grace_to_Active}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribers in 1-7 days Grace with service</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_1_7_days_Grace_with_service}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_1_7_days_Grace_with_service}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
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
  <tr>
    <td class="tg-0pky">Subscribers in 15-21 Days retry</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscribers_in_15_21_Days_retry}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscribers_in_15_21_Days_retry}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
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
  <tr style="background-color:#e5e3e3;">
    <th class="tg-0pky" colspan="2" rowspan="11" style="background-color:#e5e3e3;">Usage Pattern</th>
    <td class="tg-0pky">0-1 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins0_1}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins0_1}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">1-2 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins1_2}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins1_2}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">2-3 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins2_3}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins2_3}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">3-4 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins3_4}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins3_4}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">4-5 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins4_5}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins4_5}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">5-6 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins5_6}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins5_6}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">6-7 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins6_7}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins6_7}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">7-8 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins7_8}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins7_8}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">8-9 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins8_9}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins8_9}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">9-10 Mins</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins9_10}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins9_10}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">10 Mins & Above</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.mins10_Above}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.mins10_Above}</td>
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
					window.location.href=getContextPath()+"/neXtVoiceMIShome";
					
				}
				</script>
				
			</body>
</html>
