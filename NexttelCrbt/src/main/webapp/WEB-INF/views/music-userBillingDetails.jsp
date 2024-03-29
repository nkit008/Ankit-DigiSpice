<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h4 class="page-title">Check Details</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">neXtVoice</li>
              <li class="breadcrumb-item active" aria-current="page">Billing Details</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="neXtVoiceUserBillingDetailsAction" method="post" onsubmit="return validate();">
              <div class="card-header">
                <h3 class="card-title">Billing Details</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Mobile Number<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <input type="text" class="form-control" name="ani" id="ani" required autocomplete="off" />
                      <span style="color:red;font-weight:bold;font-size:11px;">Enter Mobile Number with Country Code - 237</span>
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
      
              <div class="row" style="padding-left:10px;padding-right:10px;">
      <div class="col-lg-12">
 
      
      <c:if test="${fn:length(data) gt 0}">
      <p style="text-align:center;font-size:16px;font-weight:bold;">User Billing Details</p>
        <div class="card">
          <div class="card-body">
                    <div class="row">
              <div class="table-responsive">
              <table id="sub" class="display nowrap" style="width:100%">
                <thead>
                  <tr>
                  	<th>Mobile Number</th>
                    <th>Subscription Date</th>
                    <th>Renew Date</th>
                    <th>Billing Date</th>
                    <th>Pack Type</th>
                    <th>Activation Source</th>
                    <th>Validity(In Days)</th>
                    <th>Amount(In USD)</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="open" items="${data}">
                <tr style="text-align: center;">
                	<td>${open.ANI}</td>
                	<td>${open.SUB_DATE}</td>
                	<td>${open.RENEW_DATE}</td>
                	<td>${open.BILLING_DATE}</td>
                	<td>${open.PACK_TYPE}</td>
                	<td>${open.ACT_SOURCE}</td>
                	<td>${open.VALIDITY}</td>
                	<td>${open.AMT_DEDUCTED}</td>
                  </tr>
                  </c:forEach>
                  </tbody>
              </table>
                
              </div>
      
	</div>
	</div>
	</div>
	</c:if>
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

<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-confirm.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#sub').DataTable( {
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

<script>
function validate()
{
	var pattern= /^[0-9]+$/;
		
		if(!pattern.test($('#ani').val()))
		{
			alert("Please Insert only Digits");
			$('#ani').focus();
			return false;
		}
		
		else if($('#ani').val().length != 12)
			{
				alert("Number length should be 12");
				$('#ani').focus();
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