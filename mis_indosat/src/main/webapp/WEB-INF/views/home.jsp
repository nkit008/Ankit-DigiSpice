<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>
</head>
<link rel="stylesheet" type="text/css"
	href="resources/stylesheet/style.css" />

<!--styles and js start here for datepicker-->
<link rel="stylesheet" type="text/css" href="resources/css/themes.css">
	<link rel="stylesheet" type="text/css"
		href="resources/css/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css"
			href="resources/css/jquery.ui.core.css">
			<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
			<script type="text/javascript" src="resources/js/jquery.ui.core.js"></script>
			<script type="text/javascript"
				src="resources/js/jquery.ui.datepicker.js"></script>
			<link type="text/css" href="resources/css/demos.css" rel="stylesheet" />
			<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						showOn : 'button',
						buttonImage : 'resources/images/calendar.gif',
						buttonImageOnly : true
					});
				});

				$(function() {
					$("#datepicker2").datepicker({
						showOn : 'button',
						buttonImage : 'resources/images/calendar.gif',
						buttonImageOnly : true
					});
				});
				
				function pagerefresh() {
					window.document.form1.action = "${pageContext.request.contextPath}/gamingStore?accesspage="
							+ window.document.form1.accessService.value;
					window.document.form1.method = "post";
					window.document.form1.submit();
				}
			</script>
			<!--styles and js end here for datepicker-->


			<body>
				<form action="GameStoreMIS" method="post" name="form1">
					<table width="845" border="0" cellpadding="0" cellspacing="0"
						align="center">


						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="" colspan="3" align="left" valign="top"><img
								src="resources/images/smartLogo.jpg" width="200" height="80" /></td>
						</tr>

						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<jsp:include page="common/header.jsp" />
						<tr>
							<td colspan="3" align="left" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" align="left" valign="top" class="mid"><div
									id="login-wrapper" style="width: 100%; margin-left: 12px;">
									<p class="text-center" width="40%"
									style="font-size:15px;border-bottom: 2px dotted">MIS</p>
									<div style="color: #c0c0c0; padding-bottom: 0px;"></div>
									<div
										style="font-size: 12px; padding-top: 32px; padding-bottom: 32px; padding-left: 320px" width="30%">
										

										<table>
											<tr>
												<td>
													<p>Service Name :</p>
												</td>
												<td>
												<select name="accessService" style="width: 150px">
												<option>iGames</option>
												
											<%-- <c:choose>
											<c:when test="${accesspage == 'gamingMis_airtel'}">
												
											</c:when>
											<c:otherwise>
												<option value="gamingMis_robi">Gaming MIS Robi</option>
												<option value="gamingMis_airtel">Gaming MIS Airtel</option>
											</c:otherwise>
										</c:choose> --%>


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
											src="resources/images/submit.jpg" style="margin-left: 16px;" />
									</div>

								</div>

								<div style="clear: both; padding-top: 42px;" align="center">
									<a href="reportxls" class="export">Export to Excel</a><img
										src="resources/images/excel.jpg" style="padding-left: 7px;"
										align="absmiddle" />
								</div>
								</div></td>
						</tr>
						<tr>
							<td colspan="3" align="left" valign="top">
							
							<div style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
									<table border="1" cellpadding="0" cellspacing="0"
										bgcolor="#FFFFFF" align="center" width="1200"
										style="padding-bottom: 0px">
										<tr>
											<td colspan="3"><font color="BLACK"></font></td>
										</tr>
										<tr>
											<!-- <td style="width: 300px;" ><font color="red">LUCKY DRAW</font></td> -->
											<td width="136"><font color="red">Date</font></td>
											<td width="300" style="width: 300px;"><font color="red">KPI</font></td>

											<c:forEach items="${reportdata}" var="data">
												<td valign="top"><table width="100%" border="1"
														cellpadding="0" cellspacing="0">
														<tr>
															<td>${data.date_time}</td>
														</tr>
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td colspan="3">&nbsp;</td>
										</tr>
										<tr>
											<td><font color="red">BASE</font></td>
											<td valign="top"><table border="1" cellpadding="0"
													cellspacing="0" width="300">
												<tr>
													<td>Active  Base</td>
												</tr>
												<tr>
													<td>Total Subscription Requests Received</td>
												</tr>
												<tr>
													<td>Total Subscription Requests processed</td>
												</tr>
												<tr>
													<td>Total Gross Adds</td>
												</tr>
												<tr>
													<td>Total Churn</td>
												</tr>
												<tr>
													<td>Net Adds</td>
												</tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td valign="top"><table width="100%" border="1"
														cellpadding="0" cellspacing="0">
														<tr>
													<c:choose>
    													<c:when test="${empty data.active_base}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.active_base}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_sub_req_rec}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_sub_req_rec}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_sub_req_proc}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_sub_req_proc}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_gross_add}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_gross_add}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_churn}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.net_add}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.net_add}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													</table>
													</td>
													</c:forEach>
													</tr>
										
										<tr>
											<td><font color="red">REVENUE</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Sub Revenue</td>
												</tr>
												<tr>
													<td>Renewal Revenue</td>
												</tr>
												<tr>
													<td>Grand Total</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.gross_adds_revenue}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.gross_adds_revenue}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.renewal_revenue}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.renewal_revenue}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.grand_total}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.grand_total}</td>
    													</c:otherwise>
													</c:choose>
												</tr>
													
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">NEW SUBSCRIPTION</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Subscription requests received @ 2200</td>
												</tr>
												<tr>
													<td>Successful subscriptions @2200</td>
												</tr>
												<tr>
													<td>Subscription requests received @ 5500</td>
												</tr>
												<tr>
													<td>Successful subscriptions @ 5500</td>
												</tr>
												<tr>
													<td>Subscription requests received @ 11000</td>
												</tr>
												<tr>
													<td>Successful subscriptions @11000</td>
												</tr>
												<tr>
													<td>Total New Users</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
														<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_rec_2200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_rec_2200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_sub_2200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        												<td>${data.succ_sub_2200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_rec_5500}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_rec_5500}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_sub_5500}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_sub_5500}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_rec_11000}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_rec_11000}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_sub_11000}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_sub_11000}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_new_users}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_new_users}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>													
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">USER MENU (SMS)</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Users Paid</td>
												</tr>
												<tr>
													<td>Total users</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.users_paid_sms}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_users_sms}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.users_paid_ussd}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.users_paid_ussd}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
												
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">USER MENU (USSD)</font></td>
											<td valign="top"><table border="1" cellpadding="0"
													cellspacing="0" width="300">
												<tr>
													<td>Users Paid</td>
												</tr>
												<tr>
													<td>Total users</td>
												</tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.users_paid_ussd}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.users_paid_ussd}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_users_ussd}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_users_ussd}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
											</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">RENEWAL</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>total renewal @2200</td>
												</tr>
												<tr>
													<td>total renewal @5500</td>
												</tr>
												<tr>
													<td>total renewal @11000</td>
												</tr>
												<tr>
													<td>Successful Renewal @ 2200</td>
												</tr>
												<tr>
													<td>Successful Renewal @ 5500</td>
												</tr>
												<tr>
													<td>Successful Renewal @ 11000</td>
												</tr>
												<tr>
													<td>Fail Renewal @ 2200</td>
												</tr>
												<tr>
													<td>Fail Renewal @ 5500</td>
												</tr>
												<tr>
													<td>Fail Renewal @ 11000</td>
												</tr>
												<tr>
													<td>Total Renewal Users</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_ren_2200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_ren_2200}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_ren_5500}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_ren_5500}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_ren_11000}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_ren_11000}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_ren_2200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_ren_2200}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_ren_5500}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_ren_5500}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_ren_11000}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_ren_11000}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_ren_2200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_ren_2200}</td>
    													</c:otherwise>
													</c:choose>
										</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_ren_5500}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_ren_5500}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_ren_11000}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_ren_11000}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_ren_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_ren_user}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													</table></td>
													</c:forEach>
													</tr>
										<tr>
											<td><font color="red">Retry USER</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr>
													<td>Total Retry Attempted</td>
												</tr>
												<tr>
													<td>Total Retry Successful</td>
												</tr>
												<tr>
													<td>Total Retry Failed</td>
												</tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
												<tr>
													<c:choose>
    													<c:when test="${empty data.total_retry_attmpt}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_retry_attmpt}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_retry_succ}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_retry_succ}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_retry_fail}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_retry_fail}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													


													</table></td>
											</c:forEach>
										</tr>
										

											<tr>
											<td><font color="red">CHURN</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr>
													<td>Voluntary Deactivations</td>
												</tr>
												<tr>
													<td>Involuntary Deactivations</td>
												</tr>
												<tr>
													<td>SMS Churn</td>
												</tr>
												
												<tr>
													<td>USSD Churn</td>
												</tr>
												<tr>
													<td>Total Churn</td>
												</tr>
												
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
												<tr>
													<c:choose>
    													<c:when test="${empty data.voluntary_deactivations}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.voluntary_deactivations}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.involuntary_deactivations}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.involuntary_deactivations}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_sms_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_sms_user}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_ussd_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_ussd_user}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_churn}</td>
    													</c:otherwise>
													</c:choose>
													</tr>													
													</table></td>
													</c:forEach>
													</tr>
									</table>
								</div></td>
						</tr>
					</table>

				</form>
			</body>
</html>
