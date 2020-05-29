<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <h4 class="page-title">User Details</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">neXtMusic</li>
              <li class="breadcrumb-item active" aria-current="page">Check User Details</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="userDetailsAction" method="post" onsubmit="return validate();">
              <div class="card-header">
                <h3 class="card-title">Check User Details</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Mobile Number</label>
                      <input type="text" class="form-control" name="ani" id="ani" required autocomplete="off">
                    </div>
                     
                  </div>
                  
                  <div class="col-md-6 col-lg-6">
					<div class="form-group">
                      <label class="form-label">Detail Type</label>
                      <select name="detail_type" id="detail_type" class="form-control" required="required">
                      <option selected="selected" value="-1">Select Option</option>
                      <option value="subscription">Subscription</option>
                      <option value="un-subscription">Un-Subscription</option>
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
        
        
        
        <div class="row" style="padding-left:10px;padding-right:10px;">
      <div class="col-lg-12">
      
      
      <c:if test="${fn:length(subdata) gt 0}">
      <p style="text-align:center;font-size:16px;font-weight:bold;">User Details-Subscription</p>
        <div class="card">
          <div class="card-body">
          
          
          
            
      <table id="sub" class="display nowrap" style="width:100%">
                <thead>
                  <tr style="text-align: center;">
                  	<th>Mobile Number</th>
                    <th>Language</th>
                    <th>Status</th>
                    <th>Subscription Date</th>
                    <th>Renew Date</th>
                    <th>Billing Date</th>
                    <th>Pack</th>
                    <th>Amount</th>
                    <th>Activation Source</th>
                  </tr>
                </thead>
                <tbody>
                	
               <c:forEach var="open" items="${subdata}">                
                <tr style="text-align: center;">
                	<td>${open.MOBILE_NUMBER}</td>
					<td>${open.LANGUAGE}</td>
					<td>${open.STATUS}</td>
                	<td>${open.SUB_DATE}</td>
                	<td>${open.RENEW_DATE}</td>
                	<td>${open.BILLING_DATE}</td>
                	<td>${open.PACK_TYPE}</td>
                	<td>${open.AMOUNT}</td>
                	<td>${open.ACT_SOURCE}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
              
              </div>
              </div>
              </c:if>
              <div>
              
              
              </div>
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
<script type="text/javascript">
function validate()
{
	var pattern= /^[0-9]+$/;
	
	if(!pattern.test($('#ani').val()))
	{
		alert("Please Insert only Digits");
		$('#ani').focus();
		return false;
	}
	
	else if($('#ani').val().length != 9)
		{
			alert("Number length should be 9");
			$('#ani').focus();
			return false;
		}
	else if($('#detail_type').val() == '-1')
		{
			alert("Please Select Detail Type");
			$('#detail_type').focus();
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