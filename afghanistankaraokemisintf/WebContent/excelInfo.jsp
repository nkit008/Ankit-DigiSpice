<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: arial; font-size: 12px;">

<div style="overflow: scroll;height: 400px; width: 845px;margin: 0px auto;margin-top: 20px;">
	<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="845" style="padding-bottom: 100px" >
				<tr>
			<td colspan="3">Ussd Info Revenue Daily MIS</td>
		</tr>
		<tr>
			<td style="width: 300px;"><font color="red">USSD INFO</font></td>
			<td style="width: 300px;" ><font color="red">Date</font></td>
			<td  align="left">
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['date_time']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	 	<tr> 
			<td> <font color="red">Quotes</font> </td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				<table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_eq']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_eq']}</div></td></c:forEach></tr>
				</table>
			</td>
		</tr> 
		 <tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Jokes</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_ej']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_ej']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		 <tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<td><font color="red">Health Tips</font></td>
		<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
			</table>
			</td>
			<td>
				<table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_eh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_eh']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">Poems</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_ep']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_ep']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">Beauty Tips</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_eb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_eb']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">Cooking</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_ec']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_ec']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		 <tr>
			<td><font color="red">Puzzle</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_epu']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_epu']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Showbiz</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_es']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_es']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		</tr> 
			<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Horoscope</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_eho']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_eho']}</div></td></c:forEach></tr>
			</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Knowledge</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_kk']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_kk']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Breaking News</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_nb']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_nb']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Headlines</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_nh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_nh']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">World News</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_nw']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_nw']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Weather Updates</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_nwe']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_nwe']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Sports News</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_ns']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_ns']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Showbiz News</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_nsh']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_nsh']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Currency</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_fc']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_fc']}</div></td></c:forEach></tr>					
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>

			<td><font color="red">Fuel</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_ff']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_ff']}</div></td></c:forEach></tr>					
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Gold</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_fg']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_fg']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Grocery</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Sub Request @ 15</td></tr>
					<tr><td>Sub Request  @ 5</td></tr>
					<tr><td>Sub Request @ 2</td></tr>
					<tr><td>Sub Success @ 15</td></tr>
					<tr><td>Sub Success @ 5</td></tr>
					<tr><td>Sub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Resub Request @ 15</td></tr>
					<tr><td>Resub Request  @ 5</td></tr>
					<tr><td>Resub Request @ 2</td></tr>
					<tr><td>Resub Success @ 15</td></tr>
					<tr><td>Resub Success @ 5</td></tr>
					<tr><td>Resub Success @ 2</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__15_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__5_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_requests_received__2_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__15_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__5_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['successful_subscriptions__2_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_revenue_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__15_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__5_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['subscription_retry__2_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__15_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__5_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_successfull__2_afn_fgr']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resubscription_revenue_fgr']}</div></td></c:forEach></tr>
				</table> 
			</td>
		</tr>
				<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Total Gross Ads</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Total Subscription Requests @ 15 AFN</td></tr>
					<tr><td>Total Subscription Requests @ 5 AFN</td></tr>
					<tr><td>Total Subscription Requests @ 2 AFN</td></tr>
					<tr><td>Total Subscription Successful  @ 15 AFN</td></tr>
					<tr><td>Total Subscription Successful  @ 5 AFN</td></tr>
					<tr><td>Total Subscription Successful  @ 2 AFN</td></tr>
					<tr><td>Total Subscription Successful</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_requests_15_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_requests_5_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_requests_2_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_successfull_15_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_successfull_5_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_successfull_2_afn']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_subscription_successfull']}</div></td></c:forEach></tr>
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
					<tr><td>Active Base</td></tr>
					<tr><td>Grace Base</td></tr>
					<tr><td>Retry Base</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['active_Base']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['grace_Base']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['retry_base']}</div></td></c:forEach></tr>
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
					<tr><td>CCI</td></tr>
					<tr><td>SMS</td></tr>
					<tr><td>USSD</td></tr>
					<tr><td>Voluntary Churn</td></tr>
					<tr><td>Involuntary Churn</td></tr>
					<tr><td>Total Churn</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td>${map['cci'] }</td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td>${map['sms'] }</td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td>${map['ussd'] }</td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['voluntary_Churn'] }</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td>${map['involuntary_churn'] }</td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td>${map['total_churn'] }</td></c:forEach></tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp</td>
		</tr>
		<tr>
			<td><font color="red">Grand Total</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr><td>Total Sub Request @ 15</td></tr>
					<tr><td>Total Sub Request @ 5</td></tr>
					<tr><td>Total Sub Request @ 2</td></tr>
					<tr><td>Total Sub Success @ 15</td></tr>
					<tr><td>Total Sub Success @ 5</td></tr>
					<tr><td>Total Sub Success @ 2</td></tr>
					<tr><td>Total Resub Request @ 15</td></tr>
					<tr><td>Total Resub Request  @ 5</td></tr>
					<tr><td>Total Resub Request @ 2</td></tr>
					<tr><td>Total Resub Success @ 15</td></tr>
					<tr><td>Total Resub Success @ 5</td></tr>
					<tr><td>Total Resub Success @ 2</td></tr>
					<tr><td>Total Sub Revenue</td></tr>
					<tr><td>Total Resub Revenue</td></tr>
					<tr><td>Total Grand Sub Revenue</td></tr>
					<tr><td>Total Grand Resub Revenue</td></tr>
					<tr><td>Total Revenue</td></tr>
				</table>
			</td>
			<td>
				 <table cellpadding="0" cellspacing="0" border="1">
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_req_rec_15']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_req_rec_5']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_req_rec_2']}</div></td></c:forEach></tr>
				 	
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_suc_15']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_suc_5']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_suc_2']}</div></td></c:forEach></tr>
				 	
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_req_rec_15']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_req_rec_5']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_req_rec_2']}</div></td></c:forEach></tr>
				 	
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_suc_15']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_suc_5']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_suc_2']}</div></td></c:forEach></tr>
				 	
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_sub_revenue']}</div></td></c:forEach></tr>
				 	<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_resub_revenue']}</div></td></c:forEach></tr>
				 	
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_grand_subscription_revenue']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_grand_resubscription_revenue']}</div></td></c:forEach></tr>
					<tr><c:forEach var="map" items="${sessionScope['mapdata'] }"><td><div style= "width: 100px;">${map['total_grand_revenue']}</div></td></c:forEach></tr>					
				</table> 
			</td>
		</tr>
	</table>
</div>
<style>
div#t  table {
    border-collapse: collapse;
}

div#t table td, th {
    border: 1px solid black;
}
</style>
</body>
</html>