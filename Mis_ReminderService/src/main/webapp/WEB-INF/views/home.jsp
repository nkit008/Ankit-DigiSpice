<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>

<link rel="stylesheet" type="text/css" href="resources/stylesheet/style.css" />

<!--styles and js start here for datepicker-->
<link rel="stylesheet" type="text/css" href="resources/css/themes.css">
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css" href="resources/css/jquery.ui.core.css">
			<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
			<script type="text/javascript" src="resources/js/jquery.ui.core.js"></script>
			<script type="text/javascript" src="resources/js/jquery.ui.datepicker.js"></script>
			<script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>
			<link type="text/css" href="resources/css/demos.css" rel="stylesheet" />
			<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.js"></script>
	
				<script type="text/javascript">
					
				$(document).ready(function(){
				$(function() {
						$("#datepicker").datepicker({
							maxDate : 0
						});
					});

					$(function() {
						$("#datepicker2").datepicker({
							maxDate : 0
						});
					});
					
					if($('#alert_user').val()==='wrong ani'){
						var x = document.getElementById("snackbar");
					    x.className = "show";
					    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
						
					}
				});

				</script>
				
<style>
#snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #333;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
}
.dropdown-menu.show {
    z-index: 99999;
}
#snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}
	</style>
	
</head>
				<body>
				<input type="hidden" id="alert_user" value="${result}">
				<div id="snackbar">${msg}</div>
				
					<h6 class="text-danger text-center" style="margin-top: 15px">${message}</h6>
					<form action="mis" method="post" name="form1" autocomplete="off">
						<div style="float: left; margin-left: 11%; margin-top: -10px;">
							<img src="resources/images/smartLogo.png" width="194" height="74" />
						</div>
						<div style="float: left; margin-left: 11%;">
							<table style="margin-top: 10px; margin-bottom: 5px;" width="845"
								border="0" cellpadding="0" cellspacing="0">
								<jsp:include page="common/header.jsp" />
							</table>
							<div class="mid"
								style="padding-right: 35px; padding-left: 35px; padding-top: 15px;">
								<h5 class="text-center" width="40%"
									style="border-bottom: 2px dotted">MIS</h5>
								<p>&#x00A0;</p>
								<p>&#x00A0;</p>
							</div>
							<table border="0px solid" cellpadding="0" cellspacing="0"
								style="margin-top: -35px; margin-bottom: -5px; margin-left: 93px;"
								width="90%" border="0">
								<tr>
									<td>
										<div class="to" style="font-size: 15px;">
											<p>
												From<input type="text" id="datepicker" name="fromDate"
													style="margin-left: 5px; margin-right: 5px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" required/>
											</p>
										</div>
									</td>
									<td>
										<div class="from">
											<p>
												To <input type="text" id="datepicker2" name="toDate"
													style="margin-right: 100px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;"  required/>
											</p>
										</div>
									</td>
									<td><span
										style="float: right; margin-left: -110px; margin-top: -18px;"><input
											type="submit" value="submit" id="btn-submit"
											class="btn btn-danger"></span></td>
								</tr>
							</table>
							<p class="text-center">
								<a href="reportxls" class="export">Export to Excel</a> <img
									src="resources/images/excel.jpg" style="padding-left: 7px;"
									align="absmiddle" />
							</p>


				<div style="overflow: scroll; height: 380px; width: 999px; margin: 0px auto; margin-top: 20px;">
							<table class="table" id="head_table" border="1px solid #fff"
								width="100%" style="font-size: 13px; margin-bottom: 18px;"
								cellspacing="0px" cellpadding="0px">
								<thead>
									<tr>
										<th
											style="text-align: center; border-top: 2px solid; border-left: 2px solid;">Karaoke</th>

										<th
											style="text-align: center; border-top: 2px solid; border-left: 2px solid;border-bottom: 2px solid; border-right: 2px solid;">Date</th>

										<div style="clear: both;" align="center">
											<c:forEach items="${reportdata}" var="data">
												<td>
													<table
														style="border-collapse: collapse; text-align: center; font-size: 13px;"
														width="100%" cellpadding="0" cellspacing="0">
														<tr>
															<td
																style="border-right: 2px solid; border-top: 2px solid;border-bottom: 2px solid;"><span
																style="color: #dc3545">${data.date}</span></td>
														</tr>
													</table>
												</td>
											</c:forEach>
											</div>
										
									</tr>
								</thead>
								<tbody>

									<tr>
										<td
											style="text-align: center; border-top: 2px solid; border-left: 2px solid;"  rowspan="11"><span
											style="color: #dc3545;">USSD KPI'S</span></td>
										<td style="text-align:center;">Total Hits</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_hits}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Hits - Live Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.hits_live_call}</td>
										</c:forEach>
										</tr>
										<tr>
											<td style="text-align:center;">Hits - Non Live Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.hits_nonlive_call}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Total Session's</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_session}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Session's - Live Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.session_live_call}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Session's - Non Live Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.session_nonlive_call}</td>
										</c:forEach>
										</tr>
										<tr>
											<td style="text-align:center;">Total Unique Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_uniq_call}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Unique Live Callers</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.uniq_live_call}</td>
										</c:forEach>
										</tr>
										<tr>
											<td style="text-align:center;">Unique Non Live Callers</td>
											<c:forEach items="${reportdata}" var="data">
												<td style="text-align:center;">${data.uniq_nonlive_call}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Unique Callers MTD</td>
										<c:forEach items="${reportdata}" var="data">
												<td style="text-align:center;">${data.uniq_call_mtd}</td>
										</c:forEach>
												</tr>
										<tr>
										<td style="text-align:center;">Unique Live Callers MTD</td>
										<c:forEach items="${reportdata}" var="data">
												<td style="text-align:center;">${data.uniq_live_call_mtd}</td>
										</c:forEach>
										</tr>
										<tr>
										<td
											style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="6"><span
											style="color: #dc3545;">OBD Gross Ads</span></td>
										<td style="text-align:center;">Subscription Requests @ 10 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_sub_req_10}</td>
										</c:forEach>
										</tr>
										<tr>
										<td style="text-align:center;">Subscription Requests @ 5 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_sub_req_5}</td>
										</c:forEach>			
										</tr>
										<tr>			
										<td style="text-align:center;">Subscription Requests @ 2 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_sub_req_2}</td>
										</c:forEach>
										</tr>
										<tr>			
										<td style="text-align:center;">Successful Subscriptions @ 10 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_succ_sub_10}</td>
										</c:forEach>
										</tr>
										<tr>			
										<td style="text-align:center;">Successful Subscriptions @ 5 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_succ_sub_5}</td>
										</c:forEach>
										</tr>			
										<tr>
										<td style="text-align:center;">Successful Subscriptions @ 2 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.obd_succ_sub_2}</td>
										</c:forEach>
										</tr>
									<tr>
										<td
											style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="6">
											<span style="color: #dc3545;">USSD Gross Ads</span></td>
										<td style="text-align:center;">Subscription Requests @ 10 Afa</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_sub_req_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Subscription Requests @ 5 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_sub_req_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Subscription Requests @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_sub_req_2}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Successful Subscriptions @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_succ_sub_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Successful Subscriptions @ 5 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_succ_sub_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Successful Subscriptions @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_succ_sub_2}</td>
										</c:forEach>
									</tr>

								<tr class="fun_std">
								<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="7">
										<span style="color: #dc3545;">Total Retry</span></td>
								<td style="text-align:center;">Total Subscription Retry @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_retry_10}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Retry @ 5 afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_retry_5}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Retry @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_retry_2}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Retry Successful @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_retry_succ_10}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Retry Successful @ 5 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_retry_succ_5}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Retry Successful @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_retry_succ_2}</td>
										</c:forEach>								
								</tr>
								<tr>
								<td style="text-align:center;">Total Retry Successful</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_retry_succ}</td>
										</c:forEach>								
								</tr>
								<tr>
									<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="7"><span
											style="color: #dc3545;">Total Gross Ads</span></td>
									<td style="text-align:center;">Total Subscription Requests @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_req_10}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Requests @ 5 Afa</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_req_5}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Requests @ 2 Afa</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_req_2}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Successful @ 10 Afa</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_succ_10}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Successful @ 5 Afa</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_succ_5}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Successful @ 2 Afa</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_succ_2}</td>
										</c:forEach>
								</tr>
								<tr>
								<td style="text-align:center;">Total Subscription Successful</td>
								<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_succ}</td>
										</c:forEach>
								</tr>
								<tr>
									<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="6"><span
											style="color: #dc3545;">Renewals</span></td>
									<td style="text-align:center;">Renewal Requests @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_req_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Requests @ 5 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_req_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Requests @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_req_2}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Successful @ 10 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_succ_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Successful @ 5 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_succ_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Successful @ 2 Afa</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renew_succ_2}</td>
										</c:forEach>
									</tr>
									<tr>
										<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="6"><span
											style="color: #dc3545;">Churn</span></td>
										<td style="text-align:center;">CCI Churn</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.cci_churn}</td>
										</c:forEach>
									</tr>
									<tr>
										<td style="text-align:center;">USSD Churn</td>
										<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.ussd_churn}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Others Churn</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.others_churn}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Voluntary Churn</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.voluntary_churn}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Involuntary Churn</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.involuntary_churn}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Total Churn</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_churn}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="5"><span
											style="color: #dc3545;">Set Reminders</span></td>
									<td style="text-align:center;">Total Reminders</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_reminder}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Unique Reminders</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.uniq_reminder}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">No of Reminder set</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.no_of_reminder_set}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">No of Greetings Send to Users</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.no_of_greetings_send_to_user}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Reminder Per Users</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.reminder_per_user}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="9"><span
											style="color: #dc3545;">Revenue</span></td>
									<td style="text-align:center;">Subscription Revenue @ 10 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.sub_revenue_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Subscription Revenue @ 5 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.sub_revenue_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Subscription Revenue @ 2 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.sub_revenue_2}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Total Subscription Revenue</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_sub_revenue}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Revenue @ 10 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renewal_revenue_10}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Revenue @ 5 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renewal_revenue_5}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Renewal Revenue @ 2 LKR</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.renewal_revenue_2}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Total Renewal Revenue</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_renewal_revenue}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align:center;">Total Revenue</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.total_revenue}</td>
										</c:forEach>
									</tr>
									<tr>
									<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="4">
									<span style="color: #dc3545;">Subscriber Base</span></td>
									<td style="text-align:center;">Net Additions</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.net_addition}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Active Base</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.active_base}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Grace Base</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.grace_base}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Retry Base</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.retry_base}</td>
										</c:forEach>									
									</tr>
									<tr>
										<td style="text-align: center; border-top: 2px solid; border-left: 2px solid;" rowspan="5">
										<span style="color: #dc3545;">Business Analysis</span></td>
									<td style="text-align:center;">ARPU</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.arpu}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Hits Per Unique User</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.hits_per_uniq_user}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Hits Per Unique Live User</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.hits_per_uniq_live_user}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Session's Per Unique User</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.session_per_uniq_user}</td>
										</c:forEach>									
									</tr>
									<tr>
									<td style="text-align:center;">Session's Per Unique Live User</td>
									<c:forEach items="${reportdata}" var="data">
											<td style="text-align:center;">${data.session_per_uniq_live_user}</td>
										</c:forEach>									
									</tr>
						 	    </tbody>
							</table>
							</div>
						</div>
					</form>
				</body>
</html>