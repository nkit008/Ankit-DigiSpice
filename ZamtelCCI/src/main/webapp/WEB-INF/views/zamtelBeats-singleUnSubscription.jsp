<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>ZamtelBeatz Unsubscription</title>

<link rel="stylesheet" type="text/css" href="resources/css/latest.css" />

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
<link href="resources/css/style.css" rel="stylesheet"/>
<link href="resources/css/sidemenu.css" rel="stylesheet"/>
<link href="resources/css/sidebar.css" rel="stylesheet"/>
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
<link href="resources/css/jquery-confirm.css" rel="stylesheet" type="text/css"/>
</head>
<body class="app sidebar-mini rtl">


<div class="page">
  <div class="page-main"> 
  

    
	<jsp:include page="header.jsp"></jsp:include>    
    
   <!-- Template start here-->   
    

<div class=" app-content my-3 my-md-5">
      <div class="side-app"> 
        <div class="mb-5">
          <div class="page-header  mb-0">
            <h4 class="page-title">UnSubscription </h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Zamtel Beatz</li>
              <li class="breadcrumb-item active" aria-current="page">UnSubscription</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" method="post" onsubmit="return validate();">
              <div class="card-header">
                <h3 class="card-title">UnSubscription</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Mobile Number<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <input type="text" class="form-control" name="ani" id="ani" required>
                      <!-- <span style="color:red;font-weight:bold;font-size:11px;">Enter Mobile Number with Country Code - 237</span> -->
                    </div>
                    
                   
                    
                   
                    
                  </div>
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group" style="padding-top:30px;">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                    
                    
                    
                    
                    
                    
                    
                  
                  
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
        
        
        
     
        
        
      </div>
	</div>

	<!-- Template end here-->
      <jsp:include page="footer.jsp" ></jsp:include>
     
      
  </div>
</div>

<input type="hidden" id="res"/>
<input type="hidden" id="snackbar" value="${msg}"/>
<script src="resources/js/jquery-3.2.1.min.js"></script>

<script src="resources/js/popper.min.js"></script>

<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-confirm.js"></script>
<script type="text/javascript" src="resources/js/toastr.min.js"></script>
<link href="resources/css/toastr.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x,
		callback: function(){}
		});
});
</script>
<script>
function validate()
	{
	var pattern = /^[0-9]$/;
	
	if(!pattern.test($('#ani').val()) &&  $('#ani').val().length != 9)
	{
		toastr.error("ani should be numeric and 12 digits");
		$('#ani').focus();
		return false;
	}
	
else
	{
		var a = $('#ani').val();
	$.confirm({
	    title: 'Confirm!',
	    content: 'Do you really want to unsubscription request for user?',
	    buttons: {
	        confirm: function () {
	window.location.href=getContextPath()+"/zamtelBeatsUnSubscriptionAction?ani=" + a;
	        },
	        cancel: function () {
	            
	        }
	    }
	});
	
	event.preventDefault();
	}
}
</script>
<script type="text/javascript">
function getContextPath() {
return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
</script>
</body>
</html>