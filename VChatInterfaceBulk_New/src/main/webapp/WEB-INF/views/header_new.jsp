<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8"%>
</head>

<body>
	<!-- header start here -->
	<div class="topbar">
		<div class="topbar-main">
			<div class="container-fluid">
				<!-- LOGO -->
				<div class="topbar-left">
				
					<a href="" class="logo"><span
						style="color: #FFF;"><img
							src="resources/images/logo.png" class="logor"></span></a>
				</div>

				<nav class="navbar-custom">
					<ul class="list-unstyled topbar-nav float-right mb-0">
						<li class="dropdown"><a
							class="nav-link dropdown-toggle waves-effect waves-light nav-user"
							data-toggle="dropdown" href="#" role="button"
							aria-haspopup="false" aria-expanded="false"><img
								src="resources/images/sb.jpg" alt="profile-user"
								class="rounded-circle"> <span
								class="ml-1 nav-user-name hidden-sm">${userObj.partnerName}<i
									class="mdi mdi-chevron-down"></i></span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="logout"><i
									class="dripicons-exit text-muted mr-2"></i> Logout</a>
							</div></li>
						<li class="menu-item">
							<!-- Mobile menu toggle--> <a class="navbar-toggle nav-link"
							id="mobileToggle">
								<div class="lines">
									<span></span> <span></span> <span></span>
								</div>
						</a>
						<!-- End mobile menu toggle-->
						</li>
					</ul>
					<ul class="list-unstyled topbar-nav mb-0"></ul>
				</nav>
				<!-- end navbar-->
			</div>
		</div>
		<!-- MENU Start -->

		<div class="navbar-custom-menu">
			<div class="container-fluid">
				<div id="navigation" align="center">
					<!-- Navigation Menu-->
					<c:if test="${userObj.role eq 'admin' || userObj.role eq 'superadmin'}">
						<ul class="navigation-menu">
						<li class="has-submenu"><a href="allcircleHome">Home</a></li>
							<li class="has-submenu"><a href="chatloginstatus">Login Status</a></li>
							<li class="has-submenu"><a href="#">Report Download</a>
								<ul class="submenu">
									<li><a href="downloadreport?hub=north">North</a></li>
				  					<li><a href="downloadreport?hub=East">East</a></li>
				  					<li><a href="downloadreport?hub=West">West</a></li>
				  					<li><a href="downloadreport?hub=South">South</a></li>
				  					<li><a href="downloadreport?hub=Upeast">Upeast</a></li>
				  					<li><a href="downloadreport?hub=ALL">ALL</a></li>
				  					<li><a href="downloadpartnerreport?hub=ALL">PartnerWise</a></li>
				  					
				  				</ul>
							</li>
							
							<li class="has-submenu"><a href="outdiallogs">Outdial Log</a></li>
							<li class="has-submenu"><a href="agentconfig">Config Agent</a>
							
							<li class="has-submenu"><a href="bulkoption">Bulk Options</a></li>
							<!-- <li class="has-submenu"><a href="#">Delete Record</a></li> -->
				  			<li class="has-submenu"><a href="#">Agent Live Count</a>
				  				<ul class="submenu">
				  					<li><a href="agentlivecountAction?hub=north">North</a></li>
				  					<li><a href="agentlivecountAction?hub=East">East</a></li>
				  					<li><a href="agentlivecountAction?hub=West">West</a></li>
				  					<li><a href="agentlivecountAction?hub=South">South</a></li>
				  					<li><a href="agentlivecountAction?hub=Upeast">Upeast</a></li>
				  				</ul>
							</li>
							<li class="has-submenu"><a href="agentmanagerview">Partner Agent Manager</a>
								<ul class="submenu">
									<li><a href="agentmanagerrecords">All Live Agents</a></li>
				  					<li><a href="agentmanagerview">Partner Request Status</a></li>
				  					<li><a href="agentmanagerviewfinal">Complete Request Status</a></li>
				  					<c:if test="${userObj.role eq 'superadmin'}">
				  						<li><a href="manageUsers">Manage Users</a></li>
				  					</c:if>	
				  				</ul>
							</li>
						</ul>
					</c:if>	
					<c:if test="${userObj.role eq 'limit'}">
						<ul class="navigation-menu">
							<li class="has-submenu"><a href="allcircleHome">Home</a></li>
							<li class="has-submenu"><a href="chatloginstatus">Login Status</a></li>
							<li class="has-submenu"><a href="#">Report Download</a>
								<ul class="submenu">
								<c:choose>
									<c:when test="${userObj.role eq 'limit'}">
												<c:forEach var="hubName" items="${userHUbList}">
													<c:if test="${fn:containsIgnoreCase(hubName,'Upeast')}">
														<li><a href="downloadreport?hub=Upeast">${hubName}</a></li>
													</c:if>
													<c:if test="${fn:containsIgnoreCase(hubName,'North')}">
														<li><a href="downloadreport?hub=north">${hubName}</a></li>
													</c:if>
													<c:if test="${(hubName eq 'East') || (hubName eq 'east')}">
														<li><a href="downloadreport?hub=East">${hubName}</a></li>
													</c:if>
													<c:if test="${fn:containsIgnoreCase(hubName,'West')}">
														<li><a href="downloadreport?hub=West">${hubName}</a></li>
													</c:if>
													<c:if test="${fn:containsIgnoreCase(hubName,'South')}">
														<li><a href="downloadreport?hub=South">${hubName}</a></li>
													</c:if>
												</c:forEach>
												<li><a href="downloadpartnerreport?hub=ALL">PartnerWise</a></li>
										</c:when>
									</c:choose>
				  				</ul>
							</li>
							
							<li class="has-submenu"><a href="agentmanagerrecords">Agent Manager</a>
								<ul class="submenu">
				  					<li><a href="agentmanagerrecords">All Live Agents </a></li>
				  					<li><a href="agentmanagerview">Pending Change Request Status</a></li>
				  					<li><a href="agentmanagerviewfinal">All Complete Request Status</a></li>
				  					<li><a href="agentmanagercreate">New Agent Configuration</a></li>
				  				</ul>
							</li>
						</ul>
					</c:if>
					<!-- End navigation menu -->
				</div>
				<!-- end navigation -->
			</div>
			<!-- end container-fluid -->
		</div>
		<!-- end navbar-custom -->
	</div>
	<!-- header end here -->
</body>
</html>