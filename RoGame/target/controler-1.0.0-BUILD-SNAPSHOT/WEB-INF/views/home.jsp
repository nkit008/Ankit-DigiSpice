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
				function pagerefresh(){
					
					
					window.document.form1.action="${pageContext.request.contextPath}/home?accesspage="+window.document.form1.accessService.value;
				    window.document.form1.method="post";
				    window.document.form1.submit();
					
				}
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
								src="resources/images/logo-ncell22.png" width="200" height="80" /></td>
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
									<div
										style="color: #4a59ad; font-size: 14px; margin: 0px; padding-top: 16px; color: #3d3d3d;">MIS</div>
									<div>....................................................................................................................................................................................................................................................................................</div>
									<div style="color: #c0c0c0; padding-bottom: 0px;"></div>
									<div 
										style="font-size: 12px; padding-top: 32px; padding-bottom: 32px;padding-left: 300px">

<table>
<tr><td>
<p>Service Name :</p></td>



<td>
										
										 <select name="accessService" style="width: 150px" onchange="pagerefresh()" >
										
										 
 
 <c:choose>
 
  <c:when test="${accesspage == 'Lifestyle'}">
   <option value="Lifestyle">Lifestyle</option>
    <option value="Funstore">Funstore</option>
    
  </c:when>
  <c:otherwise>
   <option value="Funstore">Funstore</option>
   <option value="Lifestyle">Lifestyle</option>
  </c:otherwise>
</c:choose>

   
</select> 
</td></tr></table>
</div>


									</div>
									<div>
										<div class="to" style="font-size: 12px;padding-left: 20px" >
											From<input type="text" id="datepicker" name="fromDate"
												style="margin-left: 5px;margin-right: 5px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" />
										</div>
										<div class="from" style="font-size: 12px;padding-right: 30px">
											To <input type="text" id="datepicker2" name="toDate"
												style="margin-right: 5px; padding-right: 5px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" />
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
							<td colspan="3" align="left" valign="top"><div
									style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
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
															<td>${data.reportdate}</td>
														</tr>
							</table>
							</td>
							</c:forEach>				
										</tr>
										<tr>
											<td colspan="3">&nbsp;</td>
										</tr>
										<tr>
											<td><font color="red">BASE</font></td>
											<td valign="top"><table border="1" cellpadding="0"
													cellspacing="0" width="300">
											<tr><td>Total BASE</td></tr>
											<tr><td>Active  Base</td></tr>
											<tr><td>Total Subscription Requests Received</td></tr>
											<tr><td>Total Subscription Requests processed</td></tr>
											<tr><td>Total Gross Adds</td></tr>
											<tr><td>Voluntary Churn</td></tr>
											<tr><td>WAP Mode</td></tr>
											<tr><td>SMS Mode</td></tr>
											<tr><td>USSD Mode</td></tr>
											<tr><td>Involuntary Churn</td></tr>
											<tr><td>Total Churn</td></tr>
											<tr><td>Net Adds</td></tr>

												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td valign="top"><table width="100%" border="1"
														cellpadding="0" cellspacing="0">
													  <tr><td>${data.total_base}</td></tr>
  <tr><td>${data.active_base}</td></tr>
  <tr><td>${data.total_subscription_requests_received}</td></tr>

  <tr><td>${data.total_subscription_requests_processed}</td></tr>
  <tr><td>${data.total_gross_adds}</td></tr>
  <tr><td>${data.voluntary_churn}</td></tr>
  <tr><td>${data.wap_mode}</td></tr>
  <tr><td>${data.sms_mode}</td></tr>
  <tr><td>${data.ussd_mode}</td></tr>
  <tr><td>${data.involuntary_churn}</td></tr>
  <tr><td>${data.total_churn}</td></tr>
  <tr><td>${data.net_adds}</td></tr>
		</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
										<tr>
											<td><font color="red">Revenue</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr><td>Total Revenue</td></tr>
													<tr><td>Subscription Revenue</td></tr>
													<tr><td>Resubscription Revenue</td></tr>
													<tr><td>PPU Revenue</td></tr>

												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													 <tr><td>${data.total_revenue}</td></tr>
  <tr><td>${data.subscription_revenue}</td></tr>
  <tr><td>${data.resubscription_revenue}</td></tr>
  <tr><td>${data.ppu_revenue}</td></tr>
 
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">Hits  & UU</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr><td>Total Page Views</td></tr>
													<tr><td>Total Visits</td></tr>
													<tr><td>Unique Visitors</td></tr>

												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
													<tr><td>${data.total_page_views}</td></tr>
  <tr><td>${data.total_visits}</td></tr>
  <tr><td>${data.unique_visitors}</td></tr>
  
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">Sub/Resub Count</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr><td>Daily Subscription @ NPR 5</td></tr>
													<tr><td>Weekly Subscription @ NPR 20</td></tr>
													<tr><td>Daily Re-Subscription @ NPR 5</td></tr>
													<tr><td>Weekly Re-Subscription @ NPR 20</td></tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
														<tr><td>${data.daily_subscription_npr_5}</td></tr>
  <tr><td>${data.weekly_subscription_npr_20}</td></tr>
  <tr><td>${data.daily_re_subscription_npr_5}</td></tr>
  <tr><td>${data.weekly_re_subscription_npr_20}</td></tr>
  
													</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">PPU Count</font></td>
											<td valign="top"><table border="1" cellpadding="0"
													cellspacing="0" width="300">
													<tr><td>PPU @ 3 NPR</td></tr>
													<tr><td>PPU @ 5 NPR</td></tr>
													<tr><td>PPU @ 20 NPR</td></tr>
												</table></td>

											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
												<tr><td>${data.ppu_3_npr}</td></tr>
  <tr><td>${data.ppu_5_npr}</td></tr>
  <tr><td>${data.ppu_20_npr}</td></tr>
  													</table></td>
											</c:forEach>

										</tr>
										<tr>
											<td><font color="red">Sub Download</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr><td>Total Category Wise Download Request</td></tr>
													<tr><td>Video Request</td></tr>
													<tr><td>Music Request</td></tr>
													<tr><td>Animation Request</td></tr>
													<tr><td>Games Request</td></tr>
													<tr><td>Wallpaper Request</td></tr>
													<tr><td>Total Category Wise Download_Success</td></tr>
													<tr><td>Video Success</td></tr>
													<tr><td>Music Success</td></tr>
													<tr><td>Animation Success</td></tr>
													<tr><td>Games Success</td></tr>
													<tr><td>Wallpaper Success</td></tr>
												</table></td>
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
	<tr><td>${data.sub_total_category_wise_download_request}</td></tr>
  <tr><td>${data.sub_video_request}</td></tr>
  <tr><td>${data.sub_music_request}</td></tr>
  <tr><td>${data.sub_animation_request}</td></tr>
  <tr><td>${data.sub_games_request}</td></tr>
  <tr><td>${data.sub_wallpaper_request}</td></tr>
  <tr><td>${data.sub_total_category_wise_download_success}</td></tr>
  <tr><td>${data.sub_video_success}</td></tr>
  <tr><td>${data.sub_music_success}</td></tr>
  <tr><td>${data.sub_animation_success}</td></tr>
  <tr><td>${data.sub_games_success}</td></tr>
  <tr><td>${data.sub_wallpaper_success}</td></tr>
  												</table></td>
											</c:forEach>
										</tr>
										<tr>
											<td><font color="red">PPU Download</font></td>
											<td><table border="1" cellpadding="0" cellspacing="0"
													width="300">
													<tr><td>Total Category Wise Download Request</td></tr>
													<tr><td>Video Request</td></tr>
													<tr><td>Music Request</td></tr>
													<tr><td>Animation Request</td></tr>
													<tr><td>Games Request</td></tr>
													<tr><td>Wallpaper Request</td></tr>
													<tr><td>Total Category Wise Download_Success</td></tr>
													<tr><td>Video Success</td></tr>
													<tr><td>Music Success</td></tr>
													<tr><td>Animation Success</td></tr>
													<tr><td>Games Success</td></tr>
													<tr><td>Wallpaper Success</td></tr>

												</table></td>
											
											<c:forEach items="${reportdata}" var="data">
												<td><table width="100%" border="1" cellspacing="0"
														cellpadding="0">
														<tr><td>${data.ppu_total_category_wise_download_request}</td></tr>
  <tr><td>${data.ppu_video_request}</td></tr>
  <tr><td>${data.ppu_music_request}</td></tr>
  <tr><td>${data.ppu_animation_request}</td></tr>
  <tr><td>${data.ppu_games_request}</td></tr>
  <tr><td>${data.ppu_wallpaper_request}</td></tr>
  <tr><td>${data.ppu_total_category_wise_download_success}</td></tr>
  <tr><td>${data.ppu_video_success}</td></tr>
  <tr><td>${data.ppu_music_success}</td></tr>
  <tr><td>${data.ppu_animation_success}</td></tr>
  <tr><td>${data.ppu_games_success}</td></tr>
  <tr><td>${data.ppu_wallpaper_success}</td></tr>


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
