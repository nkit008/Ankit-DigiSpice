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
				<p style="background-color:#79797c;color:#fff;text-align:center;font-weight:bold;font-size: 18px;padding: 16px;">Zamtel Games MIS</p>
	
									<div style="clear: both; padding-top: 42px;" align="center">
									<a href="reportxlsZemtalGames" class="export">Export to Excel</a><img
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
			<th class="tg-c3ow">MIS</th>
			<th class="tg-c3ow">Description/Date</th>
		<c:forEach items="${reportdata}" var="data">
			<th>${data.sDate}</th>
	</c:forEach>
			
	</tr>

<tr>
    <th class="tg-c3ow" rowspan="16" style="background-color:#f73b43;">Base</th>
    <td class="tg-0pky">Total BASE</td>
<c:forEach items="${reportdata}" var="data">
 					<c:choose>
				<c:when test="${empty data.totalBase}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalBase}</td>
				</c:otherwise>
			</c:choose>		
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Active  Base</td>
 <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.activeBase}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.activeBase}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Total Subscription Requests Received</td>
    <c:forEach items="${reportdata}" var="data">
    		<c:choose>
				<c:when test="${empty data.totalSubscriptionRequestsReceived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalSubscriptionRequestsReceived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>		
			
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Total second consent received</td>
    <c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.totalSecondConsentReceived}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalSecondConsentReceived}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Total Request Process(WAP)</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.totalRequestProcessWAP}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalRequestProcessWAP}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Total Request Process (SMS)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalRequestProcessSMS}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalRequestProcessSMS}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr>
    <td class="tg-0pky">Total Request Process (USSD)</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalRequestProcessUSSD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalRequestProcessUSSD}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Subscription Requests processed</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalSubscriptionRequestsProcessed}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalSubscriptionRequestsProcessed}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Gross Adds</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalGrossAdds}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalGrossAdds}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Voluntary Churn</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.voluntaryChurn}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.voluntaryChurn}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">WAP Mode</td>
<c:forEach items="${reportdata}" var="data">
		 			<c:choose>
				<c:when test="${empty data.wapMode}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.wapMode}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">SMS Mode</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.smsMode}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.smsMode}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr> 
  
  <tr>
    <td class="tg-0pky">USSD Mode</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.ussdMode}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.ussdMode}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Involuntary Churn</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.involuntaryChurn}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.involuntaryChurn}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Churn</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalChurn}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalChurn}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr>
    <td class="tg-0pky">Net Adds</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.netAdds}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.netAdds}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  
  
  <tr style="background-color:#e5e3e3;">
    <th class="tg-c3ow" rowspan="6" style="background-color:#e5e3e3;text-align:center;">Revenue</th>
    <td class="tg-0pky">Total Revenue in ZK</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalRevenueInZK}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalRevenueInZK}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Subscription Revenue</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subscriptionRevenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subscriptionRevenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Resubscription Revenue</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.resubscriptionRevenue}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.resubscriptionRevenue}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
    <td class="tg-0pky">Sub Revenue from SMS</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subRevenueFromSMS}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subRevenueFromSMS}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
  <tr>
    <td class="tg-0pky">Sub Revenue from WAP</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subRevenueFromWAP}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subRevenueFromWAP}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
 </tr>
 
<tr>
<td class="tg-0pky">Sub Revenue from USSD</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.subRevenueFromUSSD}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.subRevenueFromUSSD}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
<th class="tg-c3ow" rowspan="3" style="background-color:#e5e3e3;text-align:center;">Hits  & UU</th>
<td class="tg-0pky">Total Page Views</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalPageViews}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalPageViews}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
</tr>

<tr>
    <td class="tg-0pky">Total Visits</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.totalVisits}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalVisits}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
<td class="tg-0pky">Unique Visitors</td>
<c:forEach items="${reportdata}" var="data">
			<c:choose>
				<c:when test="${empty data.uniqueVisitors}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.uniqueVisitors}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
<tr>
<th class="tg-c3ow" rowspan="6" style="background-color:#e5e3e3;text-align:center;">Sub/Resub Count</th>
 <td class="tg-0pky">Daily Subscription @ ZK 0.25</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.dailySubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.dailySubscription}</td>
				</c:otherwise>
			</c:choose>
</c:forEach>
  </tr>

  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Weekly Subscription @ ZK 1.50</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weeklySubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weeklySubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Monthly Subscription @ ZK 4.50</td>
			<c:forEach items="${reportdata}" var="data">
		<c:choose>
				<c:when test="${empty data.monthlySubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthlySubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Daily Re-Subscription @ ZK 0.25</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.dailyReSubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.dailyReSubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Weekly Re-Subscription @ ZK 1.50</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.weeklyReSubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.weeklyReSubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Monthly Re-Subscription @ ZK 4.50</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.monthlyReSubscription}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.monthlyReSubscription}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  <tr>
    <th class="tg-0pky" rowspan="6">Sub Download</th>
    <td class="tg-0pky">Total Category Wise Download Request</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalCategoryWiseDownloadRequest}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalCategoryWiseDownloadRequest}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
</tr>
	<tr>
   <td class="tg-0pky">Android Games Request</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.androidGamesRequest}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.androidGamesRequest}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">HTML5 Games Request</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.HTML5GamesRequest}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.HTML5GamesRequest}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
   
 
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Total Category Wise Download_Success</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.totalCategoryWiseDownloadSuccess}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.totalCategoryWiseDownloadSuccess}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
 
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">Android Games Success</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.androidGamesSuccess}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.androidGamesSuccess}</td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
  </tr>
  
 <tr style="background-color:#e5e3e3;">
    <td class="tg-0pky">HTML5 Games Success</td>
<c:forEach items="${reportdata}" var="data">
					<c:choose>
				<c:when test="${empty data.html5GamesSuccess}">
					<td>0</td>
				</c:when>
				<c:otherwise>
					<td>${data.html5GamesSuccess}</td>
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
					window.location.href=getContextPath()+"/zamtelGamesMISAction";
					
				}
				</script>
			</body>
			
</html>
