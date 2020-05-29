<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MIS</title>
</head>
<body style="font-family: 'Poppins', sans-serif; font-size: 14px;">

	<table width="845" border="0" cellpadding="0" cellspacing="0"
		align="center">



		<tr>
			<td colspan="3" align="left" valign="top" class="mid">

				<div id="login-wrapper" style="width: 100%; margin-left: 12px;">
					<p
						style="background-color: #79797c; color: #fff; text-align: center; font-weight: bold; font-size: 18px; padding: 16px;">Zamtel
						Beatz MIS</p>

					<div style="clear: both; padding-top: 42px;" align="center">
						<a href="reportxlsZemtalBeats" class="export">Export to Excel</a><img
							src="resources/mis/images/excel.jpg" style="padding-left: 7px;"
							align="absmiddle" />
						<button onclick="goBack()"
							style="float: right; margin-top: -10px; font-weight: bold; background-color: #f73b43; padding: 12px; color: #fff; font-size: 14px;">Back</button>
					</div>

				</div>
			</td>
		</tr>
	</table>
	<div
		style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">

		<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
			align="center" width="1200" style="padding-bottom: 0px">

			<tr style="background-color: #f73b43; color: #ffffff;">
				<th class="tg-c3ow">MIS</th>
				<th class="tg-c3ow">Description/Date</th>
				<c:forEach items="${reportdata}" var="data">
					<th>${data.sDate}</th>
				</c:forEach>

			</tr>

			<tr>
				<th class="tg-c3ow" rowspan="3" style="background-color: #f73b43;">Visitors</th>
				<td class="tg-0pky">Non-Subscribed</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NON_SUB_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NON_SUB_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Subscribed</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Total Visitor</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.TOTAL_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.TOTAL_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			

			<tr>
				<th class="tg-c3ow" rowspan="3" style="background-color: #f73b43;">Unique
					Visitors</th>
				<td class="tg-0pky">Non-Subscribed</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NON_SUB_UNIQ_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NON_SUB_UNIQ_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Subscribed</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_UNIQ_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_UNIQ_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</tr>
			
			
			<tr>
				<td class="tg-0pky">Unique Visitor</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.UNIQ_VISITOR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.UNIQ_VISITOR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</tr>			

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky" colspan="2">New Registration</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_REG}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_REG}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky" colspan="2">TSLs (Subscribed User) Mins</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_USER_MIN}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_USER_MIN}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<th class="tg-c3ow" rowspan="4" style="background-color: #f73b43;">New
					subscription requests Music Streaming</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MONTHLY_SUB_MUSIC}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MONTHLY_SUB_MUSIC}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.WEEKLY_SUB_MUSIC}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.WEEKLY_SUB_MUSIC}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.DAILY_SUB_MUSIC}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.DAILY_SUB_MUSIC}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">Free Trail</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.FREE_TRIAL_MUSIC}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.FREE_TRIAL_MUSIC}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<th class="tg-c3ow" rowspan="4" style="background-color: #f73b43;">New
					subscription requests Karaoke</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MONTHLY_SUB_KARAOKE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MONTHLY_SUB_KARAOKE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.WEEKLY_SUB_KARAOKE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.WEEKLY_SUB_KARAOKE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.DAILY_SUB_KARAOKE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.DAILY_SUB_KARAOKE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">Free Trail</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.FREE_TRIAL_KARAOKE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.FREE_TRIAL_KARAOKE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<th class="tg-c3ow" rowspan="4" style="background-color: #f73b43;">New
					subscription requests Music+Karaoke Bundle</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MONTHLY_SUB_BUNDLE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MONTHLY_SUB_BUNDLE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.WEEKLY_SUB_BUNDLE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.WEEKLY_SUB_BUNDLE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.DAILY_SUB_BUNDLE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.DAILY_SUB_BUNDLE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">Free Trail</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.FREE_TRIAL_BUNDLE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.FREE_TRIAL_BUNDLE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>



			<tr style="background-color: #e5e3e3;">
				<th class="tg-c3ow" rowspan="9"
					style="background-color: #e5e3e3; text-align: center;">Mode of
					Subscription Request</th>
				<td class="tg-0pky">IVR</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_IVR}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_IVR}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">SMS</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_SMS}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_SMS}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">WEB</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_WEB}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_WEB}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">3rd Party</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_TPARTY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_TPARTY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">USSD</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_USSD}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_USSD}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Android</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_ANDROID}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_ANDROID}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">I-Phone</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_IPHONE}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_IPHONE}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">APP</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_APP}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_APP}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Others</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MODE_OTHERS}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MODE_OTHERS}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">New
					subscription on Music Streaming</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_MUSIC_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_MUSIC_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_MUSIC_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_MUSIC_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_MUSIC_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_MUSIC_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">New
					subscription on Karaoke</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_KARAOKE_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_KARAOKE_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_KARAOKE_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_KARAOKE_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_KARAOKE_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_KARAOKE_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">New
					subscription on Music+Karaoke Bundle</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_BUNDLE_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_BUNDLE_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_BUNDLE_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_BUNDLE_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.NEW_SUB_BUNDLE_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.NEW_SUB_BUNDLE_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Subscription
					Fail on Music</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MUSIC_FAIL_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MUSIC_FAIL_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MUSIC_FAIL_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MUSIC_FAIL_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_MUSIC_FAIL_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_MUSIC_FAIL_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Subscription
					Fail on Karaoke</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_KARAOKE_FAIL_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_KARAOKE_FAIL_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_KARAOKE_FAIL_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_KARAOKE_FAIL_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_KARAOKE_FAIL_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_KARAOKE_FAIL_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Subscription
					Fail on Bundle</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_BUNDLE_FAIL_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_BUNDLE_FAIL_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_BUNDLE_FAIL_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_BUNDLE_FAIL_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.SUB_BUNDLE_FAIL_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.SUB_BUNDLE_FAIL_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="2"
					style="background-color: #e5e3e3; text-align: center;">Un-Subscription
					Request</th>
				<td class="tg-0pky">Un-Subscribe by User</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.VOL_CHURN}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.VOL_CHURN}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Un-Subscribe by System</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.INVOL_CHURN}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.INVOL_CHURN}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Re-Subscription/Renewal
					on Music</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_MUSIC_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_MUSIC_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_MUSIC_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_MUSIC_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_MUSIC_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_MUSIC_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Re-Subscription/Renewal
					on Karaoke</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_KARAOKE_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_KARAOKE_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_KARAOKE_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_KARAOKE_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_KARAOKE_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_KARAOKE_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="3"
					style="background-color: #e5e3e3; text-align: center;">Re-Subscription/Renewal
					on Bundle</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_BUNDLE_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_BUNDLE_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_BUNDLE_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_BUNDLE_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.RESUB_BUNDLE_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.RESUB_BUNDLE_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="5"
					style="background-color: #e5e3e3; text-align: center;">Revenue
					on Music</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MUSIC_REV_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MUSIC_REV_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MUSIC_REV_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MUSIC_REV_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MUSIC_REV_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MUSIC_REV_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Total Gross Revenue (In Local Currency)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MUSIC_REV_LOCAL}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MUSIC_REV_LOCAL}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Total Gross Revenue (In USD) (1USD=14.63 K)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.MUSIC_REV_USD}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.MUSIC_REV_USD}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="5"
					style="background-color: #e5e3e3; text-align: center;">Revenue
					on Karaoke</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.KARAOKE_REV_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.KARAOKE_REV_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.KARAOKE_REV_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.KARAOKE_REV_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.KARAOKE_REV_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.KARAOKE_REV_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Total Gross Revenue (In Local Currency)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.KARAOKE_REV_LOCAL}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.KARAOKE_REV_LOCAL}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Total Gross Revenue (In USD) (1USD=14.63 K)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.KARAOKE_REV_USD}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.KARAOKE_REV_USD}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="5"
					style="background-color: #e5e3e3; text-align: center;">Revenue
					on Bundle</th>
				<td class="tg-0pky">Monthly Subscriptions (@K40)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.BUNDLE_REV_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.BUNDLE_REV_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Weekly Subscriptions (@K12)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.BUNDLE_REV_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.BUNDLE_REV_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td class="tg-0pky">Daily Subscriptions (@K2)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.BUNDLE_REV_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.BUNDLE_REV_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">Total Gross Revenue (In Local Currency)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.BUNDLE_REV_LOCAL}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.BUNDLE_REV_LOCAL}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Total Gross Revenue (In USD) (1USD=14.63 K)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.BUNDLE_REV_USD}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.BUNDLE_REV_USD}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>



			<tr>
				<th class="tg-c3ow" rowspan="2"
					style="background-color: #e5e3e3; text-align: center;">Total
					Rev of all packs</th>
				<td class="tg-0pky">Total Gross Revenue (In Local Currency)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.TOTAL_REV_LOCAL}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.TOTAL_REV_LOCAL}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Total Gross Revenue (In USD) (1USD=14.63 K)</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.TOTAL_REV_USD}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.TOTAL_REV_USD}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<th class="tg-c3ow" rowspan="4"
					style="background-color: #e5e3e3; text-align: center;">Active
					Subscriber Base</th>
				<td class="tg-0pky">30 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.ACTIVE_SUB_MONTHLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.ACTIVE_SUB_MONTHLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<td class="tg-0pky">7 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.ACTIVE_SUB_WEEKLY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.ACTIVE_SUB_WEEKLY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">1 Day</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.ACTIVE_SUB_DAILY}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.ACTIVE_SUB_DAILY}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td class="tg-0pky">Total Active Base</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.ACTIVE_SUB_TOTAL}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.ACTIVE_SUB_TOTAL}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>


			<tr>
				<th class="tg-c3ow" rowspan="6"
					style="background-color: #e5e3e3; text-align: center;">Grace
					Ageing</th>
				<td class="tg-0pky">1-7 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_1TO7}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_1TO7}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">8-14 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_8TO14}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_8TO14}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">15-29 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_15TO29}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_15TO29}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">30-44 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_30TO44}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_30TO44}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">45-60 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_45TO60}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_45TO60}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr style="background-color: #e5e3e3;">
				<td class="tg-0pky">Above 60 Days</td>
				<c:forEach items="${reportdata}" var="data">
					<c:choose>
						<c:when test="${empty data.GRACE_ABOVE60}">
							<td>0</td>
						</c:when>
						<c:otherwise>
							<td>${data.GRACE_ABOVE60}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</table>
	</div>
	<script>
		function getContextPath() {
			return window.location.pathname.substring(0,
					window.location.pathname.indexOf("/", 2));
		}

		function goBack() {
			event.preventDefault();
			window.location.href = getContextPath() + "/zemtalBeatsMIShome";

		}
	</script>
</body>

</html>
