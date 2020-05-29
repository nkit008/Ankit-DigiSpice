<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Complain System</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datepicker.min.css">



</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- Template start here-->
<form action="addNewUser" method="post" onsubmit="return validateForm()"> 
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">Add User</a></li>
              
            </ol>
          </div>
          <h4 class="page-title">Add User</h4>
        </div>
      </div>
    </div>
      
    
    
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>Name<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="name" name="name" autofocus="autofocus" required="required" autocomplete="off">
                      <span class="font-13 text-muted"></span></div>
                    <div class="form-group">
                      <label>Username<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="username" name="username" required="required" autocomplete="off">
                      </div>
                      
                      
                      <div class="form-group">
                      <label>Password<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="password" name="password" required="required" autocomplete="off">
                      </div>
                      
                      
                      <div class="form-group">
                      <label>Confirm Password<span class="sta-red">*</span></label>
                      <input type="password" class="form-control" id="password1" name="password1" required="required" autocomplete="off">
                      <p id="confirmpassword2" class="text-danger"></p>
                      </div>
                      
                      
                    
                    
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                      
                      
                      
                    <div class="form-group">
                    
                    
                    <div class="form-group">
                      <label></label>
                       <label>User Role<span class="sta-red">*</span></label>
                      <select class="form-control" id="user_role" name="user_role" required="required" autocomplete="off">
                      <option selected="selected" disabled="disabled" value="-1">Select Role</option>
                      <option value="Spice_Admin">Spice_Admin</option>
                      <option value="Prison_Admin">Prison_Admin</option>
                      <option value="BSNL_Admin">Bsnl_Admin</option>
                      </select>
                      </div>    
                      
                    <div class="form-group">
                      <label>Contact Number<span class="sta-red">*</span>&#x00A0;&#x00A0;&#x00A0;&#x00A0;<span class="text-danger" style="font-weight:bold" id="phone1"></span></label>
                      <input type="text" class="form-control" id="phone" name="phone" required="required" autocomplete="off">
                      </div>
                      
                      
                      <div class="form-group">
                      <label>E-Mail Address<span class="sta-red">*</span></label>
                      <input type="email" class="form-control" id="mail" name="mail" required="required" autocomplete="off">
                      </div>
                      
                      
                    <div class="form-group mb-0">
                     
                    <div class="form-group mb-0" style="padding-top:35px;">
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
                      </div>
                      </div>
                      
                      
                      
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
   </div>
 
  
</div>
</div>
</form>
<!-- template end here -->

<input type="hidden" id="snackbar" value="${msg}">

<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->

<!-- basic jQuery  -->

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>

<!-- datepicker jQuery  -->
<script type="text/javascript" src="assets/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="assets/js/form-advanced.js"></script>
<script type="text/javascript" src="assets/js/bootbox.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x, 
		callback: function(){}
		});
			
});

function validateForm(){
	var pass= document.getElementById("password").value;
	var pass1= document.getElementById("password1").value;
	var x= document.getElementById("phone").value;
	
	var pass_pattern = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
	var text_pattern = /^\d+$/;
	
	if(!pass_pattern.test(pass))
		{
		 	alert("password should contain atleast one number and one special character and have atleast 8 characters");
	        return false;
		
		}
	
	if(pass != pass1)
		{
		
		document.getElementById('confirmpassword2').innerHTML="**Password doesn't match";
		return false;
		}
	
	 	
	if (!text_pattern.test(x))
		{
		document.getElementById("phone1").innerHTML="**Number should contain digits";
			return false;
		}
	
	
	if(document.getElementById("user_role").value==-1)
		{
			alert("please select role");
			return false;		
		}
	
	
	if(x.length>=10 && x.length<14)
		{
		return true;
		}
		
	else
		{
		document.getElementById("phone1").innerHTML="**Number should have 10 digits";
		return false;
		} 
	}
</script>



</body>
</html>