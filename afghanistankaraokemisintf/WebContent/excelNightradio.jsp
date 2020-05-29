<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: arial; font-size: 12px;">

	<div
		style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
		<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
			align="center" width="845" style="padding-bottom: 100px">
			<tr>
				<td colspan="3">MOD Night Pack Revenue MIS</td>
			</tr>
			<tr>
				<td style="width: 300px;"><font color="red">MOD Night
						Pack</font></td>
				<td style="width: 300px;"><font color="red">Date</font></td>
				<td align="left">
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td style="width: 100px;">${map['date_time']}</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td id="1"><font color="red">IVR KPI's</font></td>
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
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td><div style="width: 100px;">${map['ivr_total_calls']}</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_calls_live_callers']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_calls_non_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_total_mous']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_mous_live_callers']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_mous_non_live_callers']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_total_pulses']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata']}">
								<td>${map['ivr_pulses_live_callers']}</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_pulses_NonLive_Callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_ivr_pulses_non_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_total_unique_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_non_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_callers_mtd'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_live_callers_mtd'] }</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<! -- ============================================================================= -->


			<tr>
				<td id="2"><font color="red">OBD KPI's</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Total Outdial Base Uploaded</td>
						</tr>
						<tr>
							<td>Total Outdial Attempted</td>
						</tr>
						<tr>
							<td>Success Outdials</td>
						</tr>
						<tr>
							<td>Call Patched on IVR</td>
						</tr>
						<tr>
							<td>MOU's Via OBD Call Patch</td>
						</tr>
						<tr>
							<td>Pulses Via OBD Call Patch</td>
						</tr>
						<tr>
							<td>Unique Live Callers Via OBD</td>
						</tr>
						<tr>
							<td>Unique Live Caller MTD Via OBD</td>
						</tr>
					</table>
				</td>
				<td>

					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_total_outdial_base_uploaded'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_total_outdial_attempted'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_success_outdials'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_call_patched_on_ivr'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_mous_via_obd_call_patch'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_pulses_via_obd_call_patch'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_unique_live_callers_via_obd'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_unique_live_caller_mtd_via_obd'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

			<tr>
				<td id="3"><font color="red">Total KPI's</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Total MOU's</td>
						</tr>
						<tr>
							<td>Total Live MOU's</td>
						</tr>
						<tr>
							<td>Total Pulses</td>
						</tr>
						<tr>
							<td>Toatl Live Pulses</td>
						</tr>
						<tr>
							<td>Total Unique Callers</td>
						</tr>
						<tr>
							<td>Total Unique Live Callers</td>
						</tr>
						<tr>
							<td>Total Unique Calles (MTD)</td>
						</tr>
						<tr>
							<td>Total Unique Live Callers (MTD)</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style="width: 100px;">${map['ivr_total_mous'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_mous_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_total_pulses'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_pulses_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_total_unique_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_live_callers'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_callers_mtd'] }</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td>${map['ivr_unique_live_callers_mtd'] }</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<! -- ================================================================================ -->

			<tr>
				<td id="4"><font color="red">IVR Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['ivr_gross_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_gross_successful_subscriptions_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_gross_successful_subscriptions_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_gross_successful_subscriptions_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<td id="5"><font color="red">API Gross Ads</font></td>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" width="300">
					<tr>
						<td>Subscription Requests @ 3 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 3 AFN</td>
					</tr>
					<tr>
						<td>Successful Subscriptions @ 2 AFN</td>
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
							<td><div style='width: 100px;'>${map['api_gross_subscription_requests_3_afn'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
							<td><div style='width: 100px;'>${map['api_gross_successful_subscriptions_3_afn'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
							<td><div style='width: 100px;'>${map['api_gross_successful_subscriptions_2_afn'] }</div></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="map" items="${sessionScope['mapdata'] }">
							<td><div style='width: 100px;'>${map['api_gross_successful_subscriptions_1_afn'] }</div></td>
						</c:forEach>
					</tr>
				</table>

			</td>
			</tr>
			<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="6"><font color="red">OBD Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['obd_gross_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_gross_successful_subscriptions_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_gross_successful_subscriptions_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_gross_successful_subscriptions_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="7"><font color="red">CCI Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['cci_gross_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_gross_successful_subscriptions_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_gross_successful_subscriptions_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_gross_successful_subscriptions_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="8"><font color="red">SMS Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['sms_gross_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_gross_successful_subscriptions_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_gross_successful_subscriptions_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_gross_successful_subscriptions_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="9"><font color="red">USSD Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 3 AFN</td>
						</tr>
						<tr>
							<td>Successful Subscriptions @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['ussd_gross_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_gross_successful_subscriptions_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_gross_successful_subscriptions_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['usssd_gross_successful_subscriptions_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

			<!-- ================================================================================ -->
			<tr>
				<td id="10"><font color="red">IVR Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ivr_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

			<tr>
				<td id="11"><font color="red">API Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['api_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['api_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['api_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['api_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

			<tr>
				<td id="12"><font color="red">OBD Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['obd_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="13"><font color="red">CCI Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="14"><font color="red">SMS Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="15"><font color="red">USSD Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Retry Successful @ 1 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>


			<tr>
				<td id="16"><font color="red">Dedication</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Dedication Request @ 2 AFN</td>
						</tr>
						<tr>
							<td>Dedication Successful @ 2 AFN</td>
						</tr>
					</table>
				</td>
				<td>
					<table cellpadding="0" cellspacing="0" border="1">
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['dedication_request_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['dedication_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>


			<tr>
				<td id="17"><font color="red">Total Retry</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Total Subscription Retry @ 3 AFN</td>
						</tr>
						<tr>
							<td>Total Retry Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Total Retry Successful @ 2 AFN</td>
						</tr>
						<tr>
							<td>Total Retry Successful @ 1 AFN</td>
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
								<td><div style='width: 100px;'>${map['total_subscription_retry_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_retry_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_retry_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_retry_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_retry_successful'] }</div></td>
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
				<td id="18"><font color="red">Total Gross Ads</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Total Subscription Request @ 3 AFN</td>
						</tr>
						<tr>
							<td>Total Subscription Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Total Subscription Successful @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['total_subscription_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_subscription_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_subscription_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_subscription_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_subscription_successful'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="19"><font color="red">Renewals</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Renewal Requests @ 3 AFN</td>
						</tr>
						<tr>
							<td>Renewal Successful @ 3 AFN</td>
						</tr>
						<tr>
							<td>Renewal Successful @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['renewal_requests_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_successful_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_successful_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_successful_1_afn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td id="20"><font color="red">Churn</font></td>
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
								<td><div style='width: 100px;'>${map['ivr'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['cci'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['sms'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['ussd'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['others'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['voluntary_churn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['involuntary_churn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_churn'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

			<tr>

				<td id="21"><font color="red">Revenue</font></td>
				<td>
					<table border="1" cellpadding="0" cellspacing="0" width="300">
						<tr>
							<td>Subscription Revenue @ 3 AFN</td>
						</tr>
						<tr>
							<td>Subscription Revenue @ 2 AFN</td>
						</tr>
						<tr>
							<td>Subscription Revenue @ 1 AFN</td>
						</tr>
						<tr>
							<td>Total Subscription Revenue</td>
						</tr>

						<tr>
							<td>Renewal Revenue @ 3 AFN</td>
						</tr>
						<tr>
							<td>Renewal Revenue @ 2 AFN</td>
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
								<td><div style='width: 100px;'>${map['subscription_revenue_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['subscription_revenue_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['subscription_revenue_1_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_subscription_revenue'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_revenue_3_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_revenue_2_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['renewal_revenue_1_afn'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_renewal_revenue'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['total_revenue'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>


			<tr>
				<td id="22"><font color="red">Suscriber Base</font></td>
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
								<td><div style='width: 100px;'>${map['net_additions'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['active_base'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['grace_base'] }</div></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="map" items="${sessionScope['mapdata'] }">
								<td><div style='width: 100px;'>${map['retry_base'] }</div></td>
							</c:forEach>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>

		</table>
	</div>
</body>
</html>