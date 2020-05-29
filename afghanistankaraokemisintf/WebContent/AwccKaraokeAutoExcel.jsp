<%@page import="com.spice.bean.AwccMisBean"%>
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
        response.setHeader("Content-disposition", "inline; filename=Awcckaraoke_MIS_" + myDate + ".xls");
        AwccMisBean rmb = new AwccMisBean();
        
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
			<td colspan="3">&nbsp;</td>
		</tr>
	 	<tr> 
			<td> <font color="red">IVR KPI's</font> </td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Calls</td>
					</tr>
					<tr>
						<td>Calls - Live Callers</td>
					</tr>
					<tr>
						<td>Calls - Non Live Callers</td>
					</tr>
					<tr>
						<td>Total MOUs</td>
					</tr>
					<tr>
						<td>MOUs - Live Callers</td>
					</tr>
					<tr>
						<td>MOUs - Non Live Callers</td>
					</tr>
					<tr>
						<td>Total Pulses</td>
					</tr>
					<tr>
						<td>Pulses - Live callers</td>
					</tr>
					<tr>
						<td>Pulses - Non Live Callers</td>
					</tr>
					<tr>
						<td>Total Unique Callers</td>
					</tr>
					<tr>
						<td>Unique Live Callers</td>
					</tr>
					<tr>
						<td>Unique Non Live Callers</td>
					</tr>
					<tr>
						<td>Unique Callers MTD</td>
					</tr>
					<tr>
						<td>Unique Live Callers MTD</td>
					</tr>
				</table>
			</td>
			<td>
				<table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['ivr_totalCalls'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_calls_Live_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td >${map['ivr_calls_NonLive_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_total_MOU'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_mou_Live_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_mou_NonLive_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_total_Pulses'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td >${map['ivr_pulses_Live_callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_pulses_NonLive_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_total_Unique_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_unique_Live_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_unique_NonLive_Callers'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_unique_Callers_mtd'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ivr_unique_Live_Callers_mtd'] }</td>
						</c:forEach>
					</tr>
				</table>
			</td>
		</tr> 
		 <tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">IVR Gross Ads</font></td>
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
						<td><div style= "width: 100px;">${map['ISubscription_Requests_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
				<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISuccessful_Subscriptions_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ISuccessful_Subscriptions_1_AFN'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		 <tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<td><font color="red">API Gross Ads</font></td>
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
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">OBD Gross Ads</font></td>
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
						<td>${map['OSubscription_Requests_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['OSuccessful_Subscriptions_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['OSuccessful_Subscriptions_1_AFN'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">CCI Gross Ads</font></td>
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
						<td>${map['CSubscription_Requests_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['CSuccessful_Subscriptions_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['CSuccessful_Subscriptions_1_AFN'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">SMS Gross Ads</font></td>
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
						<td>${map['SSubscription_Requests_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['SSuccessful_Subscriptions_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['SSuccessful_Subscriptions_1_AFN'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">USSD Gross Ads</font></td>
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
						<td>${map['USubscription_Requests_80_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USubscription_Requests_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USubscription_Requests_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['USuccessful_Subscriptions_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USuccessful_Subscriptions_20_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USuccessful_Subscriptions_5_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USuccessful_Subscriptions_3_AFN'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['USuccessful_Subscriptions_1_AFN'] }</td>
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
						<td>IVR</td>
					</tr>
					<tr>
						<td>CCI</td>
					</tr>
					<tr>
						<td>SMS</td>
					</tr>
					<tr>
						<td>USSD</td>
					</tr>
					<tr>
						<td>Youth pack API</td>
					</tr>
					<tr>
						<td>Others</td>
					</tr>
					<tr>
						<td>Voluntary Churn</td>
					</tr>
					<tr>
						<td>Involuntary Churn</td>
					</tr>
					<tr>
						<td>Total Churn</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['ivr'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['cci'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['sms'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['ussd'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['youth'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['others'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['voluntary_Churn'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['involuntary_churn'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_churn'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Song Dedication</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Song Dedication Request @ 10 AFN</td>
					</tr>
					<tr>
						<td>Song Dedication Successful @ 10 AFN</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['song_dedication_request_5'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['song_dedication_successful'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">CRBT</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Set CRBT Request</td>
					</tr>
					<tr>
						<td>Set CRBT Successful</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['crbt_request_received'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['successful_CRBT_Count'] }</div></td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Top Up </font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Top-Up Requests @ 80 AFN</td>
					</tr>
					<tr>
						<td>Top-Up Requests @ 20 AFN</td>
					</tr>
					<tr>
						<td>Top-Up Requests @ 5 AFN</td>
					</tr>
					<tr>
						<td>Top Up Successful @ 80 AFN</td>
					</tr>
					<tr>
						<td>Top Up Successful @ 20 AFN</td>
					</tr>
					<tr>
						<td>Top Up Successful @ 5 AFN</td>
					</tr>
					<tr>
						<td>Top Up Successful @ 3 AFN</td>
					</tr>
					<tr>
						<td>Top Up Successful @ 1 AFN</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_requests_80'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_requests_20'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_requests_5'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_successful_80'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_successful_20'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_successful_5'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_successful_3'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['top_up_successful_1'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Recording</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Recordings</td>
					</tr>
					<tr>
						<td>Unique Recorders</td>
					</tr>
					<tr>
						<td>No of Recordings Authorized</td>
					</tr>
					<tr>
						<td>Total Un-authorized recordings</td>
					</tr>
					<tr>
						<td>No of Content Shared to Users</td>
					</tr>
					<tr>
						<td>Total Likes</td>
					</tr>
					<tr>
						<td>Recording Per Users</td>
					</tr>
					<tr>
						<td>Likes/ recording</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_recordings'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['unique_recorders'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['no_of_recordings_authorized'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_un_authorized_recordings'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['no_of_content_shared_to_users'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_likes'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['recording_per_users'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['likes_recording'] }</div></td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Songs</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Recordings- Songs</td>
					</tr>
					<tr>
						<td>Total Songs Authorised</td>
					</tr>
					<tr>
						<td>Total Songs Not Authorised</td>
					</tr>
					<tr>
						<td>Total Likes on Songs</td>
					</tr>
					<tr>
						<td>Total calls on Songs DAC</td>
					</tr>
					<tr>
						<td>Songs Abuse Reported</td>
					</tr>
					<tr>
						<td>Total number of Songs shared (Dedication)</td>
					</tr> 
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_recordings_songs_s'] }</div></td>
						</c:forEach>
					</tr>
					 <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_songs_authorised_s'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_songs_not_authorised_s'] }</div></td>
						</c:forEach>
					</tr>
					 <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_likes_on_songs_s'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_calls_on_songs_dac_s'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['songs_abuse_reported_s'] }</div></td>
						</c:forEach>
					</tr>
					 <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_number_of_songs_shared_dedication_s'] }</td>
						</c:forEach>
					</tr> 
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Funny Voice</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Total Recordings- Songs</td>
					</tr>
					<tr>
						<td>Total Songs Authorised</td>
					</tr>
					<tr>
						<td>Total Songs Not Authorised</td>
					</tr>
					<tr>
						<td>Total Likes on Songs</td>
					</tr>
					<tr>
						<td>Total calls on Songs DAC</td>
					</tr>
					<tr>
						<td>Songs Abuse Reported</td>
					</tr>
					<tr>
						<td>Total number of Songs shared (Dedication)</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_recordings_songs_f'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_songs_authorised_f'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_songs_not_authorised_f'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_likes_on_songs_f'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_calls_on_songs_dac_f'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['songs_abuse_reported_f'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['total_number_of_songs_shared_dedication_f'] }</td>
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
						<td>Top-Up Revenue @ 80 AFN</td>
					</tr>
					<tr>
						<td>Top-Up Revenue @ 20 AFN</td>
					</tr>
					<tr>
						<td>Top-Up Revenue @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Top-Up Revenue</td>
					</tr>
					<tr>
						<td>Song Dedication Revenue</td>
					</tr>
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
<!-- 					<tr>
						<td>Service Gift Revenue @ 80 AFN</td>
					</tr>
					<tr>
						<td>Service Gift Revenue @ 20 AFN</td>
					</tr>
					<tr>
						<td>Service Gift Revenue @ 5 AFN</td>
					</tr>
					<tr>
						<td>Total Service Gift Revenue</td>
					</tr> -->
					<tr>
						<td>Total Revenue</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Top_Up_Revenue_80_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Top_Up_Revenue_20_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['Top_Up_Revenue_5_AFN'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['Total_Top_Up_Revenue'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['song_dedication_revenue'] }</td>
						</c:forEach>
					</tr>
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
 					<%-- <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['gifted_Request_revenue_80'] }</td>
						</c:forEach>
					</tr> 
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['gifted_Request_revenue_20'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['gifted_Request_revenue_5'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['total_gifted_Request_revenue'] }</div></td>
						</c:forEach>
					</tr> --%>
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
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">AON-Active Base</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>0-30 days</td>
					</tr>
					<tr>
						<td>31-90 days</td>
					</tr>
					<tr>
						<td>91-180 days</td>
					</tr>
					<tr>
						<td>180-365 days</td>
					</tr>
					<tr>
						<td>>365 days</td>
					</tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['aon_activebase0_30_days'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_activebase31_90_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_activebase91_180_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_activebase180_365_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_activebase365_days'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">AON-Churn Base</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>0-10 days</td>
					</tr>
					<tr>
						<td>11-30 days</td>
					</tr>
					<tr>
						<td>31-60 days</td>
					</tr>
					<tr>
						<td>61-90 days</td>
					</tr>
					<tr>
						<td>>91 days</td>
					</tr>
					
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['aon_churnbase0_10_days'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_churnbase11_30_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_churnbase31_60_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_churnbase61_90_days'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['aon_churnbase91_days'] }</td>
						</c:forEach>
					</tr>
					
					
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">MOU Bucketing</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>0 Mins</td>
					</tr>
					<tr>
						<td>0-2 Mins</td>
					</tr>
					<tr>
						<td>3-5 Mins</td>
					</tr>
					<tr>
						<td>6-10 Mins</td>
					</tr>
					<tr>
						<td>11-20 Mins</td>
					</tr>
					<tr>
						<td>16-25 Mins</td>
					</tr>
					<tr>
						<td>26-50 Mins</td>
					</tr>
					<tr>
						<td>>51 Mins</td>
					</tr>
					
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['mou_bucket0_Mins'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket0_2_Mins'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket3_5_Mins'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket6_10_Mins'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket11_15_Min'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket16_25_Mins'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket26_50_Mins'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['mou_bucket51_Mins'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Business Analysis</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>ARPU</td>
					</tr>
					<tr>
						<td>Calls Per Unique User</td>
					</tr>
					<tr>
						<td>Calls Per Unique Live User</td>
					</tr>
					<tr>
						<td>MOU's Per Unique User</td>
					</tr>
					<tr>
						<td>MoU's Per Unique Live User</td>
					</tr>
					<tr>
						<td>Mou's Per Calls</td>
					</tr>
					<tr>
						<td>Pluses Per Unique User</td>
					</tr>
					<tr>
						<td>Pulses Per Unique Live User</td>
					</tr>
					<tr>
						<td>Pulses Per Call</td>
					</tr>
					
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
				 <tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['arpu'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td><div style= "width: 100px;">${map['arpu_Calls_per_Unique_User'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_Calls_Per_Unique_Live_User'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_MOU_Per_Unique_User'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_MOU_Per_Unique_Live_User'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_MOU_Per_Call'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_Pulses_Per_Unique_User'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_Pulses_per_Unique_Live_User'] }</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
						<td>${map['arpu_Pulse_Per_Call'] }</td>
						</c:forEach>
					</tr>
				</table> 
			</td>
		</tr>
	</table>
</div>
</body>
</html>