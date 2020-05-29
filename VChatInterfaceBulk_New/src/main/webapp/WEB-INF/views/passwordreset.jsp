<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="resources/css/component.css">
<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>
<script>
function myFunction() {
  var x = document.getElementById("txtPassword");
  if (x.type === "password") {
	  x.type = "text";  
  } else {
	  x.type = "password";    
  }
}
</script>

</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class="container" align="center">
				<%-- <div class="col-sm-12">
					<div class="page-title-box">
						<h2 class="page-title" align="center"><i class="mdi mdi-music-note"></i>${objSrcName}</h2>
					</div>
				</div> --%>
				</br>
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">
							<div class="p-20">
								<form class="form-horizontal m-t-10" action="resetpasswordAction" method="post" style="border:1px dotted; black">
									
										<h4 class="page-title" style="margin-bottom: 22px;" align="center"><mark> Password Reset  </mark></h4>
										
										<div class="form-group" >
											<label class="col-md-4 blckcolor" for="reqType" >User Name <span class="required"> </span></label>
                                                                           <input type="text" name="loginId" id="loginId" class="col-md-4 blckcolor"
                                                                                  placeholder="Enter Chat Id" required="required" autocomplete="off"/>

										</div>
                                        
                                        
                                        <div class="form-group" >
											<label class="col-md-4 blckcolor" for="reqType" >Password <span class="required"> </span></label>

                                            <input type="password" name="newPassword" id="txtPassword" class="col-md-4"
												placeholder="Please Enter User Password" required="required" autocomplete="off"/>
                                            
                                          
										</div>
                                        
                                        
                                        
                                        
                         <div class="form-group" style="margin-top:-10px;">
											<label class="col-md-3 blckcolor" for="reqType" ></label>
												<input type="checkbox"  onclick="myFunction()" style="vertical-align:-2px;">Show Password


                                            
                                          
										</div>               
                                        
                                        
                                        
                                        
                                        
                                        
                                        <div class="form-group" >
											<label class="col-md-4 blckcolor" for="confirmPassword" style="padding-right:52px;" >Confirm Password <span class="required"> </span></label>
												<input type="password" name="confirmPassword" id="txtConfirmPassword" class="col-md-4"
												placeholder="Re-Type Password" required="required" autocomplete="off"/>
										</div>
                                        
										<div class="form-group" align="center">
											<button class="btn addnew-db" id="btnSubmit" style="margin-top: -0px; margin-left:80px;">
												Submit</button>
										</div>
												
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${msg}">
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
	              size: 'small',
	              callback: function(){}
	              });
	       
	});
	</script>
	
	<script type="text/javascript">
	    $(function () {
	        $("#btnSubmit").click(function () {
	            var password = $("#txtPassword").val();
	            var confirmPassword = $("#txtConfirmPassword").val();
	            if (password != confirmPassword) {
	                alert("Passwords do not match.");
	                return false;
	            }
	            return true;
	        });
	    });
	</script>
	<!-- <script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function addPlaylist()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/addNewPlaylist";
	
}
</script> -->
</body>
</html>