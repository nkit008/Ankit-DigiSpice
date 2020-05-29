<!DOCTYPE html>
<html>
<head>
<title>LogIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-edit.css" type="text/css"/>

 <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js" type="text/javascript"></script>



</head>
<body>
	
	<script type="text/javascript">
		if (window.history.forward(1) != null)
			window.history.forward(1);
		
		
		(function (global) { 

		    if(typeof (global) === "undefined") {
		        throw new Error("window is undefined");
		    }

		    var _hash = "!";
		    var noBackPlease = function () {
		        global.location.href += "#";

		        // making sure we have the fruit available for juice (^__^)
		        global.setTimeout(function () {
		            global.location.href += "!";
		        }, 50);
		    };

		    global.onhashchange = function () {
		        if (global.location.hash !== _hash) {
		            global.location.hash = _hash;
		        }
		    };

		    global.onload = function () {            
		        noBackPlease();

		        // disables backspace on page except on input fields and textarea..
		        document.body.onkeydown = function (e) {
		            var elm = e.target.nodeName.toLowerCase();
		            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea')) {
		                e.preventDefault();
		            }
		            // stopping event bubbling up the DOM tree..
		            e.stopPropagation();
		        };          
		    }

		})(window);

	</script>
	
<h2 class="text-center head">Expert Chat Agent Login Logout Interface</h2>
 <div class="container-fluid">
	<div class="row">
		<div class="col-xl-5 col-lg-5 col-md-6 col-sm-6 login-sec">
		    <h2 class="text-center">Login Now</h2>
		  	<form class="login-form" action="login" method="post">
				  <div class="form-group">
				    <label for="userid" class="text-uppercase">Username</label>
				    <input type="text" class="form-control" placeholder="" name="userid" autofocus required autocomplete="off">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="text-uppercase">Password</label>
				    <input type="password" class="form-control" placeholder="" required name="password">
				  </div>
					<div class="form-check">
					   <button type="submit" class="btn btn-login">Submit</button>
					</div>
  			</form>
		</div>
		<div class="col-xl-7 col-lg-7 col-md-6 col-sm-6 banner-sec">
		<img src="${pageContext.request.contextPath}/resources/img/pexels-photo.jpg" style="width:100%;height:548px;" alt=""/>
        </div>
     </div>
  </div>
          
</body>
</html>