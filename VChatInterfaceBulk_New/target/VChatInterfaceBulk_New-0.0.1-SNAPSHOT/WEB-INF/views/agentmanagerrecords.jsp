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
		
			<div class="row"></div>	
		</div>
	</div>
	<!-- end page-wrapper -->
    
    
    <div class="" style="width:100%;">
					<div class="">
						<div class="card bgcrd">
							<div class="card-body">
								<div class="x_content">
									<!-- <h4 class="page-title" align="center"><mark> Agent Records </mark></h4> -->
									<!-- <table id="datatable" class="table table-striped table-bordered"  style="width:100%;"> -->
									<table id="datatable" class="display  dtb"  style="width:100%;">
											<thead>
												<tr class="trb">										
													<!-- <th>Operator</th> -->
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
													<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
														<th>AgentDocImage</th>
														<th>PartnerCertImage</th>
													</c:if>	
													<th>#</th>
												</tr>
											</thead>
											 <tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>
														<!-- <td>Vodafone </td> -->
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
														<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
															<td><a href="userDoc/${listValue.userDocPath}" target="_blank"> ${listValue.userDocPath} </a></td>
															<td><a href="venderCert/${listValue.certificatePath}" target="_blank"> ${listValue.certificatePath} </a></td>
														</c:if>
														<td>
														    <button type="button" class="btn btn-warning btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}'">Update</button>
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
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false
		    });
		} );
	</script>
</body>
</html>