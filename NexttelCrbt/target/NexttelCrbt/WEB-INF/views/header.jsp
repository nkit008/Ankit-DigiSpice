<!-- header start here-->
    <header class="app-header header"> 
      <div class="container-fluid">
        <div class="d-flex"> <a class="header-brand" href="searchTone"> <img alt="logo" class="header-brand-img main-logo" src="resources/images/logo1.png"> <img alt="logo" class="header-brand-img mobile-logo" src="resources/images/logo1.png"> </a>
          
          
           
          <!-- Sidebar toggle button--> <a aria-label="Hide Sidebar" class="app-toggle" data-toggle="sidebar" href="">
          <i class="fa fa-bars barsz"></i>
          </a>
          <div class=""> <a href="" data-toggle="search" class="icon navsearch"> <i class="fa fa-search"></i> </a> </div>
          <div class="header-searchinput">
            <form class="form-inline">
              <div class="search-element mr-3">
                <input class="form-control header-search" type="search" placeholder="Search" aria-label="Search">
                <span class="search-icon"><i class="fa fa-search"></i></span> </div>
            </form>
          </div>
          <div class="d-flex order-lg-2 ml-auto">           
            
            <div class="dropdown"> <a class="nav-link pr-0 leading-none d-flex" data-toggle="dropdown" href="#"> <img src="resources/images/ujr2.png" width="40" height="40" style="margin-right:2px;" /> <span class="ml-2 d-none d-lg-block"> <span class="text-dark">${userobj.first_name}</span> </span> </a>
              <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow"> 
               
                <a class="dropdown-item" href="logout"><i class="fa fa-power-off"></i> Log Out</a> </div>
            </div>
            
          </div>
        </div>
      </div>
    </header>
    
   <!-- header end here-->

   
                   
    <%-- <!--left side menu start here-->
        
    <aside class="app-sidebar mCustomScrollbar _mCS_1 mCS-autoHide" style="overflow: visible;">
      <div id="mCSB_1" class="mCustomScrollBox mCS-minimal mCSB_vertical mCSB_outside" style="max-height: none;" tabindex="0">
        <div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">
          <div class="app-sidebar__user">
            <div class="user-body"> <img src="resources/images/ujr2.png" width="60" height="60" /></div>
            <div class="user-info"> <a href="#" class="ml-2"><span class="text-dark app-sidebar__user-name font-weight-semibold">${userobj.first_name}</span><br>
              <span class="text-muted app-sidebar__user-name text-sm"> Welcome to Nexttel</span> </a> </div>
          </div>
          <ul class="side-menu">
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-home faics"></i><span class="side-menu__label">Home</span><i class="angle fa fa-angle-right"></i></a>
              
            </li>
            <li> <a class="side-menu__item" href="#"><i class="fa fa-question faics"></i><span class="side-menu__label">FAQS</span></a> </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href=""><i class="fa fa-headphones faics"></i><span class="side-menu__label">Customer Care</span><i class="angle fa fa-angle-right"></i></a>

			<ul><li><a href="subscriptionDelete">Unsubscription</a></li></ul>
			<ul><li><a href="checkStatus">Status</a></li></ul>
			<ul><li><a href="billingDetails">billing</a></li></ul>
			<ul><li><a href="searchTone">Search Tone</a></li></ul>              
            
            </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-user faics"></i><span class="side-menu__label">Admin Options</span><i class="angle fa fa-angle-right"></i></a>
              
            </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-newspaper-o faics"></i><span class="side-menu__label">MIS Reports</span><i class="angle fa fa-angle-right"></i></a>
              <ul><li><a href="mishome">view MIS</a></li></ul>
            </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-address-book-o faics"></i><span class="side-menu__label">Manage Users</span><i class="angle fa fa-angle-right"></i></a>
            
            
              
            </li>
                     
          </ul>
        </div>
      </div>
      
    </aside>
    <!--Left side-menu end here--> --%>
    
    
    
    <!--left side menu start here-->
        
    <aside class="app-sidebar mCustomScrollbar _mCS_1 mCS-autoHide" style="overflow: visible;">
      <div id="mCSB_1" class="mCustomScrollBox mCS-minimal mCSB_vertical mCSB_outside" style="max-height: none !important;" tabindex="0" >
        <div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">
          <div class="app-sidebar__user">
            <div class="user-body"> <img src="resources/images/ujr2.png" width="60" height="60" /></div>
            <div class="user-info"> <a href="#" class="ml-2"><span class="text-dark app-sidebar__user-name font-weight-semibold">${userobj.first_name}</span><br>
              <span class="text-muted app-sidebar__user-name text-sm"> Welcome to Nexttel</span> </a> </div>
          </div>
          <ul class="side-menu" style="overflow-y:scroll; height:400px; " >
<!--             <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-home faics"></i><span class="side-menu__label">Home</span><i class="angle fa fa-angle-right"></i></a></li> -->
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-headphones faics"></i><span class="side-menu__label">CRBT</span><i class="angle fa fa-angle-right"></i></a>
              <ul class="slide-menu">
              	<li><a href="subscriptionDelete" class="slide-item">User Unsubscription</a></li>
				<li><a href="checkStatus" class="slide-item">Check User Status</a></li>
				<li><a href="billingDetails" class="slide-item">Billing Details</a></li>
				<li><a href="searchTone" class="slide-item">Search Tone</a></li>
               </ul>
            </li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-music faics"></i><span class="side-menu__label">neXtMusic</span><i class="angle fa fa-angle-right"></i></a>
            <ul class="slide-menu">
				  <li><a href="neXtMusicCheckUserDetails" class="slide-item">User Details</a></li>
	              <li><a href="neXtMusicUserBillingDetails" class="slide-item">User Billing Details</a></li>
	              <li><a href="neXtMusicSingleSubscription" class="slide-item">Single Subscription</a></li>
	              <li><a href="neXtMusicBulkSubscription" class="slide-item">Bulk Subscription</a></li>
	              <li><a href="neXtMusicSingleUnSubscription" class="slide-item">Single Un-Subscription</a></li>
              </ul>
			</li>
            <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-microphone faics"></i><span class="side-menu__label">neXtVoice</span><i class="angle fa fa-angle-right"></i></a>
            <ul class="slide-menu">
              	<li><a href="subscriptionDelete" class="slide-item">User Unsubscription</a></li>
				<li><a href="checkStatus" class="slide-item">Check User Status</a></li>
				<li><a href="billingDetails" class="slide-item">Billing Details</a></li>
				<li><a href="searchTone" class="slide-item">Search Tone</a></li>
               </ul>
            </li>
                        
<!--              <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-newspaper-o faics"></i><span class="side-menu__label">MIS Reports</span><i class="angle fa fa-angle-right"></i></a>
              <ul class="slide-menu">
              	<li><a href="mishome" class="slide-item">View MIS</a></li>
              </ul>
            </li>
              <li class="slide"> <a class="side-menu__item" data-toggle="slide" href="#"><i class="fa fa-user-o faics" aria-hidden="true"></i><span class="side-menu__label">Manage Users</span><i class="angle fa fa-angle-right"></i></a>
              <ul class="slide-menu">
              	<li><a href="createUser" class="slide-item">Create User</a></li>
              	<li><a href="viewUser" class="slide-item">View User</a></li>
              </ul>
            </li>
                  -->    
          </ul>
        </div>
      </div>
      
    </aside>
    <!--Left side-menu end here-->
    