<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>bulk Update</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/navmenu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/data_table/jquery.dataTables.min.css" type="text/css" />

<link href="${pageContext.request.contextPath}/resources/css/jquery-confirm.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/component.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-confirm.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/data_tables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/dataTables.buttons.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jszip.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/pdfmake.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/vfs_fonts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/buttons.html5.min.js" type="text/javascript"></script>


<style>
    .form-horizontal .form-group {
    margin-right: 0px;
    margin-left: -15px;
}

.dataTables_wrapper{
padding: 0px 25px 0px 25px;
margin-bottom:14px;
}

.dataTables_length{
padding: 0px 25px 0px 0px;
margin-bottom:14px;
}
</style>

</head>


<body>
	<c:choose>
	 <c:when test="${loginObj.role eq 'admin'}">
			<jsp:include page="admin_header.jsp"/>
		</c:when>
		<c:otherwise>
		<jsp:include page="user_header.jsp"/>
		</c:otherwise>
		</c:choose>

<div class="wrapper2" style="padding-top:20px;">


<div>
<form action="bulkupdate" method="post" style="margin-top:4%;">
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">
Select Zones:</div>
<div class="fright2"><select class="inpt"  id="zone_option" name="zone_option" autocomplete="off" required="required">
       <option value="" disabled selected>Select Zone</option>
       <option value="All">All</option>
    	<option value="East">East</option>
    	<option value="West">West</option>
    	<option value="North">North</option>
    	<option value="South">South</option>
    	</select>
    	</div>
</div>
</div>
</div>


<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Select Bulk Operation:</div>
<div class="fright2"><select class="inpt" id="bulk_option" name="bulk_option" autocomplete="off" required="">
              <option value="" disabled selected>Select Opertion</option>
       <option value="Login">Login</option>
    	<option value="Logout">Logout</option>
    	<option value="FLogout">FLogout</option>
    	<option value="Delete">Delete</option>
    	<option value="Change Call Limit">Change Call Limit</option>
    	</select>
    </div>
</div>
</div>
</div>


<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Enter ChatId Comma Separated:</div>
<div class="fright2"><input type="text"  id="bulk_chatid" name="bulk_chatid"  class="inpt" placeholder="Enter ChatID" autocomplete="off" required></div>
</div>
</div>
</div>


<div class="row" id="callLimit">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Call Limit:</div>
<div class="fright2"><input type="text"  id="call_limit" name="call_limit" class="inpt" autocomplete="off" placeholder="Enter Call Limit"></div>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">&nbsp;</div>
<div class="fright2"><button type="submit" class="btn btn-success btn-primary" style="margin-top:4px; width:130px !important;">Submit</button></div>
</div>
</div>
</div>
												
</form>


</div>


</div>

<input type="hidden" id="snackbar" value="${insert_succ}">

<script type="text/javascript">

$(document).ready(function(){
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x,
		size: 'small'
		});
});
</script>

<script>	  
	$(document).ready(function(){
		
		$('#callLimit').hide();
		
$('#bulk_option').change(function(){
			
			$('#callLimit').hide();
			if($('#bulk_option').val()==='Change Call Limit')
				{
				
				$('#callLimit').show();
				}
		
		})
});
	</script>






<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
</body>
</html>
