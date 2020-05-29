<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/daterangepicker.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">

<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>

</head>




<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>



</head> --%>
<!--styles and js end here for datepicker-->


<!-- <body style="font-family: 'Poppins', sans-serif; font-size: 14px;"> -->
<body>
	<jsp:include page="header_new.jsp"></jsp:include>
	<div class="wrapper">
		<form action="mis" method="post" name="form1">
			<table width="845" border="0" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<td colspan="3" align="left" valign="top" class="mid">
						<div id="login-wrapper" style="width: 100%; margin-left: 12px;margin-top: 20px;">
							<!-- <p style="background-color: #79797c; color: #fff; text-align: center; font-weight: bold; font-size: 18px; padding: 16px;">MIS</p> -->
	
							<div style="clear: both; padding-top: 42px;">
								<a href="reportxls" class="export">Export to Excel</a><img src="resources/mis/images/excel.jpg" style="padding-left: 7px;" align="left" />
								<button onclick="goBack()"
									style="float: right; margin-top: -10px; font-weight: bold; background-color: #f73b43; padding: 12px; color: #fff; font-size: 14px;">Back</button>
							</div>
	
						</div>
					</td>
				</tr>
			</table>
	
			<div
				style="overflow: scroll; height: 490px; width: 1105px; margin: 0px auto; margin-top: 20px;">
	
	
				<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
					align="center" width="1200" style="padding-bottom: 0px">
					
	
					<tr style="background-color: #f73b43; color: #ffffff;">
						<th class="tg-c3ow">MIS</th>
						<th class="tg-c3ow" colspan="2">Description/Date</th>
						<c:forEach items="${reportdata}" var="data">
							<th>${data.date_time}</th>
						</c:forEach>
	
					</tr>
	
					<tr>
						<th class="tg-c3ow" rowspan="18"
							style="background-color: #f73b43; color: #ffffff;">Voice
							Changer</th>
						<td class="tg-c3ow" rowspan="5" style="text-align: center;">Calls</td>
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
						<td class="tg-0pky">Total Nonsubscriber User Calls on 4714</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_calls_nonsub_sc}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_calls_nonsub_sc}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">Total Subscribed User Calls on 4174</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_calls_sub_sc}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_calls_sub_sc}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<td class="tg-0pky">Total Subscribed User Calls on MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_calls_sub_mm}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_calls_sub_mm}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
	
					</tr>
	
					<tr>
						<td class="tg-0pky">Total Subscribed User Calls on MM (Wrong)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_calls_nosub_mm}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_calls_nosub_mm}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
	
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-c3ow" rowspan="5"
							style="text-align: center; background-color: #e5e3e3;">B
							Party Calls</td>
						<td class="tg-0pky">Total Dial Calls on B Party from MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mm}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mm}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
	
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Total B Party Calls Connected from MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mm_success}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mm_success}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Total B Party Call Failed from MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mm_fail}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mm_fail}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Total B Party Call Failed (No Answer) : MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mm_noanswer}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mm_noanswer}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Total B Party Call Failed (Busy) : MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mm_busy}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mm_busy}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-c3ow" rowspan="4" style="text-align: center;">MOU</td>
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
					<tr>
						<td class="tg-0pky">Total Non Subscriber 4714 Calls MOU</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_mou_nonsub}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_mou_nonsub}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">Total Subscriber 4174 Calls MOU</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_mou_sub}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_mou_sub}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<td class="tg-0pky">Total B Party Outgoing Calls MOU on MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_outdial_mou_mm}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_outdial_mou_mm}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-c3ow" rowspan="4" style="text-align: center;">Unique
							Callers</td>
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
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Unique Nonsubscriber User Callers on 4174</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_unique_callers_nonsub_sc}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_unique_callers_nonsub_sc}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Unique Subscribed User Callers on 4174</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_unique_callers_sub_sc}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_unique_callers_sub_sc}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Unique B Party Outgoing Callers on MM
							(Correct)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.total_unique_callers_sub_mm}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.total_unique_callers_sub_mm}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<th class="tg-0pky" rowspan="7" colspan="2"
							style="background-color: #f73b43; color: #ffffff;">New
							Subscriptions & Unsubscription</th>
	
						<td class="tg-0pky">Monthly Auto Renewal Subscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.MONTHLY_AR_NEWSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.MONTHLY_AR_NEWSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Weekly Auto Renewal Subscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.WEEKLY_AR_NEWSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.WEEKLY_AR_NEWSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Daily Auto Renewal Subscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.DAILY_AR_NEWSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.DAILY_AR_NEWSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Daily One Time Subscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.DAILY_NEWSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.DAILY_NEWSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Voluntary Unsubscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.VOL_UNSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.VOL_UNSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">InVoluntary Unsubscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.INVOL_UNSUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.INVOL_UNSUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Gross Adds</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.GROSS_ADDS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.GROSS_ADDS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr>
						<td class="tg-c3ow" rowspan="3" colspan="2"
							style="text-align: center;">Re-Subscription/Renewals</td>
						<td class="tg-0pky">Monthly Auto Renewal Resubscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.MONTHLY_AR_RESUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.MONTHLY_AR_RESUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<td class="tg-0pky">Weekly Auto RenewalResubscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.WEEKLY_AR_RESEUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.WEEKLY_AR_RESEUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<td class="tg-0pky">Daily Auto Renewal Resubscription</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.DAILY_AR_RESUB}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.DAILY_AR_RESUB}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr style="background-color: #e5e3e3;">
						<th class="tg-0pky" rowspan="6" colspan="2"
							style="background-color: #f73b43; color: #ffffff;">Subscription
							Request</th>
						<td class="tg-0pky">IVR</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_IVR}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_IVR}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">CCI</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_CCI}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_CCI}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">OBD</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_OBD}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_OBD}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">SMS</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_SMS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_SMS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">USSD</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_USSD}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_USSD}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Others</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_SUB_OTHER}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_SUB_OTHER}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr>
						<td class="tg-c3ow" rowspan="6" colspan="2"
							style="text-align: center;">Subscription Success</td>
						<td class="tg-0pky">IVR</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_IVR}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_IVR}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">CCI</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_CCI}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_CCI}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">OBD</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_OBD}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_OBD}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">SMS</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_SMS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_SMS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">USSD</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_USSD}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_USSD}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">Others</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.SUCCESS_SUB_OTHER}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.SUCCESS_SUB_OTHER}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr style="background-color: #e5e3e3;">
						<th class="tg-0pky" colspan="2" rowspan="6"
							style="background-color: #f73b43; color: #ffffff;">Mode of
							Un-Subscription</th>
						<td class="tg-0pky">IVR</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_IVR}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_IVR}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">CCI</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_CCI}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_CCI}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">SMS</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_SMS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_SMS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">USSD</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_USSD}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_USSD}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">System App</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_APP}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_APP}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Others</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.UNSUB_OTHER}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.UNSUB_OTHER}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr style="background-color: #e5e3e3;">
						<th class="tg-0pky" colspan="2" rowspan="6"
							style="background-color: #f73b43; color: #ffffff;">Type of
							Voice (with B Party) (use only 1st time selected voice in same
							call)</th>
						<td class="tg-0pky">Child</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_child}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_child}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Female</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_female}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_female}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Male</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_male}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_male}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Chipmunk</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_chipmunk}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_chipmunk}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Monster</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_monster}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_monster}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Others</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.voice_others}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.voice_others}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Browsing
							Revenue @0 NPR per Pulse</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.browsing_rev}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.browsing_rev}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Montly
							Auto Renewal Subscription Revenue @38.31 NPR</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.MONTHLY_AR_REVENUE}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.MONTHLY_AR_REVENUE}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Weekly
							Auto Renewal Subscription Revenue @10.22 NPR</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.WEEKLY_AR_REVENUE}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.WEEKLY_AR_REVENUE}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Daily Auto
							Renewal Subscription Revenue @1.53 NPR</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.DAILY_AR_REVENUE}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.DAILY_AR_REVENUE}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Daily One
							Time Subscription Revenue @3.83 NPR</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.DAILY_REVENUE}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.DAILY_REVENUE}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Gross
							Revenue (in NPR)</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.gross_rev_npr}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.gross_rev_npr}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="3"
							style="background-color: #f73b43; color: #ffffff;">Gross
							Revenue (in USD)(1 USD= 111 NPR)</th>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.gross_rev_usd}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.gross_rev_usd}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
	
					<tr style="background-color: #e5e3e3;">
						<th class="tg-0pky" colspan="2" rowspan="2"
							style="background-color: #f73b43; color: #ffffff;">Active
							Subscribers</th>
						<td class="tg-0pky">Active Subscribers in the System</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_ACTIVE_SUBS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_ACTIVE_SUBS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
	
					</tr>
					<tr style="background-color: #e5e3e3;">
						<td class="tg-0pky">Billed Subscribers</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.TOTAL_BILLED_SUBS}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.TOTAL_BILLED_SUBS}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<th class="tg-0pky" colspan="2" rowspan="4"
							style="background-color: #f73b43; color: #ffffff;">Product
							KPI</th>
						<td class="tg-0pky">Average MOU/Call</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.mou}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.mou}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
					<tr>
						<td class="tg-0pky">Unique Caller/Active Subscribers in the
							System</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.unique_caller}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.unique_caller}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
	
					<tr>
						<td class="tg-0pky">Service Penetration(in%)(Total Operator
							Base=7,00,000)</td>
						<c:forEach items="${reportdata}" var="data">
							<c:choose>
								<c:when test="${empty data.service_pen}">
									<td>0</td>
								</c:when>
								<c:otherwise>
									<td>${data.service_pen}</td>
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
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/custom-file-input.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>
	
	<script src="resources/js/dataTables.bootstrap.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	
	<script src="resources/js/jquery.form-advanced.init.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/moment.min.js"></script>
	<script src="resources/js/daterangepicker.min.js"></script>
	
	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<script>
		$(document).ready(function() {
		    $('#datatable').DataTable( {
		        /* "scrollX": true */
		    	"bPaginate": true,
		        "bLengthChange": false,
		        "bFilter": true,
		        "bInfo": true,
		        "scrollY": 200,
		        "scrollX": true 
		        
		    } );
		} );
	</script>	

	<script>
		function getContextPath() {
			return window.location.pathname.substring(0,
					window.location.pathname.indexOf("/", 2));
		}

		function goBack() {
			event.preventDefault();
			window.location.href = getContextPath() + "/mishome";

		}
	</script>
</body>
</html>
