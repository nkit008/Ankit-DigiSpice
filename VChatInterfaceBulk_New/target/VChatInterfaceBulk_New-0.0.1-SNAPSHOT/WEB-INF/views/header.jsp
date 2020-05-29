<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8"%>
</head>

<body>
	<!-- header start here -->
	<div class="topbar">
		<div class="container-fluid">
			<!-- LOGO -->
			<!-- <div id="navigation"> -->
				<!-- Navigation Menu-->
				<div class="row">
					<div class="col-3" align="left">
						<a href="/" class="logo-admin"><img
							src="resources/images/awcc_logo.png"></a>
					</div>
					<div class="col-7">
						<p class="text-danger" style="font-size: 20px; font-weight: bold;"
							align="left">AWCC</p>
					</div>
					<div class="col-2" align="right" style="padding-top: 20px;">
						<ul class="list-unstyled topbar-nav">
							<li class="dropdown"><a
								class="nav-link dropdown-toggle waves-effect waves-light nav-user"
								data-toggle="dropdown" href="#" role="button"
								aria-haspopup="false" aria-expanded="false"><img
									src="resources/images/sb.jpg" alt="profile-user"
									class="rounded-circle"> <span
									class="ml-1 nav-user-name hidden-sm">${userObj.userName}<i
										class="mdi mdi-chevron-down"></i></span></a>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="logout"><i
										class="dripicons-exit text-muted mr-2"></i> Logout</a>
								</div></li>
						</ul>
					</div>
				</div>
			<!-- </div> -->
		</div>
		<!-- MENU Start -->
		<div class="navbar-custom-menu" align="center">
			<div class="container-fluid">
				<div id="navigation">
					<!-- Navigation Menu-->
					<ul class="navigation-menu">
						<!-- <li class="has-submenu"><a href="homepage"><i class="mdi mdi-home"></i> Home</a>
            
          				</li> -->
						<li class="has-submenu"><a href="#"><i class="mdi mdi-music-box-outline"></i>SAAZ O AWAAZ</a> 
							<ul class="submenu">
								<li><a href="soAwzUserDetails">User Details</a></li>
								<li><a href="soAwzSingleSubscription">Single Subscription</a></li>
								<li><a href="soAwzBulkSubscription">Bulk Subscription</a></li>
								<li><a href="soAwzSingleUnsubscription">Single Unsubscription</a></li>
            				</ul>
            			</li>
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-gamepad-variant"></i>GAMING PORTAL</a> 
							<ul class="submenu">
								<li><a href="gPtlUserDetails">User Details</a></li>
								<li><a href="gPtlSingleSubscription">Single Subscription</a></li>
								<li><a href="gPtlBulkSubscription">Bulk Subscription</a></li>
								<li><a href="gPtlSingleUnsubscription">Single Unsubscription</a></li>
						</ul></li>

						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-cellphone-link"></i>USSD INFO</a> 
							<ul class="submenu">
								<li><a href="ussdInfoUserDetails">User Details</a></li>
								<li><a href="ussdInfoSingleSubscription">Single Subscription</a></li>
								<li><a href="ussdInfoBulkSubscription">Bulk Subscription</a></li>
								<li><a href="ussdInfoSingleUnsubscription">Single Unsubscription</a></li>
						</ul></li>
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-weather-night"></i>USSD ISLAMIC</a> 
							<ul class="submenu">
								<li><a href="ussdIslamicUserDetails">User Details</a></li>
								<li><a href="ussdIslamicSingleSubscription">Single Subscription</a></li>
								<li><a href="ussdIslamicBulkSubscription">Bulk Subscription</a></li>
								<li><a href="ussdIslamicSingleUnsubscription">Single Unsubscription</a></li>
						</ul></li>
						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-cast"></i>NIGHT RADIO</a> 
							<ul class="submenu">
								<li><a href="ntRadioUserDetails">User Details</a></li>
								<li><a href="ntRadioSingleSubscription">Single Subscription</a></li>
								<li><a href="ntRadioBulkSubscription">Bulk Subscription</a></li>
								<li><a href="ntRadioSingleUnsubscription">Single Unsubscription</a></li>
						</ul></li>

						<li class="has-submenu"><a href="#"><i
								class="mdi mdi-music-note"></i>NAME TUNE</a>
							<ul class="submenu">
								<li><a href="ntuneSearch">Search & Set NameTune</a></li>
								<li><a href="ntuneUserDetails">User Details</a></li>
								<li><a href="ntuneRemove">Remove NameTune</a></li>
						</ul></li>
					</ul>
					<!-- End navigation menu -->
				</div>
				<!-- end navigation -->
			</div>
			<!-- end container-fluid -->
		</div>
		<!-- end navbar-custom -->
	</div>

</body>
</html>