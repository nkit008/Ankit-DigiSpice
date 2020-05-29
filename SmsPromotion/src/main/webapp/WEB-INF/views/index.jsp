<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>SMS Promotion</title>
<meta name="viewport" content="width=device-width,initial-scale=1">



<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="loginbg1">
<!-- Log In page -->
<div class="wrapper-page" >
  <div class="card">
    <div class="card-body">
      <div class="p-3">
        
        <a href="/" class="logo-admin"><img src="resources/images/logo.png" width="202" height="45"></a></div>
      <div class="p-3">
        <form class="form-horizontal m-t-10" action="login" method="post">
          <div class="form-group">
            <label>Username</label>
            <input type="text" class="form-control" name="username" placeholder="Enter username" autofocus="autofocus" required="required" autocomplete="off">
          </div>
          <div class="form-group">
            <label >Password</label>
            <input type="password" class="form-control"  placeholder="Enter password" name="password" required="required" autocomplete="off">
          </div>
          <div class="form-group row m-t-30">
            <div class="col-sm-6">
              
            </div>
            <div class="col-sm-6 text-right">
              <button class="btn btn-primary w-md waves-effect waves-light" type="submit">Log In</button>
            </div>
          </div>
        <%--   <div class="form-group m-t-30 mb-0 row">
            <p class="text-danger" style="font-size: 15px;font-weight:bold;">${wrong}</p>
          </div> --%>
        </form>
      </div>
    </div>
  </div>
  <div class="m-t-40 text-center text-white-50">
   
    <p>© 2019 Digispice - SMS Promotion</p>
  </div>
</div>

</body>

</html>