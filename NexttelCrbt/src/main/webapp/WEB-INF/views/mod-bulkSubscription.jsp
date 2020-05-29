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
            <h4 class="page-title">Subscription </h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">neXtMusic</li>
              <li class="breadcrumb-item active" aria-current="page">Bulk Subscription</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form action="mod_BulkSubscriptionAction" method="post" enctype="multipart/form-data" onsubmit="return validate()">
              <div class="card-header">
                <h3 class="card-title">Bulk Subscription</h3>
              </div>
              <div class="card-body">
                <div class="row">
					<div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label style="width:70%;">Bulk File<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <input type="file" name="ani" id="ani" class="form-control" accept=".txt" required="required">
                      <span class="font-13 text-muted"></span>
                       <span style="color:red;font-weight:bold;font-size:11px;">please upload .txt file</span>
                    </div>
                     
                  </div>
                  
				<div class="col-md-6 col-lg-6">
					<div class="form-group">
					<label style="width:70%;">Select Price Point<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <select class="form-control" id="pricePoint" name="pricePoint" required="required">
                      <option value="-1">Select Price Point</option>
                      <option value="MR_SUB1">Monthly</option>
                      <option value="MR_SUB2">Weekly</option>
                      <option value="MR_SUB3">Daily</option>
                      </select>
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
	
	if($('#pricePoint').val() == '-1')
	{
		alert("Please Select Price Point");
		$('#pricePoint').focus();
		return false;
	}

else
	{
		return true;
	}
}
</script>
</body>
</html>