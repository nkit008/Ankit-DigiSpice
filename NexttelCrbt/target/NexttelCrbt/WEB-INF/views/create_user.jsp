<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>Nexttel</title>

<link rel="stylesheet" type="text/css" href="resources/css/latest.css" />

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
<link href="resources/css/style.css" rel="stylesheet"/>
<link href="resources/css/sidemenu.css" rel="stylesheet"/>
<link href="resources/css/sidebar.css" rel="stylesheet"/>
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
            <h4 class="page-title">Create User</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Manage User</li>
              <li class="breadcrumb-item active" aria-current="page">Create User</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form method="post" class="card" action="createuserAction" method="post" onsubmit="return validate()" id="form1">
              <div class="card-header">
                <h3 class="card-title">Create User</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">User ID <span id="msg" style="color:red;float:right"></span></label>
                      <input type="text" id="userId" name="userId" class="form-control" autofocus="autofocus" autocomplete="off" required>
                    </div>
                    <div class="form-group">
                      <label class="form-label">First Name</label>
                      <input type="text" id="first_name" name="first_name" class="form-control" required autocomplete="off">
                    </div>
                    <div class="form-group">
                      <label class="form-label">Last Name</label>
                       <input type=	"text" id="last_name" name="last_name" class="form-control" required autocomplete="off">
                    </div>
                    <div class="form-group">
                      <label class="form-label">Password</label>
                     <input type="text" name="password" id="password" class="form-control" required autocomplete="off">
                    </div>
                    <div class="form-group">
                      <label class="form-label">Confirm Password</label>
                      <input type="text" name="c_password" id="c_password" class="form-control" required autocomplete="off">
                    </div>
                    
                   
                    
                  </div>
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Admin Rights</label>
                    <input type="radio" name="admin_rights" value="Y" checked="checked"> yes</input>
                    <input type="radio" name="admin_rights" value="N" checked="checked" style="margin-left:15PX;"> No</input>
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">CCI Rights</label>
                    <input type="radio" name="cci_rights" value="Y" checked="checked"> yes</input>
                    <input type="radio" name="cci_rights" value="N" checked="checked" style="margin-left:15PX;"> No</input>
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">CMS Rights</label>
                    <input type="radio" name="cms_rights" value="y" checked="checked"> yes</input>
                    <input type="radio" name="cms_rights" value="N" checked="checked" style="margin-left:15PX;"> No</input>
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">MIS Rights</label>
                    <input type="radio" name="mis_rights" value="y" checked="checked"> yes</input>
                    <input type="radio" name="mis_rights" value="N" checked="checked" style="margin-left:15PX;"> No</input>
                    
                    </div>
                    
				 <div class=" mt-2 mb-0">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="submit" class="btn btn-danger" onclick="resetvalue()">Cancel</button>
                 </div>
                  
                  
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
           
        
      </div>
      <!--Sidebar-right-->
      
      <!--/Sidebar-right-->
      
      <jsp:include page="footer.jsp" ></jsp:include>
     <!-- Template end here-->
      
  </div>
</div>
</div>

<input type="hidden" id="res"/>
<input type="hidden" id="snackbar" value="${msg}"/>
<script src="resources/js/jquery-3.2.1.min.js"></script>

<script src="resources/js/popper.min.js"></script>

<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/sidemenu.js"></script>
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
<script type="text/javascript">
function resetvalue()
{
	$('#form1').find('input:text').val('');
	event.preventDefault();
}
</script>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#userId").change(function(){
		var userid = $("#userId").val();
		
		$.ajax({
			
			url:"getUserId",
			dataType: 'json',
			data : 'userId=' + userid,
			method:"GET",
			success: function(ni)
			{
				if (ni == 0)
					{
						$('#msg').text("User Id already Exists");
						$('#res').val("User Id already Exists");
					}
				else
					{
						$('#res').val("not exists");
					}
			},
			
			error : function() { 
				alert("Error");
			}
			
		});
		
			});
});

function validate()
{
	var pass = document.getElementById("password").value;
	var conf_pass = document.getElementById("c_password").value;
	var resp = document.getElementById("res").value;
	
	if(pass===conf_pass)
		{
		if(resp == "not exists")
			{
				return true;
			}
		
		else
			{
			return false;
			}
		
		}
	else
		{
			$("#snackbar").val("password dosen't match");
			
			var y= document.getElementById("snackbar").value;
			
			bootbox.alert({
			message: y, 
			callback: function(){}
			});
		}
	
	return false;
}
</script>

</body>
</html>