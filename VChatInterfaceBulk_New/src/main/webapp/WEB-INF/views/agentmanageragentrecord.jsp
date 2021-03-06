<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentManagerRecords</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">
<link rel="stylesheet" type="text/css" href="resources/css/buttons.dataTables.min.css">



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
			<div class="row">
				<div class="col-sm-12">
					<div class="page-title-box">
						<h4 class="page-title">Agent Records</h4>
					</div>
				</div>
		    </div>
		</div>
	</div>	
	<div class="" style="width:100%">
				<div class="">
						<div class="card bgcrd">
							<div class="card-body">
								<div class="x_content">
									<!-- <h4 class="page-title" align="center"><mark> Agent Records </mark></h4> -->
									<!-- <table id="datatable" class="table table-striped table-bordered"  style="width:100%;"> -->
									<table id="datatable" class="display dtb"  style="width:100%;text-align:center;	">
											<thead>
												<tr class="trb">										
													<th>Partner Name</th>
													<th>Mobile No</th>
													<th>Chat Id</th>
													<th>Agent Name</th>
													<th>Age</th>
													<th>Languages</th>
													<th>Type</th>
													<th>Allocated Circle</th>
													<th>Location</th>
													<th>Agent Document</th>
													<th>Document Number</th>
													<!-- <th>#</th> -->
												</tr>
											</thead>
											 <tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>
														<td>${listValue.centerName} </td>
														<td>${listValue.bAni} </td>
														<td>${listValue.bChatid} </td>
														<td>${listValue.agentName} </td>
														<td>${listValue.agentAge} </td>
														<td>${listValue.agentLang} </td>
														<td>${listValue.agentCategory} </td>
														<td>${listValue.bCircle} </td>
														<td>${listValue.agentCircle} </td>
														<td>${listValue.userDoc} </td>
														<td>${listValue.userDocNo} </td>
														<%-- <td>
														    <button type="button" class="btn btn-warning btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}'">Update</button>
														</td> --%>
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
			
		
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/dataTables.buttons.min.js" type="text/javascript"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>

	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/form-advanced.init.js"></script>
	
	<script src="resources/js/vfs_fonts.js"></script>
	<script src="resources/js/jszip.min.js"></script>
	<script src="resources/js/buttons.html5.min.js"></script>

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
		    	dom: 'lBfrtip',
		        buttons: [
		        	'excelHtml5',
		        ],
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false
		    } );
		} );
	</script>
</body>
</html>