<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>DigiSpice : Web Page</title>
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
      		<div class="row">

		      	<div class="col-6" align="left">
		      		<a class="logo-admin"><img src="resources/images/logo2.png" ></a>
		      	</div>	
		   		<div class="col-6" align="right">
		   			<p class="text-danger" style="font-size: 20px;font-weight:bold;">VChat Interface</p>
		   		</div>
		   	</div>	
      	 
      </div>
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
          <div class="form-group m-t-30 mb-0 row">
            <p class="text-danger" style="font-size: 15px;margin-left:13px;	font-weight:bold;">${wrong}</p>
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="m-t-40 text-center text-white-30">
    <p style="color:#fff;">© 2019 DigiSpice - CCI Interface</p>
  </div>
</div>

</body>

</html>