<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/component.css">
 -->
 
 <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous"> -->

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<!-- <link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"> -->
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">
 


<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>


</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class=""row">
				<div class="col-sm-12">
					<div class="page-title-box">
						<!-- <div class="float-right">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
								<li class="breadcrumb-item"><a href="javascript:void(0);">home</a></li>
								<li class="breadcrumb-item active">Open Complains</li>
							</ol>
						</div> -->
						<h4 class="page-title">Agent Records</h4>
					</div>
				</div>
		    </div>
		
			<div class=""row">
				<div class="container" align="center">
					<div class="col-md-12">
						<div class="card">
							<div class="card-body">
								<div class="x_content">
									<!-- <h4 class="page-title" align="center"><mark> Agent Records </mark></h4> -->
									<!-- <table id="datatable" class="table table-striped table-bordered"  style="width:100%;"> -->
									<table id="datatable" class="display nowrap"  style="width:100%;">
											<thead>
												<tr>										
													<th>Operator</th>
													<th>Partner Name</th>
													<th>Mobile No</th>
													<th>Chat Id</th>
													<th>Agent Name</th>
													<th>Age</th>
													<th>Languages</th>
													<th>Type</th>
													<th>Allocated Circle</th>
													<th>Location</th>
													<th>State</th>
													<th>Agent Document</th>
													<th>Document Number</th>
													<th>#</th>
												</tr>
											</thead>
											 <tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>
														<td>Vodafone </td>
														<td>${listValue.partnerName} </td>
														<td>${listValue.mobileNo} </td>
														<td>${listValue.chatId} </td>
														<td>${listValue.agentName} </td>
														<td>${listValue.agentAge} </td>
														<td>${listValue.agentLang} </td>
														<td>${listValue.agentType} </td>
														<td>${listValue.circle} </td>
														<td>${listValue.location} </td>
														<td>${listValue.state} </td>
														<td>${listValue.userDoc} </td>
														<td>${listValue.userDocNo} </td>
														<td>
														    <button type="button" class="btn btn-info btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}'">Update</button>
														    <%-- <button type="button" class="btn btn-info btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}'">Update</button> --%>
														    <%-- <input class="button" type="submit" value="'${listValue.mobileNo}'" name="developer"></input> --%>   
														</td>
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
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	
 
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>

	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/form-advanced.init.js"></script>
	
	
	<!-- <script src="resources/js/dataTables.bootstrap.min.js"></script> -->
	<!-- <script src="resources/js/jquery.form-advanced.init.js"></script> -->
	<!-- <script src="resources/js/custom-file-input.js"></script> -->
	
	
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
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false
		    	
		    	
		    	
 			   /*  	"bPaginate": true,
		        "bLengthChange": false,
		        "bFilter": true,
		        "bInfo": true,
		       
		        "scrollX": true  */
		        
		    } );
		} );
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