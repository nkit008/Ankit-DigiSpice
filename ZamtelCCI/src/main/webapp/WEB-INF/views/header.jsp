<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- header start here-->
    <header class="app-header header"> 
      <div class="container-fluid">
        <div class="d-flex"> <a class="header-brand" href="neXtTunesSearchTone"> <img alt="logo" class="header-brand-img main-logo" src="resources/images/logo1.png"> <img alt="logo" class="header-brand-img mobile-logo" src="resources/images/logo1.png"> </a>
          
          
           
          <!-- Sidebar toggle button--> <a aria-label="Hide Sidebar" class="app-toggle" data-toggle="sidebar" href="">
          <i class="fa fa-bars barsz"></i>
          </a>
          
          <div class="d-flex order-lg-2 ml-auto">           
            
            <div class="dropdown"> <a class="nav-link pr-0 leading-none d-flex" data-toggle="dropdown" href="#"> <img src="resources/images/ujr2.png" width="40" height="40" style="margin-right:2px;" /> <span class="ml-2 d-none d-lg-block"> <span class="text-dark">${userObj.userName}</span> </span> </a>
              <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow"> 
               
                <a class="dropdown-item" href="logout"><i class="fa fa-power-off"></i> Log Out</a> </div>
            </div>
            
          </div>
        </div>
      </div>
    </header>
    
   <!-- header end here-->

   
       
    
    
    <!--left side menu start here-->
        
    <aside class="app-sidebar mCustomScrollbar _mCS_1 mCS-autoHide" style="overflow: visible;">
      <div id="mCSB_1" class="mCustomScrollBox mCS-minimal mCSB_vertical mCSB_outside" style="max-height: none !important;" tabindex="0" >
        <div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">
          <div class="app-sidebar__user">
            <div class="user-body"> <img src="resources/images/ujr2.png" width="60" height="60" /></div>
            <div class="user-info"> <a href="#" class="ml-2"><span class="text-dark app-sidebar__user-name font-weight-semibold">${userObj.userName}</span><br>
              <span class="text-muted app-sidebar__user-name text-sm"> Welcome to Zamtel</span> </a> </div>
          </div>
          <ul class="side-menu" style="overflow-y:scroll; height:330px; " >
<!--             <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-home faics"></i><span class="side-menu__label">Home</span><i class="angle fa fa-angle-right"></i></a></li> -->
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-headphones faics"></i><span class="side-menu__label">Zamtel Games</span></a>
              <ul class="slide-menu">
              	<li><a href="zemtalGamesUserDetail" class="slide-item">User Details</a></li>
				<li><a href="zamtelGamesBillingDetails" class="slide-item">User Billing Details</a></li>
				<li><a href="zamtelGamesSingleSubscription" class="slide-item">Single Subscription</a></li>
				<li><a href="zamtelGamesBulkSubscription" class="slide-item">Bulk Subscription</a></li>
				<li><a href="zamtelGamesSingleUnsubscription" class="slide-item">Single UnSubscriptions</a></li>
               </ul>
            </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-music faics"></i><span class="side-menu__label">Zamtel Beatz</span></a>
            <ul class="slide-menu">
              	<li><a href="zamtelBeatsUserDetails" class="slide-item">User Details</a></li>
				<li><a href="zamtelBeatsBillingDetails" class="slide-item">User Billing Details</a></li>
				<li><a href="zamtelBeatsSingleSubscription" class="slide-item">Single Subscription</a></li>
				<li><a href="zamtelBeatsBulkSubscription" class="slide-item">Bulk Subscription</a></li>
				<li><a href="zamtelBeatsSingleUnsubscription" class="slide-item">Single UnSubscriptions</a></li>
              </ul>
			</li>
			  <c:if test="${userObj.name == 'spice'}">          
              <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-newspaper-o faics"></i><span class="side-menu__label">MIS Reports</span><i class="angle fa fa-angle-right"></i></a>
              <ul class="slide-menu">
              	<li><a href="zemtalGamesMishome" class="slide-item">Zemtal Games MIS</a></li>
              	<li><a href="zemtalBeatsMIShome" class="slide-item">Zemtal Beats MIS</a></li>
              </ul>
            </li>
            </c:if>
          </ul>
        </div>
      </div>
      
    </aside>
    <!--Left side-menu end here-->
    