<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Click to Call</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<!-- header start here -->
<div class="topbar">
  <div class="topbar-main">
    <div class="container-fluid"><!-- LOGO -->
      <div class="topbar-left"><a href="index.html" class="logo"><span style="color:#FFF;"><img src="assets/images/logo.png" class="logor" ></span></a></div>
      <!-- Navbar -->
      <nav class="navbar-custom"><!-- Search input -->
        <div class="search-wrap" id="search-wrap">
          <div class="search-bar">
            <input class="search-input" type="search" placeholder="Search here..">
            <a href="javascript:void(0);" class="close-search search-btn" data-target="#search-wrap"><i class="mdi mdi-close-circle"></i></a></div>
        </div>
        <ul class="list-unstyled topbar-nav float-right mb-0">
          <li><a class="nav-link waves-effect waves-light search-btn" href="javascript:void(0);" data-target="#search-wrap"><i class="mdi mdi-magnify nav-icon"></i></a></li>
          
          
          
          <li class="dropdown"><a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false"><img src="assets/images/sb.jpg" alt="profile-user" class="rounded-circle"> <span class="ml-1 nav-user-name hidden-sm">user name <i class="mdi mdi-chevron-down"></i></span></a>
            <div class="dropdown-menu dropdown-menu-right">   
              
              <a class="dropdown-item" href="#"><i class="dripicons-exit text-muted mr-2"></i> Logout</a></div>
          </li>
          <li class="menu-item"><!-- Mobile menu toggle--> <a class="navbar-toggle nav-link" id="mobileToggle">
            <div class="lines"><span></span> <span></span> <span></span></div>
            </a><!-- End mobile menu toggle--></li>
        </ul>
        <ul class="list-unstyled topbar-nav mb-0">
          <li class="hidden-sm"><a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false"><i class="mdi mdi-library-plus mr-2"></i>Upload </a>
            
          </li>
          <li class="hidden-sm"><a class="nav-link waves-effect waves-light" href="" target="_blank"><i class="mdi mdi-music-note mr-2"></i>View Playlist</a></li>
        </ul>
      </nav>
      <!-- end navbar--></div>
  </div>
  <!-- MENU Start -->
  
  <!-- end navbar-custom --></div>
<!-- header end here -->


<!-- Page Content-->
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <!--<div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">New Complain</a></li>
              <li class="breadcrumb-item active">Hardware Complain</li>
            </ol>
          </div>-->
          <h4 class="page-title">Upload</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    
    
    <!--end row-->
    
    <!--End row-->
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                  <form >
                    <div class="form-group">
                      <label>Playlist Name</label>
                      <div>
                      <input type="text"  class="form-control" style="width:80%; display:inline;">
                     <button class="btn" style="display:inline;"><i class="mdi mdi-plus"></i>Add New</button></div></div>
                    <div class="form-group">
                      <label>Select File </label>
                      <input type="text" placeholder=""  class="form-control">
                      </div>
                    
                    
                    
                  </form>
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                  <form>
                    <div class="form-group">
                      <label>Banner</label>
                      <input type="text" placeholder=""  class="form-control">
                      </div>
                      
                      
                      
                    <div class="form-group">
                      <label>Song Artwork</label>
                      <input type="text"  class="form-control" >
                      </div>
                    
                    
                    
                      
                      
                      <div class="form-group mb-0" style="padding-top:15px;">
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
                      </div>
                  </form>
                </div>
              </div>
          </div>
      </div>
        </div>
      </div>
 </div>
   </div>
  
  
</div>
<!-- end page-wrapper -->

<!-- Footer -->
<footer class="footer">
  <div class="container-fluid">
    <div class="row">
      <div class="col-12" align="center">© 2018 Bihar PCS Complain System</div>
    </div>
  </div>
</footer>
<!-- End Footer -->

<!-- jQuery  --><script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>
<!--datepicker -->
<script src="assets/js/bootstrap-datepicker.min.js"></script>
<script src="assets/js/bootstrap-colorpicker.min.js"></script>
<script src="assets/js/bootstrap-colorpicker.min.js"></script>
<script src="assets/js/jquery.form-advanced.init.js"></script>

</body>
</html>