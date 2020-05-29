<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-UserDetails</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/component.css">

<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>

<script type="text/javascript">
function validateForm() {
    var x = "";
    var data=document.getElementById("ani").value;
	    if(isNaN(data)){
	    	alert("Please enter the numeric");
	    	return false;
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
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="x_content">
								<h4 class="page-title" align="center"><mark> CCI User Details </mark></h4>
								<table id="datatable" class="table table-striped table-bordered"  style="width:100%;">
										<thead>
											<tr>										
												<th>User Name</th>
												<th>Password</th>
												<th>Full Name</th>
												<th>Role</th>
												<th>Description</th>
												<th>Create Date</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>	
											<c:forEach var="listValue" items="${response}">
												<tr>
													<td>${listValue.userName} </td>
													<td>${listValue.password} </td>
													<td>${listValue.fullName} </td>
													<td>${listValue.role} </td>
													<td>${listValue.description} </td>
													<td>${fn:substring(listValue.insertDate,0,19)}</td>
													<td>${listValue.status} </td>
												</tr>
											</c:forEach>		
										</tbody> 	
								</table>
								<input type="hidden" id="snackbar" value="${objRes}">
							</div>
						
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/custom-file-input.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>
	
	<script src="resources/js/dataTables.bootstrap.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	
	<script src="resources/js/jquery.form-advanced.init.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	
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
	<script>
		$(document).ready(function() {
		    $('#datatable').DataTable( {
		        /* "scrollX": true */
		    	"bPaginate": true,
		        "bLengthChange": false,
		        "bFilter": true,
		        "bInfo": true,
		        "scrollY": 200,
		        "scrollX": true 
		        
		    } );
		} );
	</script>
</body>
</html>