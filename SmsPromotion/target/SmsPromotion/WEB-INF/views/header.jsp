<div class="topbar">
  <div class="topbar-main">
    <div class="container-fluid"><!-- LOGO -->
      <div class="topbar-left"><a href="home" class="logo"><span style="color:#FFF;"><img src="resources/images/logo.png" class="logor" ></span></a></div>
      <!-- Navbar -->
      <nav class="navbar-custom"><!-- Search input -->
        <div class="search-wrap" id="search-wrap">
          <div class="search-bar">
            <input class="search-input" type="search" placeholder="Search here..">
            <a href="javascript:void(0);" class="close-search search-btn" data-target="#search-wrap"><i class="mdi mdi-close-circle"></i></a></div>
        </div>
        
        
        
        <ul class="list-unstyled topbar-nav float-right mb-0">
          <!-- <li><a class="nav-link waves-effect waves-light search-btn" href="javascript:void(0);" data-target="#search-wrap"><i class="mdi mdi-magnify nav-icon"></i></a></li> -->
          
          
          
          <li class="dropdown"><a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false"><img src="resources/images/sb.jpg" alt="profile-user" class="rounded-circle"> <span class="ml-1 nav-user-name hidden-sm">${userObj.username} <i class="mdi mdi-chevron-down"></i></span></a>
            <div class="dropdown-menu dropdown-menu-right">   
              
              <a class="dropdown-item" href="logout"><i class="dripicons-exit text-muted mr-2"></i> Logout</a></div>
          </li>
          
        </ul>
        <ul class="list-unstyled topbar-nav mb-0 dsg">
        <c:if test="${user.role eq 'admin'}">
          <!-- <li class="hidden-sm"><a class="nav-link waves-effect waves-light" href="#"><i class="fa fa-list-alt mr-2"></i>View MIS</a></li> -->
          </c:if>
          
        <!--   <li class="hidden-sm"><a class="nav-link waves-effect waves-light" href="viewBanner"><i class="mdi  mdi-image-filter mr-2"></i>View Banner</a></li>
          <li class="hidden-sm"><a class="nav-link waves-effect waves-light" href="viewMusic"><i class="mdi mdi-music-note mr-2" aria-hidden="true"></i>View Music</a></li>
          <li class="hidden-sm"><a class="nav-link waves-effect waves-light" href="viewMetadata"><i class="fa fa-history mr-2" aria-hidden="true"></i>View History</a></li> -->
        </ul>
      </nav>
      <!-- end navbar--></div>
  </div>
  <!-- MENU Start -->
  
  <!-- end navbar-custom -->
  
  
  <div style="clear:both; overflow: hidden; background-color:#000; padding:10px 0px 10px 20px; "  class="kl">
  <div  class="row">
  <div class="" style="float:left; color:#FFF; padding-left:27px;"><span style="display:inline"><a href="viewPlaylist" style="color:#fff;">View Playlist </a></span> |<span style="display:inline; padding-left:4px; padding-right:4px;"><a href="viewBanner" style="color:#fff;"> View Banner</a></span>|<span style="display:inline; padding-left:5px;"><a href="viewMusic" style="color:#fff;">View Music</a></span>|<span style="display:inline; padding-left:5px;"><a href="viewMetadata" style	="color:#fff;">View History</a></span></div></div>
  
  
  
  </div>
  
  
  
  
  
  </div>
  
  
  
  
  </div>












