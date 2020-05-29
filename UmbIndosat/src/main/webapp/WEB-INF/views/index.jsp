<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>UMB Indosat</title>
<meta name="viewport" content="width=device-width,initial-scale=1">



<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="loginbg1">
<!-- Log In page -->
<div class="wrapper-page" >
  <div class="card">
    <div class="card-body">
      <div class="p-3">
        <div class="float-right text-right">
          <h4 class="font-18 mt-3 m-b-5"></h4>
          <p class="text-muted">Sign in to Complain System.</p>
        </div>
        <a href="index.html" class="logo-admin"><img src="assets/images/logo2.png" width="188" height="29"></a></div>
<div class="p-3">
	<form class="form-horizontal m-t-10" action="login" method="post">
          <div class="form-group">
            <label>Username</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="Enter username" autofocus autocomplete="off">
          </div>
          <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" autocomplete="off">
          </div>
          <div class="form-group row m-t-30">
            <div class="col-sm-6">
              
            </div>
            <div class="col-sm-6 text-right">
              <button class="btn btn-primary w-md waves-effect waves-light" type="submit">Log In</button>
            </div>
          </div>
          <p class="text-danger text-center" style="font-size:16px;font-weight: bold">${msg}</p>
          <div class="form-group m-t-30 mb-0 row">
            
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="m-t-40 text-center text-white-50">
   
    <p>© 2018 Bihar PCS Complain System</p>
  </div>
</div>

</body>

</html>