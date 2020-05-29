<!DOCTYPE html>
<html lang="en">
    
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>Indosat</title>
       
       
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
       
        <link href="resources/css/icons.css" rel="stylesheet" type="text/css">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    </head>

    <body>
       <!-- Begin page -->
       <div class="wrapper-page">

        <div class="card">
            <div class="card-body">

                <h3 class="text-center m-0">
                    <a href="index.html" class="logo logo-admin"><img src="resources/images/logo.png" style="width:150px; height:auto;"  alt="logo"></a>
                </h3>

                <div class="p-3">
                  
                    

                    <form class="form-horizontal m-t-30" action="login" method="post">

                        <div class="form-group">
                            <label for="username">User Name</label>
                            <input type="text" class="form-control" name="username" id="username" placeholder="Enter username" autofocus autocomplete="off" required="required">
                        </div>

                        <div class="form-group">
                            <label for="userpassword">Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="Enter username" autofocus autocomplete="off" required="required">
                        </div>

                        <div class="form-group row m-t-20">
                            <div class="col-6">
                                
                            </div>
                            <div class="col-6 text-right">
                                <button class="btn btn-primary w-md waves-effect waves-light" type="submit" style="background-color:#FC0; border:none;">Log In</button>
                            </div>
                        </div>

						<p class="text-danger text-center" style="font-size:16px;font-weight: bold">${wrong}</p>                        
                    </form>
                </div>

            </div>
        </div>

        <div class="m-t-40 text-center">
           
            <p>Copyright © 2018, Indobeat All Rights Reserved</p>
            
            <input type="hidden" id="snackbar" value="${wrongmsg}">
        </div>

    </div>
    
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/custom-file-input.js"></script>

<!-- jQuery  -->
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/app.js"></script>
<!--datepicker -->
<script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/jquery.form-advanced.init.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
       
 
 <script type="text/javascript">

$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x, 
		callback: function(){}
		});
	
});
</script>
 

</body>


</html>