<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>ZamtelBeatz User Details</title>

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
            <h4 class="page-title">User Details</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Zamtel Beats</li>
              <li class="breadcrumb-item active" aria-current="page">Check User Details</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="zemtalBeatsDetailsAction" method="post" onsubmit="return validate();">
              <div class="card-header">
                <h3 class="card-title">Check User Details</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Mobile Number<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <input type="text" class="form-control" name="ani" id="ani" required autocomplete="off">
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
        
        
	<c:if test="${tableExist eq 'yes'}">
      <p style="text-align:center;font-size:16px;font-weight:bold;">User Music Details</p>
        <div class="card">
          <div class="card-body">
          
            
      <table id="unsub" class="display nowrap" style="width:100%">
                <thead>
                  <tr style="text-align: center;">
                    <th>Mobile Number</th>
                  	<th>Package Id</th>
                    <th>Package Name</th>
                    <th>Package Price</th>
                    <th>Status</th>
                    <th>Package Sub Date</th>
                    <th>Package Billing Date</th>
                    <th>Package Renew Date</th>
                    </tr>
                </thead>
                <tbody>
                	
                <tr style="text-align: center;">
                	<td>${data.musicBean.msisdn}</td>
                	<td>${data.musicBean.packageId}</td>
					<td>${data.musicBean.packageName}</td>
					<td>${data.musicBean.packagePrice}</td>
                	<td>${data.musicBean.status}</td>
                	<td>${data.musicBean.packageSubDate}</td>
                	<td>${data.musicBean.packageRenewDate}</td>
                	<td>${data.musicBean.packageBillingDate}</td>
                  </tr>
                </tbody>
              </table>
              
              </div>
              </div>
              </c:if>
              
              
              
       <c:if test="${tableExist eq 'yes'}">
      <p style="text-align:center;font-size:16px;font-weight:bold;">User Karaoke Details</p>
        <div class="card">
          <div class="card-body">
          
            
      <table id="karaoke" class="display nowrap" style="width:100%">
                <thead>
                  <tr style="text-align: center;">
                    <th>Mobile Number</th>
                  	<th>Package Id</th>
                    <th>Package Name</th>
                    <th>Package Price</th>
                    <th>Status</th>
                    <th>Package Sub Date</th>
                    <th>Package Billing Date</th>
                    <th>Package Renew Date</th>
                    </tr>
                </thead>
                <tbody>
                	
                <tr style="text-align: center;">
                	<td>${data.karaokeBean.msisdn}</td>
                	<td>${data.karaokeBean.packageId}</td>
					<td>${data.karaokeBean.packageName}</td>
					<td>${data.karaokeBean.packagePrice}</td>
                	<td>${data.karaokeBean.status}</td>
                	<td>${data.karaokeBean.packageSubDate}</td>
                	<td>${data.karaokeBean.packageRenewDate}</td>
                	<td>${data.karaokeBean.packageBillingDate}</td>
                  </tr>
                </tbody>
              </table>
              
              </div>
              </div>
              </c:if>
              
              
	<c:if test="${tableExist eq 'yes'}">
      <p style="text-align:center;font-size:16px;font-weight:bold;">User Bundle Details</p>
        <div class="card">
          <div class="card-body">
          
            
      <table id="bundle" class="display nowrap" style="width:100%">
                <thead>
                  <tr style="text-align: center;">
                    <th>Mobile Number</th>
                  	<th>Package Id</th>
                    <th>Package Name</th>
                    <th>Package Price</th>
                    <th>Status</th>
                    <th>Package Sub Date</th>
                    <th>Package Billing Date</th>
                    <th>Package Renew Date</th>
                    </tr>
                </thead>
                <tbody>
                	
                <tr style="text-align: center;">
                	<td>${data.bundleBean.msisdn}</td>
                	<td>${data.bundleBean.packageId}</td>
					<td>${data.bundleBean.packageName}</td>
					<td>${data.bundleBean.packagePrice}</td>
                	<td>${data.bundleBean.status}</td>
                	<td>${data.bundleBean.packageSubDate}</td>
                	<td>${data.bundleBean.packageRenewDate}</td>
                	<td>${data.bundleBean.packageBillingDate}</td>
                  </tr>
                </tbody>
              </table>
              
              </div>
              </div>
              </c:if>
        
     
        
        
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

<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-confirm.js"></script>
<script type="text/javascript" src="resources/js/toastr.min.js"></script>
<link href="resources/css/toastr.min.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
$(document).ready(function() {

    $('#unsub').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
    
    $('#bundle').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
    
    $('#karaoke').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
    
} );
</script>
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
function validate()
{
	var pattern= /^[0-9]+$/;
	
	if(!pattern.test($('#ani').val()))
	{
		toastr.error("Please Insert only Digits");
		$('#ani').focus();
		return false;
	}
	
	else if($('#ani').val().length != 9)
		{
			toastr.error("Number length should be 9");
			$('#ani').focus();
			return false;
		}
	}

</script>
<script>
{
	var res = "${success}";
	if(res.length !== 0)
		{
			toastr.info(res);
		}
}
</script>
<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function viewCurStatusRecord()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/neXtVoiceDetailsActionDetail?ani=${mobile}&status=${status}";
	
}
</script>
</body>
</html>