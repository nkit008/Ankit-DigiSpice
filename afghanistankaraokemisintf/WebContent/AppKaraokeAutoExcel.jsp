<%@page import="com.spice.bean.KaraokeMisBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String start = "", end = "";
    ArrayList<HashMap<String, String>> arrList = null;
    SimpleDateFormat sdfto = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    
    try {

            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -1);
            end = sdfto.format(c.getTime());
            
            start = "01"+end.substring(2);
            
                    
        System.out.println("start :: " + start + " AND ::  " + end);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String myDate = sdf1.format(calendar.getTime());
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "inline; filename=AwccKaraoke_APP_MIS_" + myDate + ".xls");
        
        KaraokeMisBean rmb = new KaraokeMisBean();
        Map[] resultMap = rmb.GetData(start, end);
        session.setAttribute("mapdata", resultMap);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: arial; font-size: 12px;">

<div style="overflow: scroll;height: 400px; width: 845px;margin: 0px auto;margin-top: 20px;">
	<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="845" style="padding-bottom: 100px" >
		<!-- <tr>
			<td colspan="3">
				<a href="download.jsp"> Export To Excel </a>
			</td>
		</tr> -->
		<tr>
			<td colspan="3">Karaoke Revenue Daily MIS</td>
		</tr>
		<tr>
			<td style="width: 300px;"><font color="red">KARAOKE</font></td>
			<td style="width: 300px;" ><font color="red">Date</font></td>
			<td  align="left">
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
					<c:forEach var="map" items="${sessionScope['mapdata']}">
						<td style="width: 100px;font-weight: bold;">${map['date_time']}</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		 <tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<td><font color="red">APP Gross Ads</font></td>
		<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Subscription Requests @ 80 AFN</td>
					</tr>
					<tr>
						<td>Subscription Requests @ 20 AFN</td>
					</tr>
					<tr>
						<td>Subscription Requests @ 5 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 80 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 20 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 5 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 3 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 1 AFN</td>
					</tr>
			</table>
			</td>
			<td>
		<table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['ASubscription_Requests_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['ASuccessful_Subscriptions_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
										<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ASuccessful_Subscriptions_1_AFN'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Total Retry</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Subscription Retry @ 80 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Retry  @ 20 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Retry @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful  @ 80 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful  @ 20 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful  @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful  @ 3 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful  @ 1 AFN</td>
					</tr>
					<tr>
						<td>Total Retry Successful</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Retry_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Retry_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Retry_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Retry_Successful_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Retry_Successful_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Retry_Successful_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Retry_Successful_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Retry_Successful_1_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Retry_Successful'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Total Gross Ads</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Subscription Requests @ 80 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Requests @ 20 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Requests @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful  @ 80 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful @ 20 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful @ 3 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful @ 1 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Successful</td>
					</tr>
					
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Total_Subscription_Requests_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Successful_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Successful_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Successful_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Successful_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Successful_1_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Total_Subscription_Successful'] }</div></td>
						</c:forEach>
					</tr>
			</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Renewals</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Renewal Requests @ 80 AFN</td>
					</tr>
					<tr>
						<td>Renewal Requests @ 20 AFN</td>
					</tr>
					<tr>
						<td>Renewal Requests @ 5 AFN</td>
					</tr>
					<tr>
						<td>Renewal Successful @ 80 AFN</td>
					</tr>
					<tr>
						<td>Renewal Successful @ 20 AFN</td>
					</tr>
					<tr>
						<td>Renewal Successful @ 5 AFN</td>
					</tr>
					<tr>
						<td>Renewal Successful @ 3 AFN</td>
					</tr>
					<tr>
						<td>Renewal Successful @ 1 AFN</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Requests_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Renewal_Requests_5_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Successful_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Successful_20_AFN'] }</td>
						</c:forEach>
					</tr>
 					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Successful_5_AFN'] }</td>
						</c:forEach>
					</tr> 
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Successful_3_AFN'] }</td>
						</c:forEach>
					</tr>
 					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Successful_1_AFN'] }</td>
						</c:forEach>
					</tr> 
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Churn</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>APP</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['app'] }</div></td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>

			<td><font color="red">Revenue</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Subscription Revenue @ 80 AFN</td>
					</tr>
					<tr>
						<td>Subscription Revenue @ 20 AFN</td>
					</tr>
					<tr>
						<td>Subscription Revenue @ 5 AFN</td>
					</tr>
					<tr>
						<td>Subscription Revenue @ 3 AFN</td>
					</tr>
					<tr>
						<td>Subscription Revenue @ 1 AFN</td>
					</tr>
					<tr>
						<td>Total Subscription Revenue</td>
					</tr>
					<tr>
						<td>Renewal Revenue @ 80 AFN</td>
					</tr>
					<tr>
						<td>Renewal Revenue @ 20 AFN</td>
					</tr>
					<tr>
						<td>Renewal Revenue @ 5 AFN</td>
					</tr>
					<tr>
						<td>Renewal Revenue @ 3 AFN</td>
					</tr>
					<tr>
						<td>Renewal Revenue @ 1 AFN</td>
					</tr>
					<tr>
						<td>Total Renewal Revenue</td>
					</tr>
					<tr>
						<td>Total Revenue</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					 <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Revenue_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Revenue_20_AFN'] }</td>
						</c:forEach>
					</tr> 
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Subscription_Revenue_5_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Subscription_Revenue_3_AFN'] }</td>
						</c:forEach>
					</tr> 
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Subscription_Revenue_1_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Subscription_Revenue'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Revenue_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Revenue_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Revenue_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Revenue_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Renewal_Revenue_1_AFN'] }</td>
						</c:forEach>
					</tr>
							<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Total_Renewal_Revenue'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_revenue'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Subscriber Base</font></td>
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
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['net_Additions'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['active_Base'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['grace_Base'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['retry_base'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
	</table>
</div>
</body>
</html>