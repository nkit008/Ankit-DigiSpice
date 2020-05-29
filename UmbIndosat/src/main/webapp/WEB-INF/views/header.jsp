<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
</head>

<body>
<!-- header start here -->
<div class="topbar">
  <div class="topbar-main">
    <div class="container-fluid"><!-- LOGO -->
      <div class="topbar-left"><a href="homepage" class="logo"><span style="color:#FFF;"><img src="assets/images/logo.png" class="logor"  width="253" height="29"></span></a></div>
      <!-- Navbar -->
      <nav class="navbar-custom">
      <!-- Search input -->
        <div class="search-wrap" id="search-wrap">
          <div class="search-bar">
            <input class="search-input" type="search" placeholder="Search here..">
            <a href="javascript:void(0);" class="close-search search-btn" data-target="#search-wrap"><i class="mdi mdi-close-circle"></i></a></div>
        </div>
        <ul class="list-unstyled topbar-nav float-right mb-0">
       <!--    <li><a class="nav-link waves-effect waves-light search-btn" href="javascript:void(0);" data-target="#search-wrap"><i class="mdi mdi-magnify nav-icon"></i></a></li> -->
          
          
          
          <li class="dropdown"><a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false"><img src="assets/images/sb.jpg" alt="profile-user" class="rounded-circle"> <span class="ml-1 nav-user-name hidden-sm">${userObj.userName}<i class="mdi mdi-chevron-down"></i></span></a>
            <div class="dropdown-menu dropdown-menu-right">   
              
             <div><a class="dropdown-item" href="changePassword"><i class="text-muted fa fa-key mr-2" aria-hidden="true"></i> Change password</a></div>
                <div><a class="dropdown-item" href="logout"><i class="dripicons-exit text-muted mr-2"></i> Logout</a></div>
              
              </div>
          </li>
          <li class="menu-item"><!-- Mobile menu toggle--> <a class="navbar-toggle nav-link" id="mobileToggle">
            <div class="lines"><span></span> <span></span> <span></span></div>
            </a><!-- End mobile menu toggle--></li>
        </ul>
        <ul class="list-unstyled topbar-nav mb-0">
          
          
        </ul>
      </nav>
      <!-- end navbar--></div>
  </div>
  <!-- MENU Start -->
  <div class="navbar-custom-menu">
    <div class="container-fluid">
      <div id="navigation"><!-- Navigation Menu-->
        <ul class="navigation-menu">
          <li class="has-submenu"><a href="homepage"><i class="mdi mdi-home"></i> User Menu</a>
            <ul class="submenu">
              <li><a href="newhardwarecomplain">Login History</a></li>
              <li><a href="newsoftwarecomplain">User List</a></li>
              <li><a href="newphysicaldamage">User Last Change History</a></li>
            </ul>
          </li>
          <li class="has-submenu"><a href="#"><i class="mdi mdi-pencil"></i>CMS Management</a>
            <ul class="submenu">
              <li><a href="newhardwarecomplain">Hardware complains</a></li>
              <li><a href="newsoftwarecomplain">Software complains</a></li>
              <li><a href="newphysicaldamage">Report physical damage</a></li>
              
                 <li><a href="newconncomplain">Connectivity</a></li>
            </ul>
          </li>
          <li class="has-submenu"><a href="#"><i class="mdi mdi-bullseye"></i>System Management</a>
            <ul class="submenu">
              <li><a href="opencomlains">View Open complains</a></li>
              <li><a href="closecomplains">View Close complains</a></li>
              <li><a href="allcomplain">View All complains</a></li>
              
            </ul>
          </li>
          
            
          
          
          
          
        </ul>
        <!-- End navigation menu --></div>
      <!-- end navigation --></div>
    <!-- end container-fluid --></div>
  <!-- end navbar-custom --></div>
<!-- header end here -->
</body>
</html>