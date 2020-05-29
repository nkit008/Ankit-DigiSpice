<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>
<link rel="stylesheet" type="text/css"
	href="resources/stylesheet/style.css" />

<!--styles and js start here for datepicker-->
<link rel="stylesheet" type="text/css" href="resources/css/themes.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.ui.datepicker.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/jquery.ui.core.css" />
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
</head>



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
												<td><select name="accessService" style="width: 150px"
													onchange="pagerefresh()">
											<c:choose>
											<c:when test="${accesspage == 'gamingMis_airtel'}">
												<option value="gamingMis_airtel">Gaming MIS Airtel</option>
												<option value="gamingMis_robi">Gaming MIS Robi</option>
											</c:when>
											<c:otherwise>
												<option value="gamingMis_robi">Gaming MIS Robi</option>
												<option value="gamingMis_airtel">Gaming MIS Airtel</option>
											</c:otherwise>
										</c:choose>


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
													<td>Sub Request @2</td>
												</tr>
												<tr>
													<td>Sub Success @2</td>
												</tr>
												<tr>
													<td>Sub Request @7</td>
												</tr>
												<tr>
													<td>Sub Success @7</td>
												</tr>
												<tr>
													<td>Sub Request @28</td>
												</tr>
												<tr>
													<td>Sub Success @28</td>
												</tr>
												<tr>
													<td>Total New User</td>
												</tr>
												
												<tr>
													<td>SMS User</td>
												</tr>
												<tr>
													<td>Total SMS User</td>
												</tr>
												<tr>
													<td>USSD User</td>
												</tr>
												<tr>
													<td>Total USSD User</td>
												</tr>
												
												<tr>
													<td>Voluntary Churn</td>
												</tr>
												<tr>
													<td>Involuntary Churn</td>
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
												<td valign="top"><table width="100%" border="1"
														cellpadding="0" cellspacing="0">
														<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_succ_200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_succ_200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_700}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_700}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_succ_700}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_succ_700}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_req_2800}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_req_2800}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.sub_succ_2800}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sub_succ_2800}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_new_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_new_user}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.sms_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sms_user}</td>
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
    													<c:when test="${empty data.ussd_user}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.ussd_user}</td>
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
    													<c:when test="${empty data.voluntary_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.voluntary_churn}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.involuntary_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.involuntary_churn}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.sms_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.sms_churn}</td>
    													</c:otherwise>
													</c:choose>
												</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.ussd_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.ussd_churn}</td>
    													</c:otherwise>
													</c:choose>
												</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_churn}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td><%-- ${data.total_churn} --%>78</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													</table>
													</td>
											</c:forEach>
											</tr>
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
										<tr>
											<td><font color="red">Renewal</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Total Renewal @2</td>
												</tr>
												<tr>
													<td>Total Renewal @7</td>
												</tr>
												<tr>
													<td>Total Renewal @28</td>
												</tr>
												<tr>
													<td>Successful Renewal @2</td>
												</tr>
												<tr>
													<td>Successful Renewal @7</td>
												</tr>
												<tr>
													<td>Successful Renewal @28</td>
												</tr>
												<tr>
													<td>Fail Renewal @2</td>
												</tr>
												<tr>
													<td>Fail Renewal @7</td>
												</tr>
												<tr>
													<td>Fail Renewal @28</td>
												</tr>
												<tr>
													<td>Total Successful Renewal Users</td>
												</tr>

												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_renewal_200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_renewal_200}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_renewal_700}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_renewal_700}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_renewal_2800}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_renewal_2800}</td>
    													</c:otherwise>
													</c:choose>
												</tr>
													
													<tr>
												<c:choose>
    													<c:when test="${empty data.succ_renewal_200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_renewal_200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_renewal_700}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_renewal_700}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.succ_renewal_2800}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.succ_renewal_2800}</td>
    													</c:otherwise>
													</c:choose>
												</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_renewal_200}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_renewal_200}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_renewal_700}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_renewal_700}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.fail_renewal_2800}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.fail_renewal_2800}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_succ_renewal_users}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_succ_renewal_users}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>

													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">Revenue</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Total Sub Revenue</td>
												</tr>
												<tr>
													<td>Total Re-sub Revenue</td>
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
    													<c:when test="${empty data.total_sub_revenue}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_sub_revenue}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_resub_revenue}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        												<td>${data.total_resub_revenue}</td>
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
											<td><font color="red">Retry</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Total Retry Request</td>
												</tr>
												<tr>
													<td>Total Retry Successful</td>
												</tr>
												<tr>
													<td>Total Retry Fail</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_retry_req}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_retry_req}</td>
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
											<td><font color="red">PPU</font></td>
											<td valign="top"><table border="1" cellpadding="0"
													cellspacing="0" width="300">
												<tr>
													<td>PPU Request</td>
												</tr>
												<tr>
													<td>PPU Successful</td>
												</tr>
												<tr>
													<td>PPU Fail</td>
												</tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.ppu_req}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.ppu_req}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.ppu_succ}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.ppu_succ}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.ppu_fail}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.ppu_fail}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													</table></td>
											</c:forEach>

										</tr>
										<tr>
											<td><font color="red">Download</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
												<tr>
													<td>Download Request</td>
												</tr>
												<tr>
													<td>Download Successful</td>
												</tr>
												<tr>
													<td>Download Fail</td>
												</tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr>
													<c:choose>
    													<c:when test="${empty data.download_req}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.download_req}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.download_succ}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.download_succ}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.download_fail}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.download_fail}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">Hits & UU</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr>
													<td>Page View</td>
												</tr>
												<tr>
													<td>Unique Visitor</td>
												</tr>
												<tr>
													<td>Total Visitor</td>
												</tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
												<tr>
													<c:choose>
    													<c:when test="${empty data.page_view}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.page_view}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													
													<tr>
													<c:choose>
    													<c:when test="${empty data.unique_visitor}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.unique_visitor}</td>
    													</c:otherwise>
													</c:choose>
													</tr>
													<tr>
													<c:choose>
    													<c:when test="${empty data.total_visitor}">
        													<td>0</td>
    													</c:when>
    													<c:otherwise>
        													<td>${data.total_visitor}</td>
    													</c:otherwise>
													</c:choose>
														
													</tr>


													</table></td>
											</c:forEach>
										</tr>



										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
									</table>
								</div></td>
						</tr>
					</table>

				</form>
			</body>
</html>
