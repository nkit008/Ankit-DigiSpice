<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>
</head>
<link rel="stylesheet" type="text/css"
	href="resources/mis/stylesheet/style.css" />

<!--styles and js start here for datepicker-->
<link rel="stylesheet" type="text/css" href="resources/mis/css/themes.css">
	<link rel="stylesheet" type="text/css"
		href="resources/mis/css/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css"
			href="resources/mis/css/jquery.ui.core.css">
			<script type="text/javascript" src="resources/mis/js/jquery-1.4.2.js"></script>
			<script type="text/javascript" src="resources/mis/js/jquery.ui.core.js"></script>
			<script type="text/javascript"
				src="resources/mis/js/jquery.ui.datepicker.js"></script>
			<link type="text/css" href="resources/mis/css/demos.css" rel="stylesheet" />
			<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});

				$(function() {
					$("#datepicker2").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});
			</script>
			<!--styles and js end here for datepicker-->


			<body>
				<form action="mis" method="post" name="form1">
					<table width="845" border="0" cellpadding="0" cellspacing="0"
						align="center">


						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="" colspan="3" align="left" valign="top"><img
								src="resources/mis/images/logo-nexttel.jpg" width="170" style="height:auto" /></td>
						</tr>

						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<jsp:include page="mis_header.jsp" />
						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" align="left" valign="top" class="mid">

								<div id="login-wrapper" style="width: 100%; margin-left: 12px;">
									<div
										style="color: #4a59ad;text-align:center; font-weight:bold;font-size: 14px; margin: 0px; padding-top: 16px; color: #3d3d3d;">MIS</div>
									<div>....................................................................................................................................................................................................................................................................................</div>
									<div style="color: #c0c0c0; padding-bottom: 0px;"></div>
									<div
										style="font-size: 12px; padding-top: 32px; padding-bottom: 32px; padding-left: 300px">

										<table>
											<tr>
												<td>
													<p>Service Name :</p>
												</td>
												<td><select name="accessService" style="width: 150px">
														<option value="CrbtMis">CRBT Nexttel</option>
												</select></td>
											</tr>
										</table>
									</div>


								</div>
								<div>
									<div class="to" style="font-size: 12px; padding-left: 20px">
										From<input type="text" id="datepicker" name="fromDate"
											style="margin-left: 5px; margin-right: 5px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" required/>
									</div>
									<div class="from" style="font-size: 12px; padding-right: 30px">
										To <input type="text" id="datepicker2" name="toDate"
											style="margin-right: 5px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" required/>
										<input type="hidden" name="acessPage" value="mtnpsycho" /> <span
											style="padding-left: 32px;"><input type="image"
											src="resources/mis/images/submit.jpg" style="margin-left: 16px;" />
									</div>

								</div>

								<div style="clear: both; padding-top: 42px;" align="center">
									<a href="reportxlsCrbt" class="export">Export to Excel</a><img
										src="resources/mis/images/excel.jpg" style="padding-left: 7px;"
										align="absmiddle" />
								</div>
								</div>
							</td>
						</tr>
					</table>

	<div style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
		

<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
			align="center" width="1200" style="padding-bottom: 0px">
			
			<tr>
			<th class="tg-c3ow">MIS</th>
			<th class="tg-c3ow" colspan="2">Description/Date</th>
		<c:forEach items="${reportdata}" var="data">
			<th>${data.date}</th>
	</c:forEach>
			
	</tr>
  
  <tr>
    <th class="tg-c3ow" rowspan="13">Browsing Calls/Access Attempts</th>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">IVR</td>
    <td class="tg-0pky">Total Calls</td>
<c:forEach items="${reportdata}" var="data">
 					<c:choose>
				<c:when test="${empty data.total_calls_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_calls_ivr}</td>
				</c:otherwise>
			</c:choose>		
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Calls</td>
 <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.sub_user_calls_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_user_calls_ivr}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non Subscribed User Calls</td>
    <c:forEach items="${reportdata}" var="data">
    		<c:choose>
				<c:when test="${empty data.non_sub_user_calls_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.non_sub_user_calls_ivr}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>		
			
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">USSD</td>
    <td class="tg-0pky">Total Hits</td>
    <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_hits_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_hits_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
			
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Hits</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.sub_user_hits_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_user_hits_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non Subscribed User Hits</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.nonsub_user_hits_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.nonsub_user_hits_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">SMS</td>
    <td class="tg-0pky">Total Hits</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_hits_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_hits_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Hits</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_user_hits_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_user_hits_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non Subscribed User Hits</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.nonsub_user_hits_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.nonsub_user_hits_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3" style="text-align:center;">Unique Callers</td>
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
  <tr>
    <td class="tg-0pky">Unique subscribed callers</td>
<c:forEach items="${reportdata}" var="data">
		 			<c:choose>
				<c:when test="${empty data.unique_sub_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_sub_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unique Non-Subscribed callers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unique_nonsub_callers}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unique_nonsub_callers}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
   <td class="tg-c3ow" colspan="2" style="text-align:center;">P2P Calls</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.p2p_call}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.p2p_call}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" rowspan="15">Tone Status</th>
    <td class="tg-c3ow" rowspan="8" style="text-align:center;">New Downloads</td>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Corporate Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.corp_tone_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.corp_tone_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Free Users</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.free_user_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.free_user_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Total Tone Downloads</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_download_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_download_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Total Tone Subscrpition Attempts</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_attampt_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_attampt_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Total Tone Subscription Failed</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_fail_new_download}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_fail_new_download}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-c3ow" rowspan="7" style="text-align:center;">Tone Renewals</td>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Corporate Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.corp_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.corp_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr>
    <td class="tg-0pky">Total Tone Downloads</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_tone_download_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_download_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Total Tone Subscrpition Attempts</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_attampt_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_attampt_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Total Tone Subscription Failed</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_fail_tone_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_fail_tone_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <th class="tg-0pky" rowspan="15">Subscription Status</th>
    <td class="tg-c3ow" rowspan="8" style="text-align:center;">New Subscriptions</td>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_new_sub}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_new_sub}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
<tr>
<td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_new_sub}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
<td class="tg-0pky">Corporate Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.corp_tone_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.corp_tone_new_sub}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
    <td class="tg-0pky">Free Users</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.free_user_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.free_user_new_sub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
<td class="tg-0pky">Total Tone Downloads</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_tone_download_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_download_new_sub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Total Tone Subscrpition Attempts</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_attampt_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_attampt_new_sub}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
  </tr>

<tr>
<td class="tg-0pky">Total Tone Subscription Failed</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.total_tone_sub_fail_new_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_fail_new_sub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="7" style="text-align:center;">Subscription Renewals</td>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.weekly_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Corporate Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.corp_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.corp_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Tone Downloads</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_download_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_download_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Tone Subscrpition Attempts</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_attampt_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_attampt_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Tone Subscription Failed</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_tone_sub_fail_sub_renew}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_tone_sub_fail_sub_renew}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="9">Mode of Subscription</th>
    <td class="tg-0pky">Subscription Mode - IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_ivr}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - CCI</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_cci}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_cci}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - OBD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_obd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_obd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - *Copy</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_copy}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_copy}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - GIFT</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_gift}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_gift}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - WAP</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_wap}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_wap}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - USSD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - Others</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.sub_mode_others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.sub_mode_others}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Unsubscription</th>
    <td class="tg-0pky">Voluntary unsubscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.voluntary_unsub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.voluntary_unsub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0lax">Involuntary un-subscription</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.involuntary_unsub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.involuntary_unsub}</td>
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
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="6">Modes of Unsubscription</th>
    <td class="tg-0pky">Unsubscribe Mode - IVR</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_ivr}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_ivr}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode - USSD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_ussd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_ussd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode- WEB</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_web}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_web}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode-CCI</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_cci}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_cci}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode- SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_sms}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_sms}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode- Other</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.unsub_mode_others}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.unsub_mode_others}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Names Tunes</th>
    <td class="tg-0pky">Total Name Tunes Requests</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_name_tone_req}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_name_tone_req}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Already Available</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.already_avail}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.already_avail}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Not Available</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.not_avail}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.not_avail}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Gifted Tones</th>
    <td class="tg-0pky">Total Requests Received</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_req_recived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_req_recived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
	
  </tr>
  <tr>
    <td class="tg-0pky">Accepted</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.accepted}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.accepted}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Rejected / No Response</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.rejected}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.rejected}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Tone Revenue (Local Currency)</th>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_tone_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_tone_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_tone_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_tone_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_tone_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_tone_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Subscription Revenue (Local Currency)</th>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_sub_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_sub_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_sub_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_sub_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_sub_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_sub_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="3">Total Revenue Pack Wise in Local Currency</th>
    <td class="tg-0pky">Daily</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.daily_packwise_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.daily_packwise_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Weekly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weekly_packwise_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weekly_packwise_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Monthly</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthly_packwise_revenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthly_packwise_revenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="2">Total Revenue</th>
    <td class="tg-0pky">Local Currency</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_revenue_local}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_revenue_local}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">USD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_revenue_usd}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_revenue_usd}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" colspan="2" rowspan="9">Subscribers Status</th>
    <td class="tg-0pky">Active subscribers (Subscription)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.active_subscriber_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.active_subscriber_sub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Active Subscriber (Tone Download)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.active_subscriber_tone}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.active_subscriber_tone}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">New Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.new_tone}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.new_tone}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">New Tone Low Balance</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.new_tone_low_bal}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.new_tone_low_bal}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Grace</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.grace}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.grace}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Renewal Low Balance (Subscription)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.renewal_low_bal_sub}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.renewal_low_bal_sub}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Renewal Low Balance (Tone Download)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.renewal_low_bal_tone}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.renewal_low_bal_tone}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Billed Subscribers</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.billed_subscriber}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.billed_subscriber}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Base</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.total_base}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.total_base}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 <tr>
    <th class="tg-0pky" colspan="2" rowspan="4">Product Performance</th>
    <td class="tg-0pky">No. of tones/subscriber</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.no_of_tone_subscriber}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.no_of_tone_subscriber}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Users without a Tone</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.users_without_tone}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.users_without_tone}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Service penetration(in %)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.service_pentration}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.service_pentration}</td>
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
</table>



    			
				




	</div>
					
					
					
					
					
					
					
					
					
					
					
					
					

				</form>
			</body>
</html>
